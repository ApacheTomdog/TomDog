package com.brcc.business.creditConfig.repository;

import com.brcc.business.creditConfig.entity.CreditConfigEntity;
import com.brcc.business.creditConfig.vo.CreditConfigAddCompanyVo;
import com.brcc.business.creditConfig.vo.CreditConfigQueryVo;
import com.brcc.business.creditConfig.vo.CreditConfigVo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description: 委托方授信管理数据操作接口
 * @Auther: gemaochao
 * @Date:Created in 11:39 2018/10/31
 */
@Repository
public interface CreditConfigRepository extends JpaRepository<CreditConfigEntity,Long>,ICreditConfigRepositpory {
    
    /**
     * @Description  根据id返回委托方授信信息
     * @Param [creditConfigId]
     * @return com.brcc.business.creditConfig.entity.CreditConfigEntity
     **/
    CreditConfigEntity findByCreditConfigId(Long creditConfigId);
//    /**
//     * @Author gemaochao
//     * @Description //TODO 根据publishCompanyId 及指定状态返回信息
//     * @Date  2018/11/2
//     * @Param [companyId]
//     * @return com.brcc.business.creditConfig.entity.CreditConfigEntity
//     **/
//    CreditConfigEntity findByPublishCompanyIdAndCreditStatus(Long companyId,String status);

    /**
     * @Description  验证指定companyId发单平台是否存在有效授信记录
     * @Param [companyId, status]
     * @return boolean
     **/
    boolean existsByPublishCompanyIdAndCreditStatus(Long companyId,String status);
  
    /**
     * 通过这2个字段定义唯一性
     * @description:
     * @author:陈利
     * @date:2018年11月9日
     * @param companyId
     * @param status
     * @return
     */
    List<CreditConfigEntity> findByPublishCompanyIdAndCreditStatus(Long companyId,String status);
    

    /**
     * @Description  返回指定id授信信息
     * @Param [publishCompanyId]
     * @return com.brcc.business.creditConfig.entity.CreditConfigEntity
     **/
    CreditConfigEntity findByPublishCompanyId(Long publishCompanyId);


}