package vn.amabuy.steps;

//import static org.junit.Assert.assertEquals;
import static com.google.common.truth.Truth.*;

import org.apache.commons.lang3.RandomStringUtils;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import vn.amabuy.models.Account;
import vn.amabuy.pages.RegisterPage;

public class RegisterSteps {
	RegisterPage onRegisterPage;

	String email;
	public String getEmail()
	{
		return email;
	}
	@Step
	public void register_new_account_with(Account account) {
		email= account.getEmail();
		Serenity.setSessionVariable("email").to(account.getEmail());
		Serenity.setSessionVariable("phone").to(account.getPhone());

		enter_full_name(account.getFullname());
		enter_email(account.getEmail());
		enter_phone(account.getPhone());
		enter_password(account.getPassword());
		enter_confirm_password(account.getRepassword());
		click_on_register_bt();
	}

	@Step
	public void randoom_account(Account account) {
		account.setEmail(
				String.format("%s_%s", RandomStringUtils.randomAlphanumeric(10), account.getEmail()));
		account.setPhone(String.format("%s%s", account.getPhone().substring(0, 4),
				RandomStringUtils.randomNumeric(6)));
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
		// assertEquals(expectedStr, onRegisterPage.getErrMsg());
		// assertThat(expectedStr).isEqualTo(onRegisterPage.getErrMsg());
		assertThat(onRegisterPage.getErrMsg()).contains(expectedStr);
	}

	@Step
	public void should_see_message_correct(String expectedStr) {
		assertThat(onRegisterPage.getSuccessMsg()).contains(expectedStr);
	}
}
