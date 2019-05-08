package com.brcc.business.Interface.InterfaceOfCw.web;

import com.brcc.business.Interface.InterfaceOfCw.entity.DsReceiveLogEntity;
import com.brcc.business.Interface.InterfaceOfCw.service.DsReciveLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/business/ds")
public class DsReciveLogController {
    private static final Logger logger = LoggerFactory.getLogger(CwEcController.class);
    @Autowired
    private DsReciveLogService dsReciveLogService;

    @PostMapping("/log")
    @ResponseBody
    public Long record(@RequestBody DsReceiveLogEntity dsReceiveLogEntity){
        logger.info("ds record in "+dsReceiveLogEntity);
       return dsReciveLogService.record(dsReceiveLogEntity);
    }
}
