package com.brcc.business.payCalcBatch.vo;

import com.esteel.common.vo.BaseQueryVo;

/**
 * 批量运费计算结果
 * @author panyinfang
 *
 */
public class PayCalcBatchQueryVo  extends BaseQueryVo{
	
	private Long batchId;
	private Long publishId;
	private Long transId;
	private Long deliveryId;
	private String calcStatus;
	private String platformId;
	
	public String getPlatformId() {
		return platformId;
	}
	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	public Long getBatchId() {
		return batchId;
	}
	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}
	public Long getPublishId() {
		return publishId;
	}
	public void setPublishId(Long publishId) {
		this.publishId = publishId;
	}
	public Long getTransId() {
		return transId;
	}
	public void setTransId(Long transId) {
		this.transId = transId;
	}
	public Long getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}
	public String getCalcStatus() {
		return calcStatus;
	}
	public void setCalcStatus(String calcStatus) {
		this.calcStatus = calcStatus;
	}
	
	

}
