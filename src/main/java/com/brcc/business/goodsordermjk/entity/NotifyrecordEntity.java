package com.brcc.business.goodsordermjk.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the notifyrecord database table.
 * 货源发布记录
 */
@Entity
@Table(name="notifyrecord")
@NamedQuery(name="NotifyrecordEntity.findAll", query="SELECT n FROM NotifyrecordEntity n")
public class NotifyrecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="seq_id")
	private Long seqId;

	@Column(name="batch_id")
	private Long batchId;

	@Column(name="client_id")
	private Long clientId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;

	private String message;

	@Column(name="plat_form_id")
	private String platFormId;

	@Column(name="user_id")
	private Long userId;

	public NotifyrecordEntity() {
	}

	public Long getSeqId() {
		return this.seqId;
	}

	public void setSeqId(Long seqId) {
		this.seqId = seqId;
	}

	public Long getBatchId() {
		return this.batchId;
	}

	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}

	public Long getClientId() {
		return this.clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPlatFormId() {
		return this.platFormId;
	}

	public void setPlatFormId(String platFormId) {
		this.platFormId = platFormId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}