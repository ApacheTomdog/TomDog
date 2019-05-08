package com.brcc.business.agencyInvoice.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.brcc.business.agencyInvoice.vo.AddAgencyInvoiceVo;
import com.brcc.business.agencyInvoice.vo.AgencyInvoiceQueryVo;
import com.brcc.business.agencyInvoice.vo.AgencyInvoiceUploadVo;
import com.brcc.business.agencyInvoice.vo.AgencyInvoiceVo;

/**
 * 	代开票管理
 * 
 * @author hui.liu
 * @date 2018年12月13日
 */
public interface AgencyInvoiceService {

    /**
     * 	代开票管理列表
     */
    Page<AgencyInvoiceVo> queryAgencyInvoiceList(AgencyInvoiceQueryVo queryVo);
    
    /**
     * 	新增代开票
     */
    void addAgencyInvoice(AddAgencyInvoiceVo addVo); 
    
    /**
     * 	导入发票编号
     */
    Integer upLoadInvoiceNo(List<AgencyInvoiceUploadVo> uploadVoList, String platformId, Long userId, String userName);
}
