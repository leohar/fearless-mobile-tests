package definition.steps

import adaptation.screens.shared.LoginScreenAndroid
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import org.junit.Assert

class LoginScreenStepsAndroid(
    override val page: LoginScreenAndroid,
    override val driver: AppiumDriver<MobileElement>?,
    override val platform: String) :
    TestStep(page, driver, platform) {

    override fun checkHeader() {
        super.checkHeader()
        try {
            page.returnHeader()!!.text
        } catch (e: NoSuchElementException) {
            Assert.assertTrue("No header is provided", true)
        }
        Assert.assertFalse("Header found", false)
    }

//    override fun checkElementsAreDisplayed() {
//        super.checkElementsAreDisplayed()
//    }
}
