package vn.amabuy.steps;

import org.fluentlenium.core.annotation.Page;

import net.thucydides.core.annotations.Step;
import vn.amabuy.pages.AlertPage;

public class AlertSteps {
	@Page
	AlertPage onAlertPage;

	@Step
	public void open_web() {
		onAlertPage.open();
	}
	
	@Step
	public void show_alert() {
		onAlertPage.click_show_alert();
	}
	
	@Step
	public void show_confirm() {
		onAlertPage.click_show_Confirm();
	}
	
	@Step
	public void show_popup() {
		onAlertPage.click_show_Popup();
	}
	@Step
	public void accept() {
		onAlertPage.accept_popup();
	}

	@Step
	public void cancel() {
		onAlertPage.cancel_popup();
	}

	@Step
	public void answer(String answer) {
		onAlertPage.answer_popup(answer);
	}
	
	@Step
	public void wait_alert() {
		onAlertPage.wait_For_Alert();
	}
}
