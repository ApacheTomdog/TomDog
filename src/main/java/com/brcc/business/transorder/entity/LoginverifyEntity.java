package com.brcc.business.transorder.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2018-11-25 16:20
 */
@Entity
@Table(name = "loginverify")
public class LoginverifyEntity {

    private String loginName;
    private String userPasswd;
    private int userId;
    private String userName;
    private Timestamp lastLoginTime;
    private Timestamp passwdUpdateTime;
    private String platformId;
    private String status;
    private String userType;
    private Timestamp createDate;
    private String userPart;
    private String ifAdmin;
    private Integer regId;
    private String roleType;
    private String companyId;
    private String mobile;
    private String loginType;
    private Integer upUserId;
    private Long vehicleId;
    private Long driverId;
    private String deviceInfo;
    private String ifPlatAdmin;
    private String verifyCode;
    private String ifGetui;
    private String verifCode;
    private String remark;
    private String ifShowAdmin;
    private String accountFrom;
    private Integer appVerCode;
    private String ifPayFlag;
    private String payPasswd;
    private String openId;
    private Timestamp verifyTime;

    @Basic
    @Column(name = "login_name", nullable = false, length = 20)
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Basic
    @Column(name = "user_passwd", nullable = true, length = 20)
    public String getUserPasswd() {
        return userPasswd;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }

    @Id
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_name", nullable = true, length = 40)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "last_login_time", nullable = true)
    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Basic
    @Column(name = "passwd_update_time", nullable = true)
    public Timestamp getPasswdUpdateTime() {
        return passwdUpdateTime;
    }

    public void setPasswdUpdateTime(Timestamp passwdUpdateTime) {
        this.passwdUpdateTime = passwdUpdateTime;
    }

