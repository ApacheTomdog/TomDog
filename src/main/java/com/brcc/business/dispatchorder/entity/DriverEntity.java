package com.brcc.business.dispatchorder.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2018-11-12 13:37
 */
@Entity
@Table(name = "driver")
public class DriverEntity {

    private Long id;
    private String phone;
    private String name;
    private String sex;
    private String national;
    private Date birthDay;
    private String address;
    private String cardAddress;
    private String idNum;
    private String issueauthority;
    private String validity;
    private Date validityStartTime;
    private Date validityEndTime;
    private String idFontPicLocal;
    private String idFontPicRemote;
    private String idBackPicLocal;
    private String idBackPicRemote;
    private String driverLicenceLocal;
    private String driverLicenceRemote;
    private String occupPicLocal;
    private String occupPicRemote;
    private String avatarPicLocal;
    private String signaturePicLocal;
    private String fromPlatId;
    private String status;
    private String ifTransport;
    private String ifIcQualification;
    private Date createTime;
    private Date sysProDate;
    private String idFontPicLocalBake;
    private String idFontPicRemoteBake;
    private String idBackPicLocalBake;
    private String idBackPicRemoteBake;
    private BigDecimal locationLng;
    private BigDecimal locationLat;
    private Date locationDate;
    private String ifPush;

    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    @Column(name = "name", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "birth_day", nullable = true)
    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 200)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
    @Column(name = "id_num", nullable = true, length = 45)
    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
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
    @Column(name = "driver_licence_local", nullable = true, length = 200)
    public String getDriverLicenceLocal() {
        return driverLicenceLocal;
    }

    public void setDriverLicenceLocal(String driverLicenceLocal) {
        this.driverLicenceLocal = driverLicenceLocal;
    }

    @Basic
    @Column(name = "driver_licence_remote", nullable = true, length = 200)
    public String getDriverLicenceRemote() {
        return driverLicenceRemote;
    }

    public void setDriverLicenceRemote(String driverLicenceRemote) {
        this.driverLicenceRemote = driverLicenceRemote;
    }

    @Basic
    @Column(name = "occup_pic_local", nullable = true, length = 200)
    public String getOccupPicLocal() {
        return occupPicLocal;
    }

    public void setOccupPicLocal(String occupPicLocal) {
        this.occupPicLocal = occupPicLocal;
    }

    @Basic
    @Column(name = "occup_pic_remote", nullable = true, length = 200)
    public String getOccupPicRemote() {
        return occupPicRemote;
    }

    public void setOccupPicRemote(String occupPicRemote) {
        this.occupPicRemote = occupPicRemote;
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
    @Column(name = "from_plat_id", nullable = true, length = 200)
    public String getFromPlatId() {
        return fromPlatId;
    }

    public void setFromPlatId(String fromPlatId) {
        this.fromPlatId = fromPlatId;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 20)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "if_transport", nullable = true, length = 1)
    public String getIfTransport() {
        return ifTransport;
    }

    public void setIfTransport(String ifTransport) {
        this.ifTransport = ifTransport;
    }

    @Basic
    @Column(name = "if_ic_qualification", nullable = true, length = 1)
    public String getIfIcQualification() {
        return ifIcQualification;
    }

    public void setIfIcQualification(String ifIcQualification) {
        this.ifIcQualification = ifIcQualification;
    }

    @Basic
    @Column(name = "create_time", nullable = true)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "sys_pro_date", nullable = true)
    public Date getSysProDate() {
        return sysProDate;
    }

    public void setSysProDate(Date sysProDate) {
        this.sysProDate = sysProDate;
    }

    @Basic
    @Column(name = "id_font_pic_local_bake", nullable = true, length = 200)
    public String getIdFontPicLocalBake() {
        return idFontPicLocalBake;
    }

    public void setIdFontPicLocalBake(String idFontPicLocalBake) {
        this.idFontPicLocalBake = idFontPicLocalBake;
    }

    @Basic
    @Column(name = "id_font_pic_remote_bake", nullable = true, length = 200)
    public String getIdFontPicRemoteBake() {
        return idFontPicRemoteBake;
    }

    public void setIdFontPicRemoteBake(String idFontPicRemoteBake) {
        this.idFontPicRemoteBake = idFontPicRemoteBake;
    }

    @Basic
    @Column(name = "id_back_pic_local_bake", nullable = true, length = 200)
    public String getIdBackPicLocalBake() {
        return idBackPicLocalBake;
    }

    public void setIdBackPicLocalBake(String idBackPicLocalBake) {
        this.idBackPicLocalBake = idBackPicLocalBake;
    }

    @Basic
    @Column(name = "id_back_pic_remote_bake", nullable = true, length = 200)
    public String getIdBackPicRemoteBake() {
        return idBackPicRemoteBake;
    }

    public void setIdBackPicRemoteBake(String idBackPicRemoteBake) {
        this.idBackPicRemoteBake = idBackPicRemoteBake;
    }

    @Basic
    @Column(name = "location_lng", nullable = true, precision = 10)
    public BigDecimal getLocationLng() {
        return locationLng;
    }

    public void setLocationLng(BigDecimal locationLng) {
        this.locationLng = locationLng;
    }

    @Basic
    @Column(name = "location_lat", nullable = true, precision = 10)
    public BigDecimal getLocationLat() {
        return locationLat;
    }

    public void setLocationLat(BigDecimal locationLat) {
        this.locationLat = locationLat;
    }

    @Basic
    @Column(name = "location_date", nullable = true)
    public Date getLocationDate() {
        return locationDate;
    }

    public void setLocationDate(Date locationDate) {
        this.locationDate = locationDate;
    }

    @Basic
    @Column(name = "if_push", nullable = true, length = 1)
    public String getIfPush() {
        return ifPush;
    }

    public void setIfPush(String ifPush) {
        this.ifPush = ifPush;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriverEntity that = (DriverEntity) o;
        return id == that.id &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(name, that.name) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(national, that.national) &&
                Objects.equals(birthDay, that.birthDay) &&
                Objects.equals(address, that.address) &&
                Objects.equals(cardAddress, that.cardAddress) &&
                Objects.equals(idNum, that.idNum) &&
                Objects.equals(issueauthority, that.issueauthority) &&
                Objects.equals(validity, that.validity) &&
                Objects.equals(validityStartTime, that.validityStartTime) &&
                Objects.equals(validityEndTime, that.validityEndTime) &&
                Objects.equals(idFontPicLocal, that.idFontPicLocal) &&
                Objects.equals(idFontPicRemote, that.idFontPicRemote) &&
                Objects.equals(idBackPicLocal, that.idBackPicLocal) &&
                Objects.equals(idBackPicRemote, that.idBackPicRemote) &&
                Objects.equals(driverLicenceLocal, that.driverLicenceLocal) &&
                Objects.equals(driverLicenceRemote, that.driverLicenceRemote) &&
                Objects.equals(occupPicLocal, that.occupPicLocal) &&
                Objects.equals(occupPicRemote, that.occupPicRemote) &&
                Objects.equals(avatarPicLocal, that.avatarPicLocal) &&
                Objects.equals(signaturePicLocal, that.signaturePicLocal) &&
                Objects.equals(fromPlatId, that.fromPlatId) &&
                Objects.equals(status, that.status) &&
                Objects.equals(ifTransport, that.ifTransport) &&
                Objects.equals(ifIcQualification, that.ifIcQualification) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(sysProDate, that.sysProDate) &&
                Objects.equals(idFontPicLocalBake, that.idFontPicLocalBake) &&
                Objects.equals(idFontPicRemoteBake, that.idFontPicRemoteBake) &&
                Objects.equals(idBackPicLocalBake, that.idBackPicLocalBake) &&
                Objects.equals(idBackPicRemoteBake, that.idBackPicRemoteBake) &&
                Objects.equals(locationLng, that.locationLng) &&
                Objects.equals(locationLat, that.locationLat) &&
                Objects.equals(locationDate, that.locationDate) &&
                Objects.equals(ifPush, that.ifPush);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, phone, name, sex, national, birthDay, address, cardAddress, idNum, issueauthority, validity, validityStartTime, validityEndTime, idFontPicLocal, idFontPicRemote, idBackPicLocal, idBackPicRemote, driverLicenceLocal, driverLicenceRemote, occupPicLocal, occupPicRemote, avatarPicLocal, signaturePicLocal, fromPlatId, status, ifTransport, ifIcQualification, createTime, sysProDate, idFontPicLocalBake, idFontPicRemoteBake, idBackPicLocalBake, idBackPicRemoteBake, locationLng, locationLat, locationDate, ifPush);
    }
}