package vn.amabuy.features.browser;

import static org.assertj.core.api.Assertions.assertThat;

import org.jruby.RubyBoolean.True;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import vn.amabuy.steps.HomeSteps;
import vn.amabuy.steps.RegisterSteps;

@RunWith(SerenityRunner.class)
@WithTags(
		{
			@WithTag("open")
		})
public class WhenXOpeningTheWeb {
	
	@Managed
	WebDriver driver;
	
	@Steps
	HomeSteps onHomeStep;
		
	@Steps(shared = true)
	RegisterSteps registerStep;
	
	@Pending
	@Test
	public void when_opening_the_application() {
	
		onHomeStep.visit_the_application();
		onHomeStep.click_on_login_link();
	}
	@Test
	public void verify_phone_variable_session_from_other_class() {
		assertThat("0654684135").isEqualTo(Serenity.sessionVariableCalled("phone"));
	}
	@Test
	public void verify_email_variable_session_from_other_class() {
		assertThat("0654684135").isEqualTo(registerStep.getEmail());
	}
}
