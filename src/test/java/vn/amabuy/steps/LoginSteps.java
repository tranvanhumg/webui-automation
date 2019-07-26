package vn.amabuy.steps;

import net.thucydides.core.annotations.Step;
import vn.amabuy.pages.LoginPage;

public class LoginSteps {
	LoginPage onLoginPage;

	@Step
	public void click_on_register_link() {
		onLoginPage.clickOnRegisterLink();
	}
}
