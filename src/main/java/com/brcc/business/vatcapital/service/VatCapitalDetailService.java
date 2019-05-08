package com.brcc.business.vatcapital.service;

import com.brcc.business.vatcapital.entity.VatcapitaldetailEntity;
import com.brcc.business.vatcapital.vo.VatcapitaldetailQueryVo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Description:
 * @Auther: gemaochao
 * @Date:Created in 10:50 2018/11/23
 */
public interface VatCapitalDetailService {

    /**
     * @Description  返回资金流水详情页面数据
     * @Param [vo]
     * @return org.springframework.data.domain.Page<com.brcc.business.vatcapital.vo.VatcapitaldetailQueryVo>
     **/
    Page<VatcapitaldetailQueryVo> queryForDetail(VatcapitaldetailQueryVo vo);

    List<VatcapitaldetailQueryVo> excelForMaster(VatcapitaldetailQueryVo vo);


    VatcapitaldetailEntity save(VatcapitaldetailEntity vo);

    /**
     * 更新资金明细表上的开票标记
     * @param invoiceSplitId
     * @param platformId
     * @param ifInvoice
     * @param oldIfInvoice 
     * @return
     */
	Integer updateIfInvoiceFlag(Long invoiceSplitId, String platformId, String ifInvoice, String oldIfInvoice);
}
