package com.brcc.business.vatcapital.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * @Description:
 * @Auther: gemaochao
 * @Date:Created in 11:37 2018/11/16
 */
@Entity
@Table(name = "vatcapitalmaster")
public class VatcapitalmasterEntity {

    @Id
    @Column(name = "vat_capital_master_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vatCapitalMasterId;

    @Basic
    @Column(name = "client_id")
    private Long clientId;

    @Basic
    @Column(name = "client_name")
    private String clientName;

    @Basic
    @Column(name = "carry_id")
    private Long carryId;

    @Basic
    @Column(name = "carry_name")
    private String carryName;

    @Basic
    @Column(name = "platform_id")
    private String platformId;

    @Basic
    @Column(name = "total_credit_amount")
    private BigDecimal totalCreditAmount;

    @Basic
    @Column(name = "total_in_amount")
    private BigDecimal totalInAmount;

    @Basic
    @Column(name = "total_out_amount")
    private BigDecimal totalOutAmount;

    @Basic
    @Column(name = "total_use_amount")
    private BigDecimal totalUseAmount;

    @Basic
    @Column(name = "total_block_amount")
    private BigDecimal totalBlockAmount;

    @Basic
    @Column(name = "total_refund_amount")
    private BigDecimal totalRefundAmount;

    @Basic
    @Column(name = "total_invoiced_amount")
    private BigDecimal totalInvoicedAmount;

    @Basic
    @Column(name = "create_date")
    private Date createDate;

    @Basic
    @Column(name = "modify_date")
    private Date modifyDate;


    public Long getVatCapitalMasterId() {
        return vatCapitalMasterId;
    }

    public void setVatCapitalMasterId(Long vatCapitalMasterId) {
        this.vatCapitalMasterId = vatCapitalMasterId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Long getCarryId() {
        return carryId;
    }

    public void setCarryId(Long carryId) {
        this.carryId = carryId;
    }

    public String getCarryName() {
        return carryName;
    }

    public void setCarryName(String carryName) {
        this.carryName = carryName;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public BigDecimal getTotalCreditAmount() {
        return totalCreditAmount;
    }

    public void setTotalCreditAmount(BigDecimal totalCreditAmount) {
        this.totalCreditAmount = totalCreditAmount;
    }

    public BigDecimal getTotalInAmount() {
        return totalInAmount;
    }

    public void setTotalInAmount(BigDecimal totalInAmount) {
        this.totalInAmount = totalInAmount;
    }

    public BigDecimal getTotalOutAmount() {
        return totalOutAmount;
    }

    public void setTotalOutAmount(BigDecimal totalOutAmount) {
        this.totalOutAmount = totalOutAmount;
    }

    public BigDecimal getTotalUseAmount() {
        return totalUseAmount;
    }

    public void setTotalUseAmount(BigDecimal totalUseAmount) {
        this.totalUseAmount = totalUseAmount;
    }

    public BigDecimal getTotalBlockAmount() {
        return totalBlockAmount;
    }

    public void setTotalBlockAmount(BigDecimal totalBlockAmount) {
        this.totalBlockAmount = totalBlockAmount;
    }

    public BigDecimal getTotalRefundAmount() {
        return totalRefundAmount;
    }

    public void setTotalRefundAmount(BigDecimal totalRefundAmount) {
        this.totalRefundAmount = totalRefundAmount;
    }

    public BigDecimal getTotalInvoicedAmount() {
        return totalInvoicedAmount;
    }

    public void setTotalInvoicedAmount(BigDecimal totalInvoicedAmount) {
        this.totalInvoicedAmount = totalInvoicedAmount;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VatcapitalmasterEntity that = (VatcapitalmasterEntity) o;
        return vatCapitalMasterId == that.vatCapitalMasterId &&
                Objects.equals(clientId, that.clientId) &&
                Objects.equals(clientName, that.clientName) &&
                Objects.equals(carryId, that.carryId) &&
                Objects.equals(carryName, that.carryName) &&
                Objects.equals(platformId, that.platformId) &&
                Objects.equals(totalCreditAmount, that.totalCreditAmount) &&
                Objects.equals(totalInAmount, that.totalInAmount) &&
                Objects.equals(totalOutAmount, that.totalOutAmount) &&
                Objects.equals(totalUseAmount, that.totalUseAmount) &&
                Objects.equals(totalBlockAmount, that.totalBlockAmount) &&
                Objects.equals(totalRefundAmount, that.totalRefundAmount) &&
                Objects.equals(totalInvoicedAmount, that.totalInvoicedAmount) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(modifyDate, that.modifyDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vatCapitalMasterId, clientId, clientName, carryId, carryName, platformId, totalCreditAmount, totalInAmount, totalOutAmount, totalUseAmount, totalBlockAmount, totalRefundAmount, totalInvoicedAmount, createDate, modifyDate);
    }
}
