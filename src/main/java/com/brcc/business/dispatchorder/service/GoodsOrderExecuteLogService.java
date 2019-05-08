package com.brcc.business.dispatchorder.service;

import com.brcc.business.dispatchorder.entity.GoodsorderexecutelogEntity;

/**
 * 描述:
 * 日志记录业务逻辑接口类
 *
 * @author yushaohua
 * @create 2018-11-29 16:44
 */
public interface GoodsOrderExecuteLogService {

    /**
     * 保存记录
     * @param entity
     * @return
     */
    GoodsorderexecutelogEntity save(GoodsorderexecutelogEntity entity);

}