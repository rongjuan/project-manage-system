package cc.xuepeng.service.role;

import cc.xuepeng.dao.RoleMenuRelationDao;
import cc.xuepeng.entity.RoleMenuRelation;
import cc.xuepeng.entity.RoleMenuRelationCondition;
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
     * 根据主键查询该角色用户的菜单的主键。
     *
     * @param ids 角色主键。
     * @return 菜单信息。
     */
    @Override
    public List<String> findMenuIdsByIds(List<String> ids) {
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
     * 设置角色菜单关系持久化接口。
     *
     * @param roleMenuRelationDao 角色菜单关系持久化接口。
     */
    @Autowired
    public void setRoleMenuRelationDao(RoleMenuRelationDao roleMenuRelationDao) {
        this.roleMenuRelationDao = roleMenuRelationDao;
    }

    /**
     * 角色菜单关系持久化接口。
     */
    private RoleMenuRelationDao roleMenuRelationDao;

}
