package com.mojita.integration.core.datasource;

/**
 * @author lijunhong
 * @since 18/5/27 下午4:52
 * 保存一个线程安全的DatabaseType容器
 */
public class DatabaseContextHolder {

    private static final ThreadLocal<DatabaseType> contextHolder = new ThreadLocal<>();


    /**
     * 设置数据源类型进入线程安全的容器中
     * @param type
     */
    public static void setDatabaseType(DatabaseType type) {
        if(type == null) throw new NullPointerException();
        contextHolder.set(type);
    }


    /**
     * 从线程安全的容器中获取容器类型名称
     * @return
     */
    public static DatabaseType getDatabaseType() {
        return contextHolder.get()  == null ? DatabaseType.POSTGRES : contextHolder.get();
    }

    /**
     * 从当前线程中清空数据源类型
     */
    public static void clearDataBaseType() {
        contextHolder.remove();
    }
}
