package adaptation.screens.shared

import io.appium.java_client.MobileElement

/**
 * Base screen
 */
interface BaseScreen {

    val expectedHeaderAndroid: String
    val expectedHeaderiOS: String

    fun returnHeader(): MobileElement? {
        return null
    }
}
