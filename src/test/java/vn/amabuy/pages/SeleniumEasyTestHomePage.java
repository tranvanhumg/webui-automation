package vn.amabuy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import net.bytebuddy.asm.Advice.This;
import net.serenitybdd.core.pages.WebElementFacade;
import vn.amabuy.MyPageObject;

public class SeleniumEasyTestHomePage extends MyPageObject {

	@FindBy(xpath = "//ul[@class='nav navbar-nav']/li[1]")
	WebElementFacade showInputForm;

	@FindBy(xpath = "//ul[@class='nav navbar-nav']/li[1]/ul/li[7]")
	WebElementFacade showJqDropdown;

	@FindBy(xpath = "//ul[@class='nav navbar-nav']/li[2]")
	WebElementFacade showDatePicker;

	@FindBy(xpath = "//ul[@class='nav navbar-nav']/li[3]")
	WebElementFacade showTable;

	@FindBy(xpath = "//ul[@class='nav navbar-nav navbar-right']/li[1]")
	WebElementFacade showProgressbar;

	@FindBy(xpath = "//ul[@class='nav navbar-nav navbar-right']/li[2]")
	WebElementFacade showAlertandModals;

	@FindBy(xpath = "//ul[@class='nav navbar-nav navbar-right']/li[2]/ul/li[5]")
	WebElementFacade showAlertJs;

	@FindBy(xpath = "//ul[@class='nav navbar-nav navbar-right']/li[3]")
	WebElementFacade showListBox;

	@FindBy(xpath = "//ul[@class='nav navbar-nav navbar-right']/li[4]")
	WebElementFacade showOthers;

//	@FindBy(xpath = "//input[@type='search']")
//	WebElementFacade selectStates;

	public void clickShowJsAlertForm() {
		showAlertandModals.click();
		showAlertJs.click();
	}

	public void clickShowJqSelectDopdownForm() {
		showInputForm.click();
		showJqDropdown.click();
	}

	public void enterSelectState(String... states) {
		for (String state : states) {
			element("//input[@type='search']").waitUntilPresent().typeAndEnter(state);
			waitABit(3000);
		}
	}

	public void enterCountry(String country) {
		$("//select[@id='country']").waitUntilPresent().typeAndEnter(country);

	}

	public void enter_US_Outlying_Territories(String territories) {
		element("//select[@class='js-example-disabled-results select2-hidden-accessible']").waitUntilPresent()
				.typeAndEnter(territories);
		waitABit(3000);
	}

	@FindBy(xpath = "//select[@class='js-example-basic-multiple select2-hidden-accessible']")
	WebElementFacade selectSate;

	public void selectState(int... indexs) {
		for (int index : indexs) {
			element("//select[@class='js-example-basic-multiple select2-hidden-accessible']").waitUntilPresent().selectByIndex(index);
			waitABit(3000);
		}
	}

	@FindBy(css = "//span[@id='select2-country-container']")
	WebElementFacade ecountry;

	public void jsSelectCountry(String country) {
		waitABit(3000);
		element("//select[@id='country']").waitUntilPresent().selectByValue(country);
		waitABit(3000);
	}

	public void jsSelect_US_Outlying_Territories(String territories) {
		$("//select[@class='js-example-disabled-results select2-hidden-accessible']").waitUntilClickable()
				.selectByVisibleText(territories);
		waitABit(3000);
	}

	public void scrool_territories() {
		scrollTo($("//select[@class='js-example-disabled-results select2-hidden-accessible']"));
	}
}
