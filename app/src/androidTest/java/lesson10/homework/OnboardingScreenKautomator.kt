package lesson10.homework

import androidx.test.uiautomator.By
import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object OnboardingScreenKautomator : UiScreen<OnboardingScreenKautomator>() {
    override val packageName: String = "org.wikipedia.alpha"

    val skipButton = UiButton {
        withId(this@OnboardingScreenKautomator.packageName, "fragment_onboarding_skip_button")
    }

    val continueButton = UiButton {
        withId(this@OnboardingScreenKautomator.packageName, "fragment_onboarding_forward_button")
    }

    val addOrEditLanguagesButton = UiButton {
        withId(this@OnboardingScreenKautomator.packageName, "addLanguageButton")
    }

    val primaryText = UiTextView {
        withId(this@OnboardingScreenKautomator.packageName, "primaryText")
    }

    val secondaryText = UiTextView {
        withId(this@OnboardingScreenKautomator.packageName, "secondaryTextView")
    }

    val pageIndicator = UiView {
        withId(this@OnboardingScreenKautomator.packageName, "view_onboarding_page_indicator")
    }

    val getStartedButton = UiButton {
        withId(this@OnboardingScreenKautomator.packageName, "fragment_onboarding_done_button")
    }

    val image = UiView {
        withId(this@OnboardingScreenKautomator.packageName, "imageViewCentered")
    }

    val language = UiTextView {
        withId(this@OnboardingScreenKautomator.packageName, "option_label")
    }

}