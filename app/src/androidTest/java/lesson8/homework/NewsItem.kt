package lesson8.homework

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import android.view.View
class NewsItem(matcher: Matcher<View>) : KRecyclerItem<NewsItem>(matcher) {

    val image = KImageView(matcher) {
        withId(R.id.horizontal_scroll_list_item_image)
    }

    val text = KTextView(matcher) {
        withId(R.id.horizontal_scroll_list_item_text)
    }

}