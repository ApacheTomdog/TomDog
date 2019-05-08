package com.brcc.business.creditAdjustPrice.web;

import com.brcc.business.company.entity.CompanyEntity;
import com.brcc.business.company.vo.CompanySearchVo;
import com.brcc.business.company.vo.CompanyVo;
import com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceDetailEntity;
import com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceMasterEntity;
import com.brcc.business.creditAdjustPrice.service.CreditAdjustPriceMasterService;
import com.brcc.business.creditAdjustPrice.vo.CreditAdjustPriceQuerySearchVo;
import com.brcc.business.creditConfig.vo.CreditConfigAddCompanyVo;
import com.brcc.business.creditConfig.vo.CreditConfigQueryVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 授信调价配置
 * @Auther: gemaochao
 * @Date:Created in 17:45 2018/11/3
 */
@RestController
@RequestMapping("/creditAdjustPrice")
public class CreditAdjustPriceMasterController {

    @Autowired
    CreditAdjustPriceMasterService creditAdjustPriceMasterService;
    
    
    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * @Description  返回委托方授信调价页面
     * @Param [creditAdjustPriceQuerySearchVo]
     * @return org.springframework.data.domain.Page<com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceMasterEntity>
     **/
    @RequestMapping("/showMaster")
    @ResponseBody
    Page<CreditAdjustPriceMasterEntity> showCreditAdjustMaster(@RequestBody CreditAdjustPriceQuerySearchVo creditAdjustPriceQuerySearchVo){
        logger.info("show credit adjust price master,platCompanyId:{},platFormId:{}", creditAdjustPriceQuerySearchVo.getCreditPlatCompanyId(), creditAdjustPriceQuerySearchVo.getPlatformId());
        Assert.isTrue(creditAdjustPriceQuerySearchVo.getCreditPlatCompanyId() != null,"参数platCompanyId不能为空！");
        Assert.isTrue(creditAdjustPriceQuerySearchVo.getPlatformId() != null,"参数platFormId不能为空！");
        return creditAdjustPriceMasterService.showCreditAdjustMaster(creditAdjustPriceQuerySearchVo);
    }

    /**
     * @Description  根据credAdjMId和publishCompanyId改变指定调价状态
     * @Param [creditAdjustPriceQuerySearchVo]
     * @return com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceMasterEntity
     **/
    @RequestMapping("/changeStatus")
    @ResponseBody
    CreditAdjustPriceMasterEntity changeAdjustStatus(@RequestBody CreditAdjustPriceQuerySearchVo creditAdjustPriceQuerySearchVo){
        logger.info("change credit adjust price status ,adjMID:{},publishId:{},status:{}", creditAdjustPriceQuerySearchVo.getCredAdjMId(), creditAdjustPriceQuerySearchVo.getPublishCompanyId(), creditAdjustPriceQuerySearchVo.getAdjPriceStatus());
        Assert.isTrue(creditAdjustPriceQuerySearchVo.getCredAdjMId() != null,"参数credAdjMId不能为空！");
        Assert.isTrue(creditAdjustPriceQuerySearchVo.getAdjPriceStatus() != null,"参数adjPriceStatus不能为空！");
        Assert.isTrue(creditAdjustPriceQuerySearchVo.getModifyPersonId() != null,"参数modifyUserId不能为空！");
        return creditAdjustPriceMasterService.changeAdjStatus(creditAdjustPriceQuerySearchVo);
    }

    /**
     * @Description  判断指定publishCompanyId 委托方是否存在有效授信调价信息
     * @Param [publishCompanyId, adjPriceStatus]
     * @return boolean
     **/
    @RequestMapping("/existsStatus")
    @ResponseBody
    boolean existsByPublishCompanyId(@RequestBody CreditAdjustPriceQuerySearchVo creditAdjustPriceQuerySearchVo){
        logger.info("exists By PublishCompanyId:{} And AdjPriceStatus:{}", creditAdjustPriceQuerySearchVo.getPublishCompanyId(), creditAdjustPriceQuerySearchVo.getAdjPriceStatus());
        Assert.isTrue(creditAdjustPriceQuerySearchVo.getPublishCompanyId() != null,"参数publishCompanyId不能为空！");
        return creditAdjustPriceMasterService.existsByPublishCompanyId(creditAdjustPriceQuerySearchVo);
    }

