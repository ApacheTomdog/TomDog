package com.brcc.business.transportSettle.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the pay_bill_child database table.
 */
@Entity
@Table(name = "pay_bill_child")
@DynamicInsert
@DynamicUpdate
@NamedQuery(name = "PayBillChildEntity.findAll", query = "SELECT p FROM PayBillChildEntity p")
public class PayBillChildEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zf_child_id")
    private int zfChildId;

    @Column(name = "platform_id")
    private String platformId;

    @Column(name = "account_type")
    private String accountType;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "create_person_id")
    private Long createPersonId;

    @Column(name = "create_person_name")
    private String createPersonName;

    @Column(name = "credit_no")
    private String creditNo;

    @Column(name = "cy_pay_flag")
    private String cyPayFlag;

    @Column(name = "dump_truck_charge")
    private BigDecimal dumpTruckCharge;

    @Column(name = "fjsw_return_msg")
    private String fjswReturnMsg;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fjsw_upload_date")
    private Date fjswUploadDate;

    @Column(name = "fjsw_upload_flag")
    private String fjswUploadFlag;

    @Column(name = "if_merge_flag")
    private String ifMergeFlag;

    @Column(name = "if_process")
    private String ifProcess;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "if_process_date")
    private Date ifProcessDate;

    @Column(name = "if_virtual")
    private String ifVirtual;

    @Column(name = "oil_amount")
    private BigDecimal oilAmount;

    @Column(name = "owner_payapply_cancel_flag")
    private String ownerPayapplyCancelFlag;

    @Column(name = "owner_payapply_flag")
    private String ownerPayapplyFlag;

    @Column(name = "pay_amount")
    private BigDecimal payAmount;

    @Column(name = "pay_amount_act")
    private BigDecimal payAmountAct;

    @Column(name = "pay_company_id")
    private Long payCompanyId;

    @Column(name = "pay_company_name")
    private String payCompanyName;

    @Column(name = "pay_failure_flag")
    private String payFailureFlag;

    @Column(name = "pay_failure_reason")
    private String payFailureReason;

    @Column(name = "pay_fee_amount")
    private BigDecimal payFeeAmount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "pay_finish_date")
    private Date payFinishDate;

    @Column(name = "pay_from_type")
    private String payFromType;

    @Column(name = "pay_id")
    private Long payId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "pay_initiated_date")
    private Date payInitiatedDate;

    @Column(name = "pay_num")
    private String payNum;

    @Column(name = "pay_person_id")
    private Long payPersonId;

    @Column(name = "pay_person_name")
    private String payPersonName;

    @Column(name = "pay_style")
    private String payStyle;

    @Column(name = "pay_times")
    private Integer payTimes;

    @Column(name = "rece_bank_city")
    private String receBankCity;

    @Column(name = "rece_bank_name")
    private String receBankName;

    @Column(name = "rece_bank_num")
    private String receBankNum;

    @Column(name = "rece_bank_owner")
    private String receBankOwner;

    @Column(name = "rece_bank_province")
    private String receBankProvince;

    @Column(name = "rece_bank_type")
    private String receBankType;

    @Column(name = "rece_company_id")
    private Long receCompanyId;

    @Column(name = "rece_company_name")
    private String receCompanyName;

    @Column(name = "rece_link_num")
    private String receLinkNum;

    @Column(name = "rece_subbranch_name")
    private String receSubbranchName;

    private String remark;

    @Column(name = "request_sn")
    private String requestSn;

    private String status;

    @Column(name = "tot_amount")
    private BigDecimal totAmount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "update_person_id")
    private Long updatePersonId;

    @Column(name = "update_person_name")
    private String updatePersonName;

    @Column(name = "zf_child_num")
    private String zfChildNum;

    @Column(name = "zf_id")
    private Long zfId;

    @Column(name = "zf_num")
    private String zfNum;

    @Column(name = "zg_detail_order_no")
    private String zgDetailOrderNo;

    @Column(name = "zg_order_no")
    private String zgOrderNo;

    @Column(name = "zg_out_trade_no")
    private String zgOutTradeNo;

    @Column(name = "zg_zf_num")
    private Integer zgZfNum;

    @Column(name = "tax_amount")
    private BigDecimal taxAmount;

    @Column(name = "rece_bank_owner_no")
    private String receBankOwnerNo;

    @Column(name = "company_owner_bank_id")
    private Long companyOwnerBankId;

    @Column(name = "company_owner_id")
    private Long companyOwnerId;

    @Column(name = "authority_flag")
    private String authorityFlag;

    public PayBillChildEntity() {
    }

    public int getZfChildId() {
        return zfChildId;
    }

    public void setZfChildId(int zfChildId) {
        this.zfChildId = zfChildId;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
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

    public String getCreditNo() {
        return this.creditNo;
    }

    public void setCreditNo(String creditNo) {
        this.creditNo = creditNo;
    }

    public String getCyPayFlag() {
        return this.cyPayFlag;
    }

    public void setCyPayFlag(String cyPayFlag) {
        this.cyPayFlag = cyPayFlag;
    }

    public BigDecimal getDumpTruckCharge() {
        return this.dumpTruckCharge;
    }

    public void setDumpTruckCharge(BigDecimal dumpTruckCharge) {
        this.dumpTruckCharge = dumpTruckCharge;
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

    public String getIfMergeFlag() {
        return this.ifMergeFlag;
    }

    public void setIfMergeFlag(String ifMergeFlag) {
        this.ifMergeFlag = ifMergeFlag;
    }

    public String getIfProcess() {
        return this.ifProcess;
    }

    public void setIfProcess(String ifProcess) {
        this.ifProcess = ifProcess;
    }

    public Date getIfProcessDate() {
        return this.ifProcessDate;
    }

    public void setIfProcessDate(Date ifProcessDate) {
        this.ifProcessDate = ifProcessDate;
    }

    public String getIfVirtual() {
        return this.ifVirtual;
    }

    public void setIfVirtual(String ifVirtual) {
        this.ifVirtual = ifVirtual;
    }

    public BigDecimal getOilAmount() {
        return this.oilAmount;
    }

    public void setOilAmount(BigDecimal oilAmount) {
        this.oilAmount = oilAmount;
    }

    public String getOwnerPayapplyCancelFlag() {
        return this.ownerPayapplyCancelFlag;
    }

    public void setOwnerPayapplyCancelFlag(String ownerPayapplyCancelFlag) {
        this.ownerPayapplyCancelFlag = ownerPayapplyCancelFlag;
    }

    public String getOwnerPayapplyFlag() {
        return this.ownerPayapplyFlag;
    }

    public void setOwnerPayapplyFlag(String ownerPayapplyFlag) {
        this.ownerPayapplyFlag = ownerPayapplyFlag;
    }

    public BigDecimal getPayAmount() {
        return this.payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public BigDecimal getPayAmountAct() {
        return this.payAmountAct;
    }

    public void setPayAmountAct(BigDecimal payAmountAct) {
        this.payAmountAct = payAmountAct;
    }

    public Long getPayCompanyId() {
        return this.payCompanyId;
    }

    public void setPayCompanyId(Long payCompanyId) {
        this.payCompanyId = payCompanyId;
    }

    public String getPayCompanyName() {
        return this.payCompanyName;
    }

    public void setPayCompanyName(String payCompanyName) {
        this.payCompanyName = payCompanyName;
    }

    public String getPayFailureFlag() {
        return this.payFailureFlag;
    }

    public void setPayFailureFlag(String payFailureFlag) {
        this.payFailureFlag = payFailureFlag;
    }

    public String getPayFailureReason() {
        return this.payFailureReason;
    }

    public void setPayFailureReason(String payFailureReason) {
        this.payFailureReason = payFailureReason;
    }

    public BigDecimal getPayFeeAmount() {
        return this.payFeeAmount;
    }

    public void setPayFeeAmount(BigDecimal payFeeAmount) {
        this.payFeeAmount = payFeeAmount;
    }

    public Date getPayFinishDate() {
        return this.payFinishDate;
    }

    public void setPayFinishDate(Date payFinishDate) {
        this.payFinishDate = payFinishDate;
    }

    public String getPayFromType() {
        return this.payFromType;
    }

    public void setPayFromType(String payFromType) {
        this.payFromType = payFromType;
    }

    public Long getPayId() {
        return this.payId;
    }

    public void setPayId(Long payId) {
        this.payId = payId;
    }

    public Date getPayInitiatedDate() {
        return this.payInitiatedDate;
    }

    public void setPayInitiatedDate(Date payInitiatedDate) {
        this.payInitiatedDate = payInitiatedDate;
    }

    public String getPayNum() {
        return this.payNum;
    }

    public void setPayNum(String payNum) {
        this.payNum = payNum;
    }

    public Long getPayPersonId() {
        return this.payPersonId;
    }

    public void setPayPersonId(Long payPersonId) {
        this.payPersonId = payPersonId;
    }

    public String getPayPersonName() {
        return this.payPersonName;
    }

    public void setPayPersonName(String payPersonName) {
        this.payPersonName = payPersonName;
    }

    public String getPayStyle() {
        return this.payStyle;
    }

    public void setPayStyle(String payStyle) {
        this.payStyle = payStyle;
    }

    public Integer getPayTimes() {
        return this.payTimes;
    }

    public void setPayTimes(Integer payTimes) {
        this.payTimes = payTimes;
    }

    public String getReceBankCity() {
        return this.receBankCity;
    }

    public void setReceBankCity(String receBankCity) {
        this.receBankCity = receBankCity;
    }

    public String getReceBankName() {
        return this.receBankName;
    }

    public void setReceBankName(String receBankName) {
        this.receBankName = receBankName;
    }

    public String getReceBankNum() {
        return this.receBankNum;
    }

    public void setReceBankNum(String receBankNum) {
        this.receBankNum = receBankNum;
    }

    public String getReceBankOwner() {
        return this.receBankOwner;
    }

    public void setReceBankOwner(String receBankOwner) {
        this.receBankOwner = receBankOwner;
    }

    public String getReceBankProvince() {
        return this.receBankProvince;
    }

    public void setReceBankProvince(String receBankProvince) {
        this.receBankProvince = receBankProvince;
    }

    public String getReceBankType() {
        return this.receBankType;
    }

    public void setReceBankType(String receBankType) {
        this.receBankType = receBankType;
    }

    public Long getReceCompanyId() {
        return this.receCompanyId;
    }

    public void setReceCompanyId(Long receCompanyId) {
        this.receCompanyId = receCompanyId;
    }

    public String getReceCompanyName() {
        return this.receCompanyName;
    }

    public void setReceCompanyName(String receCompanyName) {
        this.receCompanyName = receCompanyName;
    }

    public String getReceLinkNum() {
        return this.receLinkNum;
    }

    public void setReceLinkNum(String receLinkNum) {
        this.receLinkNum = receLinkNum;
    }

    public String getReceSubbranchName() {
        return this.receSubbranchName;
    }

    public void setReceSubbranchName(String receSubbranchName) {
        this.receSubbranchName = receSubbranchName;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRequestSn() {
        return this.requestSn;
    }

    public void setRequestSn(String requestSn) {
        this.requestSn = requestSn;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTotAmount() {
        return this.totAmount;
    }

    public void setTotAmount(BigDecimal totAmount) {
        this.totAmount = totAmount;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Long getUpdatePersonId() {
        return this.updatePersonId;
    }

    public void setUpdatePersonId(Long updatePersonId) {
        this.updatePersonId = updatePersonId;
    }

    public String getUpdatePersonName() {
        return this.updatePersonName;
    }

    public void setUpdatePersonName(String updatePersonName) {
        this.updatePersonName = updatePersonName;
    }

    public String getZfChildNum() {
        return this.zfChildNum;
    }

    public void setZfChildNum(String zfChildNum) {
        this.zfChildNum = zfChildNum;
    }

    public Long getZfId() {
        return this.zfId;
    }

    public void setZfId(Long zfId) {
        this.zfId = zfId;
    }

    public String getZfNum() {
        return this.zfNum;
    }

    public void setZfNum(String zfNum) {
        this.zfNum = zfNum;
    }

    public String getZgDetailOrderNo() {
        return this.zgDetailOrderNo;
    }

    public void setZgDetailOrderNo(String zgDetailOrderNo) {
        this.zgDetailOrderNo = zgDetailOrderNo;
    }

    public String getZgOrderNo() {
        return this.zgOrderNo;
    }

    public void setZgOrderNo(String zgOrderNo) {
        this.zgOrderNo = zgOrderNo;
    }

    public String getZgOutTradeNo() {
        return this.zgOutTradeNo;
    }

    public void setZgOutTradeNo(String zgOutTradeNo) {
        this.zgOutTradeNo = zgOutTradeNo;
    }

    public Integer getZgZfNum() {
        return this.zgZfNum;
    }

    public void setZgZfNum(Integer zgZfNum) {
        this.zgZfNum = zgZfNum;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getReceBankOwnerNo() {
        return receBankOwnerNo;
    }

    public void setReceBankOwnerNo(String receBankOwnerNo) {
        this.receBankOwnerNo = receBankOwnerNo;
    }

    public Long getCompanyOwnerBankId() {
        return companyOwnerBankId;
    }

    public void setCompanyOwnerBankId(Long companyOwnerBankId) {
        this.companyOwnerBankId = companyOwnerBankId;
    }

    public Long getCompanyOwnerId() {
        return companyOwnerId;
    }

    public void setCompanyOwnerId(Long companyOwnerId) {
        this.companyOwnerId = companyOwnerId;
    }

    public String getAuthorityFlag() {
        return authorityFlag;
    }

    public void setAuthorityFlag(String authorityFlag) {
        this.authorityFlag = authorityFlag;
    }
}