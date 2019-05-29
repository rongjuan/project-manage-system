package cc.xuepeng.entity;

import cn.yesway.framework.common.entity.base.BaseEntity;
import java.io.Serializable;

/**
 * RoleUserRelation的实体类。
 * 由Code Generator生成。
 *
 * @author Code Generator
 */
public class RoleUserRelation extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * @return 获取角色主键。
     */
    public String getRoleId() {
        return this.roleId;
    }

    /**
     * 设置角色主键。
     *
     * @param roleId 角色主键。
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    /**
     * @return 获取用户主键。
     */
    public String getUserId() {
        return this.userId;
    }

    /**
     * 设置用户主键。
     *
     * @param userId 用户主键。
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }


    /**
     * 角色主键。
     */
    private String roleId = "";
    /**
     * 用户主键。
     */
    private String userId = "";

}