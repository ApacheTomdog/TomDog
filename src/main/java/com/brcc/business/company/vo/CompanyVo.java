package com.brcc.business.company.vo;

import com.brcc.business.company.entity.CompanyEntity;

/**
 * 描述:
 * 公司查询返回数据封装类
 *
 * @author yushaohua
 * @create 2018-11-22 16:55
 */
public class CompanyVo extends CompanyEntity {

    private Long queryKey;

    private String queryValue;
    
    private Long count;

    public Long getQueryKey() {
        return queryKey;
    }

    public void setQueryKey(Long queryKey) {
        this.queryKey = queryKey;
    }

    public String getQueryValue() {
        return queryValue;
    }

    public void setQueryValue(String queryValue) {
        this.queryValue = queryValue;
    }

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}
    
}