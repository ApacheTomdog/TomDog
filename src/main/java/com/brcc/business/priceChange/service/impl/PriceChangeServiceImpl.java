package com.brcc.business.priceChange.service.impl;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brcc.business.config.mybatis.MybatisQuery;
import com.brcc.business.priceChange.entity.PriceChangeEntity;
import com.brcc.business.priceChange.repository.PriceChangeRepository;
import com.brcc.business.priceChange.service.PriceChangeService;
import com.brcc.business.priceChange.vo.PriceChangeQueryVo;
import com.brcc.business.priceChange.vo.PriceChangeVo;
import com.brcc.business.priceChange.vo.CompanyVo;

/**
 * 委托承运货源审核管理,委托承运调价管理
 * @author panyinfang
 *
 */
@Service
@Transactional
public class PriceChangeServiceImpl implements PriceChangeService {
	
	Logger logger = LoggerFactory.getLogger(PriceChangeServiceImpl.class);
	@Autowired
	MybatisQuery mybatisQuery;
	@Autowired
	PriceChangeRepository priceChangeRepository;

	@Override
	public Page<PriceChangeVo> listDataList(PriceChangeQueryVo queryvo) {
		
		//return priceChangeRepository.listDataPage(queryvo);
		  Page<PriceChangeVo> page = mybatisQuery.page("priceChange.list", queryvo);
	        return page;
	}

	@Override
	public Page<PriceChangeVo> queryList(PriceChangeQueryVo queryvo) {
		
		return priceChangeRepository.queryList(queryvo);
	}

	@Override
	public void save(PriceChangeVo vo) {
		
		CompanyVo com=priceChangeRepository.getCompany(vo.getPublishId());
		PriceChangeEntity entity=new PriceChangeEntity();
		entity.setPlatformId(vo.getPlatformId());
		entity.setPublishId(vo.getPublishId());
		entity.setPriceChangeType(vo.getPriceChangeType());
		entity.setClientId(com.getClientId());
		entity.setClientName(com.getClientName());
		entity.setCarryId(vo.getCarryId());
		entity.setCarryName(vo.getCarryName());
		entity.setPriceChangeStatus("10");
		entity.setClientPrice(vo.getClientPrice());
		entity.setCarryPrice(vo.getCarryPrice());
		entity.setDiffPrice(vo.getDiffPrice());
		entity.setCreateDate(vo.getCreateDate());
		entity.setCreatePersonId(vo.getCreatePersonId());
		entity.setCreatePersonName(vo.getCreatePersonName());
		entity.setModifyDate(vo.getModifyDate());
		entity.setModifyPersonId(vo.getModifyPersonId());
		entity.setModifyPersonName(vo.getModifyPersonName());
		priceChangeRepository.save(entity);
		// 调过程
		HashMap<String, Object> propMap = new HashMap<String, Object>();
    	propMap.put("priceChangeId", entity.getPriceChangeId());
    	propMap.put("priceChangeType", entity.getPriceChangeType());
    	propMap.put("outResult", "");
    	propMap.put("outResultReason", "");
    	mybatisQuery.executePro("priceChange.goodsordermAuditPro", propMap);		
		if("1".equals(propMap.get("outResult"))){
			
		} else {
			throw new RuntimeException(propMap.get("outResultReason").toString());
		}
		
	}

	@Override
	public void delPriceChange(PriceChangeVo vo) {
		
		priceChangeRepository.delectPrice(vo.getModifyPersonName(), vo.getPublishId(), vo.getPlatformId());
	}

	@Override
	public void saveUpdate(PriceChangeVo vo) {
		
		priceChangeRepository.saveUpdate(vo.getCarryPrice(), vo.getDiffPrice(), vo.getModifyPersonId(), vo.getModifyPersonName(), vo.getPriceChangeId());
		// 调过程
		HashMap<String, Object> propMap = new HashMap<String, Object>();
    	propMap.put("priceChangeId", vo.getPriceChangeId());
    	propMap.put("priceChangeType",vo.getPriceChangeType());
    	propMap.put("outResult", "");
    	propMap.put("outResultReason", "");
    	mybatisQuery.executePro("priceChange.goodsordermAuditPro", propMap);		
		if("1".equals(propMap.get("outResult"))){
			
		} else {
			throw new RuntimeException(propMap.get("outResultReason").toString());
		}
	}

	@Override
	public PriceChangeVo getPrice(PriceChangeVo vo) {	
		PriceChangeVo voo=mybatisQuery.selectOne("priceChange.getPrice", vo);
		if(voo==null) {
			return new PriceChangeVo();
		}
		return voo;
	}

	@Override
	public PriceChangeVo getPriceTJ(PriceChangeVo vo) {
		PriceChangeVo voo=mybatisQuery.selectOne("priceChange.getPriceTJ", vo);
		if(voo==null) {
			return new PriceChangeVo();
		}
		return voo;
	}

}
