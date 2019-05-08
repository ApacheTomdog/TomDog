package com.brcc.business.transorder.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2018-11-25 14:30
 */
@Entity
@Table(name = "shortmessage")
public class ShortmessageEntity {

    private Long id;
    private String sender;
    private String receiver;
    private String message;
    private Date sendTime;
    private Date createTime;
    private String platformId;
    private String success;
    private String sendType;
    private BigDecimal sendNum;
    private String messageType;
    private Long mesDocuId;
    private String mesType;
    private String mesMemo;
    private String ip;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "sender", nullable = true, length = 20)
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Basic
    @Column(name = "receiver", nullable = true, length = 100)
    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    @Basic
    @Column(name = "message", nullable = true, length = 200)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Basic
    @Column(name = "send_time", nullable = true)
    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    @Basic
    @Column(name = "create_time", nullable = true)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "platform_id", nullable = true, length = 20)
    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    @Basic
    @Column(name = "success", nullable = true, length = 20)
    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    @Basic
    @Column(name = "send_type", nullable = true, length = 2)
    public String getSendType() {
        return sendType;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType;
    }

    @Basic
    @Column(name = "send_num", nullable = true, precision = 0)
    public BigDecimal getSendNum() {
        return sendNum;
    }

    public void setSendNum(BigDecimal sendNum) {
        this.sendNum = sendNum;
    }

    @Basic
    @Column(name = "message_type", nullable = true, length = 20)
    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    @Basic
    @Column(name = "mes_docu_id", nullable = true)
    public Long getMesDocuId() {
        return mesDocuId;
    }

    public void setMesDocuId(Long mesDocuId) {
        this.mesDocuId = mesDocuId;
    }

    @Basic
    @Column(name = "mes_type", nullable = true, length = 2)
    public String getMesType() {
        return mesType;
    }

    public void setMesType(String mesType) {
        this.mesType = mesType;
    }

    @Basic
    @Column(name = "mes_memo", nullable = true, length = 100)
    public String getMesMemo() {
        return mesMemo;
    }

    public void setMesMemo(String mesMemo) {
        this.mesMemo = mesMemo;
    }

    @Basic
    @Column(name = "ip", nullable = true, length = 20)
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShortmessageEntity that = (ShortmessageEntity) o;
        return id == that.id &&
                Objects.equals(sender, that.sender) &&
                Objects.equals(receiver, that.receiver) &&
                Objects.equals(message, that.message) &&
                Objects.equals(sendTime, that.sendTime) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(platformId, that.platformId) &&
                Objects.equals(success, that.success) &&
                Objects.equals(sendType, that.sendType) &&
                Objects.equals(sendNum, that.sendNum) &&
                Objects.equals(messageType, that.messageType) &&
                Objects.equals(mesDocuId, that.mesDocuId) &&
                Objects.equals(mesType, that.mesType) &&
                Objects.equals(mesMemo, that.mesMemo) &&
                Objects.equals(ip, that.ip);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, sender, receiver, message, sendTime, createTime, platformId, success, sendType, sendNum, messageType, mesDocuId, mesType, mesMemo, ip);
    }
}