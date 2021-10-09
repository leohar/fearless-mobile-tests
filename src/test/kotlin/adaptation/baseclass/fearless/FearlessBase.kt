package adaptation.baseclass.fearless

import adaptation.baseclass.BaseApp
import adaptation.screens.shared.LoginScreenAndroid
import definition.steps.LoginScreenStepsAndroid
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement


/**
 * All app screens and steps initialization
 */

class FearlessBase(driver: AppiumDriver<MobileElement>, platformRunAs: String) : BaseApp() {

    var loginScreenAndroid = LoginScreenAndroid(driver)
    var loginScreenStepsAndroid = LoginScreenStepsAndroid(loginScreenAndroid, driver, platformRunAs)

//    var loginScreenIOS = LoginScreeniOS(driver)
//    var loginScreenStepsIOS = LoginScreenStepsIOS(loginScreenIOS, driver, platformRunAs)
    //TODO CreateAccountScreen

    //TODO SetPINScreen

    //TODO WalletScreen

    //TODO CrowdloansScreen

    //TODO StakingScreen

    //TODO SettingsScreen
}

