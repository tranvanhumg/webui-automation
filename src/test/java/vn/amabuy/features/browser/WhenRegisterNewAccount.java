package vn.amabuy.features.browser;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import vn.amabuy.steps.HomeSteps;
import vn.amabuy.steps.LoginSteps;
import vn.amabuy.steps.RegisterSteps;

@RunWith(SerenityRunner.class)
public class WhenRegisterNewAccount {

	@Managed
	WebDriver driver;
	
	@Steps
	HomeSteps homeSteps;
	
	@Steps
	LoginSteps loginSteps;
	
	@Steps
	RegisterSteps registerSteps;
	
	@Test
	public void register_new_account()
	{
		//String errMsg="Mật khẩu xác nhận không chính xác";
		String errMsg="Email và số điện thoại này đã được đăng ký trước đây, Quý khách vui lòng kiểm tra Email để kích hoạt tài khoản";
		homeSteps.visit_the_application();
		homeSteps.click_on_login_link();
		
		loginSteps.click_on_register_link();
		
		registerSteps.register_new_account("TranVan", "tranvan.humg@gmail.com", "0985035845", "tranvan1601", "tranvan1601");
	
	    registerSteps.should_see_warning_error_message_correct(errMsg);
	}
	@Test
	public void register_new_account_wrong_confirm_password()
	{
		String errMsg="Mật khẩu xác nhận không chính xác";
		//String errMsg="Email và số điện thoại này đã được đăng ký trước đây, Quý khách vui lòng kiểm tra Email để kích hoạt tài khoản";
		homeSteps.visit_the_application();
		homeSteps.click_on_login_link();
		
		loginSteps.click_on_register_link();
		
		registerSteps.register_new_account("TranVan", "tranvan.humg@gmail.com", "0985035845", "tranvan1601", "tranvan");
	
	    registerSteps.should_see_warning_error_message_correct(errMsg);
	}	
}
