package vn.amabuy.pages;

import net.serenitybdd.core.pages.PageObject;

public class RegisterPage extends PageObject {

	private static final String ALERT = "//div[@class='alert alert-danger text-center']";
	private static final String FULLNAME_FILED = "Họ và tên";
	private static final String EMAIL_FILED = "Địa chỉ Email";
	private static final String PHONE_FILED = "Số điện thoại";
	private static final String PASSWORD_FILED = "Mật khẩu";
	private static final String CONFIRM_PASSWORD_FILED = "Nhập lại mật khẩu";

	public void enterTextIntoFullName(String fullName) {
		element(Target.of(FULLNAME_FILED)).type(fullName);
	}

	public void enterTextIntoEmail(String email) {
		element(Target.of(EMAIL_FILED)).type(email);
	}

	public void enterTextIntoPhone(String phone) {
		element(Target.of(PHONE_FILED)).type(phone);
	}

	public void enterTextIntoPassword(String pwd) {
		$(Target.of(PASSWORD_FILED)).type(pwd);
	}

	public void enterTextIntoConfirmPassword(String confirmpwd) {
		$(Target.of(CONFIRM_PASSWORD_FILED)).type(confirmpwd);
	}

	// "//button[@class='btn btn-login']"
	public void clickOnRegisterBt() {
		$("//button[@class='btn btn-login']").click();
	}

	static class Target {
		private static final String TARGET = "//label[contains(text(),'%s')]/following-sibling::input";

		public static String of(String label) {
			return String.format(TARGET, label);
		}
	}

	public String getErrMsg() {
		return element(ALERT).getText();
	}
}
