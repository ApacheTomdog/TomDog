package com.brcc.business.creditAdjustPrice.service.impl;

import com.brcc.business.company.entity.CompanyEntity;
import com.brcc.business.company.service.CompanyService;
import com.brcc.business.company.vo.CompanySearchVo;
import com.brcc.business.company.vo.CompanyVo;
import com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceDetailEntity;
import com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceDetailLogEntity;
import com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceMasterEntity;
import com.brcc.business.creditAdjustPrice.repository.CreditAdjustPriceMasterRepository;
import com.brcc.business.creditAdjustPrice.service.CreditAdjustPriceDetailLogService;
import com.brcc.business.creditAdjustPrice.service.CreditAdjustPriceDetailService;
import com.brcc.business.creditAdjustPrice.service.CreditAdjustPriceMasterService;
import com.brcc.business.creditAdjustPrice.vo.CreditAdjustPriceQuerySearchVo;
import com.brcc.business.creditConfig.service.CreditConfigService;
import com.brcc.business.creditConfig.vo.CreditConfigAddCompanyVo;
import com.brcc.business.creditConfig.vo.CreditConfigQueryVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @Description: 授信调价配置操作逻辑类
 * @Auther: gemaochao
 * @Date:Created in 17:44 2018/11/3
 */
@Service
public class CreditAdjustPriceMasterServiceImpl implements CreditAdjustPriceMasterService {

    @Autowired
    CreditAdjustPriceMasterRepository creditAdjustPriceMasterRepository;

    @Autowired
    CreditAdjustPriceDetailService creditAdjustPriceDetailService;

    @Autowired
    CreditAdjustPriceDetailLogService creditAdjustPriceDetailLogService;

    @Autowired
    CreditConfigService creditConfigService;

    @Autowired
    CompanyService companyService;


    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Page<CreditAdjustPriceMasterEntity> showCreditAdjustMaster(CreditAdjustPriceQuerySearchVo creditAdjustPriceQuerySearchVo) {
        return creditAdjustPriceMasterRepository.showCreditAdjustMaster(creditAdjustPriceQuerySearchVo);
    }

    @Override
    public CreditAdjustPriceMasterEntity changeAdjStatus(CreditAdjustPriceQuerySearchVo creditAdjustPriceQuerySearchVo) {
        logger.info("change adjStatus,status:{},id:{}",creditAdjustPriceQuerySearchVo.getAdjPriceStatus(),creditAdjustPriceQuerySearchVo.getCredAdjMId());
        //若该操作是将授信状态调整为有效，进行校验该委托方是否已存在有效的授信调价信息
        if (("90").equals(creditAdjustPriceQuerySearchVo.getAdjPriceStatus())){
            Assert.isTrue(!(creditAdjustPriceMasterRepository.existsByPublishCompanyIdAndAdjPriceStatus(creditAdjustPriceQuerySearchVo.getPublishCompanyId(),"90")),"操作失败，该委托方名下已存在有效授信调价记录");

            //检验该授信调价下是否存在有效的子记录

            Assert.notNull(findByCredAdjMId(creditAdjustPriceQuerySearchVo),"不存在有效的子项记录，不能生效！");

        }
        CreditAdjustPriceMasterEntity creditAdjustPriceMasterEntity = creditAdjustPriceMasterRepository.findByCredAdjMId(creditAdjustPriceQuerySearchVo.getCredAdjMId());
        creditAdjustPriceMasterEntity.setAdjPriceStatus(creditAdjustPriceQuerySearchVo.getAdjPriceStatus());
        creditAdjustPriceMasterEntity.setModifyDate(creditAdjustPriceQuerySearchVo.getModifyDate());
        creditAdjustPriceMasterEntity.setModifyPersonId(creditAdjustPriceQuerySearchVo.getModifyPersonId());
        creditAdjustPriceMasterEntity.setModifyPersonName(creditAdjustPriceQuerySearchVo.getModifyPersonName());
        return creditAdjustPriceMasterRepository.save(creditAdjustPriceMasterEntity);
    }

    @Override
    public boolean existsByPublishCompanyId(CreditAdjustPriceQuerySearchVo creditAdjustPriceQuerySearchVo) {
        return creditAdjustPriceMasterRepository.existsByPublishCompanyIdAndAdjPriceStatus(creditAdjustPriceQuerySearchVo.getPublishCompanyId(),"90");
    }

