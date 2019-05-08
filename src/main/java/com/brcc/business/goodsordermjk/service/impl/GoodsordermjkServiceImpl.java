package com.brcc.business.goodsordermjk.service.impl;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import com.brcc.business.basedata.entity.BasedataEntity;
import com.brcc.business.basedata.entity.TeamCompanyEntity;
import com.brcc.business.basedata.service.BaseDataService;
import com.brcc.business.basedata.service.CatalogService;
import com.brcc.business.basedata.service.TeamCompanyService;
import com.brcc.business.basedata.vo.BaseDataQueryVo;
import com.brcc.business.basedata.vo.CatalogInfoVo;
import com.brcc.business.basedata.vo.CatalogQueryVo;
import com.brcc.business.basedata.vo.TeamCompanyVo;
import com.brcc.business.commonaddress.entity.CommonaddressEntity;
import com.brcc.business.commonaddress.service.Commonaddresservice;
import com.brcc.business.config.mybatis.MybatisQuery;
import com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceDetailEntity;
import com.brcc.business.creditAdjustPrice.service.CreditAdjustPriceDetailService;
import com.brcc.business.creditAdjustPrice.vo.CreditAdjustPriceDetailVo;
import com.brcc.business.creditAmountAdjust.vo.CreditAdjustPriceDetailQueryVo;
import com.brcc.business.creditConfig.service.CreditConfigService;
import com.brcc.business.creditConfig.vo.CreditConfigQueryVo;
import com.brcc.business.creditConfig.vo.CreditConfigVo;
import com.brcc.business.flow.entity.VatflowdetailEntity;
import com.brcc.business.flow.service.VatflowdetailService;
import com.brcc.business.goodsorderm.entity.GoodsordermEntity;
import com.brcc.business.goodsorderm.service.GoodsordermService;
import com.brcc.business.goodsorderm.vo.GoodsordermQueryVo;
import com.brcc.business.goodsorderm.vo.GoodsordermVo;
import com.brcc.business.goodsordermadjust.entity.GoodsordermadjustdetailEntity;
import com.brcc.business.goodsordermadjust.service.GoodsordermadjustDetailService;
import com.brcc.business.goodsordermjk.entity.GoodsordermjkEntity;
import com.brcc.business.goodsordermjk.entity.NotifyrecordEntity;
import com.brcc.business.goodsordermjk.repository.GoodsordermjkRepository;
import com.brcc.business.goodsordermjk.service.GoodsordermjkService;
import com.brcc.business.goodsordermjk.service.NotifyrecordService;
import com.brcc.business.goodsordermjk.vo.GoodsordermjkQueryVo;
import com.brcc.business.goodsordermjk.vo.GoodsordermjkVo;
import com.brcc.business.util.LatLngGetDistance;
import com.brcc.business.util.StringFactory;
import com.esteel.common.controller.WebReturnMessage;

/**
 * @author PanJianYang
 * @version 创建时间：2018年11月6日 上午9:11:02
 * @ClassName 类名称
 * @Description 类描述
 */
@Service
@Transactional
public class GoodsordermjkServiceImpl implements GoodsordermjkService{

    Logger logger = LoggerFactory.getLogger(GoodsordermjkServiceImpl.class);
    @Autowired
    GoodsordermjkRepository goodsordermjkRepository;
    @Autowired
    Commonaddresservice commonaddresservice;
    @Autowired
    BaseDataService baseDataService;
    @Autowired
    VatflowdetailService vatflowdetailService;
    @Autowired
    CreditConfigService creditConfigService;
    @Autowired
    CreditAdjustPriceDetailService creditAdjustPriceDetailService;
    @Autowired
    GoodsordermadjustDetailService goodsordermadjustDetailService;
    @Autowired
    CatalogService catalogService;
    @Autowired
    GoodsordermService goodsordermService;
    @Autowired
    TeamCompanyService teamCompanyService;
    @Autowired
    NotifyrecordService notifyrecordService;
    @Autowired
    MybatisQuery mybatisQuery;

    @Override
    public Page<GoodsordermjkVo> list(GoodsordermjkQueryVo vo) {
        logger.info("Query ds goodsordermjk  list,by orderId:{}",vo.getOrderId());
        return goodsordermjkRepository.listData(vo);

    }

    @Override
    public Page<GoodsordermjkVo> cgList(GoodsordermjkQueryVo vo) {
        logger.info("Query cg goodsordermjk  list,by orderId:{}",vo.getOrderId());
        return goodsordermjkRepository.cgList(vo);

    }

    @Override
    public Page<GoodsordermjkVo> pinDanList(GoodsordermjkQueryVo vo) {
        logger.info("Query goodsordermjk pinDanList pagination page,pinDanNum:{},rqStart:{},rqEnd:{}",vo.getPinDanNum(),vo.getRqStart(),vo.getRqEnd());
        return goodsordermjkRepository.listData(vo);
    }

    @Override
    @Transactional
    public WebReturnMessage addPool(GoodsordermjkQueryVo vo) {
        logger.info("add goodsordrmjk pool,importIdStr:{}",vo.getImportIdStr());
        WebReturnMessage rst = new WebReturnMessage(true);
        rst.setMsg("操作成功");
        rst.setSuccess(true);
        Assert.notNull(vo.getImportIdStr(), "无法获取到需要加入到拼单池的单据");
        String[] importIdArr = vo.getImportIdStr().split(",");
        for (int i=0; i<importIdArr.length; i++) {
            vo.setImportId(NumberUtils.toLong(importIdArr[i]));
            GoodsordermjkEntity goodsordermjkEntity = goodsordermjkRepository.findById(vo.getImportId()).get();
            Assert.isTrue("10".equals(goodsordermjkEntity.getStatus()), "只有新增的单据才能加入拼单池！");
            goodsordermjkEntity.setStatus(vo.getStatus());
            goodsordermjkEntity.setPutinDate(new Date());
            goodsordermjkEntity.setUserId(vo.getUserId());
            goodsordermjkRepository.save(goodsordermjkEntity);
        }
        return rst;
    }

    @Override
    @Transactional
    public WebReturnMessage deleteFromPool(GoodsordermjkQueryVo vo) {
        logger.info("delete from goodsordrmjk pool,importIdStr:{}",vo.getImportIdStr());
        WebReturnMessage rst = new WebReturnMessage(true);
        rst.setMsg("操作成功");
        rst.setSuccess(true);
        Assert.notNull(vo.getImportIdStr(), "无法获取到需要移除拼单池的单据");
        String[] importIdArr = vo.getImportIdStr().split(",");
        for (int i=0; i<importIdArr.length; i++) {
            vo.setImportId(NumberUtils.toLong(importIdArr[i]));
            GoodsordermjkEntity goodsordermjkEntity = goodsordermjkRepository.findById(vo.getImportId()).get();
            Assert.isTrue(!"20".equals(goodsordermjkEntity.getStatus()), "已发布的单据无法进行当前操作！");
            goodsordermjkEntity.setStatus(vo.getStatus());
            goodsordermjkEntity.setPutinDate(null);
            goodsordermjkEntity.setUserId(null);
            goodsordermjkEntity.setPinDanNum(null);
            goodsordermjkRepository.save(goodsordermjkEntity);
        }
        return rst;
    }

    @Override
    @Transactional
    public WebReturnMessage doPinDan(GoodsordermjkQueryVo vo) {
        logger.info("ds goodsordrmjk doPinDan,importIdStr:{}",vo.getImportIdStr());
        WebReturnMessage rst = new WebReturnMessage(true);
        rst.setMsg("操作成功");
        rst.setSuccess(true);
        Assert.notNull(vo.getImportIdStr(), "无法完成拼单操作！");
        String[] importIdArr = vo.getImportIdStr().split(",");
        List importIdList = Arrays.asList(importIdArr);
        // 调用存储过程获取的拼单号
        String pinDanNum = getSeqNum("31");
        //校验拼单单据里面的单据是否都为含税或者不含税
        Integer count = goodsordermjkRepository.queryGoodsorderjkTaxCount(importIdList);
        Assert.isTrue((count==importIdArr.length ||count==0),"同一批拼单的单据只能全部为含税或者为不含税！");
        Integer ecNum = goodsordermjkRepository.queryCountFromDifferntEc(vo.getImportIdStr());
        Assert.isTrue((ecNum ==1),"同一批拼单的单据只能来自同一个电商平台！");

        for (int i=0; i<importIdArr.length; i++) {
            vo.setImportId(NumberUtils.toLong(importIdArr[i]));
            GoodsordermjkEntity goodsordermjkEntity = goodsordermjkRepository.findById(vo.getImportId()).get();
            Assert.isTrue("30".equals(goodsordermjkEntity.getStatus()), "只有待拼单的单据才能完成此操作！");
            goodsordermjkEntity.setStatus(vo.getStatus());
            goodsordermjkEntity.setUserId(vo.getUserId());
            goodsordermjkEntity.setPutinDate(new Date());
            goodsordermjkEntity.setPinDanNum(Integer.valueOf(pinDanNum));
            goodsordermjkRepository.save(goodsordermjkEntity);
            //		int m = goodsordermjkRepository.doPinDan("40", Integer.parseInt(vo.getImportId().toString()),"30");
//			System.out.println(m);
        }
        return rst;
    }

    @Override
    @Transactional
    public Integer revokeGoodsordermjk(Long publishId) {
        return goodsordermjkRepository.revokeGoodsordermjk(publishId);
    }

    @Override
    public GoodsordermjkEntity findById(Long importId) {
        return goodsordermjkRepository.findById(importId).get();
    }

    @Override
    @Transactional
    public GoodsordermjkEntity save(GoodsordermjkEntity goodsordermjkEntity) {
        return goodsordermjkRepository.save(goodsordermjkEntity);
    }
    
    @Override
    @Transactional
    public void saveAddress(GoodsordermjkVo vo) {
        // 检验常用路线是否经存在
        logger.info("query the addresses is exsit or not！");
        CommonaddressEntity checkEntity = commonaddresservice.checkExist(vo.getEndPlateProvince(),vo.getEndPlateCity(),vo.getEndPlateCountry(),vo.getEndPlate(),vo.getReceiver(),vo.getReceiverMobile(),vo.getAddressType(),vo.getCompanyId(),vo.getUserId());
        Assert.isNull(checkEntity,"该路线已存在,请勿重复添加!");
        // 保存常用路线地址
        logger.info("save the frequently used addresses");
        CommonaddressEntity saveEntity = new CommonaddressEntity();
        // 封装待保存的信息到实体bean
        saveEntity.setProvinceId(vo.getProvinceId());
        saveEntity.setProvinceName(vo.getEndPlateProvince());
        saveEntity.setCityId(vo.getCityId());
        saveEntity.setCityName(vo.getEndPlateCity());
        saveEntity.setCountryId(vo.getCountryId());
        saveEntity.setCountryName(vo.getEndPlateCountry());
        saveEntity.setAddress(vo.getEndPlate());
        saveEntity.setAddressType(vo.getAddressType());
        saveEntity.setPlateLng(vo.getEndPlateLngDesc() ==null ? null : vo.getEndPlateLngDesc().toString());
        saveEntity.setPlateLat(vo.getEndPlateLatDesc() ==null ? null : vo.getEndPlateLatDesc().toString());
        saveEntity.setPlatformId(vo.getPlatformId());
        saveEntity.setCompanyId(vo.getCompanyId().toString());
        saveEntity.setCompanyName(vo.getCompanyName());
        saveEntity.setCreateDate(new Date());
        saveEntity.setCreatePersonId(vo.getUserId().toString());
        saveEntity.setCreatePersonName(vo.getUserName());
        saveEntity.setContactName(vo.getReceiver());
        saveEntity.setContactTele(vo.getReceiverMobile());
        CommonaddressEntity resltEntity = commonaddresservice.save(saveEntity);
        Assert.notNull(resltEntity,"保存失败!");
    }

    @Override
    public GoodsordermjkVo queryGoodOrderMJK(GoodsordermjkQueryVo vo) {
        logger.info("query the queryGoodOrderMJK information,by importId",vo.getImportId());
        return goodsordermjkRepository.queryGoodOrderMJK(vo);
    }

