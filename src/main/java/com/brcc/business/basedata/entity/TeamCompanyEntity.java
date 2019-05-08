package com.brcc.business.basedata.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the teamcompany database table.
 * 
 */
@Entity
@Table(name="teamcompany")
@NamedQuery(name="TeamCompanyEntity.findAll", query="SELECT t FROM TeamCompanyEntity t")
public class TeamCompanyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tc_pk_id")
	private Long tcPkId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="cy_company_id")
	private Integer cyCompanyId;

	@Column(name="fd_company_id")
	private Integer fdCompanyId;

	@Column(name="if_system")
	private String ifSystem;

	@Column(name="platform_id")
	private String platformId;

	private String remark;

	@Column(name="team_id")
	private String teamId;

	@Column(name="team_name")
	private String teamName;

	private String type;

	public TeamCompanyEntity() {
	}

	public Long getTcPkId() {
		return this.tcPkId;
	}

	public void setTcPkId(Long tcPkId) {
		this.tcPkId = tcPkId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getCyCompanyId() {
		return this.cyCompanyId;
	}

	public void setCyCompanyId(Integer cyCompanyId) {
		this.cyCompanyId = cyCompanyId;
	}

	public Integer getFdCompanyId() {
		return this.fdCompanyId;
	}

	public void setFdCompanyId(Integer fdCompanyId) {
		this.fdCompanyId = fdCompanyId;
	}

	public String getIfSystem() {
		return this.ifSystem;
	}

	public void setIfSystem(String ifSystem) {
		this.ifSystem = ifSystem;
	}

	public String getPlatformId() {
		return this.platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTeamId() {
		return this.teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return this.teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}