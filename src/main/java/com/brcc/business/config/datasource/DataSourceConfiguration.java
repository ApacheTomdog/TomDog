package com.brcc.business.config.datasource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * ESTeel
 * Description: 双数据源配置
 * User: zhangxiuzhi
 * Date: 2018-11-18
 * Time: 12:57
 */
@Configuration
public class DataSourceConfiguration {


    @Bean
    @Primary
    @ConfigurationProperties("business.datasource")
    public DataSourceProperties firstDataSourceProperties() {
        return new DataSourceProperties();
    }


    @Bean
    @ConfigurationProperties("business.datasourceread")
    public DataSourceProperties readDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource dataSource() {
        return new CustomDuridDataSourceWapper(firstDataSourceProperties());
    }

    @Bean
    public DataSource readDataSource(){
        return new CustomDuridDataSourceWapper(readDataSourceProperties());
    }

}