    @Override
    @Transactional
    public WebReturnMessage savePinDanInfo(GoodsordermjkVo vo) {
        logger.info("save queryGoodOrderMJK information has the same pinDanNum",vo.getPinDanNum());
        List<GoodsordermjkEntity> entityList;
        // 校验是否存在有电商配送的单据
        if(!ObjectUtils.isEmpty(vo.getPinDanNum())) {
            Integer count = goodsordermjkRepository.countPublish(vo.getImportId(),vo.getPinDanNum(),"20","1");
            Assert.isTrue(count <= 0,"存在有电商配送的单据，无法进行此操作!");
            entityList = goodsordermjkRepository.findByPinDanNumAndStatusNot(vo.getPinDanNum(),"20");
        }else {
            Integer count = goodsordermjkRepository.countByImportIdAndStatusNotAndDsIfSettle(vo.getImportId(),"20","1");
            Assert.isTrue(count <= 0,"存在有电商配送的单据，无法进行此操作!");
            entityList = goodsordermjkRepository.findByImportIdAndStatusNot(vo.getImportId(),"20");
        }
        if (StringUtils.isEmpty(vo.getIfTaxTransport()) || "N".equals(vo.getIfTaxTransport())) {
            /**不含税运输*/
            BigDecimal standardTax = new BigDecimal(StringFactory.getTaxRate());
            BigDecimal priceTax = vo.getPrice().add(vo.getPrice().multiply(standardTax));
            priceTax = priceTax.setScale(2, BigDecimal.ROUND_HALF_UP);
            vo.setStandardTax(standardTax);
            vo.setPriceTax(priceTax);
            vo.setIfTaxTransport("N");
            vo.setVatFlowMasterId(Long.valueOf(0));
        }else {
            /**含税运输,查找流程计算价格信息*/
            setInfo(vo);
        }
        for (GoodsordermjkEntity entity : entityList) {
            saveInfo(vo, entity);
        }
        return new WebReturnMessage(true,"保存成功！");
    }


    @Override
    @Transactional
    public WebReturnMessage saveCompleteInfo(GoodsordermjkVo vo) {
        logger.info("save the queryGoodOrderMJK information,by importId",vo.getImportId());
        if (vo.getIfTaxTransport() == null || "N".equals(vo.getIfTaxTransport())
                || "".equals(vo.getIfTaxTransport())) {
            /**不含税运输*/
            BigDecimal standardTax = new BigDecimal(StringFactory.getTaxRate());
            BigDecimal priceTax = vo.getPrice().add(vo.getPrice().multiply(standardTax));
            priceTax = priceTax.setScale(2, BigDecimal.ROUND_HALF_UP);
            vo.setStandardTax(standardTax);
            vo.setPriceTax(priceTax);
            vo.setIfTaxTransport("N");
            vo.setVatFlowMasterId(Long.valueOf(0));
        }else{
            /**含税运输,查找流程获得价格、税率等信息*/
            setInfo(vo);
        }
        GoodsordermjkEntity entity = goodsordermjkRepository.findById(vo.getImportId()).get();
        Assert.notNull(entity,"该电商单据不存在，请刷新页面重试！");
        Assert.isTrue(!"20".equals(entity.getStatus()),"该电商单据的状态已发生改变！");
        saveInfo(vo, entity);
        return new WebReturnMessage(true,"保存成功！");
    }


    /**保存实体类(保存采购货源信息包括经纬度信息)*/
    /**
     * @param vo
     * @param entity
     */
    private void saveInfo(GoodsordermjkVo vo, GoodsordermjkEntity entity) {
        if(StringUtils.isNotEmpty(vo.getStartPlateLng())) {
            entity.setStartPlateLng(vo.getStartPlateLng());
        }
        if(StringUtils.isNotEmpty(vo.getStartPlateLat())) {
            entity.setStartPlateLat(vo.getStartPlateLat());
        }
        if(StringUtils.isNotEmpty(vo.getEndPlateLng())) {
            entity.setEndPlateLng(vo.getEndPlateLng());
        }
        if(StringUtils.isNotEmpty(vo.getEndPlateLat())) {
            entity.setEndPlateLat(vo.getEndPlateLat());
        }
        // 经纬度(取单地、装货地、收货地   电商单据只需要做到目的地的金纬度更新操作)
        if(StringUtils.isNotEmpty(vo.getGetOrderPlateLng())) {
            entity.setGetOrderPlateLng(vo.getGetOrderPlateLng());
        }
        if(StringUtils.isNotEmpty(vo.getGetOrderPlateLat())) {
            entity.setGetOrderPlateLat(vo.getGetOrderPlateLat());
        }
        if(StringUtils.isNotEmpty(vo.getIfShow())){
            entity.setIsAutoDisplay(vo.getIfShow());
        }
        if(vo.getEndPlateProvince().equals(vo.getEndPlateCity())) {
            entity.setEndPlate(vo.getEndPlateProvince() + vo.getEndPlateCountry() + vo.getEndPlateDetail());
        }else {
            entity.setEndPlate(vo.getEndPlateProvince() + vo.getEndPlateCity() + vo.getEndPlateCountry() + vo.getEndPlateDetail());
        }
        if(StringUtils.isNotEmpty(vo.getStartPlate())){
            entity.setStartPlate(vo.getStartPlate());
        }
        if(StringUtils.isNotEmpty(vo.getGetOrderPlate())){
            entity.setGetOrderPlate(vo.getGetOrderPlate());
        }
        // 货源单委托人以及联系方式
        if(StringUtils.isNotEmpty(vo.getBillSender())){
            entity.setBillSender(vo.getBillSender());
        }
        if(StringUtils.isNotEmpty(vo.getBillSenderMobile())){
            entity.setBillSenderMobile(vo.getBillSenderMobile());
        }
        // 收货人以及联系方式
        if(StringUtils.isNotEmpty(vo.getReceiver())){
            entity.setReceiver(vo.getReceiver());
        }
        if(StringUtils.isNotEmpty(vo.getReceiverMobile())){
            entity.setReceiverMobile(vo.getReceiverMobile());
        }
        // 取单地的省市县
        if(StringUtils.isNotEmpty(vo.getEndPlateProvince())) {
            entity.setEndPlateProvince(vo.getEndPlateProvince());
        }
        if(StringUtils.isNotEmpty(vo.getEndPlateCity())) {
            entity.setEndPlateCity(vo.getEndPlateCity());
        }

        if(StringUtils.isNotEmpty(vo.getEndPlateCountry())) {
            entity.setEndPlateCountry(vo.getEndPlateCountry());
        }
        // 拆单(0不可拆单;1可拆单)
        if("1".equals(vo.getDetachable())){
            entity.setDetachable(vo.getDetachable());
            // 单车重量
            entity.setSingleCarWeight(vo.getSingleCarWeight());
        }else {
            entity.setDetachable("0");
        }
        entity.setCompanyId(vo.getCompanyId());

        if(StringUtils.isNotEmpty(vo.getGetOrderPlateProvince())) {
            entity.setGetOrderPlateProvince(vo.getGetOrderPlateProvince());
        }
        if(StringUtils.isNotEmpty(vo.getGetOrderPlateCity())) {
            entity.setGetOrderPlateCity(vo.getGetOrderPlateCity());
        }

        if(StringUtils.isNotEmpty(vo.getGetOrderPlateCountry())) {
            entity.setGetOrderPlateCountry(vo.getGetOrderPlateCountry());
        }
        if(StringUtils.isNotEmpty(vo.getGetOrderPlateDetail())) {
            entity.setGetOrderPlateDetail(vo.getGetOrderPlateDetail());
        }

        if(null != vo.getSendWeight()){
            entity.setWeight(vo.getSendWeight());
        }
        // 起始地的省市县
        if(StringUtils.isNotEmpty(vo.getStartPlateProvince())) {
            entity.setStartPlateProvince(vo.getStartPlateProvince());
        }
        if(StringUtils.isNotEmpty(vo.getStartPlateCity())) {
            entity.setStartPlateCity(vo.getStartPlateCity());
        }

        if(StringUtils.isNotEmpty(vo.getStartPlateCountry())) {
            entity.setStartPlateCountry(vo.getStartPlateCountry());
        }
        if(StringUtils.isNotEmpty(vo.getStartPlateDetail())) {
            entity.setStartPlateDetail(vo.getStartPlateDetail());
        }
        if(StringUtils.isNotEmpty(vo.getEndPlateDetail())) {
            entity.setEndPlateDetail(vo.getEndPlateDetail());
        }

        // 备注
        entity.setRemark(vo.getRemark());
        // 货物类型
        if(null != vo.getGoodType()){
            entity.setGoodType(vo.getGoodType());
        }
        if(StringUtils.isNotEmpty(vo.getGoodTypeDesc())) {
            entity.setGoodTypeDesc(vo.getGoodTypeDesc());
        }
        if(StringUtils.isNotEmpty(vo.getProdDesc())) {
            entity.setProdDesc(vo.getProdDesc());
        }
        if(StringUtils.isNotEmpty(vo.getGoodTypeDesc())) {
            entity.setGoodTypeDesc(vo.getGoodTypeDesc());
        }
        if(StringUtils.isNotEmpty(vo.getLossType())) {
            entity.setLossType(vo.getLossType());
        }
        if(vo.getLossRatio()!=null) {
            entity.setLossRatio(vo.getLossRatio());
        }
        if(vo.getLossWeight()!=null) {
            entity.setLossWeight(vo.getLossWeight());
        }
        // 货物单价
        if(null != vo.getGoodPrice()){
            entity.setGoodPrice(vo.getGoodPrice());
        }
        // 结算方式
        if(StringUtils.isNotEmpty(vo.getJsType())) {
            entity.setJsType(vo.getJsType());
        }
        // 预计里程
        if(vo.getEstimateKM()!=null) {
            entity.setEstimateKM(vo.getEstimateKM());
        }
        if(StringUtils.isNotEmpty(vo.getAppointTeamId())) {
            entity.setAppointTeamId(vo.getAppointTeamId());
        }
        //  指定承运信息
        if(StringUtils.isNotEmpty(vo.getAppointTeamType())) {
            entity.setAppointTeamType(vo.getAppointTeamType());
        }
        if(StringUtils.isNotEmpty(vo.getAppointTeamName())) {
            entity.setAppointPersonInfo(vo.getAppointTeamName());
        }
        // 发送方式
        if("APP_TO_WEB".equals(vo.getSendGroup())){
            entity.setSendGroup("APP");
        }
        else{
            entity.setSendGroup(vo.getSendGroup());
        }
        // 含税单价
        if(vo.getPriceTax()!=null){
            entity.setPriceTax(vo.getPriceTax());
        }
        // 单据有效期
        if(null != vo.getPickupDate()) {
            entity.setPickupDate(vo.getPickupDate());
        }
        // 车型
        if(StringUtils.isNotEmpty(vo.getVehicleStyleVar())) {
            entity.setVehicleStyleVar(vo.getVehicleStyleVar());
        }
        // 是否委托承运
        if(StringUtils.isNotEmpty(vo.getIfTaxTransport())) {
            entity.setIfTaxTransport(vo.getIfTaxTransport());
        }
        // 标准税率
        if(vo.getStandardTax()!=null) {
            entity.setStandardTax(vo.getStandardTax());
        }
        // 流程id
        if(vo.getVatFlowMasterId()!=null) {
            entity.setVatFlowMasterId(vo.getVatFlowMasterId());
        }
        // 阳煤丰喜挂牌价(元)
        if(vo.getListingPrice() !=null) {
            entity.setListingPrice(vo.getListingPrice());
        }
        // 服务费(类型,金额)
        if(StringUtils.isNotEmpty(vo.getChargePriceType())) {
            entity.setChargePriceType(vo.getChargePriceType());
        }
        if(null != vo.getChargePrice()) {
            entity.setChargePrice(vo.getChargePrice());
        }
        // 是否货款支付
        if(StringUtils.isNotEmpty(vo.getIfPayment())) {
            entity.setIfPayment(vo.getIfPayment());
        }
        // 提货名称
        if(StringUtils.isNotEmpty(vo.getPickUpGoodsName())){
            entity.setPickUpGoodsName(vo.getPickUpGoodsName());
        }
        // 品种信息
        if(null != vo.getCatalogId()) {
            entity.setCatalogId(vo.getCatalogId());
        }
        if(StringUtils.isNotEmpty(vo.getCatalogName())) {
            entity.setCatalogName(vo.getCatalogName());
        }
        // 集团信息
        if(null != vo.getGroupId()) {
            entity.setGroupId(vo.getGroupId());
        }
        if(StringUtils.isNotEmpty(vo.getGroupName())) {
            entity.setGroupName(vo.getGroupName());
        }
        // 单价/底价(元/吨)
        entity.setPrice(vo.getPrice());

        // 最高接受价(元/吨)
        entity.setMaxPrice(vo.getMaxPrice());
        // 总价
        entity.setAmount(vo.getAmount());
        entity.setIfInfoComplete("Y");
        // 采购信息完善备注
        if(StringUtils.isNotEmpty(vo.getCgSaveRemark())) {
            entity.setCgSaveRemark(vo.getCgSaveRemark());
        }
        // 平台
        entity.setPlatformId(vo.getPlatformId());
        // 增发方式
        if(StringUtils.isNotEmpty(vo.getAddWeightType())) {
            entity.setAddWeightType(vo.getAddWeightType());
        }
        goodsordermjkRepository.save(entity);
    }

