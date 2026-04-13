package lesson18.homework.Explore
import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import org.wikipedia.R
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import lesson18.withParent
import lesson18.name
import io.github.kakaocup.kakao.recycler.KRecyclerView
    class FeaturedArticle(matcher: Matcher<View>) : KRecyclerItem<FeaturedArticle>(matcher) {
        val menuHeader by lazy {
            KTextView(matcher) {
                withId(R.id.view_card_header_title)
                withText("Featured article")
            }.name(withParent("Заголовок"))
        }
        val headerIcon by lazy {
            KImageView(matcher) {
                withId(R.id.view_list_card_header_menu)
            }.name(withParent("Иконка"))
        }
        val articleTitle by lazy {
            KTextView(matcher) {
                withId(R.id.articleTitle)
            }.name(withParent("Заголовок статьи"))
        }
        val items by lazy {
            KRecyclerView(
                parent = matcher,
                builder = { withId(R.id.view_list_card_list) },
                itemTypeBuilder = {
                    itemType(::TopRead)
                }
            ).name(withParent("Список статей"))
        }
        val moreLink by lazy {
            KTextView(matcher) {
                withId(R.id.footerActionButton)
            }.name(withParent("Кнопка More link"))
        }

    }
