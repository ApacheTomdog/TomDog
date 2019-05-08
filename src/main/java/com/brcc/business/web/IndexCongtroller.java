package com.brcc.business.web;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ESTeel
 * Description:
 * User: zhangxiuzhi
 * Date: 2018-11-18
 * Time: 13:13
 */
@RestController
public class IndexCongtroller {


    ApplicationContext applicationContext;

    @Autowired
    DataSourceProperties dataSourceProperties;


    @Autowired
    @Qualifier("readDataSourceProperties")
    DataSourceProperties readDataSourceProperties;


    @Autowired
    DataSource dataSource;

    @Autowired
    @Qualifier("readDataSource")
    DataSource readDataSource;

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    @Qualifier("readSqlSessionTemplate")
    SqlSessionTemplate readSqlSessionTemplate;


    @RequestMapping("/1")
    public DataSourceProperties index1() {
        return dataSourceProperties;
    }


    @RequestMapping("/read1")
    public DataSourceProperties read1() {
        return readDataSourceProperties;
    }

    @RequestMapping("/")
    public long index() {

//        queryFirstVatFlowInfo
        Map map = new HashMap();
        map.put("deliveryId","2316659");

        List<Object> list = this.sqlSessionTemplate.selectList("transportSettle.queryFirstVatFlowInfo",map);

        System.out.println(list.size());

        return this.testDataSource(dataSource);
    }


    @RequestMapping("/read")
    public long read() {
        return this.testDataSource(readDataSource);
    }

    /**
     * 用于测试连接的数据库
     *
     * @param dataSource
     * @return
     */
    private long testDataSource(DataSource dataSource) {

        Statement statement;
        ResultSet rs;

        try (Connection connection = dataSource.getConnection()) {

            statement = connection.createStatement();
            rs = statement.executeQuery("select count(*) from loginverify");

            while (rs.next()) {
                return rs.getLong(1);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;

    }


}
