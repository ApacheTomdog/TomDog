package com.brcc.business.creditConfig.service.impl;

import com.brcc.business.company.service.CompanyService;
import com.brcc.business.creditAmountAdjust.entity.CreditAmountAdjustEntity;
import com.brcc.business.creditAmountAdjust.service.CreditAmountAdjustService;
import com.brcc.business.creditConfig.repository.CreditConfigRepository;
import com.brcc.business.creditConfig.service.CreditConfigService;
import com.brcc.business.creditConfig.entity.CreditConfigEntity;
import com.brcc.business.creditConfig.vo.CreditConfigAddCompanyVo;
import com.brcc.business.creditConfig.vo.CreditConfigModifyVo;
import com.brcc.business.creditConfig.vo.CreditConfigQueryVo;
import com.brcc.business.creditConfig.vo.CreditConfigVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


/**
 * @Description: 委托方授信管理逻辑实现类
 * @Auther: gemaochao
 * @Date:Created in 13:52 2018/10/31
 */
@Service
public class CreditConfigServiceImpl implements CreditConfigService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CreditConfigRepository creditConfigRepository;

    @Autowired
    CompanyService companyService;

    @Autowired
    CreditAmountAdjustService creditAmountAdjustService;

    @Override
    public Page<CreditConfigEntity> queryCreditConfig(CreditConfigQueryVo creditConfigQueryVo) {
        logger.info("query credit config,userID:{},companyID:{},plantFormID:{}",creditConfigQueryVo.getUserId(),creditConfigQueryVo.getCompanyId(),creditConfigQueryVo.getPlatformId());
        return creditConfigRepository.queryCreditConfig(creditConfigQueryVo);
    }

    @Override
    public CreditConfigEntity findById(String creditConfigId) {
        return creditConfigRepository.findByCreditConfigId(Long.valueOf(creditConfigId));
    }

    /**
     * 目前状态修改只支持10->90的操作
     */
    @Override
    public CreditConfigEntity changeCreditStatus(CreditConfigModifyVo creditConfigModifyVo) {
        logger.info("change credit status,Id:{}",creditConfigModifyVo.getCreditConfigId());
        
        CreditConfigEntity creditConfigEntity = creditConfigRepository.findByCreditConfigId(Long.valueOf(creditConfigModifyVo.getCreditConfigId()));
        
        Assert.isTrue("10".equals(creditConfigEntity.getCreditStatus()), "操作失败：只有新增的授信，才能生效！");
        
        //修改credit_config 状态
        creditConfigEntity.setModifyPersonId(creditConfigModifyVo.getUserId());
        
        creditConfigEntity.setModifyPersonName(creditConfigModifyVo.getUserName());
        
        creditConfigEntity.setModifyDate(new Date());
        
        creditConfigEntity.setCreditStatus("90");
        
        creditConfigRepository.save(creditConfigEntity);
        
        //修改credit_amount_adjust 状态
        CreditAmountAdjustEntity creditAmountAdjustEntity = creditAmountAdjustService.searchByCreditConfigId(creditConfigEntity.getCreditConfigId());
        
        creditAmountAdjustEntity.setModifyDate(new Date());
        
        creditAmountAdjustEntity.setModifyPersonId(creditConfigModifyVo.getUserId());
       
        creditAmountAdjustEntity.setModifyPersonName(creditConfigModifyVo.getUserName());
       
        creditAmountAdjustEntity.setCreditAdjStatus("90");
       
        creditAmountAdjustService.save(creditAmountAdjustEntity);
        
        creditConfigRepository.flush();
        
        //如果是启用，必须调用存储过程
        creditConfigRepository.flush();
        
        HashMap<String,Object> procMap = new HashMap<String,Object>();
		
		procMap.put("creditAmountAdjustId", creditAmountAdjustEntity.getCredAmtAdjId());
		
		procMap.put("outResult","");
		
		procMap.put("outResultReason","");
		
		creditConfigRepository.proCreditAmountAdjust(procMap);
		
		Assert.isTrue("1".equals((String)procMap.get("outResult")), (String)procMap.get("outResultReason"));
		
        return creditConfigEntity;
    }

    @Override
    public CreditConfigEntity changeCreditFdStatus(CreditConfigModifyVo creditConfigModifyVo) {
        logger.info("change credit fdStatus,id:{}",creditConfigModifyVo.getCreditConfigId());
        CreditConfigEntity creditConfigEntity = creditConfigRepository.findByCreditConfigId(Long.valueOf(creditConfigModifyVo.getCreditConfigId()));
        //修改 `modify_date`  '修改日期',
        //  `modify_person_id` '修改人id',
        //  `modify_person_name`  '修改人名称',
        creditConfigEntity.setModifyPersonId(creditConfigModifyVo.getUserId());
        creditConfigEntity.setModifyPersonName(creditConfigModifyVo.getUserName());
        creditConfigEntity.setModifyDate(new Date());
        //修改 `credit_fd_status` varchar(2) DEFAULT '20' COMMENT '20可以发单，10不可以发单',
        if ("20".equals(creditConfigEntity.getCreditFdStatus())){
            creditConfigEntity.setCreditFdStatus("10");
        }else {
            creditConfigEntity.setCreditFdStatus("20");
        }

        creditConfigRepository.save(creditConfigEntity);
        return creditConfigEntity;
    }

    @Override
    public Page<CreditConfigAddCompanyVo> creditAddCompany(CreditConfigQueryVo creditConfigQueryVo) {
        return companyService.creditCompany(creditConfigQueryVo);
    }

    @Override
    public Page<CreditAmountAdjustEntity> findCreditAmountAdjust(CreditConfigQueryVo creditConfigQueryVo) {
        return creditAmountAdjustService.findCreditAmountAdjust(creditConfigQueryVo);
    }

