package vn.amabuy.features.function;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import vn.amabuy.steps.UploadFileSteps;

@RunWith(SerenityRunner.class)
public class WhenUploadFile {
	
	@Managed
	WebDriver driver;
	
	@Steps
	UploadFileSteps onUploadFileSteps;
	
	@Test
	@WithTag("upload")
	public void uploadFile() {
		String pathFile = "C:\\Users\\tranv\\Desktop\\Untitled.png";
		onUploadFileSteps.open();
		onUploadFileSteps.upload_file(pathFile);
		onUploadFileSteps.submit();
		onUploadFileSteps.checkMessage("successfully");
	}
	
}
