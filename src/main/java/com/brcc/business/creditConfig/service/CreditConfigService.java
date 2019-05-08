package com.brcc.business.creditConfig.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.brcc.business.creditAmountAdjust.entity.CreditAmountAdjustEntity;
import com.brcc.business.creditConfig.entity.CreditConfigEntity;
import com.brcc.business.creditConfig.vo.CreditConfigAddCompanyVo;
import com.brcc.business.creditConfig.vo.CreditConfigModifyVo;
import com.brcc.business.creditConfig.vo.CreditConfigQueryVo;
import com.brcc.business.creditConfig.vo.CreditConfigVo;

/**
 * @Description: 委托方授信管理逻辑接口
 * @Auther: gemaochao
 * @Date:Created in 13:51 2018/10/31
 */
@Service
public interface CreditConfigService {
    
    /**
     * @Description  返回委托方授信管理列表
     * @Param [creditConfigQueryVo]
     * @return org.springframework.data.domain.Page<com.brcc.business.creditConfig.entity.CreditConfigEntity>
     **/
     Page<CreditConfigEntity> queryCreditConfig(CreditConfigQueryVo creditConfigQueryVo);


     /**
      * @Description  根据id返回委托方授信信息
      * @Param [creditConfigId]
      * @return com.brcc.business.creditConfig.entity.CreditConfigEntity
      **/
     CreditConfigEntity findById(String creditConfigId);

     /**
      * @Description  保存委托方授信修改信息
      * @Param [creditConfigEntity]
      * @return com.brcc.business.creditConfig.entity.CreditConfigEntity
      **/
     CreditConfigEntity saveConfigEdit(CreditConfigEntity creditConfigEntity);

     /**
      * @Description  修改指定id委托方授信状态
      * @Param [creditConfigModifyVo]
      * @return com.brcc.business.creditConfig.entity.CreditConfigEntity
      **/
     CreditConfigEntity changeCreditStatus(CreditConfigModifyVo creditConfigModifyVo);


     /**
      * @Description  修改指定id委托方授信可发单状态
      * @Param [creditConfigModifyVo]
      * @return com.brcc.business.creditConfig.entity.CreditConfigEntity
      **/
     CreditConfigEntity changeCreditFdStatus(CreditConfigModifyVo creditConfigModifyVo);


     /**
      * @Description  返回委托方新增授信公司选项数据
      * @Param [creditConfigQueryVo]
      * @return org.springframework.data.domain.Page<com.brcc.business.creditConfig.vo.CreditConfigAddCompanyVo>
      **/
    Page<CreditConfigAddCompanyVo> creditAddCompany(CreditConfigQueryVo creditConfigQueryVo);


    /**
     * @Description  返回委托方授信明细
     * @Param [creditConfigQueryVo]
     * @return org.springframework.data.domain.Page<com.brcc.business.creditAmountAdjust.entity.CreditAmountAdjustEntity>
     **/
    Page<CreditAmountAdjustEntity> findCreditAmountAdjust(CreditConfigQueryVo creditConfigQueryVo);


//    /**
//     * @Author gemaochao
//     * @Description //TODO 返回指定publishCompanyId 且授信状态委托方授信信息
//     * @Date  2018/11/2
//     * @Param [companyId]
//     * @return com.brcc.business.creditConfig.entity.CreditConfigEntity
//     **/
//    CreditConfigEntity findByPublishCompanyId(Long companyId);
    /**
     * @Description  验证指定companyId发单平台是否存在有效授信记录
     * @Param [companyId]
     * @return boolean
     **/
    boolean exitConfig(Long companyId);
    /**
     * @Description  保存新增委托方授信
     * @Param [creditConfigEntity]
     * @return com.brcc.business.creditConfig.entity.CreditConfigEntity
     **/
    CreditConfigEntity addConfigSave(CreditConfigEntity creditConfigEntity);

    /**
     * @Description  返回新增委托方授信调价公司名称
     * @Param [creditConfigQueryVo]
     * @return org.springframework.data.domain.Page<com.brcc.business.creditConfig.vo.CreditConfigAddCompanyVo>
     **/
    Page<CreditConfigAddCompanyVo> queryAddAdjustPriceCompanyName(CreditConfigQueryVo creditConfigQueryVo);
    
    /**
     * 
     * @description:
     * @author:陈利
     * @date:2018年11月9日
     * @param companyId
     * @param status
     * @return
     */
    CreditConfigEntity queryByPublishCompanyIdAndCreditStatus(Long companyId,String status);
    

    /**
     * @Description  返回指定id授信信息
     * @Param [publishCompanyId]
     * @return com.brcc.business.creditConfig.entity.CreditConfigEntity
     **/
    CreditConfigEntity findByPublishCompanyId(Long publishCompanyId);
    
    /**
     * 处理资金帐过程
     * @description:
     * @author:陈利
     * @date:2018年11月13日
     * @param procMap
     */
    void proCreditAmountAdjust(HashMap<String, Object> procMap);

    /**
     * 判断是否有授信配置
     * @param configQueryVo
     */
	List<CreditConfigVo> queryIsCredit(CreditConfigQueryVo configQueryVo);
	
	/**
     * 查询货主下如果有资金帐是否可以发单
     * @param configQueryVo
     */
	List<CreditConfigVo> queryCreditConfigStatus(CreditConfigQueryVo configQueryVo);

   
	/**
	 * @Description  保存CreditConfig
	 * @Param [entity]
	 * @return com.brcc.business.creditConfig.entity.CreditConfigEntity
	 **/
	CreditConfigEntity justSave(CreditConfigEntity entity);
}