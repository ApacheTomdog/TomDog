package com.brcc.business.config.mybatis;

import org.springframework.data.domain.Pageable;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * 在 mybatis 调用返回数据的时候 用于返回查询的条数 等结果信息
 *
 * User: zhangxiuzhi
 * Date: 2018-10-30
 * Time: 17:02
 */
public class PageReustDto implements Serializable {

    Pageable pageable;
    long total;

    public PageReustDto(long total){
        this.total = total;
    }

    public PageReustDto(Pageable pageable,long total){
        this.pageable = pageable;
        this.total = total;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
