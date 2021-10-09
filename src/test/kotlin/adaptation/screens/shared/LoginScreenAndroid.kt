package adaptation.screens.shared

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.support.PageFactory

/**
 * Login screen
 */
class LoginScreenAndroid(driver: AppiumDriver<MobileElement>?): BaseScreen {

    override val expectedHeaderAndroid: String = ""
    override val expectedHeaderiOS: String = ""
    var titleTV: MobileElement? = null

    @AndroidFindBy(id = "logoimg")
    var welcomeLogoIMG: MobileElement? = null

    @AndroidFindBy(id = "createAccountBtn")
    var createAccountBN: MobileElement? = null

    @AndroidFindBy(id = "importAccountBtn")
    var importAccountBN: MobileElement? = null

    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), this)
    }

    override fun returnHeader(): MobileElement? {
        return titleTV
    }
}

