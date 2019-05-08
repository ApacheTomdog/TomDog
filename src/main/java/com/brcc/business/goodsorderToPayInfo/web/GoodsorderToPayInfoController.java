package com.brcc.business.goodsorderToPayInfo.web;

import com.brcc.business.bank.entity.BanksEntity;
import com.brcc.business.creditConfig.vo.CreditConfigAddCompanyVo;
import com.brcc.business.goodsorderToPayInfo.entity.GoodsorderToPayInfoEntity;
import com.brcc.business.goodsorderToPayInfo.service.GoodsorderToPayInfoService;
import com.brcc.business.goodsorderToPayInfo.vo.GoodsorderToPayInfoQueryVo;
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
 * @Description: 收款账号配置
 * @Auther: gemaochao
 * @Date:Created in 14:28 2018/11/12
 */
@RestController
@RequestMapping("/GoodsorderToPayInfo")
public class GoodsorderToPayInfoController {

    @Autowired
    GoodsorderToPayInfoService goodsorderToPayInfoService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * @Description  返回收款账号配置页面数据
     * @Param [goodsorderToPayInfoQueryVo]
     * @return org.springframework.data.domain.Page<com.brcc.business.goodsorderToPayInfo.entity.GoodsorderToPayInfoEntity>
     **/
    @RequestMapping("/queryInfo")
    Page<GoodsorderToPayInfoEntity> queryInfo(@RequestBody GoodsorderToPayInfoQueryVo goodsorderToPayInfoQueryVo){
        logger.info("query pay info ,companyId:{},platformId:{}",goodsorderToPayInfoQueryVo.getCompanyId(),goodsorderToPayInfoQueryVo.getPlatformId());
        Assert.notNull(goodsorderToPayInfoQueryVo.getCompanyId(),"参数companyId不能为空！");
        Assert.notNull(goodsorderToPayInfoQueryVo.getPlatformId(),"参数platformId不能为空！");
        return goodsorderToPayInfoService.queryPayInfo(goodsorderToPayInfoQueryVo);
    }

    /**
     * @Description  保存新增收款配置
     * @Param [goodsorderToPayInfoEntity]
     * @return com.brcc.business.goodsorderToPayInfo.entity.GoodsorderToPayInfoEntity
     **/
    @RequestMapping("/addPayInfo")
    GoodsorderToPayInfoEntity addPayInfoSave(@RequestBody GoodsorderToPayInfoQueryVo goodsorderToPayInfoQueryVo){
        logger.info("add pay info save,companyId:{}，userId:{},platformId:{},publishId:{},bankNum:{},bankCardOwner:{}",goodsorderToPayInfoQueryVo.getCompanyId(),goodsorderToPayInfoQueryVo.getUserId(),goodsorderToPayInfoQueryVo.getPlatformId(),goodsorderToPayInfoQueryVo.getPublishId(),goodsorderToPayInfoQueryVo.getBankNum(),goodsorderToPayInfoQueryVo.getBankCardOwner());
        Assert.notNull(goodsorderToPayInfoQueryVo.getCompanyId(),"参数companyId不能为空！");
        Assert.notNull(goodsorderToPayInfoQueryVo.getPlatformId(),"参数platFormId不能为空！");
        Assert.notNull(goodsorderToPayInfoQueryVo.getPublishId(),"参数publishId不能为空！");
        Assert.notNull(goodsorderToPayInfoQueryVo.getBankNum(),"参数bankNum不能为空！");
        Assert.notNull(goodsorderToPayInfoQueryVo.getBankCardOwner(),"参数bankOwner不能为空！");
        //对新增收款账户进行验证
        //检测是否是自己的货源单号
        Assert.isTrue((goodsorderToPayInfoService.verifyPublishId(goodsorderToPayInfoQueryVo))!= 0,"请输入自己发布的货源单号！");
        //检测是否添加过此货源单的收款账号
        Assert.isTrue(!((goodsorderToPayInfoService.verifyPayInfo(goodsorderToPayInfoQueryVo))>0),"您已经添加过此货源单的收款账号请勿重复配置!");
        //检测货源单号状态
        Assert.isTrue(!(("00").equals(goodsorderToPayInfoService.checkStatus(goodsorderToPayInfoQueryVo))),"此货源单已作废无法配置收款账号!");
        return goodsorderToPayInfoService.addPayInfo(goodsorderToPayInfoQueryVo);
    }


