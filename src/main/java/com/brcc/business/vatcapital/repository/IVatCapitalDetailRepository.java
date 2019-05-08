package com.brcc.business.vatcapital.repository;

import com.brcc.business.vatcapital.entity.VatcapitaldetailEntity;
import com.brcc.business.vatcapital.vo.VatcapitaldetailQueryVo;
import com.brcc.business.vatcompanyrefund.vo.VatCompanyRefundQueryVo;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 * @Auther: gemaochao
 * @Date:Created in 13:17 2018/11/16
 */
public interface IVatCapitalDetailRepository {

    
    /**
     * @Description  返回资金流水详情页面数据
     * @Param [vo]
     * @return org.springframework.data.domain.Page<com.brcc.business.vatcapital.vo.VatcapitaldetailQueryVo>
     **/
    Page<VatcapitaldetailQueryVo> queryForDetail(VatcapitaldetailQueryVo vo);

    List<VatcapitaldetailQueryVo> excelForMaster(VatcapitaldetailQueryVo vo);
}
