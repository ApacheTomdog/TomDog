package com.brcc.business.creditAdjustPrice.service;

import com.brcc.business.company.entity.CompanyEntity;
import com.brcc.business.company.vo.CompanySearchVo;
import com.brcc.business.company.vo.CompanyVo;
import com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceDetailEntity;
import com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceMasterEntity;
import com.brcc.business.creditAdjustPrice.vo.CreditAdjustPriceQuerySearchVo;
import com.brcc.business.creditConfig.vo.CreditConfigAddCompanyVo;
import com.brcc.business.creditConfig.vo.CreditConfigQueryVo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Description: 授信调价配置操作逻辑接口
 * @Auther: gemaochao
 * @Date:Created in 17:44 2018/11/3
 */
public interface CreditAdjustPriceMasterService {

    /**
     * @Description  返回委托方授信调价信息
     * @Param [creditAdjustPriceQuerySearchVo]
     * @return org.springframework.data.domain.Page<com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceMasterEntity>
     **/
    Page<CreditAdjustPriceMasterEntity> showCreditAdjustMaster(CreditAdjustPriceQuerySearchVo creditAdjustPriceQuerySearchVo);
    
    /**
     * @Description  根据credAdjMId和publishCompanyId改变指定调价状态
     * @Param [creditAdjustPriceQuerySearchVo]
     * @return com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceMasterEntity
     **/
    CreditAdjustPriceMasterEntity changeAdjStatus(CreditAdjustPriceQuerySearchVo creditAdjustPriceQuerySearchVo);

    /**
     * @Description  判断指定publishCompanyId 委托方是否存在有效调价信息
     * @Param [publishCompanyId, adjPriceStatus]
     * @return boolean
     **/
    boolean existsByPublishCompanyId(CreditAdjustPriceQuerySearchVo creditAdjustPriceQuerySearchVo);

    /**
     * @Description  保存新增委托方授信调价配置信息
     * @Param [creditAdjustPriceQuerySearchVo]
     * @return com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceMasterEntity
     **/
    CreditAdjustPriceMasterEntity addAdjustPriceSave(CreditAdjustPriceQuerySearchVo creditAdjustPriceQuerySearchVo);

    /**
     * @Description  返回新增委托方授信调价公司名称
     * @Param [creditConfigQueryVo]
     * @return org.springframework.data.domain.Page<com.brcc.business.creditConfig.vo.CreditConfigAddCompanyVo>
     **/
    Page<CreditConfigAddCompanyVo> queryAddAdjustPriceComapnyName(CreditConfigQueryVo creditConfigQueryVo);
    
    /**
     * @Description  返回指定credAdjMId 授信调价明细信息
     * @Param [credAdjMId]
     * @return org.springframework.data.domain.Page<com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceDetailEntity>
     **/
    Page<CreditAdjustPriceDetailEntity> findByCredAdjMId(CreditAdjustPriceQuerySearchVo creditAdjustPriceQuerySearchVo);


    /**
     * @Description  以List形式返回指定credAdjMId 授信调价明细信息
     * @Param [creditAdjustPriceQuerySearchVo]
     * @return java.util.List<com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceDetailEntity>
     **/
    List<CreditAdjustPriceDetailEntity> findListByCredAdjMId(CreditAdjustPriceQuerySearchVo creditAdjustPriceQuerySearchVo);


    /**
     * @Description  查询指定credAdjMId授信调价信息
     * @Param [credAdjMId]
     * @return com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceMasterEntity
     **/
    CreditAdjustPriceMasterEntity findMasterByCredAdjMId(Long credAdjMId);

    /**
     * @Description  保存新增调价明细
     * @Param [creditAdjustPriceDetailEntity]
     * @return com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceDetailEntity
     **/
    CreditAdjustPriceDetailEntity addDetailSave(CreditAdjustPriceDetailEntity creditAdjustPriceDetailEntity);

    /**
     * @Description  根据CredAdid返回明细
     * @Param [credAdjDId]
     * @return com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceDetailEntity
     **/
    CreditAdjustPriceDetailEntity findDetailByCredAdjDId(Long credAdjDId);
    
    /**
     * @Description  删除指定credAdjDId明细
     * @Param [credAdjDId]
     * @return com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceDetailEntity
     **/
    Integer detaleDetail(Long credAdjDId);

    
    /**
     * @Description  保存明细修改
     * @Param [creditAdjustPriceDetailEntity]
     * @return com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceDetailEntity
     **/
    CreditAdjustPriceDetailEntity saveEditDetail(CreditAdjustPriceDetailEntity creditAdjustPriceDetailEntity);

    List<CreditAdjustPriceMasterEntity> queryCreditAdjustPriceList(CreditAdjustPriceQuerySearchVo creditAdjustPriceQuerySearchVo);
    /**
     * @Description  判断该授信调价下是否存在子记录
     * @Param [mid]
     * @return boolean
     **/
    boolean existsByCredAdjMId(Long mid);


    /**
     * @Description  业务员管理页面公司名称
     * @Param [vo]
     * @return org.springframework.data.domain.Page<com.brcc.business.company.vo.CompanyVo>
     **/
    Page<CompanyVo> queryCompanyForSalesman(CompanySearchVo vo);

    /**
     * @Description  返回指定id公司信息
     * @Param [seqId]
     * @return com.brcc.business.company.entity.CompanyEntity
     **/
    CompanyEntity findCompanyById(Long seqId);
}