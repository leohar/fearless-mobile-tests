package definition.steps

import adaptation.utils.shared.MobilePlatform
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
    open val platform: MobilePlatform
) {
    /**
     * check header
     * */
    open fun checkHeader() {
        val result = page.returnHeader()!!.text
        val expected = when (platform) {
            MobilePlatform.ANDROID -> page.expectedHeaderAndroid
            MobilePlatform.IOS -> page.expectedHeaderiOS
        }
        Assert.assertTrue(result == expected)
    }

    /**
     * check element is displayed
     * */
    fun MobileElement.checkElementIsDisplayed(elementName: String) {
        println("Check $elementName is displayed")
        Assert.assertTrue(this.isDisplayed)
    }

    /**
     * Check elements are displayed
     * */
    open fun checkElementsAreDisplayed() {
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
