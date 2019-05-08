package com.brcc.business.agencyInvoice.entity;
import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 	代开票主项实体类
 * 
 * @author hui.liu
 * @date 2018年12月14日
 */
@Entity
@Table(name="reinvoicemaster")
public class ReinvoicemasterEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reinvoice_master_id")
	private Long reinvoiceMasterId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="create_person_id")
	private Long createPersonId;

	@Column(name="create_person_name")
	private String createPersonName;

	@Column(name="delivery_id")
	private Long deliveryId;

	@Column(name="drawer_address")
	private String drawerAddress;

	@Column(name="drawer_mobile")
	private String drawerMobile;

	@Column(name="drawer_name")
	private String drawerName;

	@Column(name="drawer_no")
	private String drawerNo;

	@Column(name="end_plate")
	private String endPlate;

	@Column(name="fjsw_return_msg")
	private String fjswReturnMsg;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fjsw_upload_date")
	private Date fjswUploadDate;

	@Column(name="fjsw_upload_flag")
	private String fjswUploadFlag;

	@Column(name="fk_print_num")
	private int fkPrintNum;

	@Column(name="good_type_desc")
	private String goodTypeDesc;

	@Column(name="if_fk_print")
	private Integer ifFkPrint;

	@Column(name="if_print")
	private Integer ifPrint;

	@Column(name="if_process")
	private String ifProcess;

	private String memo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modify_date")
	private Date modifyDate;

	@Column(name="modify_person_id")
	private Long modifyPersonId;

	@Column(name="modify_person_name")
	private String modifyPersonName;

	@Column(name="no_tax_amount")
	private BigDecimal noTaxAmount;

	@Column(name="pay_from_type")
	private String payFromType;

	@Column(name="platform_id")
	private String platformId;

	@Column(name="print_num")
	private Integer printNum;

	@Column(name="reinvoice_amount")
	private BigDecimal reinvoiceAmount;

	@Column(name="reinvoice_batch_no")
	private String reinvoiceBatchNo;

	@Column(name="reinvoice_master_num")
	private String reinvoiceMasterNum;

	@Column(name="reinvoice_no")
	private String reinvoiceNo;

	@Column(name="reinvoice_status")
	private String reinvoiceStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="reinvoice_time")
	private Date reinvoiceTime;

	@Column(name="reinvoice_title_id")
	private int reinvoiceTitleId;

	@Column(name="reinvoice_title_name")
	private String reinvoiceTitleName;

	@Column(name="reinvoice_weight")
	private BigDecimal reinvoiceWeight;

	@Column(name="start_plate")
	private String startPlate;

	@Column(name="tax_rate")
	private BigDecimal taxRate;

	@Column(name="vehicle_num")
	private String vehicleNum;

	public ReinvoicemasterEntity() {
	}

	public Long getReinvoiceMasterId() {
		return reinvoiceMasterId;
	}

	public void setReinvoiceMasterId(Long reinvoiceMasterId) {
		this.reinvoiceMasterId = reinvoiceMasterId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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

	public Long getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}

	public String getDrawerAddress() {
		return drawerAddress;
	}

	public void setDrawerAddress(String drawerAddress) {
		this.drawerAddress = drawerAddress;
	}

	public String getDrawerMobile() {
		return drawerMobile;
	}

	public void setDrawerMobile(String drawerMobile) {
		this.drawerMobile = drawerMobile;
	}

	public String getDrawerName() {
		return drawerName;
	}

	public void setDrawerName(String drawerName) {
		this.drawerName = drawerName;
	}

	public String getDrawerNo() {
		return drawerNo;
	}

	public void setDrawerNo(String drawerNo) {
		this.drawerNo = drawerNo;
	}

	public String getEndPlate() {
		return endPlate;
	}

	public void setEndPlate(String endPlate) {
		this.endPlate = endPlate;
	}

	public String getFjswReturnMsg() {
		return fjswReturnMsg;
	}

	public void setFjswReturnMsg(String fjswReturnMsg) {
		this.fjswReturnMsg = fjswReturnMsg;
	}

	public Date getFjswUploadDate() {
		return fjswUploadDate;
	}

	public void setFjswUploadDate(Date fjswUploadDate) {
		this.fjswUploadDate = fjswUploadDate;
	}

	public String getFjswUploadFlag() {
		return fjswUploadFlag;
	}

	public void setFjswUploadFlag(String fjswUploadFlag) {
		this.fjswUploadFlag = fjswUploadFlag;
	}

	public int getFkPrintNum() {
		return fkPrintNum;
	}

	public void setFkPrintNum(int fkPrintNum) {
		this.fkPrintNum = fkPrintNum;
	}

	public String getGoodTypeDesc() {
		return goodTypeDesc;
	}

	public void setGoodTypeDesc(String goodTypeDesc) {
		this.goodTypeDesc = goodTypeDesc;
	}

	public Integer getIfFkPrint() {
		return ifFkPrint;
	}

	public void setIfFkPrint(Integer ifFkPrint) {
		this.ifFkPrint = ifFkPrint;
	}

	public Integer getIfPrint() {
		return ifPrint;
	}

	public void setIfPrint(Integer ifPrint) {
		this.ifPrint = ifPrint;
	}

	public String getIfProcess() {
		return ifProcess;
	}

	public void setIfProcess(String ifProcess) {
		this.ifProcess = ifProcess;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
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

	public BigDecimal getNoTaxAmount() {
		return noTaxAmount;
	}

	public void setNoTaxAmount(BigDecimal noTaxAmount) {
		this.noTaxAmount = noTaxAmount;
	}

	public String getPayFromType() {
		return payFromType;
	}

	public void setPayFromType(String payFromType) {
		this.payFromType = payFromType;
	}

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public Integer getPrintNum() {
		return printNum;
	}

	public void setPrintNum(Integer printNum) {
		this.printNum = printNum;
	}

	public BigDecimal getReinvoiceAmount() {
		return reinvoiceAmount;
	}

	public void setReinvoiceAmount(BigDecimal reinvoiceAmount) {
		this.reinvoiceAmount = reinvoiceAmount;
	}

	public String getReinvoiceBatchNo() {
		return reinvoiceBatchNo;
	}

	public void setReinvoiceBatchNo(String reinvoiceBatchNo) {
		this.reinvoiceBatchNo = reinvoiceBatchNo;
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

	public String getReinvoiceStatus() {
		return reinvoiceStatus;
	}

	public void setReinvoiceStatus(String reinvoiceStatus) {
		this.reinvoiceStatus = reinvoiceStatus;
	}

	public Date getReinvoiceTime() {
		return reinvoiceTime;
	}

	public void setReinvoiceTime(Date reinvoiceTime) {
		this.reinvoiceTime = reinvoiceTime;
	}

	public int getReinvoiceTitleId() {
		return reinvoiceTitleId;
	}

	public void setReinvoiceTitleId(int reinvoiceTitleId) {
		this.reinvoiceTitleId = reinvoiceTitleId;
	}

	public String getReinvoiceTitleName() {
		return reinvoiceTitleName;
	}

	public void setReinvoiceTitleName(String reinvoiceTitleName) {
		this.reinvoiceTitleName = reinvoiceTitleName;
	}

	public BigDecimal getReinvoiceWeight() {
		return reinvoiceWeight;
	}

	public void setReinvoiceWeight(BigDecimal reinvoiceWeight) {
		this.reinvoiceWeight = reinvoiceWeight;
	}

	public String getStartPlate() {
		return startPlate;
	}

	public void setStartPlate(String startPlate) {
		this.startPlate = startPlate;
	}

	public BigDecimal getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}

	public String getVehicleNum() {
		return vehicleNum;
	}

	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}

	
}