    @Override
    public CreditAdjustPriceMasterEntity addAdjustPriceSave(CreditAdjustPriceQuerySearchVo creditAdjustPriceQuerySearchVo) {
        logger.info("add adjust price save,publishCompanyId:{}",creditAdjustPriceQuerySearchVo.getPublishCompanyId());
        //判断该委托方名下是否已存在有效授信调价信息
        Assert.isTrue(!(creditAdjustPriceMasterRepository.existsByPublishCompanyIdAndAdjPriceStatus(creditAdjustPriceQuerySearchVo.getPublishCompanyId(),"90")),"新增失败，该委托方名下已存在有效授信调价信息");
        //组装新增授信调价信息
        CreditAdjustPriceMasterEntity creditAdjustPriceMasterEntity = new CreditAdjustPriceMasterEntity();
        creditAdjustPriceMasterEntity.setPublishCompanyId(creditAdjustPriceQuerySearchVo.getPublishCompanyId());
        creditAdjustPriceMasterEntity.setPublishCompanyName(companyService.findCompanyById(creditAdjustPriceQuerySearchVo.getPublishCompanyId()).getCompanyName());
        creditAdjustPriceMasterEntity.setAdjPriceStyle(creditAdjustPriceQuerySearchVo.getAdjPriceStyle());
        //调价状态默认新增
        creditAdjustPriceMasterEntity.setAdjPriceStatus("10");
        creditAdjustPriceMasterEntity.setCreateDate(creditAdjustPriceQuerySearchVo.getCreateDate());
        creditAdjustPriceMasterEntity.setCreatePersonId(creditAdjustPriceQuerySearchVo.getCreatePersonId());
        creditAdjustPriceMasterEntity.setCreatePersonName(creditAdjustPriceQuerySearchVo.getCreatePersonName());
        creditAdjustPriceMasterEntity.setModifyDate(creditAdjustPriceQuerySearchVo.getModifyDate());
        creditAdjustPriceMasterEntity.setModifyPersonId(creditAdjustPriceQuerySearchVo.getModifyPersonId());
        creditAdjustPriceMasterEntity.setModifyPersonName(creditAdjustPriceQuerySearchVo.getModifyPersonName());
        creditAdjustPriceMasterEntity.setRemark(creditAdjustPriceQuerySearchVo.getRemark());
        creditAdjustPriceMasterEntity.setCreditPlatCompanyId(creditAdjustPriceQuerySearchVo.getCreditPlatCompanyId());
        creditAdjustPriceMasterEntity.setPlatformId(creditAdjustPriceQuerySearchVo.getPlatformId());
        return creditAdjustPriceMasterRepository.save(creditAdjustPriceMasterEntity);
    }

    @Override
    public Page<CreditConfigAddCompanyVo> queryAddAdjustPriceComapnyName(CreditConfigQueryVo creditConfigQueryVo) {
        return creditConfigService.queryAddAdjustPriceCompanyName(creditConfigQueryVo);
    }

    @Override
    public Page<CreditAdjustPriceDetailEntity> findByCredAdjMId(CreditAdjustPriceQuerySearchVo creditAdjustPriceQuerySearchVo) {
        return creditAdjustPriceDetailService.findByCredAdjMId(creditAdjustPriceQuerySearchVo);
    }

    @Override
    public List<CreditAdjustPriceDetailEntity> findListByCredAdjMId(CreditAdjustPriceQuerySearchVo creditAdjustPriceQuerySearchVo) {
        return creditAdjustPriceDetailService.findListByCredAdjMId(creditAdjustPriceQuerySearchVo);
    }

    @Override
    public CreditAdjustPriceMasterEntity findMasterByCredAdjMId(Long credAdjMId) {
        return creditAdjustPriceMasterRepository.findByCredAdjMId(credAdjMId);
    }

