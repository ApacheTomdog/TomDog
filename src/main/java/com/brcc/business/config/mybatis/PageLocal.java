package com.brcc.business.config.mybatis;

import com.esteel.common.vo.AggregationPageImpl;
import com.esteel.common.vo.BaseQueryVo;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * 用于做mybatis的分页时的分页数据传递
 *
 * User: zhangxiuzhi
 * Date: 2018-10-30
 * Time: 14:35
 */
public  class PageLocal {

    //用于在调用方法和mybatis拦截器之间 传递分页数据
    public static final ThreadLocal<BaseQueryVo> VO_THREAD_LOCAL = new ThreadLocal<>();

    //用于在调用方法和数据之间 返回查询的数据
    public static final ThreadLocal<PageReustDto> PAGE_THREAD_LOCAL = new ThreadLocal<>();


    public static void set(BaseQueryVo baseQueryVo){
        VO_THREAD_LOCAL.set(baseQueryVo);
    }


    public static BaseQueryVo get(){
        return VO_THREAD_LOCAL.get();
    }


    public static void setPage(PageReustDto pageReustDto){
        PAGE_THREAD_LOCAL.set(pageReustDto);
    }

    public static PageReustDto getPage(){
        return PAGE_THREAD_LOCAL.get();
    }
}


