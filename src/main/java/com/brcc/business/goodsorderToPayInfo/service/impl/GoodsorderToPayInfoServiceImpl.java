package com.brcc.business.goodsorderToPayInfo.service.impl;

import com.brcc.business.bank.entity.BanksEntity;
import com.brcc.business.bank.service.BanksService;
import com.brcc.business.creditConfig.vo.CreditConfigAddCompanyVo;
import com.brcc.business.goodsorderToPayInfo.entity.GoodsorderToPayInfoEntity;
import com.brcc.business.goodsorderToPayInfo.repository.GoodsorderToPayInfoRepository;
import com.brcc.business.goodsorderToPayInfo.service.GoodsorderToPayInfoService;
import com.brcc.business.goodsorderToPayInfo.vo.GoodsorderToPayInfoQueryVo;
import com.brcc.business.goodsorderm.service.GoodsordermService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Description: 收款账号配置逻辑
 * @Auther: gemaochao
 * @Date:Created in 14:24 2018/11/12
 */
@Service
public class GoodsorderToPayInfoServiceImpl implements GoodsorderToPayInfoService {


    @Autowired
    GoodsorderToPayInfoRepository goodsorderToPayInfoRepository;

    @Autowired
    BanksService banksService;

    @Autowired
    GoodsordermService goodsordermService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Page<GoodsorderToPayInfoEntity> queryPayInfo(GoodsorderToPayInfoQueryVo goodsorderToPayInfoQueryVo) {
        return goodsorderToPayInfoRepository.queryPayInfo(goodsorderToPayInfoQueryVo);
    }

    @Override
    public GoodsorderToPayInfoEntity addPayInfo(GoodsorderToPayInfoQueryVo vo) {

        logger.info("add payInfo save,bankCardOwner:{},companyId:{}",vo.getBankCardOwner(),vo.getCompanyId());

        GoodsorderToPayInfoEntity goodsorderToPayInfoEntity = new GoodsorderToPayInfoEntity();
        //组装对象
        goodsorderToPayInfoEntity.setCompanyId(vo.getCompanyId());
        goodsorderToPayInfoEntity.setPublishId(vo.getPublishId());
        goodsorderToPayInfoEntity.setBankName(vo.getBankName());
        goodsorderToPayInfoEntity.setBankNum(vo.getBankNum());
        goodsorderToPayInfoEntity.setBankCardOwner(vo.getBankCardOwner());
        goodsorderToPayInfoEntity.setMobile(vo.getMobile());
        goodsorderToPayInfoEntity.setCreateDate(vo.getCreateDate());
        goodsorderToPayInfoEntity.setCreatePerson(vo.getCreatePerson());
        goodsorderToPayInfoEntity.setUpdateDate(vo.getUpdateDate());
        goodsorderToPayInfoEntity.setUpdatePerson(vo.getUpdatePerson());
        goodsorderToPayInfoEntity.setPlatformId(vo.getPlatformId());
        DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //HH表示24小时制；
        goodsorderToPayInfoEntity.setRemark(vo.getCreatePerson()+"在"+dFormat.format(vo.getCreateDate())+"创建了此货源单号收款账号");
        return goodsorderToPayInfoRepository.save(goodsorderToPayInfoEntity);
    }


    @Override
    public List<CreditConfigAddCompanyVo> queryBankName(BanksEntity banksEntity) {
        return banksService.queryBankName(banksEntity);
    }

    @Override
    public GoodsorderToPayInfoEntity editInfoSave(GoodsorderToPayInfoEntity goodsorderToPayInfoEntity) {

        logger.info("edit payInfo save,id:{}",goodsorderToPayInfoEntity.getSeqId());

        GoodsorderToPayInfoEntity vo  =  goodsorderToPayInfoRepository.findBySeqId(goodsorderToPayInfoEntity.getSeqId());
        vo.setBankName(goodsorderToPayInfoEntity.getBankName());
        vo.setBankNum(goodsorderToPayInfoEntity.getBankNum());
        vo.setBankCardOwner(goodsorderToPayInfoEntity.getBankCardOwner());
        vo.setMobile(goodsorderToPayInfoEntity.getMobile());
        vo.setUpdateDate(goodsorderToPayInfoEntity.getUpdateDate());
        vo.setUpdatePerson(goodsorderToPayInfoEntity.getUpdatePerson());
        DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //HH表示24小时制；
        vo.setRemark(goodsorderToPayInfoEntity.getUpdatePerson()+"在"+dFormat.format(goodsorderToPayInfoEntity.getUpdateDate())+"维护了此货源单号收款账号信息");
        return goodsorderToPayInfoRepository.save(vo);
    }

    @Override
    public GoodsorderToPayInfoEntity findById(GoodsorderToPayInfoQueryVo goodsorderToPayInfoQueryVo) {
        return goodsorderToPayInfoRepository.findBySeqId(goodsorderToPayInfoQueryVo.getSeqId());
    }

    @Override
    @Transactional
    public void deleteInfo(GoodsorderToPayInfoQueryVo goodsorderToPayInfoQueryVo){
        goodsorderToPayInfoRepository.deleteBySeqId(goodsorderToPayInfoQueryVo.getSeqId());
    }

    @Override
    public Long verifyPayInfo(GoodsorderToPayInfoQueryVo goodsorderToPayInfoQueryVo) {
        return goodsorderToPayInfoRepository.verifyPayInfo(goodsorderToPayInfoQueryVo.getCompanyId(),goodsorderToPayInfoQueryVo.getPlatformId(),goodsorderToPayInfoQueryVo.getPublishId());
    }

    @Override
    public String checkStatus(GoodsorderToPayInfoQueryVo goodsorderToPayInfoQueryVo) {
        return goodsordermService.checkStatus(goodsorderToPayInfoQueryVo.getPlatformId(),goodsorderToPayInfoQueryVo.getPublishId());
    }

    @Override
    public Long verifyPublishId(GoodsorderToPayInfoQueryVo goodsorderToPayInfoQueryVo) {
        return goodsordermService.verifyPublishId(goodsorderToPayInfoQueryVo.getCompanyId(),goodsorderToPayInfoQueryVo.getUserId(),goodsorderToPayInfoQueryVo.getPlatformId(),goodsorderToPayInfoQueryVo.getPublishId());
    }
}
