package com.brcc.business.goodsordermjk.vo;

import java.util.Date;
import java.util.List;

import com.esteel.common.vo.BaseQueryVo;

/**
* @author PanJianYang
* @version 创建时间：2018年11月6日 下午3:27:30
* @ClassName 类名称
* @Description 类描述
*/
public class GoodsordermjkQueryVo extends BaseQueryVo {
	//平台id
		private String platformId;
		//发单公司id
		private Long companyId;
		//单据来源
		private String fromType;
		//单据主键
		private Long seqId;
		//取单地
		private String getOrderPlate;
		//单据状态
		private String status;
		//投放单号(货源单号)
		private Long orderId;
		//单据号
		private String billNum;
		//是否完善
		private String ifInfoComplete;
		//拼单单据筛选
		private String pinDan;
		//开始时间
		private Date rqStart;
		//结束时间
		private Date rqEnd;
		//目的地
		private String endPlate;
		//起始地
		private String startPlate;
		//货物类型Id
		private Long goodType;
		//货物类型
		private String goodTypeDesc;
		//品种描述
		private String prodDesc;
		//电商配送
		private String dsIfSettle;
		//委托人
		private String billSender;
		//发单人
		private String sender;
		//备注
		private String remark;
		//发单人id
		private Long fdUserId;
		//是否全部显示
		private String ifShowAdmin;
		//账号来源
		private String accountFrom;
		private Date putInRqStart;
		private Date putInRqNnd;
		//单据是否关闭的标记
		private String ifClosed;
		//发货人手机号
		private String billSenderMobile;
		//状态码集合
		private String stuStr;
		
		private String importIdStr;
		//拼单号
		private Integer pinDanNum;
		
		private String ifAdmin;
		// 外部接口货源单据号
		private Long  importId;
		
		//根据角色返回不同的拼单数据
		private String role;
		// 10代表装货地,30代表目的地
		private String addressType;
		// 定向组id
		private String appointTeamId;
		// 定向组名称
		private String appointTeamName;
		// 单据有效期
		private Date pickupDate;
		// 智能推荐
		private String ifZntjFlag;
		// 是否投放给所有平台承运人（Y 是、N 否）
		private String ifAllCompany;
		// 大品种Id
		private Long catalogId;
		// 大品种名字
		private String catalogName;

		//合同号
		private String contractNumber;
		
		public String getRole() {
			return role;
		}
		private List<String> statusList;
		public void setRole(String role) {
			this.role = role;
		}
		public String getPlatformId() {
			return platformId;
		}
		public void setPlatformId(String platformId) {
			this.platformId = platformId;
		}
		
