package com.brcc.business.brokerFunds.vo;

import com.esteel.common.vo.BaseQueryVo;

/**
 * @Description 经纪人流水分配查询类
 * @Author pjy
 * @Date
 **/
public class BrokerFundsPayeeInfoQueryVo extends BaseQueryVo {

    private String companyPayeeName;

    private Long companyPayeeId;

    private Long fundsControlMasterId;



    public String getCompanyPayeeName() {
        return companyPayeeName;
    }

    public void setCompanyPayeeName(String companyPayeeName) {
        this.companyPayeeName = companyPayeeName;
    }

    public Long getCompanyPayeeId() {
        return companyPayeeId;
    }

    public void setCompanyPayeeId(Long companyPayeeId) {
        this.companyPayeeId = companyPayeeId;
    }

    public Long getFundsControlMasterId() {
        return fundsControlMasterId;
    }

    public void setFundsControlMasterId(Long fundsControlMasterId) {
        this.fundsControlMasterId = fundsControlMasterId;
    }
}
