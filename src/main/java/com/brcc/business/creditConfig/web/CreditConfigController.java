package com.brcc.business.creditConfig.web;

import com.brcc.business.creditAmountAdjust.entity.CreditAmountAdjustEntity;
import com.brcc.business.creditConfig.entity.CreditConfigEntity;
import com.brcc.business.creditConfig.service.CreditConfigService;
import com.brcc.business.creditConfig.vo.CreditConfigAddCompanyVo;
import com.brcc.business.creditConfig.vo.CreditConfigModifyVo;
import com.brcc.business.creditConfig.vo.CreditConfigQueryVo;
import com.esteel.common.controller.WebReturnMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 委托方授信管理
 * @Auther: gemaochao
 * @Date:Created in 11:35 2018/10/31
 */

@RestController
@RequestMapping("/creditConfig")
public class CreditConfigController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CreditConfigService creditConfigService;
    
    /**
     * @Description  返回委托方授信列表
     * @Param [creditConfigQueryVo]
     * @return org.springframework.data.domain.Page<com.brcc.business.creditConfig.entity.CreditConfigEntity>
     **/
    @ResponseBody
    @RequestMapping(value = "/queryCreditConfig",method = RequestMethod.POST)
    public Page<CreditConfigEntity> queryCreditConfig(@RequestBody CreditConfigQueryVo creditConfigQueryVo){

        logger.info("query credit config,userID:{},companyID:{},plantFormID:{}",creditConfigQueryVo.getUserId(),creditConfigQueryVo.getCompanyId(),creditConfigQueryVo.getPlatformId());

        Assert.isTrue(creditConfigQueryVo.getCompanyId() != null,"传递companyId参数不能为空！");
        Assert.isTrue(creditConfigQueryVo.getPlatformId() != null,"传递platFormId参数不能为空！");
        Assert.isTrue(creditConfigQueryVo.getUserId() != null,"传递userId参数不能为空！");
        return creditConfigService.queryCreditConfig(creditConfigQueryVo);
    }


    /**
     * @Description  根据id返回委托方授信信息
     * @Param [creditConfigQueryVo]
     * @return com.brcc.business.creditConfig.entity.CreditConfigEntity
     **/
    @RequestMapping(value = "/findById",method = RequestMethod.POST)
    @ResponseBody
    public CreditConfigEntity findById(@RequestBody CreditConfigQueryVo creditConfigQueryVo){
        logger.info("find credit config by credit config id:{}"+creditConfigQueryVo.getCreditConfigId());
        Assert.isTrue(creditConfigQueryVo.getCreditConfigId() != null,"参数creditConfigId不能为空!");
        return creditConfigService.findById(creditConfigQueryVo.getCreditConfigId());
    }

    /**
     * @Description 保存委托方授信修改信息
     * @Param [creditConfigEntity]
     * @return com.brcc.business.creditConfig.entity.CreditConfigEntity
     **/
    @RequestMapping(value = "/saveConfigEdit",method = RequestMethod.POST)
    @ResponseBody
    public CreditConfigEntity saveConfigEdit(@RequestBody CreditConfigEntity creditConfigEntity){
        logger.info("save edit config,configId:{},amount:{},creditDuration:{}",creditConfigEntity.getCreditConfigId(),creditConfigEntity.getCreditAmount(),creditConfigEntity.getCreditDuration());
        Assert.isTrue(creditConfigEntity.getCreditConfigId() != null,"参数configId 不能为空！");
        Assert.isTrue(creditConfigEntity.getCreditAmount() != null,"参数amount 不能为空！");
        Assert.isTrue(creditConfigEntity.getCreditDuration() != null,"参数duration 不能为空！");

        return creditConfigService.saveConfigEdit(creditConfigEntity);
    }


    /**
     * @Description   委托方授信管理操作（启用/停用）、（发单启用/停用）
     * @Param [creditConfigModifyVo]
     * @return com.esteel.common.controller.WebReturnMessage
     **/
    @RequestMapping("/modify")
    @ResponseBody
    public WebReturnMessage creditConfigModify(@RequestBody CreditConfigModifyVo creditConfigModifyVo){
        logger.info("credit config id:{},modify:{}",creditConfigModifyVo.getCreditConfigId(),creditConfigModifyVo.getModify());
        Assert.isTrue(creditConfigModifyVo.getModify() != null,"参数modify不能为空！");
        Assert.isTrue(creditConfigModifyVo.getUserId() != null,"参数userId不能为空！");
        Assert.isTrue(creditConfigModifyVo.getUserName() != null,"参数userName不能为空！");
        if (("creditStatus").equals(creditConfigModifyVo.getModify())){
            creditConfigService.changeCreditStatus(creditConfigModifyVo);
        }else if (("fdStatus").equals(creditConfigModifyVo.getModify())){
            creditConfigService.changeCreditFdStatus(creditConfigModifyVo);
        }
        return WebReturnMessage.sucess;
    }


    /**
     * @Description  返回委托方新增授信公司数据
     * @Param [creditConfigQueryVo]
     * @return org.springframework.data.domain.Page<com.brcc.business.creditConfig.vo.CreditConfigAddCompanyVo>
     **/
    @RequestMapping("/addCredit")
    @ResponseBody
    public Page<CreditConfigAddCompanyVo> creditAddCompany(@RequestBody CreditConfigQueryVo creditConfigQueryVo){
        logger.info("return credit config add company name ");
        Assert.isTrue(creditConfigQueryVo.getPlatformId() != null,"参数platformId不能为空！");
        Assert.isTrue(creditConfigQueryVo.getCompanyId() != null,"参数companyId不能为空！");
        return creditConfigService.creditAddCompany(creditConfigQueryVo);
    }

    /**
     * @Description  返回委托方授信明细
     * @Param [creditConfigQueryVo]
     * @return org.springframework.data.domain.Page<com.brcc.business.creditAmountAdjust.entity.CreditAmountAdjustEntity>
     **/
    @RequestMapping("/configDetail")
    @ResponseBody
    public Page<CreditAmountAdjustEntity> configDetail(@RequestBody CreditConfigQueryVo creditConfigQueryVo){
        logger.info("credit config detail platformId:{},configId:{},companyId:{}",creditConfigQueryVo.getPlatformId(),creditConfigQueryVo.getCreditConfigId(),creditConfigQueryVo.getCompanyId());
        Assert.isTrue(creditConfigQueryVo.getCreditPlatCompanyId() != null,"PlatCompanyId 不能为空！");
        Assert.isTrue(creditConfigQueryVo.getPlatformId() != null,"platformId 不能为空！");
        Assert.isTrue(creditConfigQueryVo.getCreditConfigId() != null,"configId 不能为空！");
        return creditConfigService.findCreditAmountAdjust(creditConfigQueryVo);
    }
    
    /**
     * @Description  验证指定companyId 是否存在有效授信信息
     * @Param [creditConfigQueryVo]
     * @return boolean
     **/
    @RequestMapping("/companyId")
    @ResponseBody
    public boolean findByCompanyId(@RequestBody CreditConfigQueryVo creditConfigQueryVo){
        logger.info(" credit config if exits,companyId:{}",creditConfigQueryVo.getPublishCompanyId());
        Assert.isTrue(creditConfigQueryVo.getPublishCompanyId() != null,"参数publishCompanyId不能为空");
        return creditConfigService.exitConfig(creditConfigQueryVo.getPublishCompanyId());
    }

   /**
    * @Description  保存新增授信信息
    * @Param [creditConfigEntity]
    * @return com.brcc.business.creditConfig.entity.CreditConfigEntity
    **/
    @RequestMapping("/addConfigSave")
    @ResponseBody
    public CreditConfigEntity addConfigSave(@RequestBody CreditConfigEntity creditConfigEntity){
        logger.info("add credit config save,companyId:{},companyName:{}",creditConfigEntity.getPublishCompanyId(),creditConfigEntity.getPublishCompanyName());
        Assert.isTrue(creditConfigEntity.getPublishCompanyId() != null,"参数companyId不能为空！");
        return creditConfigService.addConfigSave(creditConfigEntity);
    }
    

    @RequestMapping(value = "/findByPublishCompanyIdAndCreditStatus",method = RequestMethod.POST)
    @ResponseBody
    public CreditConfigEntity findByPublishCompanyIdAndCreditStatus(@RequestBody CreditConfigQueryVo creditConfigQueryVo){
    	
        logger.info("findByPublishCompanyIdAndCreditStatus" + creditConfigQueryVo.toString());
        
        Assert.isTrue(creditConfigQueryVo.getPublishCompanyId() != null,"授信公司不能为空!");
        
        return creditConfigService.queryByPublishCompanyIdAndCreditStatus(creditConfigQueryVo.getPublishCompanyId(), "90");
    }

    /**
     * 
     * @description:
     * @author:陈利
     * @date:2018年11月9日
     * @param creditConfigQueryVo
     * @return
     */
    @RequestMapping("/findCaaCompany")
    @ResponseBody
    public Page<CreditConfigAddCompanyVo> findCaaCompany(@RequestBody CreditConfigQueryVo creditConfigQueryVo){
        
    	logger.info("return credit config add company name ");
        
        return creditConfigService.queryAddAdjustPriceCompanyName(creditConfigQueryVo);
    }
}
