package com.brcc.business.transportbill.vo;

import java.io.Serializable;

/**
 * ESTeel
 * Description:
 * 查询 对应公司的 查询间隔数据
 * User: zhangxiuzhi
 * Date: 2018-12-03
 * Time: 20:29
 */
public class IntervalTimeVo implements Serializable {
    String companyName;
    Integer times;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }
}
