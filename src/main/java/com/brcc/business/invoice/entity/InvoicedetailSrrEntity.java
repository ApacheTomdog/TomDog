package com.brcc.business.invoice.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "invoicedetail_srr")
@DynamicInsert
@DynamicUpdate
@NamedQuery(name="InvoicedetailSrrEntity.findAll", query="SELECT i FROM InvoicedetailSrrEntity i")
public class InvoicedetailSrrEntity {
    private Long invoiceDetailSrrId;
    private Long invoiceDetailId;
    private Long invoiceMasterId;
    private Long invoiceSplitId;
    private String invoiceSplitNum;
    private String invoiceNo;
    private Long payBillId;
    private Long deliveryId;
    private Long transId;
    private Long publishId;
    private Long vatFlowMasterId;
    private BigDecimal invoiceActualAmount;
    private BigDecimal invoiceActualWeight;
    private Long invoiceTitleId;
    private String invoiceTitleName;
    private Long invoiceClientId;
    private String invoiceClientName;
    private Date createDate;
    private Long createPersonId;
    private String createPersonName;
    private Date modifyDate;
    private Long modifyPersonId;
    private String modifyPersonName;
    private String ifInvoice;
    private String platformId;
    private String ifBegin;
    private String startPlate;
    private String endPlate;
    private Long driverId;
    private String driverName;
    private Long vehicleId;
    private String vehicleNum;
    private String goodTypeDesc;
    private String remark;
    private Date invoiceAgreeTime;
    private Integer ticketOpeningMark;
    private BigDecimal truckLoadingWeight;
    private BigDecimal takeDeliveryWeight;
    private Long vatCapitalDetailId;

    @Id
    @Column(name = "invoice_detail_srr_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getInvoiceDetailSrrId() {
        return invoiceDetailSrrId;
    }

    public void setInvoiceDetailSrrId(Long invoiceDetailSrrId) {
        this.invoiceDetailSrrId = invoiceDetailSrrId;
    }

    @Basic
    @Column(name = "invoice_detail_id")
    public Long getInvoiceDetailId() {
        return invoiceDetailId;
    }

    public void setInvoiceDetailId(Long invoiceDetailId) {
        this.invoiceDetailId = invoiceDetailId;
    }

    @Basic
    @Column(name = "invoice_master_id")
    public Long getInvoiceMasterId() {
        return invoiceMasterId;
    }

    public void setInvoiceMasterId(Long invoiceMasterId) {
        this.invoiceMasterId = invoiceMasterId;
    }

    @Basic
    @Column(name = "invoice_split_id")
    public Long getInvoiceSplitId() {
        return invoiceSplitId;
    }

    public void setInvoiceSplitId(Long invoiceSplitId) {
        this.invoiceSplitId = invoiceSplitId;
    }

    @Basic
    @Column(name = "invoice_split_num")
    public String getInvoiceSplitNum() {
        return invoiceSplitNum;
    }

    public void setInvoiceSplitNum(String invoiceSplitNum) {
        this.invoiceSplitNum = invoiceSplitNum;
    }

    @Basic
    @Column(name = "invoice_no")
    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    @Basic
    @Column(name = "pay_bill_id")
    public Long getPayBillId() {
        return payBillId;
    }

    public void setPayBillId(Long payBillId) {
        this.payBillId = payBillId;
    }

    @Basic
    @Column(name = "delivery_id")
    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    @Basic
    @Column(name = "trans_id")
    public Long getTransId() {
        return transId;
    }

    public void setTransId(Long transId) {
        this.transId = transId;
    }

    @Basic
    @Column(name = "publish_id")
    public Long getPublishId() {
        return publishId;
    }

    public void setPublishId(Long publishId) {
        this.publishId = publishId;
    }

    @Basic
    @Column(name = "vat_flow_master_id")
    public Long getVatFlowMasterId() {
        return vatFlowMasterId;
    }

    public void setVatFlowMasterId(Long vatFlowMasterId) {
        this.vatFlowMasterId = vatFlowMasterId;
    }

    @Basic
    @Column(name = "invoice_actual_amount")
    public BigDecimal getInvoiceActualAmount() {
        return invoiceActualAmount;
    }

    public void setInvoiceActualAmount(BigDecimal invoiceActualAmount) {
        this.invoiceActualAmount = invoiceActualAmount;
    }

