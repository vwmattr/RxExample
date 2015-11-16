package com.vwmattr.rxexample;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Espresso 2 instrumentation tests for {@link MainActivity}.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(
            MainActivity.class,
            true); // initialTouchMode
            //false);  // launchActivity. False so we can customize the intent per test method

    @Test
    public void header() {
        //If we used the ActivityTestRule constructor above and pass false for launchActivity:
        // activityRule.launchActivity(new Intent());

        onView(withId(R.id.list_header))
                .check(matches(withText("#Android StackOverflow Questions")));
    }
}
