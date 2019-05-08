package com.brcc.business.creditRepay.service.impl;

import com.brcc.business.company.service.CompanyService;
import com.brcc.business.creditConfig.service.CreditConfigService;
import com.brcc.business.creditRepay.entity.CreditRepayEntity;
import com.brcc.business.creditRepay.repository.CreditRepayRepository;
import com.brcc.business.creditRepay.service.CreditRepayService;
import com.brcc.business.creditRepay.vo.CreditRepaySearchQueryVo;
import com.brcc.business.creditRepay.vo.RepayCompanyVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;


/**
 * @Description: 授信还款逻辑操作
 * @Auther: gemaochao
 * @Date:Created in 16:46 2018/11/7
 */
@Service
public class CreditRepayServiceImpl implements CreditRepayService {


    @Autowired
    CreditRepayRepository creditRepayRepository;

    @Autowired
    CompanyService companyService;

    @Autowired
    CreditConfigService creditConfigService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Page<CreditRepayEntity> queryRepay(CreditRepaySearchQueryVo creditRepaySearchQueryVo) {
        return creditRepayRepository.queryRepay(creditRepaySearchQueryVo);
    }


    @Override
    public List<RepayCompanyVo> queryRepayCompany(CreditRepaySearchQueryVo creditRepaySearchQueryVo) {
        return creditRepayRepository.queryRepayCompany(creditRepaySearchQueryVo);
    }

    @Override
    public CreditRepayEntity changeRepayStatus(CreditRepaySearchQueryVo creditRepaySearchQueryVo) {

        logger.info("change repay status,status:{},id:{}",creditRepaySearchQueryVo.getCreditRepayStatus(),creditRepaySearchQueryVo.getCreditRepayId());

        CreditRepayEntity creditRepayEntity = creditRepayRepository.findByCreditRepayId(creditRepaySearchQueryVo.getCreditRepayId());
        if (("00").equals(creditRepaySearchQueryVo.getCreditRepayStatus())){
            //修改人、修改日期
            creditRepayEntity.setModifyDate(creditRepaySearchQueryVo.getModifyDate());
            creditRepayEntity.setModifyPersonId(creditRepaySearchQueryVo.getModifyPersonId());
            creditRepayEntity.setModifyPersonName(creditRepaySearchQueryVo.getModifyPersonName());
            creditRepayEntity.setCreditRepayStatus(creditRepaySearchQueryVo.getCreditRepayStatus());
        }else {
            //审核人、审核日期
            creditRepayEntity.setAuditDate(creditRepaySearchQueryVo.getAuditDate());
            creditRepayEntity.setAuditPersonId(creditRepaySearchQueryVo.getAuditPersonId());
            creditRepayEntity.setAuditPersonName(creditRepaySearchQueryVo.getAuditPersonName());
            //若操作是审核不通过，记录`audit_remark` '审核不通过填写的备注',
            if (("05").equals(creditRepaySearchQueryVo.getCreditRepayStatus())) {
                creditRepayEntity.setAuditRemark(creditRepaySearchQueryVo.getAuditRemark());
            }

        }
        //设置状态
        creditRepayEntity.setCreditRepayStatus(creditRepaySearchQueryVo.getCreditRepayStatus());
        CreditRepayEntity entity =  creditRepayRepository.save(creditRepayEntity);
        Assert.notNull(entity,"您操作的此数据状态已发生改变或者不存在，操作失败，请刷新页面重试");

        //当操作是通过审核时 调用存储过程 {call pro_credit_repay(?,?,?)}

        creditRepayRepository.flush();

        HashMap<String,Object> param = new HashMap<>();

        param.put("outResult", "");
        param.put("outResultReason", "");
        param.put("creditRepayId", creditRepaySearchQueryVo.getCreditRepayId());

        creditRepayRepository.proCreditRepay(param);

//        Assert.isTrue("1".equals((String)param.get("outResult")), (String)param.get("outResultReason"));


        return  entity;
    }

    @Override
    public CreditRepayEntity addRepaySave( CreditRepayEntity creditRepayEntity) {

        logger.info("add repay save,investCompanyId:{},creditCompanyId:{}",creditRepayEntity.getInvestCompanyId(),creditRepayEntity.getCreditCompanyId());

        //添加授信公司和垫资公司名字
        creditRepayEntity.setInvestCompanyName(companyService.findCompanyById(creditRepayEntity.getInvestCompanyId()).getCompanyName());
        creditRepayEntity.setCreditCompanyName(creditConfigService.findByPublishCompanyId(creditRepayEntity.getCreditCompanyId()).getPublishCompanyName());
        //生成并添加授信还款号credit_repay_no   类型32
        String creditRepayNo = creditRepayRepository.getSeqNo(Long.valueOf(32)).get("as_pk_no").toString();
        creditRepayEntity.setCreditRepayNo(creditRepayNo);
        return creditRepayRepository.save(creditRepayEntity);
    }

    @Override
    public Page<CreditRepayEntity> queryRepayAudit(CreditRepaySearchQueryVo creditRepaySearchQueryVo) {
        return creditRepayRepository.queryRepayAudit(creditRepaySearchQueryVo);
    }

    @Override
    public String getSeqNo(Long typeId) {
        return creditRepayRepository.getSeqNo(typeId).get("as_pk_no").toString();
    }
}
