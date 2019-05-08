package com.brcc.business.paybillgoods.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brcc.business.paybillgoods.entity.PayBillGoodEntity;



/**
 * @Description
 * @author yangwenbin
 * @version 创建时间：2018年11月15日 下午4:09:42
 */
public interface PayBillGoodsRepository extends JpaRepository<PayBillGoodEntity, Long> {

}
