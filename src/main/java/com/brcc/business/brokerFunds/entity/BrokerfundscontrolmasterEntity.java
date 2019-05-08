package com.brcc.business.brokerFunds.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "brokerfundscontrolmaster")
@DynamicInsert
@DynamicUpdate
@NamedQuery(name="BrokerfundscontrolmasterEntity.findAll", query="SELECT g FROM BrokerfundscontrolmasterEntity g")
@NamedStoredProcedureQuery(name = "pro_broker_tax_process", procedureName = "apptms.pro_broker_tax_process", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "asPkId", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "asType", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "userId", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "userName", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "asResult", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "asResultReason", type = String.class)
}
)
public class BrokerfundscontrolmasterEntity {
    private Long fundsControlMasterId;
    private String platformId;
    private String fundsControlMasterNum;
    private String fundsPic;
    private String fundsPicSec;
    private String fundsPicThi;
    private Long borkerCompanyId;
    private String borkerCompanyName;
    private Date createDate;
    private Long createPersonId;
    private String createPersonName;
    private String createRemark;
    private Date modifyDate;
    private Long modifyPersonId;
    private String modifyPersonName;
    private String masterStatus;
    private String masterStatusRemark;
    private Long companyPayeeId;
    private Long firstAuditId;
    private String firstAuditName;
    private Date firstAuditDate;
    private Long secondAuditId;
    private String secondAuditName;
    private Date secondAuditDate;
    private Integer companyOwnerId;
    private String brokerTaxCycleName;

    @Id
    @Column(name = "funds_control_master_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getFundsControlMasterId() {
        return fundsControlMasterId;
    }

    public void setFundsControlMasterId(Long fundsControlMasterId) {
        this.fundsControlMasterId = fundsControlMasterId;
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
    @Column(name = "funds_control_master_num")
    public String getFundsControlMasterNum() {
        return fundsControlMasterNum;
    }

    public void setFundsControlMasterNum(String fundsControlMasterNum) {
        this.fundsControlMasterNum = fundsControlMasterNum;
    }

    @Basic
    @Column(name = "funds_pic")
    public String getFundsPic() {
        return fundsPic;
    }

    public void setFundsPic(String fundsPic) {
        this.fundsPic = fundsPic;
    }

    @Basic
    @Column(name = "funds_pic_sec")
    public String getFundsPicSec() {
        return fundsPicSec;
    }

    public void setFundsPicSec(String fundsPicSec) {
        this.fundsPicSec = fundsPicSec;
    }

    @Basic
    @Column(name = "funds_pic_thi")
    public String getFundsPicThi() {
        return fundsPicThi;
    }

    public void setFundsPicThi(String fundsPicThi) {
        this.fundsPicThi = fundsPicThi;
    }

    @Basic
    @Column(name = "borker_company_id")
    public Long getBorkerCompanyId() {
        return borkerCompanyId;
    }

    public void setBorkerCompanyId(Long borkerCompanyId) {
        this.borkerCompanyId = borkerCompanyId;
    }

    @Basic
    @Column(name = "borker_company_name")
    public String getBorkerCompanyName() {
        return borkerCompanyName;
    }

    public void setBorkerCompanyName(String borkerCompanyName) {
        this.borkerCompanyName = borkerCompanyName;
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
    @Column(name = "create_remark")
    public String getCreateRemark() {
        return createRemark;
    }

    public void setCreateRemark(String createRemark) {
        this.createRemark = createRemark;
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
    @Column(name = "master_status_remark")
    public String getMasterStatusRemark() {
        return masterStatusRemark;
    }

    public void setMasterStatusRemark(String masterStatusRemark) {
        this.masterStatusRemark = masterStatusRemark;
    }

    @Basic
    @Column(name = "master_status")
    public String getMasterStatus() {
        return masterStatus;
    }

    public void setMasterStatus(String masterStatus) {
        this.masterStatus = masterStatus;
    }

    @Basic
    @Column(name = "company_payee_id")
    public Long getCompanyPayeeId() {
        return companyPayeeId;
    }

    public void setCompanyPayeeId(Long companyPayeeId) {
        this.companyPayeeId = companyPayeeId;
    }

    @Basic
    @Column(name = "first_audit_id")
    public Long getFirstAuditId() {
        return firstAuditId;
    }

    public void setFirstAuditId(Long firstAuditId) {
        this.firstAuditId = firstAuditId;
    }
    @Basic
    @Column(name = "first_audit_name")
    public String getFirstAuditName() {
        return firstAuditName;
    }

    public void setFirstAuditName(String firstAuditName) {
        this.firstAuditName = firstAuditName;
    }
    @Basic
    @Column(name = "first_audit_date")
    public Date getFirstAuditDate() {
        return firstAuditDate;
    }

    public void setFirstAuditDate(Date firstAuditDate) {
        this.firstAuditDate = firstAuditDate;
    }
    @Basic
    @Column(name = "second_audit_id")
    public Long getSecondAuditId() {
        return secondAuditId;
    }

    public void setSecondAuditId(Long secondAuditId) {
        this.secondAuditId = secondAuditId;
    }
    @Basic
    @Column(name = "second_audit_name")
    public String getSecondAuditName() {
        return secondAuditName;
    }

    public void setSecondAuditName(String secondAuditName) {
        this.secondAuditName = secondAuditName;
    }
    @Basic
    @Column(name = "second_audit_date")
    public Date getSecondAuditDate() {
        return secondAuditDate;
    }
    @Basic
    @Column(name = "company_owner_id")
    public Integer getCompanyOwnerId() {
        return companyOwnerId;
    }

    public void setCompanyOwnerId(Integer companyOwnerId) {
        this.companyOwnerId = companyOwnerId;
    }
    @Basic
    @Column(name = "broker_tax_cycle_name")
    public String getBrokerTaxCycleName() {
        return brokerTaxCycleName;
    }

    public void setBrokerTaxCycleName(String brokerTaxCycleName) {
        this.brokerTaxCycleName = brokerTaxCycleName;
    }

    public void setSecondAuditDate(Date secondAuditDate) {
        this.secondAuditDate = secondAuditDate;
    }
}