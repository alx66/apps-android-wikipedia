package lesson9.homework

import android.view.View
import lesson8.homework.ExploreScreen
import lesson8.OnboardingScreen
import lesson8.homework.AnnouncementCard
import lesson8.homework.CustomizeScreen
import lesson8.homework.CustomizeScreenItem
import lesson8.homework.FeaturedArticle
import org.hamcrest.Matcher
import org.junit.Test
import org.wikipedia.feed.announcement.AnnouncementCardView
import org.wikipedia.feed.featured.FeaturedArticleCardView

// Реализуй следующий сценарий, описав необходимые экраны:
/*Нажимает Skip на экране онбординга
Проверяет отображение блока Featured Article экрана Explore
Нажимает на кнопку Customize в блоке Customize your Explore feed экрана Explore
Отключает Featured Article
Нажимает стрелку назад в верхнем тулбаре
Проверяет, что блок Featured Article не отображается на экране Explore (метод doesNotExist())*/

class TestScenarioForHomework : BaseClass() {
    @Test
    fun disabledFeaturedArticleBlock() {
        run("Экран онборндига") {
            OnboardingScreen {
                step("Тапаем на кнопку Skip") {
                    skipButton.isDisplayed()
                    skipButton.click()
                }
            }
            ExploreScreen {
                step("Проверяем отображение блока Featured Article экрана Explore") {
                    items.childWith<FeaturedArticle> {
                        isInstanceOf(FeaturedArticleCardView::class.java)
                    } perform {
                        step("Проверяем соответствие текста тайтла") {
                            title.hasText("Featured article")
                        }
                    }
                }
                step("Проверяем отображение кнопки Customize") {
                    items.childWith<AnnouncementCard> {
                        isInstanceOf(AnnouncementCardView::class.java)
                    } perform {
                        customize.isDisplayed()
                        step("Тапаем на кнопку customize") {
                            customize.click()
                        }
                    }
                }
            }
            CustomizeScreen {
                step("Отключаем свитчер у Featured Article ") {
                    items.childAt<CustomizeScreenItem>(1) {
                        switcher.click()
                    }
                }
                step("Тап по кнопке назад для выхода с экрана customize") {
                    backButton {
                        isDisplayed()
                        click()
                    }
                }
                ExploreScreen {
                    step("Проверяем что блок Featured Article НЕ экрана Explore") {
                        items.childWith<FeaturedArticle> {} perform {
                            step("Проверяем отсутствие тайтла") {
                                image.doesNotExist()
                            }
                        }
                    }
                }
            }
        }
    }
}