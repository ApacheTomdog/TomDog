package com.brcc.business.Interface.InterfaceOfCw.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.StringJoiner;


@Entity
@Table(name = "ds_receive_log")
public class DsReceiveLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "ds_user_name")
    private String dsUserName;
    @Column(name = "ds_password")
    private String dsPassword;
    @Column(name = "ds_plat_name")
    private String dsPlatName;
    @Column(columnDefinition = "text" ,name = "ds_data_info")
    private String dsDataInfo;
    @Column(name = "ds_error_msg")
    private String dsErrorMsg;
    @Column(name="ds_create_time")
    private Date dsCreateTime;
    @Column(name = "ds_version")
    private Long dsVersion;
    @Column(name = "ds_url")
    private String dsURL;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDsUserName() {
        return dsUserName;
    }

    public void setDsUserName(String dsUserName) {
        this.dsUserName = dsUserName;
    }

    public String getDsPassword() {
        return dsPassword;
    }

    public void setDsPassword(String dsPassword) {
        this.dsPassword = dsPassword;
    }

    public String getDsPlatName() {
        return dsPlatName;
    }

    public void setDsPlatName(String dsPlatName) {
        this.dsPlatName = dsPlatName;
    }

    public String getDsDataInfo() {
        return dsDataInfo;
    }

    public void setDsDataInfo(String dsDataInfo) {
        this.dsDataInfo = dsDataInfo;
    }

    public String getDsErrorMsg() {
        return dsErrorMsg;
    }

    public void setDsErrorMsg(String dsErrorMsg) {
        this.dsErrorMsg = dsErrorMsg;
    }

    public Date getDsCreateTime() {
        return dsCreateTime;
    }

    public void setDsCreateTime(Date dsCreateTime) {
        this.dsCreateTime = dsCreateTime;
    }

    public Long getDsVersion() {
        return dsVersion;
    }

    public void setDsVersion(Long dsVersion) {
        this.dsVersion = dsVersion;
    }

    public String getDsURL() {
        return dsURL;
    }

    public void setDsURL(String dsURL) {
        this.dsURL = dsURL;
    }
}

