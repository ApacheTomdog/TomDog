package com.brcc.business.ordercancel.vo;

import com.brcc.business.ordercancel.entity.DeliverycancelauditEntity;

/**
 * 描述:
 * 撤单审核管理查询返回封装类
 *
 * @author yushaohua
 * @create 2018-11-06 21:41
 */
public class OrderCancelVo extends DeliverycancelauditEntity {

    private String deliveryCancelTypeDesc;

    private String docuTypeDesc;

    public String getDeliveryCancelTypeDesc() {
        return deliveryCancelTypeDesc;
    }

    public void setDeliveryCancelTypeDesc(String deliveryCancelTypeDesc) {
        this.deliveryCancelTypeDesc = deliveryCancelTypeDesc;
    }

    public String getDocuTypeDesc() {
        return docuTypeDesc;
    }

    public void setDocuTypeDesc(String docuTypeDesc) {
        this.docuTypeDesc = docuTypeDesc;
    }
}