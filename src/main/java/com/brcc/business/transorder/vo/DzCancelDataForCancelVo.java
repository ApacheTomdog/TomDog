package com.brcc.business.transorder.vo;

import com.brcc.business.transorder.entity.TransportationdeliveryEntity;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2018-11-11 13:19
 */
public class DzCancelDataForCancelVo {

    private String publish_id;

    private Long delivery_id;

    private String delivery_num;

    private String docu_type;

    private String ret1;

    private String ret2;

    private String ret3;

    private String ret4;

    private String ret5;

    public String getPublish_id() {
        return publish_id;
    }

    public void setPublish_id(String publish_id) {
        this.publish_id = publish_id;
    }

    public Long getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(Long delivery_id) {
        this.delivery_id = delivery_id;
    }

    public String getDelivery_num() {
        return delivery_num;
    }

    public void setDelivery_num(String delivery_num) {
        this.delivery_num = delivery_num;
    }

    public String getDocu_type() {
        return docu_type;
    }

    public void setDocu_type(String docu_type) {
        this.docu_type = docu_type;
    }

    public String getRet1() {
        return ret1;
    }

    public void setRet1(String ret1) {
        this.ret1 = ret1;
    }

    public String getRet2() {
        return ret2;
    }

    public void setRet2(String ret2) {
        this.ret2 = ret2;
    }

    public String getRet3() {
        return ret3;
    }

    public void setRet3(String ret3) {
        this.ret3 = ret3;
    }

    public String getRet4() {
        return ret4;
    }

    public void setRet4(String ret4) {
        this.ret4 = ret4;
    }

    public String getRet5() {
        return ret5;
    }

    public void setRet5(String ret5) {
        this.ret5 = ret5;
    }
}