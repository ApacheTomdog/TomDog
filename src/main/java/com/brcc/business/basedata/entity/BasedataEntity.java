package com.brcc.business.basedata.entity;
import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the basedata database table.
 * @Desc: 省市县实体类
 */
@Entity
@Table(name="basedata")
@NamedQuery(name="BasedataEntity.findAll", query="SELECT b FROM BasedataEntity b")
public class BasedataEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name="data_type")
	private String dataType;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String key;
	
	@Column(name="father_key")
	private String fatherKey;

	@Column(name="father_key_value")
	private String fatherKeyValue;

	@Column(name="father_type")
	private String fatherType;

	@Column(name="key_value")
	private String keyValue;

	@Column(name="key_value_py")
	private String keyValuePy;

	private BigDecimal lat;

	private BigDecimal lng;

	@Column(name="wccyr_code")
	private String wccyrCode;

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getFatherKey() {
		return fatherKey;
	}

	public void setFatherKey(String fatherKey) {
		this.fatherKey = fatherKey;
	}

	public String getFatherKeyValue() {
		return fatherKeyValue;
	}

	public void setFatherKeyValue(String fatherKeyValue) {
		this.fatherKeyValue = fatherKeyValue;
	}

	public String getFatherType() {
		return fatherType;
	}

	public void setFatherType(String fatherType) {
		this.fatherType = fatherType;
	}

	public String getKeyValue() {
		return keyValue;
	}

	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}

	public String getKeyValuePy() {
		return keyValuePy;
	}

	public void setKeyValuePy(String keyValuePy) {
		this.keyValuePy = keyValuePy;
	}

	public BigDecimal getLat() {
		return lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public BigDecimal getLng() {
		return lng;
	}

	public void setLng(BigDecimal lng) {
		this.lng = lng;
	}

	public String getWccyrCode() {
		return wccyrCode;
	}

	public void setWccyrCode(String wccyrCode) {
		this.wccyrCode = wccyrCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}