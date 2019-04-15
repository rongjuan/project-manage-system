package cc.xuepeng.entity;

import cn.yesway.framework.common.entity.base.BaseEntity;

import java.io.Serializable;

/**
 * PurchaseOrder的实体类。
 * 由Code Generator生成。
 *
 * @author Code Generator
 */
public class PurchaseOrder extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * @return 获取采购日期。
     */
    public java.util.Date getPurchaseDate() {
        return this.purchaseDate == null ? null : (java.util.Date) this.purchaseDate.clone();
    }

    /**
     * 设置采购日期。
     *
     * @param purchaseDate 采购日期。
     */
    public void setPurchaseDate(java.util.Date purchaseDate) {
        this.purchaseDate = (purchaseDate == null ? null : (java.util.Date) purchaseDate.clone());
    }

    /**
     * @return 获取供应商主键。
     */
    public String getSupplierId() {
        return this.supplierId;
    }

    /**
     * 设置供应商主键。
     *
     * @param supplierId 供应商主键。
     */
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * @return 获取供应商名称。
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * 设置供应商名称。
     *
     * @param supplierName 供应商名称。
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    /**
     * @return 获取商品主键。
     */
    public String getCommodityId() {
        return this.commodityId;
    }

    /**
     * 设置商品主键。
     *
     * @param commodityId 商品主键。
     */
    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    /**
     * @return 获取商品名称。
     */
    public String getCommodityName() {
        return commodityName;
    }

    /**
     * 设置商品名称。
     *
     * @param commodityName 商品名称。
     */
    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    /**
     * @return 获取项目主键。
     */
    public String getProjectId() {
        return this.projectId;
    }

    /**
     * 设置项目主键。
     *
     * @param projectId 项目主键。
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    /**
     * @return 获取项目名称。
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 设置项目名称。
     *
     * @param projectName 项目名称。
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * @return 获取商品规格。
     */
    public String getSpecification() {
        return this.specification;
    }

    /**
     * 设置商品规格。
     *
     * @param specification 商品规格。
     */
    public void setSpecification(String specification) {
        this.specification = specification;
    }

    /**
     * @return 获取单位名称。
     */
    public String getUnit() {
        return this.unit;
    }

    /**
     * 设置单位名称。
     *
     * @param unit 单位名称。
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * @return 获取商品数量。
     */
    public Integer getQuantity() {
        return this.quantity;
    }

    /**
     * 设置商品数量。
     *
     * @param quantity 商品数量。
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @return 获取单价。
     */
    public java.math.BigDecimal getPrice() {
        return this.price;
    }

    /**
     * 设置单价。
     *
     * @param price 单价。
     */
    public void setPrice(java.math.BigDecimal price) {
        this.price = price;
    }

    /**
     * @return 获取合计金额。
     */
    public java.math.BigDecimal getAmount() {
        return this.amount;
    }

    /**
     * 设置合计金额。
     *
     * @param amount 合计金额。
     */
    public void setAmount(java.math.BigDecimal amount) {
        this.amount = amount;
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
     * @return 获取采购日期开始时间。
     */
    public java.util.Date getPurchaseDateStart() {
        return this.purchaseDateStart == null ? null : (java.util.Date) this.purchaseDateStart.clone();
    }

    /**
     * 设置采购日期开始时间。
     *
     * @param purchaseDateStart 采购日期开始时间。
     */
    public void setPurchaseDateStart(java.util.Date purchaseDateStart) {
        this.purchaseDateStart = (this.purchaseDateStart == null ? null : (java.util.Date) this.purchaseDateStart.clone());
    }

    /**
     * @return 获取采购日期结束时间。
     */
    public java.util.Date getPurchaseDateEnd() {
        return this.purchaseDateEnd == null ? null : (java.util.Date) this.purchaseDateEnd.clone();
    }

    /**
     * 设置采购日期结束时间。
     *
     * @param purchaseDateEnd 采购日期结束时间。
     */
    public void setPurchaseDateEnd(java.util.Date purchaseDateEnd) {
        this.purchaseDateEnd = (purchaseDateEnd == null ? null : (java.util.Date) purchaseDateEnd.clone());
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
     * 采购日期。
     */
    private java.util.Date purchaseDate;
    /**
     * 供应商主键。
     */
    private String supplierId = "";
    /**
     * 供应商名称。
     */
    private String supplierName = "";
    /**
     * 商品主键。
     */
    private String commodityId = "";
    /**
     * 商品名称。
     */
    private String commodityName = "";
    /**
     * 项目主键。
     */
    private String projectId = "";
    /**
     * 项目名称。
     */
    private String projectName = "";
    /**
     * 商品规格。
     */
    private String specification = "";
    /**
     * 单位名称。
     */
    private String unit = "";
    /**
     * 商品数量。
     */
    private Integer quantity;
    /**
     * 单价。
     */
    private java.math.BigDecimal price;
    /**
     * 合计金额。
     */
    private java.math.BigDecimal amount;
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
     * 采购日期开始时间。
     */
    private java.util.Date purchaseDateStart;
    /**
     * 采购日期结束时间。
     */
    private java.util.Date purchaseDateEnd;
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