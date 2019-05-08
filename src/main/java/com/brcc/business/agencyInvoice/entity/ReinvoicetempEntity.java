package com.brcc.business.agencyInvoice.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *	 代开票发票导入日志
 *
 * @author hui.liu
 * @date 2018年12月14日
 */
@Entity
@Table(name="reinvoicetemp")
public class ReinvoicetempEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reinvoice_temp_id")
	private Long reinvoiceTempId;
   
	@Column(name="reinvoice_master_num")
	private String reinvoiceMasterNum;
   
	@Column(name="reinvoice_no")
	private String reinvoiceNo;
	
	@Column(name="reinvoice_agree_time")
	private Date reinvoiceAgreeTime;
	
	@Column(name="platform_id")
	private String platformId;
	
	@Column(name="batch_id")
	private String batchId;
	
	@Column(name="update_flag")
	private String updateFlag;
	
	@Column(name="remark")
	private String remark;
	
	@Column(name="create_person_id")
	private Long createPersonId;
	
	@Column(name="create_person_name")
	private String createPersonName;
	
	@Column(name="modify_person_id")
	private Long modifyPersonId;
	
	@Column(name="modify_person_name")
	private String modifyPersonName;
	
	@Column(name="create_date")
	private Date createDate;
	
	@Column(name="modify_date")
	private Date modifyDate;

	public Long getReinvoiceTempId() {
		return reinvoiceTempId;
	}

	public void setReinvoiceTempId(Long reinvoiceTempId) {
		this.reinvoiceTempId = reinvoiceTempId;
	}

	public String getReinvoiceMasterNum() {
		return reinvoiceMasterNum;
	}

	public void setReinvoiceMasterNum(String reinvoiceMasterNum) {
		this.reinvoiceMasterNum = reinvoiceMasterNum;
	}

	public String getReinvoiceNo() {
		return reinvoiceNo;
	}

	public void setReinvoiceNo(String reinvoiceNo) {
		this.reinvoiceNo = reinvoiceNo;
	}

	public Date getReinvoiceAgreeTime() {
		return reinvoiceAgreeTime;
	}

	public void setReinvoiceAgreeTime(Date reinvoiceAgreeTime) {
		this.reinvoiceAgreeTime = reinvoiceAgreeTime;
	}

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getUpdateFlag() {
		return updateFlag;
	}

	public void setUpdateFlag(String updateFlag) {
		this.updateFlag = updateFlag;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getCreatePersonId() {
		return createPersonId;
	}

	public void setCreatePersonId(Long createPersonId) {
		this.createPersonId = createPersonId;
	}

	public String getCreatePersonName() {
		return createPersonName;
	}

	public void setCreatePersonName(String createPersonName) {
		this.createPersonName = createPersonName;
	}

	public Long getModifyPersonId() {
		return modifyPersonId;
	}

	public void setModifyPersonId(Long modifyPersonId) {
		this.modifyPersonId = modifyPersonId;
	}

	public String getModifyPersonName() {
		return modifyPersonName;
	}

	public void setModifyPersonName(String modifyPersonName) {
		this.modifyPersonName = modifyPersonName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

}