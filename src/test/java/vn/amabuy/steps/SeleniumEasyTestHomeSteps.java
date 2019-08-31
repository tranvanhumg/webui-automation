package vn.amabuy.steps;

import net.thucydides.core.annotations.Step;
import vn.amabuy.pages.SeleniumEasyTestHomePage;

public class SeleniumEasyTestHomeSteps {

	SeleniumEasyTestHomePage onSeleniumEasyTestHomePage;

	@Step
	public void open_web() {
		onSeleniumEasyTestHomePage.open();
	}

	@Step
	public void showAlertForm() {
		onSeleniumEasyTestHomePage.clickShowJsAlertForm();
	}

	@Step
	public void showJqSelectDropDownForm() {
		onSeleniumEasyTestHomePage.clickShowJqSelectDopdownForm();
	}

	@Step
	public void enter_states(String... states) {
		onSeleniumEasyTestHomePage.enterSelectState(states);
	}

	@Step
	public void enter_country(String country) {
		onSeleniumEasyTestHomePage.enterCountry(country);
	}

	@Step
	public void enter_US_Outlying_Territories(String territories) {
		onSeleniumEasyTestHomePage.enter_US_Outlying_Territories(territories);
	}

	@Step
	public void select_states(int... indexs) {
		onSeleniumEasyTestHomePage.selectState(indexs);
	}

	@Step
	public void select_country(String country) {
		onSeleniumEasyTestHomePage.jsSelectCountry(country);

	}

	@Step
	public void select_US_Outlying_Territories(String territories) {
		onSeleniumEasyTestHomePage.jsSelect_US_Outlying_Territories(territories);
	}

	@Step
	public void scrool_to_erritories() {
		onSeleniumEasyTestHomePage.scrool_territories();
	}
}
