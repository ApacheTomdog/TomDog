package com.brcc.business.creditRepay.web;

import com.brcc.business.company.entity.CompanyEntity;
import com.brcc.business.creditRepay.entity.CreditRepayEntity;
import com.brcc.business.creditRepay.service.CreditRepayService;
import com.brcc.business.creditRepay.vo.CreditRepaySearchQueryVo;
import com.brcc.business.creditRepay.vo.RepayCompanyVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Description: 授信还款
 * @Auther: gemaochao
 * @Date:Created in 16:47 2018/11/7
 */
@RestController
@RequestMapping("/creditRepay")
public class CreditRepayController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CreditRepayService creditRepayService;
    
    
    /**
     * @Description  返回授信还款查询页面数据
     * @Param [creditRepaySearchQueryVo]
     * @return org.springframework.data.domain.Page<com.brcc.business.creditRepay.entity.CreditRepayEntity>
     **/
    @RequestMapping(value = "/queryRepay",method = RequestMethod.POST)
    @ResponseBody
    Page<CreditRepayEntity> queryRepay(@RequestBody CreditRepaySearchQueryVo creditRepaySearchQueryVo){
        logger.info("query credit repay page ,platFormId:{},companyId:{}",creditRepaySearchQueryVo.getPlatformId(),creditRepaySearchQueryVo.getCreditCompanyId());
        Assert.notNull(creditRepaySearchQueryVo.getPlatformId(),"参数platFormId不能为空！");
        Assert.notNull(creditRepaySearchQueryVo.getCreditCompanyId(),"参数creditCompanyId不能为空！");
        return creditRepayService.queryRepay(creditRepaySearchQueryVo);
    }


    /**
     * @Description  返回授信还款审核页面数据
     * @Param [creditRepaySearchQueryVo]
     * @return org.springframework.data.domain.Page<com.brcc.business.creditRepay.entity.CreditRepayEntity>
     **/
    @RequestMapping(value = "/queryRepayAudit",method = RequestMethod.POST)
    @ResponseBody
    Page<CreditRepayEntity> queryRepayAudit(@RequestBody CreditRepaySearchQueryVo creditRepaySearchQueryVo){
        logger.info("query credit repay page ,platFormId:{},companyId:{}",creditRepaySearchQueryVo.getPlatformId(),creditRepaySearchQueryVo.getCreditCompanyId());
        Assert.notNull(creditRepaySearchQueryVo.getPlatformId(),"参数platFormId不能为空！");
        Assert.notNull(creditRepaySearchQueryVo.getCreditCompanyId(),"参数creditCompanyId不能为空！");
        return creditRepayService.queryRepayAudit(creditRepaySearchQueryVo);
    }

    /**
     * @Description  返回授信还款公司选项数据
     * @Param [creditRepaySearchQueryVo]
     * @return java.util.List<com.brcc.business.creditRepay.vo.RepayCompanyVo>
     **/
    @RequestMapping(value = "/repayCompany",method = RequestMethod.POST)
    @ResponseBody
    List<RepayCompanyVo> repayCompany(@RequestBody CreditRepaySearchQueryVo creditRepaySearchQueryVo){
        logger.info("return add repay company name");
        Assert.notNull(creditRepaySearchQueryVo.getPlatformId(),"参数platFormId不能为空！");
        Assert.notNull(creditRepaySearchQueryVo.getCreditCompanyId(),"参数creditCompanyId不能为空！");
        return creditRepayService.queryRepayCompany(creditRepaySearchQueryVo);
    }


    /**
     * @Description  改变指定repayId授信还款信息状态
     * @Param [creditRepaySearchQueryVo]
     * @return com.brcc.business.creditRepay.entity.CreditRepayEntity
     **/
    @RequestMapping(value = "/changeStatus",method = RequestMethod.POST)
    @ResponseBody
    CreditRepayEntity changeStatus(@RequestBody CreditRepaySearchQueryVo creditRepaySearchQueryVo){
        logger.info("change repay status,repayId:{},status:{}",creditRepaySearchQueryVo.getCreditRepayId(),creditRepaySearchQueryVo.getCreditRepayStatus());
        Assert.notNull(creditRepaySearchQueryVo.getCreditRepayId(),"参数repayId不能为空！");
        Assert.notNull(creditRepaySearchQueryVo.getCreditRepayStatus(),"参数repayStatus不能为空！");
        return creditRepayService.changeRepayStatus(creditRepaySearchQueryVo);
    }

    /**
     * @Description  保存新增授信还款信息
     * @Param [creditRepaySearchQueryVo]
     * @return com.brcc.business.creditRepay.entity.CreditRepayEntity
     **/
    @RequestMapping(value = "/repaySave",method = RequestMethod.POST)
    @ResponseBody
    CreditRepayEntity addRepaySave(@RequestBody CreditRepayEntity creditRepayEntity){
        logger.info("save new credit repay,credit_company_id{},invCompanyId:{},amount:{}:",creditRepayEntity.getCreditCompanyId(),creditRepayEntity.getInvestCompanyId(),creditRepayEntity.getCreditRepayAmt());
        Assert.notNull(creditRepayEntity.getCreditCompanyId(),"参数creditCompanyId不能为空！");
        Assert.notNull(creditRepayEntity.getInvestCompanyId(),"参数invCompanyId不能为空！");
        Assert.notNull(creditRepayEntity.getCreditRepayAmt(),"参数amount不能为空！");
        return creditRepayService.addRepaySave(creditRepayEntity);
    }





}
