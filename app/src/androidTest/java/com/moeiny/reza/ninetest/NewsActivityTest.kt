package com.moeiny.reza.ninetest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.moeiny.reza.ninetest.ui.news.NewsActivity
import org.junit.Rule
import org.junit.Test

//@RunWith(AndroidJUnit4::class)
class NewsActivityTest {

  @get:Rule
  public val myActivitytest: ActivityTestRule<NewsActivity> = ActivityTestRule<NewsActivity>(NewsActivity::class.java)

  @Test
  fun clickcontinueButton_gotonewPage()  {
    onView(withId(R.id.updat_text_view)).check(matches(withText("Login")))
    onView(withId(R.id.updat_text_view)).perform(ViewActions.click())
    onView(withId(R.id.updat_text_view)).check(matches(withText("Welcome to Nine News")))
  }
  }



