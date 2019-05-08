package com.brcc.business.vatcompanyrecharge.repository.impl;

import com.brcc.business.config.mybatis.MybatisQuery;
import com.brcc.business.vatcompanyrecharge.entity.VatcompanyrechargeEntity;
import com.brcc.business.vatcompanyrecharge.repository.IVatCompanyRechargeRepository;
import com.brcc.business.vatcompanyrecharge.vo.VatCompanyRechargeQueryVo;
import com.esteel.common.dao.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Description: 委托方充值申请数据操作
 * @Auther: gemaochao
 * @Date:Created in 16:29 2018/11/13
 */
public class VatCompanyRechargeRepositoryImpl implements IVatCompanyRechargeRepository {

    @Autowired
    PageQuery pageQuery;

    @Autowired
    MybatisQuery mybatisQuery;


    @Override
    public Page<VatcompanyrechargeEntity> queryRecharge(VatCompanyRechargeQueryVo vo) {
        List<Object> arg = new ArrayList<>();
        StringBuffer sql = new StringBuffer("SELECT * FROM vatcompanyrecharge t WHERE  t.platform_id =?");
        arg.add(vo.getPlatformId());
        sql.append("    AND t.client_id =?");
        arg.add(vo.getClientId());

        if (!(StringUtils.isEmpty(vo.getCarryName()))){
            sql.append("   AND t.carry_name like ? ");
            arg.add("%"+vo.getCarryName()+"%");
        }
        if (vo.getCreateDateStart() != null){
            sql.append("     and t.create_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00')");
            arg.add(vo.getCreateDateStart());
        }
        if (vo.getCreateDateEnd() != null){
            sql.append("    and t.create_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59')");
            arg.add(vo.getCreateDateEnd());
        }
        if (!(StringUtils.isEmpty(vo.getStatus()))){
            sql.append("    AND    t.status=? ");
            arg.add(vo.getStatus());
            sql.append("    order by t.audit_date desc");
        }
        return pageQuery.query(sql.toString(),arg,vo,VatcompanyrechargeEntity.class);
    }

    @Override
    public List<VatCompanyRechargeQueryVo> queryRechargeForExcel(VatCompanyRechargeQueryVo vo) {
        List<Object> arg = new ArrayList<>();
        StringBuffer sql = new StringBuffer("SELECT vat_company_recharge_id,bank_amount,client_name,carry_name,carry_id,client_id,bank_amount_pic,create_remark, ");
        sql.append("    audit_remark,date_format(t.create_date,'%Y-%m-%d %H:%i:%s') as create_date,");
        sql.append("    date_format(t.audit_date,'%Y-%m-%d %H:%i:%s') as audit_date,");
        sql.append("    status,if(t.status=\"00\",\"作废\",if(t.status=\"05\",\"审核不通过\",if(t.status=\"90\",");
        sql.append("    \"审核通过\",if(t.status=\"10\",\"待审核\",if(t.status=\"25\",'红冲','业务审核')))))  as status");
        sql.append("    FROM vatcompanyrecharge t WHERE  t.platform_id =?");
        arg.add(vo.getPlatformId());
        sql.append("    AND t.client_id =?");
        arg.add(vo.getClientId());
        if (!(StringUtils.isEmpty(vo.getStatus()))){
            sql.append("    AND    t.status=? ");
            arg.add(vo.getStatus());
        }
        if (!(StringUtils.isEmpty(vo.getCarryName()))){
            sql.append("   AND t.carry_name like ? ");
            arg.add("%"+vo.getCarryName()+"%");
        }
        if (vo.getCreateDateStart() != null){
            sql.append("     and t.create_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00')");
            arg.add(vo.getCreateDateStart());
        }
        if (vo.getCreateDateEnd() != null){
            sql.append("    and t.create_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59')");
            arg.add(vo.getCreateDateEnd());
        }
//        sql.append("    order by t.create_date desc");
        return pageQuery.list(sql.toString(),arg,VatCompanyRechargeQueryVo.class);
    }

