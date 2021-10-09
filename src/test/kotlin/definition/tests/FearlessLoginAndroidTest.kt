package definition.tests

import adaptation.baseclass.BaseTest
import adaptation.baseclass.fearless.FearlessBase
import org.junit.jupiter.api.Test


class FearlessLoginAndroidTest: BaseTest() {

    @Test
    fun fearlessAndroidLoginScreen() {
        with(app as FearlessBase) {
            loginScreenStepsAndroid.run {
                checkHeader()
                checkElementsAreDisplayed()
            }
        }
    }
}
