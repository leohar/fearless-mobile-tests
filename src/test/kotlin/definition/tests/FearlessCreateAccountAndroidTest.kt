package definition.tests

import adaptation.baseclass.BaseTest
import adaptation.baseclass.fearless.FearlessBase
import org.junit.jupiter.api.Test

class FearlessCreateAccountAndroidTest : BaseTest() {

    @Test
    fun fearlessAndroidCreateAccountScreen() {
        with(app as FearlessBase) {
            createAccountStepsAndroid.run {
                checkHeader()
                checkElementsAreDisplayed()
            }
        }
    }
}