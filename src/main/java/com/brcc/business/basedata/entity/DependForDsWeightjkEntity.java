package com.brcc.business.basedata.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the dependfordsweightjk database table.
 * 
 */
@Entity
@Table(name="dependfordsweightjk")
@NamedQuery(name="DependForDsWeightjkEntity.findAll", query="SELECT d FROM DependForDsWeightjkEntity d")
public class DependForDsWeightjkEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pk_id")
	private Long pkId;

	@Column(name="batch_id")
	private Long batchId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="depend_id")
	private String dependId;

	@Column(name="depend_num")
	private String dependNum;

	@Column(name="ds_plat_name")
	private String dsPlatName;

	@Column(name="out_weight")
	private BigDecimal outWeight;

	@Column(name="record_num")
	private Integer recordNum;

	private String result;

	@Column(name="result_reason")
	private String resultReason;

	@Column(name="ret_1")
	private String ret1;

	@Column(name="ret_2")
	private String ret2;

	@Column(name="ret_3")
	private String ret3;

	@Column(name="ret_4")
	private String ret4;

	@Column(name="ret_5")
	private String ret5;

	public DependForDsWeightjkEntity() {
	}

	public Long getPkId() {
		return this.pkId;
	}

	public void setPkId(Long pkId) {
		this.pkId = pkId;
	}

	public Long getBatchId() {
		return this.batchId;
	}

	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDependId() {
		return this.dependId;
	}

	public void setDependId(String dependId) {
		this.dependId = dependId;
	}

	public String getDependNum() {
		return this.dependNum;
	}

	public void setDependNum(String dependNum) {
		this.dependNum = dependNum;
	}

	public String getDsPlatName() {
		return this.dsPlatName;
	}

	public void setDsPlatName(String dsPlatName) {
		this.dsPlatName = dsPlatName;
	}

	public BigDecimal getOutWeight() {
		return this.outWeight;
	}

	public void setOutWeight(BigDecimal outWeight) {
		this.outWeight = outWeight;
	}

	public Integer getRecordNum() {
		return this.recordNum;
	}

	public void setRecordNum(Integer recordNum) {
		this.recordNum = recordNum;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResultReason() {
		return this.resultReason;
	}

	public void setResultReason(String resultReason) {
		this.resultReason = resultReason;
	}

	public String getRet1() {
		return this.ret1;
	}

	public void setRet1(String ret1) {
		this.ret1 = ret1;
	}

	public String getRet2() {
		return this.ret2;
	}

	public void setRet2(String ret2) {
		this.ret2 = ret2;
	}

	public String getRet3() {
		return this.ret3;
	}

	public void setRet3(String ret3) {
		this.ret3 = ret3;
	}

	public String getRet4() {
		return this.ret4;
	}

	public void setRet4(String ret4) {
		this.ret4 = ret4;
	}

	public String getRet5() {
		return this.ret5;
	}

	public void setRet5(String ret5) {
		this.ret5 = ret5;
	}

}