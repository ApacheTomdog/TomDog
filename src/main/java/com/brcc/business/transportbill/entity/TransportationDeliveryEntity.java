package com.brcc.business.transportbill.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * Created with IntelliJ IDEA.
 * Description: 运输委托单 主信息
 * User: zhangxiuzhi
 * Date: 2018-11-02
 * Time: 15:21
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "transportationdelivery")
public class TransportationDeliveryEntity implements Serializable {
    //调度单ID
    private Long deliveryId;
    private String deliveryNum;
    //货源投放单Id
    private Long publishId;
    private String publishNum;
    //运输委托单Id
    private Long transId;
    private String transNum;
    //货物重量
    private BigDecimal weight;
    //货物金额
    private BigDecimal amount;
    //创建时间
    private Date createDate;
    //承运单位Id
    private Long companyId;
    //装货地址
    private String startPlate;
    //目的地
    private String endPlate;
    //司机Id
    private Long driverId;
    //车辆Id
    private Long vehicleId;
    //创建人Id
    private Long createPerson;
    //平台Id
    private String platformId;
    // 10:待取单,20:待装货,30:待收货,90:已完成,00:已取消
    private String status;

    private Double departureLng;
    private Double departureLat;
    private Double destinationLng;
    private Double destinationLat;
    private Double getOrderAddressLng;
    private Double getOrderAddressLat;

    //取单地
    private String getOrderPlate;
    //出发地 给老版本用
    private String departure;
    //目的地 给老版本用
    private String destination;
    //取单地 给老版本用
    private String getOrderAddress;
    //发货人
    private String sender;
    //发货人 联系电话
    private String senderMobile;
    //收货人 联系电话
    private String receiverMobile;
    //收货人
    private String receiver;
    //发单联系人
    private String billSender;
    //发单联系人电话
    private String billSenderMobile;
    //取单人
    private String billTaker;
    //取单人 联系电话
    private String billTakerMobile;

    private Date updateDate;
    private Long updatePerson;
    //货物类别 （Catalog表id）
    private Long goodType;
    //货物类别描述
    private String goodTypeDesc;
    private BigDecimal qty;
    private BigDecimal price;

    private Date pickupDate;
    //取单时间
    private Date billTime;
    //发货时间
    private Date deliveryTime;
    //完成时间
    private Date finishTime;
    //发单人companyId
    private Long publishCompanyId;
    //单据生成来源 APP WEB
    private String operateType;
    //0 为司机自动调度的 1 为物流公司调度的
    private String docuSource;
    //结算重量
    private BigDecimal settleWeight;
    //结算单价
    private BigDecimal settlePrice;
    //结算金额
    private BigDecimal settleAmount;
    //恒帅源 运费补贴标记 默认 0 处理过1
    private String ortherFlag;
    //装车单号
    private String loadingId;
    //是否司机评价： N 为待评价 Y为已评价
    private String ifDriverJudge;
    //是否发单人评价: N为待评价 Y为已评价
    private String ifFdJudge;
    //提单验证码
    private String verifyCode;
    //电商绑定过来的UserId
    private Integer fdUserId;
    //默认为Y 买家自运为N
    private String ifCanShow;
    //如果是飞单位 Y
    private String ifFeidan;
    //阿里云显示图片地址
    private String comfirmPicLocal;
    //司机手机端显示图片地址
    private String comfirmPicRemote;
    //收货确认验证码
    private String receiptVerifyCode;
    //收货验证码发送时间
    private Date receiptOperDate;
    //装车重量，收货重量修改信息
    private String remark;
    //装车确认操作时间记录
    private Date zcSureDate;
    //收货确认操作时间记录
    private Date shSureDate;
    //装车重量
    private BigDecimal truckLoadingWeight;
    //收货重量
    private BigDecimal takeDeliveryWeight;
    //结算状态 20 已结算 10 未结算 默认为未结算
    private String settleStatus;
    //油卡卡号 云南
    private String oilCardNo;
    //油卡金额 云南
    private BigDecimal oilCardAmount;
    //支付单Id
    private Long zfId;
    //支付单号
    private String zfNum;
    //司机所属承运公司的Id(天津友发针对司机只有被一个承运公司收纳)
    private Long carryCompanyId;
    //是否已经买过保险 Y 是 N 否
    private String insuranceFlag;
    //保险单 单号
    private String insuranceNo;
    //保险金额
    private BigDecimal insuranceAmount;
    //阿里云 显示图片地址
    private String comfirmPic1Local;
    //司机手机端显示图片地址
    private String comfirmPic1Remote;
    //阿里云 显示图片地址
    private String comfirmPic2Local;
    //司机手机端显示图片地址
    private String comfirmPic2Remote;
    //如果未拼单为publish_id,如果已拼单为第一条的publish_id
    private Long priPublishId;
    //司机是否已经对发单人评价 默认为N
    private String ifCyJudge;
    //计算备注
    private String jsRemark;
    //计算方式 01：全部运费 02：运费+油卡
    private String jsType;
    //油卡金额比例
    private BigDecimal oilRatio;
    //油卡单Id
    private String payOidId;
    //油卡单号
    private String payOidNum;
    //是否打印 Y N
    private String ifAlreadyPrint;
    //打印单据人Id
    private Long printPerson;
    //打印时间
    private Date dataPrint;
    //当前单据是否上传至嘀嗒物流平台
    private String ifSend;
    //调用接口返回的结果 1代表成功
    private String result;
    //嘀嗒接口调用成功之后返回的唯一键
    private String resourceId;
    //失败代码
    private String failCode;
    //失败消息
    private String failMessage;
    //装货和卸货接口上传标记00(代表数据没有上传,10代表装车已上传,20代表收货已上传)
    private String jkFinsh;
    //浮动费用类型
    private String floatType;
    //浮动费用
    private BigDecimal floatPrice;
    //是否调用接口支付'20'支付成功,'00'没有做支付
    private String ifJkpay;
    //轨迹信息是否上传
    private String ifSendlocation;
    //标准税率
    private BigDecimal standardTax;
    //含税运费单价
    private BigDecimal priceTax;
    //N 不含税运输 Y 含税运输
    private String ifTaxTransport;
    //if_tax_transport是Y的话，相关id；其他为0
    private Long vatFlowMasterId;
    //0表示未上传，1表示已上传可修改，2表示已上传不可修改
    private String ifUploadReceiptFlag;
    //1未开票 1 开票中 2 已开票
    private String ifInvoice;
    //大宗返回的装车重量
    private BigDecimal dzZcWeight;
    //大宗返回装车重量的时间
    private Date dzZcTime;
    //是否货主自己维护的装车重量 0 否 1 是
    private String zcWeightFrom;
    //经济人收费方式,'dj','每单定额收取','dl','每单按比率收取'
    private String brokerPeopleTollType;
    //经济人收费金额
    private BigDecimal brokerPeopleTollAmount;
    //经纪人收费比率
    private BigDecimal brokerPeopleTollRatio;
    //是否经济人收费 Y是 N否
    private String ifBrokerPeopleTollFlag;
    //抢单到收货的时间差
    private Integer qdShDiffTime;
    //集团Id
    private Long groupId;
    //集团名称
    private String groupName;
    //回单装车重量收货重量统一维护时间
    private Date hdZcShTime;
    //回单装车重量收货重量统一维护操作人id
    private Long hdZcShModifyPersonId;
    //信贷单价
    private BigDecimal creditPrice;
    //货主运费调整标记（Y:需要调整，N：不需要调整）
    private String ownerAdjustFlag;
    //货主运费调整方式（01：单价调整，02：单车调整）
    private String ownerAdjustType;
    //货主运费调整金额
    private BigDecimal ownerAdjustAmt;
    //信息费
    private BigDecimal infoPrice;
    //1代表抢单信息来自智能推荐 0 相反
    private String ifZntsFlag;
    //司磅地点
    private String poundLocation;
    //司磅单号
    private String poundNum;
    //出厂时间
    private Date shippingTime;
    //大宗状态：已签到 SH_SIGN_IN，已入厂 SH_IN_DOOR，已卸货 SH_SCENE_CONFIRM，已出厂 SH_OUT_DOOR
    private String dzStatus;
    //大宗状态更新时间
    private Date dzStatusUpdateTime;
    //货物单价
    private BigDecimal goodPrice;
    //路损类型 1定额 2定率 默认为2
    private String lossType;
    //路损比例
    private BigDecimal lossRatio;
    //定额路损重量
    private BigDecimal lossWeight;
    private String ifFundsControlFlag;
    private String fundsControlPic;
    private String mWeightFlag;
    private BigDecimal mWeight;
    private Long brokerFundsControlMasterId;
    //货主备注
    private String goodsOwnerPs;
    
