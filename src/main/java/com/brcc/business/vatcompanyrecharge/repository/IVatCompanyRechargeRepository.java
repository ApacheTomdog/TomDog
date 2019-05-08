package com.brcc.business.vatcompanyrecharge.repository;

import com.brcc.business.vatcompanyrecharge.entity.VatcompanyrechargeEntity;
import com.brcc.business.vatcompanyrecharge.vo.VatCompanyRechargeQueryVo;
import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.List;

/**
 * @Description: 委托方充值申请数据操作接口
 * @Auther: gemaochao
 * @Date:Created in 16:28 2018/11/13
 */
public interface IVatCompanyRechargeRepository {


    /**
     * @Description  返回委托方充值申请页面数据
     * @Param [vo]
     * @return org.springframework.data.domain.Page<com.brcc.business.vatcompanyrecharge.entity.VatcompanyrechargeEntity>
     **/
    Page<VatcompanyrechargeEntity> queryRecharge(VatCompanyRechargeQueryVo vo);


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
    List<VatCompanyRechargeQueryVo> queryTotalInAmount(VatCompanyRechargeQueryVo vo);

    List<VatcompanyrechargeEntity> queryForDetail(VatCompanyRechargeQueryVo vo);

    List<VatCompanyRechargeQueryVo> queryForExcel(VatCompanyRechargeQueryVo vo);

    void capitalDetailPro (HashMap para);
}