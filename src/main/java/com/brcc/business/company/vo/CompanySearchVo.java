package com.brcc.business.company.vo;

import com.esteel.common.vo.BaseQueryVo;

/**
 * 描述:
 * 公司检索封装类
 *
 * @author yushaohua
 * @create 2018-11-22 17:00
 */
public class CompanySearchVo extends BaseQueryVo {

    private Long parentCompanyId;

    private String platformId;

    private String queryValue;
    
    private Long publishId;
    
    private Long companyId;

    public Long getParentCompanyId() {
        return parentCompanyId;
    }

    public void setParentCompanyId(Long parentCompanyId) {
        this.parentCompanyId = parentCompanyId;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getQueryValue() {
        return queryValue;
    }

    public void setQueryValue(String queryValue) {
        this.queryValue = queryValue;
    }

	public Long getPublishId() {
		return publishId;
	}

	public void setPublishId(Long publishId) {
		this.publishId = publishId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
    
    
}