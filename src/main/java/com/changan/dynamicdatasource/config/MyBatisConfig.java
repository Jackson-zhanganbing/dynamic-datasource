package com.changan.dynamicdatasource.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.changan.dynamicdatasource.common.datasource.DatabaseType;
import com.changan.dynamicdatasource.common.datasource.DynamicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * springboot集成mybatis的基本入口
 * 1）创建数据源(如果采用的是默认的tomcat-jdbc数据源，则不需要)
 * 2) 创建SqlSessionFactory
 * 3）配置事务管理器，除非需要使用事务，否则不用配置
 */
@Configuration
@MapperScan(basePackages = "com.changan.dynamicdatasource.dao")
public class MyBatisConfig {

    @Autowired
    private Environment env;

    /**
     * 创建数据源(数据源的名称：方法名可以取为XXXDataSource(),XXX为数据库名称,该名称也就是数据源的名称)
     */
    @Bean
    @Primary
    public DataSource myTestDbDataSource1() throws Exception {
        System.out.println(env.getProperty("spring.datasource.druid.driver-class-name"));
        Properties props = new Properties();
        props.put("driverClassName", env.getProperty("spring.datasource.druid.driver-class-name"));
        props.put("url", env.getProperty("spring.datasource.druid.url"));
        props.put("username", env.getProperty("spring.datasource.druid.username"));
        props.put("password", env.getProperty("spring.datasource.druid.password"));
        return DruidDataSourceFactory.createDataSource(props);
    }

    @Bean
    public DataSource myTestDbDataSource2() throws Exception {
        Properties props = new Properties();
        props.put("url", env.getProperty("spring.datasource-ext.druid.url"));
        props.put("driverClassName", env.getProperty("spring.datasource-ext.druid.driver-class-name"));
        props.put("username", env.getProperty("spring.datasource-ext.druid.username"));
        props.put("password", env.getProperty("spring.datasource-ext.druid.password"));
        return DruidDataSourceFactory.createDataSource(props);
    }

    /**
     * @Primary 该注解表示在同一个接口有多个实现类可以注入的时候，默认选择哪一个，而不是让@autowire注解报错
     * @Qualifier 根据名称进行注入，通常是在具有相同的多个类型的实例的一个注入（例如有多个DataSource类型的实例）
     */
    @Bean
    public DynamicDataSource dataSource(@Qualifier("myTestDbDataSource1") DataSource myTestDbDataSource1,
                                        @Qualifier("myTestDbDataSource2") DataSource myTestDbDataSource2) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DatabaseType.db1, myTestDbDataSource1);
        targetDataSources.put(DatabaseType.db2, myTestDbDataSource2);

        DynamicDataSource dataSource = new DynamicDataSource();
        // 该方法是AbstractRoutingDataSource的方法
        dataSource.setTargetDataSources(targetDataSources);
        // 默认的datasource设置为myTestDbDataSource
        dataSource.setDefaultTargetDataSource(myTestDbDataSource1);

        return dataSource;
    }

    /**
     * 根据数据源创建SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DynamicDataSource ds) throws Exception {
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        // 指定数据源(这个必须有，否则报错)
        fb.setDataSource(ds);
        // 下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
        // 指定基包
        fb.setTypeAliasesPackage(env.getProperty("mybatis.type-aliases-package"));
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapper-locations")));

        return fb.getObject();
    }

    /**
     * 配置事务管理器
     */
    @Bean
    public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }

}
