package com.brcc.business.brokerFunds.service;

import com.brcc.business.brokerFunds.entity.BrokerFundsPayeeInfoEntity;
import com.brcc.business.brokerFunds.vo.BrokerFundsPayeeInfoQueryVo;
import com.brcc.business.brokerFunds.vo.BrokerFundsPayeeInfoVo;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface BrokerFundsPayeeInfoService {

    BrokerFundsPayeeInfoEntity save(BrokerFundsPayeeInfoEntity brokerFundsPayeeInfoEntity);

    BrokerFundsPayeeInfoEntity findByFundsControlMasterIdAndCompanyPayeeId(Long fundsControlMasterId,Long companyPayeeId);

    Page<BrokerFundsPayeeInfoVo> lookPayeeDetail(BrokerFundsPayeeInfoQueryVo vo);

    void deleteById(Long brokerFundsPayeeInfoId);

    Integer countByFundsControlMasterId(Long fundsControlMasterId);

    List<BrokerFundsPayeeInfoEntity> findByFundsControlMasterId(Long fundsControlMasterId);

    BigDecimal getPayeeInfoAmount(Long fundsControlMasterId);

    ArrayList checkPayeeAmountPro(Integer asPkId,String asType,String asPersonId,String asPersonName);

}
