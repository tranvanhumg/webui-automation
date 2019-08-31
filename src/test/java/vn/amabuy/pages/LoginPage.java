package vn.amabuy.pages;

import jnr.ffi.Struct.int16_t;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import vn.amabuy.MyPageObject;

public class LoginPage extends MyPageObject {

	@FindBy(xpath = "//a[@href='/register']")
	WebElementFacade registerLink;
	public void clickOnRegisterLink() {
		registerLink.click();
	}
	
	@FindBy(xpath = "//input[@class='form-control'][@placeholder='Email hoặc số điện thoại']")
	WebElementFacade emailField;
	public void enterEmailField(String email) {
		emailField.type(email);
	}
	
	@FindBy(xpath = "//input[@class='form-control'][@placeholder='Mật khẩu']")
	WebElementFacade passwordField;
	public void enterPassword(String pwd) {
		passwordField.type(pwd);
	}
	
	public void pasteEmail() {
		pasteTextInto(emailField);	
		waitABit(3000);
	}
	
	@FindBy(xpath = "//button[@class='btn btn-login']")
	WebElementFacade loginBt;
	public void clickLogin() {
		loginBt.click();
	}

	public void open_context_menu_on_email() {
		openContextMenu(emailField);
		waitABit(3000);
	}
	public void pasteByMouse(int index) {
		pressItemOnContextMenu(index);
	}
}
