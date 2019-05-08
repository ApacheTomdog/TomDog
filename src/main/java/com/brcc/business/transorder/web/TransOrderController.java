package com.brcc.business.transorder.web;

import com.brcc.business.company.service.CompanyService;
import com.brcc.business.company.vo.CompanySearchVo;
import com.brcc.business.company.vo.CompanyVo;
import com.brcc.business.dispatchorder.entity.DriverEntity;
import com.brcc.business.dispatchorder.service.DriverService;
import com.brcc.business.dispatchorder.vo.DriverVo;
import com.brcc.business.jkparaminfo.entity.JkparaminfoEntity;
import com.brcc.business.jkparaminfo.service.JkparaminfoService;
import com.brcc.business.transorder.entity.BrokerPeopleConfigEntity;
import com.brcc.business.transorder.entity.LoginverifyEntity;
import com.brcc.business.transorder.entity.TransportationdeliveryEntity;
import com.brcc.business.transorder.entity.TransportationmEntity;
import com.brcc.business.transorder.service.*;
import com.brcc.business.transorder.vo.CarInfo;
import com.brcc.business.transorder.vo.TransOrderSearchVo;
import com.brcc.business.transorder.vo.TransOrderVo;
import com.brcc.business.transorder.vo.VehicleVo;
import com.brcc.business.util.HttpUtils;
import com.brcc.business.util.JSON;
import com.esteel.common.controller.WebReturnMessage;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 描述:
 * 平台运输订单
 *
 * @author yushaohua
 * @create 2018-10-31 14:47
 */
@RestController
@RequestMapping("/business/transOrder/")
public class TransOrderController {

    Logger logger = LoggerFactory.getLogger(TransOrderController.class);

    @Autowired
    private TransOrderService transOrderService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private BrokerPeopleConfigService brokerPeopleConfigService;

    @Autowired
    private DriverService driverService;

    @Autowired
    private LoginVerifyService loginVerifyService;

    @Autowired
    private TransOrderDispatchDetailService transOrderDispatchDetailService;

    @Autowired
    private JkparaminfoService jkparaminfoService;

    /**
     * 分页列表数据
     * @param vo 查询封装的接收类
     * @return
     */
    @RequestMapping(value = "/pageData", method = RequestMethod.POST)
    public Page<TransOrderVo> pageData(@RequestBody TransOrderSearchVo vo){
        logger.info("Query trans order pagination page");

        return transOrderService.pageData(vo);
    }

    @RequestMapping(value = "/listData", method = RequestMethod.POST)
    public List<TransOrderVo> findAll(@RequestBody TransOrderSearchVo vo){
        logger.info("Query trans order list data");
        return transOrderService.findAll(vo);
    }

    /**
     * 货主运输单分页列表数据
     * @param vo 查询封装的接收类
     * @return
     */
    @RequestMapping(value = "/publisherPageData", method = RequestMethod.POST)
    public Page<TransOrderVo> publisherPageData(@RequestBody TransOrderSearchVo vo){
        logger.info("Query trans order pagination page");

        return transOrderService.findPublisherAllPage(vo);
    }

    /**
     * 货主运输单分页列表数据
     * @param vo 查询封装的接收类
     * @return
     */
    @RequestMapping(value = "/publisherListData", method = RequestMethod.POST)
    public List<TransOrderVo> publisherListData(@RequestBody TransOrderSearchVo vo){
        logger.info("Query trans order pagination page");

        return transOrderService.findPublisherListData(vo);
    }

    /**
     * 委托承运运输订单分页列表数据
     * @param vo 查询封装的接收类
     * @return
     */
    @RequestMapping(value = "/taxPageData", method = RequestMethod.POST)
    public Page<TransOrderVo> taxTransportationmPageData(@RequestBody TransOrderSearchVo vo){
        logger.info("Query trans order pagination page");

        return transOrderService.findTaxTransportationmPage(vo);
    }

    /**
     * 委托承运运输订单分页列表数据
     * @param vo 查询封装的接收类
     * @return
     */
    @RequestMapping(value = "/taxList", method = RequestMethod.POST)
    public List<TransOrderVo> taxTransportationmList(@RequestBody TransOrderSearchVo vo){
        logger.info("Query trans order pagination page");

        return transOrderService.findTaxTransportationmList(vo);
    }

    /**
     * 更新运输单状态
     * @param vo
     * @return
     */
    @RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
    public WebReturnMessage updateStatus(@RequestBody TransOrderSearchVo vo){
        transOrderService.updateStatus(vo);

        return WebReturnMessage.sucess;
    }

    /**
     * 获取飞单对象
     * @param vo 查询封装的接收类
     * @return
     */
    @RequestMapping(value = "/personTeam", method = RequestMethod.POST)
    public Page<CompanyVo> findPersonTeam(@RequestBody CompanySearchVo vo){
        logger.info("Query trans order pagination page");

        return companyService.findPersonTeam(vo);
    }

    /**
     * 获取飞单对象
     * @param vo 查询封装的接收类
     * @return
     */
    @RequestMapping(value = "/doFlyOrder", method = RequestMethod.POST)
    public WebReturnMessage doFlyOrder(@RequestBody TransOrderSearchVo vo){
        logger.info("Query trans order pagination page");

        transOrderService.flyOrder(vo);
        return WebReturnMessage.sucess;
    }

    /**
     * 验证调度单状态
     * @param vo
     * @return
     */
    @RequestMapping(value = "/verifyDelivery", method = RequestMethod.POST)
    public TransportationmEntity verifyDelivery(@RequestBody TransOrderSearchVo vo){
        return transOrderService.verifyDelivery(vo);
    }