    @Basic
    @Column(name = "invoice_actual_weight")
    public BigDecimal getInvoiceActualWeight() {
        return invoiceActualWeight;
    }

    public void setInvoiceActualWeight(BigDecimal invoiceActualWeight) {
        this.invoiceActualWeight = invoiceActualWeight;
    }

    @Basic
    @Column(name = "invoice_title_id")
    public Long getInvoiceTitleId() {
        return invoiceTitleId;
    }

    public void setInvoiceTitleId(Long invoiceTitleId) {
        this.invoiceTitleId = invoiceTitleId;
    }

    @Basic
    @Column(name = "invoice_title_name")
    public String getInvoiceTitleName() {
        return invoiceTitleName;
    }

    public void setInvoiceTitleName(String invoiceTitleName) {
        this.invoiceTitleName = invoiceTitleName;
    }

    @Basic
    @Column(name = "invoice_client_id")
    public Long getInvoiceClientId() {
        return invoiceClientId;
    }

    public void setInvoiceClientId(Long invoiceClientId) {
        this.invoiceClientId = invoiceClientId;
    }

    @Basic
    @Column(name = "invoice_client_name")
    public String getInvoiceClientName() {
        return invoiceClientName;
    }

    public void setInvoiceClientName(String invoiceClientName) {
        this.invoiceClientName = invoiceClientName;
    }

