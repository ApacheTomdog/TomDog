package com.brcc.business.oilManager.service.impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.brcc.business.company.repository.CompanyRepository;
import com.brcc.business.company.service.CompanyService;
import com.brcc.business.oilManager.service.OilManagerService;
import com.brcc.business.oilManager.vo.OilManagerQueryVo;
import com.brcc.business.oilManager.vo.OilManagerVo;
import com.esteel.common.util.RestPageImpl;

/**
* @author PanJianYang
* @version 创建时间：2018年12月21日 下午1:05:30
*/
@Transactional
@Service
public class OilManagerServiceImpl implements OilManagerService {
	Logger logger = LoggerFactory.getLogger(OilManagerServiceImpl.class);
	
	@Autowired
	CompanyService companyService;
	
	@Override
	public Page<OilManagerVo> invoiceCompanyList(OilManagerQueryVo vo) {
		
		Page<OilManagerVo> page = companyService.findIfVirtualCompany(vo);
        return page;
	
	}
	
	@Override
	public void changeIfVirtualCompany(OilManagerQueryVo vo) {
		companyService.changeIfVirtualCompany(vo);
	}
}
