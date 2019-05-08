package com.brcc.business.company.service;

import com.brcc.business.company.entity.CompanyEntity;
import com.brcc.business.company.vo.CompanySearchVo;
import com.brcc.business.company.vo.CompanyVo;
import com.brcc.business.creditConfig.vo.CreditConfigAddCompanyVo;
import com.brcc.business.creditConfig.vo.CreditConfigQueryVo;
import com.brcc.business.oilManager.vo.OilManagerQueryVo;
import com.brcc.business.oilManager.vo.OilManagerVo;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 委托方授信公司信息逻辑接口
 * @Auther: gemaochao
 * @Date:Created in 10:17 2018/11/2
 */
@Service
public interface CompanyService {

    /**
     * @Author gemaochao
     * @Description //TODO 返回公司名称
     * @Date  2018/11/2
     * @Param [creditConfigQueryVo]
     * @return org.springframework.data.domain.Page<com.brcc.business.creditConfig.vo.CreditConfigAddCompanyVo>
     **/
    Page<CreditConfigAddCompanyVo> creditCompany(CreditConfigQueryVo creditConfigQueryVo);
    
    /**
     * @Description  返回指定id公司信息
     * @Param [seqId]
     * @return com.brcc.business.company.entity.CompanyEntity
     **/
    CompanyEntity findCompanyById(Long seqId);

    /**
     * 返回承运公司
     * @param platformId
     * @param companyId
     * @return
     */
    List<CompanyEntity> companyIfTransport(String platformId, Long companyId);

    /**
     * 根据sqlId获取公司信息
     * @param seqId
     * @param platformId
     * @return
     */
    CompanyEntity findBySeqIdAndPlatformId(Long seqId,String platformId);

    /**
     * 获取飞单对象
     * @param vo
     * @return
     */
    Page<CompanyVo> findPersonTeam(CompanySearchVo vo);

    /** 校验是否有抢单资格(未审核或者被冻结)
     *  @param platformId
     *  @param companyId
     */
	Integer checkCompanyStatus(String platformId, Long companyId);

	 /** 检查是否在货主的黑名单中
      *  @param companySearchVo
      */
	CompanyVo findDriverFdrBlack(CompanySearchVo companySearchVo);

	/** 查询信息费收取情况
     *  @param publishId
     *  @param platformId
     */
	CompanyVo queryGrabMoney(Long publishId, String platformId);

    /**
     * @Description  业务员管理页面公司名称
     * @Param [vo]
     * @return org.springframework.data.domain.Page<com.brcc.business.company.vo.CompanyVo>
     **/
    Page<CompanyVo> queryCompanyForSalesman(CompanySearchVo vo);
    /**
     * 查询公司的虚实户的状态
     * **/
    Page<OilManagerVo> findIfVirtualCompany(OilManagerQueryVo vo);
    /**
     * 修改公司的虚实户状态
     * **/
    void changeIfVirtualCompany(OilManagerQueryVo vo);

}