package com.brcc.business.weightUpload.vo;

import com.brcc.business.weightUpload.entity.UploadweightEntity;

/**
 * 描述:
 * 装卸货重量查询返回封装类
 *
 * @author yushaohua
 * @create 2018-11-28 16:16
 */
public class WeightUploadVo extends UploadweightEntity {

    private String companyName;

    private String statusDesc;

    private String userName;

    private Long companyId;

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}