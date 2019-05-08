package com.brcc.business.transorder.service.impl;

import com.brcc.business.transorder.entity.GoodsordermEntity;
import com.brcc.business.transorder.repository.TransOrderDetailRepository;
import com.brcc.business.transorder.service.TransOrderDetailService;
import com.brcc.business.transorder.vo.TransOrderDetailSearchVo;
import com.brcc.business.transorder.vo.TransOrderDetailVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * 描述:
 * 平台运输单业务逻辑接口实现类
 *
 * @author yushaohua
 * @create 2018-11-01 17:08
 */
@Service
public class TransOrderDetailServiceImpl implements TransOrderDetailService {

    Logger logger = LoggerFactory.getLogger(TransOrderDetailServiceImpl.class);

    @Autowired
    private TransOrderDetailRepository transOrderDetailRepository;

    @Override
    public TransOrderDetailVo findOrderDetail(TransOrderDetailSearchVo vo) {
        logger.info("query trans order detail ");

        List<TransOrderDetailVo> list = null;
        if(vo.getOrderTaxDetail() != null && !"".equalsIgnoreCase(vo.getOrderTaxDetail())){
            vo.setCompanyId("");
            list = transOrderDetailRepository.findTaxOrderDetail(vo);
        }else{
            list = transOrderDetailRepository.findOrderDetail(vo);
        }

        if(list != null){
            String vehicleStyleVarStr = "";
            TransOrderDetailVo transOrderDetailVo = list.get(0);
            String vehicleStyleVar = transOrderDetailVo.getVehicleStyleVar();
            if (vehicleStyleVar != null && !"".equals(vehicleStyleVar)) {
                String[] vehicle_style = vehicleStyleVar.split(",");
                for(int i=0;i<vehicle_style.length;i++){
                    vehicleStyleVarStr += vehicle_style[i].substring(3, vehicle_style[i].length()) + ",";
                }
                vehicleStyleVarStr = vehicleStyleVarStr.substring(0, vehicleStyleVarStr.length() - 1);
                transOrderDetailVo.setVehicleStyleVar(vehicleStyleVarStr);
            }
            transOrderDetailVo.setOrderTaxDetail(vo.getOrderTaxDetail());
            transOrderDetailVo.setType(vo.getType());
            return transOrderDetailVo;
        }
        return null;
    }

    @Override
    public void updateGoodsOrderMStatus(String publishId) {
        transOrderDetailRepository.updateGoodsOrderMStatus(publishId);
    }

    @Override
    public void updateResource(BigDecimal weight, BigDecimal qty, BigDecimal amount, String publishId, String platformId) {
        transOrderDetailRepository.updateResource(weight, qty, amount, publishId, platformId);
    }

    @Override
    public void updateSaleResource(BigDecimal weight, BigDecimal qty, BigDecimal amount, String publishId, String platformId) {
        transOrderDetailRepository.updateSaleResource(weight, qty, amount, publishId, platformId);
    }

    @Override
    public GoodsordermEntity findByPublishIdAndPlatformId(Long publishId, String platformId) {
        return transOrderDetailRepository.findByPublishIdAndPlatformId(publishId, platformId);
    }

    @Override
    public GoodsordermEntity findById(Long publishId) {
        return transOrderDetailRepository.findById(publishId).get();
    }

    @Override
    public GoodsordermEntity save(GoodsordermEntity goodsordermEntity) {
        return transOrderDetailRepository.save(goodsordermEntity);
    }

    @Override
    public void updateGoodsStatus(String status, Long updatePerson, String remark, Long publishId, String platformId) {
        transOrderDetailRepository.updateGoodsStatus(status, updatePerson, remark, publishId, platformId);
    }
}