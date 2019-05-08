package com.brcc.business.transorder.vo;

import com.esteel.common.vo.BaseQueryVo;

import java.util.Date;

/**
 * 描述:
 * 平台运输单详情查询封装类
 *
 * @author yushaohua
 * @create 2018-10-31 16:26
 */
public class TransOrderDetailSearchVo extends BaseQueryVo {

    private String platformId;

    private String companyId;

    private String publishId;

    private String orderTaxDetail;

    private String type;

    private String orderId;

    private String publishIdD;

    public String getPublishIdD() {
        return publishIdD;
    }

    public void setPublishIdD(String publishIdD) {
        this.publishIdD = publishIdD;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getPublishId() {
        return publishId;
    }

    public void setPublishId(String publishId) {
        this.publishId = publishId;
    }

    public String getOrderTaxDetail() {
        return orderTaxDetail;
    }

    public void setOrderTaxDetail(String orderTaxDetail) {
        this.orderTaxDetail = orderTaxDetail;
    }
}