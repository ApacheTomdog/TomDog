package com.brcc.business.ordercancel.repository.impl;

import com.brcc.business.config.mybatis.MybatisQuery;
import com.brcc.business.ordercancel.entity.DeliverycancelauditEntity;
import com.brcc.business.ordercancel.repository.IOrderCancelRepository;
import com.brcc.business.ordercancel.vo.OrderCancelSearchVo;
import com.brcc.business.ordercancel.vo.OrderCancelVo;
import com.esteel.common.dao.PageQuery;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.util.ObjectUtils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 撤单审核数据接口实现类
 *
 * @author yushaohua
 * @create 2018-11-06 22:21
 */
public class OrderCancelRepositoryImpl implements IOrderCancelRepository {

    @Autowired
    PageQuery pageQuery;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    MybatisQuery mybatisQuery;

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    @Override
    public Map<String, Object> cancelDeliveryPro(Long deliveryCancelId) {
        List prmtrsList = new ArrayList();
        prmtrsList.add(new SqlParameter(Types.INTEGER));
        prmtrsList.add(new SqlOutParameter("as_out_result", Types.VARCHAR));
        prmtrsList.add(new SqlOutParameter("as_out_result_reason", Types.VARCHAR));

        Map<String, Object> resultData = jdbcTemplate.call(new CallableStatementCreator() {

            @Override
            public CallableStatement createCallableStatement(Connection connection)
                    throws SQLException {

                CallableStatement callableStatement = connection.prepareCall("{call pro_delivery_cancel_audit(?, ?, ?)}");
                callableStatement.setLong(1, deliveryCancelId);
                callableStatement.registerOutParameter(2, Types.VARCHAR);
                callableStatement.registerOutParameter(3, Types.VARCHAR);
                return callableStatement;

            }
        }, prmtrsList);
        return resultData;
    }

    @Override
    public Map<String, Object> blackListCheck(Long deliveryCancelId) {
        List prmtrsList = new ArrayList();
        prmtrsList.add(new SqlParameter(Types.INTEGER));
        prmtrsList.add(new SqlOutParameter("as_out_result", Types.VARCHAR));
        prmtrsList.add(new SqlOutParameter("as_out_result_reason", Types.VARCHAR));

        Map<String, Object> resultData = jdbcTemplate.call(new CallableStatementCreator() {

            @Override
            public CallableStatement createCallableStatement(Connection connection)
                    throws SQLException {

                CallableStatement callableStatement = connection.prepareCall("{call pro_fly_bill_check(?, ?, ?)}");
                callableStatement.setLong(1, deliveryCancelId);
                callableStatement.registerOutParameter(2, Types.VARCHAR);
                callableStatement.registerOutParameter(3, Types.VARCHAR);
                return callableStatement;

            }
        }, prmtrsList);
        return resultData;
    }

