package vn.amabuy.models;

import org.apache.commons.lang3.RandomStringUtils;

import net.serenitybdd.core.Serenity;

public class AccountBuilder {
	private String name;
	private String email;
	private String phone;
	private String password;
	private String repassword;

	public AccountBuilder(String name) {
		this.name = name;
	}

	public AccountBuilder withEmail(String email) {
		this.email = email;
		return this;
	}
	
	public AccountBuilder withRandoomEmail(String email) {
		this.email = String.format("%s_%s", RandomStringUtils.randomAlphanumeric(10), email);
		return this;
	}

	public AccountBuilder withPhone(String phone) {
		this.phone = phone;
		return this;
	}
	
	public AccountBuilder withRandoomPhone(String phone) {
		this.phone = String.format("%s%s", phone.substring(0, 4),RandomStringUtils.randomNumeric(6));
		return this;
	}

	public AccountBuilder withPassword(String password) {
		this.password = password;
		return this;
	}

	public AccountBuilder withConfirmPassword(String repassword) {
		this.repassword = repassword;
		return this;
	}

	public Account build() {
		return new Account(name, email, phone, password, repassword);
	}
}
