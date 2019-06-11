package cc.xuepeng.service.role;

import cc.xuepeng.dao.RoleDao;
import cc.xuepeng.dao.RoleMenuRelationDao;
import cc.xuepeng.dao.RoleUserRelationDao;
import cc.xuepeng.entity.*;
import cc.xuepeng.enums.RoleStatus;
import cc.xuepeng.service.user.UserService;
import cn.yesway.framework.common.entity.page.PageParam;
import cn.yesway.framework.common.entity.page.PageResult;
import cn.yesway.framework.common.util.PKUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色管理业务类。
 *
 * @author xuepeng
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    /**
     * 分页查询角色。
     *
     * @return 角色信息。
     */
    @Override
    public PageResult<Role> findByConditionAndPage(final Role role, final PageParam pageParam) {
        RoleCondition condition = new RoleCondition();
        condition.createCriteria()
                .andLicenseIdEqualTo(role.getLicenseId())
                .andStatusEqualTo((byte) RoleStatus.AVAILABLE.ordinal())
                .andDeletedEqualTo(Boolean.FALSE);
        return roleDao.selectByConditionAndPage(condition, pageParam);
    }

    /**
     * 根据主键查询该角色下的用户。
     *
     * @param id 角色主键。
     * @return 用户信息。
     */
    @Override
    public List<User> findUsersById(final String id) {
        RoleUserRelationCondition roleUserRelationCondition = new RoleUserRelationCondition();
        roleUserRelationCondition.createCriteria().andRoleIdEqualTo(id);
        List<RoleUserRelation> roleUserRelations = roleUserRelationDao.selectByCondition(roleUserRelationCondition);
        List<String> userIds = roleUserRelations.stream()
                .map(RoleUserRelation::getUserId)
                .collect(Collectors.toList());
        return userService.findByIds(userIds);
    }

    /**
     * 根据主键查询该角色用户的菜单的主键。
     *
     * @param ids 角色主键。
     * @return 菜单信息。
     */
    @Override
    public List<String> findMenuIdsByIds(final List<String> ids) {
        RoleMenuRelationCondition condition = new RoleMenuRelationCondition();
        condition.createCriteria().andRoleIdIn(ids);
        List<RoleMenuRelation> roleMenuRelations = roleMenuRelationDao.selectByCondition(condition);
        List<String> menuIds = roleMenuRelations.stream()
                .map(RoleMenuRelation::getMenuId)
                .distinct()
                .collect(Collectors.toList());
        return Collections.unmodifiableList(menuIds);
    }

    /**
     * 创建角色。
     *
     * @param role 角色信息。
     * @return 是否创建成功。
     */
    @Override
    public boolean create(final Role role) {
        role.setId(PKUtil.getRandomUUID());
        role.setStatus((byte) RoleStatus.AVAILABLE.ordinal());
        role.setDeleted(Boolean.FALSE);
        return roleDao.insertSelective(role) > 0;
    }

    /**
     * 修改角色。
     *
     * @param role 角色信息。
     * @return 是否修改成功。
     */
    @Override
    public boolean update(final Role role) {
        return roleDao.updateByPrimaryKeySelective(role) > 0;
    }

    /**
     * 删除角色。
     *
     * @param id 主键。
     * @return 是否删除成功。
     */
    @Override
    public boolean delete(final String id) {
        Role role = new Role();
        role.setId(id);
        role.setDeleted(Boolean.TRUE);
        return roleDao.updateByPrimaryKeySelective(role) > 0;
    }

    /**
     * 批量删除角色。
     *
     * @param ids 主键。
     * @return 是否删除成功。
     */
    @Override
    public boolean deleteBatch(final List<String> ids) {
        Role role = new Role();
        role.setDeleted(Boolean.TRUE);
        RoleCondition condition = new RoleCondition();
        condition.createCriteria().andIdIn(ids);
        return roleDao.updateByConditionSelective(role, condition) > 0;
    }

    /**
     * 设置角色管理持久化接口。
     *
     * @param roleDao 角色管理持久化接口。
     */
    @Autowired
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    /**
     * 设置角色菜单关系持久化接口。
     *
     * @param roleMenuRelationDao 角色菜单关系持久化接口。
     */
    @Autowired
    public void setRoleMenuRelationDao(RoleMenuRelationDao roleMenuRelationDao) {
        this.roleMenuRelationDao = roleMenuRelationDao;
    }

    /**
     * 设置角色用户关系持久化接口。
     *
     * @param roleUserRelationDao 角色用户关系持久化接口。
     */
    @Autowired
    public void setRoleUserRelationDao(RoleUserRelationDao roleUserRelationDao) {
        this.roleUserRelationDao = roleUserRelationDao;
    }

    /**
     * 设置用户管理业务接口。
     *
     * @param userService 用户管理业务接口。
     */
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 角色管理持久化接口。
     */
    private RoleDao roleDao;
    /**
     * 角色菜单关系持久化接口。
     */
    private RoleMenuRelationDao roleMenuRelationDao;
    /**
     * 角色用户关系持久化接口。
     */
    private RoleUserRelationDao roleUserRelationDao;
    /**
     * 用户管理服务接口。
     */
    private UserService userService;

}
