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
	public void click_on_login_link() {
		onHomePage.clickLoginLink();
	}

	@Step
	public void enter_search_by_key(String value) {
		onHomePage.searchbykey(value);
	}
	@Step
	public void do_search() {
		onHomePage.dosearch();
	}
	@Step
	public void scroll_to_type_email() {
		onHomePage.scrollToTypeEmail();
	}

	public void click_on_submit_email() {
		onHomePage.jSClickOnSubmitEmail();
	}

	@Step
	public void enter_type_email(String value) {
		onHomePage.jSenterTypeEmail(value);
	}

	@Step
	public void hight_light_email() {
		onHomePage.hightlightTypeEmail();
	}

	@Step
	public void hight_light_submit() {
		onHomePage.hightlightSubmit();
	}

	public void copyText_from_search_key(String value) {
		onHomePage.copyText_from_search_key(value);
	}
	public void cutText_from_search_key(String value) {
		onHomePage.cutText_from_search_key(value);
	}

	public void copyText_by_mouse_from_search_key(String value) {
		onHomePage.open_context_menu_on_search_key(value);
		onHomePage.copy_by_mouse();
	}
}
