package com.brcc.business.goodsorderOil.repository.Impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.ObjectUtils;

import com.brcc.business.goodsorderOil.repository.IGoodsorderOilRepository;
import com.brcc.business.goodsorderOil.vo.GoodsorderOilQueryVo;
import com.brcc.business.goodsorderOil.vo.GoodsorderOilVo;
import com.esteel.common.dao.PageQuery;

public class GoodsorderOilRepositoryImpl implements IGoodsorderOilRepository {
	@Autowired
	PageQuery pageQuery;

	Logger logger = LoggerFactory.getLogger(this.getClass());
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public Page<GoodsorderOilVo> searchGoodsorderOil(GoodsorderOilQueryVo queryVo) {
		List<Object> params = new ArrayList<>();
		StringBuffer sql = new StringBuffer(
				"select t.*,(SELECT t1.company_name FROM Company t1 where t1.seq_id = t.company_id and t1.platform_id = t.platform_id) as consignorName,"
						+ "(select sum(t1.weight) from TransportationDelivery t1 where t1.publish_id = t.publish_id and t.status!='00' and t1.status!='00'and t1.platform_id = t.platform_id) as transWeight"
						+ "" + " from GoodsOrderM as t");
		if (!ObjectUtils.isEmpty(queryVo.getVatFlowMasterName())) {
			sql.append("  left join vatflowmaster v on (t.vat_flow_master_id =v.vat_flow_master_id) ");
		}
		sql.append("  where 1=1  ");
		sql.append("  and t.platform_id = ? ");
		params.add(queryVo.getPlatformId());
		sql.append("  and t.status > '10' ");
		sql.append("  and t.if_tax_transport = 'Y' ");
		sql.append("  and ifnull(t.js_type,'01')='02' ");
		// 货源单号
		if (!ObjectUtils.isEmpty(queryVo.getPublishId())) {
			sql.append("AND t.publish_id like ? ");
			params.add("%" + queryVo.getPublishId() + "%");
		}
		// 业务单据号id
		if (StringUtils.isNotEmpty(queryVo.getDependNum())) {
			sql.append("AND t.depend_num like ? ");
			params.add("%" + queryVo.getDependNum() + "%");
		}
		// 拼单号
		if (StringUtils.isNotEmpty(queryVo.getPinDanNum())) {
			sql.append("AND t.pin_dan_num like ? ");
			params.add("%" + queryVo.getPinDanNum() + "%");
		}
		if (!ObjectUtils.isEmpty(queryVo.getBillSender())) {
			sql.append("AND t.bill_sender like ? ");
			params.add("%" + queryVo.getBillSender() + "%");
		}
		// 是否显示
		if (!ObjectUtils.isEmpty(queryVo.getIsAutoDisplay())) {
			sql.append(" and t.is_auto_display = ? ");
			params.add(queryVo.getIsAutoDisplay());
		}
		// 是否授信
		if (!ObjectUtils.isEmpty(queryVo.getOwnerAdjustFlag())) {
			sql.append(" and t.owner_adjust_flag = ? ");
			params.add(queryVo.getOwnerAdjustFlag());
		}
		// 取单地
		if (StringUtils.isNotEmpty(queryVo.getGetOrderPlate())) {
			sql.append("AND t.get_order_plate like ? ");
			params.add("%" + queryVo.getGetOrderPlate() + "%");
		}
		// 起始地
		if (StringUtils.isNotEmpty(queryVo.getStartPlate())) {
			sql.append("AND t.start_plate like ? ");
			params.add("%" + queryVo.getStartPlate() + "%");
		}
		// 目的地
		if (StringUtils.isNotEmpty(queryVo.getEndPlate())) {
			sql.append("AND t.end_plate like ? ");
			params.add("%" + queryVo.getEndPlate() + "%");
		}
		// 注册开始时间
		if (!ObjectUtils.isEmpty(queryVo.getRqStart())) {
			sql.append(" AND DATE_FORMAT(create_date,'%Y-%m-%d') >= ? ");
			params.add(sdf.format(queryVo.getRqStart()));
		}
		// 注册结束时间
		if (!ObjectUtils.isEmpty(queryVo.getRqEnd())) {
			sql.append(" AND DATE_FORMAT(create_date,'%Y-%m-%d') <= ? ");
			params.add(sdf.format(queryVo.getRqEnd()));
		}
		// 品种描述
		if (StringUtils.isNotEmpty(queryVo.getProdDesc())) {
			sql.append("AND t.prod_desc like ? ");
			params.add("%" + queryVo.getProdDesc() + "%");
		}
		// 货物类型
		if (queryVo.getGoodType() != null) {
			sql.append("AND t.good_type= ? ");
			params.add(queryVo.getGoodType());
		}
		// 发单人
		if (StringUtils.isNotEmpty(queryVo.getConsignorName())) {
			sql.append(
					" and (SELECT t1.company_name FROM Company t1 where t1.seq_id = t.company_id and t1.platform_id = t.platform_id)  LIKE ? ");
			params.add("%" + queryVo.getConsignorName() + "%");
		}
		// 状态
		if (StringUtils.isNotEmpty(queryVo.getStatus())) {
			if (queryVo.getStatus().equals("20")) {
				sql.append("AND t.status != '00' and t.sale_weight >'0' ");
			} else if (queryVo.getStatus().equals("30")) {
				sql.append("AND t.status != '00' and t.sale_weight ='0' ");
			} else {
				sql.append("AND t.status = ? ");
				params.add("%" + queryVo.getGoodTypeDesc() + "%");
			}
		}
		return pageQuery.query(sql.toString(), params, queryVo, GoodsorderOilVo.class);
	}

