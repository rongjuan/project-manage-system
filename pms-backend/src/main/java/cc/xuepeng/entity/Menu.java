package cc.xuepeng.entity;

import cn.yesway.framework.common.entity.base.BaseEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Menu的实体类。
 * 由Code Generator生成。
 *
 * @author Code Generator
 */
public class Menu extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * @return 获取父级主键。
     */
    public String getPid() {
        return this.pid;
    }

    /**
     * 设置父级主键。
     *
     * @param pid 父级主键。
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     * @return 获取标题。
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * 设置标题。
     *
     * @param title 标题。
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return 获取图标。
     */
    public String getIcon() {
        return this.icon;
    }

    /**
     * 设置图标。
     *
     * @param icon 图标。
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * @return 获取路径。
     */
    public String getPath() {
        return this.path;
    }

    /**
     * 设置路径。
     *
     * @param path 路径。
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return 获取排序。
     */
    public Short getSort() {
        return this.sort;
    }

    /**
     * 设置排序。
     *
     * @param sort 排序。
     */
    public void setSort(Short sort) {
        this.sort = sort;
    }

    /**
     * @return 获取是否删除。
     */
    public Boolean getDeleted() {
        return this.deleted;
    }

    /**
     * 设置是否删除。
     *
     * @param deleted 是否删除。
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * @return 获取备注。
     */
    public String getRemark() {
        return this.remark;
    }

    /**
     * 设置备注。
     *
     * @param remark 备注。
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return 获取创建人。
     */
    public String getCreateUser() {
        return this.createUser;
    }

    /**
     * 设置创建人。
     *
     * @param createUser 创建人。
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * @return 获取修改人。
     */
    public String getModifyUser() {
        return this.modifyUser;
    }

    /**
     * 设置修改人。
     *
     * @param modifyUser 修改人。
     */
    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    /**
     * @return 获取创建时间。
     */
    public java.util.Date getCreateTime() {
        return this.createTime == null ? null : (java.util.Date) this.createTime.clone();
    }

    /**
     * 设置创建时间。
     *
     * @param createTime 创建时间。
     */
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = (createTime == null ? null : (java.util.Date) createTime.clone());
    }

    /**
     * @return 获取修改时间。
     */
    public java.util.Date getModifyTime() {
        return this.modifyTime == null ? null : (java.util.Date) this.modifyTime.clone();
    }

    /**
     * 设置修改时间。
     *
     * @param modifyTime 修改时间。
     */
    public void setModifyTime(java.util.Date modifyTime) {
        this.modifyTime = (modifyTime == null ? null : (java.util.Date) modifyTime.clone());
    }

    /**
     * @return 获取创建时间开始时间。
     */
    public java.util.Date getCreateTimeStart() {
        return this.createTimeStart == null ? null : (java.util.Date) this.createTimeStart.clone();
    }

    /**
     * 设置创建时间开始时间。
     *
     * @param createTimeStart 创建时间开始时间。
     */
    public void setCreateTimeStart(java.util.Date createTimeStart) {
        this.createTimeStart = (createTimeStart == null ? null : (java.util.Date) this.createTimeStart.clone());
    }

    /**
     * @return 获取创建时间结束时间。
     */
    public java.util.Date getCreateTimeEnd() {
        return this.createTimeEnd == null ? null : (java.util.Date) this.createTimeEnd.clone();
    }

    /**
     * 设置创建时间结束时间。
     *
     * @param createTimeEnd 创建时间结束时间。
     */
    public void setCreateTimeEnd(java.util.Date createTimeEnd) {
        this.createTimeEnd = (createTimeEnd == null ? null : (java.util.Date) createTimeEnd.clone());
    }

    /**
     * @return 获取修改时间开始时间。
     */
    public java.util.Date getModifyTimeStart() {
        return this.modifyTimeStart == null ? null : (java.util.Date) this.modifyTimeStart.clone();
    }

    /**
     * 设置修改时间开始时间。
     *
     * @param modifyTimeStart 修改时间开始时间。
     */
    public void setModifyTimeStart(java.util.Date modifyTimeStart) {
        this.modifyTimeStart = (modifyTimeStart == null ? null : (java.util.Date) this.modifyTimeStart.clone());
    }

    /**
     * @return 获取修改时间结束时间。
     */
    public java.util.Date getModifyTimeEnd() {
        return this.modifyTimeEnd == null ? null : (java.util.Date) this.modifyTimeEnd.clone();
    }

    /**
     * 设置修改时间结束时间。
     *
     * @param modifyTimeEnd 修改时间结束时间。
     */
    public void setModifyTimeEnd(java.util.Date modifyTimeEnd) {
        this.modifyTimeEnd = (modifyTimeEnd == null ? null : (java.util.Date) modifyTimeEnd.clone());
    }

    /**
     * @return 获取子菜单。
     */
    public List<Menu> getChildren() {
        return children;
    }

    /**
     * 设置子菜单。
     *
     * @param children 子菜单。
     */
    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    /**
     * 父级主键。
     */
    private String pid = "";
    /**
     * 标题。
     */
    private String title = "";
    /**
     * 图标。
     */
    private String icon = "";
    /**
     * 路径。
     */
    private String path = "";
    /**
     * 排序。
     */
    private Short sort;
    /**
     * 是否删除。
     */
    private Boolean deleted;
    /**
     * 备注。
     */
    private String remark;
    /**
     * 创建人。
     */
    private String createUser = "";
    /**
     * 修改人。
     */
    private String modifyUser = "";
    /**
     * 创建时间。
     */
    private java.util.Date createTime;
    /**
     * 修改时间。
     */
    private java.util.Date modifyTime;
    /**
     * 创建时间开始时间。
     */
    private java.util.Date createTimeStart;
    /**
     * 创建时间结束时间。
     */
    private java.util.Date createTimeEnd;
    /**
     * 修改时间开始时间。
     */
    private java.util.Date modifyTimeStart;
    /**
     * 修改时间结束时间。
     */
    private java.util.Date modifyTimeEnd;
    /**
     * 子菜单。
     */
    private List<Menu> children = new ArrayList<>();

}