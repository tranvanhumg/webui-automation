package vn.amabuy.steps;

import static com.google.common.truth.Truth.*;

import org.fluentlenium.core.annotation.Page;

import net.thucydides.core.annotations.Step;
import vn.amabuy.pages.UploadPage;

public class UploadFileSteps {
	@Page
	UploadPage onUploadPage;

	@Step
	public void open() {
		onUploadPage.open();
	}

	@Step
	public void upload_file(String pathFile) {
		onUploadPage.clickBrowse();
		onUploadPage.choseUploadOn(pathFile);
	}
	@Step
	public void checkMessage(String expectMs) {
	 String actualMs = onUploadPage.getMessageUpload();
	 assertThat(actualMs).contains(expectMs);
	}
	@Step
	public void submit() {
	 onUploadPage.submitForm();
	}
}
