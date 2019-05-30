package com.changan.dynamicdatasource.common.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author zab
 * @date 2019/5/30 11:31
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DatabaseContextHolder.getDatabaseType();
    }

    public static class DatabaseContextHolder {
        private static final ThreadLocal<DatabaseType> CONTEXT_HOLDER = new ThreadLocal<>();

        public static DatabaseType getDatabaseType() {
            return CONTEXT_HOLDER.get();
        }

        public static void setDatabaseType(DatabaseType type) {
            CONTEXT_HOLDER.set(type);
        }
    }
}
