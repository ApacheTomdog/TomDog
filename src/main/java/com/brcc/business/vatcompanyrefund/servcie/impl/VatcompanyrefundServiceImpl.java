package com.brcc.business.vatcompanyrefund.servcie.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.brcc.business.company.service.CompanyService;
import com.brcc.business.creditRepay.service.CreditRepayService;
import com.brcc.business.vatcapital.entity.VatcapitaldetailEntity;
import com.brcc.business.vatcapital.entity.VatcapitalmasterEntity;
import com.brcc.business.vatcapital.service.VatCapitalService;
import com.brcc.business.vatcompanyrefund.entity.VatcompanyrefundEntity;
import com.brcc.business.vatcompanyrefund.repository.VatcompanyrefundRepository;
import com.brcc.business.vatcompanyrefund.servcie.VatcompanyrefundService;
import com.brcc.business.vatcompanyrefund.vo.VatCompanyRefundQueryVo;

/**
 * @Description: 委托方退款审核
 * @Auther: gemaochao
 * @Date:Created in 10:10 2018/11/16
 */
@Service
public class VatcompanyrefundServiceImpl implements VatcompanyrefundService {

    @Autowired
    VatcompanyrefundRepository vatcompanyrefundRepository;

    @Autowired
    VatCapitalService vatCapitalService;

    @Autowired
    CreditRepayService creditRepayService;

    @Autowired
    CompanyService companyService;


    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public Page<VatcompanyrefundEntity> queryRefund(VatCompanyRefundQueryVo vo) {
        return  vatcompanyrefundRepository.queryRefund(vo);
    }

    @Override
    @Transactional
    public VatcompanyrefundEntity audit(VatCompanyRefundQueryVo vo) {

        logger.info("company refund audit,id:{},status:{}",vo.getVatCompanyRefundId(),vo.getRefundStatus());

        vo.setDocuId(getTimeMillisSequence());

        //更新vatcompanyrefund表中信息
        VatcompanyrefundEntity entity = vatcompanyrefundRepository.findByPlatformIdAndVatCompanyRefundId(vo.getPlatformId(),vo.getVatCompanyRefundId());
        entity.setRefundStatus(vo.getRefundStatus());
        entity.setAuditDate(vo.getAuditDate());
        entity.setAuditPersonId(vo.getAuditPersonId());
        entity.setAuditPersonName(vo.getAuditPersonName());
        entity.setAuditRemark(vo.getAuditRemark());
        Assert.notNull(vatcompanyrefundRepository.save(entity).getVatCompanyRefundId(),"当前承运方的退款申请已发生变化，请刷新页面重试！");
        //审核通过操作
        if (("90").equals(vo.getRefundStatus())){


        //在VatCapitalDetail表插入记录
            VatcapitaldetailEntity detailEntity = new VatcapitaldetailEntity();
            detailEntity.setClientId(entity.getClientId());
            detailEntity.setClientName(entity.getClientName());
            detailEntity.setCarryId(entity.getCarryId());
            detailEntity.setCarryName(entity.getCarryName());
            detailEntity.setPlatformId(entity.getPlatformId());
            detailEntity.setInAmount(BigDecimal.ZERO);
            detailEntity.setOutAmount(entity.getRefundAmount());
            detailEntity.setBlockInAmount(BigDecimal.ZERO);
            detailEntity.setBlockOutAmount(BigDecimal.ZERO);
            detailEntity.setBlockStatus("20");
            detailEntity.setDocuType("80");
            detailEntity.setDocuId(entity.getVatCompanyRefundId().toString());
            detailEntity.setDocuNum(entity.getVatCompanyRefundNum());
            detailEntity.setDocuMemo(entity.getCreateRemark());
            detailEntity.setDocuFrom("C");
            detailEntity.setCreateDate(new Date());
            detailEntity.setCreatePersonId(vo.getAuditPersonId());
            detailEntity.setCreatePersonName(vo.getAuditPersonName());
            detailEntity.setModifyDate(new Date());
            detailEntity.setModifyPersonId(vo.getAuditPersonId());
            detailEntity.setModifyPersonName(vo.getAuditPersonName());
            vatCapitalService.saveDetail(detailEntity);

            //更新VatCapitalMaster表记录
            VatcapitalmasterEntity masterEntity = vatCapitalService.queryMaster(entity.getCarryId(),entity.getClientId(),entity.getPlatformId(),entity.getRefundAmount());
            Assert.notNull(masterEntity,"当前委托方在承运方的剩余金额已不足退款金额！");
            masterEntity.setTotalRefundAmount(masterEntity.getTotalRefundAmount().add(entity.getRefundAmount()));
            masterEntity.setTotalUseAmount(masterEntity.getTotalUseAmount().subtract(entity.getRefundAmount()));
            masterEntity.setModifyDate(new Date());
            Assert.notNull(vatCapitalService.saveMaster(masterEntity),"当前委托方在承运方的剩余金额已不足退款金额！");
        }
        return entity;
    }



    /**
     * @Description  seqNum
     * @Param []
     * @return java.lang.String
     **/
    public static String getTimeMillisSequence(){
        long nanoTime = System.nanoTime();
        if (nanoTime<0){
            nanoTime = nanoTime+Long.MAX_VALUE+1;
        }
        String nanoTimeStr = String.valueOf(nanoTime);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < 4; i++) {
            char c = nanoTimeStr.charAt(i);
            sb.append(c);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss"); //24小时制
        String timeMillisSequence = sdf.format(System.currentTimeMillis()) + sb.toString();

        return timeMillisSequence;
    }

    @Override
    public List<VatcapitalmasterEntity> queryCompanyName(VatCompanyRefundQueryVo vo) {
        return vatCapitalService.queryCompanyName(vo);
    }

    @Override
    public Page<VatcompanyrefundEntity> queryForClient(VatCompanyRefundQueryVo vo) {
        return vatcompanyrefundRepository.queryForClient(vo);
    }

    @Override
    public VatcompanyrefundEntity addRefundSave(VatcompanyrefundEntity entity) {

        logger.info("add refund save,carryId:{},clientId:{}",entity.getCarryId(),entity.getClientId());

        //获取退款申请编号 类型101
        entity.setVatCompanyRefundNum(creditRepayService.getSeqNo(Long.valueOf("101")));
        entity.setCarryName(companyService.findCompanyById(entity.getCarryId()).getCompanyName());
        entity.setClientName(companyService.findCompanyById(entity.getClientId()).getCompanyName());
        //保存
        return vatcompanyrefundRepository.save(entity);
    }

	@Override
	public VatcapitalmasterEntity queryCompanyCapital(VatCompanyRefundQueryVo vo) {
		logger.info("query Vatcapital info,carryId:{},clientId:{}",vo.getCarryId(),vo.getClientId());
		return vatCapitalService.queryCompanyCapital(vo);
	}
}