//    @Override
//    public CreditConfigEntity findByPublishCompanyId(Long companyId) {
//        return creditConfigRepository.findByPublishCompanyIdAndCreditStatus(companyId,"90");
//    }


    @Override
    public boolean exitConfig(Long companyId) {
        return creditConfigRepository.existsByPublishCompanyIdAndCreditStatus(companyId,"90");
    }

    @Override
    public CreditConfigEntity addConfigSave(CreditConfigEntity creditConfigEntity) {
        
    	creditConfigEntity.setPublishCompanyName(companyService.findCompanyById(creditConfigEntity.getPublishCompanyId()).getCompanyName());
        creditConfigRepository.save(creditConfigEntity);
        
     	//同时在credit_amount_adjust表添加新数据
        CreditAmountAdjustEntity creditAmountAdjustEntity = new CreditAmountAdjustEntity();
        creditAmountAdjustEntity.setCreditConfigId(creditConfigEntity.getCreditConfigId());
        creditAmountAdjustEntity.setPublishCompanyId(creditConfigEntity.getPublishCompanyId());
        creditAmountAdjustEntity.setPublishCompanyName(creditConfigEntity.getPublishCompanyName());
        creditAmountAdjustEntity.setCreditAdjAmount(creditConfigEntity.getCreditAmount());
        creditAmountAdjustEntity.setCreditAdjStatus(creditConfigEntity.getCreditStatus());
        creditAmountAdjustEntity.setCreateDate(creditConfigEntity.getModifyDate());
        creditAmountAdjustEntity.setCreatePersonId(creditConfigEntity.getModifyPersonId());
        creditAmountAdjustEntity.setCreatePersonName(creditConfigEntity.getModifyPersonName());
        creditAmountAdjustEntity.setModifyDate(creditConfigEntity.getModifyDate());
        creditAmountAdjustEntity.setModifyPersonId(creditConfigEntity.getModifyPersonId());
        creditAmountAdjustEntity.setModifyPersonName(creditConfigEntity.getModifyPersonName());
        creditAmountAdjustEntity.setRemark(creditConfigEntity.getRemark());
        creditAmountAdjustEntity.setCreditPlatCompanyId(creditConfigEntity.getCreditPlatCompanyId());
        creditAmountAdjustEntity.setPlatformId(creditConfigEntity.getPlatformId());
        creditAmountAdjustService.save(creditAmountAdjustEntity);
        
        return creditConfigEntity;
    }

    @Override
    public CreditConfigEntity saveConfigEdit(CreditConfigEntity creditConfigEntity) {
        
    	logger.info("edit credit save,id:{}",creditConfigEntity.getCreditConfigId());
        CreditConfigEntity editConfig = creditConfigRepository.findByCreditConfigId(creditConfigEntity.getCreditConfigId());
        editConfig.setCreditAmount(creditConfigEntity.getCreditAmount());
        editConfig.setCreditDuration(creditConfigEntity.getCreditDuration());
        editConfig.setRemark(creditConfigEntity.getRemark());
        editConfig.setModifyPersonName(creditConfigEntity.getModifyPersonName());
        editConfig.setModifyPersonId(creditConfigEntity.getModifyPersonId());
        editConfig.setModifyDate(creditConfigEntity.getModifyDate());
        creditConfigRepository.save(editConfig);
        
		//同时更新credit_amount_adjust
		CreditAmountAdjustEntity creditAmountAdjustEntity = creditAmountAdjustService.searchByCreditConfigId(editConfig.getCreditConfigId());
		creditAmountAdjustEntity.setCreditConfigId(editConfig.getCreditConfigId());
		creditAmountAdjustEntity.setPublishCompanyId(editConfig.getPublishCompanyId());
		creditAmountAdjustEntity.setPublishCompanyName(editConfig.getPublishCompanyName());
		creditAmountAdjustEntity.setCreditAdjAmount(editConfig.getCreditAmount());
		creditAmountAdjustEntity.setCreditAdjStatus(editConfig.getCreditStatus());
		creditAmountAdjustEntity.setCreateDate(editConfig.getModifyDate());
		creditAmountAdjustEntity.setCreatePersonId(editConfig.getModifyPersonId());
		creditAmountAdjustEntity.setCreatePersonName(editConfig.getModifyPersonName());
		creditAmountAdjustEntity.setModifyDate(editConfig.getModifyDate());
		creditAmountAdjustEntity.setModifyPersonId(editConfig.getModifyPersonId());
		creditAmountAdjustEntity.setModifyPersonName(editConfig.getModifyPersonName());
		creditAmountAdjustEntity.setRemark(editConfig.getRemark());
		creditAmountAdjustEntity.setCreditPlatCompanyId(editConfig.getCreditPlatCompanyId());
		creditAmountAdjustEntity.setPlatformId(editConfig.getPlatformId());
		creditAmountAdjustService.save(creditAmountAdjustEntity);

        return editConfig;
    }

    @Override
    public Page<CreditConfigAddCompanyVo> queryAddAdjustPriceCompanyName(CreditConfigQueryVo creditConfigQueryVo) {
        return creditConfigRepository.queryAddAdjustPriceCompanyName(creditConfigQueryVo);
    }


	@Override
	public CreditConfigEntity queryByPublishCompanyIdAndCreditStatus(Long companyId, String status) {
		ArrayList<CreditConfigEntity> list = (ArrayList<CreditConfigEntity>)creditConfigRepository.findByPublishCompanyIdAndCreditStatus(companyId, status);
		
		Assert.isTrue(list!=null, "您所要查找的公司，目前还未授信！");
		
		Assert.isTrue(list.size()==1,"您所要查找的公司，存在多条授信记录，请联系管理员！");
		
		return list.get(0);
	}



    @Override
    public CreditConfigEntity findByPublishCompanyId(Long publishCompanyId) {
        return creditConfigRepository.findByPublishCompanyIdAndCreditStatus(publishCompanyId,"90").get(0);
    }

	@Override
	public void proCreditAmountAdjust(HashMap<String, Object> procMap) {
		creditConfigRepository.proCreditAmountAdjust(procMap);
	}

	@Override
	public List<CreditConfigVo> queryIsCredit(CreditConfigQueryVo configQueryVo) {
		logger.info("query CreditConfigVo list,companyId:{}",configQueryVo.getCompanyId());
		return creditConfigRepository.queryCreditConfigList(configQueryVo);
	}
	
	@Override
    public List<CreditConfigVo> queryCreditConfigStatus(CreditConfigQueryVo creditConfigQueryVo) {
        logger.info("query credit config companyId:{},plantFormId:{}",creditConfigQueryVo.getCompanyId(),creditConfigQueryVo.getPlatformId());
        return creditConfigRepository.queryCreditConfigStatus(creditConfigQueryVo);
    }

    @Override
    public CreditConfigEntity justSave(CreditConfigEntity entity) {
        return creditConfigRepository.save(entity);
    }
}
