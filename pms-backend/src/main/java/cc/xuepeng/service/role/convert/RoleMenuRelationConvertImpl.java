package cc.xuepeng.service.role.convert;

import cc.xuepeng.entity.Role;
import cc.xuepeng.entity.RoleMenuRelation;
import cn.yesway.framework.common.util.PKUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 用户菜单关系转换类。
 *
 * @author xuepeng
 */
@Service("roleMenuRelationConvert")
public class RoleMenuRelationConvertImpl implements RoleMenuRelationConvert {

    /**
     * 将Role对象转换为RoleMenuRelation对象。
     *
     * @param role 角色信息。
     * @return 角色菜单关系信息。
     */
    @Override
    public List<RoleMenuRelation> convert(final Role role) {
        List<RoleMenuRelation> result = new ArrayList<>(role.getMenus().size());
        role.getMenus().forEach(menu -> {
            RoleMenuRelation roleMenuRelation = new RoleMenuRelation();
            roleMenuRelation.setId(PKUtil.getRandomUUID());
            roleMenuRelation.setRoleId(role.getId());
            roleMenuRelation.setMenuId(menu.getId());
            result.add(roleMenuRelation);
        });
        return Collections.unmodifiableList(result);
    }

}
