package com.zuishuai.cn.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Spring配置文件
 * @author luozuishuai
 * @Created on 2020-12-16 23:30
 */
@Configuration      //声明为配置类
@ComponentScan("com.zuishuai.cn.service")    //包扫描
@EnableTransactionManagement                 //开启事务
@PropertySource("classpath:db.properties")   //导入配置文件
public class RootConfig{

    @Value("${jdbc.driverClassName}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    //配置数据源
    @Bean
    public DruidDataSource getDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///homework");
        dataSource.setUsername("root");
        dataSource.setPassword("abc123");
//        dataSource.setDriverClassName(driver);
//        dataSource.setUrl(url);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
        return dataSource;
    }

    //配置SqlSessionFactory
    @Bean
    public SqlSessionFactoryBean getSqlSessionFactoryBean(){
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(getDataSource());
        return factory;
    }

    @Bean
    public MapperScannerConfigurer getMapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.zuishuai.cn.mapper");
        return mapperScannerConfigurer;
    }

    @Bean("transactionManager")
    public DataSourceTransactionManager getDataSourceTransactionManager(){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(getDataSource());
        return transactionManager;
    }
}
