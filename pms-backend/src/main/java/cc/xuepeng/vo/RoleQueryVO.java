package cc.xuepeng.vo;

import cn.yesway.framework.common.entity.page.PageParam;

/**
 * 用户查询对象。
 *
 * @author xuepeng
 */
public class RoleQueryVO {

    /**
     * @return 获得名称。
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
     * 名称。
     */
    private String name = "";
    /**
     * 许可证。
     */
    private String licenseId = "";
    /**
     * 分页。
     */
    private PageParam page;

}
