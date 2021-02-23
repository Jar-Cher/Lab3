package com.example.lab3

import android.content.pm.ActivityInfo
import android.view.Gravity
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.contrib.*
import androidx.test.espresso.contrib.DrawerMatchers.isClosed
import androidx.test.espresso.contrib.DrawerMatchers.isOpen

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    val activityTestRule = ActivityScenarioRule(Activity::class.java)

    private fun isFirst() {
        onView(withId(R.id.button)).check(matches(isDisplayed()))
        onView(withId(R.id.button)).check(matches(withText("To second")))
        onView(withId(R.id.button1)).check(matches(isDisplayed()))
        onView(withId(R.id.button1)).check(matches(withText("To third")))
        onView(withId(R.id.button2)).check(doesNotExist())
        onView(withId(R.id.textView)).check(matches(withText("Activity 1_5")))
        testDrawer()
    }

    private fun isSecond() {
        onView(withId(R.id.button)).check(matches(isDisplayed()))
        onView(withId(R.id.button)).check(matches(withText("To first")))
        onView(withId(R.id.button1)).check(doesNotExist())
        onView(withId(R.id.button2)).check(matches(isDisplayed()))
        onView(withId(R.id.button2)).check(matches(withText("To third")))
        onView(withId(R.id.textView)).check(matches(withText("Activity 2_5")))
        testDrawer()
    }

    private fun isThird() {
        onView(withId(R.id.button)).check(matches(isDisplayed()))
        onView(withId(R.id.button)).check(matches(withText("To first")))
        onView(withId(R.id.button1)).check(doesNotExist())
        onView(withId(R.id.button2)).check(matches(isDisplayed()))
        onView(withId(R.id.button2)).check(matches(withText("To second")))
        onView(withId(R.id.textView)).check(matches(withText("Activity 3_5")))
        testDrawer()
    }

    private fun isAbout() {
        onView(withId(R.id.button)).check(doesNotExist())
        onView(withId(R.id.button1)).check(doesNotExist())
        onView(withId(R.id.button2)).check(doesNotExist())
        onView(withId(R.id.textView)).check(matches(withText("Activity About")))
        onView(withId(R.id.textView2)).check(matches(withText("Some text, lots of it. Some text, lots of it. Some text, lots of it.")))
    }

    private fun testDrawer() {
        onView(withId(R.id.Drawer)).check(matches(isClosed(Gravity.LEFT)))
        onView(withId(R.id.Drawer)).perform(DrawerActions.open())
        onView(withId(R.id.button3)).check(matches(isDisplayed()))
        onView(withId(R.id.Drawer)).check(matches(isOpen()))
        onView(withId(R.id.Drawer)).perform(DrawerActions.close())
    }

    @Test
    fun testFirst() {
        isFirst()
        onView(withId(R.id.button)).perform(click())
        isSecond()
        onView(withId(R.id.button)).perform(click())
        isFirst()
        onView(withId(R.id.button1)).perform(click())
        isThird()
        onView(withId(R.id.button)).perform(click())
        isFirst()
    }

    @Test
    fun testSecond() {
        isFirst()
        onView(withId(R.id.button)).perform(click())

        isSecond()
        onView(withId(R.id.button)).perform(click())
        isFirst()
        onView(withId(R.id.button)).perform(click())
        isSecond()
        onView(withId(R.id.button2)).perform(click())
        isThird()
        onView(withId(R.id.button2)).perform(click())
        isSecond()
    }

    @Test
    fun testThird() {
        isFirst()
        onView(withId(R.id.button1)).perform(click())

        isThird()
        onView(withId(R.id.button)).perform(click())
        isFirst()
        onView(withId(R.id.button1)).perform(click())
        isThird()
        onView(withId(R.id.button2)).perform(click())
        isSecond()
        onView(withId(R.id.button2)).perform(click())
        isThird()
    }

    @Test
    fun testAbout() {
        isFirst()
        onView(withId(R.id.Drawer)).perform(DrawerActions.open())
        onView(withId(R.id.button3)).perform(click())
        isAbout()
        pressBack()
        isFirst()
        onView(withId(R.id.button)).perform(click())

        isSecond()
        onView(withId(R.id.Drawer)).perform(DrawerActions.open())
        onView(withId(R.id.button3)).perform(click())
        isAbout()
        pressBack()
        isSecond()
        onView(withId(R.id.button2)).perform(click())

        isThird()
        onView(withId(R.id.Drawer)).perform(DrawerActions.open())
        onView(withId(R.id.button3)).perform(click())
        isAbout()
        pressBack()
        isThird()
    }

    @Test
    fun testBackStack() {
        isFirst()
        onView(withId(R.id.button)).perform(click())
        isSecond()
        onView(withId(R.id.Drawer)).perform(DrawerActions.open())
        onView(withId(R.id.button3)).perform(click())
        isAbout()
        pressBack()
        isSecond()
        pressBack()
        isFirst()

        onView(withId(R.id.button)).perform(click())
        isSecond()
        onView(withId(R.id.button2)).perform(click())
        isThird()
        onView(withId(R.id.Drawer)).perform(DrawerActions.open())
        onView(withId(R.id.button3)).perform(click())
        isAbout()
        pressBack()
        isThird()
        pressBack()
        isSecond()
        pressBack()
        isFirst()

        onView(withId(R.id.button)).perform(click())
        isSecond()
        onView(withId(R.id.button)).perform(click())
        isFirst()

        onView(withId(R.id.button)).perform(click())
        isSecond()
        onView(withId(R.id.button2)).perform(click())
        isThird()
        onView(withId(R.id.button2)).perform(click())
        isSecond()
        onView(withId(R.id.button2)).perform(click())
        isThird()
        onView(withId(R.id.button)).perform(click())
        isFirst()
        pressBackUnconditionally()
    }

    @Test
    fun testOrientation() {
        isFirst()
        activityTestRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        isFirst()

        onView(withId(R.id.button)).perform(click())
        isSecond()
        activityTestRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        isSecond()
        pressBack()
        isFirst()

        onView(withId(R.id.Drawer)).perform(DrawerActions.open())
        activityTestRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        onView(withId(R.id.Drawer)).check(matches(isOpen()))
        activityTestRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }

    }
}