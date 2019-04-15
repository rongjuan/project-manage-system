package cc.xuepeng.entity;

import cn.yesway.framework.common.entity.base.BaseEntity;
import java.io.Serializable;

/**
 * User的实体类。
 * 由Code Generator生成。
 *
 * @author Code Generator
 */
public class User extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * @return 获取姓名。
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置姓名。
     *
     * @param name 姓名。
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return 获取账号。
     */
    public String getAccount() {
        return this.account;
    }

    /**
     * 设置账号。
     *
     * @param account 账号。
     */
    public void setAccount(String account) {
        this.account = account;
    }
    /**
     * @return 获取密码。
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * 设置密码。
     *
     * @param password 密码。
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * @return 获取电话。
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * 设置电话。
     *
     * @param phone 电话。
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
     * @return 获取状态：0=停用；1=启用；。
     */
    public Integer getStatus() {
        return this.status;
    }

    /**
     * 设置状态：0=停用；1=启用；。
     *
     * @param status 状态：0=停用；1=启用；。
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
        this.modifyTimeStart = (this.modifyTimeStart == null ? null : (java.util.Date) this.modifyTimeStart.clone());
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
     * 姓名。
     */
    private String name = "";
    /**
     * 账号。
     */
    private String account = "";
    /**
     * 密码。
     */
    private String password;
    /**
     * 电话。
     */
    private String phone = "";
    /**
     * 状态：0=停用；1=启用；。
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

}