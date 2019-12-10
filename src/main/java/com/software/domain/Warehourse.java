package com.software.domain;

public class Warehourse {
    /**
     * 仓库ID ID
     */
    private Integer id;

    /**
     * 仓库名字 name
     */
    private String name;

    /**
     * 仓库位置 location
     */
    private String location;

    /**
     * 负责人ID，店长ID principalID
     */
    private Integer principalid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Integer getPrincipalid() {
        return principalid;
    }

    public void setPrincipalid(Integer principalid) {
        this.principalid = principalid;
    }
}