    /**税率、价格的计算*/
    private void setInfo(GoodsordermjkVo vo) {
        // 查询公司流程是否存在(这里根据VO中的companyId)
        List<VatflowdetailEntity> flowList = vatflowdetailService.listByPulishCompanyId(vo.getCompanyId());
        Assert.notNull(flowList, "该单据发布的是委托承运单据，但找不到此委托承运流程");
        Assert.isTrue(flowList.size() <= 1,"该单据发布的是委托承运单据，但存在多个委托承运流程");
        VatflowdetailEntity flow = flowList.get(0);

        String vatRateChose = flow.getVatRateChose();
        BigDecimal vatStandardRate = flow.getVatStandardRate();
        BigDecimal vatPolicyRate =  flow.getVatPolicyRate();
        String vatAccType = flow.getVatAccType();

        BigDecimal price = vo.getPrice();
        BigDecimal rate = "1".equals(vatRateChose) ? vatStandardRate : vatPolicyRate;
        // 选择乘法
        BigDecimal multipart = price.multiply(new BigDecimal("1").add(rate));
        // 选择除法
        BigDecimal divide = price.divide(new BigDecimal("1").subtract(rate),10,BigDecimal.ROUND_HALF_UP);
        BigDecimal priceTax = "1".equals(vatAccType) ? multipart : divide;
        // 精度
        priceTax = priceTax.setScale(2, BigDecimal.ROUND_HALF_UP);
        // 货主含税运费单价抹分
        if ("1".equals(vo.getIfOwnerTaxpriceMf())) {
            priceTax = priceTax.setScale(1, BigDecimal.ROUND_HALF_UP);
        }
        vo.setStandardTax(rate);
        vo.setPriceTax(priceTax);
        vo.setIfTaxTransport("Y");
        vo.setVatFlowMasterId(flow.getVatFlowMasterId());
    }

	@Override
	public GoodsordermjkEntity queryActive(GoodsordermjkVo vo) {
		logger.info("query the GoodsordermjkEntity where status is 10 and importId:{}",vo.getImportId());
		return goodsordermjkRepository.findByStatusAndImportId("10",vo.getImportId());
	}

	@Override
    @Transactional
	public void updateGoodsOrdermjkLngLat(GoodsordermjkVo vo) {
		logger.info("adjust the GoodsordermjkEntity's lng and lat by importId:{}",vo.getImportId());
		if(vo.getAppointTeamId() != null && !"".equals(vo.getAppointTeamId()) && vo.getAppointTeamId().toString().indexOf("default") == -1){
			// 不是全部组
			vo.setAppointTeamType("2");
		}else{
			// 全部组
			vo.setAppointTeamType("1");
		}
		if (StringUtils.isEmpty(vo.getIfTaxTransport()) || "N".equals(vo.getIfTaxTransport())) {
			BigDecimal price = vo.getPrice();
			BigDecimal taxRate = new BigDecimal(StringFactory.getTaxRate());
			BigDecimal priceTax = price.add(price.multiply(taxRate));
			priceTax = priceTax.setScale(2, BigDecimal.ROUND_HALF_UP);  
			vo.setStandardTax(taxRate);
			vo.setPriceTax(priceTax);
			vo.setIfTaxTransport("N");
			vo.setVatFlowMasterId(Long.valueOf(0));
		} else {
			setInfo(vo);
		}
		/*页面上获取经纬度失败之后取数据库中保存的经纬度*/
		getPlatLngLat(vo);
		if ((null == vo.getEstimateKM() || "".equals(vo.getEstimateKM().toString()))
			&& vo.getGetOrderPlateLat()!=null && vo.getGetOrderPlateLng()!=null
			&& vo.getEndPlateLng()!=null && vo.getEndPlateLat()!=null){
				double startLng = Double.parseDouble(vo.getGetOrderPlateLng());
				double startLat = Double.parseDouble(vo.getGetOrderPlateLat());
				double endLng = Double.parseDouble(vo.getEndPlateLng());
				double endLat = Double.parseDouble(vo.getEndPlateLat());
				vo.setEstimateKM(new BigDecimal(LatLngGetDistance.getDistance(startLat, startLng, endLat,endLng)));
		}
		GoodsordermjkEntity entity = goodsordermjkRepository.findById(vo.getImportId()).get();
		saveInfo(vo,entity);
	}
		
	/**
	 * 取经纬度失败后拿数据库的经纬度
	 * @param param
	 * @return
	 */
	public void getPlatLngLat(GoodsordermjkVo vo){
		BaseDataQueryVo baseDataQueryVo = new BaseDataQueryVo();
		BasedataEntity basedataEntity = new BasedataEntity();
		/*取单地*/
		if("undefined".equals(vo.getGetOrderPlateLng())||"undefined".equals(vo.getGetOrderPlateLat())
				   ||"".equals(vo.getGetOrderPlateLng())||"".equals(vo.getGetOrderPlateLat())
				   ||null==(vo.getGetOrderPlateLng())||null==(vo.getGetOrderPlateLat())){
			baseDataQueryVo.setKeyValue(vo.getGetOrderPlateCountry());
			baseDataQueryVo.setFatherKeyValue(vo.getGetOrderPlateCity());
			basedataEntity = baseDataService.getPlatLngLat(baseDataQueryVo);
			vo.setGetOrderPlateLng(basedataEntity.getLng().toString());
			vo.setGetOrderPlateLat(basedataEntity.getLat().toString());
		}
		/*装货地*/
		if("undefined".equals(vo.getStartPlateLng())||"undefined".equals(vo.getStartPlateLat())
				   ||"".equals(vo.getStartPlateLng())||"".equals(vo.getStartPlateLat())
				   ||null==(vo.getStartPlateLng())||null==(vo.getStartPlateLat())){
			baseDataQueryVo.setKeyValue(vo.getStartPlateCountry());
			baseDataQueryVo.setFatherKeyValue(vo.getStartPlateCity());
			basedataEntity = baseDataService.getPlatLngLat(baseDataQueryVo);
			vo.setStartPlateLng(basedataEntity.getLng().toString());
			vo.setStartPlateLat(basedataEntity.getLat().toString());
		}
		/*收货地*/
		if("undefined".equals(vo.getEndPlateLng())||"undefined".equals(vo.getEndPlateLat())
				   ||"".equals(vo.getEndPlateLng())||"".equals(vo.getEndPlateLat())
				   ||null==(vo.getEndPlateLng())||null==(vo.getEndPlateLat())){
			baseDataQueryVo.setKeyValue(vo.getEndPlateCountry());
			baseDataQueryVo.setFatherKeyValue(vo.getEndPlateCity());
			basedataEntity = baseDataService.getPlatLngLat(baseDataQueryVo);
			vo.setEndPlateLng(basedataEntity.getLng().toString());
			vo.setEndPlateLat(basedataEntity.getLat().toString());
		}
	}

	@Override
	@Transactional
	public void agree(GoodsordermjkVo vo) {
           priceAdjust(vo);
        //"Y"代表委托承运采购单据发布
		if("Y".equals(vo.getFlagTax())){
			// 查询货主运费单价/总价调整
			priceAdjust(vo);
			// 外部接口委托承运货源发布
			publishTax(vo);
		}else{
			// 外部接口电商货源发布
			publish(vo);
		}	
		// 插入货源单运费调整明细
		insertPriceAdjustDetail(vo);
		// HashMap map = (HashMap) dao.queryMap("goodOrderAudit.queryGoodsInfo", vo);
		
	}
	
	/**
	 * 查询货主运费单价/总价调整
	 * @param param
	 */
	private void priceAdjust(GoodsordermjkVo vo) {
		
		if ("Y".equals(vo.getIfTaxTransport())) {
			// 判断是否有授信配置
			CreditConfigQueryVo configQueryVo = new CreditConfigQueryVo();
			configQueryVo.setPlatformId(vo.getPlatformId());
			configQueryVo.setCompanyId(vo.getCompanyId());
			configQueryVo.setCreditStatus("90");
			configQueryVo.setAdjPriceStatus("90");
			List<CreditConfigVo> onfigList = creditConfigService.queryIsCredit(configQueryVo);
			if (onfigList.size() > 1) {
				Assert.isTrue(false,"您存在多种价格调整方式！");
			} else if (onfigList.size() == 1) {
				CreditConfigVo creditConfigVo = onfigList.get(0);
				// 判断是否可发单(20：可发单)
				if ("20".equals(creditConfigVo.getCreditFdStatus())) {
					// 判断调价类型(01：单价调价，02：单车调价)
					if ("01".equals(creditConfigVo.getAdjPriceStyle())) {
						vo.setCurPrice(vo.getPrice());
					} else if ("02".equals(creditConfigVo.getAdjPriceStyle())) {
						vo.setCurPrice(vo.getAmount());
					}
					// 查询授信加价
					CreditAdjustPriceDetailQueryVo priceDetailQueryVo = new CreditAdjustPriceDetailQueryVo();
					priceDetailQueryVo.setPlatformId(vo.getPlatformId());
					priceDetailQueryVo.setCompanyId(vo.getCompanyId());
					priceDetailQueryVo.setCreditStatus("90");
					priceDetailQueryVo.setAdjPriceStatus("90");
					priceDetailQueryVo.setCurPrice(vo.getCurPrice());
					List<CreditAdjustPriceDetailVo> priceDetailList = creditAdjustPriceDetailService.queryCreditAddPrice(priceDetailQueryVo);
					if (priceDetailList.size() > 1) {
						Assert.isTrue(false,"存在多个授信加价调整区间！");
					} else if (priceDetailList.size() == 1) {
						CreditAdjustPriceDetailVo detailVo = priceDetailList.get(0);
						vo.setOwnerAdjustFlag("Y");
						vo.setOwnerAdjustType(detailVo.getAdjPriceStyle());
						vo.setOwnerAdjustAmt(detailVo.getCreditAddPrice());
						// 调价id
						vo.setCredAdjDId(detailVo.getCredAdjDId());
					} else {
						vo.setOwnerAdjustFlag("N");
						vo.setOwnerAdjustType("01");
						vo.setOwnerAdjustAmt(new BigDecimal("0"));
						throw new RuntimeException("未找到对应的授信加价调整区间！");
					}
				} else {
					throw new RuntimeException("您的授信金额未还款，被禁止发单，请联系管理员！");
				}
			} else {
				vo.setOwnerAdjustFlag("N");
				vo.setOwnerAdjustType("01");
				vo.setOwnerAdjustAmt(new BigDecimal("0"));
			}
		}
	}

	
	/**外部接口电商,采购货源发布通用方法*/
    @Transactional
	public void publish(GoodsordermjkVo vo) {
		if(vo.getSendKM() == null){
			vo.setSendKM(10000);
		}
	//	if(null != vo.getCatalogId() && StringUtils.isNotEmpty(vo.getCatalogName())) {
			// 大品种查询
			CatalogQueryVo catalogQueryVo = new CatalogQueryVo(); 
			catalogQueryVo.setGoodType(vo.getGoodType());
			catalogQueryVo.setGoodTypeDesc(vo.getGoodTypeDesc());
			catalogQueryVo.setPlatformId(vo.getPlatformId());
			catalogQueryVo.setStatus("20");
			catalogQueryVo.setLayer("1");
			CatalogInfoVo catalog = catalogService.queryCatalogIdAndName(catalogQueryVo);
			Assert.notNull(catalog,"当前单据的货物类型对应的大品种不存在，请先维护!");
			vo.setCatalogId(catalog.getCatalogId());
			vo.setCatalogName(catalog.getCatalogName());
		//	BeanUtils.copyProperties(catalog, vo);

	//	}
		if("DS".equals(vo.getFromType())) {
			// 电商只发一次,采购的只要单据还有发单量就可以继续发(initSpiltWeight不为零)
			Long findEntity = goodsordermjkRepository.findEntity(vo.getImportId());
			//只判断电商的单据
			Assert.isTrue(findEntity == 1,"该货源已发布或平台存在相同已生效的电商单据,请勿重复发布!");
		}
		
		GoodsordermjkEntity entity = goodsordermjkRepository.findById(vo.getImportId()).get();
		GoodsordermVo goodsordermVo = new GoodsordermVo();
		BeanUtils.copyProperties(entity, goodsordermVo);
		
		setgoodsordermjkEntity(entity,goodsordermVo,vo);
		// 发布货源(保存到GoodsOrderM)
		GoodsordermEntity goodsordermEntity = goodsordermService.saveGoodsordermVo(goodsordermVo);
		// 设置主单号
		if(null == vo.getPriPublishId()) {
			// 非拼单时
			goodsordermEntity.setPriPublishId(goodsordermEntity.getPublishId());
			goodsordermService.save(goodsordermEntity);
		}
		// 货源发布编号
		vo.setPublishId(goodsordermEntity.getPublishId());
        // 可拆单发布(减去已发布的量)
		if("1".equals(vo.getSpiltType())){
          doSpiltPublish(entity,vo);
		}
		entity.setStatus(vo.getStatus());
		entity.setPublishId(vo.getPublishId());
		entity.setApproveTime(new Date());
		entity.setApproveUserId(vo.getUserId().toString());
		entity.setCatalogId(vo.getCatalogId());
		entity.setCatalogName(vo.getCatalogName());
		GoodsordermjkEntity resulEntity = goodsordermjkRepository.save(entity);
		Assert.notNull(resulEntity,"页面数据已过时，请刷新页面!");
	}

