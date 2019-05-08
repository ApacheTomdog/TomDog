package com.brcc.business.bank.repository;

import com.brcc.business.bank.entity.BanksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description: 銀行名
 * @Auther: gemaochao
 * @Date:Created in 16:20 2018/11/12
 */
public interface BanksRepository extends JpaRepository<BanksEntity,Long>,IBanksRepository {
}