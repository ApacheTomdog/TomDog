/**
 * 
 */
package com.brcc.business.flow.repository;

import java.util.List;

import com.brcc.business.flow.entity.VatflowdetailEntity;
import com.brcc.business.flow.vo.VatflowdetailCompanyNameVo;
import com.brcc.business.flow.vo.VatflowdetailVo;
import com.brcc.business.flow.vo.VatflowmasterQueryVo;
import com.brcc.business.vatcompanyrecharge.vo.VatCompanyRechargeQueryVo;

/**
 * @Description:
 * @author:陈利
 * @date:2018年11月14日
 * 
 */
public interface IVatflowdetailRepository {

	/**
	 * @Desc: 根据发货公司查询委托承运流程
	 * @param: publishCompanyId:queryVo.getPublishCompanyId()
	 * @return: List<VatflowdetailEntity>
	 */
	List<VatflowdetailEntity> listByPulishCompanyId(Long publishCompanyId);

	/**
	 * @Description  返回当公司非业务分离时添加充值承运公司信息
	 * @Param [platformId, clientId]
	 * @return java.util.List<com.brcc.business.vatflow.vo.VatflowdetailQueryVo>
	 **/
	List<VatflowdetailCompanyNameVo> queryForCompanyName(VatCompanyRechargeQueryVo vo);
		
	/**
	 * 根据发单公司查询流程信息
	 * @Param companyId
	 * @return VatflowdetailVo
	 **/
	List<VatflowdetailVo> queryForCompanyName(Long pulishCompanyId);
	
	/**
     * @Desc 委托承运流程查询 
     * @param vo
     */
	List<VatflowdetailVo> queryTaxRate(VatflowmasterQueryVo vo);
}