	/**外部接口委托承运货源发布*/
    @Transactional
	public void publishTax(GoodsordermjkVo vo) {	
		if (StringUtils.isEmpty(vo.getIfTaxTransport()) || "N".equals(vo.getIfTaxTransport())) {
			BigDecimal price = vo.getPrice();
			BigDecimal taxRate = new BigDecimal(StringFactory.getTaxRate());
			BigDecimal priceTax = price.add(price.multiply(taxRate));
			priceTax = priceTax.setScale(2, BigDecimal.ROUND_HALF_UP);  
			vo.setStandardTax(taxRate);
			vo.setPriceTax(priceTax);
			vo.setIfTaxTransport("N");
			vo.setVatFlowMasterId(Long.valueOf(0));
			Integer countTax = goodsordermService.findGoodCountTax(vo);
			Assert.isTrue(countTax <= 0,"同一采购单据下，已发布过有效的委托承运单据，不能再发布非委托承运的单据！");
		}else{
			Integer count = goodsordermService.findGoodCount(vo);
			Assert.isTrue(count <= 0,"同一采购单据下，已发布过有效的非委托承运单据，不能再发布委托承运的单据！");
		}
		//大品种查询
		CatalogQueryVo catalogQueryVo = new CatalogQueryVo(); 
		catalogQueryVo.setGoodType(vo.getGoodType());
		catalogQueryVo.setGoodTypeDesc(vo.getGoodTypeDesc());
		catalogQueryVo.setPlatformId(vo.getPlatformId());
		catalogQueryVo.setStatus("20");
		catalogQueryVo.setLayer("1");
		CatalogInfoVo catalog = catalogService.queryCatalogIdAndName(catalogQueryVo);
		Assert.notNull(catalog,"当前单据的货物类型对应的大品种不存在，请先维护!");
		BeanUtils.copyProperties(catalog, vo);
		GoodsordermjkEntity goodsordermjkEntity = goodsordermjkRepository.findById(vo.getImportId()).get();
		// TODO
		/*dao.update("goodOrderAudit.updateGoodsOrdermjkLngLatTax", vo);
		if(vo.get("sendKM")==null || "".equals(vo.get("sendKM"))){
			vo.put("sendKM", 10000);
		}
		dao.insert("goodOrderAudit.insertGoodsOrderMFromJKTax", vo);
		if ("0".equals(vo.get("publishId")))
		{
			throw new RuntimeException("页面数据已过时，请刷新页面!");
		}
		if(null==vo.get("estimateKM")||"".equals(vo.get("estimateKM"))){
			HashMap map=(HashMap) dao.queryMap("goodOrderAudit.queryEstimateKM", vo);
			if (map.get("getOrderAddressLat")!=null&&map.get("getOrderAddressLng")!=null
					&&map.get("destinationLat")!=null&&map.get("destinationLng")!=null) {
				 Double startLat=Double.valueOf((String)map.get("getOrderAddressLat"));
				 Double startLng=Double.valueOf((String)map.get("getOrderAddressLng"));
				 Double endLat=Double.valueOf((String)map.get("destinationLat"));
				 Double endLng=Double.valueOf((String)map.get("destinationLng"));
				 Double len=LatLngGetDistance.getDistance(startLat, startLng, endLat,endLng);
				 //vo.put("latLngGetDistance", len);
				 //dao.update("goodsOrder.latLngGetDistance", vo);
			}
		}*/
        // 可拆单发布
		if("1".equals(vo.getSpiltType())){
          doSpiltPublish(goodsordermjkEntity,vo);
		}
		GoodsordermjkEntity resulEntity = goodsordermjkRepository.save(goodsordermjkEntity);
		Assert.notNull(resulEntity,"页面数据已过时，请刷新页面!");
	}
	
	/**
	 * 插入货源单运费调整明细
	 * @param vo
	 */
    @Transactional
	private void insertPriceAdjustDetail(GoodsordermjkVo vo) {
		if ("Y".equals(vo.getOwnerAdjustFlag())) {
			CreditAdjustPriceDetailEntity creditDetail = creditAdjustPriceDetailService.findByCredAdjDId(vo.getCredAdjDId());
			GoodsordermadjustdetailEntity enity = new GoodsordermadjustdetailEntity();
			// 货源发布id
			enity.setPublishId(vo.getPublishId());
			// 货主运费调价明细id
			enity.setCredAdjDId(creditDetail.getCredAdjDId());
			// 授信调价主表id
			enity.setCredAdjMId(creditDetail.getCredAdjMId());
			// 货源单单价区间起始价(包含)
			enity.setMinPrice(creditDetail.getMinPrice());
			// 货源单单价区间结束价(不包含)
			enity.setMaxPrice(creditDetail.getMaxPrice());
			// 授信加价
			enity.setCreditAddPrice(creditDetail.getCreditAddPrice());
			enity.setCreateDate(new Date());
			enity.setCreatePersonId(vo.getUserId());
			enity.setCreatePersonName(vo.getUserName());
			goodsordermadjustDetailService.save(enity);
		}
	}
	
