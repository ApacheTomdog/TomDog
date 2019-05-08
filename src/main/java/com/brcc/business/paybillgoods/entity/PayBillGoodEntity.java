package com.brcc.business.paybillgoods.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the pay_bill_goods database table.
 * 
 */
@Entity
@Table(name="pay_bill_goods")
@NamedQuery(name="PayBillGoodEntity.findAll", query="SELECT p FROM PayBillGoodEntity p")
public class PayBillGoodEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pay_goods_id")
	private Long payGoodsId;

	@Column(name="account_type")
	private String accountType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="create_person_id")
	private Long createPersonId;

	@Column(name="create_person_name")
	private String createPersonName;

	@Column(name="delivery_id")
	private Long deliveryId;

	@Column(name="delivery_num")
	private String deliveryNum;

	@Column(name="good_type")
	private String goodType;

	@Column(name="good_type_desc")
	private String goodTypeDesc;

	@Column(name="good_type_name")
	private String goodTypeName;

	@Column(name="goods_price")
	private BigDecimal goodsPrice;

	@Column(name="if_merge_flag")
	private String ifMergeFlag;

	@Column(name="pay_amount")
	private BigDecimal payAmount;

	@Column(name="pay_amount_act")
	private BigDecimal payAmountAct;

	@Column(name="pay_fee_amount")
	private BigDecimal payFeeAmount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="pay_finish_date")
	private Date payFinishDate;

	@Column(name="pay_flag")
	private String payFlag;

	@Column(name="pay_goods_num")
	private String payGoodsNum;

	@Column(name="pay_id")
	private Long payId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="pay_initiated_date")
	private Date payInitiatedDate;

	@Column(name="pay_num")
	private String payNum;

	@Column(name="pay_person_id")
	private Long payPersonId;

	@Column(name="pay_person_name")
	private String payPersonName;

	@Column(name="pay_status")
	private String payStatus;

	@Column(name="pay_style")
	private String payStyle;

	@Column(name="platform_id")
	private String platformId;

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

	@Column(name="rece_link_num")
	private String receLinkNum;

	@Column(name="rece_subbranch_name")
	private String receSubbranchName;

	private String remark;

	@Column(name="settle_weight")
	private BigDecimal settleWeight;

	@Column(name="trans_id")
	private Long transId;

	@Column(name="trans_num")
	private String transNum;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	@Column(name="update_person_id")
	private Long updatePersonId;

	@Column(name="update_person_name")
	private String updatePersonName;

	@Column(name="zg_detail_order_no")
	private String zgDetailOrderNo;

	@Column(name="zg_order_no")
	private String zgOrderNo;

	@Column(name="zg_out_trade_no")
	private String zgOutTradeNo;

	public PayBillGoodEntity() {
	}

	public Long getPayGoodsId() {
		return this.payGoodsId;
	}

	public void setPayGoodsId(Long payGoodsId) {
		this.payGoodsId = payGoodsId;
	}

	public String getAccountType() {
		return this.accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
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

	public BigDecimal getGoodsPrice() {
		return this.goodsPrice;
	}

	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getIfMergeFlag() {
		return this.ifMergeFlag;
	}

	public void setIfMergeFlag(String ifMergeFlag) {
		this.ifMergeFlag = ifMergeFlag;
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

	public String getPayFlag() {
		return this.payFlag;
	}

	public void setPayFlag(String payFlag) {
		this.payFlag = payFlag;
	}

	public String getPayGoodsNum() {
		return this.payGoodsNum;
	}

	public void setPayGoodsNum(String payGoodsNum) {
		this.payGoodsNum = payGoodsNum;
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

	public Long getPayPersonId() {
		return this.payPersonId;
	}

	public void setPayPersonId(Long payPersonId) {
		this.payPersonId = payPersonId;
	}

	public String getPayPersonName() {
		return this.payPersonName;
	}

	public void setPayPersonName(String payPersonName) {
		this.payPersonName = payPersonName;
	}

	public String getPayStatus() {
		return this.payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
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

	public BigDecimal getSettleWeight() {
		return this.settleWeight;
	}

	public void setSettleWeight(BigDecimal settleWeight) {
		this.settleWeight = settleWeight;
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

	public Date getUpdateDate() {
		return this.updateDate;
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