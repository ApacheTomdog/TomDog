package com.brcc.business.vatcapital.repository;

import com.brcc.business.vatcapital.entity.VatcapitalmasterEntity;
import com.brcc.business.vatcompanyrefund.entity.VatcompanyrefundEntity;
import com.brcc.business.vatcompanyrefund.vo.VatCompanyRefundQueryVo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Description:
 * @Auther: gemaochao
 * @Date:Created in 11:41 2018/11/16
 */
public interface IVatCapitalMasterRepository {

    /**
     * @Description  返回添加退款委托公司选项数据
     * @Param [vo]
     * @return java.util.List<com.brcc.business.vatcapital.entity.VatcapitalmasterEntity>
     **/
    List<VatcapitalmasterEntity>  queryCompanyName(VatCompanyRefundQueryVo vo);

    /**
     * @Description  返回承运方资金管理充值总金额
     * @Param [vo]
     * @return java.util.List<com.brcc.business.vatcapital.entity.VatcapitalmasterEntity>
     **/
    List<VatcapitalmasterEntity> queryTotalInAmount(VatCompanyRefundQueryVo vo);

    /**
     * @Description  返回承运方资金管理页面数据
     * @Param [vo]
     * @return org.springframework.data.domain.Page<com.brcc.business.vatcapital.entity.VatcapitalmasterEntity>
     **/
    Page<VatcapitalmasterEntity> queryForCarry(VatCompanyRefundQueryVo vo);
    
    /**
     * @Description  返回委托方资金管理页面数据
     * @Param [vo]
     * @return org.springframework.data.domain.Page<com.brcc.business.vatcapital.entity.VatcapitalmasterEntity>
     **/
    Page<VatcapitalmasterEntity> queryForClient(VatCompanyRefundQueryVo vo);
}
