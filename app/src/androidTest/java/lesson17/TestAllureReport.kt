package lesson17

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import lesson10.homework.AddLanguagesScreenKautomator
import lesson10.homework.OnboardingScreenKautomator
import lesson8.OnboardingScreen
import lesson8.PagerItem
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class TestAllureReport : TestCase(Kaspresso.Builder.withForcedAllureSupport(true)) {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testAllure() {
        run {
            step("Проверяет что кнопка скип отображается") {
                OnboardingScreen {
                    skipButton.isDisplayed()
                }
            }
            step("Проверяет праймари текст") {
                OnboardingScreen.pager {
                childAt<PagerItem>(0) {
                    title.containsText("Фри")
                }
            }
        }
    }
}
    @Test
    fun testAllureReportTwo() {
        run("Переход на экран языков и возвращение с него") {
            step("Переход по тапу на кнопку Add language") {
                OnboardingScreenKautomator.addOrEditLanguagesButton.click()
            }
            step("Проверка открытия экрана добавления языков") {
                AddLanguagesScreenKautomator.title.isNotDisplayed()
            }
            step("Возвращение с экрана добавления языков по кнопке назад") {
                AddLanguagesScreenKautomator.backButton.click()

            }
        }
    }
    }