package com.brcc.business.vatcompanyrecharge.web;

import com.brcc.business.flow.vo.VatflowdetailCompanyNameVo;
import com.brcc.business.vatcapital.entity.VatcapitalmasterEntity;
import com.brcc.business.vatcapital.vo.VatcapitaldetailQueryVo;
import com.brcc.business.vatcompanyRechargeBusiness.entity.VatcompanyRechargeBusinessEntity;
import com.brcc.business.vatcompanyRechargeBusiness.vo.CompanyNameQueryVo;
import com.brcc.business.vatcompanyrecharge.entity.VatcompanyrechargeEntity;
import com.brcc.business.vatcompanyrecharge.service.VatCompanyRechargeService;
import com.brcc.business.vatcompanyrecharge.vo.VatCompanyRechargeQueryVo;
import com.brcc.business.vatcompanyrefund.vo.VatCompanyRefundQueryVo;
import com.esteel.common.controller.WebReturnMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description: 委托方充值申请
 * @Auther: gemaochao
 * @Date:Created in 16:37 2018/11/13
 */
@RequestMapping("/VatCompanyRecharge")
@RestController
public class VatCompanyRechargeController {

    @Autowired
    VatCompanyRechargeService vatCompanyRechargeService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    
    /**
     * @Description  返回委托方充值申请页面信息
     * @Param [vo]
     * @return org.springframework.data.domain.Page<com.brcc.business.vatcompanyrecharge.entity.VatcompanyrechargeEntity>
     **/
    @RequestMapping("/query")
    Page<VatcompanyrechargeEntity> query(@RequestBody VatCompanyRechargeQueryVo vo){
        logger.info("query vat company recharge，clientId:{},platformId:{}",vo.getClientId(),vo.getPlatformId());
        Assert.notNull(vo.getPlatformId(),"参数platformId不能为空！");
        Assert.notNull(vo.getClientId(),"参数clientId不能为空！");
        return vatCompanyRechargeService.queryRecharge(vo);
    }
    
    /**
     * @Description  查询if_parts 公司是否是业务分离
     * @Param [vo]
     * @return java.lang.String
     **/
    @RequestMapping("/verifyIfParts")
    String verifyIfParts(@RequestBody VatCompanyRechargeQueryVo vo){
        logger.info("verify if parts,clientId:{}",vo.getClientId());
        Assert.notNull(vo.getPlatformId(),"参数platformId不能为空！");
        Assert.notNull(vo.getClientId(),"参数clientId不能为空！");
        return vatCompanyRechargeService.verifyIfParts(vo.getPlatformId(),vo.getClientId());
    }
    
    /**
     * @Description  返回非业务分离时添加充值承运公司信息
     * @Param [vo]
     * @return java.util.List<com.brcc.business.vatflow.vo.VatflowdetailQueryVo>
     **/
    @RequestMapping("/queryNameN")
    List<VatflowdetailCompanyNameVo> queryCompanyNameN(@RequestBody VatCompanyRechargeQueryVo vo){
        logger.info("query company name when if_parts is N,clientId:{}",vo.getClientId());
        Assert.notNull(vo.getPlatformId(),"参数platformId不能为空！");
        Assert.notNull(vo.getClientId(),"参数clientId不能为空！");
        return vatCompanyRechargeService.queryCompanyNameN(vo);
    }
    
    
    /**
     * @Description  返回业务分离时添加充值承运公司信息
     * @Param [vo]
     * @return java.util.List<com.brcc.business.vatcompanyRechargeBusiness.vo.CompanyNameQueryVo>
     **/
    @RequestMapping("/queryNameY")
    List<CompanyNameQueryVo> queryCompanyNameY(@RequestBody VatCompanyRechargeQueryVo vo){
        logger.info("query company name when if_parts is Y,clientId:{}",vo.getClientId());
        Assert.notNull(vo.getPlatformId(),"参数platformId不能为空！");
        Assert.notNull(vo.getClientId(),"参数clientId不能为空！");
        return vatCompanyRechargeService.queryCompanyNameY(vo.getClientId(),vo.getPlatformId());
    }
    
