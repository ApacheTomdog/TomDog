package com.brcc.business.basedata.service;

import com.brcc.business.basedata.entity.SwitchconfigEntity;
import com.brcc.business.basedata.vo.SwitchconfigQueryVo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SwitchconfigService {
    List<SwitchconfigEntity> queryList(SwitchconfigQueryVo vo);
}
