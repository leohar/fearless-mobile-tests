package adaptation.baseclass

import adaptation.utils.shared.appium.DevicesConfigurator
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import org.junit.AfterClass
import org.junit.BeforeClass
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


    @BeforeClass
    @Throws(MalformedURLException::class)
    fun setup(devices: String) {
        var androidPath: String = ""
        var iOSPath: String = ""
        var bundleId: String = ""

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

    @AfterClass
    fun tearDown() {
        driver!!.get().quit()
    }

    fun getDriver(): AppiumDriver<MobileElement>? {
        return driver.get()
    }
}
