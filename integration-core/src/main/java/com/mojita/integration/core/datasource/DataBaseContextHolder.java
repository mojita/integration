package com.mojita.integration.core.datasource;

/**
 * @author lijunhong
 * @since 18/5/27 下午4:52
 * 保存一个线程安全的DatabaseType容器
 */
public class DataBaseContextHolder {

    private static final ThreadLocal<DataBaseType> contextHolder = new ThreadLocal<>();

    public enum DataBaseType {
        POSTGRES,MYSQLMASTER,MYSQLSLAVEONE
    }

    /**
     * 设置数据源类型进入线程安全的容器中
     * @param databaseType
     */
    public static void setDatabaseType(DataBaseType databaseType) {
        if(databaseType == null) throw new NullPointerException();
        contextHolder.set(databaseType);
    }


    /**
     * 从线程安全的容器中获取容器类型名称
     * @return
     */
    public static DataBaseType getDatabaseType() {
        System.out.println("contextHolder.get:" + contextHolder.get());
        return contextHolder.get()  == null ? DataBaseType.POSTGRES : contextHolder.get();
    }

    /**
     * 从当前线程中清空数据源类型
     */
    public static void clearDataBaseType() {
        contextHolder.remove();
    }
}
