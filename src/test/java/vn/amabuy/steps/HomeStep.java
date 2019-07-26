package vn.amabuy.steps;

import net.thucydides.core.annotations.Step;
import vn.amabuy.pages.HomePage;

public class HomeStep {
	HomePage onHomePage;

	@Step
	public void visit_the_application() {
		onHomePage.open();
	}
}
