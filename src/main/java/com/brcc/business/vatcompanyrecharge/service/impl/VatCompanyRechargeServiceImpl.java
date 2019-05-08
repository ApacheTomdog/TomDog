package com.brcc.business.vatcompanyrecharge.service.impl;

import com.brcc.business.company.service.CompanyService;
import com.brcc.business.creditRepay.service.CreditRepayService;
import com.brcc.business.flow.service.VatflowdetailService;
import com.brcc.business.flow.vo.VatflowdetailCompanyNameVo;
import com.brcc.business.vatAuditConfigName.entity.VatAuditConfigNameEntity;
import com.brcc.business.vatAuditConfigName.service.VatAuditConfigNameService;
import com.brcc.business.vatPartBusiness.service.VatPartBusinessService;
import com.brcc.business.vatcapital.entity.VatcapitaldetailEntity;
import com.brcc.business.vatcapital.entity.VatcapitalmasterEntity;
import com.brcc.business.vatcapital.service.VatCapitalService;
import com.brcc.business.vatcapital.vo.VatcapitaldetailQueryVo;
import com.brcc.business.vatcompanyRechargeBusiness.entity.VatcompanyRechargeBusinessEntity;
import com.brcc.business.vatcompanyRechargeBusiness.service.VatcompanyRechargeBusinessService;
import com.brcc.business.vatcompanyRechargeBusiness.vo.CompanyNameQueryVo;
import com.brcc.business.vatcompanyrecharge.entity.VatcompanyrechargeEntity;
import com.brcc.business.vatcompanyrecharge.repository.VatCompanyRechargeRepository;
import com.brcc.business.vatcompanyrecharge.service.VatCompanyRechargeService;
import com.brcc.business.vatcompanyrecharge.vo.VatCompanyRechargeQueryVo;
import com.brcc.business.vatcompanyrefund.vo.VatCompanyRefundQueryVo;
import com.esteel.common.controller.WebReturnMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Description: 委托方充值申请
 * @Auther: gemaochao
 * @Date:Created in 16:36 2018/11/13
 */
@Service
public class VatCompanyRechargeServiceImpl implements VatCompanyRechargeService {

    @Autowired
    VatCompanyRechargeRepository vatCompanyRechargeRepository;

    @Autowired
    VatPartBusinessService vatPartBusinessService;

    @Autowired
    VatcompanyRechargeBusinessService vatcompanyRechargeBusinessService;

    @Autowired
    VatflowdetailService vatflowdetailService;

    @Autowired
    CompanyService companyService;

    @Autowired
    VatAuditConfigNameService vatAuditConfigNameService;

    @Autowired
    CreditRepayService creditRepayService;

    @Autowired
    VatCapitalService vatCapitalService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Page<VatcompanyrechargeEntity> queryRecharge(VatCompanyRechargeQueryVo vo) {
        return vatCompanyRechargeRepository.queryRecharge(vo);
    }

    @Override
    public String verifyIfParts(String platformId, Long clientId) {

        logger.info("verify ifParts,clientId:{}",clientId);

        String ifParts;
        if (vatPartBusinessService.findByPlatformIdAndCompanyId(platformId,clientId) != null){
             ifParts = vatPartBusinessService.findByPlatformIdAndCompanyId(platformId,clientId).getIfParts();
        }else {
            ifParts = "N";
        }
        return ifParts;
    }

    @Override
    public List<VatflowdetailCompanyNameVo> queryCompanyNameN(VatCompanyRechargeQueryVo vo) {
        return vatflowdetailService.queryCompanyName(vo);
    }

    @Override
    public List<CompanyNameQueryVo> queryCompanyNameY(Long clientId, String platformId) {
        return vatcompanyRechargeBusinessService.queryCompanyName(clientId,platformId);
    }

