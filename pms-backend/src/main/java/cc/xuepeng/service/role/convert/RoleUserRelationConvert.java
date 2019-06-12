package cc.xuepeng.service.role.convert;

import cc.xuepeng.entity.Role;
import cc.xuepeng.entity.RoleUserRelation;

import java.util.List;

/**
 * 用户角色关系转换接口。
 *
 * @author xuepeng
 */
public interface RoleUserRelationConvert {

    /**
     * 将Role对象转换为RoleUserRelation对象。
     *
     * @param role 角色信息。
     */
    List<RoleUserRelation> convert(final Role role);

}
