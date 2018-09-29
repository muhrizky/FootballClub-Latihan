package id.ac.undip.ce.student.muhammadrizqi.footballclub.main

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import id.ac.undip.ce.student.muhammadrizqi.footballclub.R.id.*
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeActivityTest {
    @Rule
    @JvmField
    var activityRule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun testRecyclerViewBehaviour() {
        onView(withId(list_team))
                .check(matches(isDisplayed()))
        onView(withId(list_team)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(1))
        onView(withId(list_team)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1, ViewActions.click()))
    }


}