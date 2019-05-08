package com.brcc.business.vatcompanyRechargeBusiness.vo;

import com.esteel.common.vo.BaseQueryVo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description:
 * @Auther: gemaochao
 * @Date:Created in 11:12 2018/11/14
 */
public class VatcompanyRechargeBusinessQueryVo extends BaseQueryVo {

    private Long id;
    private String businessNum;
    private String platformId;
    private Long clientId;
    private String clientName;
    private Long carryId;
    private String carryName;
    private String status;
    private BigDecimal applyAmount;
    private BigDecimal useAmount;
    private BigDecimal surplusAmount;
    private BigDecimal rechargeAmount;
    private Long createPersonId;
    private String createPersonName;
    private Date createDate;
    private String auditRemark;
    private Long auditPersonId;
    private String auditPersonName;
    private Date auditDate;
    private Long modifyPersonId;
    private Date modifyDate;
    private String modifyPersonName;
    private String modifyRemark;
    private String createRemark;
}
