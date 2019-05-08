package com.brcc.business.bank.service.impl;

import com.brcc.business.bank.entity.BanksEntity;
import com.brcc.business.bank.repository.BanksRepository;
import com.brcc.business.bank.service.BanksService;
import com.brcc.business.creditConfig.vo.CreditConfigAddCompanyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Auther: gemaochao
 * @Date:Created in 16:23 2018/11/12
 */
@Service
public class BanksServiceImpl implements BanksService {

    @Autowired
    BanksRepository banksRepository;

    @Override
    public List<CreditConfigAddCompanyVo> queryBankName(BanksEntity banksEntity) {
        return banksRepository.queryBankName(banksEntity);
    }
}
