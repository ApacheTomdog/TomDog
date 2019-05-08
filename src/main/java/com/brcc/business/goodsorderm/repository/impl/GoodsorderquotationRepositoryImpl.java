package com.brcc.business.goodsorderm.repository.impl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.ObjectUtils;

import com.brcc.business.goodsorderm.repository.IGoodsorderquotationRepository;
import com.brcc.business.goodsorderm.vo.GoodsordermQueryVo;
import com.brcc.business.goodsorderm.vo.GoodsordermVo;
import com.brcc.business.goodsorderm.vo.GoodsorderquotationQueryVo;
import com.brcc.business.goodsorderm.vo.GoodsorderquotationVo;
import com.esteel.common.dao.PageQuery;


/**
* @Desc   货源单货物单价报价记录数据处理接口实现
* @author TangYong
* @Date   2018-12-05
*/
public class GoodsorderquotationRepositoryImpl implements IGoodsorderquotationRepository {
	
	 @Autowired
	 PageQuery pageQuery;
	 
	public Page<GoodsordermVo> findAllPage(GoodsordermQueryVo vo) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append("select t.* from apptms.goodsorderm t");
		sql.append(" where 1=1 ");
		// 货源单id
		if(!ObjectUtils.isEmpty(vo.getPublishId())) {
			sql.append(" and t.publish_id = ? ");
			args.add(vo.getPublishId());
		}
		sql.append(" order by t.create_date desc ");
		return pageQuery.query(sql.toString(), args, vo,GoodsordermVo.class);
	}

	@Override
	public List<GoodsorderquotationVo> getBaoJiaList(GoodsordermQueryVo vo) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append("SELECT a.quotation_id,");
		sql.append("	a.amount,");
		sql.append("	a.price,");
		sql.append("	a.weight,");
		sql.append("	a.qty,");
		sql.append("	a.create_date,");
		sql.append("	a.company_id,");
		sql.append("	if(a.company_name='',t.company_name,if(ifnull(a.company_name,'') = '',t.company_name,a.company_name)) as company_name,");
		sql.append("	a.status,");
		sql.append("	if(a.status= '00','拒绝',IF(a.status='10','新增',if(a.status ='20','生效' ,'无效'))) as status_desc,");
		sql.append("	t.contact_mobile,");
		sql.append("	if((select count(1) from TransportationDelivery cc where cc.driver_id = t1.driver_id and cc.status!='00' and cc.status!='90'  limit 0,1) = 0 ,'','Y') as isTransport,");
		sql.append("	a.remark,");
		sql.append("	t1.user_type,");
		sql.append("	(select count(*) from transportationm ts where ts.company_id=a.company_id  and (ts.`status`='10' or ts.`status`='20') and IFNULL(ts.weight,0)>0 )  as tran_num, ");
		sql.append("	(select t2.status from transportationm t2 where t2.trans_id = a.trans_id) as tranStatus ");
		sql.append("FROM GoodsOrderQuotation a , company t , loginVerify t1 ");
		sql.append("WHERE a.plat_form_id = ? ");
		sql.append("	AND a.company_id = t.seq_id ");
		sql.append("	AND a.publish_id = ? ");
		sql.append("	AND a.status != '00' ");
		sql.append("	AND a.company_id = t1.company_id ");
		sql.append("	AND t1.if_admin = 'Y' ");
		sql.append("ORDER BY a.price , a.create_date ");
		args.add(vo.getPlatformId());
		args.add(vo.getPublishId());
		List<GoodsorderquotationVo> list = pageQuery.list(sql.toString(), args, GoodsorderquotationVo.class);
	 	return list;
	}

	@Override
	public GoodsorderquotationVo getBaojiaInfo(GoodsorderquotationQueryVo vo) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append("SELECT ");
		sql.append("	t.quotation_id as quotationId,");
		sql.append("    t.publish_id as publishId,");
		sql.append("    t.price as outPrice,");
		sql.append("    t.weight as grabWeight,");
		sql.append("    t.amount,");
		sql.append("    t.qty as grabQty,");
		sql.append("    t.company_id as companyId,");
		sql.append("    t.company_name as companyName,");
		sql.append("    t.publish_company_id as publishCompanyId,");
		sql.append("    t1.contact_mobile as contactMobile,");
		sql.append("    if(t.operate_type = 'WEB','GS','GR') as userType,");
		sql.append("    t2.driver_id as driverId,");
		sql.append("	t2.vehicle_id as vehicleId,");
		sql.append("	t.weight as dispatchWeight,");
		sql.append("	t.qty as dispatchQty,");
		sql.append("	t.standard_tax as 'standardTax',");
		sql.append("	t.price_tax as 'priceTax',");
		sql.append("	t.if_tax_transport as 'ifTaxTransport',");
		sql.append("	t.vat_flow_master_id as 'vatFlowMasterId' ");
		sql.append("FROM goodsorderquotation as t ,company as t1, loginverify as t2 ");
		sql.append("    where t.company_id = t1.seq_id ");
		sql.append("    and t1.seq_id = t2.company_id ");
		sql.append("    and t2.if_admin = 'Y' ");
		sql.append("    and t.quotation_id = ? ");
		args.add(vo.getQuotationId());
		List<GoodsorderquotationVo> list = pageQuery.list(sql.toString(), args, GoodsorderquotationVo.class);
	 	return ObjectUtils.isEmpty(list) ? null : list.get(0);
	}

	@Override
	public List<GoodsorderquotationVo> getOtherBaojiaMessage(GoodsorderquotationVo vo) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append("SELECT  ");
		sql.append("	t1.contact_mobile as receiver, ");
		sql.append("	CONCAT('您好，', t.publish_id ,'货源单已有承运人以', " +  vo.getOutPrice().toString() + " ,'元/吨的价格承运，请选择其他货源进行报价,祝您成功!') as message, ");
		sql.append("	t.plat_form_id as platFormId,  ");
		sql.append("	'01' as sendType  ");
		sql.append("FROM goodsorderquotation t, company t1 ");
		sql.append("where t.plat_form_id = ? ");
		sql.append("	and t.company_id = t1.seq_id ");
		sql.append("	and t.publish_id = ? ");
		sql.append("	and t.status = '10' ");
		sql.append("	and t.company_id != ? ");
		sql.append("	group by t.company_id ");
		args.add(vo.getPlatFormId());
		args.add(vo.getPublishId());
		args.add(vo.getCompanyId());
		List<GoodsorderquotationVo> list = pageQuery.list(sql.toString(), args, GoodsorderquotationVo.class);
		return list;
	}
}
