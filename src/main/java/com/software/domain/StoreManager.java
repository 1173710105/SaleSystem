package com.software.domain;

public class StoreManager {
    /**
     *  ID
     */
    private String id;

    /**
     *  password
     */
    private String password;

    /**
     * 店长姓名 name
     */
    private String name;

    /**
     * 性别 gender
     */
    private String gender;

    /**
     * 店长手机号 phone
     */
    private String phone;

    /**
     * 店长email email
     */
    private String email;

    /**
     *  label
     */
    private String label;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }
}