package cc.xuepeng.service.user;

import cc.xuepeng.consts.JWTConst;
import cc.xuepeng.dao.RoleUserRelationDao;
import cc.xuepeng.dao.UserDao;
import cc.xuepeng.entity.*;
import cc.xuepeng.enums.UserStatus;
import cc.xuepeng.exception.UserAuthenticationException;
import cc.xuepeng.service.menu.MenuService;
import cc.xuepeng.service.role.RoleService;
import cc.xuepeng.service.user.formatter.UserMenuFormatter;
import cn.yesway.framework.common.util.JWTUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
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
                .andSecretEqualTo(secret)
                .andStatusEqualTo((byte) UserStatus.AVAILABLE.ordinal()) // 启用的账号
                .andDeletedEqualTo(Boolean.FALSE); // 为删除的账号
        User user = userDao.selectOneByCondition(condition);
        if (Objects.isNull(user)) {
            throw new UserAuthenticationException("用户认证失败。");
        }
        // 创建JWT
        return JWTUtil.create(user.getId(), JWTConst.SECRET);
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
        String userId = JWTUtil.get(token, JWTConst.SECRET);
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
        return userMenuFormatter.format(menus);
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
     * 设置用户菜单格式化接口。
     *
     * @param userMenuFormatter 用户菜单格式化接口。
     */
    @Autowired
    public void setUserMenuFormatter(UserMenuFormatter userMenuFormatter) {
        this.userMenuFormatter = userMenuFormatter;
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
     * 用户菜单格式化接口。
     */
    private UserMenuFormatter userMenuFormatter;

}
