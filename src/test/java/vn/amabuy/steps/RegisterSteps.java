package vn.amabuy.steps;

import static org.junit.Assert.assertEquals;

import net.thucydides.core.annotations.Step;
import vn.amabuy.pages.RegisterPage;

public class RegisterSteps {
	RegisterPage onRegisterPage;

	@Step
	public void register_new_account(String fullName, String email, String phone,String pwd,String confirmpwd) {
		enter_full_name(fullName);
		enter_email(email);
		enter_phone(phone);
		enter_password(pwd);
		enter_confirm_password(confirmpwd);
		click_on_register_bt();
	}
	@Step
	private void click_on_register_bt() {
		onRegisterPage.clickOnRegisterBt();
	}
	@Step
	private void enter_confirm_password(String confirmpwd) {
		onRegisterPage.enterTextIntoConfirmPassword(confirmpwd);
	}
	@Step
	private void enter_password(String pwd) {
		onRegisterPage.enterTextIntoPassword(pwd);
	}
	@Step
	private void enter_phone(String phone) {
		onRegisterPage.enterTextIntoPhone(phone);
	}
	@Step
	private void enter_email(String email) {
		onRegisterPage.enterTextIntoEmail(email);
	}
	@Step
	private void enter_full_name(String fullName) {
		onRegisterPage.enterTextIntoFullName(fullName);
	}
	@Step
	public void should_see_warning_error_message_correct(String expectedStr) {
	 assertEquals(expectedStr, onRegisterPage.getErrMsg());
	}
}
