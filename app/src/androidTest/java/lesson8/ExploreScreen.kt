package lesson8

import android.view.View
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.matchers.ItemMatcher
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView
import org.hamcrest.Matcher

object ExploreScreen : KScreen<ExploreScreen>() {
    override val layoutId: Int = R.layout.fragment_feed
    override val viewClass: Class<*> = FeedView::class.java

    val imageHeader = KImageView {
        withId(R.id.main_toolbar_wordmark)
    }

    val item = KRecyclerView(
        builder = {
            withId(R.id.feed_view)
        },
        itemTypeBuilder = {
            itemType(::SearchItem)
        }
    )

}

class SearchItem(matcher: Matcher<View>) : KRecyclerItem<SearchItem>(matcher) {
        val icon = KImageView (matcher) {

        }
}