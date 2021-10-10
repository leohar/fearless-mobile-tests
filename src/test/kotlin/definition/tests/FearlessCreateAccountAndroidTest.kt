package definition.tests

import adaptation.baseclass.BaseTest
import adaptation.baseclass.fearless.FearlessBase
import org.junit.jupiter.api.Test

class FearlessCreateAccountAndroidTest : BaseTest() {

    @Test
    fun fearlessAndroidCreateAccountScreen() {
        with(app as FearlessBase) {
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