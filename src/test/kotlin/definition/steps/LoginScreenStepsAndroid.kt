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
        val result = page.returnHeader()!!.text
        val expected = null
        Assert.assertTrue("No header is provided",result == expected)
    }

//    override fun checkElementsAreDisplayed() {
//        super.checkElementsAreDisplayed()
//    }
}
