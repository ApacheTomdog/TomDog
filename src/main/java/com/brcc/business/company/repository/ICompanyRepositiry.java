package com.brcc.business.company.repository;

import org.springframework.data.domain.Page;

import com.brcc.business.company.vo.CompanySearchVo;
import com.brcc.business.company.vo.CompanyVo;
import com.brcc.business.creditConfig.vo.CreditConfigAddCompanyVo;
import com.brcc.business.creditConfig.vo.CreditConfigQueryVo;
import com.brcc.business.oilManager.vo.OilManagerQueryVo;
import com.brcc.business.oilManager.vo.OilManagerVo;

/**
 * @Description: 委托方公司数据操作接口
 * @Auther: gemaochao
 * @Date:Created in 16:23 2018/11/1
 */
public interface ICompanyRepositiry {

    /**
     * @Author gemaochao
     * @Description //TODO 返回委托方授信新增公司选项数据
     * @Date 16:36 2018/11/1
     * @Param [creditConfigQueryVo]
     * @return com.brcc.business.creditConfig.vo.CreditConfigAddCompanyVo
     **/
    Page<CreditConfigAddCompanyVo> creditCompany(CreditConfigQueryVo creditConfigQueryVo);

    /**
     * 获取飞单对象
     * @param vo
     * @return
     */
    Page<CompanyVo> findPersonTeam(CompanySearchVo vo);
    
    /**
     * 检查是否在货主的黑名单中
     * @param publishId
     * @param companyId
     */
    CompanyVo findDriverFdrBlack(CompanySearchVo companySearchVo);
    
    /**
     * 检查是否在货主的黑名单中
     * @param publishId
     * @param companyId
     */
    CompanyVo queryGrabMoney(Long publishId, String platformId);


    /**
     * @Description  业务员管理页面公司名称
     * @Param [vo]
     * @return org.springframework.data.domain.Page<com.brcc.business.company.vo.CompanyVo>
     **/
    Page<CompanyVo> queryCompanyForSalesman(CompanySearchVo vo);
    /**查询平台上所有的虚拟实体点卡账户**/
    Page<OilManagerVo> findIfVirtualCompany(OilManagerQueryVo vo);

}