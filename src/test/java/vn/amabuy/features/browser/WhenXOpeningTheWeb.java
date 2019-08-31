package vn.amabuy.features.browser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.SoftAssertions;

import org.fluentlenium.core.annotation.Page;
import org.jruby.ir.operands.Array;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.interactions.touch.Scroll;

import com.google.common.collect.ImmutableList;

import jnr.ffi.Struct.int16_t;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import vn.amabuy.pages.HomePage;
import vn.amabuy.steps.HomeSteps;
import vn.amabuy.steps.LoginSteps;
import vn.amabuy.steps.RegisterSteps;

@RunWith(SerenityRunner.class)
@WithTags({ @WithTag("open") })
public class WhenXOpeningTheWeb {

	@Managed
	WebDriver driver;

	@Steps
	HomeSteps onHomeSteps;
	@Steps
	LoginSteps onLoginSteps;

	@Steps(shared = true)
	RegisterSteps registerStep;

	@Page
	HomePage homePage;

	@Pending
	@Test
	public void when_opening_the_application() {

		onHomeSteps.visit_the_application();
		onHomeSteps.click_on_login_link();
	}

	@Pending
	@Test
	public void verify_phone_variable_session_from_other_class() {
		assertThat("0654684135").isEqualTo(Serenity.sessionVariableCalled("phone"));
	}

	@Pending
	@Test
	public void verify_email_variable_session_from_other_class() {
		assertThat("0654684135").isEqualTo(registerStep.getEmail());
	}

	// Kich ban scroll footer amabuy và click element using javascript
	// EvaluateJavaScript
	@Pending
	@WithTag("evaluate")
	@Test
	public void WhenClickElementByEvaluateJavaScript() {
		onHomeSteps.visit_the_application();
		onHomeSteps.scroll_to_type_email();
		onHomeSteps.hight_light_email();
		onHomeSteps.hight_light_submit();
		onHomeSteps.enter_type_email("tranvan@gmail.com");
		onHomeSteps.click_on_submit_email();
	}

	// Viết kịch bản input value vào element search ngoai homepage roi copy vao
	// paste de dang nhap account

	// Với kịch bản có contextClick() thì sử dụng robot để bắt (thứ tự các lệnh
	// chuột phải từ 1-n)

	// sử dụng robot để upload file

	// select multi in combobox
	@Pending
	@WithTag("singin")
	@Test
	public void sign_in() {
		onHomeSteps.visit_the_application();
		onHomeSteps.cutText_from_search_key("tranvan.humg@gmail.com");
		onHomeSteps.click_on_login_link();

		onLoginSteps.paste_on_email();
		onLoginSteps.enter_password("tranvan1601");

		onLoginSteps.click_login();
	}

	// note: sing in by email cut form search input by mouse
	@Pending
	@WithTag("singin")
	@Test
	public void sign_in_by_mouse() {
		onHomeSteps.visit_the_application();
		onHomeSteps.copyText_by_mouse_from_search_key("tranvan.humg@gmail.com");
		onHomeSteps.click_on_login_link();

		onLoginSteps.paste_by_mouse_on_email();
		onLoginSteps.enter_password("tranvan1601");

		onLoginSteps.click_login();
	}

	// note: sing in, search by key
	// if have items then click link view more amazon result
	// if have page pagination then click ever link page and get items on page to
	// check title as true or fail
	@WithTag("search")
	@Test
	public void search_by_key() {
		String key = "quan ao trang";// hoac ke ngang doc xanh do

		onHomeSteps.visit_the_application();

		onHomeSteps.click_on_login_link();
		onLoginSteps.enter_email("tranvan.humg@gmail.com");
		onLoginSteps.enter_password("tranvan1601");
		onLoginSteps.click_login();

		onHomeSteps.enter_search_by_key(key);
		onHomeSteps.do_search();

		// check content on title
		// SoftAssertions softAssertions = new SoftAssertions();

		List<String> listTitle = homePage.getLabelsItemList();
		List<WebElementFacade> linkViewMoreList = homePage.view_more_item;
		List<WebElementFacade> linkPage = homePage.page_pagination;
		List<Object> list1 = new ArrayList<>();
		if (linkViewMoreList.size() > 0)
			for (WebElementFacade we : linkViewMoreList) {
				if (we.getText().contains("amazon")) {
					homePage.scrollTo(we);
					homePage.jSClickOnElement(we);
					list1.add(we.getText());
					// we.click();
				}
			}
		List<String> allTitlelList = new ArrayList<>();
		//SoftAssertions softAssertions = new SoftAssertions();
		int i = -1;
		do {
			i += 1;			
			if (i > 0) {
				WebElementFacade we = linkPage.get(i);
				//homePage.scrollTo(we);
				we.click();
				//homePage.jSClickOnElement(we);
			}
			listTitle = homePage.getLabelsItemList();
			int sizeitems = listTitle.size();
			int sizePage = linkPage.size();
			String page = linkPage.get(i).getText();
			
			if (listTitle.size() > 0) {
				for (String title : listTitle) {
					allTitlelList.add(title);
					// softAssertions.assertThat(title).contains(key);
					// assertThat(key).contains(title);
				}
			}
		} while (i < linkPage.size()-1);
		
		String last = allTitlelList.get(allTitlelList.size() - 1);
		String cString=last;
	}

	@Pending
	@Test
	public void successfulTest() {
		List<String> expectedLabelsList = ImmutableList.of("Espresso", "Espresso with milk", "Latte", "Latte Caramel",
				"Capuccino");
		// open the page on which the elements to test are displayed
		// this is a simple page with basic HTML stored in
		// src/test/resources/htmls/forLists.html
		driver.get(new File("src/test/resources/htmls/forLists.html").getAbsolutePath());
		// compare the list of labels read from the open page with the expected list of
		// labels
		assertEquals(homePage.getLabelsItemList(), expectedLabelsList);
	}
//	webElements.get(1).click();
}
