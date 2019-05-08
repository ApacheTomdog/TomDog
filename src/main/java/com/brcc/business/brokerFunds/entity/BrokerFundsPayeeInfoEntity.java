package com.brcc.business.brokerFunds.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "broker_funds_payee_info")
@DynamicInsert
@DynamicUpdate
@NamedStoredProcedureQuery(name = "pro_broker_payee_process", procedureName = "apptms.pro_broker_payee_process", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "asPkId", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "asType", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "userId", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "userName", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "asResult", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "asResultReason", type = String.class)
}
)
public class BrokerFundsPayeeInfoEntity {
    private Long brokerFundsPayeeInfoId;
    private Long fundsControlMasterId;
    private Long companyPayeeCapitalId;
    private Long companyPayeeId;
    private Long companyId;
    private String companyName;
    private String companyPayeeName;
    private String companyPayeeCardNum;
    private String companyPayeeNum;
    private String brokerTaxCycleName;
    private BigDecimal companyPayeeAmount;
    private Date createDate;
    private Long createPersonId;
    private String createPersonName;
    private Date modifyDate;
    private Long modifyPersonId;
    private String modifyPersonName;

    @Id
    @Column(name = "broker_funds_payee_info_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getBrokerFundsPayeeInfoId() {
        return brokerFundsPayeeInfoId;
    }

    public void setBrokerFundsPayeeInfoId(Long brokerFundsPayeeInfoId) {
        this.brokerFundsPayeeInfoId = brokerFundsPayeeInfoId;
    }
    @Basic
    @Column(name = "funds_control_master_id")
    public Long getFundsControlMasterId() {
        return fundsControlMasterId;
    }

    public void setFundsControlMasterId(Long fundsControlMasterId) {
        this.fundsControlMasterId = fundsControlMasterId;
    }

    @Basic
    @Column(name = "company_payee_capital_id")
    public Long getCompanyPayeeCapitalId() {
        return companyPayeeCapitalId;
    }

    public void setCompanyPayeeCapitalId(Long companyPayeeCapitalId) {
        this.companyPayeeCapitalId = companyPayeeCapitalId;
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
    @Column(name = "company_id")
    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "company_name")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "company_payee_name")
    public String getCompanyPayeeName() {
        return companyPayeeName;
    }

    public void setCompanyPayeeName(String companyPayeeName) {
        this.companyPayeeName = companyPayeeName;
    }

    @Basic
    @Column(name = "company_payee_card_num")
    public String getCompanyPayeeCardNum() {
        return companyPayeeCardNum;
    }

    public void setCompanyPayeeCardNum(String companyPayeeCardNum) {
        this.companyPayeeCardNum = companyPayeeCardNum;
    }

    @Basic
    @Column(name = "company_payee_num")
    public String getCompanyPayeeNum() {
        return companyPayeeNum;
    }

    public void setCompanyPayeeNum(String companyPayeeNum) {
        this.companyPayeeNum = companyPayeeNum;
    }

    @Basic
    @Column(name = "broker_tax_cycle_name")
    public String getBrokerTaxCycleName() {
        return brokerTaxCycleName;
    }

    public void setBrokerTaxCycleName(String brokerTaxCycleName) {
        this.brokerTaxCycleName = brokerTaxCycleName;
    }

    @Basic
    @Column(name = "company_payee_amount")
    public BigDecimal getCompanyPayeeAmount() {
        return companyPayeeAmount;
    }

    public void setCompanyPayeeAmount(BigDecimal companyPayeeAmount) {
        this.companyPayeeAmount = companyPayeeAmount;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrokerFundsPayeeInfoEntity that = (BrokerFundsPayeeInfoEntity) o;
        return brokerFundsPayeeInfoId == that.brokerFundsPayeeInfoId &&
                Objects.equals(fundsControlMasterId, that.fundsControlMasterId) &&
                Objects.equals(companyPayeeId, that.companyPayeeId) &&
                Objects.equals(companyId, that.companyId) &&
                Objects.equals(companyName, that.companyName) &&
                Objects.equals(companyPayeeName, that.companyPayeeName) &&
                Objects.equals(companyPayeeCardNum, that.companyPayeeCardNum) &&
                Objects.equals(companyPayeeNum, that.companyPayeeNum) &&
                Objects.equals(brokerTaxCycleName, that.brokerTaxCycleName) &&
                Objects.equals(companyPayeeAmount, that.companyPayeeAmount) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(createPersonId, that.createPersonId) &&
                Objects.equals(createPersonName, that.createPersonName) &&
                Objects.equals(modifyDate, that.modifyDate) &&
                Objects.equals(modifyPersonId, that.modifyPersonId) &&
                Objects.equals(modifyPersonName, that.modifyPersonName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brokerFundsPayeeInfoId, fundsControlMasterId, companyPayeeId, companyId, companyName, companyPayeeName, companyPayeeCardNum, companyPayeeNum, brokerTaxCycleName, companyPayeeAmount, createDate, createPersonId, createPersonName, modifyDate, modifyPersonId, modifyPersonName);
    }
}
/**
 * @Description
 * @Author pjy
 * @Date
 **/