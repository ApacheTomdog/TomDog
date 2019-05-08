package com.brcc.business.goodsorderToPayInfo.repository.impl;

import com.brcc.business.goodsorderToPayInfo.entity.GoodsorderToPayInfoEntity;
import com.brcc.business.goodsorderToPayInfo.repository.IGoodsorderToPayInfoRepository;
import com.brcc.business.goodsorderToPayInfo.vo.GoodsorderToPayInfoQueryVo;
import com.esteel.common.dao.PageQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 收款账号配置数据操作类
 * @Auther: gemaochao
 * @Date:Created in 14:20 2018/11/12
 */
public class GoodsorderToPayInfoRepositoryImpl implements IGoodsorderToPayInfoRepository {

    @Autowired
    PageQuery pageQuery;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Page<GoodsorderToPayInfoEntity> queryPayInfo(GoodsorderToPayInfoQueryVo goodsorderToPayInfoQueryVo) {
        List<Object> arg = new ArrayList<>();
        StringBuffer sql = new StringBuffer("SELECT * FROM goodsorder_to_pay_info a where   a.company_id=? ");
        arg.add(goodsorderToPayInfoQueryVo.getCompanyId());
        sql.append("    AND  a.platform_id=?");
        arg.add(goodsorderToPayInfoQueryVo.getPlatformId());
        if (!(StringUtils.isEmpty(goodsorderToPayInfoQueryVo.getBankCardOwner()))){
            sql.append("    AND a.bank_card_owner like ?");
            arg.add("%"+goodsorderToPayInfoQueryVo.getBankCardOwner()+"%");
        }
        if (!(StringUtils.isEmpty(goodsorderToPayInfoQueryVo.getPublishId()))){
            sql.append("    AND a.publish_id like ?");
            arg.add("%"+goodsorderToPayInfoQueryVo.getPublishId()+"%");
        }
        if (!(StringUtils.isEmpty(goodsorderToPayInfoQueryVo.getBankNum()))){
            sql.append("    AND a.bank_num like ?");
            arg.add("%"+goodsorderToPayInfoQueryVo.getBankNum()+"%");
        }
        return pageQuery.query(sql.toString(),arg,goodsorderToPayInfoQueryVo,GoodsorderToPayInfoEntity.class);
    }












}
