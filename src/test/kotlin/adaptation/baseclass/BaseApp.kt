package adaptation.baseclass

import adaptation.baseclass.fearless.FearlessBaseAndroid
import adaptation.utils.shared.MobilePlatform
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement

/**
 * Base abstract application class
 */
open class BaseApp {

    fun createApp(product: String, driver: AppiumDriver<MobileElement>, platform: MobilePlatform): BaseApp {
        when (product) {
            //"CommonProductApp" -> return CommonProductAppBase(driver, platform)
            "Fearless" -> {
                when (platform) {
                    MobilePlatform.ANDROID -> return FearlessBaseAndroid(driver)
                    MobilePlatform.IOS -> TODO()
                }
            }
            else -> throw IllegalArgumentException("Unknown app")
        }
    }
}

