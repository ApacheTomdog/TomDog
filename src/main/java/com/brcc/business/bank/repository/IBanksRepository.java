package com.brcc.business.bank.repository;

import com.brcc.business.bank.entity.BanksEntity;
import com.brcc.business.creditConfig.vo.CreditConfigAddCompanyVo;

import java.util.List;

/**
 * @Description: 銀行名
 * @Auther: gemaochao
 * @Date:Created in 16:20 2018/11/12
 */
public interface IBanksRepository {

    
    /**
     * @Description  返回新增收款账号银行名称
     * @Param [banksEntity]
     * @return java.util.List<com.brcc.business.creditConfig.vo.CreditConfigAddCompanyVo>
     **/
    List<CreditConfigAddCompanyVo> queryBankName(BanksEntity banksEntity);
}
