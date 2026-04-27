package lesson23

import lesson18.homework.Explore.ExploreScreen
import lesson18.homework.Explore.TopReadItem
import lesson18.OnboardingScreen
import lesson9.homework.BaseClass
import lesson19.action
import lesson19.verify
import org.junit.Test

class WebViewTest: BaseClass(){

    @Test
    fun test(){
        run {
            action.click(OnboardingScreen.skipButton)
            ExploreScreen.topReadBlock {
                items.childAt<TopReadItem>(0, {
                    action.click(this)
                    Thread.sleep(3000)
                })
            }
            verify.isDisplayed(ArticleScreen.title)
        }
    }
}