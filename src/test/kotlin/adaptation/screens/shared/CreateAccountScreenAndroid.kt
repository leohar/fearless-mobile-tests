package adaptation.screens.shared

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.support.PageFactory

class CreateAccountScreenAndroid(driver: AppiumDriver<MobileElement>?): BaseScreen {

    override val expectedHeaderAndroid: String = "Create account"
    override val expectedHeaderiOS: String = ""

    @AndroidFindBy(id = "jp.co.soramitsu.fearless.debug:id/titleTv")
    var titleTV: MobileElement? = null

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ImageView\n")
    var backBN:  MobileElement? = null

    @AndroidFindBy(id = "jp.co.soramitsu.fearless.debug:id/networkInput")
    var networkSN: MobileElement? = null

    @AndroidFindBy(id = "jp.co.soramitsu.fearless.debug:id/inputField")
    var nameET: MobileElement? = null

    @AndroidFindBy(id = "jp.co.soramitsu.fearless.debug:id/nextBtn")
    var nextBN: MobileElement? = null

    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), this)
    }

    override fun returnHeader(): MobileElement? {
        return titleTV
    }

    override fun returnElements(): List<Pair<MobileElement?, String>> {
        return listOf(
            Pair(titleTV, "Title"),
            Pair(backBN, "Back button"),
            Pair(networkSN, "Network selection"),
            Pair(nameET, "Name input"),
            Pair(nextBN, "Next button")
        )
    }
}