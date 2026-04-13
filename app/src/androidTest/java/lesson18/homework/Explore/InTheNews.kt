package lesson18.homework.Explore

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import lesson8.homework.NewsItem
import org.hamcrest.Matcher
import org.wikipedia.R
import lesson18.withParent
import lesson18.name
class InTheNews(matcher: Matcher<View>) : KRecyclerItem<InTheNews>(matcher) {

    val image by lazy {
        KImageView(matcher) {
            withId(R.id.horizontal_scroll_list_item_image)
        }.name(withParent("Картинка"))
    }
    val text by lazy {
        KTextView(matcher) {
            withId(R.id.horizontal_scroll_list_item_text)
        }.name(withParent("Текст"))
    }
}