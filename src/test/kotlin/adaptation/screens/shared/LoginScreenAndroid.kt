package adaptation.screens.shared

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.support.PageFactory

/**
 * Login screen
 */
class LoginScreenAndroid(driver: AppiumDriver<MobileElement>?) : BaseScreen {

    override val expectedHeaderAndroid: String = ""
    override val expectedHeaderiOS: String = ""

    @AndroidFindBy(id = "jp.co.soramitsu.fearless.debug:id/titleTv")
    var titleTV: MobileElement? = null

    @AndroidFindBy(id = "jp.co.soramitsu.fearless.debug:id/logoImg")
    var welcomeLogoIMG: MobileElement? = null

    @AndroidFindBy(id = "jp.co.soramitsu.fearless.debug:id/createAccountBtn")
    var createAccountBN: MobileElement? = null

    @AndroidFindBy(id = "jp.co.soramitsu.fearless.debug:id/importAccountBtn")
    var importAccountBN: MobileElement? = null

    @AndroidFindBy(id = "jp.co.soramitsu.fearless.debug:id/termsTv")
    var termsLK: MobileElement? = null

    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), this)
    }

    override fun returnHeader(): MobileElement? {
        return null
    }

    override fun returnElements(): List<Pair<MobileElement?, String>> {
        return listOf(
            Pair(welcomeLogoIMG, "Welcome logo"),
            Pair(createAccountBN, "Create account button"),
            Pair(importAccountBN, "Import account button"),
            Pair(termsLK, "Terms links")
        )
    }
}

