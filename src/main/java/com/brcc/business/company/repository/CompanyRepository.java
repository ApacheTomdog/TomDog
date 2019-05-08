package com.brcc.business.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.brcc.business.company.entity.CompanyEntity;

/**
 * @Description: 委托方公司数据操作接口
 * @Auther: gemaochao
 * @Date:Created in 16:22 2018/11/1
 */
@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity,Long>,ICompanyRepositiry {
    
    /**
     * @Description  返回指定id公司信息
     * @Param [seqId]
     * @return com.brcc.business.company.entity.CompanyEntity
     **/
    CompanyEntity findBySeqId(Long seqId);

    @Query(value="SELECT * FROM company c,loginverify l WHERE c.platform_id = ? AND l.platform_id = c.platform_id AND l.company_id = c.seq_id AND c.seq_id = ? AND l.if_admin = 'Y' AND c.if_tax_transport = 'Y'", nativeQuery=true)
    List<CompanyEntity> companyIfTransport(String platformId, Long companyId);

    CompanyEntity findBySeqIdAndPlatformId(Long seqId,String platformId);

    /** 校验是否有抢单资格(未审核或者被冻结)
     *  @param platformId
     *  @param companyId
     */
    @Query(value="SELECT * FROM company c  where (ifnull(c.status,'10') = '10' or c.if_freeze = '1') and c.platform_id = ? and c.seq_id = ? ", nativeQuery=true)
	Integer checkCompanyStatus(String platformId, Long companyId);
    
    @Modifying(clearAutomatically=true)
    @Query(value = "update company set "+
		"if_virtual_company = ?1 "+
		"where platform_id = ?3 "+
		"and if_virtual_company != ?1 "+
		"and seq_id = ?2 ",nativeQuery = true)
    Integer changeIfVirtualCompany(String ifVirtualCompany,Long seqId,String platformId);

}