	@Override
	public List<GoodsorderOilVo> changeOliTypeList(GoodsorderOilQueryVo queryVo) {
		List<Object> params = new ArrayList<>();
		StringBuffer sql = new StringBuffer(
				"select t.js_type,t.oil_flag ,if(t.oil_flag='1',ifnull(t.oil_amount,0),0) as oil_amount,if(t.oil_flag='0',ifnull(t.oil_ratio,0),0) as oil_ratio "
						+ ",t.init_amount,t.detachable,CAST(FLOOR(t.init_weight/t.single_car_weight) AS SIGNED) as singleCarWeightChe,t.publish_id "
						+ " from GoodsOrderM t where 1=1 ");
		sql.append("  and t.platform_id = ? ");
		params.add(queryVo.getPlatformId());
		sql.append("  and t.status > '10' ");
		sql.append("  and t.if_tax_transport = 'Y' ");
		sql.append("  and ifnull(t.js_type,'01')='02' ");
		sql.append("  and t.publish_id = ? ");
		params.add(queryVo.getPublishId());
		return pageQuery.list(sql.toString(), params, GoodsorderOilVo.class);
	}

	@Override
	public List<GoodsorderOilVo> goodsorderOilListExcel(GoodsorderOilQueryVo queryVo) {
		List<Object> params = new ArrayList<>();
		StringBuffer sql = new StringBuffer(
				"SELECT t.*,(select sum(t1.weight) from TransportationDelivery t1 where t1.publish_id = t.publish_id and t.status!='00' and t1.status!='00'and t1.platform_id = t.platform_id) as transWeight from goodsorderm AS t where 1=1 ");
		sql.append("  and t.platform_id = ? ");
		params.add(queryVo.getPlatformId());
		sql.append("  and t.status > '10' ");
		sql.append("  and t.if_tax_transport = 'Y' ");
		sql.append("  and ifnull(t.js_type,'01')='02' ");
		// 货源单号
		if (!ObjectUtils.isEmpty(queryVo.getPublishId())) {
			sql.append("AND t.publish_id like ? ");
			params.add("%" + queryVo.getPublishId() + "%");
		}
		// 业务单据号id
		if (StringUtils.isNotEmpty(queryVo.getDependNum())) {
			sql.append("AND t.depend_num like ? ");
			params.add("%" + queryVo.getDependNum() + "%");
		}
		// 拼单号
		if (StringUtils.isNotEmpty(queryVo.getPinDanNum())) {
			sql.append("AND t.pin_dan_num like ? ");
			params.add("%" + queryVo.getPinDanNum() + "%");
		}
		if (!ObjectUtils.isEmpty(queryVo.getBillSender())) {
			sql.append("AND t.bill_sender like ? ");
			params.add("%" + queryVo.getBillSender() + "%");
		}
		// 是否显示
		if (!ObjectUtils.isEmpty(queryVo.getIsAutoDisplay())) {
			sql.append(" and t.is_auto_display = ? ");
			params.add(queryVo.getIsAutoDisplay());
		}
		// 是否授信
		if (!ObjectUtils.isEmpty(queryVo.getOwnerAdjustFlag())) {
			sql.append(" and t.owner_adjust_flag = ? ");
			params.add(queryVo.getOwnerAdjustFlag());
		}
		// 取单地
		if (StringUtils.isNotEmpty(queryVo.getGetOrderPlate())) {
			sql.append("AND t.get_order_plate like ? ");
			params.add("%" + queryVo.getGetOrderPlate() + "%");
		}
		// 起始地
		if (StringUtils.isNotEmpty(queryVo.getStartPlate())) {
			sql.append("AND t.start_plate like ? ");
			params.add("%" + queryVo.getStartPlate() + "%");
		}
		// 目的地
		if (StringUtils.isNotEmpty(queryVo.getEndPlate())) {
			sql.append("AND t.end_plate like ? ");
			params.add("%" + queryVo.getEndPlate() + "%");
		}
		// 注册开始时间
		if (!ObjectUtils.isEmpty(queryVo.getRqStart())) {
			sql.append(" AND DATE_FORMAT(create_date,'%Y-%m-%d') >= ? ");
			params.add(sdf.format(queryVo.getRqStart()));
		}
		// 注册结束时间
		if (!ObjectUtils.isEmpty(queryVo.getRqEnd())) {
			sql.append(" AND DATE_FORMAT(create_date,'%Y-%m-%d') <= ? ");
			params.add(sdf.format(queryVo.getRqEnd()));
		}
		// 品种描述
		if (StringUtils.isNotEmpty(queryVo.getProdDesc())) {
			sql.append("AND t.prod_desc like ? ");
			params.add("%" + queryVo.getProdDesc() + "%");
		}
		// 货物类型
		if (queryVo.getGoodType() != null) {
			sql.append("AND t.good_type = ? ");
			params.add(queryVo.getGoodType().toString());
		}
		// 发单人
		if (StringUtils.isNotEmpty(queryVo.getConsignorName())) {
			sql.append(
					" and (SELECT t1.company_name FROM Company t1 where t1.seq_id = t.company_id and t1.platform_id = t.platform_id)  LIKE ? ");
			params.add("%" + queryVo.getConsignorName() + "%");
		}
		// 状态
		if (StringUtils.isNotEmpty(queryVo.getStatus())) {
			if (queryVo.getStatus().equals("20")) {
				sql.append("AND t.status != '00' and t.sale_weight >'0' ");
			} else if (queryVo.getStatus().equals("30")) {
				sql.append("AND t.status != '00' and t.sale_weight ='0' ");
			} else {
				sql.append("AND t.status = ? ");
				params.add("%" + queryVo.getGoodTypeDesc() + "%");
			}

		}
		sql.append("order by  t.create_date desc ");
		return pageQuery.list(sql.toString(), params, GoodsorderOilVo.class);
	}
}
