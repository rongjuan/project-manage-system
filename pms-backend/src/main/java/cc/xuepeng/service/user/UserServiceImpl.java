package cc.xuepeng.service.user;

import cc.xuepeng.consts.JWTConst;
import cc.xuepeng.consts.UserConst;
import cc.xuepeng.dao.RoleUserRelationDao;
import cc.xuepeng.dao.UserDao;
import cc.xuepeng.entity.*;
import cc.xuepeng.enums.UserStatus;
import cc.xuepeng.exception.UserAuthenticationException;
import cc.xuepeng.service.menu.MenuService;
import cc.xuepeng.service.menu.formatter.MenuLevelFormatter;
import cc.xuepeng.service.role.RoleService;
import cc.xuepeng.service.user.secret.SecretGenerateStrategy;
import cn.yesway.framework.common.entity.page.PageParam;
import cn.yesway.framework.common.entity.page.PageResult;
import cn.yesway.framework.common.security.md5.MD5Factory;
import cn.yesway.framework.common.util.JWTUtil;
import cn.yesway.framework.common.util.PKUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 用户管理服务类。
 *
 * @author xuepeng
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    /**
     * 登录。
     *
     * @param account 账号。
     * @param secret  密码。
     * @return 登录成功后返回用户令牌。
     */
    @Override
    public String login(final String account, final String secret) {
        // 查询用户信息
        UserCondition condition = new UserCondition();
        condition.createCriteria()
                .andAccountEqualTo(account)
                .andSecretEqualTo(MD5Factory.getInstance().getMD5().encodeSalt(secret + UserConst.SALT))
                .andStatusEqualTo((byte) UserStatus.AVAILABLE.ordinal()) // 启用的账号
                .andDeletedEqualTo(Boolean.FALSE); // 未删除的账号
        User user = userDao.selectOneByCondition(condition);
        if (Objects.isNull(user)) {
            throw new UserAuthenticationException("用户认证失败。");
        }
        // 创建JWT
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", user.getId());
        claims.put("license", user.getLicenseId());
        return JWTUtil.create(claims, JWTConst.SECRET);
    }

    /**
     * 根据令牌查询用户信息。
     *
     * @param token 用户令牌。
     * @return 用户信息。
     */
    @Override
    public User findUserByToken(final String token) {
        // 获取用户主键
        if (StringUtils.isBlank(token)) {
            throw new NullPointerException("用户令牌（Token）不能为空。");
        }
        String userId = JWTUtil.get(token, JWTConst.SECRET, "id");
        if (StringUtils.isBlank(userId)) {
            throw new NullPointerException("非法的用户令牌。");
        }
        // 查询用户信息。
        User user = findUserById(userId);
        // 查询用户的菜单。
        user.setMenus(findMenusById(userId));
        return user;
    }

    /**
     * 查询用户信息。
     *
     * @param user      查询信息。
     * @param pageParam 分页信息。
     * @return 用户信息。
     */
    @Override
    public PageResult<User> findByConditionAndPage(final User user, final PageParam pageParam) {
        UserCondition condition = new UserCondition();
        condition.createCriteria().andLicenseIdEqualTo(user.getLicenseId())
                .andAccountLikeOnBoth(user.getAccount())
                .andNameLikeOnBoth(user.getName())
                .andPhoneLikeOnBoth(user.getPhone())
                .andEmailLikeOnBoth(user.getEmail())
                .andStatusEqualTo((byte) UserStatus.AVAILABLE.ordinal())
                .andDeletedEqualTo(Boolean.FALSE);
        return userDao.selectByConditionAndPage(condition, pageParam);
    }

    /**
     * 根据许可证查询用户信息。
     *
     * @param license 许可证。
     * @return 用户信息。
     */
    @Override
    public List<User> findByLicense(final String license) {
        UserCondition condition = new UserCondition();
        condition.createCriteria()
                .andLicenseIdEqualTo(license)
                .andStatusEqualTo((byte) UserStatus.AVAILABLE.ordinal())
                .andDeletedEqualTo(Boolean.FALSE);
        return userDao.selectByCondition(condition);
    }

    /**
     * 根据主键查询用户。
     *
     * @param ids 主键。
     * @return 用户信息。
     */
    public List<User> findByIds(final List<String> ids) {
        UserCondition condition = new UserCondition();
        condition.createCriteria()
                .andStatusEqualTo((byte) UserStatus.AVAILABLE.ordinal())
                .andDeletedEqualTo(Boolean.FALSE)
                .andIdIn(ids);
        return userDao.selectByCondition(condition);
    }

    /**
     * 创建用户。
     *
     * @param user 用户信息。
     * @return 是否创建成功。
     */
    @Override
    public boolean create(final User user) {
        user.setId(PKUtil.getRandomUUID());
        user.setSecret(secretMD5Strategy.generate(UserConst.SECRET));
        user.setStatus((byte) UserStatus.AVAILABLE.ordinal());
        user.setDeleted(Boolean.FALSE);
        return userDao.insertSelective(user) > 0;
    }

    /**
     * 修改用户
     *
     * @param user 用户信息。
     * @return 是否修改成功。
     */
    @Override
    public boolean update(final User user) {
        return userDao.updateByPrimaryKeySelective(user) > 0;
    }

    /**
     * 删除用户。
     *
     * @param id 用户主键。
     * @return 是否删除成功。
     */
    @Override
    public boolean delete(final String id) {
        User user = new User();
        user.setId(id);
        user.setDeleted(Boolean.TRUE);
        return userDao.updateByPrimaryKeySelective(user) > 0;
    }

    /**
     * 删除用户。
     *
     * @param ids 用户主键。
     * @return 是否删除成功。
     */
    @Override
    public boolean deleteBatch(final List<String> ids) {
        User user = new User();
        user.setDeleted(Boolean.TRUE);
        UserCondition condition = new UserCondition();
        condition.createCriteria().andIdIn(ids);
        return userDao.updateByConditionSelective(user, condition) > 0;
    }

    /**
     * 判断账号是否存在。
     * 存在：True，不存在：False；
     *
     * @param account 账号。
     * @return 是否存在。
     */
    @Override
    public boolean existed(final String account) {
        UserCondition condition = new UserCondition();
        condition.createCriteria().andAccountEqualTo(account);
        return userDao.countByCondition(condition) > 0;
    }

    /**
     * 根据主键查询用户信息。
     *
     * @param id 主键。
     * @return 用户信息。
     */
    private User findUserById(final String id) {
        return userDao.selectByPrimaryKey(id);
    }

    /**
     * 根据主键查询用户可访问的菜单。
     *
     * @param id 主键。
     * @return 菜单信息。
     */
    private List<Menu> findMenusById(final String id) {
        // TODO 做一个null的判断
        List<String> roleIds = findRoleIdsById(id);
        List<String> menuIds = roleService.findMenuIdsByIds(roleIds);
        List<Menu> menus = menuService.findByIds(menuIds);
        return menuLevelFormatter.format(menus);
    }

    /**
     * 根据用户主键查询该用户的角色的主键。
     *
     * @param id 主键。
     * @return 角色主键。
     */
    private List<String> findRoleIdsById(final String id) {
        RoleUserRelationCondition condition = new RoleUserRelationCondition();
        condition.createCriteria().andUserIdEqualTo(id);
        List<RoleUserRelation> roleUserRelations = roleUserRelationDao.selectByCondition(condition);
        List<String> roleIds = roleUserRelations.stream()
                .map(RoleUserRelation::getRoleId)
                .distinct()
                .collect(Collectors.toList());
        return Collections.unmodifiableList(roleIds);
    }

    /**
     * 用户持久化接口。
     *
     * @param userDao 用户持久化接口。
     */
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 设置角色用户关系持久化接口。
     *
     * @param roleUserRelationDao 设置角色用户关系持久化接口。
     */
    @Autowired
    public void setRoleUserRelationDao(RoleUserRelationDao roleUserRelationDao) {
        this.roleUserRelationDao = roleUserRelationDao;
    }

    /**
     * 设置角色管理业务接口。
     *
     * @param roleService 角色管理业务接口。
     */
    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * 菜单管理业务接口。
     *
     * @param menuService 菜单管理业务接口。
     */
    @Autowired
    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }

    /**
     * 设置菜单层级格式化接口。
     *
     * @param menuLevelFormatter 菜单层级格式化接口。
     */
    @Autowired
    public void setMenuLevelFormatter(MenuLevelFormatter menuLevelFormatter) {
        this.menuLevelFormatter = menuLevelFormatter;
    }

    /**
     * 设置密码生成策略。
     *
     * @param secretMD5Strategy 密码生成策略。
     */
    @Autowired
    public void setSecretMD5Strategy(SecretGenerateStrategy secretMD5Strategy) {
        this.secretMD5Strategy = secretMD5Strategy;
    }

    /**
     * 用户持久化接口。
     */
    private UserDao userDao;
    /**
     * 角色用户关系持久化接口。
     */
    private RoleUserRelationDao roleUserRelationDao;
    /**
     * 角色管理业务接口。
     */
    private RoleService roleService;
    /**
     * 菜单管理业务接口。
     */
    private MenuService menuService;
    /**
     * 菜单层级格式化接口。
     */
    private MenuLevelFormatter menuLevelFormatter;
    /**
     * 密码生成策略。
     */
    private SecretGenerateStrategy secretMD5Strategy;

}
