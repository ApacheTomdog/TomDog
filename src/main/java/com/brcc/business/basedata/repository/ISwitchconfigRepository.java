package com.brcc.business.basedata.repository;

import com.brcc.business.basedata.entity.SwitchconfigEntity;
import com.brcc.business.basedata.vo.SwitchconfigQueryVo;

import java.util.List;

public interface ISwitchconfigRepository {
    List<SwitchconfigEntity> queryList(SwitchconfigQueryVo vo);
}
