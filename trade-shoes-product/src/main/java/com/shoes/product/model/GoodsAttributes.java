package com.shoes.product.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * s_goods_attributes
 * @author  wx
 */
public class GoodsAttributes implements Serializable {
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
     * 市场价格
     */
    @ApiModelProperty(value = "市场价格")
    private Long goodsAmount;

    /**
     * 总库存
     */
    @ApiModelProperty(value = "总库存")
    private Integer goodsStock;

    /**
     * 已出售数量
     */
    @ApiModelProperty(value = "已出售数量")
    private Integer goodsSell;

    /**
     * 剩余库存
     */
    @ApiModelProperty(value = "剩余库存")
    private Integer goodsSurplus;

    /**
     * 商品尺码
     */
    @ApiModelProperty(value = "商品尺码")
    private BigDecimal goodsSize;

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

    public Long getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(Long goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public Integer getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(Integer goodsStock) {
        this.goodsStock = goodsStock;
    }

    public Integer getGoodsSell() {
        return goodsSell;
    }

    public void setGoodsSell(Integer goodsSell) {
        this.goodsSell = goodsSell;
    }

    public Integer getGoodsSurplus() {
        return goodsSurplus;
    }

    public void setGoodsSurplus(Integer goodsSurplus) {
        this.goodsSurplus = goodsSurplus;
    }

    public BigDecimal getGoodsSize() {
        return goodsSize;
    }

    public void setGoodsSize(BigDecimal goodsSize) {
        this.goodsSize = goodsSize;
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
        GoodsAttributes other = (GoodsAttributes) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCatId() == null ? other.getCatId() == null : this.getCatId().equals(other.getCatId()))
            && (this.getShopId() == null ? other.getShopId() == null : this.getShopId().equals(other.getShopId()))
            && (this.getOrdGoods() == null ? other.getOrdGoods() == null : this.getOrdGoods().equals(other.getOrdGoods()))
            && (this.getGoodsAmount() == null ? other.getGoodsAmount() == null : this.getGoodsAmount().equals(other.getGoodsAmount()))
            && (this.getGoodsStock() == null ? other.getGoodsStock() == null : this.getGoodsStock().equals(other.getGoodsStock()))
            && (this.getGoodsSell() == null ? other.getGoodsSell() == null : this.getGoodsSell().equals(other.getGoodsSell()))
            && (this.getGoodsSurplus() == null ? other.getGoodsSurplus() == null : this.getGoodsSurplus().equals(other.getGoodsSurplus()))
            && (this.getGoodsSize() == null ? other.getGoodsSize() == null : this.getGoodsSize().equals(other.getGoodsSize()))
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
        result = prime * result + ((getGoodsAmount() == null) ? 0 : getGoodsAmount().hashCode());
        result = prime * result + ((getGoodsStock() == null) ? 0 : getGoodsStock().hashCode());
        result = prime * result + ((getGoodsSell() == null) ? 0 : getGoodsSell().hashCode());
        result = prime * result + ((getGoodsSurplus() == null) ? 0 : getGoodsSurplus().hashCode());
        result = prime * result + ((getGoodsSize() == null) ? 0 : getGoodsSize().hashCode());
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
        sb.append(", goodsAmount=").append(goodsAmount);
        sb.append(", goodsStock=").append(goodsStock);
        sb.append(", goodsSell=").append(goodsSell);
        sb.append(", goodsSurplus=").append(goodsSurplus);
        sb.append(", goodsSize=").append(goodsSize);
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