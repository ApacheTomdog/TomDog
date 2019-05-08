package com.brcc.business.vatAuditConfigName.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * @Description:
 * @Auther: gemaochao
 * @Date:Created in 17:25 2018/11/14
 */
@Entity
@Table(name = "vat_audit_config_name")
public class VatAuditConfigNameEntity {

    @Id
    @Column(name = "v_a_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vAId;

    @Basic
    @Column(name = "vat_company_id")
    private Long vatCompanyId;

    @Basic
    @Column(name = "vat_company_name")
    private String vatCompanyName;

    @Basic
    @Column(name = "vat_audit_name")
    private String vatAuditName;

    @Basic
    @Column(name = "vat_director_name")
    private String vatDirectorName;

    @Basic
    @Column(name = "vat_status")
    private String vatStatus;

    @Basic
    @Column(name = "platform_id")
    private String platformId;

    @Basic
    @Column(name = "create_person_id")
    private Long createPersonId;

    @Basic
    @Column(name = "create_person_name")
    private String createPersonName;

    @Basic
    @Column(name = "create_date")
    private Date createDate;

    @Basic
    @Column(name = "modify_person_id")
    private Long modifyPersonId;

    @Basic
    @Column(name = "modify_person_name")
    private String modifyPersonName;

    @Basic
    @Column(name = "modify_date")
    private Date modifyDate;


    public Long getvAId() {
        return vAId;
    }

    public void setvAId(Long vAId) {
        this.vAId = vAId;
    }

    public Long getVatCompanyId() {
        return vatCompanyId;
    }

    public void setVatCompanyId(Long vatCompanyId) {
        this.vatCompanyId = vatCompanyId;
    }

    public String getVatCompanyName() {
        return vatCompanyName;
    }

    public void setVatCompanyName(String vatCompanyName) {
        this.vatCompanyName = vatCompanyName;
    }

    public String getVatAuditName() {
        return vatAuditName;
    }

    public void setVatAuditName(String vatAuditName) {
        this.vatAuditName = vatAuditName;
    }

    public String getVatDirectorName() {
        return vatDirectorName;
    }

    public void setVatDirectorName(String vatDirectorName) {
        this.vatDirectorName = vatDirectorName;
    }

    public String getVatStatus() {
        return vatStatus;
    }

    public void setVatStatus(String vatStatus) {
        this.vatStatus = vatStatus;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
        VatAuditConfigNameEntity that = (VatAuditConfigNameEntity) o;
        return vAId == that.vAId &&
                Objects.equals(vatCompanyId, that.vatCompanyId) &&
                Objects.equals(vatCompanyName, that.vatCompanyName) &&
                Objects.equals(vatAuditName, that.vatAuditName) &&
                Objects.equals(vatDirectorName, that.vatDirectorName) &&
                Objects.equals(vatStatus, that.vatStatus) &&
                Objects.equals(platformId, that.platformId) &&
                Objects.equals(createPersonId, that.createPersonId) &&
                Objects.equals(createPersonName, that.createPersonName) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(modifyPersonId, that.modifyPersonId) &&
                Objects.equals(modifyPersonName, that.modifyPersonName) &&
                Objects.equals(modifyDate, that.modifyDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vAId, vatCompanyId, vatCompanyName, vatAuditName, vatDirectorName, vatStatus, platformId, createPersonId, createPersonName, createDate, modifyPersonId, modifyPersonName, modifyDate);
    }
}
