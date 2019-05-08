package com.brcc.business.dispatchorder.vo;

import com.brcc.business.dispatchorder.entity.DriverEntity;

/**
 * 描述:
 * 司机查询结果封装类
 *
 * @author yushaohua
 * @create 2018-12-04 15:58
 */
public class DriverVo extends DriverEntity {

    private String info;

    private String ifRed;

    public String getIfRed() {
        return ifRed;
    }

    public void setIfRed(String ifRed) {
        this.ifRed = ifRed;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}