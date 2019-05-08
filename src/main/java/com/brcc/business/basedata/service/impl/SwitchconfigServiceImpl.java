package com.brcc.business.basedata.service.impl;

import com.brcc.business.basedata.entity.SwitchconfigEntity;
import com.brcc.business.basedata.repository.SwitchconfigRepository;
import com.brcc.business.basedata.service.SwitchconfigService;
import com.brcc.business.basedata.vo.SwitchconfigQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SwitchconfigServiceImpl implements SwitchconfigService {

    @Autowired
    SwitchconfigRepository switchconfigRepository;

    @Override
    public List<SwitchconfigEntity> queryList(SwitchconfigQueryVo vo) {
        List<SwitchconfigEntity> list=switchconfigRepository.queryList(vo);
        if(list == null)
            list = new ArrayList();
        return list;
    }
}
