package com.brcc.business.brokerFunds.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.brcc.business.brokerFunds.entity.BrokerfundscontroldetailEntity;

/**
 * @Description 经纪人资金流水查询明细接收类
 * @Author pjy
 * @Date 2018/12/27
 **/
public class BrokerFundsDetailVo extends BrokerfundscontroldetailEntity {
	
	private String zfNum; //计算单号
	private BigDecimal weight;
	private BigDecimal truckLoadingWeight;
	private BigDecimal takeDeliveryWeight;
	private BigDecimal settleWeight;
	private BigDecimal goodPrice;
	private String lossType;
	private BigDecimal lossWeight;
	private BigDecimal lossRatio;
	private BigDecimal price;
	private BigDecimal payAmount;
	private String brokerPeopleTollType;
	private BigDecimal brokerPeopleTollAmount;
	private BigDecimal brokerPeopleTollRatio;
	private String fundsPic;
	private String fundsPicSec;
	private String fundsPicThi;
    private String fundsControlDetailIdStr;
	private String contactMobile;
	private String payBillNum;
	private BigDecimal payJjrAmount;
	private BigDecimal payCarryMinAmt;
	private String getOrderPlate;
	private String dependNum;
	private String masterStatus;
	//经纪人公司名字
	private String companyName;
	private String receBankOwner;
	private String receBankNum;
	private Date payFinishDate;
	private Integer companyOwnerId;

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public BigDecimal getTruckLoadingWeight() {
		return truckLoadingWeight;
	}

	public void setTruckLoadingWeight(BigDecimal truckLoadingWeight) {
		this.truckLoadingWeight = truckLoadingWeight;
	}

	public BigDecimal getTakeDeliveryWeight() {
		return takeDeliveryWeight;
	}

	public void setTakeDeliveryWeight(BigDecimal takeDeliveryWeight) {
		this.takeDeliveryWeight = takeDeliveryWeight;
	}

	public BigDecimal getSettleWeight() {
		return settleWeight;
	}

	public void setSettleWeight(BigDecimal settleWeight) {
		this.settleWeight = settleWeight;
	}

	public BigDecimal getGoodPrice() {
		return goodPrice;
	}

	public void setGoodPrice(BigDecimal goodPrice) {
		this.goodPrice = goodPrice;
	}

	public String getLossType() {
		return lossType;
	}

	public void setLossType(String lossType) {
		this.lossType = lossType;
	}

	public BigDecimal getLossWeight() {
		return lossWeight;
	}

	public void setLossWeight(BigDecimal lossWeight) {
		this.lossWeight = lossWeight;
	}

	public BigDecimal getLossRatio() {
		return lossRatio;
	}

	public void setLossRatio(BigDecimal lossRatio) {
		this.lossRatio = lossRatio;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	public String getBrokerPeopleTollType() {
		return brokerPeopleTollType;
	}

	public void setBrokerPeopleTollType(String brokerPeopleTollType) {
		this.brokerPeopleTollType = brokerPeopleTollType;
	}

	public BigDecimal getBrokerPeopleTollAmount() {
		return brokerPeopleTollAmount;
	}

	public void setBrokerPeopleTollAmount(BigDecimal brokerPeopleTollAmount) {
		this.brokerPeopleTollAmount = brokerPeopleTollAmount;
	}

	public BigDecimal getBrokerPeopleTollRatio() {
		return brokerPeopleTollRatio;
	}

	public void setBrokerPeopleTollRatio(BigDecimal brokerPeopleTollRatio) {
		this.brokerPeopleTollRatio = brokerPeopleTollRatio;
	}


	public String getFundsPic() {
		return fundsPic;
	}

	public void setFundsPic(String fundsPic) {
		this.fundsPic = fundsPic;
	}

	public String getFundsPicSec() {
		return fundsPicSec;
	}

	public void setFundsPicSec(String fundsPicSec) {
		this.fundsPicSec = fundsPicSec;
	}

	public String getFundsPicThi() {
		return fundsPicThi;
	}

	public void setFundsPicThi(String fundsPicThi) {
		this.fundsPicThi = fundsPicThi;
	}


	public String getZfNum() {
		return zfNum;
	}

	public void setZfNum(String zfNum) {
		this.zfNum = zfNum;
	}


	public String getContactMobile() {
		return contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public String getPayBillNum() {
		return payBillNum;
	}

	public void setPayBillNum(String payBillNum) {
		this.payBillNum = payBillNum;
	}

	public BigDecimal getPayJjrAmount() {
		return payJjrAmount;
	}

	public void setPayJjrAmount(BigDecimal payJjrAmount) {
		this.payJjrAmount = payJjrAmount;
	}

	public BigDecimal getPayCarryMinAmt() {
		return payCarryMinAmt;
	}

	public void setPayCarryMinAmt(BigDecimal payCarryMinAmt) {
		this.payCarryMinAmt = payCarryMinAmt;
	}

	public String getGetOrderPlate() {
		return getOrderPlate;
	}

	public void setGetOrderPlate(String getOrderPlate) {
		this.getOrderPlate = getOrderPlate;
	}

    public String getDependNum() {
        return dependNum;
    }
    public void setDependNum(String dependNum) {
        this.dependNum = dependNum;
    }

	public String getMasterStatus() {
		return masterStatus;
	}

	public String getFundsControlDetailIdStr() {
		return fundsControlDetailIdStr;
	}

	public void setFundsControlDetailIdStr(String fundsControlDetailIdStr) {
		this.fundsControlDetailIdStr = fundsControlDetailIdStr;
	}

	public void setMasterStatus(String masterStatus) {
		this.masterStatus = masterStatus;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getReceBankOwner() {
		return receBankOwner;
	}

	public void setReceBankOwner(String receBankOwner) {
		this.receBankOwner = receBankOwner;
	}

	public String getReceBankNum() {
		return receBankNum;
	}

	public Date getPayFinishDate() {
		return payFinishDate;
	}

	public void setPayFinishDate(Date payFinishDate) {
		this.payFinishDate = payFinishDate;
	}

	public Integer getCompanyOwnerId() {
		return companyOwnerId;
	}

	public void setCompanyOwnerId(Integer companyOwnerId) {
		this.companyOwnerId = companyOwnerId;
	}

	public void setReceBankNum(String receBankNum) {
		this.receBankNum = receBankNum;
	}
}