    @Override
    public Page<VatcompanyrechargeEntity> queryAuditRecharge(VatCompanyRechargeQueryVo vo) {
        List<Object> arg = new ArrayList<>();
        StringBuffer sql = new StringBuffer("   ");
        sql.append("   		SELECT" );
        sql.append("   		    t.vat_company_recharge_id," );
        sql.append("   		    t.client_id," );
        sql.append("   		    t.client_name," );
        sql.append("   			t.carry_id," );
        sql.append("   			t.carry_name," );
        sql.append("   			bank_amount," );
        sql.append("   			bank_amount_pic," );
        sql.append("   			create_remark," );
        sql.append("   			audit_remark," );
        sql.append("   			date_format(t.create_date,'%Y-%m-%d %H:%i:%s') as create_date," );
        sql.append("   			date_format(t.audit_date,'%Y-%m-%d %H:%i:%s') as audit_date," );
        sql.append("   			audit_person_name," );
        sql.append("   			audit_person_id," );
        sql.append("   			audit_remark," );
        sql.append("   			status" );
        sql.append("   		FROM vatCompanyRecharge t" );
        sql.append("   		where 1=1" );
        sql.append("   		and t.status >='05' " );
        sql.append("   		and t.status <= '90'" );
        sql.append("    		and t.carry_id =?" );
        arg.add(vo.getCarryId());
        sql.append("   		and	t.platform_id =?" );
        arg.add(vo.getPlatformId());

        if (!(StringUtils.isEmpty(vo.getClientName()))) {
            sql.append("    	   and     t.client_name like ?");
            arg.add("%"+vo.getClientName()+"%");
        }
        if (vo.getCreateDateStart() != null){
            sql.append("     and t.create_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00')");
            arg.add(vo.getCreateDateStart());
        }
        if (vo.getCreateDateEnd() != null){
            sql.append("    and t.create_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59')");
            arg.add(vo.getCreateDateEnd());
        }

        if (!(StringUtils.isEmpty(vo.getStatus()))) {
            sql.append("         and  t.status=?");
            arg.add(vo.getStatus());
            sql.append("    order by t.audit_date desc");
        }
        return pageQuery.query(sql.toString(),arg,vo,VatcompanyrechargeEntity.class);
    }

    @Override
    public List<VatCompanyRechargeQueryVo> queryTotalInAmount(VatCompanyRechargeQueryVo vo) {
        List<Object> arg = new ArrayList<>();
        StringBuffer sql = new StringBuffer("   ");
        sql.append("   	SELECT" );
        sql.append("   			round(ifnull(sum(bank_amount),0),2) as 'totalInAmount'" );
        sql.append("   		FROM vatCompanyRecharge t" );
        sql.append("   		where 1=1" );
        sql.append("   		and t.status >='05' " );
        sql.append("   		and t.status <= '90'" );
        sql.append("   		and t.carry_id =?" );
        arg.add(vo.getCarryId());
        sql.append("   		and 	t.platform_id =?" );
        arg.add(vo.getPlatformId());
        if (!(StringUtils.isEmpty(vo.getStatus()))) {
            sql.append("         and  t.status=?");
            arg.add(vo.getStatus());
        }
        if (!(StringUtils.isEmpty(vo.getClientName()))) {
            sql.append("    	   and     t.client_name like ?");
            arg.add("%"+vo.getClientName()+"%");
        }
        if (vo.getCreateDateStart() != null){
            sql.append("     and t.create_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00')");
            arg.add(vo.getCreateDateStart());
        }
        if (vo.getCreateDateEnd() != null){
            sql.append("    and t.create_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59')");
            arg.add(vo.getCreateDateEnd());
        }
        return pageQuery.list(sql.toString(),arg,VatCompanyRechargeQueryVo.class);
    }

