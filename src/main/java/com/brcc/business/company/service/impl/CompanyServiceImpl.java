package com.brcc.business.company.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.brcc.business.company.entity.CompanyEntity;
import com.brcc.business.company.repository.CompanyRepository;
import com.brcc.business.company.service.CompanyService;
import com.brcc.business.company.vo.CompanySearchVo;
import com.brcc.business.company.vo.CompanyVo;
import com.brcc.business.creditConfig.vo.CreditConfigAddCompanyVo;
import com.brcc.business.creditConfig.vo.CreditConfigQueryVo;
import com.brcc.business.oilManager.vo.OilManagerQueryVo;
import com.brcc.business.oilManager.vo.OilManagerVo;

/**
 * @Description: 委托方授信公司信息逻辑实现类
 * @Auther: gemaochao
 * @Date:Created in 10:18 2018/11/2
 */
@Service
public class CompanyServiceImpl implements CompanyService {
	
	Logger logger = LoggerFactory.getLogger(CompanyServiceImpl.class);
	
    @Autowired
    CompanyRepository companyRepository;
    @Override
    public Page<CreditConfigAddCompanyVo> creditCompany(CreditConfigQueryVo creditConfigQueryVo) {
        return companyRepository.creditCompany(creditConfigQueryVo);
    }

    @Override
    public CompanyEntity findCompanyById(Long seqId) {
        return companyRepository.findBySeqId(seqId);
    }

    @Override
    public List<CompanyEntity> companyIfTransport(String platformId, Long companyId) {
        return companyRepository.companyIfTransport(platformId, companyId);
    }

    @Override
    public CompanyEntity findBySeqIdAndPlatformId(Long seqId, String platformId) {
        return companyRepository.findBySeqIdAndPlatformId(seqId,platformId);
    }

    @Override
    public Page<CompanyVo> findPersonTeam(CompanySearchVo vo) {
        return companyRepository.findPersonTeam(vo);
    }

	@Override
	public Integer checkCompanyStatus(String platformId, Long companyId) {
		logger.info("check if the company can grab order,companyId:{}",companyId);
		return companyRepository.checkCompanyStatus(platformId,companyId);
	}

	@Override
	public CompanyVo findDriverFdrBlack(CompanySearchVo companySearchVo) {
		logger.info("check the company is black list,companyId:{}",companySearchVo.getCompanyId());
		return companyRepository.findDriverFdrBlack(companySearchVo);
	}

	@Override
	public CompanyVo queryGrabMoney(Long publishId, String platformId) {
		logger.info("query the company's if grab fee,publishId:{}",publishId);
		return companyRepository.queryGrabMoney(publishId,platformId);
	}

    @Override
    public Page<CompanyVo> queryCompanyForSalesman(CompanySearchVo vo) {
        return companyRepository.queryCompanyForSalesman(vo);
    }
    @Override
    public Page<OilManagerVo> findIfVirtualCompany(OilManagerQueryVo vo){
    	return companyRepository.findIfVirtualCompany(vo);
    }
    @Override
    public void changeIfVirtualCompany(OilManagerQueryVo vo) {
    	Integer num = companyRepository.changeIfVirtualCompany(vo.getIfVirtualCompany(),vo.getSeqId(),vo.getPlatformId());
    	Assert.isTrue(num ==1 ,"当前记录的状态已发生改变,请刷新页面重试");
    }
}