	/**封装信息
	 * @param GoodsordermjkEntity entity
	 * @param GoodsordermVo goodsordermVo
	 * @param GoodsordermjkVo vo
	 */
	private void setgoodsordermjkEntity(GoodsordermjkEntity entity, GoodsordermVo goodsordermVo,GoodsordermjkVo vo) {
		// 总价
		goodsordermVo.setAmount(vo.getAmount());
		//货源单为有效状态
        goodsordermVo.setStatus("20");
		goodsordermVo.setPrice(vo.getPrice());
        goodsordermVo.setCreateDate(new Date());
        //电商采购的单据号 (电商采购的单据都是使用ret_2作为单据号)
        goodsordermVo.setDependNum(entity.getRet2());
		// 含税价
        if(vo.getPriceTax()!=null) {
            goodsordermVo.setPriceTax(vo.getPriceTax());
        }
		// 设置发单人id
        goodsordermVo.setUserId(vo.getUserId());
        // 平台id
        goodsordermVo.setPlatformId(vo.getPlatformId());
        // 委托人、收货人信息
        if(StringUtils.isNotEmpty(vo.getBillTaker())) {    	
        	goodsordermVo.setBillTaker(vo.getBillTaker());
        }
        if(StringUtils.isNotEmpty(vo.getBillTakerMobile())) { 
        	goodsordermVo.setBillTakerMobile(vo.getBillTakerMobile());	
        }
        if(StringUtils.isNotEmpty(vo.getReceiver())) { 
        	goodsordermVo.setBillTaker(vo.getReceiver());	
        }
        if(StringUtils.isNotEmpty(vo.getReceiverMobile())) { 
        	goodsordermVo.setReceiverMobile(vo.getReceiverMobile());
        }
        // 装货地{"address":"山西省临汾市曲沃县立恒西门","lngLat":{"lng":111.527041,"lat":35.704201}}
        String startPlate = entity.getStartPlate() == null ?  "" : entity.getStartPlate();
        String startPlateLng = entity.getStartPlateLng() == null ?  "" : entity.getStartPlateLng();
        String startPlateLat = entity.getStartPlateLat() == null ?  "" : entity.getStartPlateLat();
        goodsordermVo.setDeparture("{\"address\":\""+ startPlate +"\",\"lngLat\":{\"lng\":"+ startPlateLng +",\"lat\":"+ startPlateLat +"}}");
        goodsordermVo.setDepartureLng(new BigDecimal(vo.getStartPlateLng()));
        goodsordermVo.setDepartureLat(new BigDecimal(vo.getStartPlateLat()));
        // 目的地
        String endPlate = entity.getEndPlate() == null ?  "" : entity.getEndPlate();
        String endPlateLng = entity.getEndPlateLng() == null ?  "" : entity.getEndPlateLng();
        String endPlateLat = entity.getEndPlateLat() == null ?  "" : entity.getEndPlateLat();
        goodsordermVo.setDestination("{\"address\":\""+ endPlate +"\",\"lngLat\":{\"lng\":"+ endPlateLng +",\"lat\":"+ endPlateLat +"}}");
        goodsordermVo.setDestinationLng(new BigDecimal(vo.getEndPlateLng()));
        goodsordermVo.setDestinationLat(new BigDecimal(vo.getEndPlateLat()));
        // 取单地
        String getOrderPlate = entity.getGetOrderPlate() == null ?  "" : entity.getGetOrderPlate();
        String getOrderPlateLng = entity.getGetOrderPlateLng() == null ?  "" : entity.getGetOrderPlateLng();
        String getOrderPlateLat = entity.getGetOrderPlateLat() == null ?  "" : entity.getGetOrderPlateLat();
        goodsordermVo.setGetOrderAddress("{\"address\":\""+ getOrderPlate +"\",\"lngLat\":{\"lng\":"+ getOrderPlateLng +",\"lat\":"+ getOrderPlateLat +"}}");
        goodsordermVo.setGetOrderAddressLng(new BigDecimal(vo.getGetOrderPlateLng()));
        goodsordermVo.setGetOrderAddressLat(new BigDecimal(vo.getGetOrderPlateLat()));
        // 推送距离
        goodsordermVo.setSendKM(vo.getSendKM() == null ? entity.getSendKM() : vo.getSendKM());
        // 1为可拆单，0为不可拆单
        if(StringUtils.isNotEmpty(vo.getDetachable())) {
            goodsordermVo.setDetachable(vo.getDetachable());
        }
        // 单据有效时间
        if(null != vo.getPickupDate()) {
            goodsordermVo.setPickupDate(vo.getPickupDate());
        }else {
            // 默认单据有效时间,第二天7点整
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Calendar calendar = Calendar.getInstance();
            calendar.add(calendar.DATE, 1);
            calendar.set(calendar.HOUR_OF_DAY, 7);
            calendar.set(calendar.MINUTE, 0);
            calendar.set(calendar.SECOND, 0);
            goodsordermVo.setPickupDate(calendar.getTime());
        }

		goodsordermVo.setInitQty(entity.getQty());
        //初始金额
		goodsordermVo.setInitAmount(vo.getAmount());
		goodsordermVo.setInitWeight(entity.getWeight());
		//发单的公司id
		goodsordermVo.setCompanyId(vo.getCompanyId());
		// 发送群组(APP,WEB,ALL)
		if("APP_TO_WEB".equals(vo.getSendGroup())) {
			goodsordermVo.setSendGroup("APP");	
		}else {
			goodsordermVo.setSendGroup(vo.getSendGroup());
		}
		// 最高接受价
		goodsordermVo.setMaxPrice(vo.getMaxPrice());
		// 0为直接抢单，1为可以报价
		if(StringUtils.isNotEmpty(vo.getQbType())) {
			goodsordermVo.setQbType(vo.getQbType());
		}
		// 底价
		goodsordermVo.setFloorPrice(vo.getPrice());
        // 定向承运组id
        if(StringUtils.isNotEmpty(vo.getAppointTeamId())) {
            goodsordermVo.setAppointTeamId(vo.getAppointTeamId());
        }
        // 投放单可出价次数
        if(null != vo.getBidTimes()) {
            goodsordermVo.setBidTimes(vo.getBidTimes());
        }

		// 定向承运名称
		if(StringUtils.isNotEmpty(vo.getAppointTeamName())) {
			goodsordermVo.setAppointPersonInfo(vo.getAppointTeamName());
		}

		// 默认1为不定向,其他为定向,不能为NULL, 2定向
		TeamCompanyEntity  teamCompany = teamCompanyService.findByTeamId(vo.getAppointTeamId(),vo.getPlatformId());
		if(teamCompany == null || StringUtils.isEmpty(teamCompany.getType())) {
			goodsordermVo.setAppointTeamType("1");
		}
		else{
		    goodsordermVo.setAppointTeamType(teamCompany.getType());
        }

		// 单据来源
		goodsordermVo.setFromType(vo.getFromType());

        // 优先app用户抢时,web用户是否可抢,Y:可抢,N:不可抢
        goodsordermVo.setWebCanGrab("Y");
        if(null!=vo.getSendGroup() && "APP_TO_WEB".equals(vo.getSendGroup())){
            goodsordermVo.setWebCanGrab("N");
        }

		// 报价时,是否自动生成运单, 0:否,1:是
		if(StringUtils.isNotEmpty(vo.getIsAutoToTrans())) {
			goodsordermVo.setIsAutoToTrans(vo.getIsAutoToTrans());
		}
        else{
            goodsordermVo.setIsAutoToTrans("0");
        }
		// 预计里程
		goodsordermVo.setEstimateKM(entity.getEstimateKM());
		// 车型
		goodsordermVo.setVehicleStyleVar(vo.getVehicleStyleVar());
		logger.info("车型：",vo.getVehicleStyleVar());
		logger.info("车型2",vo.getCarStyle());


        if(StringUtils.isNotEmpty(vo.getDocuType())) {
            goodsordermVo.setDocuType(vo.getDocuType());
        }
        if(StringUtils.isNotEmpty(vo.getDocuPriSec())){
            goodsordermVo.setDocuPriSec(vo.getDocuPriSec());
        }
        // 如果为docu_pri_sec为2的话，主单的publish_id
//        if("2".equals(vo.getDocuPriSec())) {
//            // 拼单的单据主次，1为主单，2为次单
//            goodsordermVo.setPriPublishId(vo.getPublishId());
//        }else{
//            goodsordermVo.setPriPublishId(vo.getPriPublishId());
//        }
        //主单发布的时候通过插入之后再回填写
        if(vo.getPriPublishId() !=null){
            goodsordermVo.setPriPublishId(vo.getPriPublishId());
        }
		// 拼单号
		if(null != vo.getPinDanNum()) {
			goodsordermVo.setPinDanNum(vo.getPinDanNum());
		}
		if(vo.getSingleCarWeight() !=null){
		    goodsordermVo.setSingleCarWeight(vo.getSingleCarWeight());
        }
        if(StringUtils.isNotEmpty(vo.getLossType())){
            goodsordermVo.setLossType(vo.getLossType());
        }
        if(vo.getLossRatio()!=null){
            goodsordermVo.setLossRatio(vo.getLossRatio());
        }
        if(vo.getLossWeight()!=null){
            goodsordermVo.setLossWeight(vo.getLossWeight());
        }
        goodsordermVo.setPickUpGoodsName(vo.getPickUpGoodsName());
        // 是否隐藏
		if(StringUtils.isNotEmpty(vo.getIfShow())) {
			goodsordermVo.setIsAutoDisplay(vo.getIfShow());
		}
		//服务费
		if(null!=vo.getChargePrice()){
		    goodsordermVo.setChargePrice(vo.getChargePrice());
        }
        if(StringUtils.isNotEmpty(vo.getChargePriceType())){
            goodsordermVo.setChargePriceType(vo.getChargePriceType());
        }
		// 丰喜挂牌价
		if(null != vo.getListingPrice()) {
			goodsordermVo.setListingPrice(vo.getListingPrice());
		}
		// 货主调价信息(调价记录,调价类型，调价金额)
		if(null == vo.getOwnerAdjustFlag()) {
			goodsordermVo.setOwnerAdjustFlag("N");
		}else {
			goodsordermVo.setOwnerAdjustFlag(vo.getOwnerAdjustFlag());
		}
		if(null == vo.getOwnerAdjustType()) {
			goodsordermVo.setOwnerAdjustType("01");
		}else {
			goodsordermVo.setOwnerAdjustType(vo.getOwnerAdjustType());
		}
		if(null == vo.getOwnerAdjustAmt()) {
			goodsordermVo.setOwnerAdjustAmt(new BigDecimal(0));
		}else {
			goodsordermVo.setOwnerAdjustAmt(vo.getOwnerAdjustAmt());
		}
		// 货物信息
		if(null != vo.getCatalogId()) {
			goodsordermVo.setCatalogId( vo.getCatalogId());
		}
		if(StringUtils.isNotEmpty(vo.getCatalogName())) {
			goodsordermVo.setCatalogName( vo.getCatalogName());
		}
		// 1代表含税单价抹分,四舍五入;0代表不处理
		if(StringUtils.isNotEmpty(vo.getIfOwnerTaxpriceMf())) {
			goodsordermVo.setIfOwnerTaxpriceMf( vo.getIfOwnerTaxpriceMf());
		}
		// 备注
		goodsordermVo.setPs(vo.getRemark());
		goodsordermVo.setHeavyPiece(entity.getHeavyPiece() == null ? new BigDecimal("0") : new BigDecimal(entity.getHeavyPiece()));
		// 定向承运人（组）信息
		goodsordermVo.setAppointPersonInfo(vo.getAppointTeamName());
		// 集团信息
		goodsordermVo.setGroupId(vo.getGroupId() == null ? null : Long.valueOf(vo.getGroupId()));
		goodsordermVo.setGroupName(vo.getGroupName());
		// 流程id
		goodsordermVo.setVatFlowMasterId(entity.getVatFlowMasterId());
		if(StringUtils.isNotEmpty(vo.getDqFlag())) {
            goodsordermVo.setDqFlag(vo.getDqFlag());
        }
		if(StringUtils.isNotEmpty(entity.getRet1())) {
			// 单据来源域名
			goodsordermVo.setFromPlatName(entity.getRet1());
		}
		// 定抢时间
		goodsordermVo.setDqSttDate(vo.getRobDayTime() == null ? new Date() : vo.getRobDayTime());
		goodsordermVo.setDqEndDate(vo.getRobEndTime() == null ? new Date() : vo.getRobEndTime());	
		// docu_type(单据类型，1为双程单，0或空为单程单,2表示多单)
		goodsordermVo.setDocuType(StringUtils.isEmpty(vo.getDocuType()) ? "0" : vo.getDocuType());
		// Beanutils copy的原因,清空货源单id防止一直在做更新

		goodsordermVo.setPublishId(null);
        //拼单数
        if(vo.getCombinedNumber() !=null){
            goodsordermVo.setCombinedNumber(vo.getCombinedNumber());
        }
        goodsordermVo.setStartTakeDeliveryDate(null);
        goodsordermVo.setUpdateDate(null);
        // 是否定抢
        if(StringUtils.isEmpty(vo.getQbType())) {
        	 goodsordermVo.setQbType("0");
        }
        //合同号
        goodsordermVo.setContractNumber(entity.getContractNumber());
        // 增发类型
        if(StringUtils.isNotEmpty(vo.getAddWeightType())) {
            goodsordermVo.setAddWeightType(vo.getAddWeightType());
        }

	}
	
	/**可拆单量修改*/
    @Transactional
	public void doSpiltPublish(GoodsordermjkEntity entity,GoodsordermjkVo vo){
		  // 校验量
		  BigDecimal initSpiltWeight = entity.getInitSpiltWeight();
		  BigDecimal sendWeight = vo.getSendWeight();

		  if(initSpiltWeight != null && (initSpiltWeight.compareTo(new BigDecimal("0")) == 0 || sendWeight.compareTo(initSpiltWeight) > 0)){
			  throw new RuntimeException("可发布量为0或超过剩余发布量,请刷新页面重试");  
		  }
		  BigDecimal remainWeight =  initSpiltWeight.subtract(sendWeight);
		  entity.setInitSpiltWeight(remainWeight);
		  // 可拆弹初始化重量修改
		  goodsordermjkRepository.save(entity);
	      if(entity != null && remainWeight.compareTo(new BigDecimal("0")) == 0){
	    	  /**表示量已经全部发布*/
	    	  vo.setStatus("20");		
	      }else{
	    	  vo.setStatus("10");
	      }
	}

	@Override
	public void getPriceTax(GoodsordermjkVo vo) {
		logger.error("calculate the price tax,companyId:{}",vo.getCompanyId());
        // 查询公司流程是否存在(这里根据VO中的companyId)
        List<VatflowdetailEntity> flowList = vatflowdetailService.listByPulishCompanyId(vo.getCompanyId());
        Assert.notNull(flowList , "该单据发布的是委托承运单据，但找不到此委托承运流程");
        Assert.isTrue(flowList.size() <= 1,"该单据发布的是委托承运单据，但存在多个委托承运流程");
        if(flowList != null && flowList.size() > 0) {
        	VatflowdetailEntity flow = flowList.get(0);

            String vatRateChose = flow.getVatRateChose();
            BigDecimal vatStandardRate = flow.getVatStandardRate();
            BigDecimal vatPolicyRate =  flow.getVatPolicyRate();
            String vatAccType = flow.getVatAccType();

            BigDecimal price = vo.getPrice();
            BigDecimal rate = "1".equals(vatRateChose) ? vatStandardRate : vatPolicyRate;
            // 选择乘法
            BigDecimal multipart = price.multiply(new BigDecimal("1").add(rate));
            // 选择除法
            BigDecimal divide = price.divide(new BigDecimal("1").subtract(rate),10,BigDecimal.ROUND_HALF_UP);
            BigDecimal priceTax = "1".equals(vatAccType) ? multipart : divide;
            // 精度
            priceTax = priceTax.setScale(2, BigDecimal.ROUND_HALF_UP);
            vo.setPriceTax(priceTax);
        }
        
	}
	
	/**
	 * 获取编号
	 * @param typeId
	 * @return
	 */
	public String getSeqNum(String typeId) {
		logger.info("call generate_docu_no pro,typeId:{}",typeId);
    	HashMap<String, Object> propMap = new HashMap<String, Object>();
    	propMap.put("typeId", typeId);
    	propMap.put("seqNum", "");
    	mybatisQuery.executePro("transportSettle.getSeqNumPro", propMap);
    	String seqNum = (String) propMap.get("seqNum"); 
    	logger.info("call generate_docu_no pro,seqNum:{}",seqNum);
		return seqNum;
	}

