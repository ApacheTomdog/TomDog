package com.brcc.business.commonaddress.repository;
import org.springframework.data.domain.Page;

import com.brcc.business.commonaddress.entity.CommonaddressEntity;
import com.brcc.business.commonaddress.vo.CommonaddressQueryVo;


/**
 * @Description:常用路线数据扩展接口
 * @author: TangYong
 * @Date: 2018-11-15
 */
public interface ICommonaddressRepository {
	 /**
     * 查询外部接口电商货源分页信息
     * @param vo
     * @return Page<GoodsordermjkVo>
     */
	Page<CommonaddressEntity> addressList(CommonaddressQueryVo vo);
      
}
