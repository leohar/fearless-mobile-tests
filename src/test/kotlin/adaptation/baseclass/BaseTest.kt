package adaptation.baseclass

import adaptation.utils.shared.MobilePlatform
import adaptation.utils.shared.appium.DevicesConfigurator
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import java.lang.Exception
import java.net.MalformedURLException
import java.util.concurrent.TimeUnit

/**
 * Base test class
 */

open class BaseTest <T: BaseApp>{
    private var driver = ThreadLocal<AppiumDriver<MobileElement>>()
    lateinit var platformRunAs: MobilePlatform
    var productName: String = ""
    lateinit var app: T
    val product = System.getProperty("product")
    val devices = System.getProperty("devices")

    @BeforeEach
    @Throws(MalformedURLException::class)
    fun setup() {
        var androidPath: String = ""
        var iOSPath: String = ""
        var bundleId: String = ""
        when (product) {
            "Fearless" -> {
                androidPath = "/Users/lpatolya/Desktop/app-debug.apk"
                iOSPath = "/Users/.../app-_debug.ipa"
                bundleId = "jp.co.soramitsu.fearless"
                productName = "Fearless"
            }
//            "CommonProductApp" -> {
//                androidPath = "/Users/.../app-_debug.apk"
//                iOSPath = "/Users/.../app-_debug.ipa"
//                bundleId = "com.commonproduct.test"
//                productName = "CP"
//            }
        }
        when (devices) {
            "Redmi9T" -> {
                driver.set(
                    DevicesConfigurator().configDriver(
                        deviceName = "Redmi 9T", appPath = androidPath, bundleId = ""
                    )
                )
                platformRunAs = MobilePlatform.ANDROID
            }
            "iPhone Emulator" -> {
                driver.set(
                    DevicesConfigurator().configDriver(
                        deviceName = "iPhone Emulator", appPath = iOSPath, bundleId = bundleId
                    )
                )
                platformRunAs = MobilePlatform.IOS
            }
            "Android Emulator" -> {
                driver.set(
                    DevicesConfigurator().configDriver(
                        deviceName = "Android Emulator", appPath = androidPath, bundleId = ""
                    )
                )
                platformRunAs = MobilePlatform.ANDROID
            }
        }
        driver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS)
        app = BaseApp().createApp(productName, driver.get(), platformRunAs) as T
    }

    @AfterEach
    fun tearDown() {
        this.driver.get().quit() ?: throw Exception ("Driver instance was unable to quit.")
    }

    fun getDriver(): AppiumDriver<MobileElement>? {
        return driver.get()
    }
}