    @Override
    public VatcompanyrechargeEntity addRechargeSave(VatcompanyrechargeEntity entity) {

        logger.info("add recharge save,clientId:{}",entity.getClientId());

        VatAuditConfigNameEntity vo = vatAuditConfigNameService.queryAudName(entity.getClientId());
        if (vo != null) {
            entity.setVatAuditName(vo.getVatAuditName());
            entity.setVatDirectorName(vo.getVatDirectorName());
        }
        return vatCompanyRechargeRepository.save(entity);
    }


    @Override
    public VatcompanyRechargeBusinessEntity flushBusiness(VatcompanyrechargeEntity entity) {

        logger.info("flush business,businessNum:{}",entity.getBusinessNum());

        VatcompanyRechargeBusinessEntity vo = vatcompanyRechargeBusinessService.findByPlatformIdAndBusinessNum(entity.getPlatformId(),entity.getBusinessNum());
        vo.setRechargeAmount(vo.getRechargeAmount().add(entity.getBankAmount()));
        vo.setSurplusAmount(vo.getSurplusAmount().subtract(entity.getBankAmount()));
        return vatcompanyRechargeBusinessService.save(vo);
    }

    @Override
    public List<VatCompanyRechargeQueryVo> queryRechargeForExcel(VatCompanyRechargeQueryVo vo) {
        List<VatCompanyRechargeQueryVo> lists = vatCompanyRechargeRepository.queryRechargeForExcel(vo);
        //时间格式转换
        DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //HH表示24小时制；
        for (VatCompanyRechargeQueryVo list:lists){
            if (list.getCreateDate() != null){
                list.setCredateTime(dFormat.format(list.getCreateDate()));
            }
            if (list.getAuditDate() != null){
                list.setAuditTime(dFormat.format(list.getAuditDate()));
            }
        }
        return lists;
    }

    @Override
    public Page<VatcompanyrechargeEntity> queryAuditRecharge(VatCompanyRechargeQueryVo vo) {
        return vatCompanyRechargeRepository.queryAuditRecharge(vo);
    }


    @Override
    public VatCompanyRechargeQueryVo queryTotalInAmount(VatCompanyRechargeQueryVo vo) {
        return vatCompanyRechargeRepository.queryTotalInAmount(vo).get(0);
    }

