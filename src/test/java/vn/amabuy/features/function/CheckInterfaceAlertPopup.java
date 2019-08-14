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

@RunWith(SerenityRunner.class)
@WithTags({ @WithTag("alert") })
public class CheckInterfaceAlertPopup {

	@Managed
	WebDriver driver;
	
	@Steps
	AlertSteps alertSteps;
	
	@Test
	public void accept_alert() {
		alertSteps.open_web();
		alertSteps.show_alert();
		alertSteps.accept();
	}
	@Test
	public void cancel_confrim() {
		alertSteps.open_web();
		alertSteps.show_confirm();
		alertSteps.cancel();
	}
	@Test
	public void answer_popup() {
		alertSteps.open_web();
		alertSteps.show_popup();
		alertSteps.answer("Hashing van");
		alertSteps.accept();
	}
}
