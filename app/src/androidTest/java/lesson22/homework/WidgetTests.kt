package lesson22.homework

import lesson18.OnboardingScreen
import lesson18.homework.Explore.ExploreScreen
import lesson9.homework.BaseClass
import lesson19.action
import lesson19.verify
import org.junit.Test

class WidgetTest : BaseClass() {

    @Test
    fun searchWidgetTest() {
        run{
            action.click(OnboardingScreen.skipButton)
            verify {
                ExploreScreen.searchWidget {
                    isDisplayed(this)
                    isDisplayed(searchIcon)
                    hasText(searchText, "Search Wikipedia")
                    isDisplayed(voiceIcon)
                }
            }
        }
    }
}