package vn.amabuy.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import vn.amabuy.MyPageObject;

public class LoginPage extends MyPageObject {

	@FindBy(xpath = "//a[@href='/register']")
	WebElementFacade registerLink;
	public void clickOnRegisterLink() {
		registerLink.click();
	}
}
