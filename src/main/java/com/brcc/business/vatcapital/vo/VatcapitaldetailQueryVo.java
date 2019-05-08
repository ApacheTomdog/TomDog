package com.brcc.business.vatcapital.vo;

import com.esteel.common.vo.BaseQueryVo;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description:
 * @Auther: gemaochao
 * @Date:Created in 11:37 2018/11/16
 */
public class VatcapitaldetailQueryVo extends BaseQueryVo {


    private Long vatCapitalDetailId;

    private Long clientId;

    private String clientName;

    private Long carryId;

    private String carryName;

    private String platformId;

    private BigDecimal inAmount;

    private BigDecimal outAmount;

    private BigDecimal blockInAmount;

    private BigDecimal blockOutAmount;

    private String blockStatus;

    private String docuType;

    private String docuId;

    private String docuNum;

    private String docuFrom;

    private String docuMemo;

    private Date createDate;

    private Long createPersonId;

    private String createPersonName;

    private Date modifyDate;

    private Long modifyPersonId;

    private String modifyPersonName;

    private String ifInvoice;

    private Long vatFlowMasterId;

    private String ownerAdjustFlag;

    private Long redFlushFlag;

    private BigDecimal outAmountAgain;

    private String outAmountAgainFlag;


    //新加字段
    private BigDecimal amount;

    private String modifyTime;

    private Date modifyStart;
    private Date modifyEnd;

    public Date getModifyStart() {
        return modifyStart;
    }

    public void setModifyStart(Date modifyStart) {
        this.modifyStart = modifyStart;
    }

    public Date getModifyEnd() {
        return modifyEnd;
    }

    public void setModifyEnd(Date modifyEnd) {
        this.modifyEnd = modifyEnd;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

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


}
