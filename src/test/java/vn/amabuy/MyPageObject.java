package vn.amabuy;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class MyPageObject extends PageObject {

	public void highlightElementMore(WebElementFacade webElement) {
		for (int i = 0; i < 10; i++) {
			evaluateJavascript("arguments[0].setAttribute('style', arguments[1]);", webElement,
					"color: red; border: 2px solid red;");
			evaluateJavascript("arguments[0].setAttribute('style',arguments[1]);", webElement, "");
		}
	}

	public void highlightElement(WebElementFacade webElement) {

		evaluateJavascript("arguments[0].setAttribute('style', arguments[1]);", webElement,
				"color: red; border: 2px solid red;");
	}

	public void unHightlightElement(WebElementFacade webElement) {
		evaluateJavascript("arguments[0].setAttribute('style', arguments[1]);", webElement, "");
	}

	public void jSClickOnElement(WebElementFacade webElement) {
		evaluateJavascript("arguments[0].click();", webElement);
	}

	public void scrollTo(WebElementFacade webElement) {
		evaluateJavascript("arguments[0].scrollIntoView(true);", webElement);
	}
	public void scrollTo(WebElement webElement) {
		evaluateJavascript("arguments[0].scrollIntoView(true);", webElement);
	}
	public void cutText(WebElementFacade webElement, String value) {

		withAction().moveToElement(webElement).click()
				// .keyDown(webElement, Keys.SHIFT)
				.sendKeys(webElement, value).keyUp(webElement, Keys.SHIFT) // goi key down roi phai goi key up de tra
																			// lai trang thai nhu ban dau
				.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)// boi den element
				.keyDown(Keys.CONTROL).sendKeys("x").keyUp(Keys.CONTROL)// cat element
				.build().perform();
	}

	public void copyText(WebElementFacade webElement, String value) {
		withAction().moveToElement(webElement).click().sendKeys(webElement, value).keyDown(Keys.CONTROL).sendKeys("a")
				.keyUp(Keys.CONTROL)// boi den element
				.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL)// copy element
				.build().perform();
	}

	public void pasteTextInto(WebElementFacade webElement) {// , String value
		withAction().moveToElement(webElement).click().keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL)// paste
																												// den
																												// element
				.build().perform();
	}

	public void openContextMenuOnElement(WebElementFacade webElement, String value) {
		withAction().moveToElement(webElement).click().sendKeys(webElement, value).keyDown(Keys.CONTROL).sendKeys("a")
				.keyUp(Keys.CONTROL)// boi den element
				.contextClick().build().perform();
	}

	public void openContextMenu(WebElementFacade webElement) {
		withAction().moveToElement(webElement).click().contextClick().build().perform();
	}

	public void pressItemOnContextMenu(int indexItem) {
		Robot robot;
		try {
			robot = new Robot();
			robot.setAutoDelay(500);
			for (int i = 1; i <= indexItem; i++) {
				robot.keyPress(java.awt.event.KeyEvent.VK_DOWN);
			}
			robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public void setClipboardData(String fileLocation) {
		StringSelection stringSelection = new StringSelection(fileLocation); // chon duong dan
		waitABit(3000);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null); // copy vao clipboard
	}

	public void uploadFile(String fileLocation) {
		Robot robot;
		try {
			setClipboardData(fileLocation);
			robot = new Robot();
			robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
			robot.keyPress(java.awt.event.KeyEvent.VK_V);
			robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
			robot.keyRelease(java.awt.event.KeyEvent.VK_V);
			waitABit(3000);
			robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
			robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);

		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public static String getJsonDocumentFromUrl(String url) throws IOException {

		BufferedReader inputStream = null;

		URL jsonUrl = new URL(url);
		URLConnection dc = jsonUrl.openConnection();

		dc.setConnectTimeout(5000);
		dc.setReadTimeout(5000);

		inputStream = new BufferedReader(new InputStreamReader(dc.getInputStream()));
		// read the JSON results into a string
		String jsonResult = inputStream.readLine();
		return jsonResult;
	}
	
	public void findElement(String xpath) {
		
	}
}
