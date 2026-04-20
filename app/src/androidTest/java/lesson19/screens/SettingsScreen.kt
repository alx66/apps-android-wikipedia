package lesson19.screens

import lesson18.NamedScreen
import io.github.kakaocup.kakao.recycler.KRecyclerView
import lesson18.invokeWithText
import org.wikipedia.R
import lesson18.name
import lesson21.extension.invokeAtIndexAndId

object SettingsScreen : NamedScreen<SettingsScreen>() {

    override val screenName = "Экран Settings"
    override val layoutId = null
    override val viewClass = null

    val items by lazy {
        KRecyclerView(
            builder = {
                withId(R.id.recycler_view)
            },
            itemTypeBuilder = {
                itemType(::SettingsItem)
            }
        ).name(withParent("Список настроек"))
    }

    fun showLinkPreviews(fnc: SettingsItem.() -> Unit) {
        items.invokeWithText("Show link previews", fnc)
    }

    fun downloadOnlyOverWiFi(fnc: SettingsItem.() -> Unit) {
        items.invokeWithText("Download only over Wi-Fi", fnc)
    }

    fun switchAtIndex(index: Int, fnc: SettingsItem.() -> Unit) {
        items.invokeAtIndexAndId(
            index,
            0,
            10,
            R.id.switchWidget,
            "$index переключатель",
            fnc
        )
    }
}