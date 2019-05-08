package com.brcc.business.creditConfig.vo;

/**
 * @Description: 委托方授信操作封装类
 * @Auther: gemaochao
 * @Date:Created in 13:36 2018/11/1
 */
public class CreditConfigModifyVo {

    private String creditConfigId;

    private String modify;

    private Long userId;

    private String userName;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCreditConfigId() {
        return creditConfigId;
    }

    public void setCreditConfigId(String creditConfigId) {
        this.creditConfigId = creditConfigId;
    }

    public String getModify() {
        return modify;
    }

    public void setModify(String modify) {
        this.modify = modify;
    }
}
