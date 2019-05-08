package com.brcc.business.transorder.repository;

import com.brcc.business.transorder.entity.ViewAbnormalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 描述:
 * 平台调度单异常信息数据接口
 *
 * @author yushaohua
 * @create 2018-11-14 16:34
 */
@Repository
public interface ViewAbnormalRepository extends JpaRepository<ViewAbnormalEntity,Long>, IViewAbnormalRepository {

}