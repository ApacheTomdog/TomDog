package com.brcc.business.bank.service;

import com.brcc.business.bank.entity.BanksEntity;
import com.brcc.business.creditConfig.vo.CreditConfigAddCompanyVo;

import java.util.List;

/**
 * @Description:
 * @Auther: gemaochao
 * @Date:Created in 16:22 2018/11/12 
 */
public interface BanksService {

    
    /**
     * @Description  返回新增收款账号银行名
     * @Param [banksEntity]
     * @return java.util.List<com.brcc.business.creditConfig.vo.CreditConfigAddCompanyVo>
     **/
    List<CreditConfigAddCompanyVo> queryBankName(BanksEntity banksEntity);
}
