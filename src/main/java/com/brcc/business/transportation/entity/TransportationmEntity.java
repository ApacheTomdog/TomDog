package com.brcc.business.transportation.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the transportationm database table.
 * @Desc:运单实体类
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="transportationm")
@NamedQuery(name = "TransportationmEntity.findAll", query = "SELECT t FROM TransportationmEntity t")
public class TransportationmEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	// 运输委托单id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trans_id")
	private Long transId;

	// 货物金额
	private BigDecimal amount;

	// 发单联系人
	@Column(name = "bill_sender")
	private String billSender;
	// 发单联系人电话
	@Column(name = "bill_sender_mobile")
	private String billSenderMobile;
	// 取单联系人
	@Column(name = "bill_taker")
	private String billTaker;
	// 取单联系人电话
	@Column(name = "bill_taker_mobile")
	private String billTakerMobile;
	// 司机所属承运公司的Id(天津友发针对司机只有被一个承运公司收纳)
	@Column(name = "carry_company_id")
	private Long carryCompanyId;
	// 承运单位id
	@Column(name = "company_id")
	private Long companyId;
	// 承运单位
	@Column(name = "company_name")
	private String companyName;
	// 完成时间
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "complete_date")
	private Date completeDate;
	// 创建时间
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate;
	// 创建人
	@Column(name = "create_person")
	private Long createPerson;
	 
	@Column(name = "delivery_amount")
	private BigDecimal deliveryAmount;
	 
	@Column(name = "delivery_qty")
	private BigDecimal deliveryQty;
	
	@Column(name = "delivery_weight")
	private BigDecimal deliveryWeight;
	// 出发地（给老版本表用）
	private String departure;
	// 起始地经度
	@Column(name = "departure_lat")
	private BigDecimal departureLat;
	// 起始地纬度
	@Column(name = "departure_lng")
	private BigDecimal departureLng;
	// 目的地（给老版本表用）
	private String destination;
	// 目的地经度
	@Column(name = "destination_lat")
	private BigDecimal destinationLat;
	// 目的地经度
	@Column(name = "destination_lng")
	private BigDecimal destinationLng;
	// 0为司机自动调度的，1为物流公司调度的
	@Column(name = "docu_source")
	private String docuSource;
	// 目的地
	@Column(name = "end_plate")
	private String endPlate;
	// 电商绑定过来的user_id
	@Column(name = "fd_user_id")
	private Long fdUserId;
	// 取单地(给老版本用)
	@Column(name = "get_order_address")
	private String getOrderAddress;
	// 取单地经度
	@Column(name = "get_order_address_lat")
	private BigDecimal getOrderAddressLat;
	// 取单地纬度
	@Column(name = "get_order_address_lng")
	private BigDecimal getOrderAddressLng;
	// 取单地
	@Column(name = "get_order_plate")
	private String getOrderPlate;
	// 货物价格
	@Column(name = "good_price")
	private BigDecimal goodPrice;
	// 货物类别（Catalog表id）
	@Column(name = "good_type")
	private Long goodType;
	// 货物类别的描述
	@Column(name = "good_type_desc")
	private String goodTypeDesc;
	// 
	private String goodsorderquotation;
	//
	@Column(name = "group_id")
	private Long groupId;
	// 
	@Column(name = "group_name")
	private String groupName;
	// 默认为Y,买家自运为N
	@Column(name = "if_can_show")
	private String ifCanShow;
	// 如果是飞单为Y
	@Column(name = "if_feidan")
	private String ifFeidan;
	// 是否含税运输
	@Column(name = "if_tax_transport")
	private String ifTaxTransport;
	// 初始金额
	@Column(name = "init_amount")
	private BigDecimal initAmount;
	// 初始件数
	@Column(name = "init_qty")
	private BigDecimal initQty;
	// 初始重量
	@Column(name = "init_weight")
	private BigDecimal initWeight;
	// 路损比例
	@Column(name = "loss_ratio")
	private BigDecimal lossRatio;
	// 路损类型
	@Column(name = "loss_type")
	private String lossType;
	// 定额路损重量
	@Column(name = "loss_weight")
	private BigDecimal lossWeight;
	// 单据生成的来源，APP,WEB
	@Column(name = "operate_type")
	private String operateType;
	// 
	@Column(name = "owner_adjust_amt")
	private BigDecimal ownerAdjustAmt;
	//
	@Column(name = "owner_adjust_flag")
	private String ownerAdjustFlag;
	//
	@Column(name = "owner_adjust_type")
	private String ownerAdjustType;
	//
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "pickup_date")
	private Date pickupDate;
	// 平台id
	@Column(name = "platform_id")
	private String platformId;
	// 如果未拼单为publish_id,如果已拼单为第一条的publish_id
	@Column(name = "pri_publish_id")
	private Long priPublishId;
	// 价格
	private BigDecimal price;
	// 含税单价
	@Column(name = "price_tax")
	private BigDecimal priceTax;
	// 货物品种描述
	@Column(name = "prod_desc")
	private String prodDesc;
	// 发单公司id
	@Column(name = "publish_company_id")
	private Long publishCompanyId;
	// 货源投放单id
	@Column(name = "publish_id")
	private Long publishId;
	// 货源单号
	@Column(name = "publish_num")
	private String publishNum;
	// 件数
	private BigDecimal qty;
	// 收货人
	private String receiver;
	// 收货人电话
	@Column(name = "receiver_mobile")
	private String receiverMobile;
	// 备注
	private String remark;
	// 发货人
	private String sender;
	// 发货人联系电话
	@Column(name = "sender_mobile")
	private String senderMobile;
	// 标准税率
	@Column(name = "standard_tax")
	private BigDecimal standardTax;
	// 装货地
	@Column(name = "start_plate")
	private String startPlate;
	// 00无效，10新增，20生效,30完成
	private String status;
	// 运输单号
	@Column(name = "trans_num")
	private String transNum;
	// 修改日期
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date")
	private Date updateDate;
	// 修改人
	@Column(name = "update_person")
	private Long updatePerson;
	// 主流程id
	@Column(name = "vat_flow_master_id")
	private Long vatFlowMasterId;
	// 货物重量
	private BigDecimal weight;
    // 业务流程模式
	@Column(name="business_mode")
	private String businessMode;
    //抢单调度类型，0：按车抢单调度，1：按量抢单调度
	@Column(name="rob_delivery_type")
	private String robDeliveryType;

	public TransportationmEntity() {
	}

	public Long getTransId() {
		return transId;
	}

	public void setTransId(Long transId) {
		this.transId = transId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getBillSender() {
		return billSender;
	}

	public void setBillSender(String billSender) {
		this.billSender = billSender;
	}

	public String getBillSenderMobile() {
		return billSenderMobile;
	}

	public void setBillSenderMobile(String billSenderMobile) {
		this.billSenderMobile = billSenderMobile;
	}

	public String getBillTaker() {
		return billTaker;
	}

	public void setBillTaker(String billTaker) {
		this.billTaker = billTaker;
	}

	public String getBillTakerMobile() {
		return billTakerMobile;
	}

	public void setBillTakerMobile(String billTakerMobile) {
		this.billTakerMobile = billTakerMobile;
	}

	public Long getCarryCompanyId() {
		return carryCompanyId;
	}

	public void setCarryCompanyId(Long carryCompanyId) {
		this.carryCompanyId = carryCompanyId;
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

	public Date getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
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

	public BigDecimal getDeliveryAmount() {
		return deliveryAmount;
	}

	public void setDeliveryAmount(BigDecimal deliveryAmount) {
		this.deliveryAmount = deliveryAmount;
	}

	public BigDecimal getDeliveryQty() {
		return deliveryQty;
	}

	public void setDeliveryQty(BigDecimal deliveryQty) {
		this.deliveryQty = deliveryQty;
	}

	public BigDecimal getDeliveryWeight() {
		return deliveryWeight;
	}

	public void setDeliveryWeight(BigDecimal deliveryWeight) {
		this.deliveryWeight = deliveryWeight;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public BigDecimal getDepartureLat() {
		return departureLat;
	}

	public void setDepartureLat(BigDecimal departureLat) {
		this.departureLat = departureLat;
	}

	public BigDecimal getDepartureLng() {
		return departureLng;
	}

	public void setDepartureLng(BigDecimal departureLng) {
		this.departureLng = departureLng;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public BigDecimal getDestinationLat() {
		return destinationLat;
	}

	public void setDestinationLat(BigDecimal destinationLat) {
		this.destinationLat = destinationLat;
	}

	public BigDecimal getDestinationLng() {
		return destinationLng;
	}

	public void setDestinationLng(BigDecimal destinationLng) {
		this.destinationLng = destinationLng;
	}

	public String getDocuSource() {
		return docuSource;
	}

	public void setDocuSource(String docuSource) {
		this.docuSource = docuSource;
	}

	public String getEndPlate() {
		return endPlate;
	}

	public void setEndPlate(String endPlate) {
		this.endPlate = endPlate;
	}

	public Long getFdUserId() {
		return fdUserId;
	}

	public void setFdUserId(Long fdUserId) {
		this.fdUserId = fdUserId;
	}

	public String getGetOrderAddress() {
		return getOrderAddress;
	}

	public void setGetOrderAddress(String getOrderAddress) {
		this.getOrderAddress = getOrderAddress;
	}

	public BigDecimal getGetOrderAddressLat() {
		return getOrderAddressLat;
	}

	public void setGetOrderAddressLat(BigDecimal getOrderAddressLat) {
		this.getOrderAddressLat = getOrderAddressLat;
	}

	public BigDecimal getGetOrderAddressLng() {
		return getOrderAddressLng;
	}

	public void setGetOrderAddressLng(BigDecimal getOrderAddressLng) {
		this.getOrderAddressLng = getOrderAddressLng;
	}

	public String getGetOrderPlate() {
		return getOrderPlate;
	}

	public void setGetOrderPlate(String getOrderPlate) {
		this.getOrderPlate = getOrderPlate;
	}

	public BigDecimal getGoodPrice() {
		return goodPrice;
	}

	public void setGoodPrice(BigDecimal goodPrice) {
		this.goodPrice = goodPrice;
	}

	public Long getGoodType() {
		return goodType;
	}

	public void setGoodType(Long goodType) {
		this.goodType = goodType;
	}

	public String getGoodTypeDesc() {
		return goodTypeDesc;
	}

	public void setGoodTypeDesc(String goodTypeDesc) {
		this.goodTypeDesc = goodTypeDesc;
	}

	public String getGoodsorderquotation() {
		return goodsorderquotation;
	}

	public void setGoodsorderquotation(String goodsorderquotation) {
		this.goodsorderquotation = goodsorderquotation;
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

	public String getIfCanShow() {
		return ifCanShow;
	}

	public void setIfCanShow(String ifCanShow) {
		this.ifCanShow = ifCanShow;
	}

	public String getIfFeidan() {
		return ifFeidan;
	}

	public void setIfFeidan(String ifFeidan) {
		this.ifFeidan = ifFeidan;
	}

	public String getIfTaxTransport() {
		return ifTaxTransport;
	}

	public void setIfTaxTransport(String ifTaxTransport) {
		this.ifTaxTransport = ifTaxTransport;
	}

	public BigDecimal getInitAmount() {
		return initAmount;
	}

	public void setInitAmount(BigDecimal initAmount) {
		this.initAmount = initAmount;
	}

	public BigDecimal getInitQty() {
		return initQty;
	}

	public void setInitQty(BigDecimal initQty) {
		this.initQty = initQty;
	}

	public BigDecimal getInitWeight() {
		return initWeight;
	}

	public void setInitWeight(BigDecimal initWeight) {
		this.initWeight = initWeight;
	}

	public BigDecimal getLossRatio() {
		return lossRatio;
	}

	public void setLossRatio(BigDecimal lossRatio) {
		this.lossRatio = lossRatio;
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

	public String getOperateType() {
		return operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
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

	public String getOwnerAdjustType() {
		return ownerAdjustType;
	}

	public void setOwnerAdjustType(String ownerAdjustType) {
		this.ownerAdjustType = ownerAdjustType;
	}

	public Date getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public Long getPriPublishId() {
		return priPublishId;
	}

	public void setPriPublishId(Long priPublishId) {
		this.priPublishId = priPublishId;
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

	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	public Long getPublishCompanyId() {
		return publishCompanyId;
	}

	public void setPublishCompanyId(Long publishCompanyId) {
		this.publishCompanyId = publishCompanyId;
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

	public BigDecimal getQty() {
		return qty;
	}

	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getReceiverMobile() {
		return receiverMobile;
	}

	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
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

	public String getSenderMobile() {
		return senderMobile;
	}

	public void setSenderMobile(String senderMobile) {
		this.senderMobile = senderMobile;
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

	public String getTransNum() {
		return transNum;
	}

	public void setTransNum(String transNum) {
		this.transNum = transNum;
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

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public String getBusinessMode() {
		return businessMode;
	}

	public void setBusinessMode(String businessMode) {
		this.businessMode = businessMode;
	}

	public String getRobDeliveryType() {
		return robDeliveryType;
	}

	public void setRobDeliveryType(String robDeliveryType) {
		this.robDeliveryType = robDeliveryType;
	}
}