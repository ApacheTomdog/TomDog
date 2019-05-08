package com.brcc.business.transportSettle.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the v_new_pay_bill database table.
 * 
 */
@Entity
@Table(name="v_new_pay_bill")
@NamedQuery(name="VNewPayBillEntity.findAll", query="SELECT v FROM VNewPayBillEntity v")
public class VNewPayBillEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="account_check_modify_date")
	private Date accountCheckModifyDate;

	@Column(name="account_check_modify_person_id")
	private Long accountCheckModifyPersonId;

	@Column(name="account_check_modify_person_name")
	private String accountCheckModifyPersonName;

	@Column(name="account_type")
	private String accountType;

	@Column(name="bill_sender")
	private String billSender;

	@Column(name="company_bank_name")
	private String companyBankName;

	@Column(name="company_bank_num")
	private String companyBankNum;

	@Column(name="company_bank_owner")
	private String companyBankOwner;

	@Column(name="company_id")
	private Long companyId;

	@Column(name="company_name")
	private String companyName;

	@Column(name="create_company_id")
	private Long createCompanyId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="create_person_id")
	private Long createPersonId;

	@Column(name="create_person_name")
	private String createPersonName;

	@Column(name="cy_pay_flag")
	private String cyPayFlag;

	@Column(name="deduct_amount")
	private BigDecimal deductAmount;

	@Column(name="delivery_id")
	private Long deliveryId;

	@Column(name="delivery_num")
	private String deliveryNum;

	@Column(name="driver_name")
	private String driverName;

	@Column(name="end_plate")
	private String endPlate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="finish_time")
	private Date finishTime;

	@Column(name="good_price")
	private BigDecimal goodPrice;

	@Column(name="good_type")
	private String goodType;

	@Column(name="good_type_desc")
	private String goodTypeDesc;

	@Column(name="good_type_name")
	private String goodTypeName;

	@Column(name="group_id")
	private Long groupId;

	@Column(name="group_name")
	private String groupName;

	@Column(name="if_account_check")
	private String ifAccountCheck;

	@Column(name="if_invoice")
	private String ifInvoice;

	@Column(name="if_merge_flag")
	private String ifMergeFlag;

	@Column(name="if_tax_transport")
	private String ifTaxTransport;

	@Column(name="loss_ratio")
	private BigDecimal lossRatio;

	@Column(name="loss_tons")
	private BigDecimal lossTons;

	@Column(name="loss_type")
	private String lossType;

	@Column(name="loss_weight")
	private BigDecimal lossWeight;

	@Column(name="oil_amount")
	private BigDecimal oilAmount;

	@Column(name="pay_amount")
	private BigDecimal payAmount;

	@Column(name="pay_amount_act")
	private BigDecimal payAmountAct;

	@Column(name="pay_company_id")
	private Long payCompanyId;

	@Column(name="pay_company_name")
	private String payCompanyName;

	@Column(name="pay_date")
	private String payDate;

	@Column(name="pay_fee_amount")
	private BigDecimal payFeeAmount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="pay_finish_date")
	private Date payFinishDate;

	@Column(name="pay_from_type")
	private String payFromType;

	@Column(name="pay_from_type_desc")
	private String payFromTypeDesc;

	@Column(name="pay_id")
	private Long payId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="pay_initiated_date")
	private Date payInitiatedDate;

	@Column(name="pay_num")
	private String payNum;

	@Column(name="pay_person_id")
	private String payPersonId;

	@Column(name="pay_person_name")
	private String payPersonName;

	@Column(name="pay_style")
	private String payStyle;

	@Column(name="platform_id")
	private String platformId;

	private BigDecimal price;

	private BigDecimal priceTax;

	@Column(name="publish_company_id")
	private Long publishCompanyId;

	@Column(name="publish_company_name")
	private String publishCompanyName;

	@Column(name="publish_id")
	private Long publishId;

	@Column(name="publish_num")
	private String publishNum;

	@Column(name="rece_bank_city")
	private String receBankCity;

	@Column(name="rece_bank_name")
	private String receBankName;

	@Column(name="rece_bank_num")
	private String receBankNum;

	@Column(name="rece_bank_owner")
	private String receBankOwner;

	@Column(name="rece_bank_province")
	private String receBankProvince;

	@Column(name="rece_bank_type")
	private String receBankType;

	@Column(name="rece_company_id")
	private Long receCompanyId;

	@Column(name="rece_company_name")
	private String receCompanyName;

	@Column(name="rece_link_num")
	private String receLinkNum;

	@Column(name="rece_subbranch_name")
	private String receSubbranchName;

	private String remark;

	private String sender;

	@Column(name="settle_weight")
	private BigDecimal settleWeight;

	@Column(name="start_plate")
	private String startPlate;

	private String status;

	private String statusChild;

	private String statusDesc;

	@Column(name="take_delivery_weight")
	private BigDecimal takeDeliveryWeight;

	@Column(name="tot_amount")
	private BigDecimal totAmount;

	private BigDecimal totalAmount;

	@Column(name="trans_id")
	private Long transId;

	@Column(name="trans_num")
	private String transNum;

	@Column(name="trece_bank_type")
	private String treceBankType;

	@Column(name="truck_loading_weight")
	private BigDecimal truckLoadingWeight;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	@Column(name="update_person_id")
	private Long updatePersonId;

	@Column(name="update_person_name")
	private String updatePersonName;

	@Column(name="vat_flow_master_id")
	private Long vatFlowMasterId;

	@Column(name="vehicle_num")
	private String vehicleNum;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="zf_child_id")
	private Long zfChildId;

	@Column(name="zf_child_num")
	private String zfChildNum;

	@Column(name="zf_id")
	private Long zfId;

	@Column(name="zf_num")
	private String zfNum;

	@Column(name="zg_detail_order_no")
	private String zgDetailOrderNo;

	@Column(name="zg_order_no")
	private String zgOrderNo;

	@Column(name="zg_out_trade_no")
	private String zgOutTradeNo;
	
	public BigDecimal getOilAmount() {
		return oilAmount;
	}

	public void setOilAmount(BigDecimal oilAmount) {
		this.oilAmount = oilAmount;
	}

	public String getPayDate() {
		return payDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public VNewPayBillEntity() {
	}

	public Date getAccountCheckModifyDate() {
		return this.accountCheckModifyDate;
	}

	public void setAccountCheckModifyDate(Date accountCheckModifyDate) {
		this.accountCheckModifyDate = accountCheckModifyDate;
	}

	public Long getAccountCheckModifyPersonId() {
		return this.accountCheckModifyPersonId;
	}

	public void setAccountCheckModifyPersonId(Long accountCheckModifyPersonId) {
		this.accountCheckModifyPersonId = accountCheckModifyPersonId;
	}

	public String getAccountCheckModifyPersonName() {
		return this.accountCheckModifyPersonName;
	}

	public void setAccountCheckModifyPersonName(String accountCheckModifyPersonName) {
		this.accountCheckModifyPersonName = accountCheckModifyPersonName;
	}

	public String getAccountType() {
		return this.accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBillSender() {
		return this.billSender;
	}

	public void setBillSender(String billSender) {
		this.billSender = billSender;
	}

	public String getCompanyBankName() {
		return this.companyBankName;
	}

	public void setCompanyBankName(String companyBankName) {
		this.companyBankName = companyBankName;
	}

	public String getCompanyBankNum() {
		return this.companyBankNum;
	}

	public void setCompanyBankNum(String companyBankNum) {
		this.companyBankNum = companyBankNum;
	}

	public String getCompanyBankOwner() {
		return this.companyBankOwner;
	}

	public void setCompanyBankOwner(String companyBankOwner) {
		this.companyBankOwner = companyBankOwner;
	}

	public Long getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Long getCreateCompanyId() {
		return this.createCompanyId;
	}

	public void setCreateCompanyId(Long createCompanyId) {
		this.createCompanyId = createCompanyId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getCreatePersonId() {
		return this.createPersonId;
	}

	public void setCreatePersonId(Long createPersonId) {
		this.createPersonId = createPersonId;
	}

	public String getCreatePersonName() {
		return this.createPersonName;
	}

	public void setCreatePersonName(String createPersonName) {
		this.createPersonName = createPersonName;
	}

	public String getCyPayFlag() {
		return this.cyPayFlag;
	}

	public void setCyPayFlag(String cyPayFlag) {
		this.cyPayFlag = cyPayFlag;
	}

	public BigDecimal getDeductAmount() {
		return this.deductAmount;
	}

	public void setDeductAmount(BigDecimal deductAmount) {
		this.deductAmount = deductAmount;
	}

	public Long getDeliveryId() {
		return this.deliveryId;
	}

	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}

	public String getDeliveryNum() {
		return this.deliveryNum;
	}

	public void setDeliveryNum(String deliveryNum) {
		this.deliveryNum = deliveryNum;
	}

	public String getDriverName() {
		return this.driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getEndPlate() {
		return this.endPlate;
	}

	public void setEndPlate(String endPlate) {
		this.endPlate = endPlate;
	}

	public Date getFinishTime() {
		return this.finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public BigDecimal getGoodPrice() {
		return this.goodPrice;
	}

	public void setGoodPrice(BigDecimal goodPrice) {
		this.goodPrice = goodPrice;
	}

	public String getGoodType() {
		return this.goodType;
	}

	public void setGoodType(String goodType) {
		this.goodType = goodType;
	}

	public String getGoodTypeDesc() {
		return this.goodTypeDesc;
	}

	public void setGoodTypeDesc(String goodTypeDesc) {
		this.goodTypeDesc = goodTypeDesc;
	}

	public String getGoodTypeName() {
		return this.goodTypeName;
	}

	public void setGoodTypeName(String goodTypeName) {
		this.goodTypeName = goodTypeName;
	}

	public Long getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getIfAccountCheck() {
		return this.ifAccountCheck;
	}

	public void setIfAccountCheck(String ifAccountCheck) {
		this.ifAccountCheck = ifAccountCheck;
	}

	public String getIfInvoice() {
		return this.ifInvoice;
	}

	public void setIfInvoice(String ifInvoice) {
		this.ifInvoice = ifInvoice;
	}

	public String getIfMergeFlag() {
		return this.ifMergeFlag;
	}

	public void setIfMergeFlag(String ifMergeFlag) {
		this.ifMergeFlag = ifMergeFlag;
	}

	public String getIfTaxTransport() {
		return this.ifTaxTransport;
	}

	public void setIfTaxTransport(String ifTaxTransport) {
		this.ifTaxTransport = ifTaxTransport;
	}

	public BigDecimal getLossRatio() {
		return this.lossRatio;
	}

	public void setLossRatio(BigDecimal lossRatio) {
		this.lossRatio = lossRatio;
	}

	public BigDecimal getLossTons() {
		return this.lossTons;
	}

	public void setLossTons(BigDecimal lossTons) {
		this.lossTons = lossTons;
	}

	public String getLossType() {
		return this.lossType;
	}

	public void setLossType(String lossType) {
		this.lossType = lossType;
	}

	public BigDecimal getLossWeight() {
		return this.lossWeight;
	}

	public void setLossWeight(BigDecimal lossWeight) {
		this.lossWeight = lossWeight;
	}

	public BigDecimal getPayAmount() {
		return this.payAmount;
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	public BigDecimal getPayAmountAct() {
		return this.payAmountAct;
	}

	public void setPayAmountAct(BigDecimal payAmountAct) {
		this.payAmountAct = payAmountAct;
	}

	public Long getPayCompanyId() {
		return this.payCompanyId;
	}

	public void setPayCompanyId(Long payCompanyId) {
		this.payCompanyId = payCompanyId;
	}

	public String getPayCompanyName() {
		return this.payCompanyName;
	}

	public void setPayCompanyName(String payCompanyName) {
		this.payCompanyName = payCompanyName;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public BigDecimal getPayFeeAmount() {
		return this.payFeeAmount;
	}

	public void setPayFeeAmount(BigDecimal payFeeAmount) {
		this.payFeeAmount = payFeeAmount;
	}

	public Date getPayFinishDate() {
		return this.payFinishDate;
	}

	public void setPayFinishDate(Date payFinishDate) {
		this.payFinishDate = payFinishDate;
	}

	public String getPayFromType() {
		return this.payFromType;
	}

	public void setPayFromType(String payFromType) {
		this.payFromType = payFromType;
	}

	public String getPayFromTypeDesc() {
		return this.payFromTypeDesc;
	}

	public void setPayFromTypeDesc(String payFromTypeDesc) {
		this.payFromTypeDesc = payFromTypeDesc;
	}

	public Long getPayId() {
		return this.payId;
	}

	public void setPayId(Long payId) {
		this.payId = payId;
	}

	public Date getPayInitiatedDate() {
		return this.payInitiatedDate;
	}

	public void setPayInitiatedDate(Date payInitiatedDate) {
		this.payInitiatedDate = payInitiatedDate;
	}

	public String getPayNum() {
		return this.payNum;
	}

	public void setPayNum(String payNum) {
		this.payNum = payNum;
	}

	public String getPayPersonId() {
		return this.payPersonId;
	}

	public void setPayPersonId(String payPersonId) {
		this.payPersonId = payPersonId;
	}

	public String getPayPersonName() {
		return this.payPersonName;
	}

	public void setPayPersonName(String payPersonName) {
		this.payPersonName = payPersonName;
	}

	public String getPayStyle() {
		return this.payStyle;
	}

	public void setPayStyle(String payStyle) {
		this.payStyle = payStyle;
	}

	public String getPlatformId() {
		return this.platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPriceTax() {
		return this.priceTax;
	}

	public void setPriceTax(BigDecimal priceTax) {
		this.priceTax = priceTax;
	}

	public Long getPublishCompanyId() {
		return this.publishCompanyId;
	}

	public void setPublishCompanyId(Long publishCompanyId) {
		this.publishCompanyId = publishCompanyId;
	}

	public String getPublishCompanyName() {
		return this.publishCompanyName;
	}

	public void setPublishCompanyName(String publishCompanyName) {
		this.publishCompanyName = publishCompanyName;
	}

	public Long getPublishId() {
		return this.publishId;
	}

	public void setPublishId(Long publishId) {
		this.publishId = publishId;
	}

	public String getPublishNum() {
		return this.publishNum;
	}

	public void setPublishNum(String publishNum) {
		this.publishNum = publishNum;
	}

	public String getReceBankCity() {
		return this.receBankCity;
	}

	public void setReceBankCity(String receBankCity) {
		this.receBankCity = receBankCity;
	}

	public String getReceBankName() {
		return this.receBankName;
	}

	public void setReceBankName(String receBankName) {
		this.receBankName = receBankName;
	}

	public String getReceBankNum() {
		return this.receBankNum;
	}

	public void setReceBankNum(String receBankNum) {
		this.receBankNum = receBankNum;
	}

	public String getReceBankOwner() {
		return this.receBankOwner;
	}

	public void setReceBankOwner(String receBankOwner) {
		this.receBankOwner = receBankOwner;
	}

	public String getReceBankProvince() {
		return this.receBankProvince;
	}

	public void setReceBankProvince(String receBankProvince) {
		this.receBankProvince = receBankProvince;
	}

	public String getReceBankType() {
		return this.receBankType;
	}

	public void setReceBankType(String receBankType) {
		this.receBankType = receBankType;
	}

	public Long getReceCompanyId() {
		return this.receCompanyId;
	}

	public void setReceCompanyId(Long receCompanyId) {
		this.receCompanyId = receCompanyId;
	}

	public String getReceCompanyName() {
		return this.receCompanyName;
	}

	public void setReceCompanyName(String receCompanyName) {
		this.receCompanyName = receCompanyName;
	}

	public String getReceLinkNum() {
		return this.receLinkNum;
	}

	public void setReceLinkNum(String receLinkNum) {
		this.receLinkNum = receLinkNum;
	}

	public String getReceSubbranchName() {
		return this.receSubbranchName;
	}

	public void setReceSubbranchName(String receSubbranchName) {
		this.receSubbranchName = receSubbranchName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public BigDecimal getSettleWeight() {
		return this.settleWeight;
	}

	public void setSettleWeight(BigDecimal settleWeight) {
		this.settleWeight = settleWeight;
	}

	public String getStartPlate() {
		return this.startPlate;
	}

	public void setStartPlate(String startPlate) {
		this.startPlate = startPlate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusChild() {
		return this.statusChild;
	}

	public void setStatusChild(String statusChild) {
		this.statusChild = statusChild;
	}

	public String getStatusDesc() {
		return this.statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public BigDecimal getTakeDeliveryWeight() {
		return this.takeDeliveryWeight;
	}

	public void setTakeDeliveryWeight(BigDecimal takeDeliveryWeight) {
		this.takeDeliveryWeight = takeDeliveryWeight;
	}

	public BigDecimal getTotAmount() {
		return this.totAmount;
	}

	public void setTotAmount(BigDecimal totAmount) {
		this.totAmount = totAmount;
	}

	public BigDecimal getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Long getTransId() {
		return this.transId;
	}

	public void setTransId(Long transId) {
		this.transId = transId;
	}

	public String getTransNum() {
		return this.transNum;
	}

	public void setTransNum(String transNum) {
		this.transNum = transNum;
	}

	public String getTreceBankType() {
		return this.treceBankType;
	}

	public void setTreceBankType(String treceBankType) {
		this.treceBankType = treceBankType;
	}

	public BigDecimal getTruckLoadingWeight() {
		return this.truckLoadingWeight;
	}

	public void setTruckLoadingWeight(BigDecimal truckLoadingWeight) {
		this.truckLoadingWeight = truckLoadingWeight;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Long getUpdatePersonId() {
		return this.updatePersonId;
	}

	public void setUpdatePersonId(Long updatePersonId) {
		this.updatePersonId = updatePersonId;
	}

	public String getUpdatePersonName() {
		return this.updatePersonName;
	}

	public void setUpdatePersonName(String updatePersonName) {
		this.updatePersonName = updatePersonName;
	}

	public Long getVatFlowMasterId() {
		return this.vatFlowMasterId;
	}

	public void setVatFlowMasterId(Long vatFlowMasterId) {
		this.vatFlowMasterId = vatFlowMasterId;
	}

	public String getVehicleNum() {
		return this.vehicleNum;
	}

	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}

	public Long getZfChildId() {
		return this.zfChildId;
	}

	public void setZfChildId(Long zfChildId) {
		this.zfChildId = zfChildId;
	}

	public String getZfChildNum() {
		return this.zfChildNum;
	}

	public void setZfChildNum(String zfChildNum) {
		this.zfChildNum = zfChildNum;
	}

	public Long getZfId() {
		return this.zfId;
	}

	public void setZfId(Long zfId) {
		this.zfId = zfId;
	}

	public String getZfNum() {
		return this.zfNum;
	}

	public void setZfNum(String zfNum) {
		this.zfNum = zfNum;
	}

	public String getZgDetailOrderNo() {
		return this.zgDetailOrderNo;
	}

	public void setZgDetailOrderNo(String zgDetailOrderNo) {
		this.zgDetailOrderNo = zgDetailOrderNo;
	}

	public String getZgOrderNo() {
		return this.zgOrderNo;
	}

	public void setZgOrderNo(String zgOrderNo) {
		this.zgOrderNo = zgOrderNo;
	}

	public String getZgOutTradeNo() {
		return this.zgOutTradeNo;
	}

	public void setZgOutTradeNo(String zgOutTradeNo) {
		this.zgOutTradeNo = zgOutTradeNo;
	}

}