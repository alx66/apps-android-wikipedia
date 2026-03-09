package lesson9.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.wikipedia.main.MainActivity

abstract class BaseClass: TestCase() {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)
}