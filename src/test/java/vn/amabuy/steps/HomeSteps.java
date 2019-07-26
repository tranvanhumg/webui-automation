package vn.amabuy.steps;

import net.thucydides.core.annotations.Step;
import vn.amabuy.pages.HomePage;

public class HomeSteps {
	HomePage onHomePage;

	@Step
	public void visit_the_application() {
		onHomePage.open();
	}
	@Step
	public void click_on_login_link()
	{
		onHomePage.clickLoginLink();
	}
}