    /**
     * @Description  保存新增委托方授信调价信息
     * @Param [creditAdjustPriceQuerySearchVo]
     * @return com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceMasterEntity
     **/
    @RequestMapping("/addAdjustPriceSave")
    @ResponseBody
    CreditAdjustPriceMasterEntity addAdjustPriceSave(@RequestBody CreditAdjustPriceQuerySearchVo creditAdjustPriceQuerySearchVo){
        logger.info("save new adjust price,companyName:{},priceStyle:{}", creditAdjustPriceQuerySearchVo.getPublishCompanyName(), creditAdjustPriceQuerySearchVo.getAdjPriceStyle());
        Assert.isTrue(creditAdjustPriceQuerySearchVo.getPublishCompanyId() != null,"参数publishCompanyId不能为空！");
        Assert.isTrue(creditAdjustPriceQuerySearchVo.getAdjPriceStyle() != null,"参数adjPriceStyle不能为空！");
        Assert.isTrue(creditAdjustPriceQuerySearchVo.getPlatformId() != null,"参数platFormId不能为空！");
        return creditAdjustPriceMasterService.addAdjustPriceSave(creditAdjustPriceQuerySearchVo);
    }


    /**
     * @Description  返回新增委托方授信调价公司名称
     * @Param [creditConfigQueryVo]
     * @return org.springframework.data.domain.Page<com.brcc.business.creditConfig.vo.CreditConfigAddCompanyVo>
     **/
    @RequestMapping("/queryCompanyName")
    @ResponseBody
    Page<CreditConfigAddCompanyVo> queryAddAdjustPriceComapnyName(@RequestBody CreditConfigQueryVo creditConfigQueryVo){
        logger.info("query credit adjust price add company name");
        Assert.isTrue(creditConfigQueryVo.getCreditPlatCompanyId() != null,"参数creditPlatCompanyId不能为空！");
        Assert.isTrue(creditConfigQueryVo.getPlatformId() != null,"参数PlatFormId不能为空！");
        return creditAdjustPriceMasterService.queryAddAdjustPriceComapnyName(creditConfigQueryVo);
    }

    /**
     * @Description  返回授信明细
     * @Param [creditAdjustPriceQuerySearchVo]
     * @return org.springframework.data.domain.Page<com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceDetailEntity>
     **/
    @RequestMapping("/showDetail")
    Page<CreditAdjustPriceDetailEntity> findByCredAdjMId(@RequestBody CreditAdjustPriceQuerySearchVo creditAdjustPriceQuerySearchVo){
        logger.info("show credit adjust price detail,credAdjMId:{}", creditAdjustPriceQuerySearchVo.getCredAdjMId());
        Assert.isTrue(creditAdjustPriceQuerySearchVo.getCredAdjMId() != null,"参数credAdjMId不能为空！");
        return creditAdjustPriceMasterService.findByCredAdjMId(creditAdjustPriceQuerySearchVo);
    }

    /**
     * @Description  以List形式返回指定credAdjMId 授信调价明细信息
     * @Param [creditAdjustPriceQuerySearchVo]
     * @return java.util.List<com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceDetailEntity>
     **/
    @RequestMapping("/detailList")
    @ResponseBody
    List<CreditAdjustPriceDetailEntity> showDetailList(@RequestBody CreditAdjustPriceQuerySearchVo creditAdjustPriceQuerySearchVo){
        logger.info("return adjust price detail by list form ,credAdjMId:{}", creditAdjustPriceQuerySearchVo.getCredAdjMId());
        Assert.isTrue(creditAdjustPriceQuerySearchVo.getCredAdjMId() != null,"参数credAdjMId不能为空！");
        return creditAdjustPriceMasterService.findListByCredAdjMId(creditAdjustPriceQuerySearchVo);
    }

    /**
     * @Description  查询指定credAdjMId授信调价信息
     * @Param [creditAdjustPriceQuerySearchVo]
     * @return com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceMasterEntity
     **/
    @RequestMapping("/findMaster")
    @ResponseBody
    CreditAdjustPriceMasterEntity findMaster(@RequestBody CreditAdjustPriceQuerySearchVo creditAdjustPriceQuerySearchVo){
        logger.info("find credit adjust price master by mid :{}",creditAdjustPriceQuerySearchVo.getCredAdjMId());
        Assert.isTrue(creditAdjustPriceQuerySearchVo.getCredAdjMId() != null,"参数mid不能为空！");
            return creditAdjustPriceMasterService.findMasterByCredAdjMId(creditAdjustPriceQuerySearchVo.getCredAdjMId());
    }
    
    /**
     * @Description  保存新增调价明细
     * @Param [creditAdjustPriceDetailEntity]
     * @return com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceDetailEntity
     **/
    @RequestMapping("/addDetailSave")
    @ResponseBody
    CreditAdjustPriceDetailEntity addDetailSave(@RequestBody CreditAdjustPriceDetailEntity creditAdjustPriceDetailEntity){
        logger.info("add adjust price detail save,mid:{},minPrice:{}maxPrice:{},createPerson:{}",creditAdjustPriceDetailEntity.getCredAdjMId(),creditAdjustPriceDetailEntity.getMinPrice(),creditAdjustPriceDetailEntity.getMaxPrice(),creditAdjustPriceDetailEntity.getCreatePersonName());
        Assert.notNull(creditAdjustPriceDetailEntity.getCredAdjMId(),"参数mid不能为空！");
        Assert.notNull(creditAdjustPriceDetailEntity.getMinPrice(),"参数min不能为空！");
        Assert.notNull(creditAdjustPriceDetailEntity.getMaxPrice(),"参数max不能为空！");
        return creditAdjustPriceMasterService.addDetailSave(creditAdjustPriceDetailEntity);
    }