    @Override
    public Page<OrderCancelVo> findAllPage(OrderCancelSearchVo vo) {
        StringBuffer sql = new StringBuffer("SELECT ");
        sql.append("  d.delivery_cancel_id, ");
        sql.append("  d.platform_id, ");
        sql.append("  d.publish_id, ");
        sql.append("  d.trans_id, ");
        sql.append("  d.delivery_id, ");
        sql.append("  d.delivery_cancel_type, ");
        sql.append("  IF( ");
        sql.append("    d.delivery_cancel_type = '00', ");
        sql.append("    '撤销', ");
        sql.append("    IF( ");
        sql.append("      d.delivery_cancel_type = '05', ");
        sql.append("      '审核不通过', ");
        sql.append("      IF( ");
        sql.append("        d.delivery_cancel_type = '10', ");
        sql.append("        '待审核', ");
        sql.append("        '审核通过' ");
        sql.append("      ) ");
        sql.append("    ) ");
        sql.append("  ) AS deliveryCancelTypeDesc, ");
        sql.append("  d.remark, ");
        sql.append("  d.create_date, ");
        sql.append("  d.create_person_name, ");
        sql.append("  d.create_person_id, ");
        sql.append("  d.modify_date, ");
        sql.append("  d.carry_company_name, ");
        sql.append("  d.carry_company_id, ");
        sql.append("  d.driver_id, ");
        sql.append("  d.driver_name, ");
        sql.append("  d.vehicle_id, ");
        sql.append("  d.vehicle_num, ");
        sql.append("  d.modify_person_id, ");
        sql.append("  d.modify_person_name, ");
        sql.append("  d.audit_remark, ");
        sql.append("  d.audit_date, ");
        sql.append("  d.audit_person_id, ");
        sql.append("  d.audit_person_name, ");
        sql.append("  IF( ");
        sql.append("    d.docu_type = '1', ");
        sql.append("    '货主申请', ");
        sql.append("    IF( ");
        sql.append("      d.docu_type = '2', ");
        sql.append("      '司机申请', ");
        sql.append("      '未知' ");
        sql.append("    ) ");
        sql.append("  ) AS docuTypeDesc, ");
        sql.append("  d.docu_type ");
        sql.append("FROM ");
        sql.append("  deliverycancelaudit d ");
        sql.append("WHERE 1 = 1 ");
        sql.append(" AND d.platform_id = ? ");

        List<Object> args = new ArrayList<>();
        args.add(vo.getPlatformId());

        if (!ObjectUtils.isEmpty(vo.getRqStart())){
            sql.append(" AND d.create_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00') ");
            args.add(vo.getRqStart());
        }

        if (!ObjectUtils.isEmpty(vo.getRqEnd())){
            sql.append(" AND d.create_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59') ");
            args.add(vo.getRqEnd());
        }

        if (!ObjectUtils.isEmpty(vo.getTransId())){
            sql.append(" AND d.trans_id = ? ");
            args.add(vo.getTransId());
        }

        if (!ObjectUtils.isEmpty(vo.getPublishId())){
            sql.append(" AND d.publish_id = ? ");
            args.add(vo.getPublishId());
        }

        if (!ObjectUtils.isEmpty(vo.getDeliveryId())){
            sql.append(" AND d.delivery_id = ? ");
            args.add(vo.getDeliveryId());
        }

        if (!ObjectUtils.isEmpty(vo.getDeliveryCancelType())){
            sql.append(" AND d.delivery_cancel_type = ? ");
            args.add(vo.getDeliveryCancelType());
        }

        if (!ObjectUtils.isEmpty(vo.getCarryCompanyName())){
            sql.append(" AND d.carry_company_name like CONCAT('%', ?,'%') ");
            args.add(vo.getCarryCompanyName());
        }

        if (!ObjectUtils.isEmpty(vo.getDriverName())){
            sql.append(" AND d.driver_name like CONCAT('%', ?, '%') ");
            args.add(vo.getDriverName());
        }

        if (!ObjectUtils.isEmpty(vo.getVehicleNum())){
            sql.append(" AND d.vehicle_num like CONCAT('%', ?, '%') ");
            args.add(vo.getVehicleNum());
        }

        sql.append(" order by d.CREATE_DATE desc ");

        return pageQuery.query(sql.toString(), args, vo, OrderCancelVo.class);
    }