    /**
     * @Description  保存新增充值信息
     * @Param [entity]
     * @return com.brcc.business.vatcompanyrecharge.entity.VatcompanyrechargeEntity
     **/
    @RequestMapping("/addSave")
    VatcompanyrechargeEntity addSave(@RequestBody VatcompanyrechargeEntity entity){
        logger.info("save add company recharge ,clientName:{},carryName:{},amount:{}",entity.getClientName(),entity.getCarryName(),entity.getBankAmount());
        Assert.notNull(entity.getPlatformId(),"参数platformId不能为空！");
        Assert.notNull(entity.getClientId(),"参数clientId不能为空！");
        Assert.notNull(entity.getCarryId(),"参数carryId不能为空！");
        Assert.notNull(entity.getCreatePersonId(),"参数personId不能为空！");
        Assert.notNull(entity.getBankAmount(),"参数amount不能为空！");
        return vatCompanyRechargeService.addRechargeSave(entity);
    }
    
    
    /**
     * @Description  更新companyRechargeBusiness 表信息
     * @Param [entity]
     * @return void
     **/
    @RequestMapping("/flushBusiness")
    VatcompanyRechargeBusinessEntity flushBusiness(@RequestBody VatcompanyrechargeEntity entity){
        logger.info("flush company recharge business,businessNum:{},amount:{}",entity.getBusinessNum(),entity.getBankAmount());
        Assert.notNull(entity.getPlatformId(),"参数platformId不能为空！");
        Assert.notNull(entity.getBusinessNum(),"参数businessNum不能为空！");
        Assert.notNull(entity.getBankAmount(),"参数amount不能为空！");
        return vatCompanyRechargeService.flushBusiness(entity);
    }
    
    /**
     * @Description  Excel导出
     * @Param [vo]
     * @return java.util.List<com.brcc.business.vatcompanyrecharge.entity.VatcompanyrechargeEntity>
     **/
    @RequestMapping("/excel")
    List<VatCompanyRechargeQueryVo> excel(@RequestBody VatCompanyRechargeQueryVo vo){
        logger.info("company recharge list for excel");
        Assert.notNull(vo.getPlatformId(),"参数platformId不能为空！");
        Assert.notNull(vo.getClientId(),"参数clientId不能为空！");
        return vatCompanyRechargeService.queryRechargeForExcel(vo);
    }

    
    /**
     * @Description  返回承运方充值审核页面数据
     * @Param [vo]
     * @return org.springframework.data.domain.Page<com.brcc.business.vatcompanyrecharge.entity.VatcompanyrechargeEntity>
     **/
    @RequestMapping("/queryAudit")
    Page<VatcompanyrechargeEntity> queryAuditRecharge(@RequestBody VatCompanyRechargeQueryVo vo){
        logger.info("query audit recharge,carryId:{},platformId:{}",vo.getCarryId(),vo.getPlatformId());
        Assert.notNull(vo.getCarryId(),"参数carryId不能为空！");
        Assert.notNull(vo.getPlatformId(),"参数platformId不能为空！");
        return vatCompanyRechargeService.queryAuditRecharge(vo);
    }

    
    /**
     * @Description  返回充值总金额
     * @Param [vo]
     * @return com.brcc.business.vatcompanyrecharge.vo.VatCompanyRechargeQueryVo
     **/
    @RequestMapping("/totalInAmount")
    VatCompanyRechargeQueryVo queryTotalInAmount(@RequestBody VatCompanyRechargeQueryVo vo){
        logger.info("query total in amount carryId:{},platformId:{}",vo.getCarryId(),vo.getPlatformId());
        Assert.notNull(vo.getCarryId(),"参数carryId不能为空！");
        Assert.notNull(vo.getPlatformId(),"参数platformId不能为空！");
        return vatCompanyRechargeService.queryTotalInAmount(vo);
    }
    
