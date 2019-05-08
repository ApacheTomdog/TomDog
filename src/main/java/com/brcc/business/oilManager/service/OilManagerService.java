package com.brcc.business.oilManager.service;
import org.springframework.data.domain.Page;

import com.brcc.business.oilManager.vo.OilManagerQueryVo;
/**
* @author PanJianYang
* @version 创建时间：2018年12月21日 下午1:05:10
*/
import com.brcc.business.oilManager.vo.OilManagerVo;


public interface OilManagerService {
	Page<OilManagerVo> invoiceCompanyList(OilManagerQueryVo vo);
	
	void changeIfVirtualCompany(OilManagerQueryVo vo);
}