    @Basic
    @Column(name = "create_date")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "create_person_id")
    public Long getCreatePersonId() {
        return createPersonId;
    }

    public void setCreatePersonId(Long createPersonId) {
        this.createPersonId = createPersonId;
    }

    @Basic
    @Column(name = "create_person_name")
    public String getCreatePersonName() {
        return createPersonName;
    }

    public void setCreatePersonName(String createPersonName) {
        this.createPersonName = createPersonName;
    }

    @Basic
    @Column(name = "modify_date")
    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Basic
    @Column(name = "modify_person_id")
    public Long getModifyPersonId() {
        return modifyPersonId;
    }

    public void setModifyPersonId(Long modifyPersonId) {
        this.modifyPersonId = modifyPersonId;
    }

    @Basic
    @Column(name = "modify_person_name")
    public String getModifyPersonName() {
        return modifyPersonName;
    }

    public void setModifyPersonName(String modifyPersonName) {
        this.modifyPersonName = modifyPersonName;
    }

    @Basic
    @Column(name = "if_invoice")
    public String getIfInvoice() {
        return ifInvoice;
    }

    public void setIfInvoice(String ifInvoice) {
        this.ifInvoice = ifInvoice;
    }

    @Basic
    @Column(name = "platform_id")
    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    @Basic
    @Column(name = "if_begin")
    public String getIfBegin() {
        return ifBegin;
    }

    public void setIfBegin(String ifBegin) {
        this.ifBegin = ifBegin;
    }

    @Basic
    @Column(name = "start_plate")
    public String getStartPlate() {
        return startPlate;
    }

    public void setStartPlate(String startPlate) {
        this.startPlate = startPlate;
    }

    @Basic
    @Column(name = "end_plate")
    public String getEndPlate() {
        return endPlate;
    }

    public void setEndPlate(String endPlate) {
        this.endPlate = endPlate;
    }

    @Basic
    @Column(name = "driver_id")
    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    @Basic
    @Column(name = "driver_name")
    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    @Basic
    @Column(name = "vehicle_id")
    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Basic
    @Column(name = "vehicle_num")
    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    @Basic
    @Column(name = "good_type_desc")
    public String getGoodTypeDesc() {
        return goodTypeDesc;
    }

    public void setGoodTypeDesc(String goodTypeDesc) {
        this.goodTypeDesc = goodTypeDesc;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "invoice_agree_time")
    public Date getInvoiceAgreeTime() {
        return invoiceAgreeTime;
    }

    public void setInvoiceAgreeTime(Date invoiceAgreeTime) {
        this.invoiceAgreeTime = invoiceAgreeTime;
    }

    @Basic
    @Column(name = "ticket_opening_mark")
    public Integer getTicketOpeningMark() {
        return ticketOpeningMark;
    }

    public void setTicketOpeningMark(Integer ticketOpeningMark) {
        this.ticketOpeningMark = ticketOpeningMark;
    }

    @Basic
    @Column(name = "truck_loading_weight")
    public BigDecimal getTruckLoadingWeight() {
        return truckLoadingWeight;
    }

    public void setTruckLoadingWeight(BigDecimal truckLoadingWeight) {
        this.truckLoadingWeight = truckLoadingWeight;
    }

    @Basic
    @Column(name = "take_delivery_weight")
    public BigDecimal getTakeDeliveryWeight() {
        return takeDeliveryWeight;
    }

    public void setTakeDeliveryWeight(BigDecimal takeDeliveryWeight) {
        this.takeDeliveryWeight = takeDeliveryWeight;
    }

    @Basic
    @Column(name = "vat_capital_detail_id")
    public Long getVatCapitalDetailId() {
        return vatCapitalDetailId;
    }

    public void setVatCapitalDetailId(Long vatCapitalDetailId) {
        this.vatCapitalDetailId = vatCapitalDetailId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoicedetailSrrEntity that = (InvoicedetailSrrEntity) o;
        return invoiceDetailSrrId == that.invoiceDetailSrrId &&
                vatCapitalDetailId == that.vatCapitalDetailId &&
                Objects.equals(invoiceDetailId, that.invoiceDetailId) &&
                Objects.equals(invoiceMasterId, that.invoiceMasterId) &&
                Objects.equals(invoiceSplitId, that.invoiceSplitId) &&
                Objects.equals(invoiceSplitNum, that.invoiceSplitNum) &&
                Objects.equals(invoiceNo, that.invoiceNo) &&
                Objects.equals(payBillId, that.payBillId) &&
                Objects.equals(deliveryId, that.deliveryId) &&
                Objects.equals(transId, that.transId) &&
                Objects.equals(publishId, that.publishId) &&
                Objects.equals(vatFlowMasterId, that.vatFlowMasterId) &&
                Objects.equals(invoiceActualAmount, that.invoiceActualAmount) &&
                Objects.equals(invoiceActualWeight, that.invoiceActualWeight) &&
                Objects.equals(invoiceTitleId, that.invoiceTitleId) &&
                Objects.equals(invoiceTitleName, that.invoiceTitleName) &&
                Objects.equals(invoiceClientId, that.invoiceClientId) &&
                Objects.equals(invoiceClientName, that.invoiceClientName) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(createPersonId, that.createPersonId) &&
                Objects.equals(createPersonName, that.createPersonName) &&
                Objects.equals(modifyDate, that.modifyDate) &&
                Objects.equals(modifyPersonId, that.modifyPersonId) &&
                Objects.equals(modifyPersonName, that.modifyPersonName) &&
                Objects.equals(ifInvoice, that.ifInvoice) &&
                Objects.equals(platformId, that.platformId) &&
                Objects.equals(ifBegin, that.ifBegin) &&
                Objects.equals(startPlate, that.startPlate) &&
                Objects.equals(endPlate, that.endPlate) &&
                Objects.equals(driverId, that.driverId) &&
                Objects.equals(driverName, that.driverName) &&
                Objects.equals(vehicleId, that.vehicleId) &&
                Objects.equals(vehicleNum, that.vehicleNum) &&
                Objects.equals(goodTypeDesc, that.goodTypeDesc) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(invoiceAgreeTime, that.invoiceAgreeTime) &&
                Objects.equals(ticketOpeningMark, that.ticketOpeningMark) &&
                Objects.equals(truckLoadingWeight, that.truckLoadingWeight) &&
                Objects.equals(takeDeliveryWeight, that.takeDeliveryWeight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceDetailSrrId, invoiceDetailId, invoiceMasterId, invoiceSplitId, invoiceSplitNum, invoiceNo, payBillId, deliveryId, transId, publishId, vatFlowMasterId, invoiceActualAmount, invoiceActualWeight, invoiceTitleId, invoiceTitleName, invoiceClientId, invoiceClientName, createDate, createPersonId, createPersonName, modifyDate, modifyPersonId, modifyPersonName, ifInvoice, platformId, ifBegin, startPlate, endPlate, driverId, driverName, vehicleId, vehicleNum, goodTypeDesc, remark, invoiceAgreeTime, ticketOpeningMark, truckLoadingWeight, takeDeliveryWeight, vatCapitalDetailId);
    }
}
/**
 * @Description
 * @Author pjy
 * @Date
 **/