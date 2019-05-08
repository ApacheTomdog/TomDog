package com.brcc.business.creditAmountAdjust.service.impl;

import com.brcc.business.creditAmountAdjust.entity.CreditAmountAdjustEntity;
import com.brcc.business.creditAmountAdjust.repository.CreditAmountAdjustRepository;
import com.brcc.business.creditAmountAdjust.service.CreditAmountAdjustService;
import com.brcc.business.creditAmountAdjust.vo.CreditAmountAdjustQueryVo;
import com.brcc.business.creditConfig.entity.CreditConfigEntity;
import com.brcc.business.creditConfig.service.CreditConfigService;
import com.brcc.business.creditConfig.vo.CreditConfigQueryVo;
import java.math.BigDecimal;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @Description: 授信明细逻辑实现类
 * @Auther: gemaochao
 * @Date:Created in 10:22 2018/11/2
 */
@Service
public class CreditAmountAdjustServiceImpl implements CreditAmountAdjustService {

    @Autowired
    CreditAmountAdjustRepository creditAmountAdjustRepository;

    @Autowired
    CreditConfigService creditConfigService;

    Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Override
    public Page<CreditAmountAdjustEntity> findCreditAmountAdjust(CreditConfigQueryVo creditConfigQueryVo) {

    	return creditAmountAdjustRepository.findCreditAmountAdjust(creditConfigQueryVo);
    }

    @Override
    public CreditAmountAdjustEntity save(CreditAmountAdjustEntity creditAmountAdjustEntity) {
    	
    	return creditAmountAdjustRepository.save(creditAmountAdjustEntity);
    }

	@Override
	public Page<CreditAmountAdjustEntity> searchCreditAmountAdjust(CreditAmountAdjustQueryVo creditAmountAdjustQueryVo) {

		return creditAmountAdjustRepository.searchCreditAmountAdjust(creditAmountAdjustQueryVo);
	}

	@Override
	public CreditAmountAdjustEntity searchByOne(CreditAmountAdjustQueryVo creditAmountAdjustQueryVo) {

		return creditAmountAdjustRepository.findByCredAmtAdjId(creditAmountAdjustQueryVo.getCredAmtAdjId());
	}

	@Override
	public void modify(CreditAmountAdjustEntity creditAmountAdjustEntity) {
		logger.info("modify credit amount adjust,id:{}",creditAmountAdjustEntity.getCredAmtAdjId());
		
		CreditAmountAdjustEntity caaEntity = creditAmountAdjustRepository.findByCredAmtAdjId(creditAmountAdjustEntity.getCredAmtAdjId());
		
		caaEntity.setModifyDate(creditAmountAdjustEntity.getModifyDate());
		
		caaEntity.setModifyPersonId(creditAmountAdjustEntity.getModifyPersonId());
		
		caaEntity.setModifyPersonName(creditAmountAdjustEntity.getModifyPersonName());
		
		caaEntity.setCreditAdjAmount(creditAmountAdjustEntity.getCreditAdjAmount());
		
		caaEntity.setRemark(creditAmountAdjustEntity.getRemark());
		
		creditAmountAdjustRepository.save(caaEntity);
	}

	@Override
	public void modifyStatus(CreditAmountAdjustEntity creditAmountAdjustEntity) {

    	logger.info("modify status,status:{},id:{}",creditAmountAdjustEntity.getCreditAdjStatus(),creditAmountAdjustEntity.getCredAmtAdjId());
		
		CreditAmountAdjustEntity caaEntity = creditAmountAdjustRepository.findByCredAmtAdjId(creditAmountAdjustEntity.getCredAmtAdjId());
		
		Assert.isTrue("10".equals(caaEntity.getCreditAdjStatus()), "操作失败：该单据已不是新增状态，不能做任何操作！");
		
		caaEntity.setCreditAdjStatus(creditAmountAdjustEntity.getCreditAdjStatus());
		
		caaEntity.setModifyDate(creditAmountAdjustEntity.getModifyDate());
		
		caaEntity.setModifyPersonId(creditAmountAdjustEntity.getModifyPersonId());
		
		caaEntity.setModifyPersonName(creditAmountAdjustEntity.getModifyPersonName());
		
		creditAmountAdjustRepository.save(caaEntity);
		
		/**
		 * 调用存储过程，处理资金帐
		 */
		if("90".equals(caaEntity.getCreditAdjStatus())) {
			
			CreditConfigEntity creditConfigEntity = creditConfigService.findById(String.valueOf(caaEntity.getCreditConfigId()));
			
			BigDecimal creditAmount = creditConfigEntity.getCreditAmount().add(caaEntity.getCreditAdjAmount());
			
			Assert.isTrue(creditAmount.compareTo(BigDecimal.ZERO) >= 0, "操作失败：委托方总授信金额不能小于零！");
			
			creditConfigEntity.setCreditAmount(creditAmount);
			
			creditConfigService.justSave(creditConfigEntity);
			
			creditAmountAdjustRepository.flush();
			
			HashMap<String,Object> procMap = new HashMap<String,Object>();
			
			procMap.put("creditAmountAdjustId", creditAmountAdjustEntity.getCredAmtAdjId());
			
			procMap.put("outResult","");
			
			procMap.put("outResultReason","");
			
			creditConfigService.proCreditAmountAdjust(procMap);
			
			Assert.isTrue("1".equals((String)procMap.get("outResult")), (String)procMap.get("outResultReason"));
		}
	}

	@Override
	public CreditAmountAdjustEntity searchByCreditConfigId(Long creditConfigId) {
		
		return creditAmountAdjustRepository.findByCreditConfigId(creditConfigId);
	}


}
