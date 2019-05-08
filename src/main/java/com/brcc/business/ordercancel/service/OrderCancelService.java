package com.brcc.business.ordercancel.service;

import com.brcc.business.ordercancel.entity.DeliverycancelauditEntity;
import com.brcc.business.ordercancel.vo.OrderCancelSearchVo;
import com.brcc.business.ordercancel.vo.OrderCancelVo;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 撤单审核业务逻辑接口
 *
 * @author yushaohua
 * @create 2018-11-06 22:32
 */
public interface OrderCancelService {

    /**
     * 分页查询撤单审核数据
     * @param vo
     * @return
     */
    Page<OrderCancelVo> findAllPage(OrderCancelSearchVo vo);

    /**
     * 新增/更新对象
     * @param entity
     * @return
     */
    DeliverycancelauditEntity save(DeliverycancelauditEntity entity);

    /**
     * 撤销申请
     * @param entity
     * @return
     */
    Map<String , Object> orderCancel(DeliverycancelauditEntity entity);

    /**
     * 分页查询撤单审核数据
     * @param vo
     * @return
     */
    List<OrderCancelVo> findAll(OrderCancelSearchVo vo);

    /**
     * 保存数据
     * @param paramMap
     */
    void saveOrderCancel(Map<String, Object> paramMap);

    /**
     * 调用存储过程
     * @param deliveryCancelId
     * @return
     */
    Map<String, Object> blackListCheck(Long deliveryCancelId);

    /**
     * 分页查询撤单审核数据(货主级)
     * @param vo
     * @return
     */
    Page<OrderCancelVo> findAllPublisherPage(OrderCancelSearchVo vo);

    /**
     * 查询撤单审核数据(货主级)
     * @param vo
     * @return
     */
    List<OrderCancelVo> findAllPublisherList(OrderCancelSearchVo vo);

    /**
     * 更新状态
     */
    void updateStatus(OrderCancelSearchVo vo);

    /**
     * 撤单状态
     * @param deliveryId
     * @param platformId
     * @return
     */
    List<DeliverycancelauditEntity> deliveryCancelCheck(Long deliveryId, String platformId);
}