package lesson9
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.params.StepParams
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import lesson8.LanguageItem
import lesson8.OnboardingScreen
import lesson8.PagerItem
import lesson8.homework.ExploreScreen
import lesson8.homework.InTheNews
import lesson8.homework.NewsItem
import org.junit.Rule
import org.junit.Test
import org.wikipedia.feed.news.NewsCardView
import org.wikipedia.main.MainActivity


// Первый тест
class SimpleTest : TestCase() {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkOnboardingScreen() {
        run("Чек экрана онбординга") {
            OnboardingScreen.pager {
                step("Проверка отображения текста в хедере на первой странице онбординга") {
                    isDisplayed()
                    childAt<PagerItem>(0) {
                        title.containsText("Free")
                    }
                    childAt<PagerItem>(0) {
                        languages.childAt<LanguageItem>(0) {
                            hasText("1.\t\tEnglish") // childAt получает элемент списка по его позиции (индексу). Когда знаем позицию элемента списка
                        }
                        languages.childWith<LanguageItem> { // childWith получает элемент списка по его содержимому или другим характеристикам. Использовать когда не знаем позицию элемента
                            containsText("1.\t\tEnglish")
                        } perform {
                            isDisplayed()
                            hasText("1.\t\tEnglish")
                        }
                    }
                }
            }
        }
    }
    @Test
    fun checkAnyoneBlockInExploreScreen() {
        run("Тест") {
            OnboardingScreen {
                step("Тапаем по кнопку Skip") {
                    skipButton.click()
                }
            }
            ExploreScreen {
                step("Проверяем отображение лого wikipedia на экране Explore") {
                    logo.isDisplayed()
                }
                step("Проверяем список inTheNews") {
                    items.childWith<InTheNews> {
                        isInstanceOf(NewsCardView::class.java)
                    } perform {
                      step("Проверка хедера блока In the News") { headerText.hasText("In the news")
                      }
                       step("Проверяет что отображается картинка на третьем слайде") { items.childAt<NewsItem>(2) {
                            image.isDisplayed()
                       }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun checkPagerIndicator() {
     run("Проверка переключения пейджера на странице онбординга" ) {
         OnboardingScreen {
             pager.childAt<PagerItem>(1) { }
             tab.isTabSelected(1)

         }
     }
    }
}



