package com.brcc.business.goodsorderm.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the goodsorderquotation database table.
 * 货源单报价
 */
@Entity
@DynamicInsert
@Table(name = "goodsorderquotation")
@NamedQuery(name="GoodsorderquotationEntity.findAll", query="SELECT g FROM GoodsorderquotationEntity g")
public class GoodsorderquotationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="quotation_id")
	private Long quotationId;

	private BigDecimal amount;

	@Column(name="carry_company_id")
	private Long carryCompanyId;

	@Column(name="company_id")
	private Long companyId;

	@Column(name="company_name")
	private String companyName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="create_person")
	private Long createPerson;

	@Column(name="fd_user_id")
	private Long fdUserId;

	private String goodsorderquotation;

	@Column(name="group_id")
	private Long groupId;

	@Column(name="group_name")
	private String groupName;

	@Column(name="if_can_show")
	private String ifCanShow;

	@Column(name="if_tax_transport")
	private String ifTaxTransport;

	@Column(name="operate_type")
	private String operateType;

	@Column(name="plat_form_id")
	private String platFormId;

	private BigDecimal price;

	@Column(name="price_tax")
	private BigDecimal priceTax;

	@Column(name="publish_company_id")
	private Long publishCompanyId;

	@Column(name="publish_id")
	private Long publishId;

	private BigDecimal qty;

	@Column(name="quotation_style")
	private String quotationStyle;

	private String remark;

	@Column(name="standard_tax")
	private BigDecimal standardTax;

	private String status;

	@Column(name="trans_id")
	private Long transId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	@Column(name="update_person")
	private Long updatePerson;

	@Column(name="vat_flow_master_id")
	private Long vatFlowMasterId;

	private BigDecimal weight;

	public GoodsorderquotationEntity() {
	}

	public Long getQuotationId() {
		return quotationId;
	}

	public void setQuotationId(Long quotationId) {
		this.quotationId = quotationId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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

	public Long getFdUserId() {
		return fdUserId;
	}

	public void setFdUserId(Long fdUserId) {
		this.fdUserId = fdUserId;
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

	public String getIfTaxTransport() {
		return ifTaxTransport;
	}

	public void setIfTaxTransport(String ifTaxTransport) {
		this.ifTaxTransport = ifTaxTransport;
	}

	public String getOperateType() {
		return operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	public String getPlatFormId() {
		return platFormId;
	}

	public void setPlatFormId(String platFormId) {
		this.platFormId = platFormId;
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

	public Long getPublishId() {
		return publishId;
	}

	public void setPublishId(Long publishId) {
		this.publishId = publishId;
	}

	public BigDecimal getQty() {
		return qty;
	}

	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}

	public String getQuotationStyle() {
		return quotationStyle;
	}

	public void setQuotationStyle(String quotationStyle) {
		this.quotationStyle = quotationStyle;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public BigDecimal getStandardTax() {
		return standardTax;
	}

	public void setStandardTax(BigDecimal standardTax) {
		this.standardTax = standardTax;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getTransId() {
		return transId;
	}

	public void setTransId(Long transId) {
		this.transId = transId;
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

	
}