    @Override
    public CreditAdjustPriceDetailEntity addDetailSave(CreditAdjustPriceDetailEntity creditAdjustPriceDetailEntity) {
        logger.info("add detail save,id:{}",creditAdjustPriceDetailEntity.getCredAdjDId());

        CreditAdjustPriceDetailEntity saveDetail =  creditAdjustPriceDetailService.save(creditAdjustPriceDetailEntity);
        //在credit_adjust_price_detail_log表中添加记录
        CreditAdjustPriceDetailLogEntity creditAdjustPriceDetailLogEntity = new CreditAdjustPriceDetailLogEntity();
        creditAdjustPriceDetailLogEntity.setCredAdjDId(saveDetail.getCredAdjDId());
        creditAdjustPriceDetailLogEntity.setCredAdjMId(saveDetail.getCredAdjMId());
        creditAdjustPriceDetailLogEntity.setMinPrice(saveDetail.getMinPrice());
        creditAdjustPriceDetailLogEntity.setMaxPrice(saveDetail.getMaxPrice());
        creditAdjustPriceDetailLogEntity.setCreditAddPrice(creditAdjustPriceDetailEntity.getCreditAddPrice());
        creditAdjustPriceDetailLogEntity.setCreateDate(saveDetail.getCreateDate());
        creditAdjustPriceDetailLogEntity.setCreatePersonId(saveDetail.getCreatePersonId());
        creditAdjustPriceDetailLogEntity.setCreatePersonName(saveDetail.getCreatePersonName());
        creditAdjustPriceDetailLogService.save(creditAdjustPriceDetailLogEntity);
        return saveDetail;
    }

    @Override
    public CreditAdjustPriceDetailEntity findDetailByCredAdjDId(Long credAdjDId) {
        return creditAdjustPriceDetailService.findByCredAdjDId(credAdjDId);
    }

    @Override
    @Transactional
    public Integer detaleDetail(Long credAdjDId) {
       return   creditAdjustPriceDetailService.deleteByCredAdjDId(credAdjDId);
    }

    @Override
    public CreditAdjustPriceDetailEntity saveEditDetail(CreditAdjustPriceDetailEntity creditAdjustPriceDetailEntity) {
        logger.info(" edit detail save,id:{}",creditAdjustPriceDetailEntity.getCredAdjDId());
        CreditAdjustPriceDetailEntity hadDetail = creditAdjustPriceDetailService.findByCredAdjDId(creditAdjustPriceDetailEntity.getCredAdjDId());
        hadDetail.setMinPrice(creditAdjustPriceDetailEntity.getMinPrice());
        hadDetail.setMaxPrice(creditAdjustPriceDetailEntity.getMaxPrice());
        hadDetail.setCreditAddPrice(creditAdjustPriceDetailEntity.getCreditAddPrice());
        hadDetail.setModifyDate(creditAdjustPriceDetailEntity.getModifyDate());
        hadDetail.setModifyPersonId(creditAdjustPriceDetailEntity.getModifyPersonId());
        hadDetail.setModifyPersonName(creditAdjustPriceDetailEntity.getModifyPersonName());

        //同时在credit_adjust_price_detail_log表中添加记录
        CreditAdjustPriceDetailLogEntity creditAdjustPriceDetailLogEntity = new CreditAdjustPriceDetailLogEntity();
        creditAdjustPriceDetailLogEntity.setCredAdjDId(hadDetail.getCredAdjDId());
        creditAdjustPriceDetailLogEntity.setCredAdjMId(hadDetail.getCredAdjMId());
        creditAdjustPriceDetailLogEntity.setMinPrice(hadDetail.getMinPrice());
        creditAdjustPriceDetailLogEntity.setMaxPrice(hadDetail.getMaxPrice());
        creditAdjustPriceDetailLogEntity.setCreateDate(hadDetail.getModifyDate());
        creditAdjustPriceDetailLogEntity.setCreatePersonId(hadDetail.getModifyPersonId());
        creditAdjustPriceDetailLogEntity.setCreatePersonName(hadDetail.getModifyPersonName());
        creditAdjustPriceDetailLogService.save(creditAdjustPriceDetailLogEntity);

        return creditAdjustPriceDetailService.save(hadDetail);
    }
    
    @Override
    public List<CreditAdjustPriceMasterEntity> queryCreditAdjustPriceList(CreditAdjustPriceQuerySearchVo creditAdjustPriceQuerySearchVo){
    	return creditAdjustPriceMasterRepository.queryCreditAdjustPriceList(creditAdjustPriceQuerySearchVo);
    }

    @Override
    public boolean existsByCredAdjMId(Long mid) {
        return creditAdjustPriceDetailService.existsByCredAdjMId(mid);
    }


    @Override
    public Page<CompanyVo> queryCompanyForSalesman(CompanySearchVo vo) {
        return companyService.queryCompanyForSalesman(vo);
    }


    @Override
    public CompanyEntity findCompanyById(Long seqId) {
        return companyService.findCompanyById(seqId);
    }
}
