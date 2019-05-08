package com.brcc.business.creditAdjustPrice.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * @Description:授信调价明细表记录
 * @Auther: gemaochao
 * @Date:Created in 10:22 2018/11/5
 */
@Entity
@Table(name = "credit_adjust_price_detail_log")
public class CreditAdjustPriceDetailLogEntity {

    @Id
    @Column(name = "cred_adj_d_log_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long credAdjDLogId;

    @Basic
    @Column(name = "cred_adj_d_id")
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


    public Long getCredAdjDLogId() {
        return credAdjDLogId;
    }

    public void setCredAdjDLogId(Long credAdjDLogId) {
        this.credAdjDLogId = credAdjDLogId;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditAdjustPriceDetailLogEntity that = (CreditAdjustPriceDetailLogEntity) o;
        return credAdjDLogId == that.credAdjDLogId &&
                Objects.equals(credAdjDId, that.credAdjDId) &&
                Objects.equals(credAdjMId, that.credAdjMId) &&
                Objects.equals(minPrice, that.minPrice) &&
                Objects.equals(maxPrice, that.maxPrice) &&
                Objects.equals(creditAddPrice, that.creditAddPrice) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(createPersonId, that.createPersonId) &&
                Objects.equals(createPersonName, that.createPersonName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(credAdjDLogId, credAdjDId, credAdjMId, minPrice, maxPrice, creditAddPrice, createDate, createPersonId, createPersonName);
    }
}
