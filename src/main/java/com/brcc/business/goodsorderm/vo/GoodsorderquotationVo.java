package com.brcc.business.goodsorderm.vo;

import java.math.BigDecimal;

import com.brcc.business.goodsorderm.entity.GoodsorderquotationEntity;

/**
* @Desc   货源单货物单价报价查询封装类
* @author TangYong
* @Date   2018-12-08
*/
public class GoodsorderquotationVo extends GoodsorderquotationEntity {
	
	private static final long serialVersionUID = 1L;
	// 平台
	private String platFormId;
	// 域名
	private String platName;
	// 货源单号
	private Long publishId;
	// 公司id
	private Long companyId;
	// 联系电话
	private String contactMobile;
	// 未完成的运单数
	private String tranNum;
	private String tranStatus;
	
	/**报价生成运单*/
	private Long driverId;
	private Long vehicleId;
	private BigDecimal outPrice;
	private BigDecimal grabWeight;
	private String userType;
	private BigDecimal dispatchWeight;
	private BigDecimal dispatchQty;
	private BigDecimal grabQty;
	private Long UserId;
	private String consignorName;
	private String docuSource;
	private String receiver;
	private String message;
	private String sendType;
	
	public String getPlatFormId() {
		return platFormId;
	}
	public void setPlatFormId(String platFormId) {
		this.platFormId = platFormId;
	}	
	public String getPlatName() {
		return platName;
	}
	public void setPlatName(String platName) {
		this.platName = platName;
	}
	public Long getPublishId() {
		return publishId;
	}
	public void setPublishId(Long publishId) {
		this.publishId = publishId;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public String getContactMobile() {
		return contactMobile;
	}
	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}
	public String getTranNum() {
		return tranNum;
	}
	public void setTranNum(String tranNum) {
		this.tranNum = tranNum;
	}
	public String getTranStatus() {
		return tranStatus;
	}
	public void setTranStatus(String tranStatus) {
		this.tranStatus = tranStatus;
	}
	public Long getDriverId() {
		return driverId;
	}
	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}
	public Long getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}
	public BigDecimal getOutPrice() {
		return outPrice;
	}
	public void setOutPrice(BigDecimal outPrice) {
		this.outPrice = outPrice;
	}
	public BigDecimal getGrabWeight() {
		return grabWeight;
	}
	public void setGrabWeight(BigDecimal grabWeight) {
		this.grabWeight = grabWeight;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public BigDecimal getDispatchWeight() {
		return dispatchWeight;
	}
	public void setDispatchWeight(BigDecimal dispatchWeight) {
		this.dispatchWeight = dispatchWeight;
	}
	public BigDecimal getDispatchQty() {
		return dispatchQty;
	}
	public void setDispatchQty(BigDecimal dispatchQty) {
		this.dispatchQty = dispatchQty;
	}
	public Long getUserId() {
		return UserId;
	}
	public void setUserId(Long userId) {
		UserId = userId;
	}
	public String getConsignorName() {
		return consignorName;
	}
	public void setConsignorName(String consignorName) {
		this.consignorName = consignorName;
	}
	public BigDecimal getGrabQty() {
		return grabQty;
	}
	public void setGrabQty(BigDecimal grabQty) {
		this.grabQty = grabQty;
	}
	public String getDocuSource() {
		return docuSource;
	}
	public void setDocuSource(String docuSource) {
		this.docuSource = docuSource;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSendType() {
		return sendType;
	}
	public void setSendType(String sendType) {
		this.sendType = sendType;
	}	
	
}
