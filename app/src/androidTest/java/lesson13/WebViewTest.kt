package lesson13

import androidx.compose.ui.test.hasText
import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.uiautomator.UiSelector
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import lesson13.homework.ActionModeBareScreen
import lesson13.homework.ReferencesScreen
import lesson13.homework.SearchScreen
import lesson9.homework.BaseClass
import org.junit.Rule
import org.junit.Test
import lesson8.homework.ExploreScreen
import lesson8.homework.SearchItem
import lesson8.homework.TopRead
import lesson8.homework.TopReadItem
import lesson8.OnboardingScreen
import org.wikipedia.main.MainActivity


class WebViewTest : BaseClass() {

    @Test
    fun checkWebView() {
        run {
            OnboardingScreen {
                step("Тап Skip на экране онбординга") {
                    skipButton {
                        isDisplayed()
                        click()
                    }
                }
            }
            step("Тап по поиску") {
                ExploreScreen {
                    items {
                        childWith<SearchItem> {
                            withDescendant { withContentDescription("Search Wikipedia") }
                        } perform {
                            textSearch.click()
                        }
                    }
                }
            }
            step("Пишем в поиске") {
                SearchScreen.search.typeText("Donald Trump")
            }
            step("Тап по первой статье") {
                device.uiDevice.findObject(UiSelector().text("Donald Trump")).click()
            }
            step("Скролим до References проверяем текст") {
                ArticleScreen.webView {
                    withElement(Locator.ID, "References") {
                        scroll()
                        hasText("References")
                    }
                }
            }
            step("Скролим до 5й ссылки и тапаем") {
                ArticleScreen.webView {
                    withElement(
                        Locator.XPATH,
                        "//*[@id=\"cite_ref-FOOTNOTEMurray202024-29_5-0\"]/a/span"
                    ) {
                        scroll()
                        click()
                        Thread.sleep(3000)
                    }
                }
            }
            step("Проверили заголовок") {
                ReferencesScreen.title.hasText("Reference ")
            }
            step("Проверяем что ссылка под номером 5") {
                ReferencesScreen.refId.hasText("5.")
            }
            step("Тап на бек") {
                device.uiDevice.pressBack()
                Thread.sleep(3000)
            }
            step("Нашли 2ю ссылку с CSS=mw-redirect нажали на нее"){
                ArticleScreen.webView{
                    withElement(Locator.XPATH,"//*[@id=\"pcs\"]/section[1]/p[4]/a[24]"){
                        scroll()
                        Thread.sleep(3000)
                        click()
                    }
                }
            }
            step("Тап на Read article"){
                ActionModeBareScreen.readArticleButton.click()
            }
        }
    }
}