package vn.amabuy.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import net.serenitybdd.core.pages.WebElementFacade;
import vn.amabuy.MyPageObject;

public class HomePage extends MyPageObject {

	@FindBy(xpath = "//a[@href='/login']")
	WebElementFacade loginLink;

	public void clickLoginLink() {
		highlightElement(loginLink);
		loginLink.click();
	}

	WebElementFacade searchKeyword;

	public void searchbykey(String value) {
		searchKeyword.type(value);
	}

	@FindBy(xpath = "//button[@onclick='doSearch();']")
	WebElementFacade searchbt;

	public void dosearch() {
		searchbt.click();
	}

	@FindBy(xpath = "//input[@type='email']")
	WebElementFacade typeEmail;

	public void scrollToTypeEmail() {
		scrollTo(typeEmail);
		waitABit(3000);
	}

	public void jSenterTypeEmail(String value) {
		jSClickOnElement(typeEmail);
		typeEmail.type(value);
	}

	@FindBy(xpath = "//button[@type='submit']")
	WebElementFacade submitEmail;

	public void jSClickOnSubmitEmail() {
		jSClickOnElement(submitEmail);
	}

	public void hightlightTypeEmail() {
		highlightElement(typeEmail);
	}

	public void hightlightSubmit() {
		highlightElement(submitEmail);
	}

	public void copyText_from_search_key(String value) {
		copyText(searchKeyword, value);
		waitABit(3000);
	}

	public void cutText_from_search_key(String value) {
		cutText(searchKeyword, value);
		waitABit(3000);
	}

	public void open_context_menu_on_search_key(String value) {
		openContextMenuOnElement(searchKeyword, value);
	}

	public void copy_by_mouse() {
		pressItemOnContextMenu(3);
	}

	@FindAll({
			@FindBy(how = How.XPATH, using = "//div[@id='amazon_main']/div/div[@class='col-sm-6 col-lg-3']/div/h5/a") })
	private List<WebElementFacade> result_items;

	@FindBy(how = How.XPATH, using = "//a[@class='more_prod']")
	public List<WebElementFacade> view_more_item;

	@FindBy(how = How.XPATH, using = "//div[@class='page_pagination']/ul/li")
	public List<WebElementFacade> page_pagination;

	public List<String> getLabelsItemList() {
		// create an empty list in which the label texts will be stored
		List<String> labelsList = new ArrayList<>();
		// iterate through all the webElements
		for (WebElementFacade webElement : result_items) {
			// add each webElements label to the labelsList
			labelsList.add(webElement.getText());
		}
		// return all the label texts that are visible in the dropdown
		return labelsList;
	}

	public List<WebElementFacade> getLinkViewMoreItemList() {
		// create an empty list in which the label texts will be stored
		List<WebElementFacade> ListItem = new ArrayList<>();
		// iterate through all the webElements
		for (WebElementFacade webElement : view_more_item) {
			// add each webElements label to the labelsList
			ListItem.add(webElement);
		}
		// return all the label texts that are visible in the dropdown
		return ListItem;
	}
	
}
