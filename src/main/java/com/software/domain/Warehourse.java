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
     * 负责人ID principalID
     */
    private Integer principalid;

    /**
     * 仓库ID
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return ID 仓库ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 仓库ID
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param id 仓库ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 仓库名字
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return name 仓库名字
     */
    public String getName() {
        return name;
    }

    /**
     * 仓库名字
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param name 仓库名字
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 仓库位置
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return location 仓库位置
     */
    public String getLocation() {
        return location;
    }

    /**
     * 仓库位置
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param location 仓库位置
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
     * 负责人ID
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return principalID 负责人ID
     */
    public Integer getPrincipalid() {
        return principalid;
    }

    /**
     * 负责人ID
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param principalid 负责人ID
     */
    public void setPrincipalid(Integer principalid) {
        this.principalid = principalid;
    }
}