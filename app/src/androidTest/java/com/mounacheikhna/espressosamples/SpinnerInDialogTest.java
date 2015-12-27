package com.mounacheikhna.espressosamples;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.AllOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

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
        .perform(click());

    onData(AllOf.allOf(is(instanceOf(String.class)), is("Saturn")))
        .inRoot(Matchers.allOf(withDecorView(not(is(mActivityRule.getActivity().getWindow().getDecorView()))),
            withDecorView(hasWindowFocus())))
        .perform(click());

    onView(withId(R.id.ok_dialog))
        .perform(click());

    onView(withId(R.id.show_dialog)).perform(click());
  }

  private static Matcher<View> hasWindowFocus() {
    return new TypeSafeMatcher<View>() {
      @Override
      public void describeTo(Description description) {
        description.appendText("has window focus");
      }

      @Override
      public boolean matchesSafely(View view) {
        return view.hasWindowFocus();
      }
    };
  }


}
