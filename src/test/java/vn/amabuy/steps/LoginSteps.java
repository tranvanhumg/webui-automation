package vn.amabuy.steps;

import net.thucydides.core.annotations.Step;
import vn.amabuy.pages.LoginPage;

public class LoginSteps {
	LoginPage onLoginPage;

	@Step
	public void click_on_register_link() {
		onLoginPage.clickOnRegisterLink();
	}
	@Step
	public void enter_email(String email) {
		onLoginPage.enterEmailField(email);
	}
	@Step
	public void enter_password(String pwd) {
		onLoginPage.enterPassword(pwd);
	}
	
	@Step
	public void paste_on_email() {
		onLoginPage.pasteEmail();
	}
	@Step
	public void open_page() {
		onLoginPage.open();
	}
	@Step
	public void click_login() {
		onLoginPage.clickLogin();
	}	
	@Step
	public void paste_by_mouse_on_email()
	{
		onLoginPage.open_context_menu_on_email();
		onLoginPage.pasteByMouse(4);
	}
}
