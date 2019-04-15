package cc.xuepeng.entity;

import cn.yesway.framework.common.entity.base.BaseEntity;
import java.io.Serializable;

/**
 * Supplier的实体类。
 * 由Code Generator生成。
 *
 * @author Code Generator
 */
public class Supplier extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * @return 获取开户行。
     */
    public String getBankName() {
        return this.bankName;
    }

    /**
     * 设置开户行。
     *
     * @param bankName 开户行。
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    /**
     * @return 获取开户行卡号。
     */
    public String getBankAccount() {
        return this.bankAccount;
    }

    /**
     * 设置开户行卡号。
     *
     * @param bankAccount 开户行卡号。
     */
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }
    /**
     * @return 获取联系人。
     */
    public String getContact() {
        return this.contact;
    }

    /**
     * 设置联系人。
     *
     * @param contact 联系人。
     */
    public void setContact(String contact) {
        this.contact = contact;
    }
    /**
     * @return 获取联系电话。
     */
    public String getContactPhone() {
        return this.contactPhone;
    }

    /**
     * 设置联系电话。
     *
     * @param contactPhone 联系电话。
     */
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
    /**
     * @return 获取联系地址。
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * 设置联系地址。
     *
     * @param address 联系地址。
     */
    public void setAddress(String address) {
        this.address = address;
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
     * 名称。
     */
    private String name = "";
    /**
     * 开户行。
     */
    private String bankName = "";
    /**
     * 开户行卡号。
     */
    private String bankAccount = "";
    /**
     * 联系人。
     */
    private String contact = "";
    /**
     * 联系电话。
     */
    private String contactPhone = "";
    /**
     * 联系地址。
     */
    private String address = "";
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