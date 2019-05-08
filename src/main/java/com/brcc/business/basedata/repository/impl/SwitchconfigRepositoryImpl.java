package com.brcc.business.basedata.repository.impl;

import com.brcc.business.basedata.entity.SwitchconfigEntity;
import com.brcc.business.basedata.repository.ISwitchconfigRepository;
import com.brcc.business.basedata.vo.SwitchconfigQueryVo;
import com.esteel.common.dao.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

public class SwitchconfigRepositoryImpl implements ISwitchconfigRepository {

    @Autowired
    PageQuery pageQuery;

    @Override
    public List<SwitchconfigEntity> queryList(SwitchconfigQueryVo vo) {
        StringBuffer sql = new StringBuffer();
        List<Object> args = new ArrayList<>();
        sql.append(" SELECT ");
        sql.append(" a.plat_form_id  'platformId', ");
        sql.append(" a.param_value1 'paramValue1', ");
        sql.append(" a.param_value2 'paramValue2', ");
        sql.append(" a.param_value3 'paramValue3', ");
        sql.append(" a.param_value4 'paramValue4', ");
        sql.append(" a.switch_value 'switchValue' ");
        sql.append(" from SwitchConfig a ");
        sql.append(" where a.switch_type = ? ");
        sql.append(" and a.switch_value = '1' ");
        args.add(vo.getSwitchType());

        if (!ObjectUtils.isEmpty(vo.getParamValue4())) {
            sql.append(" and a.param_value4 = ? ");
            args.add(vo.getParamValue4());
        }

        return pageQuery.list(sql.toString(), args, SwitchconfigEntity.class);
    }
}
