package com.brcc.business.vatcapital.service.impl;

import com.brcc.business.vatcapital.entity.VatcapitaldetailEntity;
import com.brcc.business.vatcapital.repository.VatCapitalDetailRepository;
import com.brcc.business.vatcapital.service.VatCapitalDetailService;
import com.brcc.business.vatcapital.vo.VatcapitaldetailQueryVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Auther: gemaochao
 * @Date:Created in 10:50 2018/11/23
 */
@Service
public class VatCapitalDetailServiceImpl implements VatCapitalDetailService {

    @Autowired
    VatCapitalDetailRepository vatCapitalDetailRepository;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<VatcapitaldetailQueryVo> excelForMaster(VatcapitaldetailQueryVo vo) {
        return vatCapitalDetailRepository.excelForMaster(vo);
    }


    @Override
    public Page<VatcapitaldetailQueryVo> queryForDetail(VatcapitaldetailQueryVo vo) {
        return vatCapitalDetailRepository.queryForDetail(vo);
    }

    @Override
    public VatcapitaldetailEntity save(VatcapitaldetailEntity vo) {
        return vatCapitalDetailRepository.save(vo);
    }


	@Override
	public Integer updateIfInvoiceFlag(Long invoiceSplitId, String platformId, String ifInvoice, String oldIfInvoice) {
		Integer n = vatCapitalDetailRepository.updateIfInvoiceFlag(invoiceSplitId, platformId, ifInvoice, oldIfInvoice);
		return n;
	}
}
