package lesson10.homework

import lesson10.homework.OnboardingScreenKautomator.primaryText
import lesson8.OnboardingScreen.tab
import lesson8.homework.ExploreScreen
import lesson9.homework.BaseClass
import org.junit.Test

class OnboardingScreenTest : BaseClass() {
    @Test
    fun checkOnboardingPagesScreen() {
        run("Проверяем элементы на экране онбординга") {
            OnboardingScreenKautomator {
                step("Проверяем отображение элементов на первом экране") {
                    image.isDisplayed()
                    primaryText.containsText("Encyclopedia")
                    secondaryText.containsText("We’ve found")
                    addOrEditLanguagesButton.isDisplayed()
                    skipButton.isDisplayed()
                    pageIndicator.isDisplayed()
                    continueButton.isDisplayed()
                }
                step("Переключение экрана онбординга(на второй) по кнопке continue") {
                    continueButton.click()
                    tab.isTabSelected(1)
                }
            }
        }
    }

    @Test
    fun checkSkipButtonOnOnboardingScreen() {
        run("Проверка скрытия экрана Onboarding по кнопке Skip") {
            step("Нажимает на кнопку Skip") {
                OnboardingScreenKautomator.skipButton.click()
            }
            step("Проверяет отображение экрана Explore") {
                ExploreScreen.logo.isDisplayed()
            }
        }
    }

    @Test
    fun checkAddLanguageButtonNavigation() {
        run("Переход на экран языков и возвращение с него") {
            step("Переход по тапу на кнопку Add language") {
                OnboardingScreenKautomator.addOrEditLanguagesButton.click()
            }
            step("Проверка открытия экрана добавления языков") {
                AddLanguagesScreenKautomator.title.isDisplayed()
            }
            step("Возвращение с экрана добавления языков по кнопке назад") {
                AddLanguagesScreenKautomator.backButton.click()
            }
        }
    }
}