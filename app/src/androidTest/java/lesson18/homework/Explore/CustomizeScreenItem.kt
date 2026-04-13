package lesson18.homework.Explore
import android.view.View
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import lesson18.withParent
import lesson18.name

class CustomizeScreenItem(matcher: Matcher<View>) : KRecyclerItem<CustomizeScreenItem>(matcher) {

    val image by lazy {
        KImageView(matcher) {
            withId(R.id.view_announcement_header_image)
        }.name(withParent("Картинка"))
    }
    val text by lazy {
        KTextView(matcher) {
            withId(R.id.view_announcement_text)
        }.name(withParent("Текст"))
    }
    val customizeButton by lazy {
        KButton(matcher) {
            withId(R.id.view_announcement_action_positive)
        }.name(withParent("Кнопка Customize"))
    }
    val gotItButton by lazy {
        KButton(matcher) {
            withId(R.id.view_announcement_action_negative)
        }.name(withParent("Кнопка Got it"))
    }

}