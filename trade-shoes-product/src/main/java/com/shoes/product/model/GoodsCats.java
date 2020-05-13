package com.shoes.product.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * s_goods_cats
 * @author  wx
 */
public class GoodsCats implements Serializable {
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
     * 父级ID
     */
    @ApiModelProperty(value = "父级ID")
    private Integer parentId;

    /**
     * 类型图片路径
     */
    @ApiModelProperty(value = "类型图片路径")
    private String picUrl;

    /**
     * 类型标题
     */
    @ApiModelProperty(value = "类型标题")
    private String picName;

    /**
     * 是否显示  1(显示)  2(隐藏)
     */
    @ApiModelProperty(value = "是否显示  1(显示)  2(隐藏)")
    private Integer isShow;

    /**
     * 排序号
     */
    @ApiModelProperty(value = "排序号")
    private Integer catSort;

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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public Integer getCatSort() {
        return catSort;
    }

    public void setCatSort(Integer catSort) {
        this.catSort = catSort;
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
        GoodsCats other = (GoodsCats) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCatId() == null ? other.getCatId() == null : this.getCatId().equals(other.getCatId()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getPicUrl() == null ? other.getPicUrl() == null : this.getPicUrl().equals(other.getPicUrl()))
            && (this.getPicName() == null ? other.getPicName() == null : this.getPicName().equals(other.getPicName()))
            && (this.getIsShow() == null ? other.getIsShow() == null : this.getIsShow().equals(other.getIsShow()))
            && (this.getCatSort() == null ? other.getCatSort() == null : this.getCatSort().equals(other.getCatSort()))
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
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getPicUrl() == null) ? 0 : getPicUrl().hashCode());
        result = prime * result + ((getPicName() == null) ? 0 : getPicName().hashCode());
        result = prime * result + ((getIsShow() == null) ? 0 : getIsShow().hashCode());
        result = prime * result + ((getCatSort() == null) ? 0 : getCatSort().hashCode());
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
        sb.append(", parentId=").append(parentId);
        sb.append(", picUrl=").append(picUrl);
        sb.append(", picName=").append(picName);
        sb.append(", isShow=").append(isShow);
        sb.append(", catSort=").append(catSort);
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