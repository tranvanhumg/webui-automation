package vn.amabuy.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import vn.amabuy.MyPageObject;

public class UploadPage extends MyPageObject {

	@FindBy(xpath = "//div[@id='file_wraper0']")
	WebElementFacade uploadfile_0;
	public void choseUploadOn(String pathFile) {
	
		uploadFile(pathFile);
	}
	public void clickBrowse() {

		uploadfile_0.click();
	}
	WebElementFacade submitbutton;
	public void submitForm() {
		submitbutton.click();
	}
	
	//("//h3[@id='res']")
	WebElementFacade res;
	public String getMessageUpload() {
		return res.getText();
	}
}
