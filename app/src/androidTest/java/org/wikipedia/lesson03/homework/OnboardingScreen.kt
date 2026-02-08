package org.wikipedia.lesson03.homework

import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout
import org.wikipedia.R
import org.wikipedia.views.AppTextView

// Кнопка add or edit languages
val languageAddEditButton = listOf(
    MaterialButton::class.java,
    R.id.addLanguageButton,
    R.string.onboarding_multilingual_add_language_text
)

// Индикатор экрана
val onboardingScreenIndicator = listOf(TabLayout::class.java, R.id.view_onboarding_page_indicator)

// Кнопка переключения экранов онбординга
val continueOnboardingButton = listOf(
    MaterialButton::class.java,
    R.id.fragment_onboarding_forward_button,
    R.string.onboarding_continue
)

// Блок с отображением добавленных языков
val languagesOnboardingList = listOf(RecyclerView::class.java, R.id.languagesList)

// Текст заголовка на втором экране онбординга
val textTitleSecondScreenOnboarding =
    listOf(AppTextView::class.java, R.id.primaryTextView, R.string.onboarding_explore_title)

// Описание на третьем экране онбординга
val descriptionTextThirdScreenOnboarding = listOf(
    AppTextView::class.java,
    R.id.secondaryTextView,
    R.string.onboarding_reading_list_sync_text_v2
)

// Кнопка "Get Started" на финальном экране онбординга
val getStartedOnboardingButton = listOf(
    MaterialButton::class.java,
    R.id.fragment_onboarding_done_button,
    R.string.onboarding_get_started
)

// Изображения
val imageInFinalScreenOnboarding = listOf(AppCompatImageView::class.java, R.id.imageViewCentered)
