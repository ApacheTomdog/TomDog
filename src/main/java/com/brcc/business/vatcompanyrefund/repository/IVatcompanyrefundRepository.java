package com.brcc.business.vatcompanyrefund.repository;

import com.brcc.business.vatcompanyrefund.entity.VatcompanyrefundEntity;
import com.brcc.business.vatcompanyrefund.vo.VatCompanyRefundQueryVo;
import org.springframework.data.domain.Page;

/**
 * @Description:
 * @Auther: gemaochao
 * @Date:Created in 10:07 2018/11/16
 */
public interface IVatcompanyrefundRepository {

    /**
     * @Description  返回委托方退款审核页面数据
     * @Param [vo]
     * @return org.springframework.data.domain.Page<com.brcc.business.vatcompanyrefund.entity.VatcompanyrefundEntity>
     **/
    Page<VatcompanyrefundEntity> queryRefund(VatCompanyRefundQueryVo vo);

    /**
     * @Description  返回承运方退款申请页面数据
     * @Param [vo]
     * @return org.springframework.data.domain.Page<com.brcc.business.vatcompanyrefund.entity.VatcompanyrefundEntity>
     **/
    Page<VatcompanyrefundEntity> queryForClient(VatCompanyRefundQueryVo vo);
}