    @Override
    public VatcompanyrechargeEntity auditRecharge(VatcompanyrechargeEntity entity) {

        logger.info("audit recharge , id:{},status:{}",entity.getVatCompanyRechargeId(),entity.getStatus());

        //若操作是通过审核
        if (("90").equals(entity.getStatus())){

            //调用存储过程

            vatCompanyRechargeRepository.flush();

            HashMap param = new HashMap<>();
            param.put("vatCompanyRechargeId", entity.getVatCompanyRechargeId());
            param.put("userName", entity.getAuditPersonName());
            param.put("userId", entity.getAuditPersonId());
            param.put("docuType", "10");
            param.put("outResult", "");
            param.put("outResultReason", "");
            vatCompanyRechargeRepository.capitalDetailPro(param);
            if(param.get("outResult") == null || !("1".equals(param.get("outResult")))){
                throw new RuntimeException(param.get("outResultReason").toString());
            }
        }
        //获取充值审核单号 类型13
        String auditNum =  creditRepayService.getSeqNo(Long.valueOf(13));
        //更新承运方充值审核表状态
        VatcompanyrechargeEntity updateEntity = vatCompanyRechargeRepository.findByVatCompanyRechargeId(entity.getVatCompanyRechargeId());

        updateEntity.setAuditDate(entity.getAuditDate());
        updateEntity.setStatus(entity.getStatus());
        updateEntity.setAuditPersonId(entity.getAuditPersonId());
        updateEntity.setAuditPersonName(entity.getAuditPersonName());
        updateEntity.setAuditNum(auditNum);
        updateEntity.setAuditRemark(entity.getAuditRemark());

        Assert.notNull(vatCompanyRechargeRepository.save(updateEntity),"页面数据出错，请联系管理员");

        //反查委托业务申请表，判断剩余金额是否为0，为0 ，状态改90
        VatcompanyrechargeEntity vatcompanyrechargeEntity = vatCompanyRechargeRepository.findByVatCompanyRechargeIdAndPlatformId(entity.getVatCompanyRechargeId(),entity.getPlatformId());

        if (vatcompanyrechargeEntity.getBusinessNum()!= null&&("").equals(vatcompanyrechargeEntity.getBusinessNum())) {

            VatcompanyRechargeBusinessEntity businessEntity = vatcompanyRechargeBusinessService.findByPlatformIdAndBusinessNum(vatcompanyrechargeEntity.getPlatformId(), vatcompanyrechargeEntity.getBusinessNum());

            if (("90").equals(entity.getStatus())) {

                businessEntity.setRechargeAmount(businessEntity.getRechargeAmount().subtract(vatcompanyrechargeEntity.getBankAmount()));
                businessEntity.setUseAmount(businessEntity.getUseAmount().add(vatcompanyrechargeEntity.getBankAmount()));

            } else if (("05").equals(entity.getStatus())) {

                businessEntity.setRechargeAmount(businessEntity.getRechargeAmount().subtract(vatcompanyrechargeEntity.getBankAmount()));
                businessEntity.setSurplusAmount(businessEntity.getSurplusAmount().add(vatcompanyrechargeEntity.getBankAmount()));

            }

            vatcompanyRechargeBusinessService.save(businessEntity);

            //判断充值中金额和剩余金额是否都为0，则充值完成
            VatcompanyRechargeBusinessEntity v = vatcompanyRechargeBusinessService.findByPlatformIdAndBusinessNum(vatcompanyrechargeEntity.getPlatformId(), vatcompanyrechargeEntity.getBusinessNum());

            if (("0.00").equals(v.getSurplusAmount().toString()) && ("0.00").equals(v.getRechargeAmount().toString())) {
                vatcompanyRechargeBusinessService.updateStatus(vatcompanyrechargeEntity.getBusinessNum(), vatcompanyrechargeEntity.getPlatformId());
            }
        }
        return updateEntity;
    }

    @Override
    public void strikeBalance(VatcompanyrechargeEntity entity){
        VatcompanyrechargeEntity checkEntity = vatCompanyRechargeRepository.findById(entity.getVatCompanyRechargeId()).get();
        Assert.isTrue("90".equals(checkEntity.getStatus()),"只有审核通过的充值单据才能做红冲操作！");
        VatcapitaldetailEntity vatcapitaldetailEntity = new  VatcapitaldetailEntity();
        vatcapitaldetailEntity.setClientId(checkEntity.getClientId());
        vatcapitaldetailEntity.setClientName(checkEntity.getClientName());
        vatcapitaldetailEntity.setCarryId(checkEntity.getCarryId());
        vatcapitaldetailEntity.setCarryName(checkEntity.getCarryName());
        vatcapitaldetailEntity.setPlatformId(checkEntity.getPlatformId());
        vatcapitaldetailEntity.setInAmount(new BigDecimal(0));
        vatcapitaldetailEntity.setOutAmount(checkEntity.getBankAmount());
        vatcapitaldetailEntity.setBlockInAmount(new BigDecimal(0));
        vatcapitaldetailEntity.setBlockOutAmount(checkEntity.getBankAmount());
        vatcapitaldetailEntity.setBlockStatus("20");
        vatcapitaldetailEntity.setDocuType("25");
        vatcapitaldetailEntity.setDocuId(checkEntity.getVatCompanyRechargeId().toString());
        vatcapitaldetailEntity.setDocuNum(checkEntity.getVatCompanyRechargeId().toString());
        vatcapitaldetailEntity.setDocuFrom("B");
        vatcapitaldetailEntity.setDocuMemo("红冲");
        vatcapitaldetailEntity.setCreateDate(new Date());
        vatcapitaldetailEntity.setCreatePersonId(entity.getCreatePersonId());
        vatcapitaldetailEntity.setCreatePersonName(entity.getCreatePersonName());
        vatcapitaldetailEntity.setModifyDate(new Date());
        vatcapitaldetailEntity.setModifyPersonId(entity.getCreatePersonId());
        vatcapitaldetailEntity.setModifyPersonName(entity.getCreatePersonName());
        vatCapitalService.saveDetail(vatcapitaldetailEntity);
        Integer updateRechargeNum = vatCompanyRechargeRepository.updateStatusm("25",entity.getCreatePersonId(),entity.getCreatePersonName(),entity.getVatCompanyRechargeId());
        Assert.isTrue(updateRechargeNum==1,"充值表状态修改出错，请联系管理员");
        Integer updateMasterNum = vatCapitalService.updateVatcapitalMaster(checkEntity.getBankAmount(),checkEntity.getClientId(),checkEntity.getCarryId(),checkEntity.getPlatformId());
        Assert.isTrue(updateMasterNum==1,"资金扣除出错，请紧急联系管理员");

    }

