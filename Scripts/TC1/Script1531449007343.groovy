import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.firefox.internal.ProfilesIni
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.driver.WebUIDriverType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//WebUI.openBrowser('')

WebUIDriverType executedBrowser = DriverFactory.getExecutedBrowser()
switch(executedBrowser) {
	case WebUIDriverType.FIREFOX_DRIVER:          // "Firefox"
		System.setProperty('webdriver.gecko.driver', DriverFactory.getGeckoDriverPath())
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile FF = profile.getProfile("SeleniumFF");
		FirefoxOptions options = new FirefoxOptions()
			.setProfile(new FirefoxProfile());
		WebDriver driver = new FirefoxDriver(options);
		// let Katalon Studio to use the WebDriver created here
		DriverFactory.changeWebDriver(driver)
		break
}

WebUI.navigateToUrl('http://demoaut.katalon.com/')

WebUI.comment('>>> opened http://demoaut.katalon.com/ in FireFox with profile named SeleniumFF')

WebUI.verifyElementPresent(findTestObject('Page_CURA Healthcare Service/a_Make Appointment'), 10)

WebUI.delay(3)

WebUI.closeBrowser()

