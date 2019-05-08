package com.brcc.business.brokerFunds.vo;

import com.esteel.common.vo.BaseQueryVo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description 查询调度单信息
 * @Author pjy
 * @Date
 **/
public class BrokerFundsDetailQueryVo extends BaseQueryVo {
    private Long fundsControlMasterId;

    private Long deliveryId;

    private Long publishId;
    
    private Long transId;

    private String goodTypeDesc;

    private String vehicleNum;

    private String driverName;

    private String driverPhone;

    private String publishCompanyName;

    private String startPlate;

    private String endPlate;

    private Date rqStart;

    private Date rqEnd;

    private String platformId;

    private Long companyId;

    private String deliveryIdStr;

    private String payBillIdStr;

    private Long userId;

    private String userName;

    private String fundsControlDetailIdStr;

    private Long fundsControlDetailId;
    
    private String detailStatus;   //审核状态

    private Date secondAuditDateStart;

    private Date secondAuditDateEnd;

    private Date firstAuditDateStart;

    private Date firstAuditDateEnd;

    private String payBillNum;//结算单号

    private String  dependNum;

    private Date qdRqStart;
    private Date qdRqEnd;

    private String receBankOwner;

    private Date payStart;
    private Date payEnd;
    private String brokerTaxCycleName;
	public Date getSecondAuditDateStart() {
		return secondAuditDateStart;
	}

	public void setSecondAuditDateStart(Date secondAuditDateStart) {
		this.secondAuditDateStart = secondAuditDateStart;
	}

	public Date getSecondAuditDateEnd() {
		return secondAuditDateEnd;
	}

	public void setSecondAuditDateEnd(Date secondAuditDateEnd) {
		this.secondAuditDateEnd = secondAuditDateEnd;
	}

	public Date getFirstAuditDateStart() {
		return firstAuditDateStart;
	}

	public void setFirstAuditDateStart(Date firstAuditDateStart) {
		this.firstAuditDateStart = firstAuditDateStart;
	}

	public Date getFirstAuditDateEnd() {
		return firstAuditDateEnd;
	}

	public void setFirstAuditDateEnd(Date firstAuditDateEnd) {
		this.firstAuditDateEnd = firstAuditDateEnd;
	}

	public String getDetailStatus() {
		return detailStatus;
	}

	public void setDetailStatus(String detailStatus) {
		this.detailStatus = detailStatus;
	}

    public Long getTransId() {
		return transId;
	}

	public void setTransId(Long transId) {
		this.transId = transId;
	}

	public Long getFundsControlMasterId() {
        return fundsControlMasterId;
    }

    public void setFundsControlMasterId(Long fundsControlMasterId) {
        this.fundsControlMasterId = fundsControlMasterId;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Long getPublishId() {
        return publishId;
    }

    public void setPublishId(Long publishId) {
        this.publishId = publishId;
    }

    public Long getFundsControlDetailId() {
        return fundsControlDetailId;
    }

    public void setFundsControlDetailId(Long fundsControlDetailId) {
        this.fundsControlDetailId = fundsControlDetailId;
    }

    public String getGoodTypeDesc() {
        return goodTypeDesc;
    }

    public void setGoodTypeDesc(String goodTypeDesc) {
        this.goodTypeDesc = goodTypeDesc;
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getPublishCompanyName() {
        return publishCompanyName;
    }

    public void setPublishCompanyName(String publishCompanyName) {
        this.publishCompanyName = publishCompanyName;
    }

    public String getStartPlate() {
        return startPlate;
    }

    public void setStartPlate(String startPlate) {
        this.startPlate = startPlate;
    }

    public String getEndPlate() {
        return endPlate;
    }

    public void setEndPlate(String endPlate) {
        this.endPlate = endPlate;
    }

    public Date getRqStart() {
        return rqStart;
    }

    public void setRqStart(Date rqStart) {
        this.rqStart = rqStart;
    }

    public Date getRqEnd() {
        return rqEnd;
    }

    public void setRqEnd(Date rqEnd) {
        this.rqEnd = rqEnd;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getDeliveryIdStr() {
        return deliveryIdStr;
    }

    public void setDeliveryIdStr(String deliveryIdStr) {
        this.deliveryIdStr = deliveryIdStr;
    }

    public String getPayBillIdStr() {
        return payBillIdStr;
    }

    public void setPayBillIdStr(String payBillIdStr) {
        this.payBillIdStr = payBillIdStr;
    }

    public Long getUserId() {
        return userId;
    }

    public String getPayBillNum() {
        return payBillNum;
    }

    public void setPayBillNum(String payBillNum) {
        this.payBillNum = payBillNum;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getFundsControlDetailIdStr() {
        return fundsControlDetailIdStr;
    }

    public void setFundsControlDetailIdStr(String fundsControlDetailIdStr) {
        this.fundsControlDetailIdStr = fundsControlDetailIdStr;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDependNum() {
        return dependNum;
    }

    public void setDependNum(String dependNum) {
        this.dependNum = dependNum;
    }

    public Date getQdRqStart() {
        return qdRqStart;
    }

    public void setQdRqStart(Date qdRqStart) {
        this.qdRqStart = qdRqStart;
    }

    public Date getQdRqEnd() {
        return qdRqEnd;
    }

    public void setQdRqEnd(Date qdRqEnd) {
        this.qdRqEnd = qdRqEnd;
    }

    public String getReceBankOwner() {
        return receBankOwner;
    }

    public Date getPayStart() {
        return payStart;
    }

    public void setPayStart(Date payStart) {
        this.payStart = payStart;
    }

    public Date getPayEnd() {
        return payEnd;
    }

    public void setPayEnd(Date payEnd) {
        this.payEnd = payEnd;
    }

    public void setReceBankOwner(String receBankOwner) {
        this.receBankOwner = receBankOwner;
    }

    public String getBrokerTaxCycleName() {
        return brokerTaxCycleName;
    }

    public void setBrokerTaxCycleName(String brokerTaxCycleName) {
        this.brokerTaxCycleName = brokerTaxCycleName;
    }
}
