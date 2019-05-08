package com.brcc.business.brokerFunds.service.impl;

import com.brcc.business.brokerFunds.entity.BrokerfundscontroldetailEntity;
import com.brcc.business.brokerFunds.entity.BrokerfundscontrolmasterEntity;
import com.brcc.business.brokerFunds.repository.BrokerFundsRepository;
import com.brcc.business.brokerFunds.repository.impl.BrokerFundsRepositoryImpl;
import com.brcc.business.brokerFunds.service.BrokerFundsDetailService;
import com.brcc.business.brokerFunds.service.BrokerFundsService;
import com.brcc.business.brokerFunds.vo.BrokerFundsDetailQueryVo;
import com.brcc.business.brokerFunds.vo.BrokerFundsDetailVo;
import com.brcc.business.brokerFunds.vo.BrokerFundsQueryVo;
import com.brcc.business.brokerFunds.vo.BrokerFundsVo;
import com.brcc.business.config.mybatis.MybatisQuery;
import com.brcc.business.transportbill.entity.TransportationDeliveryEntity;
import com.brcc.business.transportbill.service.TransportationDeliveryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;

/**
 * @Description 经纪人资金流水查询
 * @Author pjy
 * @Date 2018/12/27
 **/
@Service
public class BrokerFundsServiceImpl implements BrokerFundsService {

    Logger logger = LoggerFactory.getLogger(BrokerFundsServiceImpl.class);

    @Autowired
    BrokerFundsRepository brokerFundsRepository;
    @Autowired
    BrokerFundsDetailService  brokerFundsDetailService;
    @Autowired
    MybatisQuery mybatisQuery;
    @Autowired
    TransportationDeliveryService  transportationDeliveryService;
    /**
     * 经纪人资金流水单上传列表查询
     */
    @Override
    public Page<BrokerFundsVo> brokerFundsList(BrokerFundsQueryVo vo){
        logger.info(vo.toString());
        return brokerFundsRepository.brokerFundsList(vo);

    }
    /**
     * 	查询可以添加进入资金流水明细的调度单信息
     */
    @Override
    public Page<BrokerFundsDetailVo> addBrokerFundsDetailList(BrokerFundsDetailQueryVo vo){
        logger.info(vo.toString());
       return brokerFundsRepository.addBrokerFundsDetailList(vo);

    }
    /**
     * 	查询添加进入经纪人资金流水明细的调度单信息
     */
    @Override
    public Page<BrokerFundsDetailVo> lookBrokerFundsDetailList(BrokerFundsDetailQueryVo vo){
        logger.info(vo.toString());
        return brokerFundsRepository.lookBrokerFundsDetailList(vo);
    }

    /**
     * 	增加经纪人上传流水
     */
    @Override
    @Transactional
    public void addBrokerFunds(BrokerFundsVo vo){
        logger.info("add BrokerFunds by fundsPic,createRemark",vo.getFundsPic(),vo.getCreateRemark());
        String fundsControllerMasterNum = getSeqNum("103");
        vo.setFundsControlMasterNum(fundsControllerMasterNum);
        vo.setCreateDate(new Date());
        vo.setModifyDate(new Date());
        vo.setModifyPersonId(vo.getCreatePersonId());
        vo.setModifyPersonName(vo.getCreatePersonName());
        BrokerfundscontrolmasterEntity entity = new BrokerfundscontrolmasterEntity();
        BeanUtils.copyProperties(vo,entity);
        brokerFundsRepository.save(entity);
    }

    /**
     * 	增加经纪人上传流水明细
     */
    @Override
    @Transactional
    public void addDetailToBrokerFunds(BrokerFundsDetailQueryVo vo){
        String[] deliveryIdArr = vo.getDeliveryIdStr().split(",");
        BrokerfundscontrolmasterEntity brokerfundscontrolmasterEntity = brokerFundsRepository.findById(vo.getFundsControlMasterId()).get();

        for(int i=0;i<deliveryIdArr.length;i++){
                BrokerfundscontroldetailEntity detailEntity = new  BrokerfundscontroldetailEntity();
                TransportationDeliveryEntity deliveryEntity = new TransportationDeliveryEntity();
                vo.setDeliveryId(Long.parseLong(deliveryIdArr[i].toString()));
                BrokerFundsDetailVo detailVo =brokerFundsDetailService.queryDeliveryDetail(vo);
                BeanUtils.copyProperties(detailVo,detailEntity);
                deliveryEntity = transportationDeliveryService.findById(vo.getDeliveryId());
                detailEntity.setFundsControlMasterId(vo.getFundsControlMasterId());
                detailEntity.setFundsControlMasterNum(brokerfundscontrolmasterEntity.getFundsControlMasterNum());
                detailEntity.setCreatePersonId(vo.getUserId());
                detailEntity.setCreateDate(new Date());
                detailEntity.setCreatePersonName(vo.getUserName());
                deliveryEntity.setFundsControlPic(brokerfundscontrolmasterEntity.getFundsPic());
                deliveryEntity.setIfFundsControlFlag("2");
                transportationDeliveryService.save(deliveryEntity);
                brokerFundsDetailService.save(detailEntity);
        }
    }

    /**
     * 	删除经纪人上传流水明细
     */
    @Override
    @Transactional
    public void deleteBrokerFundsDetail(BrokerFundsDetailQueryVo vo){
            String[] fundsControlDetailIdArr = vo.getFundsControlDetailIdStr().split(",");
            for(int i=0; i < fundsControlDetailIdArr.length; i++){
                    vo.setFundsControlDetailId(Long.parseLong(fundsControlDetailIdArr[i].toString()));
                    brokerFundsDetailService.updateDeliveryFundsFlag(vo.getFundsControlDetailId());
                    brokerFundsDetailService.deleteById(vo.getFundsControlDetailId());
            }
        }

    /**
     * 获取编号
     * @param typeId
     * @return
     */
    public String getSeqNum(String typeId) {
        logger.info("call generate_docu_no pro,typeId:{}",typeId);
        HashMap<String, Object> propMap = new HashMap<String, Object>();
        propMap.put("typeId", typeId);
        propMap.put("seqNum", "");
        mybatisQuery.executePro("transportSettle.getSeqNumPro", propMap);
        String seqNum = (String) propMap.get("seqNum");
        logger.info("call generate_docu_no pro,seqNum:{}",seqNum);
        return seqNum;
    }

}
