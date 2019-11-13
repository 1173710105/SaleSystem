package com.software.domain;

public class new_table {
    /**
     * i am here ID
     */
    private Integer id;

    /**
     * i am here too Name
     */
    private String name;

    /**
     * i am here too too test
     */
    private String test;

    /**
     * i am here
     * @author www12
     * @date 2019-11-13 15:11:13
     * @return ID i am here
     */
    public Integer getId() {
        return id;
    }

    /**
     * i am here
     * @author www12
     * @date 2019-11-13 15:11:13
     * @param id i am here
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * i am here too
     * @author www12
     * @date 2019-11-13 15:11:13
     * @return Name i am here too
     */
    public String getName() {
        return name;
    }

    /**
     * i am here too
     * @author www12
     * @date 2019-11-13 15:11:13
     * @param name i am here too
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * i am here too too
     * @author www12
     * @date 2019-11-13 15:11:13
     * @return test i am here too too
     */
    public String getTest() {
        return test;
    }

    /**
     * i am here too too
     * @author www12
     * @date 2019-11-13 15:11:13
     * @param test i am here too too
     */
    public void setTest(String test) {
        this.test = test == null ? null : test.trim();
    }
}