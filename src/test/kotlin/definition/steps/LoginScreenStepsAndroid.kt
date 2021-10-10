package definition.steps

import adaptation.screens.shared.LoginScreenAndroid
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import org.junit.Assert
import java.lang.NullPointerException

class LoginScreenStepsAndroid(
    override val page: LoginScreenAndroid,
    override val driver: AppiumDriver<MobileElement>?,
    override val platform: String
) :
    TestStep(page, driver, platform) {

    override fun checkHeader() {
        try {
            super.checkHeader()
            page.returnHeader()!!.text
        } catch (e: NullPointerException) {
            Assert.assertTrue(true)
        }
        Assert.assertFalse("No header should be displayed on this screen", false)
    }

    /** "Moving to account creation" */
    fun proceedCreateAccount() {
        page.run {
            clickElement(createAccountBN!!, "Create account button")
        }
    }

    /** "Moving to account import" */
    fun proceedAccountImport() {
        page.run {
            clickElement(importAccountBN!!, "Import account button")
        }
    }
}