    /**
     * 修改运费
     * @param vo
     * @return
     */
    @RequestMapping(value = "/modifyPrice", method = RequestMethod.POST)
    public WebReturnMessage modifyPrice(@RequestBody TransOrderSearchVo vo){
        transOrderService.modifyPrice(vo);
        return WebReturnMessage.sucess;
    }

    /**
     * 车辆信息
     * @param vo
     * @return
     */
    @RequestMapping(value = "/vehicleInfo", method = RequestMethod.POST)
    public Page<VehicleVo> queryVehicleId(@RequestBody TransOrderSearchVo vo){
       return vehicleService.queryVehicleId(vo);
    }

    /**
     * 驾驶员信息
     * @param vo
     * @return
     */
    @RequestMapping(value = "/driverInfo", method = RequestMethod.POST)
    public Page<DriverVo> queryDriverInfo(@RequestBody TransOrderSearchVo vo){
         return driverService.findDriverInfo(vo);
    }

    /**
     * 经纪人信息
     * @param vo
     * @return
     */
    @RequestMapping(value = "/brokerInfo", method = RequestMethod.POST)
    public BrokerPeopleConfigEntity queryBrokerInfo(@RequestBody TransOrderSearchVo vo){
        return brokerPeopleConfigService.queryUse(vo);
    }

    /**
     * 承运人审核记录
     * @param vo
     * @return
     */
    @RequestMapping(value = "/checkCYRStatus", method = RequestMethod.POST)
    public List<LoginverifyEntity> checkCYRStatus(@RequestBody TransOrderSearchVo vo){
        return loginVerifyService.checkCYRStatus(vo.getDriverId(), vo.getPlatformId());
    }

    /**
     * 承运车辆审核记录
     * @param vo
     * @return
     */
    @RequestMapping(value = "/checkCYRVehicleStatus", method = RequestMethod.POST)
    public Long checkCYRVehicleStatus(@RequestBody TransOrderSearchVo vo){
        return loginVerifyService.checkCYRVehicleStatus(vo.getVehicleId(), vo.getPlatformId());
    }

    /**
     * 未完成订单查询
     * @param vo
     * @return
     */
    @RequestMapping(value = "/noCompleteCount", method = RequestMethod.POST)
    public List<TransportationdeliveryEntity> noCompleteCount(@RequestBody TransOrderSearchVo vo){
        return transOrderDispatchDetailService.noCompleteCount(vo.getPlatformId(), vo.getDriverId(),
                vo.getTransId() == null ? null :  Long.parseLong(vo.getTransId()));
    }

    /**
     * 运单调度
     * @param vo
     * @return
     */
    @RequestMapping(value = "/doDispatch", method = RequestMethod.POST)
    public WebReturnMessage dispatch(@RequestBody TransOrderSearchVo vo){
        DriverEntity driverEntity = driverService.findById(vo.getDriverId());
        vo.setDriverName(driverEntity.getName());
        vo.setDriverPhone(driverEntity.getPhone());
        String msg = transOrderService.dispatch(vo);
        return new WebReturnMessage(true, msg);
    }


    /**
     * 根据运单号查询运单数据
     * @param transIdStr
     */
    @RequestMapping(value = "/getTransorderList", method = RequestMethod.POST)
    public List<TransportationmEntity> getTransorderList(@RequestBody String transIdStr){
        logger.info("Query trans order list data by transId string");
        return transOrderService.getTransorderList(transIdStr);
    }


    /**
     * 运单拼单调度
     * @param vo
     * @return
     */
    @RequestMapping(value = "/pindanDispatch", method = RequestMethod.POST)
    public WebReturnMessage pindanDispatch(@RequestBody TransOrderSearchVo vo){
        try {
            DriverEntity driverEntity = driverService.findById(vo.getDriverId());
            vo.setDriverName(driverEntity.getName());
            vo.setDriverPhone(driverEntity.getPhone());
            String msg = transOrderService.pindanDispatch(vo);
            if("操作成功".equals(msg)){
                return new WebReturnMessage(true, msg);
            }else{
                return new WebReturnMessage(false, msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new WebReturnMessage(false, e.getMessage());
        }
    }

    /**
     * 车辆信息(川威)
     * @param vo
     * @return
     */
    @RequestMapping(value = "/cwVehicleInfo", method = RequestMethod.POST)
    public Page<VehicleVo> cwVehicleInfo(@RequestBody TransOrderSearchVo vo){
        JkparaminfoEntity jkparaminfoEntity = jkparaminfoService.findById(28l);
        String url = jkparaminfoEntity.getUrl();
        /**检验车辆是否可调度（川威）*/
        List<CarInfo> vehicleNumList = getvehicleInfo(url, vo.getInterCode());
        vo.setCarInfoList(vehicleNumList);
        return vehicleService.queryVehicleId(vo);
    }

    /**
     * 获取车辆信息(调用川威接口)
     */
    List<CarInfo> getvehicleInfo(String url, String interCode){
        HttpUtils utils = new HttpUtils();
        //String url = "http://182.151.214.208:8072/api/getCarsInformation";
        try {
            HashMap<String, Object> map = new HashMap<>();

            List dataInfo = new ArrayList();
            HashMap<String, Object> dataInfoMap = new HashMap<>();
            dataInfoMap.put("appointCompanyCode", interCode);
            dataInfo.add(dataInfoMap);

            map.put("dataInfo", dataInfo);

            JSONObject jsonObject = new JSONObject(map);

            String result = utils.postJson(url, jsonObject.toString());

            JSONObject outResultData = new JSONObject(result);
            List<CarInfo> carInfoList = JSON.parseArray(outResultData.getString("outResultData"),CarInfo.class);
            return carInfoList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}