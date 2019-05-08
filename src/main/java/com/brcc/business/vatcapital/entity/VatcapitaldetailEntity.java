package com.brcc.business.vatcapital.entity;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;

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
@DynamicInsert
@Table(name = "vatcapitaldetail")
public class VatcapitaldetailEntity {

    @Id
    @Column(name = "vat_capital_detail_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vatCapitalDetailId;

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
    @Column(name = "in_amount")
    private BigDecimal inAmount;

    @Basic
    @Column(name = "out_amount")
    private BigDecimal outAmount;

    @Basic
    @Column(name = "block_in_amount")
    private BigDecimal blockInAmount;

    @Basic
    @Column(name = "block_out_amount")
    private BigDecimal blockOutAmount;

    @Basic
    @Column(name = "block_status")
    private String blockStatus;

    @Basic
    @Column(name = "docu_type")
    private String docuType;

    @Basic
    @Column(name = "docu_id")
    private String docuId;

    @Basic
    @Column(name = "docu_num")
    private String docuNum;

    @Basic
    @Column(name = "docu_from")
    private String docuFrom;

    @Basic
    @Column(name = "docu_memo")
    private String docuMemo;

    @Basic
    @Column(name = "create_date")
    private Date createDate;

    @Basic
    @Column(name = "create_person_id")
    private Long createPersonId;

    @Basic
    @Column(name = "create_person_name")
    private String createPersonName;

    @Basic
    @Column(name = "modify_date")
    private Date modifyDate;

    @Basic
    @Column(name = "modify_person_id")
    private Long modifyPersonId;

    @Basic
    @Column(name = "modify_person_name")
    private String modifyPersonName;

    @Basic
    @Column(name = "if_invoice")
    private String ifInvoice;

    @Basic
    @Column(name = "vat_flow_master_id")
    private Long vatFlowMasterId;

    @Basic
    @Column(name = "owner_adjust_flag")
    private String ownerAdjustFlag;

    @Basic
    @Column(name = "red_flush_flag")
    private Long redFlushFlag;

    @Basic
    @Column(name = "out_amount_again")
    private BigDecimal outAmountAgain;

    @Basic
    @Column(name = "out_amount_again_flag")
    private String outAmountAgainFlag;


    public Long getVatCapitalDetailId() {
        return vatCapitalDetailId;
    }

    public void setVatCapitalDetailId(Long vatCapitalDetailId) {
        this.vatCapitalDetailId = vatCapitalDetailId;
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

    public BigDecimal getInAmount() {
        return inAmount;
    }

    public void setInAmount(BigDecimal inAmount) {
        this.inAmount = inAmount;
    }

    public BigDecimal getOutAmount() {
        return outAmount;
    }

    public void setOutAmount(BigDecimal outAmount) {
        this.outAmount = outAmount;
    }

    public BigDecimal getBlockInAmount() {
        return blockInAmount;
    }

    public void setBlockInAmount(BigDecimal blockInAmount) {
        this.blockInAmount = blockInAmount;
    }

    public BigDecimal getBlockOutAmount() {
        return blockOutAmount;
    }

    public void setBlockOutAmount(BigDecimal blockOutAmount) {
        this.blockOutAmount = blockOutAmount;
    }

    public String getBlockStatus() {
        return blockStatus;
    }

    public void setBlockStatus(String blockStatus) {
        this.blockStatus = blockStatus;
    }

    public String getDocuType() {
        return docuType;
    }

    public void setDocuType(String docuType) {
        this.docuType = docuType;
    }

    public String getDocuId() {
        return docuId;
    }

    public void setDocuId(String docuId) {
        this.docuId = docuId;
    }

    public String getDocuNum() {
        return docuNum;
    }

    public void setDocuNum(String docuNum) {
        this.docuNum = docuNum;
    }

    public String getDocuFrom() {
        return docuFrom;
    }

    public void setDocuFrom(String docuFrom) {
        this.docuFrom = docuFrom;
    }

    public String getDocuMemo() {
        return docuMemo;
    }

    public void setDocuMemo(String docuMemo) {
        this.docuMemo = docuMemo;
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

    public String getIfInvoice() {
        return ifInvoice;
    }

    public void setIfInvoice(String ifInvoice) {
        this.ifInvoice = ifInvoice;
    }

    public Long getVatFlowMasterId() {
        return vatFlowMasterId;
    }

    public void setVatFlowMasterId(Long vatFlowMasterId) {
        this.vatFlowMasterId = vatFlowMasterId;
    }

    public String getOwnerAdjustFlag() {
        return ownerAdjustFlag;
    }

    public void setOwnerAdjustFlag(String ownerAdjustFlag) {
        this.ownerAdjustFlag = ownerAdjustFlag;
    }

    public Long getRedFlushFlag() {
        return redFlushFlag;
    }

    public void setRedFlushFlag(Long redFlushFlag) {
        this.redFlushFlag = redFlushFlag;
    }

    public BigDecimal getOutAmountAgain() {
        return outAmountAgain;
    }

    public void setOutAmountAgain(BigDecimal outAmountAgain) {
        this.outAmountAgain = outAmountAgain;
    }

    public String getOutAmountAgainFlag() {
        return outAmountAgainFlag;
    }

    public void setOutAmountAgainFlag(String outAmountAgainFlag) {
        this.outAmountAgainFlag = outAmountAgainFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VatcapitaldetailEntity that = (VatcapitaldetailEntity) o;
        return vatCapitalDetailId == that.vatCapitalDetailId &&
                Objects.equals(clientId, that.clientId) &&
                Objects.equals(clientName, that.clientName) &&
                Objects.equals(carryId, that.carryId) &&
                Objects.equals(carryName, that.carryName) &&
                Objects.equals(platformId, that.platformId) &&
                Objects.equals(inAmount, that.inAmount) &&
                Objects.equals(outAmount, that.outAmount) &&
                Objects.equals(blockInAmount, that.blockInAmount) &&
                Objects.equals(blockOutAmount, that.blockOutAmount) &&
                Objects.equals(blockStatus, that.blockStatus) &&
                Objects.equals(docuType, that.docuType) &&
                Objects.equals(docuId, that.docuId) &&
                Objects.equals(docuNum, that.docuNum) &&
                Objects.equals(docuFrom, that.docuFrom) &&
                Objects.equals(docuMemo, that.docuMemo) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(createPersonId, that.createPersonId) &&
                Objects.equals(createPersonName, that.createPersonName) &&
                Objects.equals(modifyDate, that.modifyDate) &&
                Objects.equals(modifyPersonId, that.modifyPersonId) &&
                Objects.equals(modifyPersonName, that.modifyPersonName) &&
                Objects.equals(ifInvoice, that.ifInvoice) &&
                Objects.equals(vatFlowMasterId, that.vatFlowMasterId) &&
                Objects.equals(ownerAdjustFlag, that.ownerAdjustFlag) &&
                Objects.equals(redFlushFlag, that.redFlushFlag) &&
                Objects.equals(outAmountAgain, that.outAmountAgain) &&
                Objects.equals(outAmountAgainFlag, that.outAmountAgainFlag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vatCapitalDetailId, clientId, clientName, carryId, carryName, platformId, inAmount, outAmount, blockInAmount, blockOutAmount, blockStatus, docuType, docuId, docuNum, docuFrom, docuMemo, createDate, createPersonId, createPersonName, modifyDate, modifyPersonId, modifyPersonName, ifInvoice, vatFlowMasterId, ownerAdjustFlag, redFlushFlag, outAmountAgain, outAmountAgainFlag);
    }
}