    /**
     * @Description  根据credAdjDId返回调价明细
     * @Param [creditAdjustPriceDetailEntity]
     * @return boolean
     **/
    @RequestMapping("/findDetail")
    @ResponseBody
    CreditAdjustPriceDetailEntity findDetailByCredAdjDId(@RequestBody CreditAdjustPriceDetailEntity creditAdjustPriceDetailEntity){
        logger.info("whether the price adjust detail is in use,credAdjDId:{}",creditAdjustPriceDetailEntity.getCredAdjDId());
        Assert.notNull(creditAdjustPriceDetailEntity.getCredAdjDId(),"参数credAdjDId不能为空！");
        return creditAdjustPriceMasterService.findDetailByCredAdjDId(creditAdjustPriceDetailEntity.getCredAdjDId());
    }
    
    /**
     * @Description  删除指定credAdjDId明细
     * @Param [creditAdjustPriceDetailEntity]
     * @return com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceDetailEntity
     **/
    @RequestMapping("/deleteDetail")
    @ResponseBody
    Integer deteleDetail(@RequestBody CreditAdjustPriceDetailEntity creditAdjustPriceDetailEntity){
        logger.info("delete detail,credAdjDId:{}",creditAdjustPriceDetailEntity.getCredAdjDId());
        Assert.notNull(creditAdjustPriceDetailEntity.getCredAdjDId(),"参数credAdjDId不能为空！");
        return creditAdjustPriceMasterService.detaleDetail(creditAdjustPriceDetailEntity.getCredAdjDId());
    }

    /**
     * @Description  保存明细修改
     * @Param [creditAdjustPriceDetailEntity]
     * @return com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceDetailEntity
     **/
    @RequestMapping("/saveEditDetail")
    @ResponseBody
    CreditAdjustPriceDetailEntity saveEditDetail(@RequestBody CreditAdjustPriceDetailEntity creditAdjustPriceDetailEntity){
        logger.info("save edit detail,credAdjDId:{},minPrice:{},maxPrice:{},addPrice:{}",creditAdjustPriceDetailEntity.getCredAdjDId(),creditAdjustPriceDetailEntity.getMinPrice(),creditAdjustPriceDetailEntity.getMaxPrice(),creditAdjustPriceDetailEntity.getCreditAddPrice());
        Assert.notNull(creditAdjustPriceDetailEntity.getCredAdjDId(),"参数credAdjDId不能为空！");
        Assert.notNull(creditAdjustPriceDetailEntity.getMinPrice(),"参数minPrice不能为空！");
        Assert.notNull(creditAdjustPriceDetailEntity.getMaxPrice(),"参数maxPrice不能为空！");
        Assert.notNull(creditAdjustPriceDetailEntity.getCreditAddPrice(),"参数addPrice不能为空！");
        return creditAdjustPriceMasterService.saveEditDetail(creditAdjustPriceDetailEntity);
    }

    /**
     * @Description  判断该授信调价下是否存在子记录
     * @Param [mid]
     * @return boolean
     **/
    @RequestMapping("/existsByMId")
    boolean existsByCredAdjMId(@RequestBody CreditAdjustPriceQuerySearchVo vo){
        Assert.notNull(vo.getCredAdjMId(),"mid不能为空！");
        return creditAdjustPriceMasterService.existsByCredAdjMId(vo.getCredAdjMId());
    }

    /**
     * @Description  业务员管理页面公司名称
     * @Param [vo]
     * @return org.springframework.data.domain.Page<com.brcc.business.company.vo.CompanyVo>
     **/
    @RequestMapping("/queryCompanyForSalesman")
    Page<CompanyVo> queryCompanyForSalesman(@RequestBody CompanySearchVo vo){
        Assert.notNull(vo.getPlatformId(),"参数platformId不能为空！");
        return creditAdjustPriceMasterService.queryCompanyForSalesman(vo);
    }


    /**
     * @Description  返回指定id公司信息
     * @Param [seqId]
     * @return com.brcc.business.company.entity.CompanyEntity
     **/
    @RequestMapping("/findCompanyById")
    CompanyEntity findCompanyById(@RequestBody CompanySearchVo vo){
        return creditAdjustPriceMasterService.findCompanyById(vo.getCompanyId());
    }

}
