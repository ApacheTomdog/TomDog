package com.brcc.business.brokerFunds.service.impl;

import com.brcc.business.brokerFunds.entity.BrokerfundscontroldetailEntity;
import com.brcc.business.brokerFunds.repository.BrokerFundsDetailRepository;
import com.brcc.business.brokerFunds.service.BrokerFundsDetailService;
import com.brcc.business.brokerFunds.vo.BrokerFundsDetailQueryVo;
import com.brcc.business.brokerFunds.vo.BrokerFundsDetailVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * @Description
 * @Author pjy
 * @Date
 **/
@Service
public class BrokerFundsDetailServiceImpl implements BrokerFundsDetailService {
    Logger logger = LoggerFactory.getLogger(BrokerFundsDetailServiceImpl.class);
    @Autowired
    BrokerFundsDetailRepository  brokerFundsDetailRepository;
    @Override
    public BrokerFundsDetailVo queryDeliveryDetail(BrokerFundsDetailQueryVo vo){
            return brokerFundsDetailRepository.queryDeliveryDetail(vo);
    }
    @Override
    public BrokerfundscontroldetailEntity save(BrokerfundscontroldetailEntity entity){
          return  brokerFundsDetailRepository.save(entity);
    }
    @Override
    @Transactional
    public  void updateDeliveryFundsFlag(Long fundsControlDetailId){
        brokerFundsDetailRepository.updateDeliveryFundsFlag(fundsControlDetailId);
    }

    @Override
    @Transactional
    public void deleteById(Long fundsControlDetailId){
        brokerFundsDetailRepository.deleteById(fundsControlDetailId);
    }

    @Override
    public BrokerfundscontroldetailEntity findById(Long fundsControlDetailId){
        Optional <BrokerfundscontroldetailEntity> optional= brokerFundsDetailRepository.findById(fundsControlDetailId);
        if(optional.isPresent()){
            return optional.get();
        }
        else{
            return new BrokerfundscontroldetailEntity();
        }
    }
    @Override
    public List<BrokerfundscontroldetailEntity> findByFundsControlMasterId(Long fundsControlMasterId){
        return brokerFundsDetailRepository.findByFundsControlMasterId(fundsControlMasterId);
    }
    @Override
    public  void deleteAllByFundsControlMasterId(Long fundsControlMasterId){
        brokerFundsDetailRepository.deleteAllByFundsControlMasterId(fundsControlMasterId);
    }
    @Override
    public Integer countByFundsControlMasterIdAndFcIfUpload(Long fundsControlMasterId,Integer fcIfUpload){
        return brokerFundsDetailRepository.countByFundsControlMasterIdAndFcIfUpload(fundsControlMasterId,fcIfUpload);
    }
    @Override
    public Integer countByFundsControlMasterId(Long fundsControlMasterId){
        return brokerFundsDetailRepository.countByFundsControlMasterId(fundsControlMasterId);
    }

    @Override
    public List<BrokerfundscontroldetailEntity> findAllDetailInfo(Long fundsControlMasterId){
        return brokerFundsDetailRepository.findAllDetailInfo(fundsControlMasterId);
    }
    @Override
    public BigDecimal getDetailAmount(Long fundsControlMasterId){
        return brokerFundsDetailRepository.getDetailAmount(fundsControlMasterId);
    }

}
