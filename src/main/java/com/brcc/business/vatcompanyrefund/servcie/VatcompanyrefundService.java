package com.brcc.business.vatcompanyrefund.servcie;

import com.brcc.business.vatcapital.entity.VatcapitalmasterEntity;
import com.brcc.business.vatcompanyrefund.entity.VatcompanyrefundEntity;
import com.brcc.business.vatcompanyrefund.vo.VatCompanyRefundQueryVo;
import org.springframework.data.domain.Page;

import java.util.List;


/**
 * @Description: 委托方退款审核逻辑接口
 * @Auther: gemaochao
 * @Date:Created in 10:09 2018/11/16
 */
public interface VatcompanyrefundService {

    Page<VatcompanyrefundEntity> queryRefund(VatCompanyRefundQueryVo vo);

    
    /**
     * @Description  委托方退款审核通过/不通过
     * @Param [vo]
     * @return com.brcc.business.vatcompanyrefund.entity.VatcompanyrefundEntity
     **/
    VatcompanyrefundEntity audit(VatCompanyRefundQueryVo vo);

    /**
     * @Description  返回添加退款委托公司选项数据
     * @Param [vo]
     * @return java.util.List<com.brcc.business.vatcapital.entity.VatcapitalmasterEntity>
     **/
    List<VatcapitalmasterEntity> queryCompanyName(VatCompanyRefundQueryVo vo);
    /**
     * @Description  返回承运方退款申请页面数据
     * @Param [vo]
     * @return org.springframework.data.domain.Page<com.brcc.business.vatcompanyrefund.entity.VatcompanyrefundEntity>
     **/
    Page<VatcompanyrefundEntity> queryForClient(VatCompanyRefundQueryVo vo);
    
    /**
     * @Description  保存新增退款信息
     * @Param [entity]
     * @return com.brcc.business.vatcompanyrefund.entity.VatcompanyrefundEntity
     **/
    VatcompanyrefundEntity addRefundSave(VatcompanyrefundEntity entity);

    /**
     * 查询资金帐信息(根据委托clientId和承运carrId)
     * @param vo
     * @return VatcapitalmasterEntity
     */
	VatcapitalmasterEntity queryCompanyCapital(VatCompanyRefundQueryVo vo);
}
