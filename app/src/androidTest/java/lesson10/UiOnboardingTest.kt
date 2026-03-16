package lesson10

import lesson9.homework.BaseClass
import org.junit.Test

class UiOnboardingTest : BaseClass() {
    @Test
    fun checkSkipButton() {
        run("Тест скип баттон") {
            KautomatorOnboarding {
                skipButton.isDisplayed()
            }
        }
    }

}