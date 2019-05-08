package com.brcc.business.transorder.vo;

import java.math.BigDecimal;

/**
 * @description:
 * @author:TangYong
 * @date:2019/4/24
 */
public class DispatchVo {

    /**调度重量*/
    BigDecimal dispatchWeight;
    /**运单号*/
    Long transId;

    public BigDecimal getDispatchWeight() {
        return dispatchWeight;
    }

    public void setDispatchWeight(BigDecimal dispatchWeight) {
        this.dispatchWeight = dispatchWeight;
    }

    public Long getTransId() {
        return transId;
    }

    public void setTransId(Long transId) {
        this.transId = transId;
    }
}
