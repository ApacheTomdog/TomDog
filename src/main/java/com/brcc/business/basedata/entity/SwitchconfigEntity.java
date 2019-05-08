package com.brcc.business.basedata.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "switchconfig")
public class SwitchconfigEntity  implements Serializable {
    private static final long serialVersionUID = 1L;
    private String platFormId;
    private String switchType;
    private String switchDesc;
    private String switchValue;
    private Date createDate;
    private String createPer;
    private String paramValue1;
    private String paramDesc1;
    private String paramValue2;
    private String paramDesc2;
    private String paramValue3;
    private String paramDesc3;
    private String paramValue4;
    private String paramDesc4;
    private Long switchConfigId;

    @Basic
    @Column(name = "plat_form_id")
    public String getPlatFormId() {
        return platFormId;
    }

    public void setPlatFormId(String platFormId) {
        this.platFormId = platFormId;
    }

    @Basic
    @Column(name = "switch_type")
    public String getSwitchType() {
        return switchType;
    }

    public void setSwitchType(String switchType) {
        this.switchType = switchType;
    }

    @Basic
    @Column(name = "switch_desc")
    public String getSwitchDesc() {
        return switchDesc;
    }

    public void setSwitchDesc(String switchDesc) {
        this.switchDesc = switchDesc;
    }

    @Basic
    @Column(name = "switch_value")
    public String getSwitchValue() {
        return switchValue;
    }

    public void setSwitchValue(String switchValue) {
        this.switchValue = switchValue;
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
    @Column(name = "create_per")
    public String getCreatePer() {
        return createPer;
    }

    public void setCreatePer(String createPer) {
        this.createPer = createPer;
    }

    @Basic
    @Column(name = "param_value1")
    public String getParamValue1() {
        return paramValue1;
    }

    public void setParamValue1(String paramValue1) {
        this.paramValue1 = paramValue1;
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
    @Column(name = "param_value2")
    public String getParamValue2() {
        return paramValue2;
    }

    public void setParamValue2(String paramValue2) {
        this.paramValue2 = paramValue2;
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
    @Column(name = "param_value3")
    public String getParamValue3() {
        return paramValue3;
    }

    public void setParamValue3(String paramValue3) {
        this.paramValue3 = paramValue3;
    }

    @Basic
    @Column(name = "param_desc3")
    public String getParamDesc3() {
        return paramDesc3;
    }

    public void setParamDesc3(String paramDesc3) {
        this.paramDesc3 = paramDesc3;
    }

    @Basic
    @Column(name = "param_value4")
    public String getParamValue4() {
        return paramValue4;
    }

    public void setParamValue4(String paramValue4) {
        this.paramValue4 = paramValue4;
    }

    @Basic
    @Column(name = "param_desc4")
    public String getParamDesc4() {
        return paramDesc4;
    }

    public void setParamDesc4(String paramDesc4) {
        this.paramDesc4 = paramDesc4;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "switch_config_id")
    public Long getSwitchConfigId() {
        return switchConfigId;
    }

    public void setSwitchConfigId(Long switchConfigId) {
        this.switchConfigId = switchConfigId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SwitchconfigEntity that = (SwitchconfigEntity) o;
        return switchConfigId == that.switchConfigId &&
                Objects.equals(platFormId, that.platFormId) &&
                Objects.equals(switchType, that.switchType) &&
                Objects.equals(switchDesc, that.switchDesc) &&
                Objects.equals(switchValue, that.switchValue) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(createPer, that.createPer) &&
                Objects.equals(paramValue1, that.paramValue1) &&
                Objects.equals(paramDesc1, that.paramDesc1) &&
                Objects.equals(paramValue2, that.paramValue2) &&
                Objects.equals(paramDesc2, that.paramDesc2) &&
                Objects.equals(paramValue3, that.paramValue3) &&
                Objects.equals(paramDesc3, that.paramDesc3) &&
                Objects.equals(paramValue4, that.paramValue4) &&
                Objects.equals(paramDesc4, that.paramDesc4);
    }

    @Override
    public int hashCode() {

        return Objects.hash(platFormId, switchType, switchDesc, switchValue, createDate, createPer, paramValue1, paramDesc1, paramValue2, paramDesc2, paramValue3, paramDesc3, paramValue4, paramDesc4, switchConfigId);
    }
}
