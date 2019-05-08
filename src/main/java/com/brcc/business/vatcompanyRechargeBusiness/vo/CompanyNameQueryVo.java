package com.brcc.business.vatcompanyRechargeBusiness.vo;

import java.math.BigDecimal;

/**
 * @Description:
 * @Auther: gemaochao
 * @Date:Created in 15:26 2018/11/14
 */
public class CompanyNameQueryVo {

    private Long id;

    private Long clientId;

    private String clientName;

    private String businessNum;

    private Long carryId;

    private String carryName;

    private BigDecimal surplusAmount;

    private String createRemark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusinessNum() {
        return businessNum;
    }

    public void setBusinessNum(String businessNum) {
        this.businessNum = businessNum;
    }

    public String getCarryName() {
        return carryName;
    }

    public void setCarryName(String carryName) {
        this.carryName = carryName;
    }

    public BigDecimal getSurplusAmount() {
        return surplusAmount;
    }

    public void setSurplusAmount(BigDecimal surplusAmount) {
        this.surplusAmount = surplusAmount;
    }

    public String getCreateRemark() {
        return createRemark;
    }

    public void setCreateRemark(String createRemark) {
        this.createRemark = createRemark;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Long getCarryId() {
        return carryId;
    }

    public void setCarryId(Long carryId) {
        this.carryId = carryId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
