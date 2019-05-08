package com.brcc.business.flow.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="vatplatflowmaster")
public class VatplatflowmasterEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vat_plat_flow_master_id")
	private Long vatPlatFlowMasterId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="create_person_id")
	private Long createPersonId;

	@Column(name="create_person_name")
	private String createPersonName;

	@Column(name="if_old_status")
	private String ifOldStatus;

	@Column(name="if_special_case")
	private String ifSpecialCase;

	@Column(name="if_wc_monitor")
	private String ifWcMonitor;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modify_date")
	private Date modifyDate;

	@Column(name="modify_person_id")
	private Long modifyPersonId;

	@Column(name="modify_person_name")
	private String modifyPersonName;

	@Column(name="platform_id")
	private String platformId;

	@Column(name="special_client_id")
	private Long specialClientId;

	@Column(name="special_client_name")
	private String specialClientName;

	@Column(name="special_login_name")
	private String specialLoginName;

	@Column(name="vat_acc_type")
	private String vatAccType;

	@Column(name="vat_company_id")
	private Long vatCompanyId;

	@Column(name="vat_company_name")
	private String vatCompanyName;

	@Column(name="vat_flow_num")
	private Long vatFlowNum;

	@Column(name="vat_plat_flow_master_name")
	private String vatPlatFlowMasterName;

	@Column(name="vat_rate_chose")
	private String vatRateChose;

	@Column(name="vat_standard_rate")
	private BigDecimal vatStandardRate;

	@Column(name="vat_status")
	private String vatStatus;

	public VatplatflowmasterEntity() {
	}

	public Long getVatPlatFlowMasterId() {
		return this.vatPlatFlowMasterId;
	}

	public void setVatPlatFlowMasterId(Long vatPlatFlowMasterId) {
		this.vatPlatFlowMasterId = vatPlatFlowMasterId;
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

	public String getIfOldStatus() {
		return this.ifOldStatus;
	}

	public void setIfOldStatus(String ifOldStatus) {
		this.ifOldStatus = ifOldStatus;
	}

	public String getIfSpecialCase() {
		return this.ifSpecialCase;
	}

	public void setIfSpecialCase(String ifSpecialCase) {
		this.ifSpecialCase = ifSpecialCase;
	}

	public String getIfWcMonitor() {
		return this.ifWcMonitor;
	}

	public void setIfWcMonitor(String ifWcMonitor) {
		this.ifWcMonitor = ifWcMonitor;
	}

	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Long getModifyPersonId() {
		return this.modifyPersonId;
	}

	public void setModifyPersonId(Long modifyPersonId) {
		this.modifyPersonId = modifyPersonId;
	}

	public String getModifyPersonName() {
		return this.modifyPersonName;
	}

	public void setModifyPersonName(String modifyPersonName) {
		this.modifyPersonName = modifyPersonName;
	}

	public String getPlatformId() {
		return this.platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public Long getSpecialClientId() {
		return this.specialClientId;
	}

	public void setSpecialClientId(Long specialClientId) {
		this.specialClientId = specialClientId;
	}

	public String getSpecialClientName() {
		return this.specialClientName;
	}

	public void setSpecialClientName(String specialClientName) {
		this.specialClientName = specialClientName;
	}

	public String getSpecialLoginName() {
		return this.specialLoginName;
	}

	public void setSpecialLoginName(String specialLoginName) {
		this.specialLoginName = specialLoginName;
	}

	public String getVatAccType() {
		return this.vatAccType;
	}

	public void setVatAccType(String vatAccType) {
		this.vatAccType = vatAccType;
	}

	public Long getVatCompanyId() {
		return this.vatCompanyId;
	}

	public void setVatCompanyId(Long vatCompanyId) {
		this.vatCompanyId = vatCompanyId;
	}

	public String getVatCompanyName() {
		return this.vatCompanyName;
	}

	public void setVatCompanyName(String vatCompanyName) {
		this.vatCompanyName = vatCompanyName;
	}

	public Long getVatFlowNum() {
		return this.vatFlowNum;
	}

	public void setVatFlowNum(Long vatFlowNum) {
		this.vatFlowNum = vatFlowNum;
	}

	public String getVatPlatFlowMasterName() {
		return this.vatPlatFlowMasterName;
	}

	public void setVatPlatFlowMasterName(String vatPlatFlowMasterName) {
		this.vatPlatFlowMasterName = vatPlatFlowMasterName;
	}

	public String getVatRateChose() {
		return this.vatRateChose;
	}

	public void setVatRateChose(String vatRateChose) {
		this.vatRateChose = vatRateChose;
	}

	public BigDecimal getVatStandardRate() {
		return this.vatStandardRate;
	}

	public void setVatStandardRate(BigDecimal vatStandardRate) {
		this.vatStandardRate = vatStandardRate;
	}

	public String getVatStatus() {
		return this.vatStatus;
	}

	public void setVatStatus(String vatStatus) {
		this.vatStatus = vatStatus;
	}

}