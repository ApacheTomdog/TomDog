package com.brcc.business.basedata.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the goodsordermjksetplat database table.
 * 
 */
@Entity
@Table(name="goodsordermjksetplat")
@NamedQuery(name="GoodsOrdermjkSetplatEntity.findAll", query="SELECT g FROM GoodsOrdermjkSetplatEntity g")
public class GoodsOrdermjkSetplatEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GoodsOrdermjkSetplatEntityPK id;

	@Column(name="company_dswl_no")
	private String companyDswlNo;

	@Column(name="delivery_info_zdwl_source")
	private String deliveryInfoZdwlSource;

	@Column(name="ds_plat_country")
	private String dsPlatCountry;

	@Column(name="dz_jk_cancel")
	private String dzJkCancel;

	@Column(name="ec_plat_name")
	private String ecPlatName;

	@Column(name="ec_plat_type")
	private String ecPlatType;

	@Column(name="first_page_recommand")
	private String firstPageRecommand;

	@Column(name="fund_control_name")
	private String fundControlName;

	@Column(name="if_ecp_publish")
	private String ifEcpPublish;

	@Column(name="if_fund_control")
	private String ifFundControl;

	@Column(name="if_rough_weight_cal")
	private Integer ifRoughWeightCal;

	@Column(name="ownership_company_id")
	private Long ownershipCompanyId;

	private String password;

	@Column(name="tax_business_flag")
	private String taxBusinessFlag;

	@Column(name="tms_from_type")
	private String tmsFromType;

	@Column(name="user_name")
	private String userName;

	public GoodsOrdermjkSetplatEntity() {
	}

	public GoodsOrdermjkSetplatEntityPK getId() {
		return this.id;
	}

	public void setId(GoodsOrdermjkSetplatEntityPK id) {
		this.id = id;
	}

	public String getCompanyDswlNo() {
		return this.companyDswlNo;
	}

	public void setCompanyDswlNo(String companyDswlNo) {
		this.companyDswlNo = companyDswlNo;
	}

	public String getDeliveryInfoZdwlSource() {
		return this.deliveryInfoZdwlSource;
	}

	public void setDeliveryInfoZdwlSource(String deliveryInfoZdwlSource) {
		this.deliveryInfoZdwlSource = deliveryInfoZdwlSource;
	}

	public String getDsPlatCountry() {
		return this.dsPlatCountry;
	}

	public void setDsPlatCountry(String dsPlatCountry) {
		this.dsPlatCountry = dsPlatCountry;
	}

	public String getDzJkCancel() {
		return this.dzJkCancel;
	}

	public void setDzJkCancel(String dzJkCancel) {
		this.dzJkCancel = dzJkCancel;
	}

	public String getEcPlatName() {
		return this.ecPlatName;
	}

	public void setEcPlatName(String ecPlatName) {
		this.ecPlatName = ecPlatName;
	}

	public String getEcPlatType() {
		return this.ecPlatType;
	}

	public void setEcPlatType(String ecPlatType) {
		this.ecPlatType = ecPlatType;
	}

	public String getFirstPageRecommand() {
		return this.firstPageRecommand;
	}

	public void setFirstPageRecommand(String firstPageRecommand) {
		this.firstPageRecommand = firstPageRecommand;
	}

	public String getFundControlName() {
		return this.fundControlName;
	}

	public void setFundControlName(String fundControlName) {
		this.fundControlName = fundControlName;
	}

	public String getIfEcpPublish() {
		return this.ifEcpPublish;
	}

	public void setIfEcpPublish(String ifEcpPublish) {
		this.ifEcpPublish = ifEcpPublish;
	}

	public String getIfFundControl() {
		return this.ifFundControl;
	}

	public void setIfFundControl(String ifFundControl) {
		this.ifFundControl = ifFundControl;
	}

	public Integer getIfRoughWeightCal() {
		return this.ifRoughWeightCal;
	}

	public void setIfRoughWeightCal(Integer ifRoughWeightCal) {
		this.ifRoughWeightCal = ifRoughWeightCal;
	}

	public Long getOwnershipCompanyId() {
		return this.ownershipCompanyId;
	}

	public void setOwnershipCompanyId(Long ownershipCompanyId) {
		this.ownershipCompanyId = ownershipCompanyId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTaxBusinessFlag() {
		return this.taxBusinessFlag;
	}

	public void setTaxBusinessFlag(String taxBusinessFlag) {
		this.taxBusinessFlag = taxBusinessFlag;
	}

	public String getTmsFromType() {
		return this.tmsFromType;
	}

	public void setTmsFromType(String tmsFromType) {
		this.tmsFromType = tmsFromType;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}