package lesson6

import com.google.android.material.button.MaterialButton
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.tabs.KTabLayout
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R


object Onboarding : KScreen<Onboarding>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val skipButton = KButton {
        withId(R.id.fragment_onboarding_skip_button)
    }

    val image = KImageView {
        withId(R.id.imageViewCentered)
    }

    val primaryText = KTextView {
        withId(R.id.primaryTextView)
    }

    val secondaryText = KTextView {
        containsText("We've found")
    }

    // поиск элемента по родителю: наш элемент имеет родителя который имеет соот-ий id
    val addLanguagesButton = KButton {
        withParent {
            withId(R.id.languageListContainer)
        }
        isInstanceOf(MaterialButton::class.java)
    }

    // поиск элемента по предку: наш элемент имеет родителя который имеет соот-ий id
    val addLanguagesButton1 = KButton {
        isDescendantOfA {
            withId(R.id.scrollViewContainer)
        }
        isInstanceOf(MaterialButton::class.java)
    }

    // поиск по индеку когда элементов в классе много(работает криво)
    val firstLanguage = KTextView {
        withIndex(0) {
            withId(R.id.option_label)
        }


    }
    val pageIndicator = KTabLayout {
        withId(R.id.view_onboarding_page_indicator)
    }

    fun main() {
        Onboarding {
            skipButton {
                click()
                isDisplayed()
            }
        pageIndicator.selectTab(2)
        }
    }
}



