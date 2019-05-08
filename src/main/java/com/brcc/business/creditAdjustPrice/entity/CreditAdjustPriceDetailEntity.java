package com.brcc.business.creditAdjustPrice.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * @Description: 授信调价明细表实体类
 * @Auther: gemaochao
 * @Date:Created in 19:23 2018/11/3
 */
@Entity
@Table(name = "credit_adjust_price_detail", schema = "apptms", catalog = "")
public class CreditAdjustPriceDetailEntity {

    @Id
    @Column(name = "cred_adj_d_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long credAdjDId;

    @Basic
    @Column(name = "cred_adj_m_id")
    private Long credAdjMId;

    @Basic
    @Column(name = "min_price")
    private BigDecimal minPrice;

    @Basic
    @Column(name = "max_price")
    private BigDecimal maxPrice;

    @Basic
    @Column(name = "credit_add_price")
    private BigDecimal creditAddPrice;

    @Basic
    @Column(name = "create_date")
    private Date createDate;

    @Basic
    @Column(name = "create_person_id")
    private Long createPersonId;

    @Basic
    @Column(name = "create_person_name")
    private String createPersonName;

    @Basic
    @Column(name = "modify_date")
    private Date modifyDate;

    @Basic
    @Column(name = "modify_person_id")
    private Long modifyPersonId;

    @Basic
    @Column(name = "modify_person_name")
    private String modifyPersonName;


    public Long getCredAdjDId() {
        return credAdjDId;
    }

    public void setCredAdjDId(Long credAdjDId) {
        this.credAdjDId = credAdjDId;
    }

    public Long getCredAdjMId() {
        return credAdjMId;
    }

    public void setCredAdjMId(Long credAdjMId) {
        this.credAdjMId = credAdjMId;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public BigDecimal getCreditAddPrice() {
        return creditAddPrice;
    }

    public void setCreditAddPrice(BigDecimal creditAddPrice) {
        this.creditAddPrice = creditAddPrice;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditAdjustPriceDetailEntity that = (CreditAdjustPriceDetailEntity) o;
        return credAdjDId == that.credAdjDId &&
                Objects.equals(credAdjMId, that.credAdjMId) &&
                Objects.equals(minPrice, that.minPrice) &&
                Objects.equals(maxPrice, that.maxPrice) &&
                Objects.equals(creditAddPrice, that.creditAddPrice) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(createPersonId, that.createPersonId) &&
                Objects.equals(createPersonName, that.createPersonName) &&
                Objects.equals(modifyDate, that.modifyDate) &&
                Objects.equals(modifyPersonId, that.modifyPersonId) &&
                Objects.equals(modifyPersonName, that.modifyPersonName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(credAdjDId, credAdjMId, minPrice, maxPrice, creditAddPrice, createDate, createPersonId, createPersonName, modifyDate, modifyPersonId, modifyPersonName);
    }
}
