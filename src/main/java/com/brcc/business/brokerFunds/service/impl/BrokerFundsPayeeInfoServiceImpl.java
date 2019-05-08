package com.brcc.business.brokerFunds.service.impl;

import com.brcc.business.brokerFunds.entity.BrokerFundsPayeeInfoEntity;
import com.brcc.business.brokerFunds.repository.BrokerFundsPayeeInfoRepository;
import com.brcc.business.brokerFunds.service.BrokerFundsPayeeInfoService;
import com.brcc.business.brokerFunds.vo.BrokerFundsPayeeInfoQueryVo;
import com.brcc.business.brokerFunds.vo.BrokerFundsPayeeInfoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 资金流水单分配信息查询添加删除
 * @Author pjy
 * @Date 2019-3-01
 **/
@Service
@Transactional
public class BrokerFundsPayeeInfoServiceImpl implements BrokerFundsPayeeInfoService {

    Logger logger = LoggerFactory.getLogger(BrokerFundsPayeeInfoServiceImpl.class);
    @Autowired
    BrokerFundsPayeeInfoRepository  brokerFundsPayeeInfoRepository;

    @Override
    public BrokerFundsPayeeInfoEntity save(BrokerFundsPayeeInfoEntity entity){
        return brokerFundsPayeeInfoRepository.save(entity) ;
    }

    @Override
    public BrokerFundsPayeeInfoEntity findByFundsControlMasterIdAndCompanyPayeeId(Long fundsControlMasterId,Long companyPayeeId){
        return  brokerFundsPayeeInfoRepository.findByFundsControlMasterIdAndCompanyPayeeId(fundsControlMasterId,companyPayeeId);
    }
    @Override
    public Page<BrokerFundsPayeeInfoVo> lookPayeeDetail(BrokerFundsPayeeInfoQueryVo vo){
        return  brokerFundsPayeeInfoRepository.lookPayeeDetail(vo);
    }
    @Override
    public void deleteById(Long brokerFundsPayeeInfoId){
         brokerFundsPayeeInfoRepository.deleteById(brokerFundsPayeeInfoId);
    }
    @Override
    public Integer countByFundsControlMasterId(Long fundsControlMasterId){
        return brokerFundsPayeeInfoRepository.countByFundsControlMasterId(fundsControlMasterId);
    }
    @Override
    public List<BrokerFundsPayeeInfoEntity> findByFundsControlMasterId(Long fundsControlMasterId){
        return brokerFundsPayeeInfoRepository.findByFundsControlMasterId(fundsControlMasterId);
    }
    @Override
    public BigDecimal getPayeeInfoAmount(Long fundsControlMasterId){
        return  brokerFundsPayeeInfoRepository.getPayeeInfoAmount(fundsControlMasterId);
    }
    @Override
    public ArrayList checkPayeeAmountPro(Integer asPkId, String  asType, String asPersonId, String asPersonName){
        return brokerFundsPayeeInfoRepository.checkPayeeAmountPro(asPkId,asType,asPersonId,asPersonName);
    }
}
