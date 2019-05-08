package com.brcc.business.transportbill.vo;

import java.io.Serializable;
import java.math.BigDecimal;
/**|
 * 查看运费
 * @author panyinfang
 *
 */
public class CheckFreightVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal payAmount; // 应付运费
	private BigDecimal dumpTruckCharge;// 卸车费
	private BigDecimal transportationAmount;// 运杂费
	private BigDecimal deductAmount;// 亏吨扣除
	private BigDecimal settleWeight;// 结算重量
	private BigDecimal price;// 运费单价
	private BigDecimal goodPrice;// 货物单价
	private String lossType;
	private BigDecimal lossRatio;
	private BigDecimal lossWeight;// 合理路耗,
	private String lossTons;// 实际路耗
	private String receCompanyName;// 经纪人收款人
	private String receBankNum;// 经纪人银行卡号
	private String receBankName;// 经纪人银行姓名
	private BigDecimal payAmountAct;// 经纪人收款金额
	private BigDecimal oilAmount;// 油卡点数
	private String receCompanyName2;// 司机收款人
	private String receBankNum2;// 司机银行卡号
	private String receBankName2;// 司机银行姓名
	private BigDecimal payAmountAct2;// 司机收款金额
	
	
	public BigDecimal getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}
	public BigDecimal getDumpTruckCharge() {
		return dumpTruckCharge;
	}
	public void setDumpTruckCharge(BigDecimal dumpTruckCharge) {
		this.dumpTruckCharge = dumpTruckCharge;
	}
	public BigDecimal getTransportationAmount() {
		return transportationAmount;
	}
	public void setTransportationAmount(BigDecimal transportationAmount) {
		this.transportationAmount = transportationAmount;
	}
	public BigDecimal getDeductAmount() {
		return deductAmount;
	}
	public void setDeductAmount(BigDecimal deductAmount) {
		this.deductAmount = deductAmount;
	}
	public BigDecimal getSettleWeight() {
		return settleWeight;
	}
	public void setSettleWeight(BigDecimal settleWeight) {
		this.settleWeight = settleWeight;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getGoodPrice() {
		return goodPrice;
	}
	public void setGood_price(BigDecimal goodPrice) {
		this.goodPrice = goodPrice;
	}
	public String getLossType() {
		return lossType;
	}
	public void setLossType(String lossType) {
		this.lossType = lossType;
	}
	public BigDecimal getLossRatio() {
		return lossRatio;
	}
	public void setLossRatio(BigDecimal lossRatio) {
		this.lossRatio = lossRatio;
	}
	public BigDecimal getLossWeight() {
		return lossWeight;
	}
	public void setLossWeight(BigDecimal lossWeight) {
		this.lossWeight = lossWeight;
	}
	public String getLossTons() {
		return lossTons;
	}
	public void setLossTons(String lossTons) {
		this.lossTons = lossTons;
	}
	public String getReceCompanyName() {
		return receCompanyName;
	}
	public void setReceCompanyName(String receCompanyName) {
		this.receCompanyName = receCompanyName;
	}
	public String getReceBankNum() {
		return receBankNum;
	}
	public void setReceBankNum(String receBankNum) {
		this.receBankNum = receBankNum;
	}
	public String getReceBankName() {
		return receBankName;
	}
	public void setReceBankName(String receBankName) {
		this.receBankName = receBankName;
	}
	public BigDecimal getPayAmountAct() {
		return payAmountAct;
	}
	public void setPayAmountAct(BigDecimal payAmountAct) {
		this.payAmountAct = payAmountAct;
	}
	public BigDecimal getOilAmount() {
		return oilAmount;
	}
	public void setOilAmount(BigDecimal oilAmount) {
		this.oilAmount = oilAmount;
	}
	public String getReceCompanyName2() {
		return receCompanyName2;
	}
	public void setReceCompanyName2(String receCompanyName2) {
		this.receCompanyName2 = receCompanyName2;
	}
	public String getReceBankNum2() {
		return receBankNum2;
	}
	public void setReceBankNum2(String receBankNum2) {
		this.receBankNum2 = receBankNum2;
	}
	public String getReceBankName2() {
		return receBankName2;
	}
	public void setReceBankName2(String receBankName2) {
		this.receBankName2 = receBankName2;
	}
	public BigDecimal getPayAmountAct2() {
		return payAmountAct2;
	}
	public void setPayAmountAct2(BigDecimal payAmountAct2) {
		this.payAmountAct2 = payAmountAct2;
	}
	
	

}
