package definition.steps

import adaptation.screens.shared.BaseScreen
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import org.junit.Assert

/**
 * Base step class
 */
abstract class TestStep(
    open val page: BaseScreen,
    open val driver: AppiumDriver<MobileElement>?,
    open val platform: String
) {
    /**
     * check header
     * */
    open fun checkHeader() {
        val result = page.returnHeader()!!.text
        val expected = if (platform == "Android") {
            page.expectedHeaderAndroid
        } else {
            page.expectedHeaderiOS
        }
        Assert.assertTrue(result == expected)
    }

    /**
     * check element is displayed
     * */
    fun checkElementIsDisplayed(element: MobileElement, elementName: String) {
        Assert.assertTrue(element.isDisplayed)
    }

    /**
     * Check elements are displayed
     * */
    open fun checkElementsAreDisplayed() {
        page.returnElements()!!.forEach {
            checkElementIsDisplayed(it.first!!, it.second)
        }
    }

    /**
     * Click element
     */
    fun clickElement(element: MobileElement, elementName: String = "Element") {
            element.click()
    }

    /**
     * Text input
     */
    fun fillTextInput(element: MobileElement, text: String) {
            element.run {
                click()
                clear()
                sendKeys(text)
            }
    }
}
