package lesson13.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object SearchScreen : KScreen<SearchScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val back = KImageView() {
        withContentDescription("Navigate up")
    }

    val engMode = KTextView {
        withId(R.id.language_label)
        withText("English")
    }

    val ruMode = KTextView {
        withId(R.id.language_label)
        withText("русский")
    }

    val moreButton = KButton {
        withId(R.id.more_languages)
    }

    val search = KEditText{
        withId(R.id.search_input)
    }


}