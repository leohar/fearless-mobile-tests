package definition.steps

import adaptation.utils.shared.MobilePlatform
import adaptation.screens.shared.CreateAccountScreenAndroid
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement

class CreateAccountStepsAndroid(
    override val page: CreateAccountScreenAndroid,
    override val driver: AppiumDriver<MobileElement>?,
) :
    TestStep(page, driver, MobilePlatform.ANDROID) {

    /** Back button click */
    fun backtoLoginScreen() {
        page.run {
            backBN!!.clickElement("Back button")
        }
    }

    /** Name field text input */
    fun fillUserName() {
        page.run {
            nameET!!.fillTextInput("New user")
        }
    }

    /** Next button click */
    fun proceedToBackupMnemonic() {
        page.run {
            nextBN!!.clickElement("Next")
        }
    }
}