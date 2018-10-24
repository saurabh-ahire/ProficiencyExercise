package saurabh.test.com.proficiencyexercise;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import saurabh.test.com.proficiencyexercise.view.HomeActivity;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

/**
 * Created by saurabha on 20/10/18.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class HomeScreenUIUnitTestCases {
    public static final long TIMEOUT = 10000;
    private HomeActivity homeActivity;
    @Rule
    public ActivityTestRule<HomeActivity> activityActivityTestRule =
            new ActivityTestRule<>(HomeActivity.class);


    @Before
    public void setUp() {
        homeActivity = activityActivityTestRule.getActivity();
        assertNotNull("HomeActivity is null", homeActivity);
    }

    @Test
    public void testDataLoadedSuccess() {
        RecyclerView recyclerView = (RecyclerView) homeActivity.findViewById(R.id.rv_home_data);
        assertNotNull("RecyclerView is null", recyclerView);
        assertThat(recyclerView.getAdapter(), instanceOf(RecyclerView.Adapter.class));
        try {
            Thread.sleep(TIMEOUT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertThat(recyclerView.getAdapter().getItemCount(), greaterThan(0));
    }

    @Test
    public void testDataLoadedFailed() {
        try {
            Thread.sleep(TIMEOUT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TextView mEmptyStateText = (TextView) homeActivity
                .findViewById(R.id.tv_no_data);
        assertNotNull("EmptyStateTextView is null", mEmptyStateText);
        assertThat(mEmptyStateText.getVisibility(), lessThanOrEqualTo(View.VISIBLE));
    }


}