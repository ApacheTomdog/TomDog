package com.brcc.business.creditRepay.service;

import com.brcc.business.company.entity.CompanyEntity;
import com.brcc.business.creditRepay.entity.CreditRepayEntity;
import com.brcc.business.creditRepay.vo.CreditRepaySearchQueryVo;
import com.brcc.business.creditRepay.vo.RepayCompanyVo;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * @Description: 授信还款逻辑操作接口
 * @Auther: gemaochao
 * @Date:Created in 16:46 2018/11/7
 */
public interface CreditRepayService {
    
    /**
     * @Description  返回授信还款查询界面数据
     * @Param [creditRepaySearchQueryVo]
     * @return org.springframework.data.domain.Page<com.brcc.business.creditRepay.entity.CreditRepayEntity>
     **/
    Page<CreditRepayEntity> queryRepay(CreditRepaySearchQueryVo creditRepaySearchQueryVo);

    /**
     * @Description  返回授信还款审核界面数据
     * @Param [creditRepaySearchQueryVo]
     * @return org.springframework.data.domain.Page<com.brcc.business.creditRepay.entity.CreditRepayEntity>
     **/
    Page<CreditRepayEntity> queryRepayAudit(CreditRepaySearchQueryVo creditRepaySearchQueryVo);
    
    /**
     * @Description  返回授信还款公司选项名称
     * @Param [creditRepaySearchQueryVo]
     * @return org.springframework.data.domain.Page<com.brcc.business.creditRepay.vo.RepayCompanyVo>
     **/
    List<RepayCompanyVo> queryRepayCompany(CreditRepaySearchQueryVo creditRepaySearchQueryVo);

    /**
     * @Description  修改授信还款状态
     * @Param [creditRepaySearchQueryVo]
     * @return com.brcc.business.creditRepay.entity.CreditRepayEntity
     **/
    CreditRepayEntity changeRepayStatus(CreditRepaySearchQueryVo creditRepaySearchQueryVo);

    /**
     * @Description  保存新增授信还款信息
     * @Param [creditRepaySearchQueryVo]
     * @return com.brcc.business.creditRepay.entity.CreditRepayEntity
     **/
    CreditRepayEntity addRepaySave(CreditRepayEntity creditRepayEntity);

    /**
     * @Description  获取还款单据号
     * @Param [typeId]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    String getSeqNo(Long typeId);
}