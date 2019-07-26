package vn.amabuy.features.browser;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import vn.amabuy.steps.HomeSteps;

@RunWith(SerenityRunner.class)
public class WhenOpeningTheWeb {
	
	@Managed
	WebDriver driver;
	
	@Steps
	HomeSteps onHomeStep;
	
	@Pending @Test
	public void when_opening_the_application() {
	
		onHomeStep.visit_the_application();
	}
}
