package cc.xuepeng.entity;

import cn.yesway.framework.common.entity.base.BaseEntity;
import java.io.Serializable;

/**
 * License的实体类。
 * 由Code Generator生成。
 *
 * @author Code Generator
 */
public class License extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * @return 获取公司名称。
     */
    public String getCompany() {
        return this.company;
    }

    /**
     * 设置公司名称。
     *
     * @param company 公司名称。
     */
    public void setCompany(String company) {
        this.company = company;
    }
    /**
     * @return 获取过期时间。
     */
    public java.util.Date getExpireDate() {
        return this.expireDate == null ? null : (java.util.Date) this.expireDate.clone();
    }

    /**
     * 设置过期时间。
     *
     * @param expireDate 过期时间。
     */
    public void setExpireDate(java.util.Date expireDate) {
        this.expireDate = (expireDate == null ? null : (java.util.Date) expireDate.clone());
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
     * @return 获取过期时间开始时间。
     */
    public java.util.Date getExpireDateStart() {
        return this.expireDateStart == null ? null : (java.util.Date) this.expireDateStart.clone();
    }

    /**
     * 设置过期时间开始时间。
     *
     * @param expireDateStart 过期时间开始时间。
     */
    public void setExpireDateStart(java.util.Date expireDateStart) {
        this.expireDateStart = (expireDateStart == null ? null : (java.util.Date) this.expireDateStart.clone());
    }

    /**
     * @return 获取过期时间结束时间。
     */
    public java.util.Date getExpireDateEnd() {
        return this.expireDateEnd == null ? null : (java.util.Date) this.expireDateEnd.clone();
    }

    /**
     * 设置过期时间结束时间。
     *
     * @param expireDateEnd 过期时间结束时间。
     */
    public void setExpireDateEnd(java.util.Date expireDateEnd) {
        this.expireDateEnd = (expireDateEnd == null ? null : (java.util.Date) expireDateEnd.clone());
    }

    /**
     * 公司名称。
     */
    private String company = "";
    /**
     * 过期时间。
     */
    private java.util.Date expireDate;
    /**
     * 备注。
     */
    private String remark = "";
    /**
     * 过期时间开始时间。
     */
    private java.util.Date expireDateStart;
    /**
     * 过期时间结束时间。
     */
    private java.util.Date expireDateEnd;

}