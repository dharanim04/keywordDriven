package hrm.keyworddriven;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Keywords {
	WebDriver driver;
	Actions action;

//	openBrowser
	public void openBrowser(String locType, String locValue, String data) {
		if(data.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", ExcelReader.getFilePath("drivers", "chromedriver.exe"));
		driver = new ChromeDriver();
			
		}else if(data.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ExcelReader.getFilePath("drivers", "geckodriver.exe"));
			driver = new FirefoxDriver();
		}else {
			throw new RuntimeException("browser name "+data+" does not exist");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		action = new Actions(driver);
	}

//	navigate
	public void navigate(String locType, String locValue, String data) {
		driver.get(data);
	}

//	write
	public void write(String locType, String locValue, String data) {
		driver.findElement(LocatorHelper.locate(locType, locValue)).clear();
		driver.findElement(LocatorHelper.locate(locType, locValue)).sendKeys(data);
	}

//	click
	public void click(String locType, String locValue, String data) {
		driver.findElement(LocatorHelper.locate(locType, locValue)).click();
	}

//	wait
	public void wait(String locType, String locValue, String data) {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	moveToElement
	public void moveToElement(String locType, String locValue, String data) {
		action.moveToElement(driver.findElement(LocatorHelper.locate(locType, locValue))).build().perform();
	}

//	moveToEleAndClick
	public void moveToEleAndClick(String locType, String locValue, String data) {
		action.moveToElement(driver.findElement(LocatorHelper.locate(locType, locValue))).click().build().perform();
	}

//	switchToFrame
	public void switchToFrame(String locType, String locValue, String data) {
		driver.switchTo().frame(driver.findElement(LocatorHelper.locate(locType, locValue)));
	}

//	select
	public void select(String locType, String locValue, String data) {
		new Select(driver.findElement(LocatorHelper.locate(locType, locValue))).selectByVisibleText(data);
	}

//	switchToDefaultContent
	public void switchToDefaultContent(String locType, String locValue, String data) {
		driver.switchTo().defaultContent();
	}

//	closeBrowser
	public void closeBrowser(String locType, String locValue, String data) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
	
//	acceptAlert
	public void acceptAlert(String locType, String locValue, String data) {
		driver.switchTo().alert().accept();
	}


}
