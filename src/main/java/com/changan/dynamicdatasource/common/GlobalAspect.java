package com.changan.dynamicdatasource.common;

import com.changan.dynamicdatasource.common.datasource.DatabaseType;
import com.changan.dynamicdatasource.common.datasource.DynamicDataSource;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author zab
 * @date 2019/5/31 8:50
 */
@Aspect
@Component
public class GlobalAspect {
    @Pointcut("@annotation(com.changan.dynamicdatasource.common.datasource.Master)")
    public void master() {
    }

    @Pointcut("@annotation(com.changan.dynamicdatasource.common.datasource.Slave)")
    public void slave() {
    }

    @Before("master()")
    public void beforeMaster() {
        DynamicDataSource.DatabaseContextHolder.setDatabaseType(DatabaseType.db1);
    }

    @Before("slave()")
    public void beforeSlave() {
        DynamicDataSource.DatabaseContextHolder.setDatabaseType(DatabaseType.db2);
    }
}
