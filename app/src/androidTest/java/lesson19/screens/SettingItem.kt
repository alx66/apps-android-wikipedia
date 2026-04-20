package lesson19.screens

import android.view.View
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import lesson18.name
import lesson18.withParent
class SettingsItem(matcher: Matcher<View>) : KRecyclerItem<SettingsItem>(matcher) {

    val switchWidget by lazy {
        KCheckBox(matcher) {
            withId(R.id.switchWidget)
        }.name(withParent("Переключатель"))
    }

    val titleText by lazy {
        KTextView(matcher) {
            withId(R.id.title)
        }.name(withParent("Заголовок"))
    }
}