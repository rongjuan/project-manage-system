package cc.xuepeng.entity;

import cn.yesway.framework.common.entity.base.BaseEntity;
import java.io.Serializable;

/**
 * RoleMenuRelation的实体类。
 * 由Code Generator生成。
 *
 * @author Code Generator
 */
public class RoleMenuRelation extends BaseEntity implements Serializable {

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
     * @return 获取菜单主键。
     */
    public String getMenuId() {
        return this.menuId;
    }

    /**
     * 设置菜单主键。
     *
     * @param menuId 菜单主键。
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }


    /**
     * 角色主键。
     */
    private String roleId = "";
    /**
     * 菜单主键。
     */
    private String menuId = "";

}