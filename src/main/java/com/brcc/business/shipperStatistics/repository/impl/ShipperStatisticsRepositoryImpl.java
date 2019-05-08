package com.brcc.business.shipperStatistics.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import com.brcc.business.shipperStatistics.repository.IShipperStatisticsRepository;
import com.brcc.business.shipperStatistics.vo.ShipperStatisticsQueryVo;
import com.brcc.business.shipperStatistics.vo.ShipperStatisticsVo;
import com.esteel.common.dao.PageQuery;

public class ShipperStatisticsRepositoryImpl implements IShipperStatisticsRepository{
	
	@Autowired
	PageQuery readPageQuery;
	
	/**
	 * 日
	 *
	 */
	@Override
	public ShipperStatisticsVo getDay(ShipperStatisticsQueryVo queryVo) {
		StringBuffer sql = new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		sql.append("SELECT");
		sql.append(" ( ");
		sql.append("   SELECT");
		sql.append("     ROUND(IFNULL(SUM(t.init_weight), 0), 2)");
		sql.append("   FROM");
		sql.append("     goodsorderm t");
		sql.append("   WHERE");
		sql.append("     t.create_date >= CURDATE()");
		sql.append("    AND t.platform_id = ?");
		params.add(queryVo.getPlatformId());
		sql.append("    AND t.`status` >= '20'");
		sql.append("    AND t.company_id = ?");
		params.add(queryVo.getCompanyId());
		sql.append("  ) AS toDayFdWeightSum,");
		sql.append(" (");
		sql.append("   SELECT");
		sql.append("     ROUND(IFNULL(SUM(t.sale_weight), 0), 2)");	
		sql.append("   FROM");		
		sql.append("     goodsorderm t");	
		sql.append("   WHERE");		
		sql.append("     t.create_date >= CURDATE()");	
		sql.append("     AND t.platform_id = ?");
		params.add(queryVo.getPlatformId());
		sql.append("     AND t.`status` >= '20'");	
		sql.append("     AND t.company_id = ?");
		params.add(queryVo.getCompanyId());
		sql.append("   ) AS toDayGrabWeightSum,");
		sql.append(" (");
		sql.append("   SELECT");	
		sql.append("     ROUND(IFNULL(");		
		sql.append("       SUM(");	
		sql.append("         IFNULL(t.take_delivery_weight, 0)");		
		sql.append("        ),0), 2)");	
		sql.append("   FROM");		
		sql.append("    transportationdelivery t");	
		sql.append("   WHERE");	
		sql.append("     t.finish_time >= CURDATE()");
		sql.append("     AND t.platform_id = ?");
		params.add(queryVo.getPlatformId());
		sql.append("     AND t.`status` = '90'");	
		sql.append("     AND t.publish_company_id = ?");
		params.add(queryVo.getCompanyId());
		sql.append("     ) AS toDayTakeDeliveryWeightSum,");	
		sql.append("  (");	
		sql.append("    SELECT");					
		sql.append("      ROUND(IFNULL(");				
		sql.append("        SUM(IFNULL(t.pay_amount, 0)),0), 2)");				
		sql.append("     FROM");			
		sql.append("       pay_bill t");		
		sql.append("     WHERE");		
		sql.append("       t.create_date >= CURDATE()");
		sql.append("       and t.if_tax_transport = 'Y'");
		sql.append("       AND t.platform_id = ?");
		params.add(queryVo.getPlatformId());
		sql.append("       AND t.`status` != '00'");			
		sql.append("       AND t.publish_company_id = ?");
		params.add(queryVo.getCompanyId());
		sql.append("      ) AS toDayPayAmountSum,");	
		sql.append("  (");		
		sql.append("    SELECT");					
		sql.append("      ROUND(IFNULL(");				
		sql.append("        SUM(IFNULL(t.pay_amount, 0)),0), 2)");				
		sql.append("     FROM");			
		sql.append("       pay_bill t");		
		sql.append("     WHERE");		
		sql.append("       t.create_date >= CURDATE()");
		sql.append("       AND t.platform_id = ?");
		params.add(queryVo.getPlatformId());
		sql.append("       and t.if_tax_transport = 'Y'");
		sql.append("       AND t.`status` = '20'");			
		sql.append("       AND t.publish_company_id = ?");
		params.add(queryVo.getCompanyId());
		sql.append("      ) AS toDayPayAmountActSum");			
		sql.append(" FROM DUAL;");	
		List<ShipperStatisticsVo> list = readPageQuery.list(sql.toString(), params, ShipperStatisticsVo.class);
		return ObjectUtils.isEmpty(list) ? null : list.get(0);
		
	}
	/**
	 * 周
	 */
	@Override
	public ShipperStatisticsVo getWeek(ShipperStatisticsQueryVo queryVo) {
		StringBuffer sql = new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		sql.append("SELECT");
		sql.append(" ( ");
		sql.append("   SELECT");
		sql.append("     ROUND(IFNULL(SUM(t.init_weight), 0), 2)");
		sql.append("   FROM");
		sql.append("     goodsorderm t");
		sql.append("   WHERE");
		sql.append("     t.create_date > STR_TO_DATE(CONCAT(DATE_FORMAT(CURRENT_DATE,'%Y-%m'),'-01'),'%Y-%m-%d')");
		sql.append("     and t.create_date < last_day(curdate())");
		sql.append("     and YEARWEEK(date_format(t.create_date,'%Y-%m-%d')) = YEARWEEK(now())");
		sql.append("    AND t.platform_id = ?");
		params.add(queryVo.getPlatformId());
		sql.append("    AND t.`status` >= '20'");
		sql.append("    AND t.company_id = ?");
		params.add(queryVo.getCompanyId());
		sql.append("  ) AS toDayFdWeightSum,");
		sql.append(" (");
		sql.append("   SELECT");
		sql.append("     ROUND(IFNULL(SUM(t.sale_weight), 0), 2)");	
		sql.append("   FROM");		
		sql.append("     goodsorderm t");	
		sql.append("   WHERE");		
		sql.append("     t.create_date > STR_TO_DATE(CONCAT(DATE_FORMAT(CURRENT_DATE,'%Y-%m'),'-01'),'%Y-%m-%d')");
		sql.append("     and t.create_date < last_day(curdate())");
		sql.append("     and YEARWEEK(date_format(t.create_date,'%Y-%m-%d')) = YEARWEEK(now())");
		sql.append("     AND t.platform_id = ?");
		params.add(queryVo.getPlatformId());
		sql.append("     AND t.`status` >= '20'");	
		sql.append("     AND t.company_id = ?");
		params.add(queryVo.getCompanyId());
		sql.append("   ) AS toDayGrabWeightSum,");
		sql.append(" (");
		sql.append("   SELECT");	
		sql.append("     ROUND(IFNULL(");		
		sql.append("       SUM(");	
		sql.append("         IFNULL(t.take_delivery_weight, 0)");		
		sql.append("        ),0), 2)");	
		sql.append("   FROM");		
		sql.append("    transportationdelivery t");	
		sql.append("   WHERE");
		sql.append("     t.finish_time > STR_TO_DATE(CONCAT(DATE_FORMAT(CURRENT_DATE,'%Y-%m'),'-01'),'%Y-%m-%d')");
		sql.append("     and t.finish_time < last_day(curdate())");
		sql.append("     and YEARWEEK(date_format(t.finish_time,'%Y-%m-%d')) = YEARWEEK(now())");
		sql.append("     AND t.platform_id = ?");
		params.add(queryVo.getPlatformId());
		sql.append("     AND t.`status` = '90'");	
		sql.append("     AND t.publish_company_id = ?");
		params.add(queryVo.getCompanyId());
		sql.append("     ) AS toDayTakeDeliveryWeightSum,");	
		sql.append("  (");	
		sql.append("    SELECT");					
		sql.append("      ROUND(IFNULL(");				
		sql.append("        SUM(IFNULL(t.pay_amount, 0)),0), 2)");				
		sql.append("     FROM");			
		sql.append("       pay_bill t");		
		sql.append("     WHERE");		
		sql.append("     t.create_date > STR_TO_DATE(CONCAT(DATE_FORMAT(CURRENT_DATE,'%Y-%m'),'-01'),'%Y-%m-%d')");
		sql.append("     and t.create_date < last_day(curdate())");
		sql.append("     and YEARWEEK(date_format(t.create_date,'%Y-%m-%d')) = YEARWEEK(now())");
		sql.append("       AND t.platform_id = ?");
		params.add(queryVo.getPlatformId());
		sql.append("       and t.if_tax_transport = 'Y'");
		sql.append("       AND t.`status` != '00'");			
		sql.append("       AND t.publish_company_id = ?");
		params.add(queryVo.getCompanyId());
		sql.append("      ) AS toDayPayAmountSum,");	
		sql.append("  (");		
		sql.append("    SELECT");					
		sql.append("      ROUND(IFNULL(");				
		sql.append("        SUM(IFNULL(t.pay_amount, 0)),0), 2)");				
		sql.append("     FROM");			
		sql.append("       pay_bill t");		
		sql.append("     WHERE");		
		sql.append("     t.create_date > STR_TO_DATE(CONCAT(DATE_FORMAT(CURRENT_DATE,'%Y-%m'),'-01'),'%Y-%m-%d')");
		sql.append("     and t.create_date < last_day(curdate())");	
		sql.append("     and YEARWEEK(date_format(t.create_date,'%Y-%m-%d')) = YEARWEEK(now())");
		sql.append("       AND t.platform_id = ?");
		params.add(queryVo.getPlatformId());
		sql.append("       and t.if_tax_transport = 'Y'");
		sql.append("       AND t.`status` = '20'");			
		sql.append("       AND t.publish_company_id = ?");
		params.add(queryVo.getCompanyId());
		sql.append("      ) AS toDayPayAmountActSum");			
		sql.append(" FROM DUAL;");	
		List<ShipperStatisticsVo> list = readPageQuery.list(sql.toString(), params, ShipperStatisticsVo.class);
		return ObjectUtils.isEmpty(list) ? null : list.get(0);
	}
	/**
	 * 月份
	 */
	@Override
	public ShipperStatisticsVo getMonth(ShipperStatisticsQueryVo queryVo) {
		StringBuffer sql = new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		sql.append("SELECT");
		sql.append(" ( ");
		sql.append("   SELECT");
		sql.append("     ROUND(IFNULL(SUM(t.init_weight), 0), 2)");
		sql.append("   FROM");
		sql.append("     goodsorderm t");
		sql.append("   WHERE");
		sql.append("     t.create_date > STR_TO_DATE(CONCAT(DATE_FORMAT(CURRENT_DATE,'%Y-%m'),'-01'),'%Y-%m-%d')");
		sql.append("     and t.create_date < last_day(curdate())");
		sql.append("    AND t.platform_id = ?");
		params.add(queryVo.getPlatformId());
		sql.append("    AND t.`status` >= '20'");
		sql.append("    AND t.company_id = ?");
		params.add(queryVo.getCompanyId());
		sql.append("  ) AS toDayFdWeightSum,");
		sql.append(" (");
		sql.append("   SELECT");
		sql.append("     ROUND(IFNULL(SUM(t.sale_weight), 0), 2)");	
		sql.append("   FROM");		
		sql.append("     goodsorderm t");	
		sql.append("   WHERE");		
		sql.append("     t.create_date > STR_TO_DATE(CONCAT(DATE_FORMAT(CURRENT_DATE,'%Y-%m'),'-01'),'%Y-%m-%d')");
		sql.append("     and t.create_date < last_day(curdate())");	
		sql.append("     AND t.platform_id = ?");
		params.add(queryVo.getPlatformId());
		sql.append("     AND t.`status` >= '20'");	
		sql.append("     AND t.company_id = ?");
		params.add(queryVo.getCompanyId());
		sql.append("   ) AS toDayGrabWeightSum,");
		sql.append(" (");
		sql.append("   SELECT");	
		sql.append("     ROUND(IFNULL(");		
		sql.append("       SUM(");	
		sql.append("         IFNULL(t.take_delivery_weight, 0)");		
		sql.append("        ),0), 2)");	
		sql.append("   FROM");		
		sql.append("    transportationdelivery t");	
		sql.append("   WHERE");
		sql.append("     t.finish_time > STR_TO_DATE(CONCAT(DATE_FORMAT(CURRENT_DATE,'%Y-%m'),'-01'),'%Y-%m-%d')");
		sql.append("     and t.finish_time < last_day(curdate())");
		sql.append("     AND t.platform_id = ?");
		params.add(queryVo.getPlatformId());
		sql.append("     AND t.`status` = '90'");	
		sql.append("     AND t.publish_company_id = ?");
		params.add(queryVo.getCompanyId());
		sql.append("     ) AS toDayTakeDeliveryWeightSum,");	
		sql.append("  (");	
		sql.append("    SELECT");					
		sql.append("      ROUND(IFNULL(");				
		sql.append("        SUM(IFNULL(t.pay_amount, 0)),0), 2)");				
		sql.append("     FROM");			
		sql.append("       pay_bill t");		
		sql.append("     WHERE");		
		sql.append("     t.create_date > STR_TO_DATE(CONCAT(DATE_FORMAT(CURRENT_DATE,'%Y-%m'),'-01'),'%Y-%m-%d')");
		sql.append("     and t.create_date < last_day(curdate())");	
		sql.append("       AND t.platform_id = ?");
		params.add(queryVo.getPlatformId());
		sql.append("       and t.if_tax_transport = 'Y'");
		sql.append("       AND t.`status` != '00'");			
		sql.append("       AND t.publish_company_id = ?");
		params.add(queryVo.getCompanyId());
		sql.append("      ) AS toDayPayAmountSum,");	
		sql.append("  (");		
		sql.append("    SELECT");					
		sql.append("      ROUND(IFNULL(");				
		sql.append("        SUM(IFNULL(t.pay_amount, 0)),0), 2)");				
		sql.append("     FROM");			
		sql.append("       pay_bill t");		
		sql.append("     WHERE");		
		sql.append("     t.create_date > STR_TO_DATE(CONCAT(DATE_FORMAT(CURRENT_DATE,'%Y-%m'),'-01'),'%Y-%m-%d')");
		sql.append("     and t.create_date < last_day(curdate())");	
		sql.append("       AND t.platform_id = ?");
		params.add(queryVo.getPlatformId());
		sql.append("       and t.if_tax_transport = 'Y'");
		sql.append("       AND t.`status` = '20'");			
		sql.append("       AND t.publish_company_id = ?");
		params.add(queryVo.getCompanyId());
		sql.append("      ) AS toDayPayAmountActSum");			
		sql.append(" FROM DUAL;");	
		List<ShipperStatisticsVo> list = readPageQuery.list(sql.toString(), params, ShipperStatisticsVo.class);
		return ObjectUtils.isEmpty(list) ? null : list.get(0);
	}

}