    @Basic
    @Column(name = "platform_id", nullable = false, length = 20)
    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    @Basic
    @Column(name = "status", nullable = false, length = 20)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "user_type", nullable = true, length = 20)
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Basic
    @Column(name = "create_date", nullable = true)
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "user_part", nullable = true, length = 20)
    public String getUserPart() {
        return userPart;
    }

    public void setUserPart(String userPart) {
        this.userPart = userPart;
    }

    @Basic
    @Column(name = "if_admin", nullable = true, length = 1)
    public String getIfAdmin() {
        return ifAdmin;
    }

    public void setIfAdmin(String ifAdmin) {
        this.ifAdmin = ifAdmin;
    }

    @Basic
    @Column(name = "reg_id", nullable = true)
    public Integer getRegId() {
        return regId;
    }

    public void setRegId(Integer regId) {
        this.regId = regId;
    }

    @Basic
    @Column(name = "role_type", nullable = true, length = 20)
    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    @Basic
    @Column(name = "company_id", nullable = true, length = 20)
    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "mobile", nullable = true, length = 20)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "login_type", nullable = true, length = 20)
    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    @Basic
    @Column(name = "up_user_id", nullable = true)
    public Integer getUpUserId() {
        return upUserId;
    }

    public void setUpUserId(Integer upUserId) {
        this.upUserId = upUserId;
    }

    @Basic
    @Column(name = "vehicle_id", nullable = true)
    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Basic
    @Column(name = "driver_id", nullable = true)
    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    @Basic
    @Column(name = "device_info", nullable = true, length = 400)
    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    @Basic
    @Column(name = "if_plat_admin", nullable = true, length = 1)
    public String getIfPlatAdmin() {
        return ifPlatAdmin;
    }

    public void setIfPlatAdmin(String ifPlatAdmin) {
        this.ifPlatAdmin = ifPlatAdmin;
    }

    @Basic
    @Column(name = "verify_code", nullable = true, length = 20)
    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    @Basic
    @Column(name = "if_getui", nullable = true, length = 1)
    public String getIfGetui() {
        return ifGetui;
    }

    public void setIfGetui(String ifGetui) {
        this.ifGetui = ifGetui;
    }

    @Basic
    @Column(name = "verif_code", nullable = true, length = 20)
    public String getVerifCode() {
        return verifCode;
    }

    public void setVerifCode(String verifCode) {
        this.verifCode = verifCode;
    }

    @Basic
    @Column(name = "remark", nullable = true, length = 100)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "if_show_admin", nullable = true, length = 1)
    public String getIfShowAdmin() {
        return ifShowAdmin;
    }

    public void setIfShowAdmin(String ifShowAdmin) {
        this.ifShowAdmin = ifShowAdmin;
    }

    @Basic
    @Column(name = "account_from", nullable = true, length = 20)
    public String getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(String accountFrom) {
        this.accountFrom = accountFrom;
    }

    @Basic
    @Column(name = "app_ver_code", nullable = true)
    public Integer getAppVerCode() {
        return appVerCode;
    }

    public void setAppVerCode(Integer appVerCode) {
        this.appVerCode = appVerCode;
    }

    @Basic
    @Column(name = "if_pay_flag", nullable = true, length = 1)
    public String getIfPayFlag() {
        return ifPayFlag;
    }

    public void setIfPayFlag(String ifPayFlag) {
        this.ifPayFlag = ifPayFlag;
    }

    @Basic
    @Column(name = "pay_passwd", nullable = true, length = 10)
    public String getPayPasswd() {
        return payPasswd;
    }

    public void setPayPasswd(String payPasswd) {
        this.payPasswd = payPasswd;
    }

    @Basic
    @Column(name = "open_id", nullable = true, length = 50)
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Basic
    @Column(name = "verify_time", nullable = true)
    public Timestamp getVerifyTime() {
        return verifyTime;
    }

    public void setVerifyTime(Timestamp verifyTime) {
        this.verifyTime = verifyTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginverifyEntity that = (LoginverifyEntity) o;
        return userId == that.userId &&
                Objects.equals(loginName, that.loginName) &&
                Objects.equals(userPasswd, that.userPasswd) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(lastLoginTime, that.lastLoginTime) &&
                Objects.equals(passwdUpdateTime, that.passwdUpdateTime) &&
                Objects.equals(platformId, that.platformId) &&
                Objects.equals(status, that.status) &&
                Objects.equals(userType, that.userType) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(userPart, that.userPart) &&
                Objects.equals(ifAdmin, that.ifAdmin) &&
                Objects.equals(regId, that.regId) &&
                Objects.equals(roleType, that.roleType) &&
                Objects.equals(companyId, that.companyId) &&
                Objects.equals(mobile, that.mobile) &&
                Objects.equals(loginType, that.loginType) &&
                Objects.equals(upUserId, that.upUserId) &&
                Objects.equals(vehicleId, that.vehicleId) &&
                Objects.equals(driverId, that.driverId) &&
                Objects.equals(deviceInfo, that.deviceInfo) &&
                Objects.equals(ifPlatAdmin, that.ifPlatAdmin) &&
                Objects.equals(verifyCode, that.verifyCode) &&
                Objects.equals(ifGetui, that.ifGetui) &&
                Objects.equals(verifCode, that.verifCode) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(ifShowAdmin, that.ifShowAdmin) &&
                Objects.equals(accountFrom, that.accountFrom) &&
                Objects.equals(appVerCode, that.appVerCode) &&
                Objects.equals(ifPayFlag, that.ifPayFlag) &&
                Objects.equals(payPasswd, that.payPasswd) &&
                Objects.equals(openId, that.openId) &&
                Objects.equals(verifyTime, that.verifyTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(loginName, userPasswd, userId, userName, lastLoginTime, passwdUpdateTime, platformId, status, userType, createDate, userPart, ifAdmin, regId, roleType, companyId, mobile, loginType, upUserId, vehicleId, driverId, deviceInfo, ifPlatAdmin, verifyCode, ifGetui, verifCode, remark, ifShowAdmin, accountFrom, appVerCode, ifPayFlag, payPasswd, openId, verifyTime);
    }
}