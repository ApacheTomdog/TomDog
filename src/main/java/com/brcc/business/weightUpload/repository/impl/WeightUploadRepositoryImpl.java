package com.brcc.business.weightUpload.repository.impl;

import com.brcc.business.weightUpload.repository.IWeightUploadRepository;
import com.brcc.business.weightUpload.vo.WeightUploadSearchVo;
import com.brcc.business.weightUpload.vo.WeightUploadVo;
import com.esteel.common.dao.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 装卸货重量数据接口实现类
 *
 * @author yushaohua
 * @create 2018-11-28 16:13
 */
public class WeightUploadRepositoryImpl implements IWeightUploadRepository {

    @Autowired
    PageQuery pageQuery;

    @Override
    public Page<WeightUploadVo> queryDelieryImport(WeightUploadSearchVo vo) {
        StringBuffer sql = new StringBuffer("SELECT ");
        sql.append("  t.id, ");
        sql.append("  FORMAT(t.batch_id, 0) AS batch_id, ");
        sql.append("  (SELECT ");
        sql.append("    c.company_name ");
        sql.append("  FROM ");
        sql.append("    company c ");
        sql.append("  WHERE c.seq_id = t.publish_company_id) AS companyName, ");
        sql.append("  t.delivery_id, ");
        sql.append("  t.truck_loading_weight, ");
        sql.append("  t.truck_loading_date, ");
        sql.append("  t.take_delivery_weight, ");
        sql.append("  t.take_delivery_date, ");
        sql.append("  t.status AS statusDesc, ");
        sql.append("  IF( ");
        sql.append("    t.status = '10', ");
        sql.append("    '未处理', ");
        sql.append("    '已处理' ");
        sql.append("  ) AS STATUS, ");
        sql.append("  t.proc_result, ");
        sql.append("  (SELECT ");
        sql.append("    l.user_name ");
        sql.append("  FROM ");
        sql.append("    loginverify l ");
        sql.append("  WHERE l.user_id = t.create_person) AS userName, ");
        sql.append("  t.create_date, ");
        sql.append("  t.proc_date ");
        sql.append("FROM ");
        sql.append("  uploadweight t ");
        sql.append("WHERE t.publish_company_id = ? ");

        List<Object> args = new ArrayList<>();
        args.add(vo.getCompanyId());

        if (!ObjectUtils.isEmpty(vo.getBatchId())){
            sql.append(" AND t.batch_id = ? ");
            args.add(vo.getBatchId());
        }

        if (!ObjectUtils.isEmpty(vo.getDeliveryId())){
            sql.append(" AND t.delivery_id = ? ");
            args.add(vo.getDeliveryId());
        }

        if (!ObjectUtils.isEmpty(vo.getStatus())){
            sql.append(" AND t.status = ? ");
            args.add(vo.getStatus());
        }

        if (!ObjectUtils.isEmpty(vo.getRqStart())){
            sql.append(" AND t.create_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00') ");
            args.add(vo.getRqStart());
        }

        if (!ObjectUtils.isEmpty(vo.getRqEnd())){
            sql.append(" AND t.create_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59') ");
            args.add(vo.getRqEnd());
        }

        sql.append(" order by t.CREATE_DATE desc ");

        return pageQuery.query(sql.toString(), args, vo, WeightUploadVo.class);
    }
}