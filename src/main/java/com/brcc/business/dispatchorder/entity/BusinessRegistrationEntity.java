package com.brcc.business.dispatchorder.entity;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;

import java.util.Date;
import java.util.Objects;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2018-11-12 13:50
 */
@Entity
@DynamicInsert
@Table(name = "business_registration")
public class BusinessRegistrationEntity {

    private Long regId;
    private String userName;
    private String idNum;
    private String phone;
    private String regName;
    private String sex;
    private String national;
    private String cardAddress;
    private String issueauthority;
    private String validity;
    private Date validityStartTime;
    private Date validityEndTime;
    private Date birthDay;
    private String avatarPicLocal;
    private String signaturePicLocal;
    private Integer status;
    private String taxNum;
    private Date taxNumDate;
    private Long ibId;
    private String idFontPicLocal;
    private String idFontPicRemote;
    private String idBackPicLocal;
    private String idBackPicRemote;
    private Byte ifPrint;
    private Long createPersonId;
    private String createPersonName;
    private Date createDate;
    private Long modifyPersonId;
    private String modifyPersonName;
    private Date modifyDate;
    private String platformId;
    private Integer taxRegistrationFlag;
    private Integer withholdProtocolFlag;
    private String ifUploadFjsw;
    private Date uploadDate;
    private String resultMsg;

    @Id
    @Column(name = "reg_id", nullable = false)
    public Long getRegId() {
        return regId;
    }

    public void setRegId(Long regId) {
        this.regId = regId;
    }

