package lesson18.homework.screens.Onboarding

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.matchers.ItemMatcher
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.tabs.KTabLayout
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.text.TextViewAssertions
import lesson18.OnboardingScreen.withParent
import lesson18.invokeByIndex
import org.hamcrest.Matcher
import org.wikipedia.onboarding.OnboardingPageView
import lesson18.withParent
import lesson18.name


object OnboardingScreen : KScreen<OnboardingScreen>() {

    override val layoutId = null
    override val viewClass = null

    val skipButton by lazy {
        KButton {
            withId(R.id.fragment_onboarding_skip_button)
        }.name(withParent("Кнопка Skip"))
    }
    val continueButton by lazy {
        KButton {
            withId(R.id.fragment_onboarding_forward_button)
        }.name(withParent("Кнопка Continue"))
    }
    val getStarted by lazy {
        KButton {
            withId(R.id.fragment_onboarding_done_button)
        }.name(withParent("Кнопка Get started"))
    }
    val pager by lazy {
        KViewPager2(
            builder = {
                withId(R.id.fragment_pager)
            },
            itemTypeBuilder = {
                itemType(::PagerItem)
            }
        ).name(withParent("Слайдер"))
    }

    fun page(index: Int, fnc: PagerItem.() -> Unit) {
        pager.invokeByIndex(index, fnc)
    }
}

class PagerItem(matcher: Matcher<View>) : KViewPagerItem<PagerItem>(matcher) {

    val image by lazy {
        KImageView(matcher) {
            withId(R.id.imageViewCentered)
        }.name(withParent("Картинка"))
    }
    val title by lazy {
        KTextView(matcher) {
            withId(R.id.primaryTextView)
        }.name(withParent("Заголовок"))
    }
    val addLanguageButton by lazy {
        KButton {
            withId(R.id.addLanguageButton)
        }.name(withParent("Кнопка добавления языка"))
    }
    val languages by lazy {
        KRecyclerView(
            parent = matcher,
            builder = {
                withId(R.id.languagesList)
            },
            itemTypeBuilder = {
                itemType(::LanguageItem)
            }
        ).name(withParent("Список языков"))
    }
}

class LanguageItem(matcher: Matcher<View>) : KRecyclerItem<PagerItem>(matcher), TextViewAssertions {

    val languageText by lazy {
        KTextView(matcher) {
            withId(R.id.option_label)
        }.name(withParent("Текст языка"))
    }
}
