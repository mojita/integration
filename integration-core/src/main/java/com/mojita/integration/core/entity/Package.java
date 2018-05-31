package com.mojita.integration.core.entity;

/**
 * @author lijunhong
 * @since 18/5/30 下午3:34
 */
public class Package {

    private Integer id;
    private String packageName;
    private Student student;


    public Package() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
