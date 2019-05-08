package com.brcc.business.transportSettle.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.jdbc.core.JdbcTemplate;

import com.brcc.business.transportSettle.entity.VNewPayBillEntity;
import com.brcc.business.transportSettle.repository.IPayBillChildRepository;
import com.brcc.business.transportbill.vo.TransportBillQueryVo;
import com.esteel.common.dao.PageQuery;

/**
 * 结算单数据接口扩展实现
 * @author yangwenbin
 * @version 创建时间：2018年11月4日 上午11:33:00
 */
public class PayBillChildRepositoryImpl implements IPayBillChildRepository {

	@Autowired
    PageQuery pageQuery;
    @Autowired
    JdbcTemplate jdbcTemplate;
    
	@Override
	public Page<VNewPayBillEntity> findPayDetailData(TransportBillQueryVo vo) {
		
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append(" select ");
		sql.append("     pc.zf_child_id, ");
		sql.append("     pc.zf_child_num, ");
		sql.append("     pc.zf_id, ");
		sql.append("     pc.zf_num, ");
		sql.append("     pc.pay_id, ");
		sql.append("     pc.pay_num, ");
		sql.append("     pc.pay_company_id, ");
		sql.append("     pc.pay_company_name, ");
		sql.append("     pc.rece_company_id, ");
		sql.append("     pc.rece_company_name, ");
		sql.append("     if(pc.tot_amount = 0, pc.pay_amount, pc.tot_amount) as pay_amount, ");
		sql.append("     pc.create_date, ");
		sql.append("     pc.create_person_id, ");
		sql.append("     pc.create_person_name, ");
		sql.append("     pc.pay_person_id, ");
		sql.append("     pc.pay_person_name, ");
		sql.append("     pc.platform_id, ");
		sql.append("     pc.update_date, ");
		sql.append("     pc.update_person_id, ");
		sql.append("     pc.update_person_name, ");
		sql.append("     pc.pay_from_type, ");
		sql.append("     pc.pay_from_type_desc, ");
		sql.append("     pc.company_bank_name as rece_bank_name, ");
		sql.append("     pc.company_bank_num as rece_bank_num, ");
		sql.append("     pc.company_bank_owner as rece_bank_owner, ");
		sql.append("     pc.rece_bank_type, ");
		sql.append("     pc.rece_bank_province, ");
		sql.append("     pc.rece_bank_city, ");
		sql.append("     pc.rece_subbranch_name, ");
		sql.append("     pc.rece_link_num, ");
		sql.append("     pc.vehicle_num   ");
		sql.append(" from v_new_pay_bill pc  ");
		sql.append(" where 1=1  ");
		sql.append(" and pc.platform_id= ? ");
		sql.append(" and pc.zf_id= ? ");
		
		args.add(vo.getPlatformId());
		args.add(vo.getZfId());
		
		return pageQuery.query(sql.toString(), args, vo, VNewPayBillEntity.class);
	}
    
	 
}
