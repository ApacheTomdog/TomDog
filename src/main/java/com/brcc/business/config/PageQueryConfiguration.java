package com.brcc.business.config;

import com.esteel.common.dao.PageQuery;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zhangxiuzhi
 * Date: 2018-10-26
 * Time: 15:09
 */
@Configuration
public class PageQueryConfiguration {



    @Bean(name = "jdbcTemplate")
    public JdbcTemplate primaryJdbcTemplate(
            @Qualifier("dataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "readJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate(
            @Qualifier("readDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean("pageQuery")
    @Primary
    public PageQuery pageQuery(@Qualifier("jdbcTemplate") JdbcTemplate jdbcTemplate){
        PageQuery pageQuery = new PageQuery(jdbcTemplate);

        return pageQuery;
    }


    /**
     * 提供只读 查询对象
     * @return
     */
    @Bean("readPageQuery")
    public PageQuery readPageQuery(@Qualifier("readJdbcTemplate") JdbcTemplate jdbcTemplate){
        PageQuery pageQuery = new PageQuery(jdbcTemplate);
        return pageQuery;
    }
}
