package vn.amabuy.models;

import org.apache.commons.lang3.RandomStringUtils;

public class Account {

	private String fullname;
	private String email;
	private String phone;
	private String password;
	private String repassword;

	public Account(String fullname, String email, String phone, String pwd, String repwd) {
		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
		this.password = pwd;
		this.repassword = repwd;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

}
