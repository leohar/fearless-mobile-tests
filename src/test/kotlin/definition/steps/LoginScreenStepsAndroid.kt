package definition.steps

import adaptation.utils.shared.MobilePlatform
import adaptation.screens.shared.LoginScreenAndroid
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement

class LoginScreenStepsAndroid(
    override val page: LoginScreenAndroid,
    override val driver: AppiumDriver<MobileElement>?
) :
    TestStep(page, driver, MobilePlatform.ANDROID) {

    override fun checkHeader() {
        page.titleTV!!.checkElementIsNotDisplayed()
    }

    /** "Moving to account creation" */
    fun proceedCreateAccount() {
        page.run {
            createAccountBN!!.clickElement("Create account button")
        }
    }

    /** "Moving to account import" */
    fun proceedAccountImport() {
        page.run {
            importAccountBN!!.clickElement("Import account button")
        }
    }
}
