package com.brcc.business.creditConfig.repository;

import com.brcc.business.creditConfig.entity.CreditConfigEntity;
import com.brcc.business.creditConfig.vo.CreditConfigAddCompanyVo;
import com.brcc.business.creditConfig.vo.CreditConfigQueryVo;
import com.brcc.business.creditConfig.vo.CreditConfigVo;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @Description: 委托方授信管理数据操作接口
 * @Auther: gemaochao
 * @Date:Created in 11:40 2018/10/31
 */
@Repository
public interface ICreditConfigRepositpory {
    
    /**
     * @Description  返回委托方授信查询结果
     * @Param [creditConfigQueryVo]
     * @return org.springframework.data.domain.Page<com.brcc.business.creditConfig.entity.CreditConfigEntity>
     **/
    Page<CreditConfigEntity> queryCreditConfig(CreditConfigQueryVo creditConfigQueryVo);
    
    /**
     * @Description  返回新增委托方授信调价公司名称
     * @Param [creditConfigQueryVo]
     * @return org.springframework.data.domain.Page<com.brcc.business.creditConfig.vo.CreditConfigAddCompanyVo>
     **/
    Page<CreditConfigAddCompanyVo> queryAddAdjustPriceCompanyName(CreditConfigQueryVo creditConfigQueryVo);
    
    void proCreditAmountAdjust(HashMap<String,Object> procMap);
    
    /**
     * @Desc   查询授信配置
     * @Param  configQueryVo
     * @return List<CreditConfigVo>>
     **/
    List<CreditConfigVo> queryCreditConfigList(CreditConfigQueryVo configQueryVo);
    
    /**
     * @Desc   查询授信配置判断货主是否可以发单
     * @Param  configQueryVo
     * @return List<CreditConfigVo>>
     **/
    List<CreditConfigVo> queryCreditConfigStatus(CreditConfigQueryVo configQueryVo);
}