	//拼单货源发布
	@Override
    @Transactional
	public void publishPinDan(GoodsordermjkVo goodsordermjkVo) {
		// 货源单据的拼接串
		String[] importIdArr = goodsordermjkVo.getImportIdStr().split(",");
		Long publishId = null;
		List <GoodsordermjkEntity> list = new ArrayList<GoodsordermjkEntity>();
		for(int count = 0; count < importIdArr.length;count ++) {
            GoodsordermjkEntity entity = goodsordermjkRepository.findByImportIdAndStatus(Long.valueOf(importIdArr[count]), "40");
            if (entity != null) {
                list.add(entity);
            }
        }
        Assert.isTrue(list.size()==importIdArr.length,"页面数据已过时，请刷新页面!");
		for (int i = 0; i < list.size(); i++) {
		    //需要判断拼单选中的单据的状态
			GoodsordermjkEntity entity = list.get(i);
			GoodsordermjkVo vo = new GoodsordermjkVo();
			BeanUtils.copyProperties(entity, vo);
			// 将页面修改的值以及基础信息放在新的vo
			vo.setQbType(goodsordermjkVo.getQbType());
			vo.setIsAutoToTrans(goodsordermjkVo.getIsAutoToTrans());
			vo.setDetachable(goodsordermjkVo.getDetachable());
			vo.setIfShow(goodsordermjkVo.getIfShow());
			vo.setPickupDate(goodsordermjkVo.getPickupDate());
			vo.setAppointTeamId(goodsordermjkVo.getAppointTeamId());
			vo.setAppointTeamName(goodsordermjkVo.getAppointTeamName());
			vo.setSendGroup(goodsordermjkVo.getSendGroup());
			//获取的用户信息
			vo.setPlatformId(goodsordermjkVo.getPlatformId());
			vo.setUserId(goodsordermjkVo.getUserId());
			vo.setUserName(goodsordermjkVo.getUserName());
			vo.setCompanyId(goodsordermjkVo.getCompanyId());
			vo.setCompanyName(goodsordermjkVo.getCompanyName());
			vo.setGroupId(goodsordermjkVo.getGroupId());
			vo.setGroupName(goodsordermjkVo.getGroupName());
			vo.setIfOwnerTaxpriceMf(goodsordermjkVo.getIfOwnerTaxpriceMf());
			// 代表电商
			vo.setFromType("DS");
			//vo.setCompanyMobile(company.getContactMobile());
			vo.setStatus("20");	
			if (null == vo.getBidTimes() || "".equals(vo.getBidTimes())) {
				// 投放单可出价次数
				vo.setBidTimes(1);
			}
			// 计算里程
			if (vo.getGetOrderPlateLng() !=null && vo.getGetOrderPlateLat()!=null
					&& vo.getEndPlateLng() !=null && vo.getEndPlateLat() !=null) {
				double startLng = Double.parseDouble(vo.getGetOrderPlateLng());
				double startLat = Double.parseDouble(vo.getGetOrderPlateLat());
				double endLng = Double.parseDouble(vo.getEndPlateLng());
				double endLat = Double.parseDouble(vo.getEndPlateLat());
				vo.setEstimateKM(new BigDecimal(LatLngGetDistance.getDistance(startLat, startLng, endLat,endLng)));	
			}
			if (StringUtils.isEmpty(vo.getIfTaxTransport()) || "N".equals(vo.getIfTaxTransport())) {
				// 不含税价、税率
				BigDecimal price = vo.getPrice();
				BigDecimal taxRate = new BigDecimal(StringFactory.getTaxRate());
				BigDecimal priceTax = price.add(price.multiply(taxRate));
				priceTax = priceTax.setScale(2, BigDecimal.ROUND_HALF_UP);  
				vo.setStandardTax(taxRate);
				vo.setPriceTax(priceTax);
				vo.setIfTaxTransport("N");
				vo.setVatFlowMasterId(Long.valueOf(0));
			} else {
				// 含税价、税率 
				setInfo(vo);
			}
			entity.setVatFlowMasterId(vo.getVatFlowMasterId());
			entity.setStandardTax(vo.getStandardTax());
			entity.setPriceTax(vo.getPriceTax());
			// 更新流程、价格、税率等信息
			GoodsordermjkEntity save = goodsordermjkRepository.save(entity);
			Assert.isTrue(null != save.getPinDanNum(),"拼单货源中有货源已被移除，拼单发布失败!");
			if (i == 0) {
				// 单据类型，1为双程单，0或空为单程单,2表示多单
				vo.setDocuType("2");
				// 单据主次，1为主单，2为次单
				vo.setDocuPriSec("1");
				// 合并单据数
				vo.setCombinedNumber(importIdArr.length);
				agree(vo);
				// 将第一个发布单号作为主单号
				publishId = vo.getPublishId();
				// 设置主单号
				GoodsordermEntity goodsordermEntity = goodsordermService.findById(publishId);
				goodsordermEntity.setPriPublishId(publishId);
				goodsordermService.save(goodsordermEntity);
			} else {
				vo.setDocuType("2");
				vo.setDocuPriSec("2");
				vo.setPriPublishId(publishId);
				vo.setCombinedNumber(importIdArr.length);
				// 查询货主运费单价/总价调整
				priceAdjust(vo);
				// 发布货源
				publish(vo);
				// 插入货源单运费调整明细
				insertPriceAdjustDetail(vo);
			}
			// TODO 消息推送(已经不用)
			//orderPush(vo);
		}
		
	}

	@Override
	public GoodsordermEntity checkIfTaxTransport(GoodsordermjkVo param) {
		logger.info("query GoodsordermEntity by importId:{}",param.getImportId());
		GoodsordermQueryVo queryVo = new GoodsordermQueryVo();
		queryVo.setPlatformId(param.getPlatformId());
		queryVo.setImportId(param.getImportId());

		return goodsordermService.queryEntity(queryVo);
	}

	@Override
	public CatalogInfoVo getCatalogId(GoodsordermjkQueryVo vo) {
		logger.info("query CatalogEntity by goodType:{}",vo.getGoodType());
		CatalogQueryVo queryVo = new CatalogQueryVo();
		queryVo.setPlatformId(vo.getPlatformId());
		queryVo.setGoodType(vo.getGoodType());
		return catalogService.getCatalogInfo(queryVo);
	}

	@Override
	@Transactional
	public void publishByBatch(GoodsordermjkVo vo) {
		logger.info("publish order(DianShang) by batch");	
		Assert.notNull(vo.getImportIdStr(),"参数不能为空！");
		String imports = vo.getImportIdStr();
		String[] importArr = imports.split(",");
		// 批量发布号
		String publishBatchId = getTimeMillisSequence();
		for (int i = 0; i < importArr.length; i++) {
			// 查询待发布的货源
			GoodsordermjkEntity queryEntity = goodsordermjkRepository.findById(Long.valueOf(importArr[i])).get();
			Assert.notNull(queryEntity,"找不到import_id为" + importArr[i] + "的货源。");
			queryEntity.setUserId(vo.getUserId());			
			queryEntity.setPickupDate(vo.getPickupDate());
			queryEntity.setCompanyId(vo.getCompanyId());			
			queryEntity.setAppointTeamId(vo.getAppointTeamId());
			queryEntity.setAppointPersonInfo(vo.getAppointTeamName());
			queryEntity.setPlatformId(vo.getPlatformId());
			queryEntity.setPublishBatchId(publishBatchId);
			queryEntity.setCompanyId(vo.getCompanyId());
			// 大品种查询
			CatalogQueryVo catalogQueryVo = new CatalogQueryVo(); 
			catalogQueryVo.setGoodType(queryEntity.getGoodType());
			catalogQueryVo.setGoodTypeDesc(queryEntity.getGoodTypeDesc());
			catalogQueryVo.setPlatformId(queryEntity.getPlatformId());
			catalogQueryVo.setStatus("20");
			catalogQueryVo.setLayer("1");
			CatalogInfoVo catalog = catalogService.queryCatalogIdAndName(catalogQueryVo);
			Assert.notNull(queryEntity,"单据号为："+queryEntity.getDependNum()+"的货物类型对应的大品种不存在，请先维护！");
			GoodsordermjkVo gVo = new GoodsordermjkVo();
			BeanUtils.copyProperties(queryEntity, gVo);
			gVo.setAppointTeamName(vo.getAppointTeamName());
			gVo.setCatalogId(catalog.getCatalogId());
			gVo.setCatalogName(catalog.getCatalogName());
			gVo.setUserName(vo.getUserName());			
			gVo.setPlatformId(vo.getPlatformId());
			gVo.setCompanyId(vo.getCompanyId());
			gVo.setFromType("DS");
			gVo.setStatus("20");
			gVo.setDocuType(null);
			
	        gVo.setSendGroup(vo.getSendGroup());
	        
			// 抹零
			gVo.setIfOwnerTaxpriceMf(vo.getIfOwnerTaxpriceMf());
			// 查询货主运费单价/总价调整
			priceAdjust(gVo);		
			//priceAdjust(vo);		
			publishBatch(gVo);		
			// 插入货源单运费调整明细
			insertPriceAdjustDetail(vo);
		}
	}

	// 电商批量发布
	private void publishBatch(GoodsordermjkVo vo) {
	CatalogQueryVo catalogQueryVo = new CatalogQueryVo(); 
	catalogQueryVo.setGoodType(vo.getGoodType());
	catalogQueryVo.setGoodTypeDesc(vo.getGoodTypeDesc());
	catalogQueryVo.setPlatformId(vo.getPlatformId());
	catalogQueryVo.setStatus("20");
	catalogQueryVo.setLayer("1");
	CatalogInfoVo catalog = catalogService.queryCatalogIdAndName(catalogQueryVo);
	Assert.notNull(catalog,"当前单据的货物类型对应的大品种不存在，请先维护!");
	vo.setCatalogId(catalog.getCatalogId());
	vo.setCatalogName(catalog.getCatalogName());
	
	GoodsordermjkEntity entity = goodsordermjkRepository.findById(vo.getImportId()).get();
	entity.setAppointTeamId(vo.getAppointTeamId());
	entity.setAppointPersonInfo(vo.getAppointTeamName());
	entity.setAppointTeamType(vo.getAppointTeamType());
	entity.setPickupDate(vo.getPickupDate());
	entity.setSendGroup(vo.getSendGroup());
	GoodsordermVo goodsordermVo = new GoodsordermVo();
	BeanUtils.copyProperties(entity, goodsordermVo);
	

	GoodsordermjkVo jkVo = new GoodsordermjkVo();
	BeanUtils.copyProperties(entity, jkVo);
	if(jkVo.getSendKM() == null){
		jkVo.setSendKM(10000);
	}
	jkVo.setFromType("DS");
	jkVo.setStatus("20");
	jkVo.setCatalogId(catalog.getCatalogId());
	jkVo.setCatalogName(catalog.getCatalogName());
	jkVo.setAppointTeamName(vo.getAppointTeamName());
	jkVo.setIfOwnerTaxpriceMf(vo.getIfOwnerTaxpriceMf());
	jkVo.setDocuType(null);
	
	if("DS".equals(vo.getFromType())) {
		// 电商只发一次,采购的只要单据还有发单量就可以继续发(initSpiltWeight不为零)
		Long findEntity = goodsordermjkRepository.findEntity(vo.getImportId());
		//只判断电商的单据
		Assert.isTrue(findEntity == 1,"该货源已发布或平台存在相同已生效的电商单据,请勿重复发布!");
	}
	
	setgoodsordermjkEntity(entity,goodsordermVo,jkVo);

	// 发布货源(保存到GoodsOrderM)
	GoodsordermEntity goodsordermEntity = goodsordermService.saveGoodsordermVo(goodsordermVo);
	// 设置主单号
	if(null == vo.getPriPublishId()) {
		// 非拼单时
		goodsordermEntity.setPriPublishId(goodsordermEntity.getPublishId());
		goodsordermService.save(goodsordermEntity);
	}
	// 货源发布编号
	vo.setPublishId(goodsordermEntity.getPublishId());
    // 可拆单发布(减去已发布的量)
	if("1".equals(vo.getSpiltType())){
      doSpiltPublish(entity,vo);
	}
	entity.setStatus(vo.getStatus());
	entity.setPublishId(vo.getPublishId());
	entity.setApproveTime(new Date());
	entity.setApproveUserId(vo.getUserId().toString());
	entity.setCatalogId(vo.getCatalogId());
	entity.setCatalogName(vo.getCatalogName());
	GoodsordermjkEntity resulEntity = goodsordermjkRepository.save(entity);
	Assert.notNull(resulEntity,"页面数据已过时，请刷新页面!");
	
}

