package com.brcc.business.Interface.InterfaceOfCw.service;

import com.brcc.business.Interface.InterfaceOfCw.vo.CancelBillVo;
import com.brcc.business.Interface.InterfaceOfCw.vo.GoodsUploadVo;
import com.brcc.business.Interface.InterfaceOfCw.vo.OutWeightVo;
import com.brcc.business.Interface.InterfaceOfCw.vo.Result;

/**
* 川威后台逻辑处理Service
* 
* @author 万强
*
* 2019年4月22日
*/
public interface CwEcService {
	
	Result goodsUpload(GoodsUploadVo vo);
	/**
	 * 返单量上传
	 * @param vo 封装的接收类
	 * @return
	 */
	Result outWeight(OutWeightVo vo);
	/**
	 * 撤销单据
	 * @param vo 封装的接收类
	 * @return
	 */
	Result cancelBill(CancelBillVo vo);

	void dispatchToCWEcTask();
	
	void reinfotocwTask();

}

