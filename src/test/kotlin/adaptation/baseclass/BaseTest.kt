package adaptation.baseclass

import adaptation.utils.shared.appium.DevicesConfigurator
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.runners.Parameterized
import java.net.MalformedURLException
import java.util.concurrent.TimeUnit

/**
 * Base test class
 */

open class BaseTest {
    var driver = ThreadLocal<AppiumDriver<MobileElement>>()
    var platformRunAs: String = ""
    var productName: String = ""
    lateinit var app: BaseApp
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
            "Redmi 9T" -> {
                driver.set(
                    DevicesConfigurator().configDriver(
                        deviceName = "Redmi 9T", appPath = androidPath, bundleId = ""
                    )
                )
                platformRunAs = "Android"
            }
            "iPhone Emulator" -> {
                driver.set(
                    DevicesConfigurator().configDriver(
                        deviceName = "iPhone Emulator", appPath = iOSPath, bundleId = bundleId
                    )
                )
                platformRunAs = "iOSX"
            }
            "Android Emulator" -> {
                driver.set(
                    DevicesConfigurator().configDriver(
                        deviceName = "Android Emulator", appPath = androidPath, bundleId = ""
                    )
                )
                platformRunAs = "Android"
            }
        }
        driver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS)
        app = BaseApp().createApp(productName, driver.get(), platformRunAs)
    }

    @AfterEach
    fun tearDown() {
        this.driver?.get().quit()
    }

    fun getDriver(): AppiumDriver<MobileElement>? {
        return driver.get()
    }
}
