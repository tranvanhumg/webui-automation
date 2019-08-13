package vn.amabuy;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class MyPageObject extends PageObject {

	public void highlightElement(WebElementFacade webElement ) {
		for(int i=0;i<10;i++)
		{
			evaluateJavascript("arguments[0].setAttribute('style',arguments[1]);",webElement,
					"color:red;border:2px soild red;");
			evaluateJavascript("arguments[0].setAttribute('style',arguments[1]);",webElement,"");
		}
	}
	
	
}