	//作废方法
//	@Override
    @Transactional
	public void publishForU8ByBatchOld(GoodsordermjkVo vo) {
		logger.info("publish purchase order by batch");	
		Assert.notNull(vo.getImportIdStr(),"参数不能为空！");
		String imports = vo.getImportIdStr();
		String[] importArr = imports.split(",");
		// 批量发布号
		String publishBatchId = getTimeMillisSequence();
		for (int i = 0; i < importArr.length; i++) {
			// 查询待发布的货源
			GoodsordermjkEntity queryEntity = goodsordermjkRepository.findById(Long.valueOf(importArr[i])).get();
			Assert.notNull(queryEntity,"找不到import_id为" + importArr[i] + "的货源。");
			// 校验发布量
			BigDecimal remainWeight = queryEntity.getInitSpiltWeight().subtract(queryEntity.getWeight());
			BigDecimal initSpiltWeight = queryEntity.getInitSpiltWeight();
			if (remainWeight.compareTo(new BigDecimal("0")) == -1 || initSpiltWeight.compareTo(new BigDecimal("0")) == -1 
					|| initSpiltWeight.compareTo(new BigDecimal("0")) == 0) {
				throw new RuntimeException("可发布量为0或超过剩余发布量，请刷新页面重试");  
			} 
			// 减去本次的发布量(采购的量大，可多次发布，直到remainWeight量为0)
			queryEntity.setInitSpiltWeight(remainWeight);
			if (remainWeight.compareTo(new BigDecimal("0")) == 0) {
				queryEntity.setStatus("20");
			} else {
				queryEntity.setStatus("10");
			}		
			queryEntity.setUserId(vo.getUserId());			
			queryEntity.setCompanyId(vo.getCompanyId());			
			queryEntity.setPlatformId(vo.getPlatformId());
			queryEntity.setPublishBatchId(publishBatchId);
			queryEntity.setCompanyId(vo.getCompanyId());
			// 更新可发布数量
			GoodsordermjkEntity resulEntity = goodsordermjkRepository.save(queryEntity);
			Assert.notNull(resulEntity,"页面数据已过时，请刷新页面!");
			// 大品种查询
			CatalogQueryVo catalogQueryVo = new CatalogQueryVo(); 
			catalogQueryVo.setGoodType(queryEntity.getGoodType());
			catalogQueryVo.setGoodTypeDesc(queryEntity.getGoodTypeDesc());
			catalogQueryVo.setPlatformId(queryEntity.getPlatformId());
			catalogQueryVo.setStatus("20");
			catalogQueryVo.setLayer("1");
			CatalogInfoVo catalog = catalogService.queryCatalogIdAndName(catalogQueryVo);
			Assert.notNull(queryEntity,"找不到import_id为："+importArr[i]+"的货物类型对应的大品种不存在，请先维护！");
			GoodsordermjkVo gVo = new GoodsordermjkVo();
			BeanUtils.copyProperties(queryEntity, gVo);
			gVo.setCatalogId(catalog.getCatalogId());
			gVo.setCatalogName(catalog.getCatalogName());
			gVo.setUserName(vo.getUserName());
			gVo.setCompanyId(vo.getCompanyId());			
			gVo.setPlatformId(vo.getPlatformId());
			gVo.setCompanyId(vo.getCompanyId());
			gVo.setDocuType(null);
			if("1".equals(vo.getSpiltType())){
				gVo.setSendWeight(resulEntity.getWeight());
			}
			// 抹零
			gVo.setIfOwnerTaxpriceMf(vo.getIfOwnerTaxpriceMf());
			// 查询货主运费单价/总价调整
			priceAdjust(gVo);		
			publish(gVo);		
			// 插入货源单运费调整明细
			insertPriceAdjustDetail(vo);
		}		
	
	}

    @Override
    @Transactional
    //避免耦合采购单据
    public void publishForU8ByBatch(GoodsordermjkVo vo) {
        logger.info("publish purchase order by batch");
        Assert.notNull(vo.getImportIdStr(), "参数不能为空！");
        String imports = vo.getImportIdStr();
        String[] importArr = imports.split(",");
        // 批量发布号
        String publishBatchId = getTimeMillisSequence();
        for (int i = 0; i < importArr.length; i++) {
            GoodsordermjkVo goodsordermjkVo = new GoodsordermjkVo();
            goodsordermjkVo.setImportId(Long.valueOf(importArr[i]));
            goodsordermjkVo.setUserId(vo.getUserId());
            goodsordermjkVo.setUserName(vo.getUserName());
            goodsordermjkVo.setCompanyId(vo.getCompanyId());
            goodsordermjkVo.setIfOwnerTaxpriceMf(vo.getIfOwnerTaxpriceMf());
            goodsordermjkVo.setPlatformId(vo.getPlatformId());
            goodsordermjkVo.setPublishBatchId(publishBatchId);
            ;
            // 查询待发布的货源
            GoodsordermjkEntity queryEntity = goodsordermjkRepository.findById(Long.valueOf(importArr[i])).get();
            Assert.notNull(queryEntity, "找不到import_id为" + importArr[i] + "的货源。");
            // 大品种查询
            CatalogQueryVo catalogQueryVo = new CatalogQueryVo();
            catalogQueryVo.setGoodType(queryEntity.getGoodType());
            catalogQueryVo.setGoodTypeDesc(queryEntity.getGoodTypeDesc());
            catalogQueryVo.setPlatformId(queryEntity.getPlatformId());
            catalogQueryVo.setStatus("20");
            catalogQueryVo.setLayer("1");
            CatalogInfoVo catalog = catalogService.queryCatalogIdAndName(catalogQueryVo);
            Assert.notNull(queryEntity, "找不到import_id为：" + importArr[i] + "的货物类型对应的大品种不存在，请先维护！");
            goodsordermjkVo.setCatalogId(catalog.getCatalogId());
            goodsordermjkVo.setCatalogName(catalog.getCatalogName());
            goodsordermjkVo.setPrice(queryEntity.getPrice());
            goodsordermjkVo.setAmount(queryEntity.getAmount());
            goodsordermjkVo.setIfTaxTransport(queryEntity.getIfTaxTransport());
            priceAdjust(goodsordermjkVo);
            GoodsordermEntity goodsordermEntity = new GoodsordermEntity();
            GoodsordermVo goodsordermVo = new GoodsordermVo();
            setgoodsordermEntityByBatch(queryEntity, goodsordermVo, goodsordermjkVo);
            BeanUtils.copyProperties(goodsordermVo,goodsordermEntity);
            goodsordermEntity = goodsordermService.save(goodsordermEntity);
            goodsordermEntity.setPriPublishId(goodsordermEntity.getPublishId());
            goodsordermService.save(goodsordermEntity);
            queryEntity.setPublishId(goodsordermEntity.getPublishId());
            goodsordermjkVo.setPublishId(goodsordermEntity.getPublishId());
            insertPriceAdjustDetail(goodsordermjkVo);
            // 校验发布量
            BigDecimal remainWeight = queryEntity.getInitSpiltWeight().subtract(queryEntity.getWeight());
            BigDecimal initSpiltWeight = queryEntity.getInitSpiltWeight();
            if (remainWeight.compareTo(new BigDecimal("0")) == -1 || initSpiltWeight.compareTo(new BigDecimal("0")) == -1
                    || initSpiltWeight.compareTo(new BigDecimal("0")) == 0) {
                throw new RuntimeException("可发布量为0或超过剩余发布量，请刷新页面重试");
            }
            // 减去本次的发布量(采购的量大，可多次发布，直到remainWeight量为0)
            queryEntity.setInitSpiltWeight(remainWeight);
            if (remainWeight.compareTo(new BigDecimal("0")) == 0) {
                queryEntity.setStatus("20");
            } else {
                queryEntity.setStatus("10");
            }
            queryEntity.setApproveTime(new Date());
            queryEntity.setApproveUserId(goodsordermjkVo.getUserId().toString());
            queryEntity.setPublishBatchId(publishBatchId);
            if (goodsordermjkVo.getCatalogId() != null) {
                queryEntity.setCatalogId(goodsordermjkVo.getCatalogId());
            }
            if (StringUtils.isNotEmpty(goodsordermjkVo.getCatalogName())) {
                queryEntity.setCatalogName(goodsordermjkVo.getCatalogName());
            }
            GoodsordermjkEntity resulEntity = goodsordermjkRepository.save(queryEntity);
        }

    }


        public static String getTimeMillisSequence () {
            long nanoTime = System.nanoTime();
            if (nanoTime < 0) {
                nanoTime = nanoTime + Long.MAX_VALUE + 1;
            }
            String nanoTimeStr = String.valueOf(nanoTime);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                char c = nanoTimeStr.charAt(i);
                sb.append(c);
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss"); //24小时制
            String timeMillisSequence = sdf.format(System.currentTimeMillis()) + sb.toString();

            return timeMillisSequence;
        }

        @Override
        public GoodsordermjkEntity findByPublishIdAndPlatformId (Long publishId, String platformId){
            logger.info("query goodordermjk info,publishId:{},platformId", publishId, platformId);
            GoodsordermjkEntity goodsordermjk = goodsordermjkRepository.findByPublishIdAndPlatformId(publishId, platformId);
            return goodsordermjk;
        }

        @Override
        @Transactional
        public void updateOnOff (GoodsordermjkVo vo){
            logger.info("update order's field named if_on_off, by importId:{}", vo.getImportId());
            GoodsordermjkEntity entity = goodsordermjkRepository.findById(vo.getImportId()).get();
            switch (entity.getStatus()) {
                case "00":
                    Assert.isTrue(false, "该单据已作废,无法操作！");
                    break;
                case "20":
                    Assert.isTrue(false, "该单据已生效,无法操作！");
                    break;
                case "30":
                    Assert.isTrue(false, "该单据在待拼单状态,无法操作！");
                    break;
                case "40":
                    Assert.isTrue(false, "该单据已拼单,无法操作！");
                    break;
                default:
                    entity.setIfOnOff(vo.getIfOnOff());
                    entity.setUpdateDate(new Date());
                    entity.setUpdatePersonId(vo.getUserId().toString());
                    goodsordermjkRepository.save(entity);
                    break;
            }

        }

        @Override
        public void updateStatusJk (Long publishId, String platformId){
            goodsordermjkRepository.updateStatusJk(publishId, platformId);
        }

        @Override
        public void updateGoodInfo (BigDecimal goodWeight, Long importId){
            goodsordermjkRepository.updateGoodInfo(goodWeight, importId);
        }

