package definition.tests

import adaptation.baseclass.BaseTest
import adaptation.baseclass.fearless.FearlessBaseAndroid
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder

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
                fillUserName()
                proceedToBackupMnemonic()
            }
        }
    }
}