    @Override
    public VatcompanyrechargeEntity queryForDetail(VatCompanyRechargeQueryVo vo) {
        return vatCompanyRechargeRepository.queryForDetail(vo).get(0);
    }

    @Override
    public List<VatCompanyRechargeQueryVo> queryForExcel(VatCompanyRechargeQueryVo vo) {
        List<VatCompanyRechargeQueryVo> lists = vatCompanyRechargeRepository.queryForExcel(vo);
        //时间格式转换
        DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //HH表示24小时制；
        for (VatCompanyRechargeQueryVo list:lists){
            if (list.getCreateDate() != null){
                list.setCredateTime(dFormat.format(list.getCreateDate()));
            }
            if (list.getAuditDate() != null){
                list.setAuditTime(dFormat.format(list.getAuditDate()));
            }
        }
        return lists;
    }

    @Override
    public Page<VatcapitaldetailQueryVo> queryMasterForDetail(VatcapitaldetailQueryVo vo) {
        return vatCapitalService.queryForDetail(vo);
    }

    @Override
    public Page<VatcapitalmasterEntity> queryMasterForCarry(VatCompanyRefundQueryVo vo) {
        return vatCapitalService.queryForCarry(vo);
    }

    @Override
    public VatcapitalmasterEntity queryMasterTotalInAmount(VatCompanyRefundQueryVo vo) {
        return vatCapitalService.queryTotalInAmount(vo);
    }

    @Override
    public List<VatcapitaldetailQueryVo> excelForMaster(VatcapitaldetailQueryVo vo) {

        logger.info("excel for master");

        List<VatcapitaldetailQueryVo> lists = vatCapitalService.excelForMaster(vo);
        //时间格式转换
        DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //HH表示24小时制；
        for (VatcapitaldetailQueryVo list:lists){
            if (list.getModifyDate() != null){
                list.setModifyTime(dFormat.format(list.getModifyDate()));
            }
        }
        return lists;
    }

    @Override
    public Page<VatcapitalmasterEntity> queryMasterForClient(VatCompanyRefundQueryVo vo) {
        return vatCapitalService.queryForClient(vo);
    }

    @Override
    public WebReturnMessage cancel(Long vatCompanyRechargeId) {
        logger.info("cancel recharge vatCompanyRechargeId:{}",vatCompanyRechargeId);
        VatcompanyrechargeEntity entity = vatCompanyRechargeRepository.findByVatCompanyRechargeId(vatCompanyRechargeId);
        if (!("10").equals(entity.getStatus())){
            WebReturnMessage.sucess.setMsg("该记录不是未审核状态，不能作废！");
        }else {
            //状态设为作废 00
            entity.setStatus("00");
            vatCompanyRechargeRepository.save(entity);
            WebReturnMessage.sucess.setMsg("操作成功！");
        }
        return WebReturnMessage.sucess;
    }
}
