package adaptation.utils.shared.appium

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.remote.AndroidMobileCapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL

/**
 * Drivers capability configurator
 */
class DevicesConfigurator {

    /**
     * Creating capability
     */
    fun generateCapability(
        platformName: String,
        systemPort: String = "",
        udid: String?,
        appPath: String,
        bundleId: String? = "",
        xcodeOrgId: String? = "",
        xcodeSigningId: String? = "",
        deviceName: String = "",
        platformVersion: String = "",
        wdaLocalPort: String? = ""
    ): DesiredCapabilities {

        val cap = DesiredCapabilities()
        cap.setCapability("platformName", platformName)
        cap.setCapability("udid", udid)
        cap.setCapability("app", appPath)
        cap.setCapability("deviceName", platformName)
        cap.setCapability("adbExecTimeout", 60000)
        cap.setCapability("autoGrantPermissions", "true")
        cap.setCapability("autoAcceptAlerts", "true")
        if (platformName == "Android") {
            cap.setCapability("automationName", "UiAutomator2")
            cap.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, systemPort)
        } else if (platformName == "iOS") {
            cap.setCapability("automationName", "XCUITest")
            cap.setCapability("bundleId", bundleId)
            cap.setCapability("xcodeSingingId", xcodeSigningId)
            cap.setCapability("xcodeOrgId", xcodeOrgId)
            cap.setCapability("deviceName", deviceName)
            cap.setCapability("platformVersion", platformVersion)
            cap.setCapability("wdaLocalPort", wdaLocalPort)
            cap.setCapability("useNewWDA", "false")
            cap.setCapability("usePrebuiltWDA", "true")
            cap.setCapability("derivedDataPath", "/Users/...")
        }
        return cap
    }

    /**
     * Driver configurations
     */
    fun configDriver(deviceName: String, appPath: String = "", bundleId: String): AppiumDriver<MobileElement>? {
        when (deviceName) {
            "Redmi 9T" -> {
                return AppiumDriver<MobileElement>(
                    URL("http://127.0.0.1:4732/wd/hub"),
                    generateCapability(
                        platformName = "Android",
                        systemPort = "8203",
                        udid = "d6b9a1fd0820",
                        appPath = appPath
                    )
                )
            }
            "iPhone Emulator" -> {
                return AppiumDriver<MobileElement>(
                    URL("http://127.0.0.1:4730/wd/hub"),
                    generateCapability(
                        platformName = "iOS",
                        udid = null,
                        appPath = appPath,
                        bundleId = bundleId,
                        xcodeOrgId = null,
                        xcodeSigningId = null,
                        deviceName = "iPhone Emulator",
                        platformVersion = "13.1",
                        wdaLocalPort = null
                    )
                )
            }
            "Android Emulator" -> {
                return AppiumDriver<MobileElement>(
                    URL("http://127.0.0.1:4723/wd/hub"),
                    generateCapability(
                        platformName = "Android",
                        systemPort = "8201",
                        udid = "emulator-5554",
                        appPath = appPath
                    )
                )
            }
        }
        return null
    }
}
