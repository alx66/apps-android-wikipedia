package lesson11.homework

import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test
import lesson8.homework.ExploreScreen
import lesson8.OnboardingScreen
import lesson8.homework.TopReadItem
import org.wikipedia.main.MainActivity
import java.util.Locale
import lesson9.homework.BaseClass

class TestWithAdb : BaseClass() {
    @Test
    fun checkOrientation() {
        run("Поворот экрана и проверка ориентации") {
            val isNaturalOrientation = device.uiDevice.isNaturalOrientation
            assertTrue("Device should be in natural orientation", isNaturalOrientation)
            device.uiDevice.setOrientationLandscape()
            Thread.sleep(2000)
            assertFalse("Device should be in landscape orientation", device.uiDevice.isNaturalOrientation)
            device.uiDevice.setOrientationPortrait()
            Thread.sleep(2000)
            assertTrue("Device should be back to natural orientation", device.uiDevice.isNaturalOrientation)
        }
    }

    @Test
    fun checkSwitchOnAndSwitchOffScreen() {
        run("Выключение и включение экрана, проверка отображения любого элемента") {
            device.uiDevice.sleep()
            device.uiDevice.wakeUp()
            OnboardingScreen.skipButton.isDisplayed()
        }
    }

    @Test
    fun checkCollapsedDeviceByHomeButton() {
        run("Сворачивание приложения кнопкой Домой и разварачивание, проверка любого элемента") {
            device.uiDevice.pressHome()
            repeat(2) {
                device.uiDevice.pressRecentApps()
            }
            OnboardingScreen.skipButton.isDisplayed()
        }
    }

    @Test
    fun checkSwitchOnAndSwitchOffInternet() {
        before("выключить сеть, перейти в статью и проверить отображение ошибки и кнопки Retry. \" +\n" +
                "                \"Включить сеть и нажать Retry, проверить отображение заголовка \" +\n" +
                "                \"(может работать некорректно, в этом случае забить на тест)") {
            adbServer.performAdb("shell svc data disable")
            adbServer.performAdb("shell svc wifi disable")
        }.after {
            adbServer.performAdb("shell svc data enable")
            adbServer.performAdb("shell svc wifi enable")
        }.run {
            OnboardingScreen.skipButton.click()
            ExploreScreen.items.childWith<TopReadItem> {
                isInstanceOf(TopReadItem::class.java)
            } perform {
                step("Переход на экран") {
                    number.isDisplayed()
                }
            }
        }
    }

    @Test
    fun changeLanguage() {
        before("поменять язык приложения и проверить текст какой-нибудь кнопки (не через ресурсы)") {
            device.language.switchInApp(Locale.FRENCH)
        }.after {
            device.language.switchInApp(Locale.ENGLISH)
        }.
        run {
            OnboardingScreen.skipButton.hasText("Sauter")
        }
    }

    @Test
    fun checkMainActivity() {
        run("проверить, что сейчас активна MainActivity.") {
            OnboardingScreen.skipButton.click()
            device.activities.isCurrent(MainActivity::class.java)
        }
    }
}