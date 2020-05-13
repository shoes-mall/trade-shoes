package com.shoes.product.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * s_goods
 * @author  wx
 */
public class Goods implements Serializable {
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
     * 商品编号（唯一）
     */
    @ApiModelProperty(value = "商品编号（唯一）")
    private String ordGoods;

    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    /**
     * 商品图片
     */
    @ApiModelProperty(value = "商品图片")
    private String goodsImg;

    /**
     * 商品类型  1(实物)  2(虚拟货物)
     */
    @ApiModelProperty(value = "商品类型  1(实物)  2(虚拟货物)")
    private Integer goodsType;

    /**
     * 商品描述
     */
    @ApiModelProperty(value = "商品描述")
    private String goodsDesc;

    /**
     * 是否上架  1(上架)  2(下架)
     */
    @ApiModelProperty(value = "是否上架  1(上架)  2(下架)")
    private Integer isSale;

    /**
     * 是否新品  1(是)  2(否)
     */
    @ApiModelProperty(value = "是否新品  1(是)  2(否)")
    private Integer isNew;

    /**
     * 发售时间
     */
    @ApiModelProperty(value = "发售时间")
    private Date saleTime;

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

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public Integer getIsSale() {
        return isSale;
    }

    public void setIsSale(Integer isSale) {
        this.isSale = isSale;
    }

    public Integer getIsNew() {
        return isNew;
    }

    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }

    public Date getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(Date saleTime) {
        this.saleTime = saleTime;
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
        Goods other = (Goods) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCatId() == null ? other.getCatId() == null : this.getCatId().equals(other.getCatId()))
            && (this.getShopId() == null ? other.getShopId() == null : this.getShopId().equals(other.getShopId()))
            && (this.getOrdGoods() == null ? other.getOrdGoods() == null : this.getOrdGoods().equals(other.getOrdGoods()))
            && (this.getGoodsName() == null ? other.getGoodsName() == null : this.getGoodsName().equals(other.getGoodsName()))
            && (this.getGoodsImg() == null ? other.getGoodsImg() == null : this.getGoodsImg().equals(other.getGoodsImg()))
            && (this.getGoodsType() == null ? other.getGoodsType() == null : this.getGoodsType().equals(other.getGoodsType()))
            && (this.getGoodsDesc() == null ? other.getGoodsDesc() == null : this.getGoodsDesc().equals(other.getGoodsDesc()))
            && (this.getIsSale() == null ? other.getIsSale() == null : this.getIsSale().equals(other.getIsSale()))
            && (this.getIsNew() == null ? other.getIsNew() == null : this.getIsNew().equals(other.getIsNew()))
            && (this.getSaleTime() == null ? other.getSaleTime() == null : this.getSaleTime().equals(other.getSaleTime()))
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
        result = prime * result + ((getGoodsName() == null) ? 0 : getGoodsName().hashCode());
        result = prime * result + ((getGoodsImg() == null) ? 0 : getGoodsImg().hashCode());
        result = prime * result + ((getGoodsType() == null) ? 0 : getGoodsType().hashCode());
        result = prime * result + ((getGoodsDesc() == null) ? 0 : getGoodsDesc().hashCode());
        result = prime * result + ((getIsSale() == null) ? 0 : getIsSale().hashCode());
        result = prime * result + ((getIsNew() == null) ? 0 : getIsNew().hashCode());
        result = prime * result + ((getSaleTime() == null) ? 0 : getSaleTime().hashCode());
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
        sb.append(", goodsName=").append(goodsName);
        sb.append(", goodsImg=").append(goodsImg);
        sb.append(", goodsType=").append(goodsType);
        sb.append(", goodsDesc=").append(goodsDesc);
        sb.append(", isSale=").append(isSale);
        sb.append(", isNew=").append(isNew);
        sb.append(", saleTime=").append(saleTime);
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