package com.brcc.business.weightUpload.vo;

import com.esteel.common.vo.BaseQueryVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * 描述:
 * 装卸货重量查询封装类
 *
 * @author yushaohua
 * @create 2018-11-28 16:20
 */
public class WeightUploadSearchVo extends BaseQueryVo {

    private Long publishCompanyId;

    private Long batchId;

    private Long deliveryId;

    private String status;

    private Date rqStart;

    private Date rqEnd;

    private String platformId;

    private Long companyId;

    private Date toDay;

    private String fileContent;

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    public Date getToDay() {
        return toDay;
    }

    public void setToDay(Date toDay) {
        this.toDay = toDay;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

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

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Long getPublishCompanyId() {
        return publishCompanyId;
    }

    public void setPublishCompanyId(Long publishCompanyId) {
        this.publishCompanyId = publishCompanyId;
    }
}