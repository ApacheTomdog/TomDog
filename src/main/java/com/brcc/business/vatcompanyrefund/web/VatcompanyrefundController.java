package com.brcc.business.vatcompanyrefund.web;

import com.brcc.business.vatcapital.entity.VatcapitalmasterEntity;
import com.brcc.business.vatcompanyrefund.entity.VatcompanyrefundEntity;
import com.brcc.business.vatcompanyrefund.servcie.VatcompanyrefundService;
import com.brcc.business.vatcompanyrefund.vo.VatCompanyRefundQueryVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 委托方退款审核
 * @Auther: gemaochao
 * @Date:Created in 10:11 2018/11/16
 */
@RestController
@RequestMapping("/Vatcompanyrefund")
public class VatcompanyrefundController {


    @Autowired
    VatcompanyrefundService vatcompanyrefundService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    
    /**
     * @Description  返回委托方退款审核页面数据
     * @Param [vo]
     * @return org.springframework.data.domain.Page<com.brcc.business.vatcompanyrefund.entity.VatcompanyrefundEntity>
     **/
    @RequestMapping("/query")
    Page<VatcompanyrefundEntity> queryRefund(@RequestBody VatCompanyRefundQueryVo vo){
        logger.info("query vat company refund ,platformId:{},clientId:{}",vo.getPlatformId(),vo.getClientId());
        Assert.notNull(vo.getPlatformId(),"参数platformId不能为空！");
        Assert.notNull(vo.getClientId(),"参数clientId不能为空！");
        return vatcompanyrefundService.queryRefund(vo);
    }

    
    /**
     * @Description  委托方退款审核操作
     * @Param [vo]
     * @return com.brcc.business.vatcompanyrefund.entity.VatcompanyrefundEntity
     **/
    @RequestMapping("/audit")
    VatcompanyrefundEntity audit(@RequestBody VatCompanyRefundQueryVo vo){
        logger.info("refundId:{},auditPerson:{},auditPersonId:{},audit status:{}",vo.getVatCompanyRefundId(),vo.getAuditPersonName(),vo.getAuditPersonId(),vo.getRefundStatus());
        Assert.notNull(vo.getVatCompanyRefundId(),"参数refundId不能为空！");
        Assert.notNull(vo.getRefundStatus(),"参数refundStatus不能为空！");
        Assert.notNull(vo.getAuditDate(),"参数auditDate不能为空！");
        Assert.notNull(vo.getAuditPersonId(),"参数auditPersonId不能为空！");
        return vatcompanyrefundService.audit(vo);
    }

    /**
     * @Description  返回承运方新增退款委托公司选项数据
     * @Param [vo]
     * @return java.util.List<com.brcc.business.vatcapital.entity.VatcapitalmasterEntity>
     **/
    @RequestMapping("/queryCompanyName")
    List<VatcapitalmasterEntity> queryCompanyName(@RequestBody VatCompanyRefundQueryVo vo){
        logger.info("query company name for add new refund,carryId:{},platformId:{}",vo.getCarryId(),vo.getPlatformId());
        Assert.notNull(vo.getCarryId(),"参数carryId不能为空！");
        Assert.notNull(vo.getPlatformId(),"参数platformId不能为空！");
        return vatcompanyrefundService.queryCompanyName(vo);
    }

    /**
     * @Description  返回承运方退款页面数据
     * @Param [vo]
     * @return org.springframework.data.domain.Page<com.brcc.business.vatcompanyrefund.entity.VatcompanyrefundEntity>
     **/
    @RequestMapping("/queryForClient")
    Page<VatcompanyrefundEntity> queryForClient(@RequestBody VatCompanyRefundQueryVo vo){
        logger.info("query refund for client,carryId:{},platformId:{}",vo.getCarryId(),vo.getPlatformId());
        Assert.notNull(vo.getCarryId(),"参数carryId不能为空！");
        Assert.notNull(vo.getPlatformId(),"参数platformId不能为空！");
        return vatcompanyrefundService.queryForClient(vo);
    }
    
    /**
     * @Description  保存新增退款信息
     * @Param [entity]
     * @return com.brcc.business.vatcompanyrefund.entity.VatcompanyrefundEntity
     **/
    @RequestMapping("/addRefundSave")
    VatcompanyrefundEntity addRefundSave(@RequestBody VatcompanyrefundEntity entity){
        logger.info("add refund save,carryId:{},clientId:{},createPersonId:{},amount:{}",entity.getCarryId(),entity.getClientId(),entity
        .getCreatePersonId(),entity.getRefundAmount());
        Assert.notNull(entity.getPlatformId(),"参数platformId不能为空！");
        Assert.notNull(entity.getCarryId(),"参数carryId不能为空！");
        Assert.notNull(entity.getClientId(),"参数clientId不能为空！");
        Assert.notNull(entity.getRefundAmount(),"参数amount不能为空！");
        Assert.notNull(entity.getCreatePersonId(),"参数createPersonId不能为空！");
        Assert.notNull(entity.getRefundStatus(),"参数status不能为空！");
        return vatcompanyrefundService.addRefundSave(entity);
    }
    
    /**
     * 查询资金帐信息(根据委托clientId和承运carrId)
     * @param vo
     * @return VatcapitalmasterEntity
     */
    @RequestMapping("/queryCompanyCapital")
    VatcapitalmasterEntity queryCompanyCapital(@RequestBody VatCompanyRefundQueryVo vo){
        logger.info("query company name for add new refund,carryId:{},platformId:{}",vo.getCarryId(),vo.getPlatformId());
        Assert.notNull(vo.getCarryId(),"参数carryId不能为空！");
        Assert.notNull(vo.getClientId(),"参数从lientId不能为空！");
        Assert.notNull(vo.getPlatformId(),"参数platformId不能为空！");
        return vatcompanyrefundService.queryCompanyCapital(vo);
    }
}