		public Long getCompanyId() {
			return companyId;
		}
		public void setCompanyId(Long companyId) {
			this.companyId = companyId;
		}
		public String getFromType() {
			return fromType;
		}
		public void setFromType(String fromType) {
			this.fromType = fromType;
		}
		public Long getSeqId() {
			return seqId;
		}
		public void setSeqId(Long seqId) {
			this.seqId = seqId;
		}
		public String getGetOrderPlate() {
			return getOrderPlate;
		}
		public void setGetOrderPlate(String getOrderPlate) {
			this.getOrderPlate = getOrderPlate;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public Long getOrderId() {
			return orderId;
		}
		public void setOrderId(Long orderId) {
			this.orderId = orderId;
		}
		public String getBillNum() {
			return billNum;
		}
		public void setBillNum(String billNum) {
			this.billNum = billNum;
		}
		public String getIfInfoComplete() {
			return ifInfoComplete;
		}
		public void setIfInfoComplete(String ifInfoComplete) {
			this.ifInfoComplete = ifInfoComplete;
		}
		public String getPinDan() {
			return pinDan;
		}
		public void setPinDan(String pinDan) {
			this.pinDan = pinDan;
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
		public String getEndPlate() {
			return endPlate;
		}
		public void setEndPlate(String endPlate) {
			this.endPlate = endPlate;
		}
		public String getStartPlate() {
			return startPlate;
		}
		public void setStartPlate(String startPlate) {
			this.startPlate = startPlate;
		}
		public Long getGoodType() {
			return goodType;
		}
		public void setGoodType(Long goodType) {
			this.goodType = goodType;
		}
		public String getGoodTypeDesc() {
			return goodTypeDesc;
		}
		public void setGoodTypeDesc(String goodTypeDesc) {
			this.goodTypeDesc = goodTypeDesc;
		}
		public String getProdDesc() {
			return prodDesc;
		}
		public void setProdDesc(String prodDesc) {
			this.prodDesc = prodDesc;
		}
		public String getDsIfSettle() {
			return dsIfSettle;
		}
		public void setDsIfSettle(String dsIfSettle) {
			this.dsIfSettle = dsIfSettle;
		}
		public String getBillSender() {
			return billSender;
		}
		public void setBillSender(String billSender) {
			this.billSender = billSender;
		}
		public String getSender() {
			return sender;
		}
		public void setSender(String sender) {
			this.sender = sender;
		}
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
		public Long getFdUserId() {
			return fdUserId;
		}
		public void setFdUserId(Long fdUserId) {
			this.fdUserId = fdUserId;
		}
		public String getIfShowAdmin() {
			return ifShowAdmin;
		}
		public void setIfShowAdmin(String ifShowAdmin) {
			this.ifShowAdmin = ifShowAdmin;
		}
		public String getAccountFrom() {
			return accountFrom;
		}
		public void setAccountFrom(String accountFrom) {
			this.accountFrom = accountFrom;
		}
		public Date getPutInRqStart() {
			return putInRqStart;
		}
		public void setPutInRqStart(Date putInRqStart) {
			this.putInRqStart = putInRqStart;
		}
		public Date getPutInRqNnd() {
			return putInRqNnd;
		}
		public void setPutInRqNnd(Date putInRqNnd) {
			this.putInRqNnd = putInRqNnd;
		}
		public String getIfClosed() {
			return ifClosed;
		}
		public void setIfClosed(String ifClosed) {
			this.ifClosed = ifClosed;
		}
		public String getBillSenderMobile() {
			return billSenderMobile;
		}
		public void setBillSenderMobile(String billSenderMobile) {
			this.billSenderMobile = billSenderMobile;
		}
		public String getStuStr() {
			return stuStr;
		}
		public void setStuStr(String stuStr) {
			this.stuStr = stuStr;
		}
		public String getImportIdStr() {
			return importIdStr;
		}
		public void setImportIdStr(String importIdStr) {
			this.importIdStr = importIdStr;
		}
		public Integer getPinDanNum() {
			return pinDanNum;
		}
		public void setPinDanNum(Integer pinDanNum) {
			this.pinDanNum = pinDanNum;
		}
		public String getIfAdmin() {
			return ifAdmin;
		}
		public void setIfAdmin(String ifAdmin) {
			this.ifAdmin = ifAdmin;
		}
		public Long getImportId() {
			return importId;
		}
		public void setImportId(Long importId) {
			this.importId = importId;
		}
		public List<String> getStatusList() {
			return statusList;
		}
		public void setStatusList(List<String> statusList) {
			this.statusList = statusList;
		}
		public String getAddressType() {
			return addressType;
		}
		public void setAddressType(String addressType) {
			this.addressType = addressType;
		}
		public String getAppointTeamId() {
			return appointTeamId;
		}
		public void setAppointTeamId(String appointTeamId) {
			this.appointTeamId = appointTeamId;
		}
		public String getAppointTeamName() {
			return appointTeamName;
		}
		public void setAppointTeamName(String appointTeamName) {
			this.appointTeamName = appointTeamName;
		}
		public Date getPickupDate() {
			return pickupDate;
		}
		public void setPickupDate(Date pickupDate) {
			this.pickupDate = pickupDate;
		}
		public String getIfZntjFlag() {
			return ifZntjFlag;
		}
		public void setIfZntjFlag(String ifZntjFlag) {
			this.ifZntjFlag = ifZntjFlag;
		}
		public String getIfAllCompany() {
			return ifAllCompany;
		}
		public void setIfAllCompany(String ifAllCompany) {
			this.ifAllCompany = ifAllCompany;
		}
		public Long getCatalogId() {
			return catalogId;
		}
		public void setCatalogId(Long catalogId) {
			this.catalogId = catalogId;
		}
		public String getCatalogName() {
			return catalogName;
		}
		public void setCatalogName(String catalogName) {
			this.catalogName = catalogName;
		}
		public String getContractNumber() {
		return contractNumber;
	}
		public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}
}
