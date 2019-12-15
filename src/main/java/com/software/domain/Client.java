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
     * 客户电话号码 phone
     */
    private String phone;

    /**
     * 客户邮件 email
     */
    private String email;

    /**
     *  note
     */
    private String note;

    /**
     *  type
     */
    private String type;

    /**
     * 客户标签 label
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }
}