package com.brcc.business.creditRepay.repository;

import com.brcc.business.creditRepay.entity.CreditRepayEntity;
import com.brcc.business.creditRepay.vo.CreditRepaySearchQueryVo;
import com.brcc.business.creditRepay.vo.RepayCompanyVo;
import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 授信还款数据操作接口
 * @Auther: gemaochao
 * @Date:Created in 16:43 2018/11/7
 */
public interface ICreditRepayRepository {
    
    /**
     * @Description  返回授信还款查询页面数据
     * @Param [creditRepaySearchQueryVo]
     * @return org.springframework.data.domain.Page<com.brcc.business.creditRepay.entity.CreditRepayEntity>
     **/
    Page<CreditRepayEntity> queryRepay(CreditRepaySearchQueryVo creditRepaySearchQueryVo);

    /**
     * @Description  返回授信还款审核页面数据
     * @Param [creditRepaySearchQueryVo]
     * @return org.springframework.data.domain.Page<com.brcc.business.creditRepay.entity.CreditRepayEntity>
     **/
    Page<CreditRepayEntity> queryRepayAudit(CreditRepaySearchQueryVo creditRepaySearchQueryVo);
    
    /**
     * @Description  返回授信还款公司选项内容
     * @Param [creditRepaySearchQueryVo]
     * @return org.springframework.data.domain.Page<com.brcc.business.creditRepay.vo.RepayCompanyVo>
     **/
    List<RepayCompanyVo> queryRepayCompany(CreditRepaySearchQueryVo creditRepaySearchQueryVo);

    /**
     * @Description  获取还款单据号
     * @Param [typeId]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    Map<String,Object> getSeqNo(Long typeId);

    void proCreditRepay(HashMap<String,Object> param);
}