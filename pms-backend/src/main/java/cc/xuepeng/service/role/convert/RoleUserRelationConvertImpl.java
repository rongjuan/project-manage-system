package cc.xuepeng.service.role.convert;

import cc.xuepeng.entity.Role;
import cc.xuepeng.entity.RoleUserRelation;
import cn.yesway.framework.common.util.PKUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 用户角色关系转换类。
 *
 * @author xuepeng
 */
@Service("roleUserRelationConvert")
public class RoleUserRelationConvertImpl implements RoleUserRelationConvert {

    /**
     * 将Role对象转换为RoleUserRelation对象。
     *
     * @param role 角色信息。
     * @return 角色用户关系信息。
     */
    @Override
    public List<RoleUserRelation> convert(final Role role) {
        List<RoleUserRelation> result = new ArrayList<>(role.getUsers().size());
        role.getUsers().forEach(user -> {
            RoleUserRelation roleUserRelation = new RoleUserRelation();
            roleUserRelation.setId(PKUtil.getRandomUUID());
            roleUserRelation.setRoleId(role.getId());
            roleUserRelation.setUserId(user.getId());
            result.add(roleUserRelation);
        });
        return Collections.unmodifiableList(result);
    }

}
