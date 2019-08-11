package vn.amabuy.steps;

//import static org.junit.Assert.assertEquals;
import static com.google.common.truth.Truth.*;
import static com.google.common.truth.Truth8.*;

import net.thucydides.core.annotations.Step;
import vn.amabuy.models.Account;
import vn.amabuy.pages.RegisterPage;

public class RegisterSteps {
	RegisterPage onRegisterPage;

	@Step
	public void register_new_account_with(Account account) {
		enter_full_name(account.getFullname());
		enter_email(account.getEmail());
		enter_phone(account.getPhone());
		enter_password(account.getPassword());
		enter_confirm_password(account.getRepassword());
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
	 //assertEquals(expectedStr, onRegisterPage.getErrMsg());		 		    
		//assertThat(expectedStr).isEqualTo(onRegisterPage.getErrMsg());
		assertThat(onRegisterPage.getErrMsg()).contains(expectedStr);
	}
	@Step
	public void should_see_message_correct(String expectedStr) {
		assertThat(onRegisterPage.getSuccessMsg()).contains(expectedStr);
	}
}
