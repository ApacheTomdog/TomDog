package com.brcc.business.transportbill.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * ESTeel
 * Description: 调度单已经完成的数量，用户数据库中查询数据获取
 * User: zhangxiuzhi
 * Date: 2018-12-04
 * Time: 13:27
 */
public class DeliveryComplateWeightVo implements Serializable {
    BigDecimal sumWeight;
    BigDecimal sumQty;
    BigDecimal initWeight;
    BigDecimal initQty;

    public BigDecimal getSumWeight() {
        return sumWeight;
    }

    public void setSumWeight(BigDecimal sumWeight) {
        this.sumWeight = sumWeight;
    }

    public BigDecimal getSumQty() {
        return sumQty;
    }

    public void setSumQty(BigDecimal sumQty) {
        this.sumQty = sumQty;
    }

    public BigDecimal getInitWeight() {
        return initWeight;
    }

    public void setInitWeight(BigDecimal initWeight) {
        this.initWeight = initWeight;
    }

    public BigDecimal getInitQty() {
        return initQty;
    }

    public void setInitQty(BigDecimal initQty) {
        this.initQty = initQty;
    }
}
