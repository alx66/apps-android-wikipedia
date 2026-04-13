package lesson18.homework.Explore
import android.view.View
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import lesson8.homework.CustomizeScreenItem
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView

object CustomizeScreen : KScreen<CustomizeScreen>() {
    override val layoutId: Int? = null

    override val viewClass: Class<*> = FeedView::class.java


    val backButton = KImageView() {
        isDescendantOfA {
            withId(R.id.toolbar)
        }
        isInstanceOf(AppCompatImageButton::class.java)
    }

    val title = KTextView() {
        isDescendantOfA {
            withId(R.id.toolbar)
        }
        isInstanceOf(AppCompatTextView::class.java)
    }

    val menu = KImageView() {
        withContentDescription("More options")
    }



    val items =  KRecyclerView(

        builder = {
            withId(R.id.content_types_recycler)
        },
        itemTypeBuilder = {
            itemType(::CustomizeScreenItem)
        }
    )

}