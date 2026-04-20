import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.image.KImageView
import lesson18.NamedScreen
import org.wikipedia.R
import lesson18.name

object SearchField : NamedScreen<SearchField>() {
    override val screenName: String = "Экран поиска"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val searchInput by lazy {
        KEditText {
            withId(R.id.search_cab_view)
        }.name(withParent("Строка поиска"))
    }


    val voiceIcon by lazy {
        KImageView {
            withId(R.id.voice_search_button)
        }.name(withParent("Кнопка Назад"))
    }
}