package com.brcc.business.payFailureNotice.repository.impl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.ObjectUtils;

import com.brcc.business.goodsorderm.vo.GoodsordermVo;
import com.brcc.business.payFailureNotice.repository.IPayFailureNoticeRepository;
import com.brcc.business.payFailureNotice.vo.PayFailureNoticeQueryVo;
import com.brcc.business.payFailureNotice.vo.PayFailureNoticeVo;
import com.esteel.common.dao.PageQuery;


/**
* @author
* @version 创建时间：2018年10月30日 下午9:05:12
* @Description 
*/
public class PayFailureNoticeRepositoryImpl implements IPayFailureNoticeRepository {
	@Autowired
	PageQuery pageQuery;

	public Page<PayFailureNoticeVo> queryListPage(PayFailureNoticeQueryVo vo) {
		List<Object> params = new ArrayList<>();
		StringBuffer sql = new StringBuffer("select * from pay_failure_notice where ");

		sql.append(" platform_id = ? ");
		params.add(vo.getPlatformId());
		if(!ObjectUtils.isEmpty(vo.getPublishCompanyId())) {
			 sql.append(" and publish_company_id =  ? ");
			 params.add( vo.getPublishCompanyId());
		}
		if(!ObjectUtils.isEmpty(vo.getPayCompanyId())) {
			 sql.append(" and pay_company_id =  ? ");
			 params.add( vo.getPayCompanyId());
		}
		if(!ObjectUtils.isEmpty(vo.getDeliveryId())) {
			 sql.append(" and delivery_id like ? ");
			 params.add("%" + vo.getDeliveryId() + "%");
		}
		if(!ObjectUtils.isEmpty(vo.getProcessFlag())) {
			 sql.append(" and process_flag =  ? ");
			 params.add( vo.getProcessFlag());
		}
		if(!ObjectUtils.isEmpty(vo.getPayBankOwner())) {
			 sql.append(" and pay_bank_owner like ? ");
			 params.add("%" + vo.getPayBankOwner() + "%");
		}
		if(!ObjectUtils.isEmpty(vo.getPayBankName())) {
			 sql.append(" and pay_bank_name like ? ");
			 params.add("%" + vo.getPayBankName() + "%");
		}
		if(!ObjectUtils.isEmpty(vo.getPayBankNo())) {
			 sql.append(" and pay_bank_no like ? ");
			 params.add("%" + vo.getPayBankNo() + "%");
		}
		
		if(!ObjectUtils.isEmpty(vo.getDeliveryNum())) {
			 sql.append(" and delivery_num like ? ");
			params.add("%" + vo.getDeliveryNum() + "%");
		}
		// 开始时间
		if (!ObjectUtils.isEmpty(vo.getRqStart())) {
			sql.append(" AND create_date >= ? ");
			params.add(vo.getRqStart());
		}
		// 结束时间
		if (!ObjectUtils.isEmpty(vo.getRqEnd())) {
			sql.append(" AND create_date < ? ");
			params.add(vo.getRqEnd());
		}
		sql.append(" order by create_date desc ");
		Page<PayFailureNoticeVo> page = pageQuery.query(sql.toString(), params, vo,PayFailureNoticeVo.class);
		return page;
	}
}
