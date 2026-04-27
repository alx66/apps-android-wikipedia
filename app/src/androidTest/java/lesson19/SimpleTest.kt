package lesson19

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import lesson18.OnboardingScreen
import lesson18.homework.Explore.ExploreScreen
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity



class TestForAllureReport: TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()){

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun example() {
        run {
//            val steps = StepDefinitions(this)
//            val action = Actions(steps)
//            val verify = Verify(steps)
            action.click(OnboardingScreen.skipButton)
            ExploreScreen.customizeBlock {
                verify.isDisplayed(this)
            }
        }
    }
}