package com.brcc.business.payFailureNotice.vo;

import java.sql.Timestamp;
import java.util.Date;

import com.esteel.common.vo.BaseQueryVo;
/**
 * 查询条件信息
 * @author pan
 *
 */
public class PayFailureNoticeQueryVo extends BaseQueryVo {
	private static final long serialVersionUID = 1L;
	private Long payFailureId;// 支付失败通知表
	private String deliveryId; // 调度单id
	private String deliveryNum; // 调度单num
	private String payBillId; // 支付单id
	private String payBillNum; // 支付单num
	private String payBillChildId; // 支付单子表id
	private String payBillChildNum; // 支付单子表num
	private String publishCompanyId; // 发单公司id
	private String publishCompanyName;// 发单公司name
	private String payCompanyId; // 付款公司id
	private String payCompanyName; // 付款公司name
	private String carryCompanyId; // 承运人id(司机，承运公司，经纪人）
	private String carryCompanyName;// 承运人id(司机，承运公司，经纪人）
	private String payFromType; // 2表示司机1表示经纪人
	private String vehicleId; // 车辆id
	private String vehicleNum; // 车牌号
	private String payBankOwner; // 收款银行
	private String payBankName; // 持卡人姓名
	private String payBankNo; // 银行卡号
	private String platformId; // 所属平台
/*	private Timestamp createDate;*/
	private Date rqStart;
	// 创建结束时间
	private Date rqEnd;
	// 货源单号
	private String processFlag;// 代表未处理，1代表已处理
	private Timestamp processDate;
	public Long getPayFailureId() {
		return payFailureId;
	}
	public void setPayFailureId(Long payFailureId) {
		this.payFailureId = payFailureId;
	}
	public String getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(String deliveryId) {
		this.deliveryId = deliveryId;
	}
	public String getDeliveryNum() {
		return deliveryNum;
	}
	public void setDeliveryNum(String deliveryNum) {
		this.deliveryNum = deliveryNum;
	}
	public String getPayBillId() {
		return payBillId;
	}
	public void setPayBillId(String payBillId) {
		this.payBillId = payBillId;
	}
	public String getPayBillNum() {
		return payBillNum;
	}
	public void setPayBillNum(String payBillNum) {
		this.payBillNum = payBillNum;
	}
	public String getPayBillChildId() {
		return payBillChildId;
	}
	public void setPayBillChildId(String payBillChildId) {
		this.payBillChildId = payBillChildId;
	}
	public String getPayBillChildNum() {
		return payBillChildNum;
	}
	public void setPayBillChildNum(String payBillChildNum) {
		this.payBillChildNum = payBillChildNum;
	}
	public String getPublishCompanyId() {
		return publishCompanyId;
	}
	public void setPublishCompanyId(String publishCompanyId) {
		this.publishCompanyId = publishCompanyId;
	}
	public String getPublishCompanyName() {
		return publishCompanyName;
	}
	public void setPublishCompanyName(String publishCompanyName) {
		this.publishCompanyName = publishCompanyName;
	}
	public String getPayCompanyId() {
		return payCompanyId;
	}
	public void setPayCompanyId(String payCompanyId) {
		this.payCompanyId = payCompanyId;
	}
	public String getPayCompanyName() {
		return payCompanyName;
	}
	public void setPayCompanyName(String payCompanyName) {
		this.payCompanyName = payCompanyName;
	}
	public String getCarryCompanyId() {
		return carryCompanyId;
	}
	public void setCarryCompanyId(String carryCompanyId) {
		this.carryCompanyId = carryCompanyId;
	}
	public String getCarryCompanyName() {
		return carryCompanyName;
	}
	public void setCarryCompanyName(String carryCompanyName) {
		this.carryCompanyName = carryCompanyName;
	}
	public String getPayFromType() {
		return payFromType;
	}
	public void setPayFromType(String payFromType) {
		this.payFromType = payFromType;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleNum() {
		return vehicleNum;
	}
	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}
	public String getPayBankOwner() {
		return payBankOwner;
	}
	public void setPayBankOwner(String payBankOwner) {
		this.payBankOwner = payBankOwner;
	}
	public String getPayBankName() {
		return payBankName;
	}
	public void setPayBankName(String payBankName) {
		this.payBankName = payBankName;
	}
	public String getPayBankNo() {
		return payBankNo;
	}
	public void setPayBankNo(String payBankNo) {
		this.payBankNo = payBankNo;
	}
	public String getPlatformId() {
		return platformId;
	}
	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	public Date getRqStart() {
		return rqStart;
	}
	public void setRqStart(Date rqStart) {
		this.rqStart = rqStart;
	}
	public Date getRqEnd() {
		return rqEnd;
	}
	public void setRqEnd(Date rqEnd) {
		this.rqEnd = rqEnd;
	}
	public String getProcessFlag() {
		return processFlag;
	}
	public void setProcessFlag(String processFlag) {
		this.processFlag = processFlag;
	}
	public Timestamp getProcessDate() {
		return processDate;
	}
	public void setProcessDate(Timestamp processDate) {
		this.processDate = processDate;
	}
	
	

}
