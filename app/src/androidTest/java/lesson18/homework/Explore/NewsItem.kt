package lesson18.homework.Explore

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import android.view.View
import lesson18.withParent
import lesson18.name
import io.github.kakaocup.kakao.recycler.KRecyclerView
class NewsItem(matcher: Matcher<View>) : KRecyclerItem<NewsItem>(matcher) {


    val header by lazy {
        KTextView(matcher) {
            withId(R.id.view_card_header_title)
        }.name(withParent("Заголовок"))
    }
    val icon by lazy {
        KImageView(matcher) {
            withId(R.id.view_list_card_header_menu)
        }.name(withParent("Иконка"))
    }
    val pager by lazy {
        KRecyclerView(
            parent = matcher,
            builder = { withId(R.id.news_cardview_recycler_view) },
            itemTypeBuilder = {
                itemType(::InTheNews)
            }
        ).name(withParent("Список статей"))
    }

}