    /**
     * @Description  承运方充值审核操作
     * @Param [entity]
     * @return com.brcc.business.vatcompanyrecharge.entity.VatcompanyrechargeEntity
     **/
    @RequestMapping("/auditRecharge")
    VatcompanyrechargeEntity auditRecharge(@RequestBody VatcompanyrechargeEntity entity){
        logger.info("audit recharge,id:{},audit status:{}",entity.getVatCompanyRechargeId(),entity.getStatus());
        Assert.notNull(entity.getVatCompanyRechargeId(),"参数id不能为空！");
        Assert.notNull(entity.getStatus(),"参数status不能为空！");
        Assert.notNull(entity.getAuditPersonId(),"参数auditPersonId不能为空！");
        Assert.notNull(entity.getAuditPersonName(),"参数auditPersonName不能为空！");
        Assert.notNull(entity.getAuditDate(),"参数auditDate不能为空！");
        return vatCompanyRechargeService.auditRecharge(entity);
    }

    /**
     * @Description
     * @Param [entity]
     * @return com.brcc.business.vatcompanyrecharge.entity.VatcompanyrechargeEntity
     **/
    @RequestMapping("/strikeBalance")
    WebReturnMessage strikeBalance(@RequestBody VatcompanyrechargeEntity entity){
        logger.info("audit recharge,id:{},audit status:{}",entity.getVatCompanyRechargeId(),entity.getStatus());
        Assert.notNull(entity.getVatCompanyRechargeId(),"参数id不能为空！");
        Assert.notNull(entity.getStatus(),"参数status不能为空！");
        Assert.notNull(entity.getCreatePersonId(),"参数auditPersonId不能为空！");
        Assert.notNull(entity.getCreatePersonName(),"参数auditPersonName不能为空！");
        Assert.notNull(entity.getCreateDate(),"参数auditDate不能为空！");
        try {
            vatCompanyRechargeService.strikeBalance(entity);
            return new WebReturnMessage(true,"操作成功!");
        }catch (Exception e){
            logger.error("strikeBalance by vatCompanyRechargeId:{}  error,message:{}", e.getMessage());
            return new WebReturnMessage(false, e.getMessage());
        }
    }

    /**
     * @Description  返回充值审核单信息
     * @Param [vo]
     * @return com.brcc.business.vatcompanyrecharge.entity.VatcompanyrechargeEntity
     **/
    @RequestMapping("/queryDetail")
    VatcompanyrechargeEntity queryForDetail(@RequestBody VatCompanyRechargeQueryVo vo){
        logger.info("query for detail,id:{}",vo.getVatCompanyRechargeId());
        Assert.notNull(vo.getVatCompanyRechargeId(),"参数id不能为空！");
        Assert.notNull(vo.getPlatformId(),"参数platformId不能为空！");
        return vatCompanyRechargeService.queryForDetail(vo);
    }
    
    
    /**
     * @Description  返回excel导出数据
     * @Param [vo]
     * @return java.util.List<com.brcc.business.vatcompanyrecharge.entity.VatcompanyrechargeEntity>
     **/
    @RequestMapping("/queryExcel")
    List<VatCompanyRechargeQueryVo> queryForExcel(@RequestBody VatCompanyRechargeQueryVo vo){
        logger.info("query for excel");
        Assert.notNull(vo.getCarryId(),"参数carryId不能为空！");
        Assert.notNull(vo.getPlatformId(),"参数platformId不能为空！");
        return vatCompanyRechargeService.queryForExcel(vo);
    }


    /**
     * @Description  返回资金流水详情页面数据
     * @Param [vo]
     * @return org.springframework.data.domain.Page<com.brcc.business.vatcapital.vo.VatcapitaldetailQueryVo>
     **/
    @RequestMapping("/queryMasterDetail")
    Page<VatcapitaldetailQueryVo> queryMasterForDetail(@RequestBody VatcapitaldetailQueryVo vo){
        logger.info("query master detail,carryId:{},clientId:{},platformId:{}",vo.getCarryId(),vo.getClientId(),vo.getPlatformId());
        Assert.notNull(vo.getClientId(),"参数clientId不能为空！");
        Assert.notNull(vo.getPlatformId(),"参数platformId不能为空！");
        Assert.notNull(vo.getCarryId(),"参数carryId不能为空！");
        return vatCompanyRechargeService.queryMasterForDetail(vo);
    }

