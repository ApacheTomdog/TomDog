package com.brcc.business.bank.repository.impl;

import com.brcc.business.bank.entity.BanksEntity;
import com.brcc.business.bank.repository.IBanksRepository;
import com.brcc.business.creditConfig.vo.CreditConfigAddCompanyVo;
import com.esteel.common.dao.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 银行名
 * @Auther: gemaochao
 * @Date:Created in 16:22 2018/11/12
 */
public class BanksRepositoryImpl implements IBanksRepository {

    @Autowired
    PageQuery pageQuery;


    @Override
    public List<CreditConfigAddCompanyVo> queryBankName(BanksEntity banksEntity) {
        List<Object> arg = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select t.bank_name as \"queryValue\", t.seq_id as \"queryKey\"  from banks t");
        sql.append("    where  t.platform_id = ?");
        arg.add(banksEntity.getPlatformId());
        if (!(StringUtils.isEmpty(banksEntity.getBankName()))) {
            sql.append("    AND t.bank_name like?");
            arg.add("%"+banksEntity.getBankName()+"%");
        }
        return pageQuery.list(sql.toString(),arg,CreditConfigAddCompanyVo.class);
    }
}
