package com.software.domain;

public class Staff 
{
	private String tablename;
	
    /**
     * 员工ID ID
     */
    private String id;

    /**
     * 密码 password
     */
    private String password;

    /**
     * 员工所属子仓库ID hourseID
     */
    private Integer hourseid;

    /**
     * 员工姓名 name
     */
    private String name;

    /**
     * 员工性别 gender
     */
    private String gender;

    /**
     * 员工手机 phone
     */
    private String phone;

    /**
     * 员工电子邮件 email
     */
    private String email;

    
    public String getTablename() {
		return tablename;
	}
    
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

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

    public Integer getHourseid() {
        return hourseid;
    }

    public void setHourseid(Integer hourseid) {
        this.hourseid = hourseid;
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

	@Override
	public String toString() {
		return "Staff [tablename=" + tablename + ", id=" + id + ", password=" + password + ", hourseid=" + hourseid
				+ ", name=" + name + ", gender=" + gender + ", phone=" + phone + ", email=" + email + "]";
	}
    
}