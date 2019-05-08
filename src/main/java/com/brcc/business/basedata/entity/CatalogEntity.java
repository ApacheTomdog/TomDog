package com.brcc.business.basedata.entity;
import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the catalog database table.
 * @Desc:货物品种实体类
 */
@Entity
@Table(name="catalog")
@NamedQuery(name="CatalogEntity.findAll", query="SELECT c FROM CatalogEntity c")
public class CatalogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="catalog_sort")
	private Integer catalogSort;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;

	@Column(name="floor_price")
	private BigDecimal floorPrice;

	private String layer;

	private String name;

	@Column(name="old_id")
	private Integer oldId;

	@Column(name="parent_id")
	private Long parentId;

	@Column(name="platform_id")
	private String platformId;

	private String status;

	public CatalogEntity() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCatalogSort() {
		return this.catalogSort;
	}

	public void setCatalogSort(Integer catalogSort) {
		this.catalogSort = catalogSort;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public BigDecimal getFloorPrice() {
		return this.floorPrice;
	}

	public void setFloorPrice(BigDecimal floorPrice) {
		this.floorPrice = floorPrice;
	}

	public String getLayer() {
		return this.layer;
	}

	public void setLayer(String layer) {
		this.layer = layer;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getOldId() {
		return this.oldId;
	}

	public void setOldId(Integer oldId) {
		this.oldId = oldId;
	}

	public Long getParentId() {
		return this.parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getPlatformId() {
		return this.platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}