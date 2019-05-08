package com.brcc.business.transportSettle.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the pay_bill database table. 结算单实体类
 */
@Entity
@Table(name = "pay_bill")
@DynamicInsert
@DynamicUpdate
@NamedQuery(name = "PayBillEntity.findAll", query = "SELECT p FROM PayBillEntity p")
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "pro_paybill_batch_calc", procedureName = "apptms.pro_paybill_batch_calc", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "asBatchId", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "asOutResult", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "asOutResultReason", type = String.class)
	})
})
public class PayBillEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "zf_id")
	private Long zfId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "account_check_modify_date")
	private Date accountCheckModifyDate;

	@Column(name = "account_check_modify_person_id")
	private String accountCheckModifyPersonId;

	@Column(name = "account_check_modify_person_name")
	private String accountCheckModifyPersonName;

	@Column(name = "bill_sender")
	private String billSender;

	@Column(name = "charge_amount")
	private BigDecimal chargeAmount;

	@Column(name = "charge_price")
	private BigDecimal chargePrice;

	@Column(name = "charge_price_type")
	private String chargePriceType;

	@Column(name = "company_id")
	private Long companyId;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "create_company_id")
	private Long createCompanyId;

	@Column(name = "create_company_name")
	private String createCompanyName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate;

	@Column(name = "create_person")
	private Long createPerson;

	@Column(name = "deduct_amount")
	private BigDecimal deductAmount;

	@Column(name = "delivery_id")
	private Long deliveryId;

	@Column(name = "delivery_num")
	private String deliveryNum;

	@Column(name = "driver_id")
	private Long driverId;

	@Column(name = "driver_name")
	private String driverName;

	@Column(name = "dump_truck_charge")
	private BigDecimal dumpTruckCharge;

	@Column(name = "end_plate")
	private String endPlate;

	@Column(name = "erase_amount")
	private BigDecimal eraseAmount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "finish_time")
	private Date finishTime;

	@Column(name = "good_price")
	private BigDecimal goodPrice;

	@Column(name = "good_type")
	private String goodType;

	@Column(name = "good_type_desc")
	private String goodTypeDesc;

	@Column(name = "good_type_name")
	private String goodTypeName;

	@Column(name = "group_id")
	private Long groupId;

	@Column(name = "group_name")
	private String groupName;

	@Column(name = "if_account_check")
	private String ifAccountCheck;

	@Column(name = "if_broker_people_toll_flag")
	private String ifBrokerPeopleTollFlag;

	@Column(name = "if_invoice")
	private String ifInvoice;

	@Column(name = "if_owner_taxprice_mf")
	private String ifOwnerTaxpriceMf;

	@Column(name = "if_tax_transport")
	private String ifTaxTransport;

