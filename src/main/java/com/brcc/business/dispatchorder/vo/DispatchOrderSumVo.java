package com.brcc.business.dispatchorder.vo;

import java.math.BigDecimal;

/**
 * 描述:
 * 平台调度单统计封装类
 *
 * @author yushaohua
 * @create 2018-11-06 15:14
 */
public class DispatchOrderSumVo {

    private BigDecimal sumWeight;

    private BigDecimal sumZcWeight;

    private BigDecimal sumShWeight;

    public BigDecimal getSumWeight() {
        return sumWeight;
    }

    public void setSumWeight(BigDecimal sumWeight) {
        this.sumWeight = sumWeight;
    }

    public BigDecimal getSumZcWeight() {
        return sumZcWeight;
    }

    public void setSumZcWeight(BigDecimal sumZcWeight) {
        this.sumZcWeight = sumZcWeight;
    }

    public BigDecimal getSumShWeight() {
        return sumShWeight;
    }

    public void setSumShWeight(BigDecimal sumShWeight) {
        this.sumShWeight = sumShWeight;
    }
}