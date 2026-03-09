package lesson10.homework

import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

object AddLanguagesScreenKautomator : UiScreen<AddLanguagesScreenKautomator>() {

    override val packageName = "org.wikipedia.alpha"

    val title = UiTextView {
        withText("Wikipedia languages")
    }
    val backButton = UiButton {
        withContentDescription("Navigate up")
    }
    val header = UiTextView {
        withId(this@AddLanguagesScreenKautomator.packageName, "section_header_text")
    }
}