    @Override
    public List<OrderCancelVo> findAll(OrderCancelSearchVo vo) {
        StringBuffer sql = new StringBuffer("SELECT ");
        sql.append("  d.delivery_cancel_id, ");
        sql.append("  d.platform_id, ");
        sql.append("  d.publish_id, ");
        sql.append("  d.trans_id, ");
        sql.append("  d.delivery_id, ");
        sql.append("  d.delivery_cancel_type, ");
        sql.append("  IF( ");
        sql.append("    d.delivery_cancel_type = '00', ");
        sql.append("    '撤销', ");
        sql.append("    IF( ");
        sql.append("      d.delivery_cancel_type = '05', ");
        sql.append("      '审核不通过', ");
        sql.append("      IF( ");
        sql.append("        d.delivery_cancel_type = '10', ");
        sql.append("        '待审核', ");
        sql.append("        '审核通过' ");
        sql.append("      ) ");
        sql.append("    ) ");
        sql.append("  ) AS deliveryCancelTypeDesc, ");
        sql.append("  d.remark, ");
        sql.append("  d.create_date, ");
        sql.append("  d.create_person_name, ");
        sql.append("  d.create_person_id, ");
        sql.append("  d.modify_date, ");
        sql.append("  d.carry_company_name, ");
        sql.append("  d.carry_company_id, ");
        sql.append("  d.driver_id, ");
        sql.append("  d.driver_name, ");
        sql.append("  d.vehicle_id, ");
        sql.append("  d.vehicle_num, ");
        sql.append("  d.modify_person_id, ");
        sql.append("  d.modify_person_name, ");
        sql.append("  d.audit_remark, ");
        sql.append("  d.audit_date, ");
        sql.append("  d.audit_person_id, ");
        sql.append("  d.audit_person_name, ");
        sql.append("  IF( ");
        sql.append("    d.docu_type = '1', ");
        sql.append("    '货主申请', ");
        sql.append("    IF( ");
        sql.append("      d.docu_type = '2', ");
        sql.append("      '司机申请', ");
        sql.append("      '未知' ");
        sql.append("    ) ");
        sql.append("  ) AS docuTypeDesc, ");
        sql.append("  d.docu_type ");
        sql.append("FROM ");
        sql.append("  deliverycancelaudit d ");
        sql.append("WHERE 1 = 1 ");
        sql.append(" AND d.platform_id = ? ");

        List<Object> args = new ArrayList<>();
        args.add(vo.getPlatformId());

        if (!ObjectUtils.isEmpty(vo.getRqStart())){
            sql.append(" AND d.create_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00') ");
            args.add(vo.getRqStart());
        }

        if (!ObjectUtils.isEmpty(vo.getRqEnd())){
            sql.append(" AND d.create_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59') ");
            args.add(vo.getRqEnd());
        }

        if (!ObjectUtils.isEmpty(vo.getTransId())){
            sql.append(" AND d.trans_id = ? ");
            args.add(vo.getTransId());
        }

        if (!ObjectUtils.isEmpty(vo.getPublishId())){
            sql.append(" AND d.publish_id = ? ");
            args.add(vo.getPublishId());
        }

        if (!ObjectUtils.isEmpty(vo.getDeliveryId())){
            sql.append(" AND d.delivery_id = ? ");
            args.add(vo.getDeliveryId());
        }

        if (!ObjectUtils.isEmpty(vo.getDeliveryCancelType())){
            sql.append(" AND d.delivery_cancel_type = ? ");
            args.add(vo.getDeliveryCancelType());
        }

        if (!ObjectUtils.isEmpty(vo.getCarryCompanyName())){
            sql.append(" AND d.carry_company_name like CONCAT('%', ?,'%') ");
            args.add(vo.getCarryCompanyName());
        }

        if (!ObjectUtils.isEmpty(vo.getDriverName())){
            sql.append(" AND d.driver_name like CONCAT('%', ?, '%') ");
            args.add(vo.getDriverName());
        }

        if (!ObjectUtils.isEmpty(vo.getVehicleNum())){
            sql.append(" AND d.vehicle_num like CONCAT('%', ?, '%') ");
            args.add(vo.getVehicleNum());
        }

        sql.append(" order by d.CREATE_DATE desc ");

        return pageQuery.list(sql.toString(), args, OrderCancelVo.class);
    }

    @Override
    public void saveOrderCancel(Map<String, Object> paramMap) {
        sqlSessionTemplate.insert("deliverycancelaudit.insert", paramMap);
    }

