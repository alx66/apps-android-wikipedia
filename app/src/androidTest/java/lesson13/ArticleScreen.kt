package lesson13

import androidx.test.espresso.web.webdriver.Locator
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.web.KWebView
import lesson9.homework.BaseClass
import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith
import org.wikipedia.R
@RunWith(Enclosed::class)
object ArticleScreen : KScreen<ArticleScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val webView = KWebView() {
        withId(R.id.page_web_view)
    }


    class WebViewTests: BaseClass() {

    @Test
    fun webViewTest(){
        run {
            ArticleScreen {
                webView {
                    withElement(Locator.CLASS_NAME, "mw-page-title-main") {
                        scroll()
                        hasText("Corleck Head")
                    }
                    withElement(Locator.XPATH, "//img[1]") {
                        scroll()
                        click()
                    }
                }
            }
        }
    }

    }
}