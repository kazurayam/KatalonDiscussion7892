import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.driver.WebUIDriverType
import org.openqa.selenium.firefox.internal.ProfilesIni
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.firefox.FirefoxProfile

WebUIDriverType executedBrowser = DriverFactory.getExecutedBrowser()
switch(executedBrowser) {
	case WebUIDriverType.FIREFOX_DRIVER:          // "Firefox"
		System.setProperty('webdriver.gecko.driver', DriverFactory.getGeckoDriverPath())
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile FF = profile.getProfile(firefoxProfile);
		FirefoxOptions options = new FirefoxOptions()
			.setProfile(new FirefoxProfile());
		WebDriver driver = new FirefoxDriver(options);
		// let Katalon Studio to use the WebDriver created here
		DriverFactory.changeWebDriver(driver)
		break
}

WebUI.navigateToUrl('http://demoaut.katalon.com/')

WebUI.comment(">>> opened http://demoaut.katalon.com/ in FireFox with profile named ${firefoxProfile}")

WebUI.verifyElementPresent(findTestObject('Page_CURA Healthcare Service/a_Make Appointment'), 10)

WebUI.delay(3)

WebUI.closeBrowser()