    private String signStatus;
	
	private Date signTime;
	
	private String signPersonName;
	
	private Long signPersonId;

	private Integer returnNum;

	private String spellListNum;

	@Basic
    @Column(name = "spell_list_num")
	public String getSpellListNum() {
		return spellListNum;
	}

	public void setSpellListNum(String spellListNum) {
		this.spellListNum = spellListNum;
	}

	@Basic
    @Column(name = "return_num")
    public Integer getReturnNum() {
		return returnNum;
	}

	public void setReturnNum(Integer returnNum) {
		this.returnNum = returnNum;
	}

	@Id

	//装车磅单图片
	private String truckLoadingPic;

    @Id
    @Column(name = "delivery_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }
    
    @Basic
    @Column(name = "m_weight_flag")
    public String getmWeightFlag() {
		return mWeightFlag;
	}

	public void setmWeightFlag(String mWeightFlag) {
		this.mWeightFlag = mWeightFlag;
	}

	@Basic
    @Column(name = "m_weight")
	public BigDecimal getmWeight() {
		return mWeight;
	}

	public void setmWeight(BigDecimal mWeight) {
		this.mWeight = mWeight;
	}

	@Basic
    @Column(name = "if_funds_control_flag")
    public String getIfFundsControlFlag() {
		return ifFundsControlFlag;
	}
    
    public void setIfFundsControlFlag(String ifFundsControlFlag) {
		this.ifFundsControlFlag = ifFundsControlFlag;
	}
    
    @Basic
    @Column(name = "funds_control_pic")
    public String getFundsControlPic() {
    	return fundsControlPic;
    }

    public void setFundsControlPic(String fundsControlPic) {
		this.fundsControlPic = fundsControlPic;
	}
	
	@Basic
    @Column(name = "delivery_num")
    public String getDeliveryNum() {
        return deliveryNum;
    }

    public void setDeliveryNum(String deliveryNum) {
        this.deliveryNum = deliveryNum;
    }

    @Basic
    @Column(name = "publish_id")
    public Long getPublishId() {
        return publishId;
    }

    public void setPublishId(Long publishId) {
        this.publishId = publishId;
    }

    @Basic
    @Column(name = "publish_num")
    public String getPublishNum() {
        return publishNum;
    }

    public void setPublishNum(String publishNum) {
        this.publishNum = publishNum;
    }

    @Basic
    @Column(name = "trans_id")
    public Long getTransId() {
        return transId;
    }

    public void setTransId(Long transId) {
        this.transId = transId;
    }

    @Basic
    @Column(name = "trans_num")
    public String getTransNum() {
        return transNum;
    }

    public void setTransNum(String transNum) {
        this.transNum = transNum;
    }

    @Basic
    @Column(name = "weight")
    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "amount")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "create_date")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "company_id")
    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "start_plate")
    public String getStartPlate() {
        return startPlate;
    }

    public void setStartPlate(String startPlate) {
        this.startPlate = startPlate;
    }

    @Basic
    @Column(name = "end_plate")
    public String getEndPlate() {
        return endPlate;
    }

    public void setEndPlate(String endPlate) {
        this.endPlate = endPlate;
    }

    @Basic
    @Column(name = "driver_id")
    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    @Basic
    @Column(name = "vehicle_id")
    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Basic
    @Column(name = "create_person")
    public Long getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(Long createPerson) {
        this.createPerson = createPerson;
    }

    @Basic
    @Column(name = "platform_id")
    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "departure_lng")
    public Double getDepartureLng() {
        return departureLng;
    }

    public void setDepartureLng(Double departureLng) {
        this.departureLng = departureLng;
    }

    @Basic
    @Column(name = "departure_lat")
    public Double getDepartureLat() {
        return departureLat;
    }

    public void setDepartureLat(Double departureLat) {
        this.departureLat = departureLat;
    }

    @Basic
    @Column(name = "destination_lng")
    public Double getDestinationLng() {
        return destinationLng;
    }

    public void setDestinationLng(Double destinationLng) {
        this.destinationLng = destinationLng;
    }

    @Basic
    @Column(name = "destination_lat")
    public Double getDestinationLat() {
        return destinationLat;
    }

    public void setDestinationLat(Double destinationLat) {
        this.destinationLat = destinationLat;
    }

    @Basic
    @Column(name = "get_order_address_lng")
    public Double getGetOrderAddressLng() {
        return getOrderAddressLng;
    }

    public void setGetOrderAddressLng(Double getOrderAddressLng) {
        this.getOrderAddressLng = getOrderAddressLng;
    }

    @Basic
    @Column(name = "get_order_address_lat")
    public Double getGetOrderAddressLat() {
        return getOrderAddressLat;
    }

    public void setGetOrderAddressLat(Double getOrderAddressLat) {
        this.getOrderAddressLat = getOrderAddressLat;
    }

    @Basic
    @Column(name = "get_order_plate")
    public String getGetOrderPlate() {
        return getOrderPlate;
    }

    public void setGetOrderPlate(String getOrderPlate) {
        this.getOrderPlate = getOrderPlate;
    }

    @Basic
    @Column(name = "departure")
    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    @Basic
    @Column(name = "destination")
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Basic
    @Column(name = "get_order_address")
    public String getGetOrderAddress() {
        return getOrderAddress;
    }

    public void setGetOrderAddress(String getOrderAddress) {
        this.getOrderAddress = getOrderAddress;
    }

    @Basic
    @Column(name = "sender")
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Basic
    @Column(name = "sender_mobile")
    public String getSenderMobile() {
        return senderMobile;
    }

    public void setSenderMobile(String senderMobile) {
        this.senderMobile = senderMobile;
    }

    @Basic
    @Column(name = "receiver_mobile")
    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    @Basic
    @Column(name = "receiver")
    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    @Basic
    @Column(name = "bill_sender")
    public String getBillSender() {
        return billSender;
    }

    public void setBillSender(String billSender) {
        this.billSender = billSender;
    }

    @Basic
    @Column(name = "bill_sender_mobile")
    public String getBillSenderMobile() {
        return billSenderMobile;
    }

    public void setBillSenderMobile(String billSenderMobile) {
        this.billSenderMobile = billSenderMobile;
    }

    @Basic
    @Column(name = "bill_taker")
    public String getBillTaker() {
        return billTaker;
    }

    public void setBillTaker(String billTaker) {
        this.billTaker = billTaker;
    }

    @Basic
    @Column(name = "bill_taker_mobile")
    public String getBillTakerMobile() {
        return billTakerMobile;
    }

    public void setBillTakerMobile(String billTakerMobile) {
        this.billTakerMobile = billTakerMobile;
    }

    @Basic
    @Column(name = "update_date")
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Basic
    @Column(name = "update_person")
    public Long getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(Long updatePerson) {
        this.updatePerson = updatePerson;
    }

    @Basic
    @Column(name = "good_type")
    public Long getGoodType() {
        return goodType;
    }

    public void setGoodType(Long goodType) {
        this.goodType = goodType;
    }

    @Basic
    @Column(name = "good_type_desc")
    public String getGoodTypeDesc() {
        return goodTypeDesc;
    }

    public void setGoodTypeDesc(String goodTypeDesc) {
        this.goodTypeDesc = goodTypeDesc;
    }

    @Basic
    @Column(name = "qty")
    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "pickup_date")
    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    @Basic
    @Column(name = "bill_time")
    public Date getBillTime() {
        return billTime;
    }

    public void setBillTime(Date billTime) {
        this.billTime = billTime;
    }

    @Basic
    @Column(name = "delivery_time")
    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    @Basic
    @Column(name = "finish_time")
    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    @Basic
    @Column(name = "publish_company_id")
    public Long getPublishCompanyId() {
        return publishCompanyId;
    }

    public void setPublishCompanyId(Long publishCompanyId) {
        this.publishCompanyId = publishCompanyId;
    }

    @Basic
    @Column(name = "operate_type")
    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    @Basic
    @Column(name = "docu_source")
    public String getDocuSource() {
        return docuSource;
    }

    public void setDocuSource(String docuSource) {
        this.docuSource = docuSource;
    }

    @Basic
    @Column(name = "settle_weight")
    public BigDecimal getSettleWeight() {
        return settleWeight;
    }

    public void setSettleWeight(BigDecimal settleWeight) {
        this.settleWeight = settleWeight;
    }

    @Basic
    @Column(name = "settle_price")
    public BigDecimal getSettlePrice() {
        return settlePrice;
    }

    public void setSettlePrice(BigDecimal settlePrice) {
        this.settlePrice = settlePrice;
    }

    @Basic
    @Column(name = "settle_amount")
    public BigDecimal getSettleAmount() {
        return settleAmount;
    }

    public void setSettleAmount(BigDecimal settleAmount) {
        this.settleAmount = settleAmount;
    }

    @Basic
    @Column(name = "orther_flag")
    public String getOrtherFlag() {
        return ortherFlag;
    }

    public void setOrtherFlag(String ortherFlag) {
        this.ortherFlag = ortherFlag;
    }

    @Basic
    @Column(name = "loading_id")
    public String getLoadingId() {
        return loadingId;
    }

    public void setLoadingId(String loadingId) {
        this.loadingId = loadingId;
    }

    @Basic
    @Column(name = "if_driver_judge")
    public String getIfDriverJudge() {
        return ifDriverJudge;
    }

    public void setIfDriverJudge(String ifDriverJudge) {
        this.ifDriverJudge = ifDriverJudge;
    }

    @Basic
    @Column(name = "if_fd_judge")
    public String getIfFdJudge() {
        return ifFdJudge;
    }

    public void setIfFdJudge(String ifFdJudge) {
        this.ifFdJudge = ifFdJudge;
    }

    @Basic
    @Column(name = "verify_code")
    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    @Basic
    @Column(name = "fd_user_id")
    public Integer getFdUserId() {
        return fdUserId;
    }

    public void setFdUserId(Integer fdUserId) {
        this.fdUserId = fdUserId;
    }

    @Basic
    @Column(name = "if_can_show")
    public String getIfCanShow() {
        return ifCanShow;
    }

    public void setIfCanShow(String ifCanShow) {
        this.ifCanShow = ifCanShow;
    }

    @Basic
    @Column(name = "if_feidan")
    public String getIfFeidan() {
        return ifFeidan;
    }

    public void setIfFeidan(String ifFeidan) {
        this.ifFeidan = ifFeidan;
    }

    @Basic
    @Column(name = "comfirm_pic_local")
    public String getComfirmPicLocal() {
        return comfirmPicLocal;
    }

    public void setComfirmPicLocal(String comfirmPicLocal) {
        this.comfirmPicLocal = comfirmPicLocal;
    }

    @Basic
    @Column(name = "comfirm_pic_remote")
    public String getComfirmPicRemote() {
        return comfirmPicRemote;
    }

    public void setComfirmPicRemote(String comfirmPicRemote) {
        this.comfirmPicRemote = comfirmPicRemote;
    }

    @Basic
    @Column(name = "receipt_verify_code")
    public String getReceiptVerifyCode() {
        return receiptVerifyCode;
    }

    public void setReceiptVerifyCode(String receiptVerifyCode) {
        this.receiptVerifyCode = receiptVerifyCode;
    }

    @Basic
    @Column(name = "receipt_oper_date")
    public Date getReceiptOperDate() {
        return receiptOperDate;
    }

    public void setReceiptOperDate(Date receiptOperDate) {
        this.receiptOperDate = receiptOperDate;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "zcSure_date")
    public Date getZcSureDate() {
        return zcSureDate;
    }

    public void setZcSureDate(Date zcSureDate) {
        this.zcSureDate = zcSureDate;
    }

    @Basic
    @Column(name = "shSure_date")
    public Date getShSureDate() {
        return shSureDate;
    }

    public void setShSureDate(Date shSureDate) {
        this.shSureDate = shSureDate;
    }

    @Basic
    @Column(name = "truck_loading_weight")
    public BigDecimal getTruckLoadingWeight() {
        return truckLoadingWeight;
    }

    public void setTruckLoadingWeight(BigDecimal truckLoadingWeight) {
        this.truckLoadingWeight = truckLoadingWeight;
    }

    @Basic
    @Column(name = "take_delivery_weight")
    public BigDecimal getTakeDeliveryWeight() {
        return takeDeliveryWeight;
    }

    public void setTakeDeliveryWeight(BigDecimal takeDeliveryWeight) {
        this.takeDeliveryWeight = takeDeliveryWeight;
    }

    @Basic
    @Column(name = "settle_status")
    public String getSettleStatus() {
        return settleStatus;
    }

    public void setSettleStatus(String settleStatus) {
        this.settleStatus = settleStatus;
    }

    @Basic
    @Column(name = "oil_card_no")
    public String getOilCardNo() {
        return oilCardNo;
    }

    public void setOilCardNo(String oilCardNo) {
        this.oilCardNo = oilCardNo;
    }

    @Basic
    @Column(name = "oil_card_amount")
    public BigDecimal getOilCardAmount() {
        return oilCardAmount;
    }

    public void setOilCardAmount(BigDecimal oilCardAmount) {
        this.oilCardAmount = oilCardAmount;
    }

    @Basic
    @Column(name = "zf_id")
    public Long getZfId() {
        return zfId;
    }

    public void setZfId(Long zfId) {
        this.zfId = zfId;
    }

    @Basic
    @Column(name = "zf_num")
    public String getZfNum() {
        return zfNum;
    }

    public void setZfNum(String zfNum) {
        this.zfNum = zfNum;
    }

    @Basic
    @Column(name = "carry_company_id")
    public Long getCarryCompanyId() {
        return carryCompanyId;
    }

    public void setCarryCompanyId(Long carryCompanyId) {
        this.carryCompanyId = carryCompanyId;
    }

    @Basic
    @Column(name = "insurance_flag")
    public String getInsuranceFlag() {
        return insuranceFlag;
    }

    public void setInsuranceFlag(String insuranceFlag) {
        this.insuranceFlag = insuranceFlag;
    }

    @Basic
    @Column(name = "insurance_no")
    public String getInsuranceNo() {
        return insuranceNo;
    }

    public void setInsuranceNo(String insuranceNo) {
        this.insuranceNo = insuranceNo;
    }

    @Basic
    @Column(name = "insurance_amount")
    public BigDecimal getInsuranceAmount() {
        return insuranceAmount;
    }

    public void setInsuranceAmount(BigDecimal insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    @Basic
    @Column(name = "comfirm_pic1_local")
    public String getComfirmPic1Local() {
        return comfirmPic1Local;
    }

    public void setComfirmPic1Local(String comfirmPic1Local) {
        this.comfirmPic1Local = comfirmPic1Local;
    }

    @Basic
    @Column(name = "comfirm_pic1_remote")
    public String getComfirmPic1Remote() {
        return comfirmPic1Remote;
    }

    public void setComfirmPic1Remote(String comfirmPic1Remote) {
        this.comfirmPic1Remote = comfirmPic1Remote;
    }

    @Basic
    @Column(name = "comfirm_pic2_local")
    public String getComfirmPic2Local() {
        return comfirmPic2Local;
    }

    public void setComfirmPic2Local(String comfirmPic2Local) {
        this.comfirmPic2Local = comfirmPic2Local;
    }

    @Basic
    @Column(name = "comfirm_pic2_remote")
    public String getComfirmPic2Remote() {
        return comfirmPic2Remote;
    }

    public void setComfirmPic2Remote(String comfirmPic2Remote) {
        this.comfirmPic2Remote = comfirmPic2Remote;
    }

    @Basic
    @Column(name = "pri_publish_id")
    public Long getPriPublishId() {
        return priPublishId;
    }

    public void setPriPublishId(Long priPublishId) {
        this.priPublishId = priPublishId;
    }

    @Basic
    @Column(name = "if_cy_judge")
    public String getIfCyJudge() {
        return ifCyJudge;
    }

    public void setIfCyJudge(String ifCyJudge) {
        this.ifCyJudge = ifCyJudge;
    }

    @Basic
    @Column(name = "js_remark")
    public String getJsRemark() {
        return jsRemark;
    }

    public void setJsRemark(String jsRemark) {
        this.jsRemark = jsRemark;
    }

    @Basic
    @Column(name = "js_type")
    public String getJsType() {
        return jsType;
    }

    public void setJsType(String jsType) {
        this.jsType = jsType;
    }

    @Basic
    @Column(name = "oil_ratio")
    public BigDecimal getOilRatio() {
        return oilRatio;
    }

    public void setOilRatio(BigDecimal oilRatio) {
        this.oilRatio = oilRatio;
    }

    @Basic
    @Column(name = "pay_oid_id")
    public String getPayOidId() {
        return payOidId;
    }

    public void setPayOidId(String payOidId) {
        this.payOidId = payOidId;
    }

    @Basic
    @Column(name = "pay_oid_num")
    public String getPayOidNum() {
        return payOidNum;
    }

    public void setPayOidNum(String payOidNum) {
        this.payOidNum = payOidNum;
    }

    @Basic
    @Column(name = "if_already_print")
    public String getIfAlreadyPrint() {
        return ifAlreadyPrint;
    }

    public void setIfAlreadyPrint(String ifAlreadyPrint) {
        this.ifAlreadyPrint = ifAlreadyPrint;
    }

    @Basic
    @Column(name = "print_person")
    public Long getPrintPerson() {
        return printPerson;
    }

    public void setPrintPerson(Long printPerson) {
        this.printPerson = printPerson;
    }

    @Basic
    @Column(name = "data_print")
    public Date getDataPrint() {
        return dataPrint;
    }

    public void setDataPrint(Date dataPrint) {
        this.dataPrint = dataPrint;
    }

    @Basic
    @Column(name = "if_send")
    public String getIfSend() {
        return ifSend;
    }

    public void setIfSend(String ifSend) {
        this.ifSend = ifSend;
    }

    @Basic
    @Column(name = "result")
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Basic
    @Column(name = "resourceId")
    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    @Basic
    @Column(name = "failCode")
    public String getFailCode() {
        return failCode;
    }

    public void setFailCode(String failCode) {
        this.failCode = failCode;
    }

    @Basic
    @Column(name = "failMessage")
    public String getFailMessage() {
        return failMessage;
    }

    public void setFailMessage(String failMessage) {
        this.failMessage = failMessage;
    }

    @Basic
    @Column(name = "jk_finsh")
    public String getJkFinsh() {
        return jkFinsh;
    }

    public void setJkFinsh(String jkFinsh) {
        this.jkFinsh = jkFinsh;
    }

    @Basic
    @Column(name = "float_type")
    public String getFloatType() {
        return floatType;
    }

    public void setFloatType(String floatType) {
        this.floatType = floatType;
    }

    @Basic
    @Column(name = "float_price")
    public BigDecimal getFloatPrice() {
        return floatPrice;
    }

    public void setFloatPrice(BigDecimal floatPrice) {
        this.floatPrice = floatPrice;
    }

    @Basic
    @Column(name = "if_jkpay")
    public String getIfJkpay() {
        return ifJkpay;
    }

    public void setIfJkpay(String ifJkpay) {
        this.ifJkpay = ifJkpay;
    }

    @Basic
    @Column(name = "if_sendlocation")
    public String getIfSendlocation() {
        return ifSendlocation;
    }

    public void setIfSendlocation(String ifSendlocation) {
        this.ifSendlocation = ifSendlocation;
    }

    @Basic
    @Column(name = "standard_tax")
    public BigDecimal getStandardTax() {
        return standardTax;
    }

    public void setStandardTax(BigDecimal standardTax) {
        this.standardTax = standardTax;
    }

    @Basic
    @Column(name = "price_tax")
    public BigDecimal getPriceTax() {
        return priceTax;
    }

    public void setPriceTax(BigDecimal priceTax) {
        this.priceTax = priceTax;
    }

    @Basic
    @Column(name = "if_tax_transport")
    public String getIfTaxTransport() {
        return ifTaxTransport;
    }

    public void setIfTaxTransport(String ifTaxTransport) {
        this.ifTaxTransport = ifTaxTransport;
    }

    @Basic
    @Column(name = "vat_flow_master_id")
    public Long getVatFlowMasterId() {
        return vatFlowMasterId;
    }

    public void setVatFlowMasterId(Long vatFlowMasterId) {
        this.vatFlowMasterId = vatFlowMasterId;
    }

    @Basic
    @Column(name = "if_upload_receipt_flag")
    public String getIfUploadReceiptFlag() {
        return ifUploadReceiptFlag;
    }

    public void setIfUploadReceiptFlag(String ifUploadReceiptFlag) {
        this.ifUploadReceiptFlag = ifUploadReceiptFlag;
    }

    @Basic
    @Column(name = "if_invoice")
    public String getIfInvoice() {
        return ifInvoice;
    }

    public void setIfInvoice(String ifInvoice) {
        this.ifInvoice = ifInvoice;
    }

    @Basic
    @Column(name = "dz_zc_weight")
    public BigDecimal getDzZcWeight() {
        return dzZcWeight;
    }

    public void setDzZcWeight(BigDecimal dzZcWeight) {
        this.dzZcWeight = dzZcWeight;
    }

    @Basic
    @Column(name = "dz_zc_time")
    public Date getDzZcTime() {
        return dzZcTime;
    }

    public void setDzZcTime(Date dzZcTime) {
        this.dzZcTime = dzZcTime;
    }

    @Basic
    @Column(name = "zc_weight_from")
    public String getZcWeightFrom() {
        return zcWeightFrom;
    }

    public void setZcWeightFrom(String zcWeightFrom) {
        this.zcWeightFrom = zcWeightFrom;
    }

    @Basic
    @Column(name = "broker_people_toll_type")
    public String getBrokerPeopleTollType() {
        return brokerPeopleTollType;
    }

    public void setBrokerPeopleTollType(String brokerPeopleTollType) {
        this.brokerPeopleTollType = brokerPeopleTollType;
    }

    @Basic
    @Column(name = "broker_people_toll_amount")
    public BigDecimal getBrokerPeopleTollAmount() {
        return brokerPeopleTollAmount;
    }

    public void setBrokerPeopleTollAmount(BigDecimal brokerPeopleTollAmount) {
        this.brokerPeopleTollAmount = brokerPeopleTollAmount;
    }

    @Basic
    @Column(name = "broker_people_toll_ratio")
    public BigDecimal getBrokerPeopleTollRatio() {
        return brokerPeopleTollRatio;
    }

    public void setBrokerPeopleTollRatio(BigDecimal brokerPeopleTollRatio) {
        this.brokerPeopleTollRatio = brokerPeopleTollRatio;
    }

    @Basic
    @Column(name = "if_broker_people_toll_flag")
    public String getIfBrokerPeopleTollFlag() {
        return ifBrokerPeopleTollFlag;
    }

    public void setIfBrokerPeopleTollFlag(String ifBrokerPeopleTollFlag) {
        this.ifBrokerPeopleTollFlag = ifBrokerPeopleTollFlag;
    }

    @Basic
    @Column(name = "qd_sh_diff_time")
    public Integer getQdShDiffTime() {
        return qdShDiffTime;
    }

    public void setQdShDiffTime(Integer qdShDiffTime) {
        this.qdShDiffTime = qdShDiffTime;
    }

    @Basic
    @Column(name = "group_id")
    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "group_name")
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Basic
    @Column(name = "hd_zc_sh_time")
    public Date getHdZcShTime() {
        return hdZcShTime;
    }

    public void setHdZcShTime(Date hdZcShTime) {
        this.hdZcShTime = hdZcShTime;
    }

    @Basic
    @Column(name = "hd_zc_sh_modify_person_id")
    public Long getHdZcShModifyPersonId() {
        return hdZcShModifyPersonId;
    }

    public void setHdZcShModifyPersonId(Long hdZcShModifyPersonId) {
        this.hdZcShModifyPersonId = hdZcShModifyPersonId;
    }

    @Basic
    @Column(name = "credit_price")
    public BigDecimal getCreditPrice() {
        return creditPrice;
    }

    public void setCreditPrice(BigDecimal creditPrice) {
        this.creditPrice = creditPrice;
    }

    @Basic
    @Column(name = "owner_adjust_flag")
    public String getOwnerAdjustFlag() {
        return ownerAdjustFlag;
    }

    public void setOwnerAdjustFlag(String ownerAdjustFlag) {
        this.ownerAdjustFlag = ownerAdjustFlag;
    }

    @Basic
    @Column(name = "owner_adjust_type")
    public String getOwnerAdjustType() {
        return ownerAdjustType;
    }

    public void setOwnerAdjustType(String ownerAdjustType) {
        this.ownerAdjustType = ownerAdjustType;
    }

    @Basic
    @Column(name = "owner_adjust_amt")
    public BigDecimal getOwnerAdjustAmt() {
        return ownerAdjustAmt;
    }

    public void setOwnerAdjustAmt(BigDecimal ownerAdjustAmt) {
        this.ownerAdjustAmt = ownerAdjustAmt;
    }

    @Basic
    @Column(name = "info_price")
    public BigDecimal getInfoPrice() {
        return infoPrice;
    }

    public void setInfoPrice(BigDecimal infoPrice) {
        this.infoPrice = infoPrice;
    }

    @Basic
    @Column(name = "if_znts_flag")
    public String getIfZntsFlag() {
        return ifZntsFlag;
    }

    public void setIfZntsFlag(String ifZntsFlag) {
        this.ifZntsFlag = ifZntsFlag;
    }

    @Basic
    @Column(name = "pound_location")
    public String getPoundLocation() {
        return poundLocation;
    }

    public void setPoundLocation(String poundLocation) {
        this.poundLocation = poundLocation;
    }

    @Basic
    @Column(name = "pound_num")
    public String getPoundNum() {
        return poundNum;
    }

    public void setPoundNum(String poundNum) {
        this.poundNum = poundNum;
    }

    @Basic
    @Column(name = "shipping_time")
    public Date getShippingTime() {
        return shippingTime;
    }

    public void setShippingTime(Date shippingTime) {
        this.shippingTime = shippingTime;
    }

    @Basic
    @Column(name = "dz_status")
    public String getDzStatus() {
        return dzStatus;
    }

    public void setDzStatus(String dzStatus) {
        this.dzStatus = dzStatus;
    }

    @Basic
    @Column(name = "dz_status_update_time")
    public Date getDzStatusUpdateTime() {
        return dzStatusUpdateTime;
    }

    public void setDzStatusUpdateTime(Date dzStatusUpdateTime) {
        this.dzStatusUpdateTime = dzStatusUpdateTime;
    }

    @Basic
    @Column(name = "good_price")
    public BigDecimal getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(BigDecimal goodPrice) {
        this.goodPrice = goodPrice;
    }

    @Basic
    @Column(name = "loss_type")
    public String getLossType() {
        return lossType;
    }

    public void setLossType(String lossType) {
        this.lossType = lossType;
    }

    @Basic
    @Column(name = "loss_ratio")
    public BigDecimal getLossRatio() {
        return lossRatio;
    }

    public void setLossRatio(BigDecimal lossRatio) {
        this.lossRatio = lossRatio;
    }

    @Basic
    @Column(name = "loss_weight")
    public BigDecimal getLossWeight() {
        return lossWeight;
    }

    public void setLossWeight(BigDecimal lossWeight) {
        this.lossWeight = lossWeight;
    }

    @Basic
    @Column(name = "broker_funds_control_master_id")
    public Long getBrokerFundsControlMasterId() {
        return brokerFundsControlMasterId;
    }

    public void setBrokerFundsControlMasterId(Long brokerFundsControlMasterId) {
        this.brokerFundsControlMasterId = brokerFundsControlMasterId;
    }
    
    @Basic
    @Column(name = "goods_owner_ps")
    public String getGoodsOwnerPs() {
		return goodsOwnerPs;
	}

	public void setGoodsOwnerPs(String goodsOwnerPs) {
		this.goodsOwnerPs = goodsOwnerPs;
	}
	
    @Column(name = "sign_status")
    public String getSignStatus() {
		return signStatus;
	}

	public void setSignStatus(String signStatus) {
		this.signStatus = signStatus;
	}
	
	@Basic
	@Column(name = "sign_time")
	public Date getSignTime() {
		return signTime;
	}

	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}
	
	@Basic
	@Column(name = "sign_person_name")
	public String getSignPersonName() {
		return signPersonName;
	}
	public void setSignPersonName(String signPersonName) {
		this.signPersonName = signPersonName;
	}
	
	@Basic
	@Column(name = "sign_person_id")
	public Long getSignPersonId() {
		return signPersonId;
	}

	public void setSignPersonId(Long signPersonId) {
		this.signPersonId = signPersonId;
	}

	@Basic
    @Column(name = "truck_loading_pic")
    public String getTruckLoadingPic() {
        return truckLoadingPic;
    }

    public void setTruckLoadingPic(String truckLoadingPic) {
        this.truckLoadingPic = truckLoadingPic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransportationDeliveryEntity that = (TransportationDeliveryEntity) o;
        return Objects.equals(deliveryId, that.deliveryId) &&
                Objects.equals(deliveryNum, that.deliveryNum) &&
                Objects.equals(publishId, that.publishId) &&
                Objects.equals(publishNum, that.publishNum) &&
                Objects.equals(transId, that.transId) &&
                Objects.equals(transNum, that.transNum) &&
                Objects.equals(weight, that.weight) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(companyId, that.companyId) &&
                Objects.equals(startPlate, that.startPlate) &&
                Objects.equals(endPlate, that.endPlate) &&
                Objects.equals(driverId, that.driverId) &&
                Objects.equals(vehicleId, that.vehicleId) &&
                Objects.equals(createPerson, that.createPerson) &&
                Objects.equals(platformId, that.platformId) &&
                Objects.equals(status, that.status) &&
                Objects.equals(departureLng, that.departureLng) &&
                Objects.equals(departureLat, that.departureLat) &&
                Objects.equals(destinationLng, that.destinationLng) &&
                Objects.equals(destinationLat, that.destinationLat) &&
                Objects.equals(getOrderAddressLng, that.getOrderAddressLng) &&
                Objects.equals(getOrderAddressLat, that.getOrderAddressLat) &&
                Objects.equals(getOrderPlate, that.getOrderPlate) &&
                Objects.equals(departure, that.departure) &&
                Objects.equals(destination, that.destination) &&
                Objects.equals(getOrderAddress, that.getOrderAddress) &&
                Objects.equals(sender, that.sender) &&
                Objects.equals(senderMobile, that.senderMobile) &&
                Objects.equals(receiverMobile, that.receiverMobile) &&
                Objects.equals(receiver, that.receiver) &&
                Objects.equals(billSender, that.billSender) &&
                Objects.equals(billSenderMobile, that.billSenderMobile) &&
                Objects.equals(billTaker, that.billTaker) &&
                Objects.equals(billTakerMobile, that.billTakerMobile) &&
                Objects.equals(updateDate, that.updateDate) &&
                Objects.equals(updatePerson, that.updatePerson) &&
                Objects.equals(goodType, that.goodType) &&
                Objects.equals(goodTypeDesc, that.goodTypeDesc) &&
                Objects.equals(qty, that.qty) &&
                Objects.equals(price, that.price) &&
                Objects.equals(pickupDate, that.pickupDate) &&
                Objects.equals(billTime, that.billTime) &&
                Objects.equals(deliveryTime, that.deliveryTime) &&
                Objects.equals(finishTime, that.finishTime) &&
                Objects.equals(publishCompanyId, that.publishCompanyId) &&
                Objects.equals(operateType, that.operateType) &&
                Objects.equals(docuSource, that.docuSource) &&
                Objects.equals(settleWeight, that.settleWeight) &&
                Objects.equals(settlePrice, that.settlePrice) &&
                Objects.equals(settleAmount, that.settleAmount) &&
                Objects.equals(ortherFlag, that.ortherFlag) &&
                Objects.equals(loadingId, that.loadingId) &&
                Objects.equals(ifDriverJudge, that.ifDriverJudge) &&
                Objects.equals(ifFdJudge, that.ifFdJudge) &&
                Objects.equals(verifyCode, that.verifyCode) &&
                Objects.equals(fdUserId, that.fdUserId) &&
                Objects.equals(ifCanShow, that.ifCanShow) &&
                Objects.equals(ifFeidan, that.ifFeidan) &&
                Objects.equals(comfirmPicLocal, that.comfirmPicLocal) &&
                Objects.equals(comfirmPicRemote, that.comfirmPicRemote) &&
                Objects.equals(receiptVerifyCode, that.receiptVerifyCode) &&
                Objects.equals(receiptOperDate, that.receiptOperDate) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(zcSureDate, that.zcSureDate) &&
                Objects.equals(shSureDate, that.shSureDate) &&
                Objects.equals(truckLoadingWeight, that.truckLoadingWeight) &&
                Objects.equals(takeDeliveryWeight, that.takeDeliveryWeight) &&
                Objects.equals(settleStatus, that.settleStatus) &&
                Objects.equals(oilCardNo, that.oilCardNo) &&
                Objects.equals(oilCardAmount, that.oilCardAmount) &&
                Objects.equals(zfId, that.zfId) &&
                Objects.equals(zfNum, that.zfNum) &&
                Objects.equals(carryCompanyId, that.carryCompanyId) &&
                Objects.equals(insuranceFlag, that.insuranceFlag) &&
                Objects.equals(insuranceNo, that.insuranceNo) &&
                Objects.equals(insuranceAmount, that.insuranceAmount) &&
                Objects.equals(comfirmPic1Local, that.comfirmPic1Local) &&
                Objects.equals(comfirmPic1Remote, that.comfirmPic1Remote) &&
                Objects.equals(comfirmPic2Local, that.comfirmPic2Local) &&
                Objects.equals(comfirmPic2Remote, that.comfirmPic2Remote) &&
                Objects.equals(priPublishId, that.priPublishId) &&
                Objects.equals(ifCyJudge, that.ifCyJudge) &&
                Objects.equals(jsRemark, that.jsRemark) &&
                Objects.equals(jsType, that.jsType) &&
                Objects.equals(oilRatio, that.oilRatio) &&
                Objects.equals(payOidId, that.payOidId) &&
                Objects.equals(payOidNum, that.payOidNum) &&
                Objects.equals(ifAlreadyPrint, that.ifAlreadyPrint) &&
                Objects.equals(printPerson, that.printPerson) &&
                Objects.equals(dataPrint, that.dataPrint) &&
                Objects.equals(ifSend, that.ifSend) &&
                Objects.equals(result, that.result) &&
                Objects.equals(resourceId, that.resourceId) &&
                Objects.equals(failCode, that.failCode) &&
                Objects.equals(failMessage, that.failMessage) &&
                Objects.equals(jkFinsh, that.jkFinsh) &&
                Objects.equals(floatType, that.floatType) &&
                Objects.equals(floatPrice, that.floatPrice) &&
                Objects.equals(ifJkpay, that.ifJkpay) &&
                Objects.equals(ifSendlocation, that.ifSendlocation) &&
                Objects.equals(standardTax, that.standardTax) &&
                Objects.equals(priceTax, that.priceTax) &&
                Objects.equals(ifTaxTransport, that.ifTaxTransport) &&
                Objects.equals(vatFlowMasterId, that.vatFlowMasterId) &&
                Objects.equals(ifUploadReceiptFlag, that.ifUploadReceiptFlag) &&
                Objects.equals(ifInvoice, that.ifInvoice) &&
                Objects.equals(dzZcWeight, that.dzZcWeight) &&
                Objects.equals(dzZcTime, that.dzZcTime) &&
                Objects.equals(zcWeightFrom, that.zcWeightFrom) &&
                Objects.equals(brokerPeopleTollType, that.brokerPeopleTollType) &&
                Objects.equals(brokerPeopleTollAmount, that.brokerPeopleTollAmount) &&
                Objects.equals(brokerPeopleTollRatio, that.brokerPeopleTollRatio) &&
                Objects.equals(ifBrokerPeopleTollFlag, that.ifBrokerPeopleTollFlag) &&
                Objects.equals(qdShDiffTime, that.qdShDiffTime) &&
                Objects.equals(groupId, that.groupId) &&
                Objects.equals(groupName, that.groupName) &&
                Objects.equals(hdZcShTime, that.hdZcShTime) &&
                Objects.equals(hdZcShModifyPersonId, that.hdZcShModifyPersonId) &&
                Objects.equals(creditPrice, that.creditPrice) &&
                Objects.equals(ownerAdjustFlag, that.ownerAdjustFlag) &&
                Objects.equals(ownerAdjustType, that.ownerAdjustType) &&
                Objects.equals(ownerAdjustAmt, that.ownerAdjustAmt) &&
                Objects.equals(infoPrice, that.infoPrice) &&
                Objects.equals(ifZntsFlag, that.ifZntsFlag) &&
                Objects.equals(poundLocation, that.poundLocation) &&
                Objects.equals(poundNum, that.poundNum) &&
                Objects.equals(shippingTime, that.shippingTime) &&
                Objects.equals(dzStatus, that.dzStatus) &&
                Objects.equals(dzStatusUpdateTime, that.dzStatusUpdateTime) &&
                Objects.equals(goodPrice, that.goodPrice) &&
                Objects.equals(lossType, that.lossType) &&
                Objects.equals(lossRatio, that.lossRatio) &&
                Objects.equals(lossWeight, that.lossWeight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deliveryId, deliveryNum, publishId, publishNum, transId, transNum, weight, amount, createDate, companyId, startPlate, endPlate, driverId, vehicleId, createPerson, platformId, status, departureLng, departureLat, destinationLng, destinationLat, getOrderAddressLng, getOrderAddressLat, getOrderPlate, departure, destination, getOrderAddress, sender, senderMobile, receiverMobile, receiver, billSender, billSenderMobile, billTaker, billTakerMobile, updateDate, updatePerson, goodType, goodTypeDesc, qty, price, pickupDate, billTime, deliveryTime, finishTime, publishCompanyId, operateType, docuSource, settleWeight, settlePrice, settleAmount, ortherFlag, loadingId, ifDriverJudge, ifFdJudge, verifyCode, fdUserId, ifCanShow, ifFeidan, comfirmPicLocal, comfirmPicRemote, receiptVerifyCode, receiptOperDate, remark, zcSureDate, shSureDate, truckLoadingWeight, takeDeliveryWeight, settleStatus, oilCardNo, oilCardAmount, zfId, zfNum, carryCompanyId, insuranceFlag, insuranceNo, insuranceAmount, comfirmPic1Local, comfirmPic1Remote, comfirmPic2Local, comfirmPic2Remote, priPublishId, ifCyJudge, jsRemark, jsType, oilRatio, payOidId, payOidNum, ifAlreadyPrint, printPerson, dataPrint, ifSend, result, resourceId, failCode, failMessage, jkFinsh, floatType, floatPrice, ifJkpay, ifSendlocation, standardTax, priceTax, ifTaxTransport, vatFlowMasterId, ifUploadReceiptFlag, ifInvoice, dzZcWeight, dzZcTime, zcWeightFrom, brokerPeopleTollType, brokerPeopleTollAmount, brokerPeopleTollRatio, ifBrokerPeopleTollFlag, qdShDiffTime, groupId, groupName, hdZcShTime, hdZcShModifyPersonId, creditPrice, ownerAdjustFlag, ownerAdjustType, ownerAdjustAmt, infoPrice, ifZntsFlag, poundLocation, poundNum, shippingTime, dzStatus, dzStatusUpdateTime, goodPrice, lossType, lossRatio, lossWeight);
    }
    
}
