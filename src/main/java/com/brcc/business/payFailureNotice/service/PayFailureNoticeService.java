package com.brcc.business.payFailureNotice.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.brcc.business.payFailureNotice.vo.PayFailureNoticeQueryVo;
import com.brcc.business.payFailureNotice.vo.PayFailureNoticeVo;


public interface PayFailureNoticeService {
	
	 /**
	  * 查询
	  * @param vo
	  * @return
	  */
	 Page<PayFailureNoticeVo> queryList(PayFailureNoticeQueryVo vo);
	
}
