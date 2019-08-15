package vn.amabuy.features.browser;

import org.jetbrains.annotations.Nullable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import net.thucydides.junit.annotations.UseTestDataFrom;
import vn.amabuy.models.Account;
import vn.amabuy.steps.HomeSteps;
import vn.amabuy.steps.LoginSteps;
import vn.amabuy.steps.RegisterSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "testdata/accounts/register_account.csv")
@WithTags({
	@WithTag("datadriven")
})
public class WhenRegisterNewAccountWithDataFromCSV {

	@Managed
	WebDriver webDriver;

	@Steps
	RegisterSteps registerSteps;

	@Steps
	HomeSteps homeSteps;

	@Steps
	LoginSteps loginSteps;

	@Nullable
	private String fullName;
	
	@Nullable
	private String email;
	
	@Nullable
	private String phoneNumber;
	
	@Nullable
	private String password;
	
	@Nullable
	private String confirmPassword;

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setEmail(String emai) {
		this.email = emai;
	}

	public void setPhone(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Test
	public void register_new_account_with_incorect_password() {
		
		Account info_account = Account.named(fullName).withEmail(email).withPhone(phoneNumber).withPassword(password)
				.withConfirmPassword(confirmPassword).build();
		
		String errMsg = "thành công";

		registerSteps.randoom_account(info_account);

		homeSteps.visit_the_application();
		homeSteps.click_on_login_link();

		loginSteps.click_on_register_link();

		registerSteps.register_new_account_with(info_account);

		registerSteps.should_see_message_correct(errMsg);
	}
}
