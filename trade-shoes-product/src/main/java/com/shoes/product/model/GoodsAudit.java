package com.shoes.product.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * s_goods_audit
 * @author  wx
 */
public class GoodsAudit implements Serializable {
    /**
     * 自增id
     */
    private Integer id;

    /**
     * 类型ID
     */
    @ApiModelProperty(value = "类型ID")
    private Integer catId;

    /**
     * 店铺ID
     */
    @ApiModelProperty(value = "店铺ID")
    private Integer shopId;

    /**
     * 商品编号
     */
    @ApiModelProperty(value = "商品编号")
    private String ordGoods;

    /**
     * 审核状态：0(待审核) 1(已通过) 2(拒绝)
     */
    @ApiModelProperty(value = "审核状态：0(待审核) 1(已通过) 2(拒绝)")
    private Integer auditStatus;

    /**
     * 拒绝说明
     */
    @ApiModelProperty(value = "拒绝说明")
    private String illegalRemarks;

    /**
     * 审核人
     */
    @ApiModelProperty(value = "审核人")
    private String auditUser;

    /**
     * 审核时间
     */
    @ApiModelProperty(value = "审核时间")
    private Date auditTime;

    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者")
    private String intoUser;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date intoTime;

    /**
     * 更新者
     */
    @ApiModelProperty(value = "更新者")
    private String updUser;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updTime;

    /**
     * 软删除状态：默认：1 （-1：已删除  1：正常）
     */
    @ApiModelProperty(value = "软删除状态：默认：1 （-1：已删除  1：正常）")
    private Integer status;

    /**
     * 版本号
     */
    @ApiModelProperty(value = "版本号")
    private Integer version;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getOrdGoods() {
        return ordGoods;
    }

    public void setOrdGoods(String ordGoods) {
        this.ordGoods = ordGoods;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getIllegalRemarks() {
        return illegalRemarks;
    }

    public void setIllegalRemarks(String illegalRemarks) {
        this.illegalRemarks = illegalRemarks;
    }

    public String getAuditUser() {
        return auditUser;
    }

    public void setAuditUser(String auditUser) {
        this.auditUser = auditUser;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public String getIntoUser() {
        return intoUser;
    }

    public void setIntoUser(String intoUser) {
        this.intoUser = intoUser;
    }

    public Date getIntoTime() {
        return intoTime;
    }

    public void setIntoTime(Date intoTime) {
        this.intoTime = intoTime;
    }

    public String getUpdUser() {
        return updUser;
    }

    public void setUpdUser(String updUser) {
        this.updUser = updUser;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        GoodsAudit other = (GoodsAudit) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCatId() == null ? other.getCatId() == null : this.getCatId().equals(other.getCatId()))
            && (this.getShopId() == null ? other.getShopId() == null : this.getShopId().equals(other.getShopId()))
            && (this.getOrdGoods() == null ? other.getOrdGoods() == null : this.getOrdGoods().equals(other.getOrdGoods()))
            && (this.getAuditStatus() == null ? other.getAuditStatus() == null : this.getAuditStatus().equals(other.getAuditStatus()))
            && (this.getIllegalRemarks() == null ? other.getIllegalRemarks() == null : this.getIllegalRemarks().equals(other.getIllegalRemarks()))
            && (this.getAuditUser() == null ? other.getAuditUser() == null : this.getAuditUser().equals(other.getAuditUser()))
            && (this.getAuditTime() == null ? other.getAuditTime() == null : this.getAuditTime().equals(other.getAuditTime()))
            && (this.getIntoUser() == null ? other.getIntoUser() == null : this.getIntoUser().equals(other.getIntoUser()))
            && (this.getIntoTime() == null ? other.getIntoTime() == null : this.getIntoTime().equals(other.getIntoTime()))
            && (this.getUpdUser() == null ? other.getUpdUser() == null : this.getUpdUser().equals(other.getUpdUser()))
            && (this.getUpdTime() == null ? other.getUpdTime() == null : this.getUpdTime().equals(other.getUpdTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCatId() == null) ? 0 : getCatId().hashCode());
        result = prime * result + ((getShopId() == null) ? 0 : getShopId().hashCode());
        result = prime * result + ((getOrdGoods() == null) ? 0 : getOrdGoods().hashCode());
        result = prime * result + ((getAuditStatus() == null) ? 0 : getAuditStatus().hashCode());
        result = prime * result + ((getIllegalRemarks() == null) ? 0 : getIllegalRemarks().hashCode());
        result = prime * result + ((getAuditUser() == null) ? 0 : getAuditUser().hashCode());
        result = prime * result + ((getAuditTime() == null) ? 0 : getAuditTime().hashCode());
        result = prime * result + ((getIntoUser() == null) ? 0 : getIntoUser().hashCode());
        result = prime * result + ((getIntoTime() == null) ? 0 : getIntoTime().hashCode());
        result = prime * result + ((getUpdUser() == null) ? 0 : getUpdUser().hashCode());
        result = prime * result + ((getUpdTime() == null) ? 0 : getUpdTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", catId=").append(catId);
        sb.append(", shopId=").append(shopId);
        sb.append(", ordGoods=").append(ordGoods);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", illegalRemarks=").append(illegalRemarks);
        sb.append(", auditUser=").append(auditUser);
        sb.append(", auditTime=").append(auditTime);
        sb.append(", intoUser=").append(intoUser);
        sb.append(", intoTime=").append(intoTime);
        sb.append(", updUser=").append(updUser);
        sb.append(", updTime=").append(updTime);
        sb.append(", status=").append(status);
        sb.append(", version=").append(version);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}