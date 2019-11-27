package com.software.domain;

public class Client {
    /**
     * 客户ID ID
     */
    private Integer id;

    /**
     * 客户名字 name
     */
    private String name;

    /**
     * 客户性别 gender
     */
    private String gender;

    /**
     * 客户电话 phone
     */
    private String phone;

    /**
     * 客户email email
     */
    private String email;

    /**
     * 客户类型标签 label
     */
    private String label;

    /**
     * 客户ID
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return ID 客户ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 客户ID
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param id 客户ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 客户名字
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return name 客户名字
     */
    public String getName() {
        return name;
    }

    /**
     * 客户名字
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param name 客户名字
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 客户性别
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return gender 客户性别
     */
    public String getGender() {
        return gender;
    }

    /**
     * 客户性别
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param gender 客户性别
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * 客户电话
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return phone 客户电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 客户电话
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param phone 客户电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 客户email
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return email 客户email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 客户email
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param email 客户email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 客户类型标签
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return label 客户类型标签
     */
    public String getLabel() {
        return label;
    }

    /**
     * 客户类型标签
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param label 客户类型标签
     */
    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }
}