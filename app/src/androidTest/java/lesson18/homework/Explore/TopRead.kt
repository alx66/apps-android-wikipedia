package lesson18.homework.Explore

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import lesson8.homework.TopReadItem
import org.hamcrest.Matcher
import org.wikipedia.R
import lesson18.withParent
import lesson18.name
import io.github.kakaocup.kakao.common.views.KView

class TopRead(matcher: Matcher<View>) : KRecyclerItem<TopRead>(matcher) {


    val number by lazy {
        KTextView(matcher) {
            withId(R.id.numberView)
        }.name(withParent("Номер"))
    }
    val title by lazy {
        KTextView(matcher) {
            withId(R.id.view_list_card_item_title)
        }.name(withParent("Заголовок"))
    }
    val subtitle by lazy {
        KTextView(matcher) {
            withId(R.id.view_list_card_item_subtitle)
        }.name(withParent("Подзаголовок"))
    }
    val graph by lazy {
        KView(matcher) {
            withId(R.id.view_list_card_item_graph)
        }.name(withParent("Граф"))
    }
    val pageViews by lazy {
        KTextView(matcher) {
            withId(R.id.view_list_card_item_pageviews)
        }.name(withParent("Page views"))
    }
    val image by lazy {
        KTextView(matcher) {
            withId(R.id.view_list_card_item_image)
        }.name(withParent("картинка"))
    }
}