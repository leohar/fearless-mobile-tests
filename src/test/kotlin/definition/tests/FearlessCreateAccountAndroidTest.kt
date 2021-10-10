package definition.tests

import adaptation.baseclass.BaseTest
import adaptation.baseclass.fearless.FearlessBaseAndroid
import org.junit.jupiter.api.Test

class FearlessCreateAccountAndroidTest : BaseTest<FearlessBaseAndroid>() {

    @Test
    fun fearlessAndroidCreateAccountScreen() {
        with(app) {
            loginScreenStepsAndroid.run {
                proceedCreateAccount()
            }
            createAccountStepsAndroid.run {
                checkHeader()
                checkElementsAreDisplayed()
            }
        }
    }
}