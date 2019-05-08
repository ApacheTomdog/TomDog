package com.brcc.business.transorder.vo;

import com.brcc.business.transorder.entity.ViewAbnormalEntity;

/**
 * 描述:
 * 平台调度单异常列表数据返回封装类
 *
 * @author yushaohua
 * @create 2018-11-14 16:39
 */
public class ViewAbnormalVo extends ViewAbnormalEntity {

    private String billCompanyName;

    private String transCompanyName;

    private String name;

    private String idNum;

    private String vehicleNum;

    private String docOrigin;

    private String shWeight;

    private String zcWeight;

    private String contactName;

    private String contactMobile;

    private String phone;

    private String ifTaxTransport;

    public String getBillCompanyName() {
        return billCompanyName;
    }

    public void setBillCompanyName(String billCompanyName) {
        this.billCompanyName = billCompanyName;
    }

    public String getTransCompanyName() {
        return transCompanyName;
    }

    public void setTransCompanyName(String transCompanyName) {
        this.transCompanyName = transCompanyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public String getDocOrigin() {
        return docOrigin;
    }

    public void setDocOrigin(String docOrigin) {
        this.docOrigin = docOrigin;
    }

    public String getShWeight() {
        return shWeight;
    }

    public void setShWeight(String shWeight) {
        this.shWeight = shWeight;
    }

    public String getZcWeight() {
        return zcWeight;
    }

    public void setZcWeight(String zcWeight) {
        this.zcWeight = zcWeight;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String getIfTaxTransport() {
        return ifTaxTransport;
    }

    @Override
    public void setIfTaxTransport(String ifTaxTransport) {
        this.ifTaxTransport = ifTaxTransport;
    }
}