package com.vwmattr.rxexample;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.vwmattr.rxexample.components.AppComponent;
import com.vwmattr.rxexample.modules.MockApiModule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Singleton;

import dagger.Component;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Espresso 2 instrumentation tests for {@link MainActivity}.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Singleton
    @Component(modules = MockApiModule.class)
    public interface TestComponent extends AppComponent {
        void inject(MainActivityTest mainActivityTest);
    }

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(
            MainActivity.class,
            true); // initialTouchMode
            //false);  // launchActivity. False so we can customize the intent per test method

    @Before
    public void setUp() {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        App app = (App) instrumentation.getTargetContext().getApplicationContext();
        TestComponent component = DaggerMainActivityTest_TestComponent.builder()
                .mockApiModule(new MockApiModule())
                .build();
        app.setComponent(component);
        component.inject(this);
    }

    @Test
    public void header() {
        //If we used the ActivityTestRule constructor above and pass false for launchActivity:
        // activityRule.launchActivity(new Intent());

        onView(withId(R.id.list_header))
                .check(matches(withText("#Android StackOverflow Questions")));
    }

    @Test
    public void questionList() {
        //First item
        onView(withText("Question 1 Title"))
                .check(matches(withId(R.id.title)));
        //Second item
        onView(withText("2nd Question Title"))
                .check(matches(withId(R.id.title)));
        //Third item
        onView(withText("Title of question 3"))
                .check(matches(withId(R.id.title)));
    }

}
