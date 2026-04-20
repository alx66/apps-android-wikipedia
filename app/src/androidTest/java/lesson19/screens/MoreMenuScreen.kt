package lesson19.screens

import lesson18.NamedScreen
import io.github.kakaocup.kakao.common.views.KView
import org.wikipedia.R
import lesson18.name
object MoreMenuScreen : NamedScreen<MoreMenuScreen>() {

    override val screenName = "Меню More"
    override val layoutId = null
    override val viewClass = null

    val settingsButton by lazy {
        KView {
            withId(R.id.main_drawer_settings_container)
        }.name(withParent("Кнопка Settings"))
    }
}