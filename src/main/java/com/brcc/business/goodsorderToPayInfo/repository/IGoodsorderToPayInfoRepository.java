package com.brcc.business.goodsorderToPayInfo.repository;

import com.brcc.business.goodsorderToPayInfo.entity.GoodsorderToPayInfoEntity;
import com.brcc.business.goodsorderToPayInfo.vo.GoodsorderToPayInfoQueryVo;
import org.springframework.data.domain.Page;

/**
 * @Description: 收款账号配置数据操作接口
 * @Auther: gemaochao
 * @Date:Created in 14:21 2018/11/12
 */
public interface IGoodsorderToPayInfoRepository {
    
    /**
     * @Description  返回收款账号配置页面数据
     * @Param [goodsorderToPayInfoQueryVo]
     * @return org.springframework.data.domain.Page<com.brcc.business.goodsorderToPayInfo.entity.GoodsorderToPayInfoEntity>
     **/
    Page<GoodsorderToPayInfoEntity> queryPayInfo(GoodsorderToPayInfoQueryVo goodsorderToPayInfoQueryVo);
}