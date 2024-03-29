package cc.xuepeng.entity;

import cn.yesway.framework.common.entity.base.BaseEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * User的实体类。
 * 由Code Generator生成。
 *
 * @author Code Generator
 */
public class User extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * @return 获取。
     */
    public String getLicenseId() {
        return this.licenseId;
    }

    /**
     * 设置。
     *
     * @param licenseId 。
     */
    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }
    /**
     * @return 获取。
     */
    public String getAccount() {
        return this.account;
    }

    /**
     * 设置。
     *
     * @param account 。
     */
    public void setAccount(String account) {
        this.account = account;
    }
    /**
     * @return 获取。
     */
    public String getSecret() {
        return this.secret;
    }

    /**
     * 设置。
     *
     * @param secret 。
     */
    public void setSecret(String secret) {
        this.secret = secret;
    }
    /**
     * @return 获取。
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置。
     *
     * @param name 。
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return 获取。
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * 设置。
     *
     * @param phone 。
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
     * @return 获取。
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * 设置。
     *
     * @param email 。
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * @return 获取。
     */
    public String getPhoto() {
        return this.photo;
    }

    /**
     * 设置。
     *
     * @param photo 。
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    /**
     * @return 获取。
     */
    public Byte getStatus() {
        return this.status;
    }

    /**
     * 设置。
     *
     * @param status 。
     */
    public void setStatus(Byte status) {
        this.status = status;
    }
    /**
     * @return 获取。
     */
    public Boolean getDeleted() {
        return this.deleted;
    }

    /**
     * 设置。
     *
     * @param deleted 。
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
    /**
     * @return 获取。
     */
    public String getRemark() {
        return this.remark;
    }

    /**
     * 设置。
     *
     * @param remark 。
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
    /**
     * @return 获取。
     */
    public String getCreateUser() {
        return this.createUser;
    }

    /**
     * 设置。
     *
     * @param createUser 。
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    /**
     * @return 获取。
     */
    public String getModifyUser() {
        return this.modifyUser;
    }

    /**
     * 设置。
     *
     * @param modifyUser 。
     */
    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }
    /**
     * @return 获取。
     */
    public java.util.Date getCreateTime() {
        return this.createTime == null ? null : (java.util.Date) this.createTime.clone();
    }

    /**
     * 设置。
     *
     * @param createTime 。
     */
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = (createTime == null ? null : (java.util.Date) createTime.clone());
    }
    /**
     * @return 获取。
     */
    public java.util.Date getModifyTime() {
        return this.modifyTime == null ? null : (java.util.Date) this.modifyTime.clone();
    }

    /**
     * 设置。
     *
     * @param modifyTime 。
     */
    public void setModifyTime(java.util.Date modifyTime) {
        this.modifyTime = (modifyTime == null ? null : (java.util.Date) modifyTime.clone());
    }

    /**
     * @return 获取开始时间。
     */
    public java.util.Date getCreateTimeStart() {
        return this.createTimeStart == null ? null : (java.util.Date) this.createTimeStart.clone();
    }

    /**
     * 设置开始时间。
     *
     * @param createTimeStart 开始时间。
     */
    public void setCreateTimeStart(java.util.Date createTimeStart) {
        this.createTimeStart = (createTimeStart == null ? null : (java.util.Date) this.createTimeStart.clone());
    }

    /**
     * @return 获取结束时间。
     */
    public java.util.Date getCreateTimeEnd() {
        return this.createTimeEnd == null ? null : (java.util.Date) this.createTimeEnd.clone();
    }

    /**
     * 设置结束时间。
     *
     * @param createTimeEnd 结束时间。
     */
    public void setCreateTimeEnd(java.util.Date createTimeEnd) {
        this.createTimeEnd = (createTimeEnd == null ? null : (java.util.Date) createTimeEnd.clone());
    }
    /**
     * @return 获取开始时间。
     */
    public java.util.Date getModifyTimeStart() {
        return this.modifyTimeStart == null ? null : (java.util.Date) this.modifyTimeStart.clone();
    }

    /**
     * 设置开始时间。
     *
     * @param modifyTimeStart 开始时间。
     */
    public void setModifyTimeStart(java.util.Date modifyTimeStart) {
        this.modifyTimeStart = (modifyTimeStart == null ? null : (java.util.Date) this.modifyTimeStart.clone());
    }

    /**
     * @return 获取结束时间。
     */
    public java.util.Date getModifyTimeEnd() {
        return this.modifyTimeEnd == null ? null : (java.util.Date) this.modifyTimeEnd.clone();
    }

    /**
     * 设置结束时间。
     *
     * @param modifyTimeEnd 结束时间。
     */
    public void setModifyTimeEnd(java.util.Date modifyTimeEnd) {
        this.modifyTimeEnd = (modifyTimeEnd == null ? null : (java.util.Date) modifyTimeEnd.clone());
    }

	/**
     * @return 获取用户可访问的菜单。
            */
    public List<Menu> getMenus() {
        return menus;
    }

    /**
     * 设置用户可访问的菜单。
     *
     * @param menus 用户可访问的菜单。
     */
    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    /**
     * 。
     */
    private String licenseId = "";
    /**
     * 。
     */
    private String account = "";
    /**
     * 。
     */
    private String secret = "";
    /**
     * 。
     */
    private String name = "";
    /**
     * 。
     */
    private String phone = "";
    /**
     * 。
     */
    private String email = "";
    /**
     * 。
     */
    private String photo = "";
    /**
     * 。
     */
    private Byte status;
    /**
     * 。
     */
    private Boolean deleted;
    /**
     * 。
     */
    private String remark = "";
    /**
     * 。
     */
    private String createUser = "";
    /**
     * 。
     */
    private String modifyUser = "";
    /**
     * 。
     */
    private java.util.Date createTime;
    /**
     * 。
     */
    private java.util.Date modifyTime;
    /**
     * 开始时间。
     */
    private java.util.Date createTimeStart;
    /**
     * 结束时间。
     */
    private java.util.Date createTimeEnd;
    /**
     * 开始时间。
     */
    private java.util.Date modifyTimeStart;
    /**
     * 结束时间。
     */
    private java.util.Date modifyTimeEnd;
       /**
     * 用户可访问的菜单。
     */
    private List<Menu> menus = new ArrayList<>();

}