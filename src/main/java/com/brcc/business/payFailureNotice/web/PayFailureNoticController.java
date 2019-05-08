package com.brcc.business.payFailureNotice.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.brcc.business.payFailureNotice.service.PayFailureNoticeService;
import com.brcc.business.payFailureNotice.vo.PayFailureNoticeQueryVo;
import com.brcc.business.payFailureNotice.vo.PayFailureNoticeVo;
import org.springframework.web.bind.annotation.*;
/**
 * 查询
 * 
 * @author pan
 *
 */
@RestController
@RequestMapping("/payfailurenotice")
public class PayFailureNoticController {
	Logger logger = LoggerFactory.getLogger(PayFailureNoticController.class);

	@Autowired
	PayFailureNoticeService payFailureNoticeService;

	/**
	 * 分页列表数据
	 * 
	 * @param vo 查询封装的接收类
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/listForPlat", method = RequestMethod.POST)
	public Page<PayFailureNoticeVo> queryList(@RequestBody PayFailureNoticeQueryVo vo) {

		logger.info("queryList params:", vo.toString());
		Page<PayFailureNoticeVo> page = payFailureNoticeService.queryList(vo);
		return page;
	}
	
	@ResponseBody
	@RequestMapping(value = "/listFor", method = RequestMethod.POST)
	public Page<PayFailureNoticeVo> listFor(@RequestBody PayFailureNoticeQueryVo vo) {

		logger.info("queryList params:", vo.toString());
		Page<PayFailureNoticeVo> page = payFailureNoticeService.queryList(vo);
		return page;
	}

}