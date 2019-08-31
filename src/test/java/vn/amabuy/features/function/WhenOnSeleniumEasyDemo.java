package vn.amabuy.features.function;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import vn.amabuy.steps.AlertSteps;
import vn.amabuy.steps.SeleniumEasyTestHomeSteps;

@RunWith(SerenityRunner.class)
@WithTags({ @WithTag("SeleniumEasy") })
public class WhenOnSeleniumEasyDemo {

	@Managed
	WebDriver driver;
	
	@Steps
	SeleniumEasyTestHomeSteps seleniumHomeSteps;

	@Steps
	AlertSteps alertSteps;
	
	@Pending
	@WithTag("alert")
	@Test
	public void accept_alert() {
		seleniumHomeSteps.open_web();
		seleniumHomeSteps.showAlertForm();
		alertSteps.show_alert();
		alertSteps.accept();
	}
	@Pending
	@WithTag("alert")
	@Test
	public void cancel_confrim() {
		seleniumHomeSteps.open_web();
		seleniumHomeSteps.showAlertForm();
		alertSteps.show_confirm();
		alertSteps.cancel();
	}
	@WithTag("alert")
	@Test
	public void answer_popup() {
		seleniumHomeSteps.open_web();
		seleniumHomeSteps.showAlertForm();
		alertSteps.show_popup();
		alertSteps.answer("Hashing van");
		alertSteps.accept();
	}
//	@WithTag("multiselect")
//	@Test
//	public void select_dropdown() {
//		seleniumHomeSteps.open_web();				
//		seleniumHomeSteps.showJqSelectDropDownForm();
//		seleniumHomeSteps.select_states(1,2);
//		seleniumHomeSteps.select_country("India");
//		seleniumHomeSteps.scrool_to_erritories();
//		seleniumHomeSteps.select_US_Outlying_Territories("Guam");
//	}
	@WithTag("multiselect")
	@Test
	public void enter_dropdown() {
		seleniumHomeSteps.open_web();				
		seleniumHomeSteps.showJqSelectDropDownForm();
		//seleniumHomeSteps.select_states(1,2);
		seleniumHomeSteps.select_country("India");
		seleniumHomeSteps.scrool_to_erritories();
		seleniumHomeSteps.enter_US_Outlying_Territories("Guam");
	}
	
}
