/**
 * 
 */
package com.brcc.business.util;

import com.esteel.common.vo.BaseQueryVo;

/**
 * @Description:
 * @author:陈利
 * @date:2018年11月14日
 * 
 */
public class QueryKeyValue extends BaseQueryVo {

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
}
