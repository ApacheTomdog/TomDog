package com.brcc.business.jkparaminfo.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "jkparaminfo")
public class JkparaminfoEntity {
    private Long id;
    private String desc;
    private String url;
    private String platformId;
    private String param1;
    private String paramDesc1;
    private String param2;
    private String paramDesc2;
    private String param3;
    private String paramDesc3;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "desc")
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
    @Column(name = "param1")
    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    @Basic
    @Column(name = "param_desc1")
    public String getParamDesc1() {
        return paramDesc1;
    }

    public void setParamDesc1(String paramDesc1) {
        this.paramDesc1 = paramDesc1;
    }

    @Basic
    @Column(name = "param2")
    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }

    @Basic
    @Column(name = "param_desc2")
    public String getParamDesc2() {
        return paramDesc2;
    }

    public void setParamDesc2(String paramDesc2) {
        this.paramDesc2 = paramDesc2;
    }

    @Basic
    @Column(name = "param3")
    public String getParam3() {
        return param3;
    }

    public void setParam3(String param3) {
        this.param3 = param3;
    }

    @Basic
    @Column(name = "param_desc3")
    public String getParamDesc3() {
        return paramDesc3;
    }

    public void setParamDesc3(String paramDesc3) {
        this.paramDesc3 = paramDesc3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JkparaminfoEntity that = (JkparaminfoEntity) o;
        return id == that.id &&
                Objects.equals(desc, that.desc) &&
                Objects.equals(url, that.url) &&
                Objects.equals(platformId, that.platformId) &&
                Objects.equals(param1, that.param1) &&
                Objects.equals(paramDesc1, that.paramDesc1) &&
                Objects.equals(param2, that.param2) &&
                Objects.equals(paramDesc2, that.paramDesc2) &&
                Objects.equals(param3, that.param3) &&
                Objects.equals(paramDesc3, that.paramDesc3);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, desc, url, platformId, param1, paramDesc1, param2, paramDesc2, param3, paramDesc3);
    }
}