    /**
     * @Description  返回承运方资金管理充值总金额
     * @Param [vo]
     * @return java.util.List<com.brcc.business.vatcapital.entity.VatcapitalmasterEntity>
     **/
    @RequestMapping("/queryMasterTotalAmount")
    BigDecimal queryMasterTotalInAmount(@RequestBody VatCompanyRefundQueryVo vo){
        logger.info("query master total amount,carryId:{},platformId:{}",vo.getCarryId(),vo.getPlatformId());
        Assert.notNull(vo.getPlatformId(),"参数platformId不能为空！");
        Assert.notNull(vo.getCarryId(),"参数carryId不能为空！");
        Assert.notNull(vatCompanyRechargeService.queryMasterTotalInAmount(vo),"数据出错，请联系管理员");
        return vatCompanyRechargeService.queryMasterTotalInAmount(vo).getTotalInAmount();
    }


    /**
     * @Description  返回承运方资金管理页面数据
     * @Param [vo]
     * @return org.springframework.data.domain.Page<com.brcc.business.vatcapital.entity.VatcapitalmasterEntity>
     **/
    @RequestMapping("/queryMaster")
    Page<VatcapitalmasterEntity> queryMasterForCarry(@RequestBody VatCompanyRefundQueryVo vo){
        logger.info("query master for client,carryId:{},platformId:{}",vo.getCarryId(),vo.getPlatformId());
        Assert.notNull(vo.getCarryId(),"参数carryId不能为空！");
        Assert.notNull(vo.getPlatformId(),"参数platformId不能为空！");
        return vatCompanyRechargeService.queryMasterForCarry(vo);
    }

    /**
     * @Description  返回承运方资金管理资金流水详情excel导出数据
     * @Param [vo]
     * @return java.util.List<com.brcc.business.vatcompanyrecharge.entity.VatcompanyrechargeEntity>
     **/
    @RequestMapping("/master/excel")
    List<VatcapitaldetailQueryVo> queryForExcel(@RequestBody VatcapitaldetailQueryVo vo){
        logger.info("query master detail for excel");
        Assert.notNull(vo.getClientId(),"参数clientId不能为空！");
        Assert.notNull(vo.getPlatformId(),"参数platformId不能为空！");
        Assert.notNull(vo.getCarryId(),"参数carryId不能为空！");
        return vatCompanyRechargeService.excelForMaster(vo);
    }
    /**
     * @Description  返回委托方资金管理页面数据
     * @Param [vo]
     * @return org.springframework.data.domain.Page<com.brcc.business.vatcapital.entity.VatcapitalmasterEntity>
     **/
    @RequestMapping("/queryForClient")
    Page<VatcapitalmasterEntity> queryForClient(@RequestBody VatCompanyRefundQueryVo vo){
        logger.info("query master for client,platformId:{},clientId:{}",vo.getPlatformId(),vo.getClientId());
        Assert.notNull(vo.getClientId(),"参数clientId不能为空！");
        Assert.notNull(vo.getPlatformId(),"参数platformId不能为空！");
        return vatCompanyRechargeService.queryMasterForClient(vo);
    }

    /**
     * 作废未审核状态的充值申请
     * @param vatCompanyRechargeId
     * @return
     */
    @RequestMapping("/cancel")
    WebReturnMessage cancelRecharge(@RequestBody Long vatCompanyRechargeId){
        logger.info("cancel recharge,vatCompanyRechargeId:{}",vatCompanyRechargeId);
        return vatCompanyRechargeService.cancel(vatCompanyRechargeId);
    }


}
