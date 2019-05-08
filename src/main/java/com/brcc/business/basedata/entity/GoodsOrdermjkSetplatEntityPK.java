package com.brcc.business.basedata.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the goodsordermjksetplat database table.
 * 
 */
@Embeddable
public class GoodsOrdermjkSetplatEntityPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="tms_fd_company_id")
	private int tmsFdCompanyId;

	@Column(name="tms_platform_id")
	private String tmsPlatformId;

	@Column(name="if_my_ec")
	private String ifMyEc;

	public GoodsOrdermjkSetplatEntityPK() {
	}
	public int getTmsFdCompanyId() {
		return this.tmsFdCompanyId;
	}
	public void setTmsFdCompanyId(int tmsFdCompanyId) {
		this.tmsFdCompanyId = tmsFdCompanyId;
	}
	public String getTmsPlatformId() {
		return this.tmsPlatformId;
	}
	public void setTmsPlatformId(String tmsPlatformId) {
		this.tmsPlatformId = tmsPlatformId;
	}
	public String getIfMyEc() {
		return this.ifMyEc;
	}
	public void setIfMyEc(String ifMyEc) {
		this.ifMyEc = ifMyEc;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GoodsOrdermjkSetplatEntityPK)) {
			return false;
		}
		GoodsOrdermjkSetplatEntityPK castOther = (GoodsOrdermjkSetplatEntityPK)other;
		return 
			(this.tmsFdCompanyId == castOther.tmsFdCompanyId)
			&& this.tmsPlatformId.equals(castOther.tmsPlatformId)
			&& this.ifMyEc.equals(castOther.ifMyEc);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.tmsFdCompanyId;
		hash = hash * prime + this.tmsPlatformId.hashCode();
		hash = hash * prime + this.ifMyEc.hashCode();
		
		return hash;
	}
}