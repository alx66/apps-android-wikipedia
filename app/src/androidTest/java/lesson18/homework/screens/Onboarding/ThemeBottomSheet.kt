package lesson18.homework.screens.Onboarding

import com.google.android.material.R
import lesson18.name
import lesson18.NamedScreen
import lesson22.ThemeWidget



object ThemeBottomSheet : NamedScreen<ThemeBottomSheet>() {
    override val screenName: String = "Боттомшит Тема"
    override val layoutId = null
    override val viewClass = null

    val themeWidget by lazy{
        ThemeWidget {
            withId(R.id.design_bottom_sheet)
        }.name(withParent("Виджет Тема"))
    }

}