package com.brcc.business.vatcapital.repository.impl;

import com.brcc.business.vatcapital.entity.VatcapitaldetailEntity;
import com.brcc.business.vatcapital.repository.IVatCapitalDetailRepository;
import com.brcc.business.vatcapital.vo.VatcapitaldetailQueryVo;
import com.esteel.common.dao.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * @Description:
 * @Auther: gemaochao
 * @Date:Created in 13:18 2018/11/16
 */
public class VatCapitalDetailRepositoryImpl implements IVatCapitalDetailRepository {

    @Autowired
    PageQuery pageQuery;

    @Override
    public Page<VatcapitaldetailQueryVo> queryForDetail(VatcapitaldetailQueryVo vo) {
        List<Object> arg = new ArrayList<>();
        StringBuffer sql  = new StringBuffer("  ");
        sql.append("   SELECT" );
        sql.append("   			 t.vat_capital_detail_id," );
        sql.append("   			  t.client_id," );
        sql.append("     			t.client_name," );
        sql.append("     			t.carry_id," );
        sql.append("     			t.carry_name," );
        sql.append("     			t.platform_id," );
        sql.append("     			t.in_amount," );
        sql.append("     			t.out_amount," );
        sql.append("           	if(t.block_status='10',t.block_in_amount,0.00) as  'block_in_amount'," );
        sql.append("           	if(t.block_status='10',t.block_out_amount,0.00) as 'block_out_amount'," );
        sql.append("     			(t.in_amount - t.out_amount) as 'amount'," );
        sql.append("     			if(t.docu_type='10','充值',if(t.docu_type='20','提现',if(t.docu_type='30','支付',if(t.docu_type='40','收款',if(t.docu_type='50','封锁',if(t.docu_type='80','预付款退款',if(t.docu_type='25','红冲'," );
        sql.append("     			if(t.docu_type='90','业务资金调整',if(t.docu_type='91','资金授信',if(t.docu_type='92','授信还款','未知')))))))))) as docuType," );
        sql.append("     			date_format(t.create_date,'%Y-%m-%d %H:%i:%s')  as 'create_date'," );
        sql.append("     			date_format(t.modify_date,'%Y-%m-%d %H:%i:%s')  as 'modify_date'," );
        sql.append("     			t.docu_num," );
        sql.append("     			t.docu_memo" );
        sql.append("   		FROM vatcapitaldetail t" );
        sql.append("   		WHERE 1=1" );
        sql.append("   		and t.platform_id =?" );
        arg.add(vo.getPlatformId());
        sql.append("    		and t.carry_id =?" );
        arg.add(vo.getCarryId());
        sql.append("   		and t.client_id =?" );
        arg.add(vo.getClientId());
        if (!StringUtils.isEmpty(vo.getDocuType())) {
            sql.append("         AND  t.docu_type=?");
            arg.add(vo.getDocuType());
        }
        if (vo.getModifyStart() != null){
            sql.append("    and t.modify_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00')");
            arg.add(vo.getModifyStart());
        }
        if (vo.getModifyEnd() != null){
            sql.append("    and t.modify_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59')");
            arg.add(vo.getModifyEnd());
        }
        sql.append("   	    and t.docu_type not in ('60')	" );

        return pageQuery.query(sql.toString(),arg,vo,VatcapitaldetailQueryVo.class);
    }

    @Override
    public List<VatcapitaldetailQueryVo> excelForMaster(VatcapitaldetailQueryVo vo) {
        List<Object> arg = new ArrayList<>();
        StringBuffer sql  = new StringBuffer("  ");
        sql.append("   SELECT" );
        sql.append("   			 t.vat_capital_detail_id," );
        sql.append("   			  t.client_id," );
        sql.append("     			t.client_name," );
        sql.append("     			t.carry_id," );
        sql.append("     			t.carry_name," );
        sql.append("     			t.platform_id," );
        sql.append("     			t.in_amount," );
        sql.append("     			t.out_amount," );
        sql.append("           	if(t.block_status='10',t.block_in_amount,0.00) as  'block_in_amount'," );
        sql.append("           	if(t.block_status='10',t.block_out_amount,0.00) as 'block_out_amount'," );
        sql.append("     			(t.in_amount - t.out_amount) as 'amount'," );
        sql.append("     			if(t.docu_type='10','充值',if(t.docu_type='20','提现',if(t.docu_type='30','支付',if(t.docu_type='40','收款',if(t.docu_type='50','封锁',if(t.docu_type='80','预付款退款',if(t.docu_type='25','红冲'," );
        sql.append("     			if(t.docu_type='90','业务资金调整',if(t.docu_type='91','资金授信',if(t.docu_type='92','授信还款','未知')))))))))) as docuType," );
        sql.append("     			date_format(t.create_date,'%Y-%m-%d %H:%i:%s')  as 'create_date'," );
        sql.append("     			date_format(t.modify_date,'%Y-%m-%d %H:%i:%s')  as 'modify_date'," );
        sql.append("     			t.docu_num," );
        sql.append("     			t.docu_memo" );
        sql.append("   		FROM vatcapitaldetail t" );
        sql.append("   		WHERE 1=1" );
        sql.append("   		and t.platform_id =?" );
        arg.add(vo.getPlatformId());
        sql.append("    		and t.carry_id =?" );
        arg.add(vo.getCarryId());
        sql.append("   		and t.client_id =?" );
        arg.add(vo.getClientId());
        if (!StringUtils.isEmpty(vo.getDocuType())) {
            sql.append("         AND  t.docu_type=?");
            arg.add(vo.getDocuType());
        }
        if (vo.getModifyStart() != null){
            sql.append("    and t.modify_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00')");
            arg.add(vo.getModifyStart());
        }
        if (vo.getModifyEnd() != null){
            sql.append("    and t.modify_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59')");
            arg.add(vo.getModifyEnd());
        }
        sql.append("   	    and t.docu_type not in ('60')	" );
        sql.append("     order by t.modify_date desc");
        return pageQuery.list(sql.toString(),arg,VatcapitaldetailQueryVo.class);
    }
}
