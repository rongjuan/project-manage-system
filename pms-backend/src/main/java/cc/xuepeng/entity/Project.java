package cc.xuepeng.entity;

import cn.yesway.framework.common.entity.base.BaseEntity;

import java.io.Serializable;

/**
 * Project的实体类。
 * 由Code Generator生成。
 *
 * @author Code Generator
 */
public class Project extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * @return 获取项目经理。
     */
    public String getUserId() {
        return this.userId;
    }

    /**
     * 设置项目经理。
     *
     * @param userId 项目经理。
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return 获取项目经理名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置项目经理名称。
     *
     * @param userName 项目经理名称。
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return 获取名称。
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置名称。
     *
     * @param name 名称。
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return 获取地址。
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * 设置地址。
     *
     * @param address 地址。
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return 获取状态：状态：0=初始化；1=启动；2=暂停；3=停止。
     */
    public Integer getStatus() {
        return this.status;
    }

    /**
     * 设置状态：状态：0=初始化；1=启动；2=暂停；3=停止。
     *
     * @param status 状态：0=初始化；1=启动；2=暂停；3=停止。
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return 获取是否删除。
     */
    public Boolean getIsDelete() {
        return this.isDelete;
    }

    /**
     * 设置是否删除。
     *
     * @param isDelete 是否删除。
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
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
     * @return 获取编辑人。
     */
    public String getModifyUser() {
        return this.modifyUser;
    }

    /**
     * 设置编辑人。
     *
     * @param modifyUser 编辑人。
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
     * @return 获取编辑时间。
     */
    public java.util.Date getModifyTime() {
        return this.modifyTime == null ? null : (java.util.Date) this.modifyTime.clone();
    }

    /**
     * 设置编辑时间。
     *
     * @param modifyTime 编辑时间。
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
        this.createTimeStart = (this.createTimeStart == null ? null : (java.util.Date) this.createTimeStart.clone());
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
     * @return 获取编辑时间开始时间。
     */
    public java.util.Date getModifyTimeStart() {
        return this.modifyTimeStart == null ? null : (java.util.Date) this.modifyTimeStart.clone();
    }

    /**
     * 设置编辑时间开始时间。
     *
     * @param modifyTimeStart 编辑时间开始时间。
     */
    public void setModifyTimeStart(java.util.Date modifyTimeStart) {
        this.modifyTimeStart = (this.modifyTimeStart == null ? null : (java.util.Date) this.modifyTimeStart.clone());
    }

    /**
     * @return 获取编辑时间结束时间。
     */
    public java.util.Date getModifyTimeEnd() {
        return this.modifyTimeEnd == null ? null : (java.util.Date) this.modifyTimeEnd.clone();
    }

    /**
     * 设置编辑时间结束时间。
     *
     * @param modifyTimeEnd 编辑时间结束时间。
     */
    public void setModifyTimeEnd(java.util.Date modifyTimeEnd) {
        this.modifyTimeEnd = (modifyTimeEnd == null ? null : (java.util.Date) modifyTimeEnd.clone());
    }

    /**
     * 项目经理。
     */
    private String userId = "";
    /**
     * 项目经理名称。
     */
    private String userName = "";
    /**
     * 名称。
     */
    private String name = "";
    /**
     * 地址。
     */
    private String address = "";
    /**
     * 状态：状态：0=初始化；1=启动；2=暂停；3=停止。
     */
    private Integer status;
    /**
     * 是否删除。
     */
    private Boolean isDelete;
    /**
     * 备注。
     */
    private String remark = "";
    /**
     * 创建人。
     */
    private String createUser = "";
    /**
     * 编辑人。
     */
    private String modifyUser = "";
    /**
     * 创建时间。
     */
    private java.util.Date createTime;
    /**
     * 编辑时间。
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
     * 编辑时间开始时间。
     */
    private java.util.Date modifyTimeStart;
    /**
     * 编辑时间结束时间。
     */
    private java.util.Date modifyTimeEnd;

}