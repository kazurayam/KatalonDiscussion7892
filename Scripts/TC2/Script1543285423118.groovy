import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

/*
WebUI.callTestCase(findTestCase('Test Cases/worker'),
	['firefoxProfile':'usualProfile'])

WebUI.callTestCase(findTestCase('Test Cases/worker'),
	['firefoxProfile':'seleniumProfile'])
 */


def data = findTestData('FirefoxProfiles')

List<List<Object>> allData = data.getAllData() 

for (List<Object> lst : allData) {
	WebUI.callTestCase(findTestCase('Test Cases/worker'),
		['firefoxProfile': lst.get(0)])
}

