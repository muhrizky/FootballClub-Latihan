package id.ac.undip.ce.student.muhammadrizqi.footballclub

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import id.ac.undip.ce.student.muhammadrizqi.footballclub.R.id.*
import android.support.v7.widget.RecyclerView
import id.ac.undip.ce.student.muhammadrizqi.footballclub.main.HomeActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeActivityTest {
    @Rule
    @JvmField
    var activityRule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun testRecyclerViewBehaviour() {
        Thread.sleep(2000)
        onView(withId(list_team))
                .check(matches(isDisplayed()))
        onView(withId(list_team)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(10))
        onView(withId(list_team)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(10, click()))
    }
    @Test
    fun testAppBehaviour() {
//        Thread.sleep(2000)
        onView(withId(spinner))
                .check(matches(isDisplayed()))
        onView(withId(spinner)).perform(click())
        onView(ViewMatchers.withText("Spanish La Liga")).perform(click())
        Thread.sleep(2000)
        onView(ViewMatchers.withText("Barcelona"))
                .check(matches(isDisplayed()))
        onView(ViewMatchers.withText("Barcelona")).perform(click())

        onView(withId(add_to_favorite))
                .check(matches(isDisplayed()))
        onView(withId(add_to_favorite)).perform(click())
        onView(ViewMatchers.withText("Added to favorite"))
                .check(matches(isDisplayed()))
        Espresso.pressBack()

        onView(withId(bottom_navigation))
                .check(matches(isDisplayed()))
        onView(withId(favorites)).perform(click())
    }

}