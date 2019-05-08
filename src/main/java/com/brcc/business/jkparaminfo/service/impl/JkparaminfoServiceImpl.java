package com.brcc.business.jkparaminfo.service.impl;

import com.brcc.business.jkparaminfo.entity.JkparaminfoEntity;
import com.brcc.business.jkparaminfo.repository.JkparaminfoRepository;
import com.brcc.business.jkparaminfo.service.JkparaminfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JkparaminfoServiceImpl implements JkparaminfoService {

    Logger logger = LoggerFactory.getLogger(JkparaminfoServiceImpl.class);

    @Autowired
    JkparaminfoRepository jkparaminfoRepository;

    public JkparaminfoEntity findById(Long id){
        return jkparaminfoRepository.findById(id).get();
    }
}
