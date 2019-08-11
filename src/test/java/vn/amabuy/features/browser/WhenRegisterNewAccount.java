package vn.amabuy.features.browser;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import vn.amabuy.features.models.Account;
import vn.amabuy.steps.HomeSteps;
import vn.amabuy.steps.LoginSteps;
import vn.amabuy.steps.RegisterSteps;

@RunWith(SerenityRunner.class)
public class WhenRegisterNewAccount {

	Account account_correct_repwd = new Account("tranvan", "tranvan.humg@gmail.com", "0985035845", "tranvan1601",
			"tranvan1601");
	Account account_wrong_repwd = new Account("tranvan", "tranvan.humg@gmail.com", "0985035845", "tranvan1601",
			"tranvan");

	@Managed
	WebDriver driver;

	@Steps
	HomeSteps homeSteps;

	@Steps
	LoginSteps loginSteps;

	@Steps
	RegisterSteps registerSteps;


	@Test 
	public void register_new_account_with_incorect_password() {
		String errMsg ="thành công";
		
		account_correct_repwd.setEmail(String.format("%s_%s",RandomStringUtils.randomAlphanumeric(10),account_correct_repwd.getEmail()));
		account_correct_repwd.setPhone(String.format("%s%s",account_correct_repwd.getPhone().substring(0, 4),RandomStringUtils.randomNumeric(6)));
		
		homeSteps.visit_the_application();
		homeSteps.click_on_login_link();

		loginSteps.click_on_register_link();

		registerSteps.register_new_account_with(account_correct_repwd);

		registerSteps.should_see_message_correct(errMsg);
	}
	
	@Pending @Test
	public void register_new_account_with_info_account_registed() {
		String errMsg = "Email và số điện thoại này đã được đăng ký trước đây, Quý khách vui lòng kiểm tra Email để kích hoạt tài khoản";
				
		homeSteps.visit_the_application();
		homeSteps.click_on_login_link();

		loginSteps.click_on_register_link();

		registerSteps.register_new_account_with(account_correct_repwd);

		registerSteps.should_see_warning_error_message_correct(errMsg);
	}


	@Pending @Test
	public void register_new_account_with_wrong_confirm_password() {
		String errMsg = "Mật khẩu xác nhận không chính xác";
		homeSteps.visit_the_application();
		homeSteps.click_on_login_link();

		loginSteps.click_on_register_link();

		registerSteps.register_new_account_with(account_wrong_repwd);

		registerSteps.should_see_warning_error_message_correct(errMsg);
	}
	@Pending @Test
	public void register_new_account_with_randoom_email() {
		System.out.print(account_correct_repwd.getEmail());
		System.out.print(account_correct_repwd.getPhone());
	}
}
