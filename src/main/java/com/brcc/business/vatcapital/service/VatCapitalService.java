package com.brcc.business.vatcapital.service;

import com.brcc.business.vatcapital.entity.VatcapitaldetailEntity;
import com.brcc.business.vatcapital.entity.VatcapitalmasterEntity;
import com.brcc.business.vatcapital.vo.VatcapitaldetailQueryVo;
import com.brcc.business.vatcompanyrecharge.entity.VatcompanyrechargeEntity;
import com.brcc.business.vatcompanyrefund.vo.VatCompanyRefundQueryVo;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description:
 * @Auther: gemaochao
 * @Date:Created in 14:15 2018/11/16
 */
public interface VatCapitalService {

    
    /**
     * @Description  在vatcapitaldetail新增记录
     * @Param [vo]
     * @return com.brcc.business.vatcapital.entity.VatcapitaldetailEntity
     **/
    VatcapitaldetailEntity saveDetail(VatcapitaldetailEntity vo);

    VatcapitalmasterEntity queryMaster(Long carryId,Long clientId,String platformId,BigDecimal totalUserAmount);


    VatcapitalmasterEntity saveMaster(VatcapitalmasterEntity vo);

    /**
     * @Description  返回添加退款委托公司选项数据
     * @Param [vo]
     * @return java.util.List<com.brcc.business.vatcapital.entity.VatcapitalmasterEntity>
     **/
    List<VatcapitalmasterEntity> queryCompanyName(VatCompanyRefundQueryVo vo);

    /**
     * @Description  返回资金流水详情页面数据
     * @Param [vo]
     * @return org.springframework.data.domain.Page<com.brcc.business.vatcapital.vo.VatcapitaldetailQueryVo>
     **/
    Page<VatcapitaldetailQueryVo> queryForDetail(VatcapitaldetailQueryVo vo);

    /**
     * @Description  返回承运方资金管理充值总金额
     * @Param [vo]
     * @return java.util.List<com.brcc.business.vatcapital.entity.VatcapitalmasterEntity>
     **/
    VatcapitalmasterEntity queryTotalInAmount(VatCompanyRefundQueryVo vo);

    /**
     * @Description  返回承运方资金管理页面数据
     * @Param [vo]
     * @return org.springframework.data.domain.Page<com.brcc.business.vatcapital.entity.VatcapitalmasterEntity>
     **/
    Page<VatcapitalmasterEntity> queryForCarry(VatCompanyRefundQueryVo vo);

    List<VatcapitaldetailQueryVo> excelForMaster(VatcapitaldetailQueryVo vo);

    /**
     * @Description  返回委托方资金管理页面数据
     * @Param [vo]
     * @return org.springframework.data.domain.Page<com.brcc.business.vatcapital.entity.VatcapitalmasterEntity>
     **/
    Page<VatcapitalmasterEntity> queryForClient(VatCompanyRefundQueryVo vo);

    /**
     * 查询资金帐信息(根据委托clientId和承运carrId)
     * @param vo
     * @return VatcapitalmasterEntity
     */
	VatcapitalmasterEntity queryCompanyCapital(VatCompanyRefundQueryVo vo);

	Integer updateVatcapitalMaster(BigDecimal bankAmount,Long clientId,Long carryId,String platformId);
}
