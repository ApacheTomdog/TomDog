package com.brcc.business.Interface.InterfaceOfCw.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "reinfotocw")

public class ReInfoEntity implements Serializable {

  @Id
  private long cwinterfaceId;
  private long deliveryId;
  private double lng;
  private double lat;
  private String address;
  private java.sql.Timestamp arriveTime;
  private String imageAddress;

  public long getCwinterfaceId() {
    return cwinterfaceId;
  }
  public void setCwinterfaceId(long cwinterfaceId) {
    this.cwinterfaceId = cwinterfaceId;
  }

  public long getDeliveryId() {
    return deliveryId;
  }

  public void setDeliveryId(long deliveryId) {
    this.deliveryId = deliveryId;
  }


  public double getLng() {
    return lng;
  }

  public void setLng(double lng) {
    this.lng = lng;
  }


  public double getLat() {
    return lat;
  }

  public void setLat(double lat) {
    this.lat = lat;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public java.sql.Timestamp getArriveTime() {
    return arriveTime;
  }

  public void setArriveTime(java.sql.Timestamp arriveTime) {
    this.arriveTime = arriveTime;
  }


  public String getImageAddress() {
    return imageAddress;
  }

  public void setImageAddress(String imageAddress) {
    this.imageAddress = imageAddress;
  }

}
