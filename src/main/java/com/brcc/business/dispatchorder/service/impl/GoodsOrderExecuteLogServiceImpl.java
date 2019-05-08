package com.brcc.business.dispatchorder.service.impl;

import com.brcc.business.dispatchorder.entity.GoodsorderexecutelogEntity;
import com.brcc.business.dispatchorder.repository.GoodsOrderExecuteLogRepository;
import com.brcc.business.dispatchorder.service.GoodsOrderExecuteLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:
 * 日志记录业务逻辑接口实现类
 *
 * @author yushaohua
 * @create 2018-11-29 16:44
 */
@Service
public class GoodsOrderExecuteLogServiceImpl implements GoodsOrderExecuteLogService {

    @Autowired
    private GoodsOrderExecuteLogRepository goodsOrderExecuteLogRepository;

    @Override
    public GoodsorderexecutelogEntity save(GoodsorderexecutelogEntity entity) {
        return goodsOrderExecuteLogRepository.save(entity);
    }
}