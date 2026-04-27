package lesson22.homework

import io.github.kakaocup.kakao.text.TextViewAssertions
import lesson18.homework.screens.Onboarding.ThemeBottomSheet
import lesson18.homework.Explore.ExploreScreen
import lesson18.OnboardingScreen
import lesson9.homework.BaseClass
import lesson19.action
import lesson19.verify
import org.junit.Test

class ThemeTest : BaseClass() {

    @Test
    fun themeWidgetChangeTextSizeTest() {
        run {
            action.click(OnboardingScreen.skipButton)
            ExploreScreen.topReadBlock {
                cardListItem(0) {
                    action {
                        click(image)
                        click(this@topReadBlock.themeButton)
                    }
                }
            }
            ThemeBottomSheet {
                themeWidget{
                    verify.isDisplayed(this)
                    action.click(increaseSizeButton)
                    verify.hasText(textSize as TextViewAssertions, "110%")
                    repeat(2){
                        action.click(decreaseSizeButton)
                    }
                    verify.hasText(textSize as TextViewAssertions, "90%")
                }
            }
        }
    }

    @Test
    fun matchSystemThemeTest() {
        run{
            action.click(OnboardingScreen.skipButton)
            ExploreScreen.topReadBlock {
                cardListItem(0) {
                    action {
                        click(image)
                        click(this@topReadBlock.themeButton)
                    }
                }
            }
            ThemeBottomSheet {
                themeWidget{
                    verify.isDisplayed(this)
                    action.click(matchSystemThemeSwitcher)
                    verify{
                        darkThemeButton.isEnabled()
                        blackThemeButton.isEnabled()
                    }
                    action.click(matchSystemThemeSwitcher)
                    verify{
                        darkThemeButton.isDisabled()
                        blackThemeButton.isDisabled()
                    }
                }
            }
        }
    }
}