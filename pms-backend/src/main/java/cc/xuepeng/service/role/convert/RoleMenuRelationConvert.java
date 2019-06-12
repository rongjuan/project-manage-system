package cc.xuepeng.service.role.convert;

import cc.xuepeng.entity.Role;
import cc.xuepeng.entity.RoleMenuRelation;

import java.util.List;

/**
 * 用户菜单关系转换接口。
 *
 * @author xuepeng
 */
public interface RoleMenuRelationConvert {

    /**
     * 将Role对象转换为RoleMenuRelation对象。
     *
     * @param role 角色信息。
     */
    List<RoleMenuRelation> convert(final Role role);

}
