package com.brcc.business.goodsorderToPayInfo.service;

import com.brcc.business.bank.entity.BanksEntity;
import com.brcc.business.creditConfig.vo.CreditConfigAddCompanyVo;
import com.brcc.business.goodsorderToPayInfo.entity.GoodsorderToPayInfoEntity;
import com.brcc.business.goodsorderToPayInfo.vo.GoodsorderToPayInfoQueryVo;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: 收款账号配置逻辑
 * @Auther: gemaochao
 * @Date:Created in 14:23 2018/11/12
 */
public interface GoodsorderToPayInfoService {


    /**
     * @Description  返回收款账号配置页面数据
     * @Param [goodsorderToPayInfoQueryVo]
     * @return org.springframework.data.domain.Page<com.brcc.business.goodsorderToPayInfo.entity.GoodsorderToPayInfoEntity>
     **/
    Page<GoodsorderToPayInfoEntity> queryPayInfo(GoodsorderToPayInfoQueryVo goodsorderToPayInfoQueryVo);

    /**
     * @Description  保存新增收款账号
     * @Param [goodsorderToPayInfoQueryVo]
     * @return com.brcc.business.goodsorderToPayInfo.entity.GoodsorderToPayInfoEntity
     **/
    GoodsorderToPayInfoEntity addPayInfo(GoodsorderToPayInfoQueryVo goodsorderToPayInfoQueryVo );
    
    /**
     * @Description  返回新增收款账号银行名
     * @Param [banksEntity]
     * @return java.util.List<com.brcc.business.creditConfig.vo.CreditConfigAddCompanyVo>
     **/
    List<CreditConfigAddCompanyVo> queryBankName(BanksEntity banksEntity);
    
    /**
     * @Description  保存收款账号修改信息
     * @Param [goodsorderToPayInfoEntity]
     * @return com.brcc.business.goodsorderToPayInfo.entity.GoodsorderToPayInfoEntity
     **/
    GoodsorderToPayInfoEntity editInfoSave(GoodsorderToPayInfoEntity goodsorderToPayInfoEntity);
    
    /**
     * @Description  返回指定id收款账号信息
     * @Param [goodsorderToPayInfoQueryVo]
     * @return com.brcc.business.goodsorderToPayInfo.entity.GoodsorderToPayInfoEntity
     **/
    GoodsorderToPayInfoEntity findById(GoodsorderToPayInfoQueryVo goodsorderToPayInfoQueryVo);
    
    /**
     * @Description  删除指定id收款账号信息
     * @Param [goodsorderToPayInfoQueryVo]
     * @return com.brcc.business.goodsorderToPayInfo.entity.GoodsorderToPayInfoEntity
     **/
    void deleteInfo(GoodsorderToPayInfoQueryVo goodsorderToPayInfoQueryVo);

    /**
     * @Description  检测货源单号是否添加过此货源单的收款账号
     * @Param [companyId, platformId, publishId]
     * @return java.lang.Long
     **/
    Long verifyPayInfo(GoodsorderToPayInfoQueryVo goodsorderToPayInfoQueryVo);

    /**
     * @Description  检测是否是自己的货源单号
     * @Param [companyId, userId, platformId, publishId]
     * @return java.lang.Long
     **/
    Long verifyPublishId(GoodsorderToPayInfoQueryVo goodsorderToPayInfoQueryVo);

    /**
     * @Description  检测货源单号状态
     * @Param [platformId, publishId]
     * @return java.lang.String
     **/
    String checkStatus(GoodsorderToPayInfoQueryVo goodsorderToPayInfoQueryVo);

}