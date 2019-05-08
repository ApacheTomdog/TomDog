package com.brcc.business.ordercancel.repository;

import com.brcc.business.ordercancel.entity.DeliverycancelauditEntity;
import com.brcc.business.ordercancel.vo.OrderCancelSearchVo;
import com.brcc.business.ordercancel.vo.OrderCancelVo;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 撤单审核数据接口实现类
 *
 * @author yushaohua
 * @create 2018-11-06 22:19
 */
public interface IOrderCancelRepository {

    /**
     * 调用存储过程
     * @return
     */
    Map<String, Object> cancelDeliveryPro(Long deliveryCancelId);

    /**
     * 调用存储过程
     * @param deliveryCancelId
     * @return
     */
    Map<String, Object> blackListCheck(Long deliveryCancelId);

    /**
     * 分页查询撤单审核数据
     * @param vo
     * @return
     */
    Page<OrderCancelVo> findAllPage(OrderCancelSearchVo vo);

    /**
     * 分页查询撤单审核数据(货主级)
     * @param vo
     * @return
     */
    Page<OrderCancelVo> findAllPublisherPage(OrderCancelSearchVo vo);

    /**
     * 分页查询撤单审核数据(货主级)
     * @param vo
     * @return
     */
    List<OrderCancelVo> findAllPublisherList(OrderCancelSearchVo vo);

    /**
     * 分页查询撤单审核数据
     * @param vo
     * @return
     */
    List<OrderCancelVo> findAll(OrderCancelSearchVo vo);

    /**
     * 保存记录
     * @param paramMap
     */
    void saveOrderCancel(Map<String, Object> paramMap);
}