//	@Column(name = "if_virtual")
//	private String ifVirtual;

	@Column(name = "js_type")
	private String jsType;

	@Column(name = "loss_ratio")
	private BigDecimal lossRatio;

	@Column(name = "loss_tons")
	private BigDecimal lossTons;

	@Column(name = "loss_type")
	private String lossType;

	@Column(name = "loss_weight")
	private BigDecimal lossWeight;

	@Column(name = "oil_amount")
	private BigDecimal oilAmount;

	@Column(name = "oil_flag")
	private String oilFlag;

	@Column(name = "oil_ratio")
	private BigDecimal oilRatio;

	@Column(name = "owner_adjust_amt")
	private BigDecimal ownerAdjustAmt;

	@Column(name = "owner_adjust_flag")
	private String ownerAdjustFlag;

	@Column(name = "owner_adjust_tot_amt")
	private BigDecimal ownerAdjustTotAmt;

	@Column(name = "owner_adjust_type")
	private String ownerAdjustType;

	@Column(name = "owner_payapply_cancel_flag")
	private String ownerPayapplyCancelFlag;

	@Column(name = "owner_payapply_flag")
	private String ownerPayapplyFlag;

	@Column(name = "pay_amount")
	private BigDecimal payAmount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "pay_date")
	private Date payDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "pay_finish_date")
	private Date payFinishDate;

	@Column(name = "pay_person")
	private String payPerson;

	private BigDecimal price;

	@Column(name = "price_tax")
	private BigDecimal priceTax;

	@Column(name = "publish_company_id")
	private Long publishCompanyId;

	@Column(name = "publish_company_name")
	private String publishCompanyName;

	@Column(name = "publish_id")
	private Long publishId;

	@Column(name = "publish_num")
	private String publishNum;

	@Column(name = "rece_bank_type")
	private String receBankType;

	private String remark;

	private String sender;

	@Column(name = "settle_weight")
	private BigDecimal settleWeight;

	@Column(name = "standard_tax")
	private BigDecimal standardTax;

	@Column(name = "start_plate")
	private String startPlate;

	private String status;

	@Column(name = "take_delivery_weight")
	private BigDecimal takeDeliveryWeight;

	@Column(name = "trans_id")
	private Long transId;

	@Column(name = "trans_num")
	private String transNum;

	@Column(name = "transportation_amount")
	private BigDecimal transportationAmount;

	private String transportationm;

	@Column(name = "truck_loading_weight")
	private BigDecimal truckLoadingWeight;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date")
	private Date updateDate;

	@Column(name = "update_person")
	private Long updatePerson;

	@Column(name = "vat_flow_master_id")
	private Long vatFlowMasterId;

	@Column(name = "vehicle_id")
	private Long vehicleId;

	@Column(name = "vehicle_num")
	private String vehicleNum;

	@Column(name = "vice_business_flag")
	private String viceBusinessFlag;

	@Column(name = "vice_business_reason")
	private String viceBusinessReason;

	@Column(name = "zf_num")
	private String zfNum;
	
	@Column(name = "platform_id")
	private String platformId;
	
	@Column(name = "owner_capital_adjust")
	private BigDecimal ownerCapitalAdjust;
	
	@Column(name = "owner_pay_amount")
	private BigDecimal ownerPayAmount;
	
	@Column(name = "business_memo")
	private String businessMemo;

	@Column(name = "pay_carry_min_amt")
	private BigDecimal payCarryMinAmt;
	
	@Column(name = "batch_flag")
	private Long batchFlag;
	
	public PayBillEntity() {
	}

	public Long getBatchFlag() {
		return batchFlag;
	}

	public void setBatchFlag(Long batchFlag) {
		this.batchFlag = batchFlag;
	}

	public Long getZfId() {
		return zfId;
	}

	public void setZfId(Long zfId) {
		this.zfId = zfId;
	}

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public Date getAccountCheckModifyDate() {
		return accountCheckModifyDate;
	}

	public void setAccountCheckModifyDate(Date accountCheckModifyDate) {
		this.accountCheckModifyDate = accountCheckModifyDate;
	}

	public String getAccountCheckModifyPersonId() {
		return accountCheckModifyPersonId;
	}

	public void setAccountCheckModifyPersonId(String accountCheckModifyPersonId) {
		this.accountCheckModifyPersonId = accountCheckModifyPersonId;
	}

	public String getAccountCheckModifyPersonName() {
		return accountCheckModifyPersonName;
	}

	public void setAccountCheckModifyPersonName(String accountCheckModifyPersonName) {
		this.accountCheckModifyPersonName = accountCheckModifyPersonName;
	}

	public String getBillSender() {
		return billSender;
	}

	public void setBillSender(String billSender) {
		this.billSender = billSender;
	}

	public BigDecimal getChargeAmount() {
		return chargeAmount;
	}

	public void setChargeAmount(BigDecimal chargeAmount) {
		this.chargeAmount = chargeAmount;
	}

	public BigDecimal getChargePrice() {
		return chargePrice;
	}

	public void setChargePrice(BigDecimal chargePrice) {
		this.chargePrice = chargePrice;
	}

	public String getChargePriceType() {
		return chargePriceType;
	}

	public void setChargePriceType(String chargePriceType) {
		this.chargePriceType = chargePriceType;
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

	public Long getCreateCompanyId() {
		return createCompanyId;
	}

	public void setCreateCompanyId(Long createCompanyId) {
		this.createCompanyId = createCompanyId;
	}

	public String getCreateCompanyName() {
		return createCompanyName;
	}

	public void setCreateCompanyName(String createCompanyName) {
		this.createCompanyName = createCompanyName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getCreatePerson() {
		return createPerson;
	}

	public void setCreatePerson(Long createPerson) {
		this.createPerson = createPerson;
	}

	public BigDecimal getDeductAmount() {
		return deductAmount;
	}

	public void setDeductAmount(BigDecimal deductAmount) {
		this.deductAmount = deductAmount;
	}

	public Long getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}

	public String getDeliveryNum() {
		return deliveryNum;
	}

	public void setDeliveryNum(String deliveryNum) {
		this.deliveryNum = deliveryNum;
	}

	public Long getDriverId() {
		return driverId;
	}

	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public BigDecimal getDumpTruckCharge() {
		return dumpTruckCharge;
	}

	public void setDumpTruckCharge(BigDecimal dumpTruckCharge) {
		this.dumpTruckCharge = dumpTruckCharge;
	}

	public String getEndPlate() {
		return endPlate;
	}

	public void setEndPlate(String endPlate) {
		this.endPlate = endPlate;
	}

	public BigDecimal getEraseAmount() {
		return eraseAmount;
	}

	public void setEraseAmount(BigDecimal eraseAmount) {
		this.eraseAmount = eraseAmount;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public BigDecimal getGoodPrice() {
		return goodPrice;
	}

	public void setGoodPrice(BigDecimal goodPrice) {
		this.goodPrice = goodPrice;
	}

	public String getGoodType() {
		return goodType;
	}

	public void setGoodType(String goodType) {
		this.goodType = goodType;
	}

	public String getGoodTypeDesc() {
		return goodTypeDesc;
	}

	public void setGoodTypeDesc(String goodTypeDesc) {
		this.goodTypeDesc = goodTypeDesc;
	}

	public String getGoodTypeName() {
		return goodTypeName;
	}

	public void setGoodTypeName(String goodTypeName) {
		this.goodTypeName = goodTypeName;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getIfAccountCheck() {
		return ifAccountCheck;
	}

	public void setIfAccountCheck(String ifAccountCheck) {
		this.ifAccountCheck = ifAccountCheck;
	}

	public String getIfBrokerPeopleTollFlag() {
		return ifBrokerPeopleTollFlag;
	}

	public void setIfBrokerPeopleTollFlag(String ifBrokerPeopleTollFlag) {
		this.ifBrokerPeopleTollFlag = ifBrokerPeopleTollFlag;
	}

	public String getIfInvoice() {
		return ifInvoice;
	}

	public void setIfInvoice(String ifInvoice) {
		this.ifInvoice = ifInvoice;
	}

	public String getIfOwnerTaxpriceMf() {
		return ifOwnerTaxpriceMf;
	}

	public void setIfOwnerTaxpriceMf(String ifOwnerTaxpriceMf) {
		this.ifOwnerTaxpriceMf = ifOwnerTaxpriceMf;
	}

	public String getIfTaxTransport() {
		return ifTaxTransport;
	}

	public void setIfTaxTransport(String ifTaxTransport) {
		this.ifTaxTransport = ifTaxTransport;
	}

//	public String getIfVirtual() {
//		return ifVirtual;
//	}
//
//	public void setIfVirtual(String ifVirtual) {
//		this.ifVirtual = ifVirtual;
//	}

	public String getJsType() {
		return jsType;
	}

	public void setJsType(String jsType) {
		this.jsType = jsType;
	}

	public BigDecimal getLossRatio() {
		return lossRatio;
	}

	public void setLossRatio(BigDecimal lossRatio) {
		this.lossRatio = lossRatio;
	}

	public BigDecimal getLossTons() {
		return lossTons;
	}

	public void setLossTons(BigDecimal lossTons) {
		this.lossTons = lossTons;
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

	public BigDecimal getOilAmount() {
		return oilAmount;
	}

	public void setOilAmount(BigDecimal oilAmount) {
		this.oilAmount = oilAmount;
	}

	public String getOilFlag() {
		return oilFlag;
	}

	public void setOilFlag(String oilFlag) {
		this.oilFlag = oilFlag;
	}

	public BigDecimal getOilRatio() {
		return oilRatio;
	}

	public void setOilRatio(BigDecimal oilRatio) {
		this.oilRatio = oilRatio;
	}

	public BigDecimal getOwnerAdjustAmt() {
		return ownerAdjustAmt;
	}

	public void setOwnerAdjustAmt(BigDecimal ownerAdjustAmt) {
		this.ownerAdjustAmt = ownerAdjustAmt;
	}

	public String getOwnerAdjustFlag() {
		return ownerAdjustFlag;
	}

	public void setOwnerAdjustFlag(String ownerAdjustFlag) {
		this.ownerAdjustFlag = ownerAdjustFlag;
	}

	public BigDecimal getOwnerAdjustTotAmt() {
		return ownerAdjustTotAmt;
	}

	public void setOwnerAdjustTotAmt(BigDecimal ownerAdjustTotAmt) {
		this.ownerAdjustTotAmt = ownerAdjustTotAmt;
	}

	public String getOwnerAdjustType() {
		return ownerAdjustType;
	}

	public void setOwnerAdjustType(String ownerAdjustType) {
		this.ownerAdjustType = ownerAdjustType;
	}

	public String getOwnerPayapplyCancelFlag() {
		return ownerPayapplyCancelFlag;
	}

	public void setOwnerPayapplyCancelFlag(String ownerPayapplyCancelFlag) {
		this.ownerPayapplyCancelFlag = ownerPayapplyCancelFlag;
	}

	public String getOwnerPayapplyFlag() {
		return ownerPayapplyFlag;
	}

	public void setOwnerPayapplyFlag(String ownerPayapplyFlag) {
		this.ownerPayapplyFlag = ownerPayapplyFlag;
	}

	public BigDecimal getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public Date getPayFinishDate() {
		return payFinishDate;
	}

	public void setPayFinishDate(Date payFinishDate) {
		this.payFinishDate = payFinishDate;
	}

	public String getPayPerson() {
		return payPerson;
	}

	public void setPayPerson(String payPerson) {
		this.payPerson = payPerson;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPriceTax() {
		return priceTax;
	}

	public void setPriceTax(BigDecimal priceTax) {
		this.priceTax = priceTax;
	}

	public Long getPublishCompanyId() {
		return publishCompanyId;
	}

	public void setPublishCompanyId(Long publishCompanyId) {
		this.publishCompanyId = publishCompanyId;
	}

	public String getPublishCompanyName() {
		return publishCompanyName;
	}

	public void setPublishCompanyName(String publishCompanyName) {
		this.publishCompanyName = publishCompanyName;
	}

	public Long getPublishId() {
		return publishId;
	}

	public void setPublishId(Long publishId) {
		this.publishId = publishId;
	}

	public String getPublishNum() {
		return publishNum;
	}

	public void setPublishNum(String publishNum) {
		this.publishNum = publishNum;
	}

	public String getReceBankType() {
		return receBankType;
	}

	public void setReceBankType(String receBankType) {
		this.receBankType = receBankType;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public BigDecimal getSettleWeight() {
		return settleWeight;
	}

	public void setSettleWeight(BigDecimal settleWeight) {
		this.settleWeight = settleWeight;
	}

	public BigDecimal getStandardTax() {
		return standardTax;
	}

	public void setStandardTax(BigDecimal standardTax) {
		this.standardTax = standardTax;
	}

	public String getStartPlate() {
		return startPlate;
	}

	public void setStartPlate(String startPlate) {
		this.startPlate = startPlate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getTakeDeliveryWeight() {
		return takeDeliveryWeight;
	}

	public void setTakeDeliveryWeight(BigDecimal takeDeliveryWeight) {
		this.takeDeliveryWeight = takeDeliveryWeight;
	}

	public Long getTransId() {
		return transId;
	}

	public void setTransId(Long transId) {
		this.transId = transId;
	}

	public String getTransNum() {
		return transNum;
	}

	public void setTransNum(String transNum) {
		this.transNum = transNum;
	}

	public BigDecimal getTransportationAmount() {
		return transportationAmount;
	}

	public void setTransportationAmount(BigDecimal transportationAmount) {
		this.transportationAmount = transportationAmount;
	}

	public String getTransportationm() {
		return transportationm;
	}

	public void setTransportationm(String transportationm) {
		this.transportationm = transportationm;
	}

	public BigDecimal getTruckLoadingWeight() {
		return truckLoadingWeight;
	}

	public void setTruckLoadingWeight(BigDecimal truckLoadingWeight) {
		this.truckLoadingWeight = truckLoadingWeight;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Long getUpdatePerson() {
		return updatePerson;
	}

	public void setUpdatePerson(Long updatePerson) {
		this.updatePerson = updatePerson;
	}

	public Long getVatFlowMasterId() {
		return vatFlowMasterId;
	}

	public void setVatFlowMasterId(Long vatFlowMasterId) {
		this.vatFlowMasterId = vatFlowMasterId;
	}

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleNum() {
		return vehicleNum;
	}

	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}

	public String getViceBusinessFlag() {
		return viceBusinessFlag;
	}

	public void setViceBusinessFlag(String viceBusinessFlag) {
		this.viceBusinessFlag = viceBusinessFlag;
	}

	public String getViceBusinessReason() {
		return viceBusinessReason;
	}

	public void setViceBusinessReason(String viceBusinessReason) {
		this.viceBusinessReason = viceBusinessReason;
	}

	public String getZfNum() {
		return zfNum;
	}

	public void setZfNum(String zfNum) {
		this.zfNum = zfNum;
	}

	public BigDecimal getOwnerCapitalAdjust() {
		return ownerCapitalAdjust;
	}

	public void setOwnerCapitalAdjust(BigDecimal ownerCapitalAdjust) {
		this.ownerCapitalAdjust = ownerCapitalAdjust;
	}

	public BigDecimal getOwnerPayAmount() {
		return ownerPayAmount;
	}

	public void setOwnerPayAmount(BigDecimal ownerPayAmount) {
		this.ownerPayAmount = ownerPayAmount;
	}

	public String getBusinessMemo() {
		return businessMemo;
	}

	public void setBusinessMemo(String businessMemo) {
		this.businessMemo = businessMemo;
	}

	public BigDecimal getPayCarryMinAmt() {
		return payCarryMinAmt;
	}

	public void setPayCarryMinAmt(BigDecimal payCarryMinAmt) {
		this.payCarryMinAmt = payCarryMinAmt;
	}
	
}