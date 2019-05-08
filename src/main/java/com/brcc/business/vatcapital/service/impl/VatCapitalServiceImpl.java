package com.brcc.business.vatcapital.service.impl;

import com.brcc.business.vatcapital.entity.VatcapitaldetailEntity;
import com.brcc.business.vatcapital.entity.VatcapitalmasterEntity;
import com.brcc.business.vatcapital.repository.VatCapitalMasterRepository;
import com.brcc.business.vatcapital.service.VatCapitalDetailService;
import com.brcc.business.vatcapital.service.VatCapitalService;
import com.brcc.business.vatcapital.vo.VatcapitaldetailQueryVo;
import com.brcc.business.vatcompanyrecharge.entity.VatcompanyrechargeEntity;
import com.brcc.business.vatcompanyrefund.vo.VatCompanyRefundQueryVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description:
 * @Auther: gemaochao
 * @Date:Created in 14:15 2018/11/16
 */
@Service
public class VatCapitalServiceImpl implements VatCapitalService {



    @Autowired
    VatCapitalMasterRepository vatCapitalMasterRepository;

    @Autowired
    VatCapitalDetailService vatCapitalDetailService;

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public VatcapitaldetailEntity saveDetail(VatcapitaldetailEntity vo) {
        return vatCapitalDetailService.save(vo);
    }

    @Override
    public VatcapitalmasterEntity saveMaster(VatcapitalmasterEntity vo) {
        return vatCapitalMasterRepository.save(vo);
    }


    @Override
    public VatcapitalmasterEntity queryMaster(Long carryId, Long clientId, String platformId, BigDecimal totalUserAmount) {
        return vatCapitalMasterRepository.queryMaster(carryId,clientId,platformId,totalUserAmount);
    }

    @Override
    public List<VatcapitalmasterEntity> queryCompanyName(VatCompanyRefundQueryVo vo) {
        return vatCapitalMasterRepository.queryCompanyName(vo);
    }

    @Override
    public Page<VatcapitaldetailQueryVo> queryForDetail(VatcapitaldetailQueryVo vo) {
        return vatCapitalDetailService.queryForDetail(vo);
    }


    @Override
    public Page<VatcapitalmasterEntity> queryForCarry(VatCompanyRefundQueryVo vo) {
        return vatCapitalMasterRepository.queryForCarry(vo);
    }

    @Override
    public VatcapitalmasterEntity queryTotalInAmount(VatCompanyRefundQueryVo vo) {
        return vatCapitalMasterRepository.queryTotalInAmount(vo).get(0);
    }

    @Override
    public List<VatcapitaldetailQueryVo> excelForMaster(VatcapitaldetailQueryVo vo) {
        return vatCapitalDetailService.excelForMaster(vo);
    }


    @Override
    public Page<VatcapitalmasterEntity> queryForClient(VatCompanyRefundQueryVo vo) {
        return vatCapitalMasterRepository.queryForClient(vo);
    }

	@Override
	public VatcapitalmasterEntity queryCompanyCapital(VatCompanyRefundQueryVo vo) {
		logger.info("query Vatcapital info,carryId:{},clientId:{}",vo.getCarryId(),vo.getClientId());
		return vatCapitalMasterRepository.queryCompanyCapital(vo.getClientId(),vo.getCarryId(),vo.getPlatformId());
	}


    @Override
	public Integer updateVatcapitalMaster(BigDecimal bankAmount,Long clientId,Long carryId,String platformId){
        return vatCapitalMasterRepository.updateVatcapitalMaster(bankAmount,clientId,carryId,platformId);
    }
}
