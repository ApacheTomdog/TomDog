package com.brcc.business.agencyInvoice.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 *	 代开票明细实体类
 *
 * @author hui.liu
 * @date 2018年12月14日
 */
@Entity
@Table(name="reinvoicedetail")
public class ReinvoicedetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reinvoice_detail_id")
	private Long reinvoiceDetailId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="create_person_id")
	private Long createPersonId;

	@Column(name="create_person_name")
	private String createPersonName;

	@Column(name="delivery_id")
	private Long deliveryId;

	@Column(name="fjsw_return_msg")
	private String fjswReturnMsg;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fjsw_upload_date")
	private Date fjswUploadDate;

	@Column(name="fjsw_upload_flag")
	private String fjswUploadFlag;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modify_date")
	private Date modifyDate;

	@Column(name="modify_person_id")
	private Long modifyPersonId;

	@Column(name="modify_person_name")
	private String modifyPersonName;

	@Column(name="pay_bill_child_id")
	private Long payBillChildId;

	@Column(name="pay_bill_child_num")
	private String payBillChildNum;

	@Column(name="pay_bill_id")
	private Long payBillId;

	@Column(name="pay_bill_num")
	private String payBillNum;

	@Column(name="platform_id")
	private String platformId;

	@Column(name="publish_id")
	private Long publishId;

	@Column(name="reinvoice_amount")
	private BigDecimal reinvoiceAmount;

	@Column(name="reinvoice_master_id")
	private Long reinvoiceMasterId;

	@Column(name="reinvoice_middle_id")
	private Long reinvoiceMiddleId;

	@Column(name="reinvoice_no")
	private String reinvoiceNo;

	@Column(name="reinvoice_status")
	private String reinvoiceStatus;

	@Column(name="reinvoice_title_id")
	private Long reinvoiceTitleId;

	@Column(name="reinvoice_title_name")
	private String reinvoiceTitleName;

	@Column(name="reinvoice_weight")
	private BigDecimal reinvoiceWeight;

	@Column(name="trans_id")
	private Long transId;

	public ReinvoicedetailEntity() {
	}

	public Long getReinvoiceDetailId() {
		return this.reinvoiceDetailId;
	}

	public void setReinvoiceDetailId(Long reinvoiceDetailId) {
		this.reinvoiceDetailId = reinvoiceDetailId;
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

	public String getFjswReturnMsg() {
		return this.fjswReturnMsg;
	}

	public void setFjswReturnMsg(String fjswReturnMsg) {
		this.fjswReturnMsg = fjswReturnMsg;
	}

	public Date getFjswUploadDate() {
		return this.fjswUploadDate;
	}

	public void setFjswUploadDate(Date fjswUploadDate) {
		this.fjswUploadDate = fjswUploadDate;
	}

	public String getFjswUploadFlag() {
		return this.fjswUploadFlag;
	}

	public void setFjswUploadFlag(String fjswUploadFlag) {
		this.fjswUploadFlag = fjswUploadFlag;
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

	public Long getPayBillChildId() {
		return this.payBillChildId;
	}

	public void setPayBillChildId(Long payBillChildId) {
		this.payBillChildId = payBillChildId;
	}

	public String getPayBillChildNum() {
		return this.payBillChildNum;
	}

	public void setPayBillChildNum(String payBillChildNum) {
		this.payBillChildNum = payBillChildNum;
	}

	public Long getPayBillId() {
		return this.payBillId;
	}

	public void setPayBillId(Long payBillId) {
		this.payBillId = payBillId;
	}

	public String getPayBillNum() {
		return this.payBillNum;
	}

	public void setPayBillNum(String payBillNum) {
		this.payBillNum = payBillNum;
	}

	public String getPlatformId() {
		return this.platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public Long getPublishId() {
		return this.publishId;
	}

	public void setPublishId(Long publishId) {
		this.publishId = publishId;
	}

	public BigDecimal getReinvoiceAmount() {
		return this.reinvoiceAmount;
	}

	public void setReinvoiceAmount(BigDecimal reinvoiceAmount) {
		this.reinvoiceAmount = reinvoiceAmount;
	}

	public Long getReinvoiceMasterId() {
		return this.reinvoiceMasterId;
	}

	public void setReinvoiceMasterId(Long reinvoiceMasterId) {
		this.reinvoiceMasterId = reinvoiceMasterId;
	}

	public Long getReinvoiceMiddleId() {
		return this.reinvoiceMiddleId;
	}

	public void setReinvoiceMiddleId(Long reinvoiceMiddleId) {
		this.reinvoiceMiddleId = reinvoiceMiddleId;
	}

	public String getReinvoiceNo() {
		return this.reinvoiceNo;
	}

	public void setReinvoiceNo(String reinvoiceNo) {
		this.reinvoiceNo = reinvoiceNo;
	}

	public String getReinvoiceStatus() {
		return this.reinvoiceStatus;
	}

	public void setReinvoiceStatus(String reinvoiceStatus) {
		this.reinvoiceStatus = reinvoiceStatus;
	}

	public Long getReinvoiceTitleId() {
		return this.reinvoiceTitleId;
	}

	public void setReinvoiceTitleId(Long reinvoiceTitleId) {
		this.reinvoiceTitleId = reinvoiceTitleId;
	}

	public String getReinvoiceTitleName() {
		return this.reinvoiceTitleName;
	}

	public void setReinvoiceTitleName(String reinvoiceTitleName) {
		this.reinvoiceTitleName = reinvoiceTitleName;
	}

	public BigDecimal getReinvoiceWeight() {
		return this.reinvoiceWeight;
	}

	public void setReinvoiceWeight(BigDecimal reinvoiceWeight) {
		this.reinvoiceWeight = reinvoiceWeight;
	}

	public Long getTransId() {
		return this.transId;
	}

	public void setTransId(Long transId) {
		this.transId = transId;
	}

}