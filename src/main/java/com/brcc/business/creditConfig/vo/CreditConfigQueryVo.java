package com.brcc.business.creditConfig.vo;

import java.util.Date;

import com.esteel.common.vo.BaseQueryVo;

/**
 * @Description: 委托方授信管理接受数据封装类
 * @Auther: gemaochao
 * @Date:Created in 13:55 2018/10/31
 */
public class CreditConfigQueryVo extends BaseQueryVo {

	private static final long serialVersionUID = 1L;

	//平台id
    private String platformId;

    //授信平台company_id',
    private Long creditPlatCompanyId;

    //id
    private String creditConfigId;

    private Long userId;

    private Long companyId;
    //委托方名称
    private Long publishCompanyId;

    private String publishCompanyName;

    private Date createStartDate;

    private Date createEndDate;

    private String creditStatus;
    
    /**调价状态(00：无效，10：新增，90：有效)*/
    private String adjPriceStatus;


    private String queryKey;
    private String queryValue;


    public String getQueryKey() {
        return queryKey;
    }

    public void setQueryKey(String queryKey) {
        this.queryKey = queryKey;
    }

    public String getQueryValue() {
        return queryValue;
    }

    public void setQueryValue(String queryValue) {
        this.queryValue = queryValue;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getCreditConfigId() {
        return creditConfigId;
    }

    public void setCreditConfigId(String creditConfigId) {
        this.creditConfigId = creditConfigId;
    }

    @Override
    public Long getUserId() {
        return userId;
    }

    @Override
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
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

    public String getCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(String creditStatus) {
        this.creditStatus = creditStatus;
    }

    public Long getCreditPlatCompanyId() {
        return creditPlatCompanyId;
    }

    public void setCreditPlatCompanyId(Long creditPlatCompanyId) {
        this.creditPlatCompanyId = creditPlatCompanyId;
    }

	public String getAdjPriceStatus() {
		return adjPriceStatus;
	}

	public void setAdjPriceStatus(String adjPriceStatus) {
		this.adjPriceStatus = adjPriceStatus;
	}
    
}
