package adaptation.baseclass

import adaptation.baseclass.fearless.FearlessBase
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement

/**
 * Base abstract application class
 */
open class BaseApp {

    fun createApp(product: String, driver: AppiumDriver<MobileElement>, platform: String): BaseApp {
        when (product) {
            //"AnyOtherApp" -> return AnyOtherAppBase(driver, platform)
            "Fearless" -> return FearlessBase(driver, platform)
        }
        return adaptation.baseclass.BaseApp()
    }
}
