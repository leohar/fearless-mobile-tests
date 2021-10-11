package definition.steps

import adaptation.utils.shared.MobilePlatform
import adaptation.screens.shared.BaseScreen
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement

/**
 * Base step class
 */
abstract class TestStep(
    open val page: BaseScreen,
    open val driver: AppiumDriver<MobileElement>?,
    open val platform: MobilePlatform
) {
    /**
     * Check header
     * */
    open fun checkHeader() {
        println("Check header is displayed")
        val result = page.returnHeader()!!.text
        val expected = when (platform) {
            MobilePlatform.ANDROID -> page.expectedHeaderAndroid
            MobilePlatform.IOS -> page.expectedHeaderiOS
        }
        assert(result == expected)
    }

    /**
     * Check element is displayed
     * */
    fun MobileElement.checkElementIsDisplayed(elementName: String) {
        println("Check $elementName is displayed")
        assert(this.isDisplayed)
    }

    /**
     * Check elements are displayed
     * */
    open fun checkElementsAreDisplayed() {
        println("Check screen elements are displayed")
        page.returnElements()!!.forEach {
            it.first!!.checkElementIsDisplayed(it.second)
        }
    }

    /**
     * Click element
     */
    fun MobileElement.clickElement(elementName: String = "Element") {
        println("Click $elementName")
        this.click()
    }

    /**
     * Text input
     */
    fun MobileElement.fillTextInput(text: String) {
        println("Input $text")
        this.run {
            click()
            clear()
            sendKeys(text)
        }
    }

    fun MobileElement.checkElementIsNotDisplayed() {
        println("Check element is not displayed")
        try {
            this.isDisplayed
        } catch (e: Exception) {
            when (e) {
                is org.openqa.selenium.NoSuchElementException -> return
                else -> throw e
            }
        }
    }
}
