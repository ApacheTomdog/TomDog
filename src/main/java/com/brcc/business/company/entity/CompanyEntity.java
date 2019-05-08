package com.brcc.business.company.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;
    /**
     * @Description:
     * @Auther: gemaochao
     * @Date:Created in 20:56 2018/11/8
     */
    @Entity
    @Table(name = "company")
    public  class CompanyEntity {
        private Long seqId;
        private String companyName;
        private String contactName;
        private String contactMobile;
        private String platformId;
        private String taxNum;
        private Timestamp createDate;
        private Timestamp modiDate;
        private Long regId;
        private Long userId;
        private String status;
        private String ifTransport;
        private String ifPublish;
        private String imageLocal1;
        private String imageLocal2;
        private String imageLocal3;
        private String ifAdmin;
        private String tuiguangren;
        private String remark;
        private String ifFreeze;
        private String ifAllCompany;
        private Long parentCompanyId;
        private String defaultTeamId;
        private String ifPlatAdmin;
        private String ifPartPlatAdmin;
        private Long createCompanyId;
        private String ifGoodsOwner;
        private Long contactNum;
        private String limitContact;
        private String auditPerson;
        private Timestamp auditDate;
        private String expendDepartment;
        private String bankType;
        private String bankName;
        private String bankNum;
        private String bankOwner;
        private String bankCkName;
        private String bankCkCode;
        private String bankProvinceCity;
        private String bankCity;
        private String bankMesCode;
        private String bankStatus;
        private String ifPay;
        private String ifDefaultPay;
        private String ownerFdCompanyId;
        private String secondContactName;
        private String secondContactMobile;
        private String companyNature;
        private String uncheck;
        private Timestamp modifyInfoDate;
        private String modifyInfoPer;
        private Long memberLevel;
        private Long memberPoints;
        private String modiPerson;
        private String autoDefaultTeam;
        private String zzNotPayFlag;
        private String bankDrctCode;
        private String invoiceAddr;
        private String invoiceTel;
        private String invoiceBank;
        private String invoiceAccount;
        private Long earlyWarningDays;
        private String ifGrabMoney;
        private BigDecimal grabMoney;
        private String ifPlatAutoAudit;
        private String ifTaxTransport;
        private String ifBrokerPeopleFlag;
        private String imageLocal1Check;
        private String imageLocal1Remark;
        private String imageLocal1AuditPerson;
        private Timestamp imageLocal1AuditDate;
        private String imageLocal2Check;
        private String imageLocal2Remark;
        private String imageLocal2AuditPerson;
        private Timestamp imageLocal2AuditDate;
        private String imageLocal3Check;
        private String imageLocal3Remark;
        private String imageLocal3AuditPerson;
        private Timestamp imageLocal3AuditDate;
        private String gpsUpload;
        private String ifGroupCompany;
        private String ifInvoiceCompany;
        private String ifZntjFlag;
        private String ifOwnerTaxpriceMf;
        private String goodsSet;
        private String businessMode;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "seq_id")
        public Long getSeqId() {
            return seqId;
        }

        public void setSeqId(Long seqId) {
            this.seqId = seqId;
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
        @Column(name = "contact_name")
        public String getContactName() {
            return contactName;
        }

        public void setContactName(String contactName) {
            this.contactName = contactName;
        }

        @Basic
        @Column(name = "contact_mobile")
        public String getContactMobile() {
            return contactMobile;
        }

        public void setContactMobile(String contactMobile) {
            this.contactMobile = contactMobile;
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
        @Column(name = "tax_num")
        public String getTaxNum() {
            return taxNum;
        }

        public void setTaxNum(String taxNum) {
            this.taxNum = taxNum;
        }

        @Basic
        @Column(name = "create_date")
        public Timestamp getCreateDate() {
            return createDate;
        }

        public void setCreateDate(Timestamp createDate) {
            this.createDate = createDate;
        }

        @Basic
        @Column(name = "modi_date")
        public Timestamp getModiDate() {
            return modiDate;
        }

        public void setModiDate(Timestamp modiDate) {
            this.modiDate = modiDate;
        }

        @Basic
        @Column(name = "reg_id")
        public Long getRegId() {
            return regId;
        }

        public void setRegId(Long regId) {
            this.regId = regId;
        }

        @Basic
        @Column(name = "user_id")
        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        @Basic
        @Column(name = "status")
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @Basic
        @Column(name = "if_transport")
        public String getIfTransport() {
            return ifTransport;
        }

        public void setIfTransport(String ifTransport) {
            this.ifTransport = ifTransport;
        }

        @Basic
        @Column(name = "if_publish")
        public String getIfPublish() {
            return ifPublish;
        }

        public void setIfPublish(String ifPublish) {
            this.ifPublish = ifPublish;
        }

        @Basic
        @Column(name = "image_local1")
        public String getImageLocal1() {
            return imageLocal1;
        }

        public void setImageLocal1(String imageLocal1) {
            this.imageLocal1 = imageLocal1;
        }

        @Basic
        @Column(name = "image_local2")
        public String getImageLocal2() {
            return imageLocal2;
        }

        public void setImageLocal2(String imageLocal2) {
            this.imageLocal2 = imageLocal2;
        }

        @Basic
        @Column(name = "image_local3")
        public String getImageLocal3() {
            return imageLocal3;
        }

        public void setImageLocal3(String imageLocal3) {
            this.imageLocal3 = imageLocal3;
        }

        @Basic
        @Column(name = "if_admin")
        public String getIfAdmin() {
            return ifAdmin;
        }

        public void setIfAdmin(String ifAdmin) {
            this.ifAdmin = ifAdmin;
        }

        @Basic
        @Column(name = "tuiguangren")
        public String getTuiguangren() {
            return tuiguangren;
        }

        public void setTuiguangren(String tuiguangren) {
            this.tuiguangren = tuiguangren;
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
        @Column(name = "if_freeze")
        public String getIfFreeze() {
            return ifFreeze;
        }

        public void setIfFreeze(String ifFreeze) {
            this.ifFreeze = ifFreeze;
        }

        @Basic
        @Column(name = "if_all_company")
        public String getIfAllCompany() {
            return ifAllCompany;
        }

        public void setIfAllCompany(String ifAllCompany) {
            this.ifAllCompany = ifAllCompany;
        }

        @Basic
        @Column(name = "parent_company_id")
        public Long getParentCompanyId() {
            return parentCompanyId;
        }

        public void setParentCompanyId(Long parentCompanyId) {
            this.parentCompanyId = parentCompanyId;
        }

        @Basic
        @Column(name = "default_team_id")
        public String getDefaultTeamId() {
            return defaultTeamId;
        }

        public void setDefaultTeamId(String defaultTeamId) {
            this.defaultTeamId = defaultTeamId;
        }

        @Basic
        @Column(name = "if_plat_admin")
        public String getIfPlatAdmin() {
            return ifPlatAdmin;
        }

        public void setIfPlatAdmin(String ifPlatAdmin) {
            this.ifPlatAdmin = ifPlatAdmin;
        }

        @Basic
        @Column(name = "if_part_plat_admin")
        public String getIfPartPlatAdmin() {
            return ifPartPlatAdmin;
        }

        public void setIfPartPlatAdmin(String ifPartPlatAdmin) {
            this.ifPartPlatAdmin = ifPartPlatAdmin;
        }

        @Basic
        @Column(name = "create_company_id")
        public Long getCreateCompanyId() {
            return createCompanyId;
        }

        public void setCreateCompanyId(Long createCompanyId) {
            this.createCompanyId = createCompanyId;
        }

        @Basic
        @Column(name = "if_goods_owner")
        public String getIfGoodsOwner() {
            return ifGoodsOwner;
        }

        public void setIfGoodsOwner(String ifGoodsOwner) {
            this.ifGoodsOwner = ifGoodsOwner;
        }

        @Basic
        @Column(name = "contact_num")
        public Long getContactNum() {
            return contactNum;
        }

        public void setContactNum(Long contactNum) {
            this.contactNum = contactNum;
        }

        @Basic
        @Column(name = "limit_contact")
        public String getLimitContact() {
            return limitContact;
        }

        public void setLimitContact(String limitContact) {
            this.limitContact = limitContact;
        }

        @Basic
        @Column(name = "audit_person")
        public String getAuditPerson() {
            return auditPerson;
        }

        public void setAuditPerson(String auditPerson) {
            this.auditPerson = auditPerson;
        }

        @Basic
        @Column(name = "audit_date")
        public Timestamp getAuditDate() {
            return auditDate;
        }

        public void setAuditDate(Timestamp auditDate) {
            this.auditDate = auditDate;
        }

        @Basic
        @Column(name = "expend_department")
        public String getExpendDepartment() {
            return expendDepartment;
        }

        public void setExpendDepartment(String expendDepartment) {
            this.expendDepartment = expendDepartment;
        }

        @Basic
        @Column(name = "bank_type")
        public String getBankType() {
            return bankType;
        }

        public void setBankType(String bankType) {
            this.bankType = bankType;
        }

        @Basic
        @Column(name = "bank_name")
        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        @Basic
        @Column(name = "bank_num")
        public String getBankNum() {
            return bankNum;
        }

        public void setBankNum(String bankNum) {
            this.bankNum = bankNum;
        }

        @Basic
        @Column(name = "bank_owner")
        public String getBankOwner() {
            return bankOwner;
        }

        public void setBankOwner(String bankOwner) {
            this.bankOwner = bankOwner;
        }

        @Basic
        @Column(name = "bank_ck_name")
        public String getBankCkName() {
            return bankCkName;
        }

        public void setBankCkName(String bankCkName) {
            this.bankCkName = bankCkName;
        }

        @Basic
        @Column(name = "bank_ck_code")
        public String getBankCkCode() {
            return bankCkCode;
        }

        public void setBankCkCode(String bankCkCode) {
            this.bankCkCode = bankCkCode;
        }

        @Basic
        @Column(name = "bank_province_city")
        public String getBankProvinceCity() {
            return bankProvinceCity;
        }

        public void setBankProvinceCity(String bankProvinceCity) {
            this.bankProvinceCity = bankProvinceCity;
        }

        @Basic
        @Column(name = "bank_city")
        public String getBankCity() {
            return bankCity;
        }

        public void setBankCity(String bankCity) {
            this.bankCity = bankCity;
        }

        @Basic
        @Column(name = "bank_mes_code")
        public String getBankMesCode() {
            return bankMesCode;
        }

        public void setBankMesCode(String bankMesCode) {
            this.bankMesCode = bankMesCode;
        }

        @Basic
        @Column(name = "bank_status")
        public String getBankStatus() {
            return bankStatus;
        }

        public void setBankStatus(String bankStatus) {
            this.bankStatus = bankStatus;
        }

        @Basic
        @Column(name = "if_pay")
        public String getIfPay() {
            return ifPay;
        }

        public void setIfPay(String ifPay) {
            this.ifPay = ifPay;
        }

        @Basic
        @Column(name = "if_default_pay")
        public String getIfDefaultPay() {
            return ifDefaultPay;
        }

        public void setIfDefaultPay(String ifDefaultPay) {
            this.ifDefaultPay = ifDefaultPay;
        }

        @Basic
        @Column(name = "owner_fd_company_id")
        public String getOwnerFdCompanyId() {
            return ownerFdCompanyId;
        }

        public void setOwnerFdCompanyId(String ownerFdCompanyId) {
            this.ownerFdCompanyId = ownerFdCompanyId;
        }

        @Basic
        @Column(name = "second_contact_name")
        public String getSecondContactName() {
            return secondContactName;
        }

        public void setSecondContactName(String secondContactName) {
            this.secondContactName = secondContactName;
        }

        @Basic
        @Column(name = "second_contact_mobile")
        public String getSecondContactMobile() {
            return secondContactMobile;
        }

        public void setSecondContactMobile(String secondContactMobile) {
            this.secondContactMobile = secondContactMobile;
        }

        @Basic
        @Column(name = "company_nature")
        public String getCompanyNature() {
            return companyNature;
        }

        public void setCompanyNature(String companyNature) {
            this.companyNature = companyNature;
        }

        @Basic
        @Column(name = "uncheck")
        public String getUncheck() {
            return uncheck;
        }

        public void setUncheck(String uncheck) {
            this.uncheck = uncheck;
        }

        @Basic
        @Column(name = "modify_info_date")
        public Timestamp getModifyInfoDate() {
            return modifyInfoDate;
        }

        public void setModifyInfoDate(Timestamp modifyInfoDate) {
            this.modifyInfoDate = modifyInfoDate;
        }

        @Basic
        @Column(name = "modify_info_per")
        public String getModifyInfoPer() {
            return modifyInfoPer;
        }

        public void setModifyInfoPer(String modifyInfoPer) {
            this.modifyInfoPer = modifyInfoPer;
        }

        @Basic
        @Column(name = "member_level")
        public Long getMemberLevel() {
            return memberLevel;
        }

        public void setMemberLevel(Long memberLevel) {
            this.memberLevel = memberLevel;
        }

        @Basic
        @Column(name = "member_points")
        public Long getMemberPoints() {
            return memberPoints;
        }

        public void setMemberPoints(Long memberPoints) {
            this.memberPoints = memberPoints;
        }

        @Basic
        @Column(name = "modi_person")
        public String getModiPerson() {
            return modiPerson;
        }

        public void setModiPerson(String modiPerson) {
            this.modiPerson = modiPerson;
        }

        @Basic
        @Column(name = "auto_default_team")
        public String getAutoDefaultTeam() {
            return autoDefaultTeam;
        }

        public void setAutoDefaultTeam(String autoDefaultTeam) {
            this.autoDefaultTeam = autoDefaultTeam;
        }

        @Basic
        @Column(name = "zz_not_pay_flag")
        public String getZzNotPayFlag() {
            return zzNotPayFlag;
        }

        public void setZzNotPayFlag(String zzNotPayFlag) {
            this.zzNotPayFlag = zzNotPayFlag;
        }

        @Basic
        @Column(name = "bank_drct_code")
        public String getBankDrctCode() {
            return bankDrctCode;
        }

        public void setBankDrctCode(String bankDrctCode) {
            this.bankDrctCode = bankDrctCode;
        }

        @Basic
        @Column(name = "invoice_addr")
        public String getInvoiceAddr() {
            return invoiceAddr;
        }

        public void setInvoiceAddr(String invoiceAddr) {
            this.invoiceAddr = invoiceAddr;
        }

        @Basic
        @Column(name = "invoice_tel")
        public String getInvoiceTel() {
            return invoiceTel;
        }

        public void setInvoiceTel(String invoiceTel) {
            this.invoiceTel = invoiceTel;
        }

        @Basic
        @Column(name = "invoice_bank")
        public String getInvoiceBank() {
            return invoiceBank;
        }

        public void setInvoiceBank(String invoiceBank) {
            this.invoiceBank = invoiceBank;
        }

        @Basic
        @Column(name = "invoice_account")
        public String getInvoiceAccount() {
            return invoiceAccount;
        }

        public void setInvoiceAccount(String invoiceAccount) {
            this.invoiceAccount = invoiceAccount;
        }

        @Basic
        @Column(name = "early_warning_days")
        public Long getEarlyWarningDays() {
            return earlyWarningDays;
        }

        public void setEarlyWarningDays(Long earlyWarningDays) {
            this.earlyWarningDays = earlyWarningDays;
        }

        @Basic
        @Column(name = "if_grab_money")
        public String getIfGrabMoney() {
            return ifGrabMoney;
        }

        public void setIfGrabMoney(String ifGrabMoney) {
            this.ifGrabMoney = ifGrabMoney;
        }

        @Basic
        @Column(name = "grab_money")
        public BigDecimal getGrabMoney() {
            return grabMoney;
        }

        public void setGrabMoney(BigDecimal grabMoney) {
            this.grabMoney = grabMoney;
        }

        @Basic
        @Column(name = "if_plat_auto_audit")
        public String getIfPlatAutoAudit() {
            return ifPlatAutoAudit;
        }

        public void setIfPlatAutoAudit(String ifPlatAutoAudit) {
            this.ifPlatAutoAudit = ifPlatAutoAudit;
        }

        @Basic
        @Column(name = "if_tax_transport")
        public String getIfTaxTransport() {
            return ifTaxTransport;
        }

        public void setIfTaxTransport(String ifTaxTransport) {
            this.ifTaxTransport = ifTaxTransport;
        }

        @Basic
        @Column(name = "if_broker_people_flag")
        public String getIfBrokerPeopleFlag() {
            return ifBrokerPeopleFlag;
        }

        public void setIfBrokerPeopleFlag(String ifBrokerPeopleFlag) {
            this.ifBrokerPeopleFlag = ifBrokerPeopleFlag;
        }

        @Basic
        @Column(name = "image_local1_check")
        public String getImageLocal1Check() {
            return imageLocal1Check;
        }

        public void setImageLocal1Check(String imageLocal1Check) {
            this.imageLocal1Check = imageLocal1Check;
        }

        @Basic
        @Column(name = "image_local1_remark")
        public String getImageLocal1Remark() {
            return imageLocal1Remark;
        }

        public void setImageLocal1Remark(String imageLocal1Remark) {
            this.imageLocal1Remark = imageLocal1Remark;
        }

        @Basic
        @Column(name = "image_local1_audit_person")
        public String getImageLocal1AuditPerson() {
            return imageLocal1AuditPerson;
        }

        public void setImageLocal1AuditPerson(String imageLocal1AuditPerson) {
            this.imageLocal1AuditPerson = imageLocal1AuditPerson;
        }

        @Basic
        @Column(name = "image_local1_audit_date")
        public Timestamp getImageLocal1AuditDate() {
            return imageLocal1AuditDate;
        }

        public void setImageLocal1AuditDate(Timestamp imageLocal1AuditDate) {
            this.imageLocal1AuditDate = imageLocal1AuditDate;
        }

        @Basic
        @Column(name = "image_local2_check")
        public String getImageLocal2Check() {
            return imageLocal2Check;
        }

        public void setImageLocal2Check(String imageLocal2Check) {
            this.imageLocal2Check = imageLocal2Check;
        }

        @Basic
        @Column(name = "image_local2_remark")
        public String getImageLocal2Remark() {
            return imageLocal2Remark;
        }

        public void setImageLocal2Remark(String imageLocal2Remark) {
            this.imageLocal2Remark = imageLocal2Remark;
        }

        @Basic
        @Column(name = "image_local2_audit_person")
        public String getImageLocal2AuditPerson() {
            return imageLocal2AuditPerson;
        }

        public void setImageLocal2AuditPerson(String imageLocal2AuditPerson) {
            this.imageLocal2AuditPerson = imageLocal2AuditPerson;
        }

        @Basic
        @Column(name = "image_local2_audit_date")
        public Timestamp getImageLocal2AuditDate() {
            return imageLocal2AuditDate;
        }

        public void setImageLocal2AuditDate(Timestamp imageLocal2AuditDate) {
            this.imageLocal2AuditDate = imageLocal2AuditDate;
        }

        @Basic
        @Column(name = "image_local3_check")
        public String getImageLocal3Check() {
            return imageLocal3Check;
        }

        public void setImageLocal3Check(String imageLocal3Check) {
            this.imageLocal3Check = imageLocal3Check;
        }

        @Basic
        @Column(name = "image_local3_remark")
        public String getImageLocal3Remark() {
            return imageLocal3Remark;
        }

        public void setImageLocal3Remark(String imageLocal3Remark) {
            this.imageLocal3Remark = imageLocal3Remark;
        }

        @Basic
        @Column(name = "image_local3_audit_person")
        public String getImageLocal3AuditPerson() {
            return imageLocal3AuditPerson;
        }

        public void setImageLocal3AuditPerson(String imageLocal3AuditPerson) {
            this.imageLocal3AuditPerson = imageLocal3AuditPerson;
        }

        @Basic
        @Column(name = "image_local3_audit_date")
        public Timestamp getImageLocal3AuditDate() {
            return imageLocal3AuditDate;
        }

        public void setImageLocal3AuditDate(Timestamp imageLocal3AuditDate) {
            this.imageLocal3AuditDate = imageLocal3AuditDate;
        }

        @Basic
        @Column(name = "gps_upload")
        public String getGpsUpload() {
            return gpsUpload;
        }

        public void setGpsUpload(String gpsUpload) {
            this.gpsUpload = gpsUpload;
        }

        @Basic
        @Column(name = "if_group_company")
        public String getIfGroupCompany() {
            return ifGroupCompany;
        }

        public void setIfGroupCompany(String ifGroupCompany) {
            this.ifGroupCompany = ifGroupCompany;
        }

        @Basic
        @Column(name = "if_invoice_company")
        public String getIfInvoiceCompany() {
            return ifInvoiceCompany;
        }

        public void setIfInvoiceCompany(String ifInvoiceCompany) {
            this.ifInvoiceCompany = ifInvoiceCompany;
        }

        @Basic
        @Column(name = "if_zntj_flag")
        public String getIfZntjFlag() {
            return ifZntjFlag;
        }

        public void setIfZntjFlag(String ifZntjFlag) {
            this.ifZntjFlag = ifZntjFlag;
        }

        @Basic
        @Column(name = "if_owner_taxprice_mf")
        public String getIfOwnerTaxpriceMf() {
            return ifOwnerTaxpriceMf;
        }

        public void setIfOwnerTaxpriceMf(String ifOwnerTaxpriceMf) {
            this.ifOwnerTaxpriceMf = ifOwnerTaxpriceMf;
        }

        @Basic
        @Column(name = "goods_set")
        public String getGoodsSet() {
            return goodsSet;
        }

        public void setGoodsSet(String goodsSet) {
            this.goodsSet = goodsSet;
        }
        
        @Basic
        @Column(name = "business_mode")
        public String getBusinessMode() {
			return businessMode;
		}

		public void setBusinessMode(String businessMode) {
			this.businessMode = businessMode;
		}

		@Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CompanyEntity that = (CompanyEntity) o;
            return Objects.equals(seqId, that.seqId) &&
                    Objects.equals(companyName, that.companyName) &&
                    Objects.equals(contactName, that.contactName) &&
                    Objects.equals(contactMobile, that.contactMobile) &&
                    Objects.equals(platformId, that.platformId) &&
                    Objects.equals(taxNum, that.taxNum) &&
                    Objects.equals(createDate, that.createDate) &&
                    Objects.equals(modiDate, that.modiDate) &&
                    Objects.equals(regId, that.regId) &&
                    Objects.equals(userId, that.userId) &&
                    Objects.equals(status, that.status) &&
                    Objects.equals(ifTransport, that.ifTransport) &&
                    Objects.equals(ifPublish, that.ifPublish) &&
                    Objects.equals(imageLocal1, that.imageLocal1) &&
                    Objects.equals(imageLocal2, that.imageLocal2) &&
                    Objects.equals(imageLocal3, that.imageLocal3) &&
                    Objects.equals(ifAdmin, that.ifAdmin) &&
                    Objects.equals(tuiguangren, that.tuiguangren) &&
                    Objects.equals(remark, that.remark) &&
                    Objects.equals(ifFreeze, that.ifFreeze) &&
                    Objects.equals(ifAllCompany, that.ifAllCompany) &&
                    Objects.equals(parentCompanyId, that.parentCompanyId) &&
                    Objects.equals(defaultTeamId, that.defaultTeamId) &&
                    Objects.equals(ifPlatAdmin, that.ifPlatAdmin) &&
                    Objects.equals(ifPartPlatAdmin, that.ifPartPlatAdmin) &&
                    Objects.equals(createCompanyId, that.createCompanyId) &&
                    Objects.equals(ifGoodsOwner, that.ifGoodsOwner) &&
                    Objects.equals(contactNum, that.contactNum) &&
                    Objects.equals(limitContact, that.limitContact) &&
                    Objects.equals(auditPerson, that.auditPerson) &&
                    Objects.equals(auditDate, that.auditDate) &&
                    Objects.equals(expendDepartment, that.expendDepartment) &&
                    Objects.equals(bankType, that.bankType) &&
                    Objects.equals(bankName, that.bankName) &&
                    Objects.equals(bankNum, that.bankNum) &&
                    Objects.equals(bankOwner, that.bankOwner) &&
                    Objects.equals(bankCkName, that.bankCkName) &&
                    Objects.equals(bankCkCode, that.bankCkCode) &&
                    Objects.equals(bankProvinceCity, that.bankProvinceCity) &&
                    Objects.equals(bankCity, that.bankCity) &&
                    Objects.equals(bankMesCode, that.bankMesCode) &&
                    Objects.equals(bankStatus, that.bankStatus) &&
                    Objects.equals(ifPay, that.ifPay) &&
                    Objects.equals(ifDefaultPay, that.ifDefaultPay) &&
                    Objects.equals(ownerFdCompanyId, that.ownerFdCompanyId) &&
                    Objects.equals(secondContactName, that.secondContactName) &&
                    Objects.equals(secondContactMobile, that.secondContactMobile) &&
                    Objects.equals(companyNature, that.companyNature) &&
                    Objects.equals(uncheck, that.uncheck) &&
                    Objects.equals(modifyInfoDate, that.modifyInfoDate) &&
                    Objects.equals(modifyInfoPer, that.modifyInfoPer) &&
                    Objects.equals(memberLevel, that.memberLevel) &&
                    Objects.equals(memberPoints, that.memberPoints) &&
                    Objects.equals(modiPerson, that.modiPerson) &&
                    Objects.equals(autoDefaultTeam, that.autoDefaultTeam) &&
                    Objects.equals(zzNotPayFlag, that.zzNotPayFlag) &&
                    Objects.equals(bankDrctCode, that.bankDrctCode) &&
                    Objects.equals(invoiceAddr, that.invoiceAddr) &&
                    Objects.equals(invoiceTel, that.invoiceTel) &&
                    Objects.equals(invoiceBank, that.invoiceBank) &&
                    Objects.equals(invoiceAccount, that.invoiceAccount) &&
                    Objects.equals(earlyWarningDays, that.earlyWarningDays) &&
                    Objects.equals(ifGrabMoney, that.ifGrabMoney) &&
                    Objects.equals(grabMoney, that.grabMoney) &&
                    Objects.equals(ifPlatAutoAudit, that.ifPlatAutoAudit) &&
                    Objects.equals(ifTaxTransport, that.ifTaxTransport) &&
                    Objects.equals(ifBrokerPeopleFlag, that.ifBrokerPeopleFlag) &&
                    Objects.equals(imageLocal1Check, that.imageLocal1Check) &&
                    Objects.equals(imageLocal1Remark, that.imageLocal1Remark) &&
                    Objects.equals(imageLocal1AuditPerson, that.imageLocal1AuditPerson) &&
                    Objects.equals(imageLocal1AuditDate, that.imageLocal1AuditDate) &&
                    Objects.equals(imageLocal2Check, that.imageLocal2Check) &&
                    Objects.equals(imageLocal2Remark, that.imageLocal2Remark) &&
                    Objects.equals(imageLocal2AuditPerson, that.imageLocal2AuditPerson) &&
                    Objects.equals(imageLocal2AuditDate, that.imageLocal2AuditDate) &&
                    Objects.equals(imageLocal3Check, that.imageLocal3Check) &&
                    Objects.equals(imageLocal3Remark, that.imageLocal3Remark) &&
                    Objects.equals(imageLocal3AuditPerson, that.imageLocal3AuditPerson) &&
                    Objects.equals(imageLocal3AuditDate, that.imageLocal3AuditDate) &&
                    Objects.equals(gpsUpload, that.gpsUpload) &&
                    Objects.equals(ifGroupCompany, that.ifGroupCompany) &&
                    Objects.equals(ifInvoiceCompany, that.ifInvoiceCompany) &&
                    Objects.equals(ifZntjFlag, that.ifZntjFlag) &&
                    Objects.equals(ifOwnerTaxpriceMf, that.ifOwnerTaxpriceMf) &&
                    Objects.equals(goodsSet, that.goodsSet);
        }

        @Override
        public int hashCode() {
            return Objects.hash(seqId, companyName, contactName, contactMobile, platformId, taxNum, createDate, modiDate, regId, userId, status, ifTransport, ifPublish, imageLocal1, imageLocal2, imageLocal3, ifAdmin, tuiguangren, remark, ifFreeze, ifAllCompany, parentCompanyId, defaultTeamId, ifPlatAdmin, ifPartPlatAdmin, createCompanyId, ifGoodsOwner, contactNum, limitContact, auditPerson, auditDate, expendDepartment, bankType, bankName, bankNum, bankOwner, bankCkName, bankCkCode, bankProvinceCity, bankCity, bankMesCode, bankStatus, ifPay, ifDefaultPay, ownerFdCompanyId, secondContactName, secondContactMobile, companyNature, uncheck, modifyInfoDate, modifyInfoPer, memberLevel, memberPoints, modiPerson, autoDefaultTeam, zzNotPayFlag, bankDrctCode, invoiceAddr, invoiceTel, invoiceBank, invoiceAccount, earlyWarningDays, ifGrabMoney, grabMoney, ifPlatAutoAudit, ifTaxTransport, ifBrokerPeopleFlag, imageLocal1Check, imageLocal1Remark, imageLocal1AuditPerson, imageLocal1AuditDate, imageLocal2Check, imageLocal2Remark, imageLocal2AuditPerson, imageLocal2AuditDate, imageLocal3Check, imageLocal3Remark, imageLocal3AuditPerson, imageLocal3AuditDate, gpsUpload, ifGroupCompany, ifInvoiceCompany, ifZntjFlag, ifOwnerTaxpriceMf, goodsSet);
        }
    }

