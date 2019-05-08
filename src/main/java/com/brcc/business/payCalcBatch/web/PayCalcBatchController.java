package com.brcc.business.payCalcBatch.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brcc.business.payCalcBatch.service.PayCalcBatchService;
import com.brcc.business.payCalcBatch.vo.PayCalcBatchQueryVo;
import com.brcc.business.payCalcBatch.vo.PayCalcBatchVo;

/**
 * 批量运费计算结果
 * @author panyinfang
 *
 */
@RestController
@RequestMapping("/payCalcBatch")
public class PayCalcBatchController {

	Logger logger = LoggerFactory.getLogger(PayCalcBatchController.class);
	@Autowired
	PayCalcBatchService payCalcBatchService;
	
	
	/**
	 *  批量运费计算结果列表
	 * 
	 * @param queryvo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/listDataList", method = RequestMethod.POST)
	public Page<PayCalcBatchVo> listDataList(@RequestBody PayCalcBatchQueryVo queryvo) {
		logger.info("queryList params:", queryvo.toString());
		Page<PayCalcBatchVo> page = payCalcBatchService.listDataList(queryvo);
		return page;
	}

}
