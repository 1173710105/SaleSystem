package com.software.domain;

public class Staff {
    /**
     * 员工ID ID
     */
    private String id;

    /**
     * 员工密码 password
     */
    private String password;

    /**
     * 员工姓名 name
     */
    private String name;

    /**
     * 员工性别 gender
     */
    private String gender;

    /**
     * 员工电话 phone
     */
    private String phone;

    /**
     * 员工email email
     */
    private String email;

    /**
     * 员工权限标志位 authority
     */
    private String authority;

    /**
     * 员工ID
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return ID 员工ID
     */
    public String getId() {
        return id;
    }

    /**
     * 员工ID
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param id 员工ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 员工密码
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return password 员工密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 员工密码
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param password 员工密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 员工姓名
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return name 员工姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 员工姓名
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param name 员工姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 员工性别
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return gender 员工性别
     */
    public String getGender() {
        return gender;
    }

    /**
     * 员工性别
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param gender 员工性别
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * 员工电话
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return phone 员工电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 员工电话
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param phone 员工电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 员工email
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return email 员工email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 员工email
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param email 员工email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 员工权限标志位
     * @author www12
     * @date 2019-11-27 20:20:28
     * @return authority 员工权限标志位
     */
    public String getAuthority() {
        return authority;
    }

    /**
     * 员工权限标志位
     * @author www12
     * @date 2019-11-27 20:20:28
     * @param authority 员工权限标志位
     */
    public void setAuthority(String authority) {
        this.authority = authority == null ? null : authority.trim();
    }
}