    /**
     * @Description  返回新增收款账号银行名
     * @Param [goodsorderToPayInfoQueryVo]
     * @return java.util.List<com.brcc.business.creditConfig.vo.CreditConfigAddCompanyVo>
     **/
    @RequestMapping("/queryBankName")
    List<CreditConfigAddCompanyVo> queryBankName(@RequestBody GoodsorderToPayInfoQueryVo goodsorderToPayInfoQueryVo){
        logger.info("query add pay info bank name ");
        Assert.notNull(goodsorderToPayInfoQueryVo.getPlatformId(),"参数platformId不能为空！");
        BanksEntity banksEntity = new BanksEntity();
        banksEntity.setPlatformId(goodsorderToPayInfoQueryVo.getPlatformId());
        return goodsorderToPayInfoService.queryBankName(banksEntity);
    }

    /**
     * @Description  保存收款账号修改信息
     * @Param [goodsorderToPayInfoEntity]
     * @return com.brcc.business.goodsorderToPayInfo.entity.GoodsorderToPayInfoEntity
     **/
    @RequestMapping("/editInfoSave")
    GoodsorderToPayInfoEntity editInfoSave(@RequestBody GoodsorderToPayInfoEntity goodsorderToPayInfoEntity){
        logger.info("edit pay info save,companyId:{},publishId:{},bankNum:{},bankCardOwner:{}",goodsorderToPayInfoEntity.getCompanyId(),goodsorderToPayInfoEntity.getPublishId(),goodsorderToPayInfoEntity.getBankNum(),goodsorderToPayInfoEntity.getBankCardOwner());
        Assert.notNull(goodsorderToPayInfoEntity.getPublishId(),"参数publishId不能为空！");
        Assert.notNull(goodsorderToPayInfoEntity.getBankNum(),"参数bankNum不能为空！");
        Assert.notNull(goodsorderToPayInfoEntity.getBankCardOwner(),"参数bankOwner不能为空！");
        return goodsorderToPayInfoService.editInfoSave(goodsorderToPayInfoEntity);
    }

    /**
     * @Description  返回指定id收款账号信息
     * @Param [goodsorderToPayInfoQueryVo]
     * @return com.brcc.business.goodsorderToPayInfo.entity.GoodsorderToPayInfoEntity
     **/
    @RequestMapping("/findById")
    GoodsorderToPayInfoEntity findById(@RequestBody GoodsorderToPayInfoQueryVo goodsorderToPayInfoQueryVo){
        logger.info("find pay info by id:{}",goodsorderToPayInfoQueryVo.getSeqId());
        Assert.notNull(goodsorderToPayInfoQueryVo.getSeqId(),"参数seqId不能为空！");
        return goodsorderToPayInfoService.findById(goodsorderToPayInfoQueryVo);
    }
    
    /**
     * @Description  删除指定id收款账号信息
     * @Param [goodsorderToPayInfoQueryVo]
     * @return com.brcc.business.goodsorderToPayInfo.entity.GoodsorderToPayInfoEntity
     **/
    @RequestMapping("/delete")
    void deleteInfo(@RequestBody GoodsorderToPayInfoQueryVo goodsorderToPayInfoQueryVo){
        logger.info("delete pay info,seqId:{}",goodsorderToPayInfoQueryVo.getSeqId());
        Assert.notNull(goodsorderToPayInfoQueryVo.getSeqId(),"参数seqId不能为空！");
         goodsorderToPayInfoService.deleteInfo(goodsorderToPayInfoQueryVo);
    }



    /**
     * @Description  检测货源单号是否添加过此货源单的收款账号
     * @Param [companyId, platformId, publishId]
     * @return java.lang.Long
     **/
    @RequestMapping("/verifyPayInfo")
    Long verifyPayInfo(@RequestBody GoodsorderToPayInfoQueryVo goodsorderToPayInfoQueryVo){
        return goodsorderToPayInfoService.verifyPayInfo(goodsorderToPayInfoQueryVo);
    }

    /**
     * @Description  检测是否是自己的货源单号
     * @Param [companyId, userId, platformId, publishId]
     * @return java.lang.Long
     **/
    @RequestMapping("/verifyPublishId")
    Long verifyPublishId(@RequestBody GoodsorderToPayInfoQueryVo goodsorderToPayInfoQueryVo){
        return goodsorderToPayInfoService.verifyPublishId(goodsorderToPayInfoQueryVo);
    }

    /**
     * @Description  检测货源单号状态
     * @Param [platformId, publishId]
     * @return java.lang.String
     **/
    @RequestMapping("/checkStatus")
    String checkStatus(@RequestBody GoodsorderToPayInfoQueryVo goodsorderToPayInfoQueryVo){
        return goodsorderToPayInfoService.checkStatus(goodsorderToPayInfoQueryVo);
    }
}
