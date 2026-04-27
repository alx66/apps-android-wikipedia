package lesson18.homework.Explore


import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.textview.MaterialTextView
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.tabs.KTabLayout
import lesson8.homework.AnnouncementCard
import lesson8.homework.DataItem
import lesson8.homework.FeaturedArticle
import lesson8.homework.InTheNews
import lesson8.homework.TopRead
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView
import lesson18.NamedScreen
import lesson18.withParent
import lesson18.name
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import lesson18.OnboardingScreen.withParent
import lesson18.invokeWithText
import lesson21.extension.invokeAtIndexAndClass
import org.wikipedia.feed.featured.FeaturedArticleCardView
import lesson22.SearchWidget

object ExploreScreen : KScreen<ExploreScreen>() {


    override val layoutId = R.layout.fragment_feed
    override val viewClass = FeedView::class.java

    val logoIcon by lazy {
        KImageView {
            withId(R.id.main_toolbar_wordmark)
        }.name(withParent("Иконка лого"))
    }
    val retryButton by lazy {
        KButton {
            withId(R.id.view_card_offline_button_retry)
        }.name(withParent("Кнопка Retry"))
    }
    val closeButton by lazy {
        KButton {
            withId(R.id.closeButton)
        }.name(withParent("Кнопка Close"))
    }
    val items by lazy {
        KRecyclerView(
            builder = {
                withId(R.id.feed_view)
            },
            itemTypeBuilder = {
                itemType(::SearchItem)
                itemType(::CustomizeScreenItem)
                itemType(::DataItem)
                itemType(::TopReadItem)
                itemType(::NewsItem)
                itemType(::FeaturedArticle)
            }
        ).name(withParent("Список блоков"))
    }

    fun customizeBlock(fnc: CustomizeScreenItem.() -> Unit) {
        items.invokeWithText("Customize", fnc)
    }

    fun topReadBlock(fnc: TopReadItem.() -> Unit) {
        items.invokeWithText("Top read", fnc)
    }

    val moreTab = KTabLayout {
        withId(R.id.nav_tab_more)
    }.name(withParent("Таб More"))

    fun featuredArticle(index: Int, fnc: FeaturedArticle.() -> Unit) {
        items.invokeAtIndexAndClass(
            index,
            1,
            (index - 1) * 10,
            FeaturedArticleCardView::class.java,
            "$index блок Featured article",
            fnc
        )
    }

    val searchField = KTextView() {
        isInstanceOf(MaterialTextView::class.java)
        withText("Search Wikipedia")
    }

    val searchWidget by lazy {
        SearchWidget {
            withId(R.id.search_container)
        }.name(withParent("Виджет поиска"))
    }
}