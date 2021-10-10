package definition.steps

import adaptation.screens.shared.CreateAccountScreenAndroid
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement

class CreateAccountStepsAndroid(
    override val page: CreateAccountScreenAndroid,
    override val driver: AppiumDriver<MobileElement>?,
    override val platform: String
) :
    TestStep(page, driver, platform) {

    override fun checkHeader() {
        super.checkHeader()
    }
}