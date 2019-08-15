package vn.amabuy;

import org.openqa.selenium.Keys;

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

	public void javascriptClickOnElement(WebElementFacade webElement) {
		evaluateJavascript("arguments[0].click();", webElement);
	}

	public void scrollTo(WebElementFacade webElement) {
		evaluateJavascript("arguments[0].scrollIntoView(true);", webElement);
	}

	public void cutText(WebElementFacade webElement, String value) {

		withAction()
		.moveToElement(webElement)
		.click()
		.keyDown(webElement, Keys.SHIFT)
		.sendKeys(webElement,value)
		.keyUp(webElement,Keys.SHIFT) //goi key down roi phai goi key up de tra lai trang thai nhu ban dau
		.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)//boi den element
		.keyDown(Keys.CONTROL).sendKeys("x").keyUp(Keys.CONTROL)//cat element
		.build()
		.perform();
		
		waitABit(5000);
	}

	public void copyText(WebElementFacade webElement, String value) {
		withAction()
		.moveToElement(webElement)
		.click()
		.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)//boi den element
		.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL)//copy element
		.build()
		.perform();
		
		waitABit(5000);
	}

	public void pasteTextInto(WebElementFacade webElement, String value) {
		withAction()
		.moveToElement(webElement)
		.click()
		.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL)//paste den element
		.build()
		.perform();
		
		waitABit(5000);
	}
}
