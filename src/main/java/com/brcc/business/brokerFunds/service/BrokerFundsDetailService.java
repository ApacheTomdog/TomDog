package com.brcc.business.brokerFunds.service;

import com.brcc.business.brokerFunds.entity.BrokerfundscontroldetailEntity;
import com.brcc.business.brokerFunds.vo.BrokerFundsDetailQueryVo;
import com.brcc.business.brokerFunds.vo.BrokerFundsDetailVo;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

public interface BrokerFundsDetailService {
    /***
     * 查询添加进入资金流水明细的单据信息
     * */
     BrokerFundsDetailVo queryDeliveryDetail(BrokerFundsDetailQueryVo vo);

     BrokerfundscontroldetailEntity save(BrokerfundscontroldetailEntity entity);
    /***
     * 更新调单单下的资金流水信息
     * */
     void updateDeliveryFundsFlag(Long vo);

     void deleteById(Long fundsControlDetailId);
    /***
     * 根据主键查询资金流水明细
     * */
    BrokerfundscontroldetailEntity findById(Long fundsControlDetailId);

    List<BrokerfundscontroldetailEntity> findByFundsControlMasterId(Long fundsControlMasterId);

    void deleteAllByFundsControlMasterId(Long fundsControlMasterId);

    Integer countByFundsControlMasterIdAndFcIfUpload(Long fundsControlMasterId,Integer fcIfUpload);

    Integer countByFundsControlMasterId(Long fundsControlMasterId);
    //查询删除部分明细后查看主单下面是否存在不为0或者null的明细
    List<BrokerfundscontroldetailEntity> findAllDetailInfo(Long fundsControlMasterId);

    BigDecimal getDetailAmount(Long fundsControlMasterId);

}
