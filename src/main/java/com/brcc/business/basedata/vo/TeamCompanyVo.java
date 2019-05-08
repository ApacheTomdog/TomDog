package com.brcc.business.basedata.vo;

import com.brcc.business.basedata.entity.TeamCompanyEntity;

/**
 * 描述: 承运组查询数据返回封装类
 *
 * @author yushaohua
 * @create 2018-11-23 15:56
 */
public class TeamCompanyVo extends TeamCompanyEntity {

	private static final long serialVersionUID = 1L;

	private Long companyId;

    private Long driverId;

    private String vehicleId;

    private String companyName;

    private String driverName;
    
    private String driverMobile;

    private Long userId;

    private Long clientId;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverMobile() {
        return driverMobile;
    }

    public void setDriverMobile(String driverMobile) {
        this.driverMobile = driverMobile;
    }

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
    
}