        @Override
        @Transactional
        public void orderPush (GoodsordermjkVo vo){

            String batchId = goodsordermjkRepository.queryNotifyRecordBatchId();
            String message = "";
            if ("DSFB".equals(vo.getMessageType())) {
                message = "" + vo.getStartPlate() + "到" + vo.getEndPlate() + "（" + vo.getGoodTypeDesc() + "," + vo.getWeight() + " 吨）。"
                        + "更多货源请登入:http://www.wbtech.com";
            } else {
                message = "" + vo.getStartPlateProvince() + vo.getStartPlateCity() + vo.getStartPlate() + "到" + vo.getEndPlateProvince() + vo.getEndPlateCity() + vo.getEndPlate() + "(" + vo.getGoodTypeDesc() + "," + vo.getWeight() + " 吨）。"
                        + "更多货源请登入:http://www.wbtech.com";
            }
            List<TeamCompanyVo> list = goodsordermjkRepository.queryPushUser(vo.getPlatformId(), vo.getAppointTeamId());
            List<NotifyrecordEntity> notifyrecordList = new ArrayList<>();
            if (list.size() > 0) {
                for (TeamCompanyVo teamCompanyVo : list) {
                    NotifyrecordEntity notifyrecordEntity = new NotifyrecordEntity();
                    notifyrecordEntity.setUserId(teamCompanyVo.getUserId());
                    notifyrecordEntity.setClientId(teamCompanyVo.getClientId());
                    notifyrecordEntity.setPlatFormId(vo.getPlatformId());
                    notifyrecordEntity.setMessage(message);
                    notifyrecordEntity.setBatchId(Long.valueOf(batchId));
                    notifyrecordEntity.setCreateTime(new Date());
                    notifyrecordList.add(notifyrecordEntity);
                }
                notifyrecordService.saveList(notifyrecordList);
            }

        }

//采购批量发布将外部接口采购单据属性插入到货源单中
        private void setgoodsordermEntityByBatch(GoodsordermjkEntity entity, GoodsordermVo goodsordermVo, GoodsordermjkVo vo){
            goodsordermVo.setWeight(entity.getWeight());
            goodsordermVo.setQty(entity.getQty());
            // 总价
            goodsordermVo.setAmount(entity.getAmount());
            //货源单为有效状态
            goodsordermVo.setStatus("20");
            goodsordermVo.setPlatformId(vo.getPlatformId());
            goodsordermVo.setCreateDate(new Date());
            goodsordermVo.setLimitTime(entity.getLimitTime());
            goodsordermVo.setRemark(entity.getRemark());
            //电商采购的单据号 (电商采购的单据都是使用ret_2作为单据号)
            goodsordermVo.setDependNum(entity.getRet2());
            goodsordermVo.setPrice(entity.getPrice());
            goodsordermVo.setPriceTax(entity.getPriceTax());
            goodsordermVo.setUserId(vo.getUserId());
            goodsordermVo.setStartPlate(entity.getStartPlate());
            goodsordermVo.setEndPlate(entity.getEndPlate());
            goodsordermVo.setGetOrderPlate(entity.getGetOrderPlate());
            String startPlate = entity.getStartPlate() == null ? "" : entity.getStartPlate();
            String startPlateLng = entity.getStartPlateLng() == null ? "" : entity.getStartPlateLng();
            String startPlateLat = entity.getStartPlateLat() == null ? "" : entity.getStartPlateLat();
            goodsordermVo.setDeparture("{\"address\":\"" + startPlate + "\",\"lngLat\":{\"lng\":" + startPlateLng + ",\"lat\":" + startPlateLat + "}}");
            goodsordermVo.setDepartureLng(new BigDecimal(entity.getStartPlateLng()));
            goodsordermVo.setDepartureLat(new BigDecimal(entity.getStartPlateLat()));

            String endPlate = entity.getEndPlate() == null ? "" : entity.getEndPlate();
            String endPlateLng = entity.getEndPlateLng() == null ? "" : entity.getEndPlateLng();
            String endPlateLat = entity.getEndPlateLat() == null ? "" : entity.getEndPlateLat();
            goodsordermVo.setDestination("{\"address\":\"" + endPlate + "\",\"lngLat\":{\"lng\":" + endPlateLng + ",\"lat\":" + endPlateLat + "}}");
            goodsordermVo.setDestinationLng(new BigDecimal(entity.getEndPlateLng()));
            goodsordermVo.setDestinationLat(new BigDecimal(entity.getEndPlateLat()));
            // 取单地
            String getOrderPlate = entity.getGetOrderPlate() == null ? "" : entity.getGetOrderPlate();
            String getOrderPlateLng = entity.getGetOrderPlateLng() == null ? "" : entity.getGetOrderPlateLng();
            String getOrderPlateLat = entity.getGetOrderPlateLat() == null ? "" : entity.getGetOrderPlateLat();
            goodsordermVo.setGetOrderAddress("{\"address\":\"" + getOrderPlate + "\",\"lngLat\":{\"lng\":" + getOrderPlateLng + ",\"lat\":" + getOrderPlateLat + "}}");
            goodsordermVo.setGetOrderAddressLng(new BigDecimal(entity.getGetOrderPlateLng()));
            goodsordermVo.setGetOrderAddressLat(new BigDecimal(entity.getGetOrderPlateLat()));
            goodsordermVo.setSendKM(1000);
            goodsordermVo.setSender(entity.getSender());
            goodsordermVo.setSenderMobile(entity.getSenderMobile());
            goodsordermVo.setReceiverMobile(entity.getReceiverMobile());
            goodsordermVo.setReceiver(entity.getReceiver());
            goodsordermVo.setGoodType(entity.getGoodType());
            goodsordermVo.setGoodTypeDesc(entity.getGoodTypeDesc());
            goodsordermVo.setBillSender(entity.getBillSender());
            goodsordermVo.setBillSenderMobile(entity.getBillSenderMobile());
            goodsordermVo.setBillTaker(entity.getBillTaker());
            goodsordermVo.setBillTakerMobile(entity.getBillTakerMobile());
            goodsordermVo.setDetachable(entity.getDetachable());
            goodsordermVo.setHeavyPiece(new BigDecimal(entity.getHeavyPiece()));
            goodsordermVo.setPickupDate(entity.getPickupDate());
            goodsordermVo.setInitWeight(entity.getWeight());
            goodsordermVo.setInitQty(entity.getQty());
            goodsordermVo.setInitAmount(entity.getAmount());
            goodsordermVo.setDependNum2(entity.getDependNum2());
            goodsordermVo.setCompanyId(vo.getCompanyId());
            goodsordermVo.setSendGroup(entity.getSendGroup());
            goodsordermVo.setMaxPrice(entity.getMaxPrice());
            goodsordermVo.setQbType("0");
            goodsordermVo.setFloorPrice(entity.getPrice());
            goodsordermVo.setAppointTeamId(entity.getAppointTeamId());
            goodsordermVo.setBidTimes(1);
            goodsordermVo.setAppointTeamType(entity.getAppointTeamType());
            goodsordermVo.setFromType(entity.getFromType());
            goodsordermVo.setProdDesc(entity.getProdDesc());
            goodsordermVo.setIsAutoToTrans("0");
            goodsordermVo.setPs(entity.getRemark());
            goodsordermVo.setEstimateKM(entity.getEstimateKM());
            goodsordermVo.setWebCanGrab("Y");
            goodsordermVo.setPs1(entity.getPs1());
            goodsordermVo.setPs2(entity.getPs2());
            goodsordermVo.setPs3(entity.getPs3());
            goodsordermVo.setPs4(entity.getPs4());
            goodsordermVo.setPs5(entity.getPs5());
            goodsordermVo.setVehicleStyleVar(entity.getVehicleStyleVar());
            goodsordermVo.setFdUserId(entity.getFdUserId());
            goodsordermVo.setIfCanShow(entity.getIfCanShow());
            goodsordermVo.setImportId(entity.getImportId());
            goodsordermVo.setAppointPersonInfo(entity.getAppointPersonInfo());
            goodsordermVo.setStartPlateProvince(entity.getStartPlateProvince());
            goodsordermVo.setStartPlateCity(entity.getStartPlateCity());
            goodsordermVo.setGetOrderPlateProvince(entity.getGetOrderPlateProvince());
            goodsordermVo.setGetOrderPlateCity(entity.getGetOrderPlateCity());
            goodsordermVo.setEndPlateProvince(entity.getEndPlateProvince());
            goodsordermVo.setEndPlateCity(entity.getEndPlateCity());
            goodsordermVo.setJsType(entity.getJsType());
            goodsordermVo.setDsIfSettle(entity.getDsIfSettle());
            goodsordermVo.setIsAutoDisplay(entity.getIsAutoDisplay());
            goodsordermVo.setProdArea(entity.getProdArea());
            goodsordermVo.setSingleCarWeight(entity.getSingleCarWeight());
            goodsordermVo.setLossType(entity.getLossType());
            goodsordermVo.setLossRatio(entity.getLossRatio());
            goodsordermVo.setLossWeight(entity.getLossWeight());
            goodsordermVo.setStandardTax(entity.getStandardTax());
            goodsordermVo.setIfTaxTransport(entity.getIfTaxTransport());
            goodsordermVo.setIfPayment(entity.getIfPayment());
            goodsordermVo.setVatFlowMasterId(entity.getVatFlowMasterId());
            goodsordermVo.setListingPrice(entity.getListingPrice());
            goodsordermVo.setChargePrice(entity.getChargePrice());
            goodsordermVo.setChargePriceType(entity.getChargePriceType());
            goodsordermVo.setLogisticsMark(entity.getLogisticsMark());
            goodsordermVo.setStartPlateCountry(entity.getStartPlateCountry());
            goodsordermVo.setGetOrderPlateCountry(entity.getGetOrderPlateCountry());
            goodsordermVo.setEndPlateCountry(entity.getEndPlateCountry());
            goodsordermVo.setFromPlatName(entity.getRet1());
            goodsordermVo.setGroupId(entity.getGroupId());
            goodsordermVo.setGroupName(entity.getGroupName());
            goodsordermVo.setOwnerAdjustFlag(vo.getOwnerAdjustFlag() == null ? "N" : vo.getOwnerAdjustFlag());
            goodsordermVo.setOwnerAdjustType(vo.getOwnerAdjustType() == null ? "01" : vo.getOwnerAdjustType());
            goodsordermVo.setOwnerAdjustAmt(vo.getOwnerAdjustAmt() == null ? new BigDecimal(0) : vo.getOwnerAdjustAmt());
            if (null != vo.getCatalogId()) {
                goodsordermVo.setCatalogId(vo.getCatalogId());
            }
            if (StringUtils.isNotEmpty(vo.getCatalogName())) {
                goodsordermVo.setCatalogName(vo.getCatalogName());
            }
            // 1代表含税单价抹分,四舍五入;0代表不处理
            if (StringUtils.isNotEmpty(vo.getIfOwnerTaxpriceMf())) {
                goodsordermVo.setIfOwnerTaxpriceMf(vo.getIfOwnerTaxpriceMf());
            }
        }

		@Override
		public void saveCompleteInfoByBatch(GoodsordermjkVo vo) {
			logger.info("save the queryGoodOrderMJK information by batch,where importIdStr:{}",vo.getImportIdStr());
			String[] importIdArr  = vo.getImportIdStr().split(",");
			for (String importId : importIdArr) {
				vo.setImportId(Long.valueOf(importId));
				if (vo.getIfTaxTransport() == null || "N".equals(vo.getIfTaxTransport())
		                || "".equals(vo.getIfTaxTransport())) {
		            /**不含税运输*/
		            BigDecimal standardTax = new BigDecimal(StringFactory.getTaxRate());
		            BigDecimal priceTax = vo.getPrice().add(vo.getPrice().multiply(standardTax));
		            priceTax = priceTax.setScale(2, BigDecimal.ROUND_HALF_UP);
		            vo.setStandardTax(standardTax);
		            vo.setPriceTax(priceTax);
		            vo.setIfTaxTransport("N");
		            vo.setVatFlowMasterId(Long.valueOf(0));
		        }else{
		            /**含税运输,查找流程获得价格、税率等信息*/
		            setInfo(vo);
		        }
		        GoodsordermjkEntity entity = goodsordermjkRepository.findById(vo.getImportId()).get();
		        Assert.notNull(entity,"该电商单据不存在，请刷新页面重试！");
		        Assert.isTrue(!"20".equals(entity.getStatus()),"该电商单据的状态已发生改变！");
		        saveInfo(vo, entity);
			}	
		}

    @Override
    @Transactional
    public void saveContractNumber (GoodsordermjkVo vo){
//        int num = goodsordermjkRepository.checkDiaoDD(vo.getPlatformId(),vo.getImportId());
//        Assert.isTrue(num<=0, "货源单已发布，不能维护合同号");
        //goodsordermjkRepository.saveContractNumber(vo.getPlatformId(),vo.getImportId(),vo.getContractNumber());
        goodsordermjkRepository.saveContractNumber1(vo.getPlatformId(),vo.getImportId(),vo.getContractNumber(),vo.getContractType());
        //goodsordermjkRepository.saveContractNumber2(vo.getPlatformId(),vo.getImportId(),vo.getContractNumber());
    }

    @Override
    public void delete(GoodsordermjkEntity goodsordermjkEntity) {
        goodsordermjkRepository.delete(goodsordermjkEntity);
    }

	@Override
	public GoodsordermjkEntity findByRet2AndRet1(String ret2, String ret1) {
		
		return goodsordermjkRepository.findByRet2AndRet1(ret2, ret1);
	}

}

