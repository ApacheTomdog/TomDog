package com.brcc.business.dispatchorder.vo;

/**
 * 描述:
 * 川威调度单下发查询VO
 *
 * @author chk
 * @create 2018-04-23 15:58
 */
public class CWDispatchDeliveryDetailQueryVo {

    private String platformId;

    private String dsPlatName;

    private String dsPlatJk;

    private String pinDanNum;


    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getDsPlatName() {
        return dsPlatName;
    }

    public void setDsPlatName(String dsPlatName) {
        this.dsPlatName = dsPlatName;
    }

    public String getDsPlatJk() {
        return dsPlatJk;
    }

    public void setDsPlatJk(String dsPlatJk) {
        this.dsPlatJk = dsPlatJk;
    }

    public String getPinDanNum() {
        return pinDanNum;
    }

    public void setPinDanNum(String pinDanNum) {
        this.pinDanNum = pinDanNum;
    }
}