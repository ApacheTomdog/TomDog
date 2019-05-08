package com.brcc.business.goodsordermjk.service.impl;

import com.brcc.business.goodsordermjk.entity.GoodsordermjkLogEntity;
import com.brcc.business.goodsordermjk.repository.GoodsordermjkLogRepository;
import com.brcc.business.goodsordermjk.service.GoodsordermjkLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Desc: 外部接口货源日志逻辑接口实现
 * @author: ywb
 * @date: 2019-04-23
 */
@Transactional
@Service
public class GoodsordermjkLogServiceImpl implements GoodsordermjkLogService {

    Logger logger = LoggerFactory.getLogger(GoodsordermjkLogServiceImpl.class);

    @Autowired
    GoodsordermjkLogRepository goodsordermjkLogRepository;

    @Override
    public void save(GoodsordermjkLogEntity goodsordermjkLogEntity) {
        goodsordermjkLogRepository.save(goodsordermjkLogEntity);
    }
}
