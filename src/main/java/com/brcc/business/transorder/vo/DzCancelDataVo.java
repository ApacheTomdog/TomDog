package com.brcc.business.transorder.vo;

import com.brcc.business.transorder.entity.TransportationdeliveryEntity;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2018-11-11 13:19
 */
public class DzCancelDataVo extends TransportationdeliveryEntity {

    private String docuType;

    private String ret1;

    private String ret2;

    private String ret3;

    private String ret4;

    private String ret5;

    private String jkCount;

    private String fromType;

    private String estimateKM;

    public String getFromType() {
        return fromType;
    }

    public void setFromType(String fromType) {
        this.fromType = fromType;
    }

    public String getEstimateKM() {
        return estimateKM;
    }

    public void setEstimateKM(String estimateKM) {
        this.estimateKM = estimateKM;
    }

    public String getJkCount() {
        return jkCount;
    }

    public void setJkCount(String jkCount) {
        this.jkCount = jkCount;
    }

    public String getDocuType() {
        return docuType;
    }

    public void setDocuType(String docuType) {
        this.docuType = docuType;
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