package definition.tests

import adaptation.baseclass.BaseTest
import adaptation.baseclass.fearless.FearlessBaseAndroid
import org.junit.jupiter.api.Test

class FearlessLoginAndroidTest : BaseTest<FearlessBaseAndroid>() {

    @Test
    fun fearlessAndroidLoginScreen() {
        with(app) {
            loginScreenStepsAndroid.run {
                checkHeader()
                checkElementsAreDisplayed()
                proceedCreateAccount()
            }
            createAccountStepsAndroid.run {
                checkHeader()
                checkElementsAreDisplayed()
                backtoLoginScreen()
            }
            loginScreenStepsAndroid.run {
                checkHeader()
                checkElementsAreDisplayed()
                proceedAccountImport()
            }
        }
    }
}