    @Basic
    @Column(name = "user_name", nullable = true, length = 20)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "id_num", nullable = true, length = 45)
    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 45)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "reg_name", nullable = true, length = 100)
    public String getRegName() {
        return regName;
    }

    public void setRegName(String regName) {
        this.regName = regName;
    }

    @Basic
    @Column(name = "sex", nullable = true, length = 2)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "national", nullable = true, length = 10)
    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    @Basic
    @Column(name = "card_address", nullable = true, length = 100)
    public String getCardAddress() {
        return cardAddress;
    }

    public void setCardAddress(String cardAddress) {
        this.cardAddress = cardAddress;
    }

    @Basic
    @Column(name = "issueauthority", nullable = true, length = 50)
    public String getIssueauthority() {
        return issueauthority;
    }

    public void setIssueauthority(String issueauthority) {
        this.issueauthority = issueauthority;
    }

    @Basic
    @Column(name = "validity", nullable = true, length = 100)
    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    @Basic
    @Column(name = "validity_start_time", nullable = true)
    public Date getValidityStartTime() {
        return validityStartTime;
    }

    public void setValidityStartTime(Date validityStartTime) {
        this.validityStartTime = validityStartTime;
    }

    @Basic
    @Column(name = "validity_end_time", nullable = true)
    public Date getValidityEndTime() {
        return validityEndTime;
    }

    public void setValidityEndTime(Date validityEndTime) {
        this.validityEndTime = validityEndTime;
    }

    @Basic
    @Column(name = "birth_day", nullable = true)
    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    @Basic
    @Column(name = "avatar_pic_local", nullable = true, length = 100)
    public String getAvatarPicLocal() {
        return avatarPicLocal;
    }

    public void setAvatarPicLocal(String avatarPicLocal) {
        this.avatarPicLocal = avatarPicLocal;
    }

    @Basic
    @Column(name = "signature_pic_local", nullable = true, length = 100)
    public String getSignaturePicLocal() {
        return signaturePicLocal;
    }

    public void setSignaturePicLocal(String signaturePicLocal) {
        this.signaturePicLocal = signaturePicLocal;
    }

    @Basic
    @Column(name = "status", nullable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "tax_num", nullable = true, length = 40)
    public String getTaxNum() {
        return taxNum;
    }

    public void setTaxNum(String taxNum) {
        this.taxNum = taxNum;
    }

    @Basic
    @Column(name = "tax_num_date", nullable = true)
    public Date getTaxNumDate() {
        return taxNumDate;
    }

    public void setTaxNumDate(Date taxNumDate) {
        this.taxNumDate = taxNumDate;
    }

    @Basic
    @Column(name = "ib_id", nullable = true)
    public Long getIbId() {
        return ibId;
    }

    public void setIbId(Long ibId) {
        this.ibId = ibId;
    }

    @Basic
    @Column(name = "id_font_pic_local", nullable = true, length = 200)
    public String getIdFontPicLocal() {
        return idFontPicLocal;
    }

    public void setIdFontPicLocal(String idFontPicLocal) {
        this.idFontPicLocal = idFontPicLocal;
    }

    @Basic
    @Column(name = "id_font_pic_remote", nullable = true, length = 200)
    public String getIdFontPicRemote() {
        return idFontPicRemote;
    }

    public void setIdFontPicRemote(String idFontPicRemote) {
        this.idFontPicRemote = idFontPicRemote;
    }

    @Basic
    @Column(name = "id_back_pic_local", nullable = true, length = 200)
    public String getIdBackPicLocal() {
        return idBackPicLocal;
    }

    public void setIdBackPicLocal(String idBackPicLocal) {
        this.idBackPicLocal = idBackPicLocal;
    }

    @Basic
    @Column(name = "id_back_pic_remote", nullable = true, length = 200)
    public String getIdBackPicRemote() {
        return idBackPicRemote;
    }

    public void setIdBackPicRemote(String idBackPicRemote) {
        this.idBackPicRemote = idBackPicRemote;
    }

    @Basic
    @Column(name = "if_print", nullable = true)
    public Byte getIfPrint() {
        return ifPrint;
    }

    public void setIfPrint(Byte ifPrint) {
        this.ifPrint = ifPrint;
    }

    @Basic
    @Column(name = "create_person_id", nullable = true)
    public Long getCreatePersonId() {
        return createPersonId;
    }

    public void setCreatePersonId(Long createPersonId) {
        this.createPersonId = createPersonId;
    }

    @Basic
    @Column(name = "create_person_name", nullable = true, length = 100)
    public String getCreatePersonName() {
        return createPersonName;
    }

    public void setCreatePersonName(String createPersonName) {
        this.createPersonName = createPersonName;
    }

    @Basic
    @Column(name = "create_date", nullable = true)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "modify_person_id", nullable = true)
    public Long getModifyPersonId() {
        return modifyPersonId;
    }

    public void setModifyPersonId(Long modifyPersonId) {
        this.modifyPersonId = modifyPersonId;
    }

    @Basic
    @Column(name = "modify_person_name", nullable = true, length = 100)
    public String getModifyPersonName() {
        return modifyPersonName;
    }

    public void setModifyPersonName(String modifyPersonName) {
        this.modifyPersonName = modifyPersonName;
    }

    @Basic
    @Column(name = "modify_date", nullable = true)
    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Basic
    @Column(name = "platform_id", nullable = true, length = 20)
    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    @Basic
    @Column(name = "tax_registration_flag", nullable = true)
    public Integer getTaxRegistrationFlag() {
        return taxRegistrationFlag;
    }

    public void setTaxRegistrationFlag(Integer taxRegistrationFlag) {
        this.taxRegistrationFlag = taxRegistrationFlag;
    }

    @Basic
    @Column(name = "withhold_protocol_flag", nullable = true)
    public Integer getWithholdProtocolFlag() {
        return withholdProtocolFlag;
    }

    public void setWithholdProtocolFlag(Integer withholdProtocolFlag) {
        this.withholdProtocolFlag = withholdProtocolFlag;
    }

    @Basic
    @Column(name = "if_upload_fjsw", nullable = true, length = 1)
    public String getIfUploadFjsw() {
        return ifUploadFjsw;
    }

    public void setIfUploadFjsw(String ifUploadFjsw) {
        this.ifUploadFjsw = ifUploadFjsw;
    }

    @Basic
    @Column(name = "upload_date", nullable = true)
    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    @Basic
    @Column(name = "result_msg", nullable = true, length = 800)
    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusinessRegistrationEntity that = (BusinessRegistrationEntity) o;
        return regId == that.regId &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(idNum, that.idNum) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(regName, that.regName) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(national, that.national) &&
                Objects.equals(cardAddress, that.cardAddress) &&
                Objects.equals(issueauthority, that.issueauthority) &&
                Objects.equals(validity, that.validity) &&
                Objects.equals(validityStartTime, that.validityStartTime) &&
                Objects.equals(validityEndTime, that.validityEndTime) &&
                Objects.equals(birthDay, that.birthDay) &&
                Objects.equals(avatarPicLocal, that.avatarPicLocal) &&
                Objects.equals(signaturePicLocal, that.signaturePicLocal) &&
                Objects.equals(status, that.status) &&
                Objects.equals(taxNum, that.taxNum) &&
                Objects.equals(taxNumDate, that.taxNumDate) &&
                Objects.equals(ibId, that.ibId) &&
                Objects.equals(idFontPicLocal, that.idFontPicLocal) &&
                Objects.equals(idFontPicRemote, that.idFontPicRemote) &&
                Objects.equals(idBackPicLocal, that.idBackPicLocal) &&
                Objects.equals(idBackPicRemote, that.idBackPicRemote) &&
                Objects.equals(ifPrint, that.ifPrint) &&
                Objects.equals(createPersonId, that.createPersonId) &&
                Objects.equals(createPersonName, that.createPersonName) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(modifyPersonId, that.modifyPersonId) &&
                Objects.equals(modifyPersonName, that.modifyPersonName) &&
                Objects.equals(modifyDate, that.modifyDate) &&
                Objects.equals(platformId, that.platformId) &&
                Objects.equals(taxRegistrationFlag, that.taxRegistrationFlag) &&
                Objects.equals(withholdProtocolFlag, that.withholdProtocolFlag) &&
                Objects.equals(ifUploadFjsw, that.ifUploadFjsw) &&
                Objects.equals(uploadDate, that.uploadDate) &&
                Objects.equals(resultMsg, that.resultMsg);
    }

    @Override
    public int hashCode() {

        return Objects.hash(regId, userName, idNum, phone, regName, sex, national, cardAddress, issueauthority, validity, validityStartTime, validityEndTime, birthDay, avatarPicLocal, signaturePicLocal, status, taxNum, taxNumDate, ibId, idFontPicLocal, idFontPicRemote, idBackPicLocal, idBackPicRemote, ifPrint, createPersonId, createPersonName, createDate, modifyPersonId, modifyPersonName, modifyDate, platformId, taxRegistrationFlag, withholdProtocolFlag, ifUploadFjsw, uploadDate, resultMsg);
    }
}