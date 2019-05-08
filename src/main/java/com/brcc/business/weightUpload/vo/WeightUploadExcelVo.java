package com.brcc.business.weightUpload.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述:
 * 装卸货导入封装类
 *
 * @author yushaohua
 * @create 2018-11-30 16:50
 */
public class WeightUploadExcelVo {

    private Long deliveryId;

    private BigDecimal deliveryWeight;

    private Date deliveryIdDate;

    private BigDecimal finishWeight;

    private Date finishDate;

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public BigDecimal getDeliveryWeight() {
        return deliveryWeight;
    }

    public void setDeliveryWeight(BigDecimal deliveryWeight) {
        this.deliveryWeight = deliveryWeight;
    }

    public Date getDeliveryIdDate() {
        return deliveryIdDate;
    }

    public void setDeliveryIdDate(Date deliveryIdDate) {
        this.deliveryIdDate = deliveryIdDate;
    }

    public BigDecimal getFinishWeight() {
        return finishWeight;
    }

    public void setFinishWeight(BigDecimal finishWeight) {
        this.finishWeight = finishWeight;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }
}