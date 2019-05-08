package com.brcc.business.invoice.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the invoicedetail_log database table.
 * 
 */
@Entity
@Table(name="invoicedetail_log")
@DynamicInsert
@DynamicUpdate
@NamedQuery(name="InvoicedetailLogEntity.findAll", query="SELECT i FROM InvoicedetailLogEntity i")
public class InvoicedetailLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="invoice_detail_id")
	private Long invoiceDetailId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="create_person_id")
	private Long createPersonId;

	@Column(name="create_person_name")
	private String createPersonName;

	@Column(name="delivery_id")
	private Long deliveryId;

	@Column(name="driver_id")
	private Long driverId;

	@Column(name="driver_name")
	private String driverName;

	@Column(name="end_plate")
	private String endPlate;

	@Column(name="good_type_desc")
	private String goodTypeDesc;

	@Column(name="if_begin")
	private String ifBegin;

	@Column(name="if_invoice")
	private String ifInvoice;

	@Column(name="invoice_actual_amount")
	private BigDecimal invoiceActualAmount;

	@Column(name="invoice_actual_weight")
	private BigDecimal invoiceActualWeight;

	@Column(name="invoice_client_id")
	private Long invoiceClientId;

	@Column(name="invoice_client_name")
	private String invoiceClientName;

	@Column(name="invoice_master_id")
	private Long invoiceMasterId;

	@Column(name="invoice_title_id")
	private Long invoiceTitleId;

	@Column(name="invoice_title_name")
	private String invoiceTitleName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modify_date")
	private Date modifyDate;

	@Column(name="modify_person_id")
	private Long modifyPersonId;

	@Column(name="modify_person_name")
	private String modifyPersonName;

	@Column(name="pay_bill_id")
	private Long payBillId;

	@Column(name="platform_id")
	private String platformId;

	@Column(name="publish_id")
	private Long publishId;

	@Column(name="start_plate")
	private String startPlate;

	@Column(name="take_delivery_weight")
	private BigDecimal takeDeliveryWeight;

	@Column(name="ticket_opening_mark")
	private Integer ticketOpeningMark;

	@Column(name="trans_id")
	private Long transId;

	@Column(name="truck_loading_weight")
	private BigDecimal truckLoadingWeight;

	@Column(name="vat_capital_detail_id")
	private Long vatCapitalDetailId;

	@Column(name="vat_flow_master_id")
	private Long vatFlowMasterId;

	@Column(name="vehicle_id")
	private Long vehicleId;

	@Column(name="vehicle_num")
	private String vehicleNum;

	public InvoicedetailLogEntity() {
	}

	public Long getInvoiceDetailId() {
		return this.invoiceDetailId;
	}

	public void setInvoiceDetailId(Long invoiceDetailId) {
		this.invoiceDetailId = invoiceDetailId;
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

	public Long getDriverId() {
		return this.driverId;
	}

	public void setDriverId(Long driverId) {
		this.driverId = driverId;
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

	public String getGoodTypeDesc() {
		return this.goodTypeDesc;
	}

	public void setGoodTypeDesc(String goodTypeDesc) {
		this.goodTypeDesc = goodTypeDesc;
	}

	public String getIfBegin() {
		return this.ifBegin;
	}

	public void setIfBegin(String ifBegin) {
		this.ifBegin = ifBegin;
	}

	public String getIfInvoice() {
		return this.ifInvoice;
	}

	public void setIfInvoice(String ifInvoice) {
		this.ifInvoice = ifInvoice;
	}

	public BigDecimal getInvoiceActualAmount() {
		return this.invoiceActualAmount;
	}

	public void setInvoiceActualAmount(BigDecimal invoiceActualAmount) {
		this.invoiceActualAmount = invoiceActualAmount;
	}

	public BigDecimal getInvoiceActualWeight() {
		return this.invoiceActualWeight;
	}

	public void setInvoiceActualWeight(BigDecimal invoiceActualWeight) {
		this.invoiceActualWeight = invoiceActualWeight;
	}

	public Long getInvoiceClientId() {
		return this.invoiceClientId;
	}

	public void setInvoiceClientId(Long invoiceClientId) {
		this.invoiceClientId = invoiceClientId;
	}

	public String getInvoiceClientName() {
		return this.invoiceClientName;
	}

	public void setInvoiceClientName(String invoiceClientName) {
		this.invoiceClientName = invoiceClientName;
	}

	public Long getInvoiceMasterId() {
		return this.invoiceMasterId;
	}

	public void setInvoiceMasterId(Long invoiceMasterId) {
		this.invoiceMasterId = invoiceMasterId;
	}


	public Long getInvoiceTitleId() {
		return this.invoiceTitleId;
	}

	public void setInvoiceTitleId(Long invoiceTitleId) {
		this.invoiceTitleId = invoiceTitleId;
	}

	public String getInvoiceTitleName() {
		return this.invoiceTitleName;
	}

	public void setInvoiceTitleName(String invoiceTitleName) {
		this.invoiceTitleName = invoiceTitleName;
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

	public Long getPayBillId() {
		return this.payBillId;
	}

	public void setPayBillId(Long payBillId) {
		this.payBillId = payBillId;
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

	public String getStartPlate() {
		return this.startPlate;
	}

	public void setStartPlate(String startPlate) {
		this.startPlate = startPlate;
	}

	public BigDecimal getTakeDeliveryWeight() {
		return this.takeDeliveryWeight;
	}

	public void setTakeDeliveryWeight(BigDecimal takeDeliveryWeight) {
		this.takeDeliveryWeight = takeDeliveryWeight;
	}

	public Integer getTicketOpeningMark() {
		return this.ticketOpeningMark;
	}

	public void setTicketOpeningMark(Integer ticketOpeningMark) {
		this.ticketOpeningMark = ticketOpeningMark;
	}

	public Long getTransId() {
		return this.transId;
	}

	public void setTransId(Long transId) {
		this.transId = transId;
	}

	public BigDecimal getTruckLoadingWeight() {
		return this.truckLoadingWeight;
	}

	public void setTruckLoadingWeight(BigDecimal truckLoadingWeight) {
		this.truckLoadingWeight = truckLoadingWeight;
	}

	public Long getVatCapitalDetailId() {
		return this.vatCapitalDetailId;
	}

	public void setVatCapitalDetailId(Long vatCapitalDetailId) {
		this.vatCapitalDetailId = vatCapitalDetailId;
	}

	public Long getVatFlowMasterId() {
		return this.vatFlowMasterId;
	}

	public void setVatFlowMasterId(Long vatFlowMasterId) {
		this.vatFlowMasterId = vatFlowMasterId;
	}

	public Long getVehicleId() {
		return this.vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleNum() {
		return this.vehicleNum;
	}

	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}

}