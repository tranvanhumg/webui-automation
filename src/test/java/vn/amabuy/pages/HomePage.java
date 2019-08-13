package vn.amabuy.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import vn.amabuy.MyPageObject;

public class HomePage extends MyPageObject{

	@FindBy(xpath = "//a[@href='/login']")
	WebElementFacade loginLink;
	public void clickLoginLink() {
		highlightElement(loginLink);
		loginLink.click();
	}	
}
