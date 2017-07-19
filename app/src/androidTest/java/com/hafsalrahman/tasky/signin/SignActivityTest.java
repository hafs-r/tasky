package com.hafsalrahman.tasky.signin;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.hafsalrahman.tasky.R;

import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by hafsal on 7/20/17.
 */

@RunWith(AndroidJUnit4.class)
public class SignActivityTest {

    ActivityTestRule<SignActivity> activityTestRule =
            new ActivityTestRule<>(SignActivity.class);


    @Test
    public void checkUserNameAndPasswordEditTextIsDisplayed() throws Exception {
        activityTestRule.launchActivity(new Intent());
        onView(withId(R.id.edt_user_name)).check(matches(isDisplayed()));
        onView(withId(R.id.edt_password)).check(matches(isDisplayed()));
    }

    @Test
    public void checkIfshowPasswordError() throws Exception {
        activityTestRule.launchActivity(new Intent());
        onView(withId(R.id.edt_user_name)).perform(typeText("hafsal"));
        onView(withId(R.id.edt_password)).perform(typeText("incorrect"));
        onView(withId(R.id.btn_login)).check(matches(isDisplayed())).perform(click());
        onView(withText("Invalid password.")).check(matches(isDisplayed()));
    }

    @Test
    public void checkIfshowUserNameError() throws Exception {
        activityTestRule.launchActivity(new Intent());
        onView(withId(R.id.edt_user_name)).perform(typeText("incorrect"));
        onView(withId(R.id.edt_password)).perform(typeText("tasky"));
        onView(withId(R.id.btn_login)).check(matches(isDisplayed())).perform(click());
        onView(withText("Invalid username.")).check(matches(isDisplayed()));

    }

    @Test
    public void checkIfEmptyInputs() throws Exception {
        activityTestRule.launchActivity(new Intent());

        onView(withId(R.id.btn_login)).check(matches(isDisplayed())).perform(click());
        onView(withText("Please enter required credentials.")).check(matches(isDisplayed()));
    }

    @Test
    public void checkIfshowMaximumAttemptError() throws Exception {
        activityTestRule.launchActivity(new Intent());

        // TODO: 7/20/17 implement show maximum attemt error ui test

    }

    @Test
    public void checkIfLoginSuccess() throws Exception {
        activityTestRule.launchActivity(new Intent());
        onView(withId(R.id.edt_user_name)).perform(typeText("hafsal"));
        onView(withId(R.id.edt_password)).perform(typeText("tasky"));
        onView(withId(R.id.btn_login)).check(matches(isDisplayed())).perform(click());
        onView(withText("SignIn Success.")).check(matches(isDisplayed()));
    }

}