    @Override
    public List<VatcompanyrechargeEntity> queryForDetail(VatCompanyRechargeQueryVo vo) {
        List<Object> arg = new ArrayList<>();
        StringBuffer sql = new StringBuffer("   ");
        sql.append("   		SELECT" );
        sql.append("   			t.vat_company_recharge_id," );
        sql.append("   			t.bank_amount," );
        sql.append("   			t.client_name," );
        sql.append("   			t.carry_name," );
        sql.append("   			t.carry_id," );
        sql.append("   			t.client_id," );
        sql.append("   			t.bank_amount_pic," );
        sql.append("   			t.create_remark," );
        sql.append("   			t.audit_remark," );
        sql.append("   			date_format(t.create_date,'%Y-%m-%d %H:%i:%s') as create_date," );
        sql.append("   			date_format(t.audit_date,'%Y-%m-%d %H:%i:%s') as audit_date," );
        sql.append("   			t.status," );
        sql.append("   			t.audit_person_name," );
        sql.append("   			if(t.status='00','作废',if(t.status='05','审核不通过',if(t.status='90','审核通过',if(t.status='10','待审核','红冲'))))  as status," );
        sql.append("   			t.audit_num," );
        sql.append("   			t1.create_person_name as 'createPersonName'," );
        sql.append("   			t1.audit_person_name as 'auditPersonName'," );
        sql.append("   			t.vat_audit_name as 'vatAuditName', " );
        sql.append("   			t.vat_director_name as 'vatDirectorName'" );
        sql.append("   		FROM vatcompanyrecharge t LEFT JOIN vatcompany_recharge_business t1 ON(t.business_num=t1.business_num) " );
        sql.append("   		WHERE 1=1" );
        sql.append("   		and t.platform_id =?" );
        arg.add(vo.getPlatformId());
        sql.append("   		and t.vat_company_recharge_id =?" );
        arg.add(vo.getVatCompanyRechargeId());
        if (vo.getCreateDateStart() != null){
            sql.append("     and t.create_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00')");
            arg.add(vo.getCreateDateStart());
        }
        if (vo.getCreateDateEnd() != null){
            sql.append("    and t.create_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59')");
            arg.add(vo.getCreateDateEnd());
        }
        return pageQuery.list(sql.toString(),arg,VatcompanyrechargeEntity.class);
    }

    @Override
    public List<VatCompanyRechargeQueryVo> queryForExcel(VatCompanyRechargeQueryVo vo) {
        List<Object> arg = new ArrayList<>();
        StringBuffer sql = new StringBuffer("   ");
        sql.append("   SELECT" );
        sql.append("   		    t.vat_company_recharge_id," );
        sql.append("   		    t.client_id," );
        sql.append("   		    t.client_name," );
        sql.append("   			t.carry_id," );
        sql.append("   			t.carry_name," );
        sql.append("   			bank_amount," );
        sql.append("   			bank_amount_pic," );
        sql.append("   			create_remark," );
        sql.append("   			audit_remark," );
        sql.append("   			date_format(t.create_date,'%Y-%m-%d %H:%i:%s') as create_date," );
        sql.append("   			date_format(t.audit_date,'%Y-%m-%d %H:%i:%s') as audit_date," );
        sql.append("   			audit_person_name," );
        sql.append("   			audit_person_id," );
        sql.append("   			audit_remark," );
        sql.append("   			status," );
        sql.append("   			if(t.status='00','作废',if(t.status='05','审核不通过',if(t.status='90','审核通过',if(t.status='10','待审核','红冲'))))  as status" );
        sql.append("   		FROM vatCompanyRecharge t" );
        sql.append("   		where 1=1" );
        sql.append("   		and status >='05' " );
        sql.append("   		and status <= '90'" );
        sql.append("   		and t.carry_id =?" );
        arg.add(vo.getCarryId());
        sql.append("   			and t.platform_id =?" );
        arg.add(vo.getPlatformId());
        if (!StringUtils.isEmpty(vo.getStatus())) {
            sql.append("   	        and t.status=?");
            arg.add(vo.getStatus());
        }
        if (!StringUtils.isEmpty(vo.getClientName())) {
            sql.append("   	        and t.client_name like ?");
            arg.add("%"+vo.getClientName()+"%");
        }
        if (vo.getCreateDateStart() != null){
            sql.append("     and t.create_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00')");
            arg.add(vo.getCreateDateStart());
        }
        if (vo.getCreateDateEnd() != null){
            sql.append("    and t.create_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59')");
            arg.add(vo.getCreateDateEnd());
        }
//        sql.append("    order by t.create_date desc");
        return pageQuery.list(sql.toString(),arg,VatCompanyRechargeQueryVo.class);
    }

    @Override
    public void capitalDetailPro(HashMap para) {
        mybatisQuery.executePro("credit.proCapitalDetail",para);
    }
}
