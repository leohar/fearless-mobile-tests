package adaptation.baseclass.fearless

import adaptation.baseclass.BaseApp
import adaptation.screens.shared.CreateAccountScreenAndroid
import adaptation.screens.shared.LoginScreenAndroid
import definition.steps.CreateAccountStepsAndroid
import definition.steps.LoginScreenStepsAndroid
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement


/**
 * All app screens and steps initialization
 */

class FearlessBaseAndroid(driver: AppiumDriver<MobileElement>) : BaseApp() {

    var loginScreenAndroid = LoginScreenAndroid(driver)
    var loginScreenStepsAndroid = LoginScreenStepsAndroid(loginScreenAndroid, driver)

//    var loginScreenIOS = LoginScreeniOS(driver)
//    var loginScreenStepsIOS = LoginScreenStepsIOS(loginScreenIOS, driver, platformRunAs)

    var createAccountScreenAndroid = CreateAccountScreenAndroid(driver)
    var createAccountStepsAndroid = CreateAccountStepsAndroid(createAccountScreenAndroid, driver)

    //TODO SetPINScreen

    //TODO WalletScreen

    //TODO CrowdloansScreen

    //TODO StakingScreen

    //TODO SettingsScreen
}

