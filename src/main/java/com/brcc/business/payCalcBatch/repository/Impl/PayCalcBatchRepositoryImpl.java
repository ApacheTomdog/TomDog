package com.brcc.business.payCalcBatch.repository.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.ObjectUtils;

import com.brcc.business.payCalcBatch.repository.IPayCalcBatchRepository;
import com.brcc.business.payCalcBatch.vo.PayCalcBatchQueryVo;
import com.brcc.business.payCalcBatch.vo.PayCalcBatchVo;
import com.brcc.business.payFailureNotice.vo.PayFailureNoticeVo;
import com.brcc.business.priceChange.vo.PriceChangeVo;
import com.esteel.common.dao.PageQuery;

/**
 * 批量运费计算结果
 * @author panyinfang
 *
 */

public class PayCalcBatchRepositoryImpl implements IPayCalcBatchRepository{
	
	@Autowired
	PageQuery pageQuery;

	@Override
	public Page<PayCalcBatchVo> listDataList(PayCalcBatchQueryVo queryvo) {
	
		StringBuffer sql = new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		sql.append(" select * from pay_calc_batch where ");
		sql.append(" platform_id = ? ");
		params.add(queryvo.getPlatformId());
		if(!ObjectUtils.isEmpty(queryvo.getBatchId())) {
			 sql.append(" and batch_id like ? ");
			 params.add("%" + queryvo.getBatchId() + "%");
		}
		if(!ObjectUtils.isEmpty(queryvo.getPublishId())) {
			 sql.append(" and publish_id like  ? ");
			 params.add("%" + queryvo.getPublishId() + "%");
		}
		if(!ObjectUtils.isEmpty(queryvo.getTransId())) {
			 sql.append(" and trans_id like ? ");
			 params.add("%" + queryvo.getTransId() + "%");
		}
		if(!ObjectUtils.isEmpty(queryvo.getDeliveryId())) {
			 sql.append(" and delivery_id like ? ");
			 params.add("%" + queryvo.getDeliveryId() + "%");
		}
		if(!ObjectUtils.isEmpty(queryvo.getCalcStatus())) {
			 sql.append(" and calc_status = ? ");
			 params.add(queryvo.getCalcStatus());
		}
	
		sql.append(" order by create_date desc ");
		Page<PayCalcBatchVo> page = pageQuery.query(sql.toString(), params, queryvo, PayCalcBatchVo.class);
		return page;

	}

}
