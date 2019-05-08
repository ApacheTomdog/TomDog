package com.brcc.business.creditAdjustPrice.vo;

import com.esteel.common.vo.BaseQueryVo;

import java.util.Date;

/**
 * @Description: 授信调价配置查询封装类
 * @Auther: gemaochao
 * @Date:Created in 20:06 2018/11/3
 */
public class CreditAdjustPriceQuerySearchVo extends BaseQueryVo {


    private Long credAdjMId;


    private Long publishCompanyId;

    private String publishCompanyName;


    private String adjPriceStyle;


    private String adjPriceStatus;

    private Date createDate;


    private Long createPersonId;


    private String createPersonName;


    private Date modifyDate;


    private Long modifyPersonId;


    private String modifyPersonName;


    private String remark;


    private Long creditPlatCompanyId;


    private String platformId;
    private Date createStartDate;

    private Date createEndDate;

    public Date getCreateStartDate() {
        return createStartDate;
    }

    public void setCreateStartDate(Date createStartDate) {
        this.createStartDate = createStartDate;
    }

    public Date getCreateEndDate() {
        return createEndDate;
    }

    public void setCreateEndDate(Date createEndDate) {
        this.createEndDate = createEndDate;
    }

    public Long getCredAdjMId() {
        return credAdjMId;
    }

    public void setCredAdjMId(Long credAdjMId) {
        this.credAdjMId = credAdjMId;
    }

    public Long getPublishCompanyId() {
        return publishCompanyId;
    }

    public void setPublishCompanyId(Long publishCompanyId) {
        this.publishCompanyId = publishCompanyId;
    }

    public String getPublishCompanyName() {
        return publishCompanyName;
    }

    public void setPublishCompanyName(String publishCompanyName) {
        this.publishCompanyName = publishCompanyName;
    }

    public String getAdjPriceStyle() {
        return adjPriceStyle;
    }

    public void setAdjPriceStyle(String adjPriceStyle) {
        this.adjPriceStyle = adjPriceStyle;
    }

    public String getAdjPriceStatus() {
        return adjPriceStatus;
    }

    public void setAdjPriceStatus(String adjPriceStatus) {
        this.adjPriceStatus = adjPriceStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getCreatePersonId() {
        return createPersonId;
    }

    public void setCreatePersonId(Long createPersonId) {
        this.createPersonId = createPersonId;
    }

    public String getCreatePersonName() {
        return createPersonName;
    }

    public void setCreatePersonName(String createPersonName) {
        this.createPersonName = createPersonName;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Long getModifyPersonId() {
        return modifyPersonId;
    }

    public void setModifyPersonId(Long modifyPersonId) {
        this.modifyPersonId = modifyPersonId;
    }

    public String getModifyPersonName() {
        return modifyPersonName;
    }

    public void setModifyPersonName(String modifyPersonName) {
        this.modifyPersonName = modifyPersonName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getCreditPlatCompanyId() {
        return creditPlatCompanyId;
    }

    public void setCreditPlatCompanyId(Long creditPlatCompanyId) {
        this.creditPlatCompanyId = creditPlatCompanyId;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }
}