    @Override
    public Page<OrderCancelVo> findAllPublisherPage(OrderCancelSearchVo vo) {
        StringBuffer sql = new StringBuffer("SELECT ");
        sql.append("  d.delivery_cancel_id, ");
        sql.append("  d.platform_id, ");
        sql.append("  d.publish_id, ");
        sql.append("  d.trans_id, ");
        sql.append("  d.delivery_id, ");
        sql.append("  d.delivery_cancel_type, ");
        sql.append("  d.remark, ");
        sql.append("  IF( ");
        sql.append("    d.delivery_cancel_type = '00', ");
        sql.append("    '撤销', ");
        sql.append("    IF( ");
        sql.append("      d.delivery_cancel_type = '05', ");
        sql.append("      '审核不通过', ");
        sql.append("      IF( ");
        sql.append("        d.delivery_cancel_type = '10', ");
        sql.append("        '待审核', ");
        sql.append("        '审核通过' ");
        sql.append("      ) ");
        sql.append("    ) ");
        sql.append("  ) AS deliveryCancelTypeDesc, ");
        sql.append("  DATE_FORMAT( ");
        sql.append("    d.create_date, ");
        sql.append("    '%Y-%m-%d %H:%i:%s' ");
        sql.append("  ) AS create_date, ");
        sql.append("  d.create_person_name, ");
        sql.append("  d.create_person_id, ");
        sql.append("  DATE_FORMAT( ");
        sql.append("    d.modify_date, ");
        sql.append("    '%Y-%m-%d %H:%i:%s' ");
        sql.append("  ) AS modify_date, ");
        sql.append("  d.carry_company_name, ");
        sql.append("  d.carry_company_id, ");
        sql.append("  d.driver_id, ");
        sql.append("  d.driver_name, ");
        sql.append("  d.vehicle_id, ");
        sql.append("  d.vehicle_num, ");
        sql.append("  d.modify_person_id, ");
        sql.append("  d.modify_person_name, ");
        sql.append("  d.audit_remark, ");
        sql.append("  DATE_FORMAT( ");
        sql.append("    d.audit_date, ");
        sql.append("    '%Y-%m-%d %H:%i:%s' ");
        sql.append("  ) AS audit_date, ");
        sql.append("  d.audit_person_id, ");
        sql.append("  d.audit_person_name, ");
        sql.append("  IF( ");
        sql.append("    d.docu_type = '1', ");
        sql.append("    '货主申请', ");
        sql.append("    IF( ");
        sql.append("      d.docu_type = '2', ");
        sql.append("      '司机申请', ");
        sql.append("      '未知' ");
        sql.append("    ) ");
        sql.append("  ) AS docuTypeDesc, ");
        sql.append("  d.docu_type ");
        sql.append("FROM ");
        sql.append("  deliverycancelaudit d ");
        sql.append("WHERE 1 = 1 ");
        sql.append(" AND  d.platform_id = ? ");
        sql.append(" and  d.fd_company_id = ? ");
        sql.append(" and d.docu_type ='1' ");

        List<Object> args = new ArrayList<>();
        args.add(vo.getPlatformId());
        args.add(vo.getCompanyId());

        if ("N".equalsIgnoreCase(vo.getIfShowAdmin())){
            if("TMS".equalsIgnoreCase(vo.getAccountFrom())){
                sql.append(" and d.if_can_show ='Y' ");
            }else if("DS".equalsIgnoreCase(vo.getAccountFrom())){
                sql.append(" and d.if_can_show ='N' and d.fd_user_id = ? ");
                args.add(vo.getUserId());
            }
        }

        if (!ObjectUtils.isEmpty(vo.getRqStart())){
            sql.append(" AND d.create_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00') ");
            args.add(vo.getRqStart());
        }

        if (!ObjectUtils.isEmpty(vo.getRqEnd())){
            sql.append(" AND d.create_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59') ");
            args.add(vo.getRqEnd());
        }

        if (!ObjectUtils.isEmpty(vo.getTransId())){
            sql.append(" AND d.trans_id = ? ");
            args.add(vo.getTransId());
        }

        if (!ObjectUtils.isEmpty(vo.getPublishId())){
            sql.append(" AND d.publish_id = ? ");
            args.add(vo.getPublishId());
        }

        if (!ObjectUtils.isEmpty(vo.getDeliveryId())){
            sql.append(" AND d.delivery_id = ? ");
            args.add(vo.getDeliveryId());
        }

        if (!ObjectUtils.isEmpty(vo.getDeliveryCancelType())){
            sql.append(" AND d.delivery_cancel_type = ? ");
            args.add(vo.getDeliveryCancelType());
        }

        if (!ObjectUtils.isEmpty(vo.getCarryCompanyName())){
            sql.append(" AND d.carry_company_name like CONCAT('%',?,'%') ");
            args.add(vo.getCarryCompanyName());
        }

        if (!ObjectUtils.isEmpty(vo.getDriverName())){
            sql.append(" AND d.driver_name like CONCAT('%',?,'%') ");
            args.add(vo.getDriverName());
        }

        if (!ObjectUtils.isEmpty(vo.getVehicleNum())){
            sql.append(" AND d.vehicle_num like CONCAT('%',?,'%') ");
            args.add(vo.getVehicleNum());
        }

        sql.append(" order by d.CREATE_DATE desc ");

        return pageQuery.query(sql.toString(), args, vo, OrderCancelVo.class);
    }

