package com.changan.dynamicdatasource.common.datasource;

public class DatabaseContextHolder {
    private static final ThreadLocal<DatabaseType> CONTEXT_HOLDER = new ThreadLocal<>();

    public static DatabaseType getDatabaseType() {
        return CONTEXT_HOLDER.get();
    }

    public static void setDatabaseType(DatabaseType type) {
        CONTEXT_HOLDER.set(type);
    }
}
