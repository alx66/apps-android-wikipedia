package lesson20.Tests

import lesson18.homework.Explore.ExploreScreen
import lesson18.homework.screens.Onboarding.OnboardingScreen
import lesson19.screens.MoreMenuScreen
import lesson19.screens.SettingsScreen
import lesson20.Action.multiAction
import lesson20.Assertion.equalsWithTrim
import lesson9.homework.BaseClass
import org.junit.Test

class test : BaseClass() {
    @Test
    fun multiActionTest() {
        run {
            OnboardingScreen.skipButton.multiAction()
        }
    }

    @Test
    fun assertionTest() {
        run {
            OnboardingScreen.page(1) {
                title.equalsWithTrim("New ways to explore")
            }
        }
    }

    @Test
    fun hwTests() {
        run {
            OnboardingScreen.skipButton.multiAction()
//            ExploreScreen.searchBlock{
//                searchIcon.multiAction()
//            }
//            SearchScreen.searchText {
//                multiAction("Kotlin")
//                equalsWithTrim("Kotlin")
//            }
//            device.uiDevice.pressBack()
//            device.uiDevice.pressBack()
            ExploreScreen.moreTab.multiAction()
            MoreMenuScreen.settingsButton.multiAction()
            SettingsScreen.downloadOnlyOverWiFi{
                switchWidget.multiAction()
                switchWidget.isChecked()
            }
        }
    }
}