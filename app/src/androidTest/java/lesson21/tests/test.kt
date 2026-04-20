package lesson21.tests

import lesson18.homework.Explore.ExploreScreen
import lesson18.homework.screens.Onboarding.OnboardingScreen
import lesson19.screens.MoreMenuScreen
import lesson19.screens.SettingsScreen
import lesson19.verify
import lesson20.Action.multiAction
import lesson20.Assertion.equalsWithTrim
import lesson9.homework.BaseClass
import org.junit.Test

class test : BaseClass() {

    @Test
    fun invokeAtIndexAndClassTest() {
        run {
            OnboardingScreen.skipButton.multiAction()
            ExploreScreen.featuredArticle(1) { verify.isDisplayed(this) }
        }
    }

    @Test
    fun invokeAtIndexAndIdTest() {
        run {
            OnboardingScreen.skipButton.multiAction()
            ExploreScreen.moreTab.multiAction()
            MoreMenuScreen.settingsButton.multiAction()
            SettingsScreen.switchAtIndex(0) {
                switchWidget.multiAction()
                switchWidget.isChecked()
            }
            SettingsScreen.switchAtIndex(1) {
                titleText.equalsWithTrim("Collapse tables")
            }
        }
    }
}