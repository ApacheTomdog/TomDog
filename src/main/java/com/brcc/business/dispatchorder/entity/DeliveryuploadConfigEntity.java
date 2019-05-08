package com.brcc.business.dispatchorder.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2018-11-11 11:42
 */
@Entity
@Table(name = "deliveryupload_config")
public class DeliveryuploadConfigEntity implements Serializable {

    private Long seqId;
    private String jkName;
    private String jkNameDesc;
    private String jkValue;
    private String paramValue1;
    private String paramValue2;

    @Id
    @Column(name = "seq_id", nullable = false)
    public Long getSeqId() {
        return seqId;
    }

    public void setSeqId(Long seqId) {
        this.seqId = seqId;
    }

    @Basic
    @Column(name = "jk_name", nullable = true, length = 50)
    public String getJkName() {
        return jkName;
    }

    public void setJkName(String jkName) {
        this.jkName = jkName;
    }

    @Basic
    @Column(name = "jk_name_desc", nullable = true, length = 100)
    public String getJkNameDesc() {
        return jkNameDesc;
    }

    public void setJkNameDesc(String jkNameDesc) {
        this.jkNameDesc = jkNameDesc;
    }

    @Basic
    @Column(name = "jk_value", nullable = true, length = 100)
    public String getJkValue() {
        return jkValue;
    }

    public void setJkValue(String jkValue) {
        this.jkValue = jkValue;
    }

    @Basic
    @Column(name = "param_value1", nullable = true, length = 100)
    public String getParamValue1() {
        return paramValue1;
    }

    public void setParamValue1(String paramValue1) {
        this.paramValue1 = paramValue1;
    }

    @Basic
    @Column(name = "param_value2", nullable = true, length = 100)
    public String getParamValue2() {
        return paramValue2;
    }

    public void setParamValue2(String paramValue2) {
        this.paramValue2 = paramValue2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryuploadConfigEntity that = (DeliveryuploadConfigEntity) o;
        return seqId == that.seqId &&
                Objects.equals(jkName, that.jkName) &&
                Objects.equals(jkNameDesc, that.jkNameDesc) &&
                Objects.equals(jkValue, that.jkValue) &&
                Objects.equals(paramValue1, that.paramValue1) &&
                Objects.equals(paramValue2, that.paramValue2);
    }

    @Override
    public int hashCode() {

        return Objects.hash(seqId, jkName, jkNameDesc, jkValue, paramValue1, paramValue2);
    }
}