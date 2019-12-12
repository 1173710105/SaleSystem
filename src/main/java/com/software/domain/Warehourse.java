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
    private String principalid;

    /**
     *  time
     */
    private String time;

    /**
     *  label
     */
    private String label;

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

    public String getPrincipalid() {
        return principalid;
    }

    public void setPrincipalid(String principalid) {
        this.principalid = principalid == null ? null : principalid.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }
}