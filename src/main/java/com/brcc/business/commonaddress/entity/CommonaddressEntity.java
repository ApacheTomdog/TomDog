package com.brcc.business.commonaddress.entity;


import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the commonaddress database table.
 * @Desc:常用路线实体类
 */
@Entity
@Table(name="commonaddress")
@NamedQuery(name="CommonaddressEntity.findAll", query="SELECT c FROM CommonaddressEntity c")
public class CommonaddressEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="address_id")
	private Long addressId;

	@Column(name="address")
	private String address;
	
	@Column(name="address_type")
	private String addressType;

	@Column(name="city_id")
	private String cityId;

	@Column(name="city_name")
	private String cityName;

	@Column(name="company_id")
	private String companyId;

	@Column(name="company_name")
	private String companyName;

	@Column(name="contact_name")
	private String contactName;

	@Column(name="contact_tele")
	private String contactTele;

	@Column(name="country_id")
	private String countryId;

	@Column(name="country_name")
	private String countryName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="create_person_id")
	private String createPersonId;

	@Column(name="create_person_name")
	private String createPersonName;

	@Column(name="plate_lat")
	private String plateLat;

	@Column(name="plate_lng")
	private String plateLng;

	@Column(name="platform_id")
	private String platformId;

	@Column(name="province_id")
	private String provinceId;

	@Column(name="province_name")
	private String provinceName;

	public Long getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressType() {
		return this.addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getCityId() {
		return this.cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactTele() {
		return this.contactTele;
	}

	public void setContactTele(String contactTele) {
		this.contactTele = contactTele;
	}

	public String getCountryId() {
		return this.countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreatePersonId() {
		return this.createPersonId;
	}

	public void setCreatePersonId(String createPersonId) {
		this.createPersonId = createPersonId;
	}

	public String getCreatePersonName() {
		return this.createPersonName;
	}

	public void setCreatePersonName(String createPersonName) {
		this.createPersonName = createPersonName;
	}

	public String getPlateLat() {
		return this.plateLat;
	}

	public void setPlateLat(String plateLat) {
		this.plateLat = plateLat;
	}

	public String getPlateLng() {
		return this.plateLng;
	}

	public void setPlateLng(String plateLng) {
		this.plateLng = plateLng;
	}

	public String getPlatformId() {
		return this.platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public String getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceName() {
		return this.provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

}