package com.mounacheikhna.espressosamples;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.isDialog;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Created by cheikhnamouna on 12/27/15.
 */
@RunWith(AndroidJUnit4.class)
public class SpinnerInDialogTest {

  @Rule public ActivityTestRule<MainActivity> mActivityRule =
      new ActivityTestRule<>(MainActivity.class);

  @Test public void spinnerTestDemo() throws Exception {
    onView(withId(R.id.show_dialog)).perform(click());

    onView(withId(R.id.planets_spinner))
        //.inRoot(withDecorView(not(is(mActivityRule.getActivity().getWindow().getDecorView()))))
        .inRoot(isDialog())
        .perform(click());

    onData(allOf(is(instanceOf(String.class)), is("Saturn")))
        //.inRoot(withDecorView(not(is(mActivityRule.getActivity().getWindow().getDecorView()))))
        .inRoot(isDialog())
        .perform(click());

    onView(withId(R.id.ok_dialog))
        //.inRoot(withDecorView(not(is(mActivityRule.getActivity().getWindow().getDecorView()))))
        .inRoot(isDialog())
        .perform(click());

    onView(withId(R.id.planets_spinner))
        .inRoot(isDialog())
        .perform(click());
    onView(withId(R.id.planets_spinner)).check(matches(withSpinnerText("Saturn")));
  }

}
