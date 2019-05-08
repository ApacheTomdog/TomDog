package com.brcc.business.payFailureNotice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.brcc.business.payFailureNotice.entity.PayFailureNoticeEntity;
import com.brcc.business.payFailureNotice.vo.PayFailureNoticeQueryVo;
import com.brcc.business.payFailureNotice.vo.PayFailureNoticeVo;

/**
* @author 
* @version 创建时间：2018年10月30日 下午9:01:18
* @Descripe 
*/

public interface PayFailureNoticeRepository extends JpaRepository<PayFailureNoticeEntity,Long>,IPayFailureNoticeRepository{

	
	  
}
