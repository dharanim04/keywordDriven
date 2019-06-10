package hrm.keyworddriven;

import org.openqa.selenium.By;

public class LocatorHelper {
	protected static By locate(String locType, String locValue) {
		By by = null;
		locType = locType.toLowerCase();
		switch (locType) {
		case "id":
			by = By.id(locValue);
			break;
		case "name":
			by = By.name(locValue);
			break;
		case "linktext":
			by = By.linkText(locValue);
			break;
		case "partiallinktext":
			by = By.partialLinkText(locValue);
			break;
		case "xpath":
			by = By.xpath(locValue);
			break;
		case "cssselector":
			by = By.cssSelector(locValue);
			break;
		default:
			throw new RuntimeException("locator type " + locType + " is not valid");
		}

		return by;

	}
}
