package com.brcc.business.vatcompanyrecharge.service;

import com.brcc.business.flow.vo.VatflowdetailCompanyNameVo;
import com.brcc.business.vatcapital.entity.VatcapitalmasterEntity;
import com.brcc.business.vatcapital.vo.VatcapitaldetailQueryVo;
import com.brcc.business.vatcompanyRechargeBusiness.entity.VatcompanyRechargeBusinessEntity;
import com.brcc.business.vatcompanyRechargeBusiness.vo.CompanyNameQueryVo;
import com.brcc.business.vatcompanyrecharge.entity.VatcompanyrechargeEntity;
import com.brcc.business.vatcompanyrecharge.vo.VatCompanyRechargeQueryVo;
import com.brcc.business.vatcompanyrefund.vo.VatCompanyRefundQueryVo;
import com.esteel.common.controller.WebReturnMessage;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Description: 委托方充值申请
 * @Auther: gemaochao
 * @Date:Created in 16:35 2018/11/13
 */
public interface VatCompanyRechargeService {


    /**
     * @Description  返回委托方充值申请页面数据
     * @Param [vo]
     * @return org.springframework.data.domain.Page<com.brcc.business.vatcompanyrecharge.entity.VatcompanyrechargeEntity>
     **/
    Page<VatcompanyrechargeEntity> queryRecharge(VatCompanyRechargeQueryVo vo);

    /**
     * @Description  查询公司是否业务分离
     * @Param [platformId, clientId]
     * @return java.lang.String
     **/
    String verifyIfParts (String platformId,Long clientId);

    /**
     * @Description  返回当公司非业务分离时添加充值承运公司信息
     * @Param [platformId, clientId]
     * @return java.util.List<com.brcc.business.vatflow.vo.VatflowdetailQueryVo>
     **/
    List<VatflowdetailCompanyNameVo> queryCompanyNameN(VatCompanyRechargeQueryVo vo);

    /**
     * @Description  查询业务分离公司充值承运公司信息
     * @Param [clientId, platformId]
     * @return java.util.List<com.brcc.business.vatcompanyRechargeBusiness.vo.CompanyNameQueryVo>
     **/
    List<CompanyNameQueryVo> queryCompanyNameY(Long clientId, String platformId);

    /**
     * @Description  保存新增充值
     * @Param [entity]
     * @return com.brcc.business.vatcompanyrecharge.entity.VatcompanyrechargeEntity
     **/
    VatcompanyrechargeEntity addRechargeSave(VatcompanyrechargeEntity entity);


    /**
     * @Description  更新business表信息
     * @Param [entity]
     * @return void
     **/
    VatcompanyRechargeBusinessEntity flushBusiness(VatcompanyrechargeEntity entity);

    /**
     * @Description  Excel导出
     * @Param [vo]
     * @return java.util.List<com.brcc.business.vatcompanyrecharge.entity.VatcompanyrechargeEntity>
     **/
    List<VatCompanyRechargeQueryVo> queryRechargeForExcel(VatCompanyRechargeQueryVo vo);

    /**
     * @Description  返回承运方充值审核页面数据
     * @Param [vo]
     * @return org.springframework.data.domain.Page<com.brcc.business.vatcompanyrecharge.entity.VatcompanyrechargeEntity>
     **/
    Page<VatcompanyrechargeEntity> queryAuditRecharge(VatCompanyRechargeQueryVo vo);

    /**
     * @Description  返回充值总金额
     * @Param [vo]
     * @return java.util.List<com.brcc.business.vatcompanyrecharge.vo.VatCompanyRechargeQueryVo>
     **/
    VatCompanyRechargeQueryVo queryTotalInAmount(VatCompanyRechargeQueryVo vo);
    
    /**
     * @Description  承运方充值审核操作
     * @Param [entity]
     * @return com.brcc.business.vatcompanyrecharge.entity.VatcompanyrechargeEntity
     **/
    VatcompanyrechargeEntity auditRecharge(VatcompanyrechargeEntity entity);
    /**
     * @Description  承运方充值审核单审核操作
     * @Param [entity]
     * @return
     **/
    void strikeBalance(VatcompanyrechargeEntity entity);

    /**
     * @Description  返回充值审核单信息
     * @Param [vo]
     * @return com.brcc.business.vatcompanyrecharge.entity.VatcompanyrechargeEntity
     **/
    VatcompanyrechargeEntity queryForDetail(VatCompanyRechargeQueryVo vo);

    
    /**
     * @Description  返回excel表导出数据
     * @Param [vo]
     * @return java.util.List<com.brcc.business.vatcompanyrecharge.entity.VatcompanyrechargeEntity>
     **/
    List<VatCompanyRechargeQueryVo> queryForExcel(VatCompanyRechargeQueryVo vo);

    /**
     * @Description  返回资金流水详情页面数据
     * @Param [vo]
     * @return org.springframework.data.domain.Page<com.brcc.business.vatcapital.vo.VatcapitaldetailQueryVo>
     **/
    Page<VatcapitaldetailQueryVo> queryMasterForDetail(VatcapitaldetailQueryVo vo);

    /**
     * @Description  返回承运方资金管理充值总金额
     * @Param [vo]
     * @return java.util.List<com.brcc.business.vatcapital.entity.VatcapitalmasterEntity>
     **/
    VatcapitalmasterEntity queryMasterTotalInAmount(VatCompanyRefundQueryVo vo);

    /**
     * @Description  返回承运方资金管理页面数据
     * @Param [vo]
     * @return org.springframework.data.domain.Page<com.brcc.business.vatcapital.entity.VatcapitalmasterEntity>
     **/
    Page<VatcapitalmasterEntity> queryMasterForCarry(VatCompanyRefundQueryVo vo);

    List<VatcapitaldetailQueryVo> excelForMaster(VatcapitaldetailQueryVo vo);

    /**
     * @Description  返回委托方资金管理页面数据
     * @Param [vo]
     * @return org.springframework.data.domain.Page<com.brcc.business.vatcapital.entity.VatcapitalmasterEntity>
     **/
    Page<VatcapitalmasterEntity> queryMasterForClient(VatCompanyRefundQueryVo vo);

    /**
     * 作废未审核状态的委托方充值申请
     * @param vatCompanyRechargeId
     * @return
     */
    WebReturnMessage cancel(Long vatCompanyRechargeId);
}