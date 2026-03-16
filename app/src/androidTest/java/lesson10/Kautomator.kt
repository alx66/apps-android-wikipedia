package lesson10

import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.screen.UiScreen

object KautomatorOnboarding : UiScreen<KautomatorOnboarding>()  {
    override val packageName: String = ""

    val skipButton = UiButton {
        withId(this@KautomatorOnboarding.packageName,"fragment_onboarding_skip_button")
    }

}