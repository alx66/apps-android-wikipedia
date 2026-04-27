package lesson19.homework

import org.junit.Test
import lesson18.OnboardingScreen
import lesson18.homework.Explore.ExploreScreen
import lesson19.action
import lesson19.verify
import lesson9.homework.BaseClass
import

class ExploreTests : BaseClass() {

    @Test
    fun checkTopReadTest() {
        run {
            action.click(OnboardingScreen.skipButton)
            ExploreScreen.topReadBlock {
                verify.isDisplayed(this)
                items(4) {
                    verify.isDisplayed(image)
                }
            }
        }
    }

    @Test
    fun checkShowLinkPreviewsToggleTest() {
        run {
            action.click(OnboardingScreen.skipButton)
            ExploreScreen.topReadBlock {
                verify.isDisplayed(this)
                items(4) {
                    verify.isDisplayed(image)
                }
            }
        }
    }
}