    @Override
    public List<OrderCancelVo> findAllPublisherList(OrderCancelSearchVo vo) {
        StringBuffer sql = new StringBuffer("SELECT ");
        sql.append("  d.delivery_cancel_id, ");
        sql.append("  d.platform_id, ");
        sql.append("  d.publish_id, ");
        sql.append("  d.trans_id, ");
        sql.append("  d.delivery_id, ");
        sql.append("  d.delivery_cancel_type, ");
        sql.append("  d.remark, ");
        sql.append("  IF( ");
        sql.append("    d.delivery_cancel_type = '00', ");
        sql.append("    '撤销', ");
        sql.append("    IF( ");
        sql.append("      d.delivery_cancel_type = '05', ");
        sql.append("      '审核不通过', ");
        sql.append("      IF( ");
        sql.append("        d.delivery_cancel_type = '10', ");
        sql.append("        '待审核', ");
        sql.append("        '审核通过' ");
        sql.append("      ) ");
        sql.append("    ) ");
        sql.append("  ) AS deliveryCancelTypeDesc, ");
        sql.append("  DATE_FORMAT( ");
        sql.append("    d.create_date, ");
        sql.append("    '%Y-%m-%d %H:%i:%s' ");
        sql.append("  ) AS create_date, ");
        sql.append("  d.create_person_name, ");
        sql.append("  d.create_person_id, ");
        sql.append("  DATE_FORMAT( ");
        sql.append("    d.modify_date, ");
        sql.append("    '%Y-%m-%d %H:%i:%s' ");
        sql.append("  ) AS modify_date, ");
        sql.append("  d.carry_company_name, ");
        sql.append("  d.carry_company_id, ");
        sql.append("  d.driver_id, ");
        sql.append("  d.driver_name, ");
        sql.append("  d.vehicle_id, ");
        sql.append("  d.vehicle_num, ");
        sql.append("  d.modify_person_id, ");
        sql.append("  d.modify_person_name, ");
        sql.append("  d.audit_remark, ");
        sql.append("  DATE_FORMAT( ");
        sql.append("    d.audit_date, ");
        sql.append("    '%Y-%m-%d %H:%i:%s' ");
        sql.append("  ) AS audit_date, ");
        sql.append("  d.audit_person_id, ");
        sql.append("  d.audit_person_name, ");
        sql.append("  IF( ");
        sql.append("    d.docu_type = '1', ");
        sql.append("    '货主申请', ");
        sql.append("    IF( ");
        sql.append("      d.docu_type = '2', ");
        sql.append("      '司机申请', ");
        sql.append("      '未知' ");
        sql.append("    ) ");
        sql.append("  ) AS docuTypeDesc, ");
        sql.append("  d.docu_type ");
        sql.append("FROM ");
        sql.append("  deliverycancelaudit d ");
        sql.append("WHERE 1 = 1 ");
        sql.append(" AND  d.platform_id = ? ");
        sql.append(" and  d.fd_company_id = ? ");
        sql.append(" and d.docu_type ='1' ");

        List<Object> args = new ArrayList<>();
        args.add(vo.getPlatformId());
        args.add(vo.getCompanyId());

        if ("N".equalsIgnoreCase(vo.getIfShowAdmin())){
            if("TMS".equalsIgnoreCase(vo.getAccountFrom())){
                sql.append(" and d.if_can_show ='Y' ");
            }else if("DS".equalsIgnoreCase(vo.getAccountFrom())){
                sql.append(" and d.if_can_show ='N' and d.fd_user_id = ? ");
                args.add(vo.getUserId());
            }
        }

        if (!ObjectUtils.isEmpty(vo.getRqStart())){
            sql.append(" AND d.create_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00') ");
            args.add(vo.getRqStart());
        }

        if (!ObjectUtils.isEmpty(vo.getRqEnd())){
            sql.append(" AND d.create_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59') ");
            args.add(vo.getRqEnd());
        }

        if (!ObjectUtils.isEmpty(vo.getTransId())){
            sql.append(" AND d.trans_id = ? ");
            args.add(vo.getTransId());
        }

        if (!ObjectUtils.isEmpty(vo.getPublishId())){
            sql.append(" AND d.publish_id = ? ");
            args.add(vo.getPublishId());
        }

        if (!ObjectUtils.isEmpty(vo.getDeliveryId())){
            sql.append(" AND d.delivery_id = ? ");
            args.add(vo.getDeliveryId());
        }

        if (!ObjectUtils.isEmpty(vo.getDeliveryCancelType())){
            sql.append(" AND d.delivery_cancel_type = ? ");
            args.add(vo.getDeliveryCancelType());
        }

        if (!ObjectUtils.isEmpty(vo.getCarryCompanyName())){
            sql.append(" AND d.carry_company_name like CONCAT('%',?,'%') ");
            args.add(vo.getCarryCompanyName());
        }

        if (!ObjectUtils.isEmpty(vo.getDriverName())){
            sql.append(" AND d.driver_name like CONCAT('%',?,'%') ");
            args.add(vo.getDriverName());
        }

        if (!ObjectUtils.isEmpty(vo.getVehicleNum())){
            sql.append(" AND d.vehicle_num like CONCAT('%',?,'%') ");
            args.add(vo.getVehicleNum());
        }

        sql.append(" order by d.CREATE_DATE desc ");

        return pageQuery.list(sql.toString(), args, OrderCancelVo.class);
    }
}