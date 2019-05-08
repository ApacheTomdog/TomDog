package com.brcc.business.payFailureNotice.repository;

import org.springframework.data.domain.Page;

import com.brcc.business.payFailureNotice.vo.PayFailureNoticeQueryVo;
import com.brcc.business.payFailureNotice.vo.PayFailureNoticeVo;


/**
* @author 
* @version 创建时间：2018年10月30日 下午9:02:44
* @ClassName 类名称
* @Description 
*/
public interface IPayFailureNoticeRepository {
	 /**
     * 分页查询
     * @param vo
     * @return
     */

	Page<PayFailureNoticeVo> queryListPage(PayFailureNoticeQueryVo vo);

}
