package vn.amabuy.features.browser;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

import org.jruby.RubyBoolean.True;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.UsePersistantStepLibraries;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import vn.amabuy.models.Account;
import vn.amabuy.steps.HomeSteps;
import vn.amabuy.steps.LoginSteps;
import vn.amabuy.steps.RegisterSteps;

@RunWith(SerenityRunner.class)
@WithTags({ @WithTag("register") })
@UsePersistantStepLibraries
public class WhenRegisterNewAccount {
	Account account_correct_repwd = Account.named("tranvan")
			.withEmail("tranvan.humg@gmail.com")
			.withPhone("0985035845")
			.withPassword("tranvan1601")
			.withConfirmPassword("tranvan1601")
			.build();
	Account account_wrong_repwd = Account.named("tranvan")
			.withEmail("tranvan.humg@gmail.com")
			.withPhone("0985035845")
			.withPassword("tranvan1601")
			.withConfirmPassword("tranvan")
			.build();
	
	@Managed
	WebDriver driver;

	@Steps
	HomeSteps homeSteps;

	@Steps
	LoginSteps loginSteps;

	@Steps(shared = true)
	RegisterSteps registerSteps;

	@Test
	public void register_new_account_with_incorect_password() {
		String errMsg = "thành công";
		
		registerSteps.randoom_account(account_correct_repwd);

		homeSteps.visit_the_application();
		homeSteps.click_on_login_link();

		loginSteps.click_on_register_link();

		registerSteps.register_new_account_with(account_correct_repwd);

		registerSteps.should_see_message_correct(errMsg);
	}

	@Pending
	@Test
	public void register_new_account_with_info_account_registed() {
		String errMsg = "Email và số điện thoại này đã được đăng ký trước đây, Quý khách vui lòng kiểm tra Email để kích hoạt tài khoản";

		homeSteps.visit_the_application();
		homeSteps.click_on_login_link();

		loginSteps.click_on_register_link();

		registerSteps.register_new_account_with(account_correct_repwd);

		registerSteps.should_see_warning_error_message_correct(errMsg);
	}

	@WithTag("register_wrong")
	@Test
	@Pending
	public void register_new_account_with_wrong_confirm_password() {
		String errMsg = "Mật khẩu xác nhận không chính xác";
		homeSteps.visit_the_application();
		homeSteps.click_on_login_link();

		loginSteps.click_on_register_link();

		registerSteps.register_new_account_with(account_wrong_repwd);

		registerSteps.should_see_warning_error_message_correct(errMsg);
	}

	@Pending
	@Test
	public void register_new_account_with_randoom_email() {
		System.out.print(account_correct_repwd.getEmail());
		System.out.print(account_correct_repwd.getPhone());
	}

	@Pending
	@Test
	public void verify_email_variable_session() {

		assertThat(account_correct_repwd.getEmail()).isEqualTo(Serenity.sessionVariableCalled("email"));
	}

	@Test
	public void verify_phone_variable_session() {

		assertThat(account_correct_repwd.getPhone()).isEqualTo(Serenity.sessionVariableCalled("phone"));
	}

	@Test
	public void verify_email_UsePersistantStepLibraries() {

		assertThat(account_correct_repwd.getEmail()	).isEqualTo(registerSteps.getEmail());
	}

}
