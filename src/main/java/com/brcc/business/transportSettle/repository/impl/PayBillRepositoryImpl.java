package com.brcc.business.transportSettle.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.brcc.business.transportSettle.repository.IPayBillRepository;
import com.brcc.business.transportbill.vo.TransportBillQueryVo;
import com.esteel.common.dao.PageQuery;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

/**
 * 结算单数据接口扩展实现
 * @author yangwenbin
 * @version 创建时间：2018年11月4日 上午11:33:00
 */
public class PayBillRepositoryImpl implements IPayBillRepository {

	@Autowired
    PageQuery pageQuery;
    @Autowired
    JdbcTemplate jdbcTemplate;
	@Autowired
	EntityManager entityManager;
    
	@Override
	public Integer queryActiveOilBillNum(Long deliveryId, String platformId) {
		String sql = "SELECT COUNT(1) FROM pay_oil_bill t WHERE t.docu_status > '10' AND t.platform_id = ? AND t.delivery_id = ?";
		Object[] args = new Object[] {platformId, deliveryId};
		Integer n = jdbcTemplate.queryForObject(sql, Integer.class, args);
		return n;
	}

	@Override
	public void insertPayOilBillLog(TransportBillQueryVo vo) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append(" INSERT INTO `apptms`.`pay_oil_bill_log` ");
		sql.append("         ( ");
		sql.append("         `pay_oil_id`, ");
		sql.append("         `pay_oil_num`, ");
		sql.append("         `delivery_id`, ");
		sql.append("         `trans_id`, ");
		sql.append("         `publish_id`, ");
		sql.append("         `publish_company_id`, ");
		sql.append("         `publish_company_name`, ");
		sql.append("         `fk_company_id`, ");
		sql.append("         `fk_company_name`, ");
		sql.append("         `sk_company_id`, ");
		sql.append("         `sk_company_name`, ");
		sql.append("         `sk_company_nature`, ");
		sql.append("         `driver_id`, ");
		sql.append("         `driver_name`, ");
		sql.append("         `vehicle_id`, ");
		sql.append("         `vehicle_num`, ");
		sql.append("         `oil_amount`, ");
		sql.append("         `oil_amount_act`, ");
		sql.append("         `docu_status`, ");
		sql.append("         `platform_id`, ");
		sql.append("         `docu_from_type`, ");
		sql.append("         `create_date`, ");
		sql.append("         `create_person_id`, ");
		sql.append("         `create_person_name`, ");
		sql.append("         `modify_date`, ");
		sql.append("         `modify_person_id`, ");
		sql.append("         `modify_person_name`, ");
		sql.append("         `card_id`, ");
		sql.append("         `card_name`, ");
		sql.append("         `log_create_date`, ");
		sql.append("         `log_create_person`) ");
		sql.append("         select `pay_oil_id`, ");
		sql.append("             `pay_oil_num`, ");
		sql.append("             `delivery_id`, ");
		sql.append("             `trans_id`, ");
		sql.append("             `publish_id`, ");
		sql.append("             `publish_company_id`, ");
		sql.append("             `publish_company_name`, ");
		sql.append("             `fk_company_id`, ");
		sql.append("             `fk_company_name`, ");
		sql.append("             `sk_company_id`, ");
		sql.append("             `sk_company_name`, ");
		sql.append("             `sk_company_nature`, ");
		sql.append("             `driver_id`, ");
		sql.append("             `driver_name`, ");
		sql.append("             `vehicle_id`, ");
		sql.append("             `vehicle_num`, ");
		sql.append("             `oil_amount`, ");
		sql.append("             `oil_amount_act`, ");
		sql.append("             `docu_status`, ");
		sql.append("             `platform_id`, ");
		sql.append("             `docu_from_type`, ");
		sql.append("             `create_date`, ");
		sql.append("             `create_person_id`, ");
		sql.append("             `create_person_name`, ");
		sql.append("             `modify_date`, ");
		sql.append("             `modify_person_id`, ");
		sql.append("             `modify_person_name`, ");
		sql.append("             `card_id`, ");
		sql.append("             `card_name`, ");
		sql.append("             now(), ");
		sql.append("             ? ");
		sql.append("        from pay_oil_bill t ");
		sql.append("       where t.delivery_id = ? ");
		sql.append("         and t.platform_id = ? ");
		sql.append("         and t.docu_status = '10' ");
		
		args.add(vo.getUserId());
		args.add(vo.getDeliveryId());
		args.add(vo.getPlatformId());
		
		jdbcTemplate.update(sql.toString(), args.toArray());
		
	}

	@Override
	public void deletePayOilBill(TransportBillQueryVo vo) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append("DELETE FROM pay_oil_bill WHERE delivery_id = ? AND platform_id = ? AND docu_status = '10'");
		args.add(vo.getDeliveryId());
		args.add(vo.getPlatformId());
		
		jdbcTemplate.update(sql.toString(), args.toArray());
	}

	@Override
	public HashMap<String, Object> callBatchCalcPro(String batchId) {

		StoredProcedureQuery procedure = entityManager.createNamedStoredProcedureQuery("pro_paybill_batch_calc");
		procedure.setParameter("asBatchId", batchId);
		List list = procedure.getResultList();
		Object[] objectArr = (Object[]) list.get(0);

		HashMap<String, Object> proMap = new HashMap<String, Object>();
		proMap.put("outResult", (String)objectArr[0]);
		proMap.put("outResultReason", (String)objectArr[1]);

		return proMap;
	}

}
