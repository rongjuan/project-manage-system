package cc.xuepeng.vo;

import cn.yesway.framework.common.entity.page.PageParam;

/**
 * 用户查询对象。
 *
 * @author xuepenga
 */
public class UserQueryVO {

    /**
     * @return 获得账号。
     */
    public String getAccount() {
        return account;
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
     * @return 名称。
     */
    public String getName() {
        return name;
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
     * @return 获得电话。
     */
    public String getPhone() {
        return phone;
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
     * @return 获得邮件。
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮件。
     *
     * @param email 邮件。
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return 获取许可证。
     */
    public String getLicenseId() {
        return licenseId;
    }

    /**
     * 设置许可证。
     *
     * @param licenseId 许可证。
     */
    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

    /**
     * @return 获得分页。
     */
    public PageParam getPage() {
        return page;
    }

    /**
     * 设置分页。
     *
     * @param page 分页。
     */
    public void setPage(PageParam page) {
        this.page = page;
    }

    /**
     * 账号。
     */
    private String account = "";
    /**
     * 名称。
     */
    private String name = "";
    /**
     * 电话。
     */
    private String phone = "";
    /**
     * 邮箱。
     */
    private String email = "";
    /**
     * 许可证。
     */
    private String licenseId = "";
    /**
     * 分页。
     */
    private PageParam page;

}
