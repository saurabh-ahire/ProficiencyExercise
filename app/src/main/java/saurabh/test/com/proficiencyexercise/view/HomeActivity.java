package saurabh.test.com.proficiencyexercise.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.PersistableBundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import saurabh.test.com.proficiencyexercise.R;
import saurabh.test.com.proficiencyexercise.adapter.RecyclerViewAdapter;
import saurabh.test.com.proficiencyexercise.model.data.CanadaInformation;
import saurabh.test.com.proficiencyexercise.presentor.HomeScreenPresenterImp;
import saurabh.test.com.proficiencyexercise.presentor.HomeScreenView;
import saurabh.test.com.proficiencyexercise.utility.AppActivity;
import saurabh.test.com.proficiencyexercise.utility.DialogPresenter;
import saurabh.test.com.proficiencyexercise.viewmodel.CanadaInformationViewModel;

/**
 * This will be a launcher activity
 * <p>
 * Created by saurabha on 18/10/18.
 */

public class HomeActivity extends AppActivity implements HomeScreenView {

    HomeScreenPresenterImp homeScreenPresenterImp;

    @BindView(R.id.swipe_refresh_home_screen)
    SwipeRefreshLayout swipeRefreshHomeScreen;
    @BindView(R.id.rv_home_data)
    RecyclerView recyclerViewHomeScreen;
    @BindView(R.id.tv_no_data)
    TextView tvNoData;
    private CanadaInformationViewModel canadaInformationViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setListeners();

         canadaInformationViewModel = ViewModelProviders.of(this).get(CanadaInformationViewModel.class);

        if (!canadaInformationViewModel.getCanadaInformationList().isEmpty()) {
            setDataToAdapter(canadaInformationViewModel.getCanadaInformationList());
        } else {
            getCanadaInformationAPICall(false);
        }

    }

    /**
     * This method will initialize all listeners
     */

    private void setListeners() {

        homeScreenPresenterImp = new HomeScreenPresenterImp(this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerViewHomeScreen.setLayoutManager(mLayoutManager);
        swipeRefreshHomeScreen.setOnRefreshListener(homeScreenPresenterImp);
    }

    private void getCanadaInformationAPICall(boolean isRefresh) {
        if (isNetworkConnected()) {
            setRefreshingState(false);
            homeScreenPresenterImp.getCanadaInformation(isRefresh);
        } else {
            showLoading(false);
            showNoNetworkError();
            setRefreshingState(false);
        }

    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showProgressBar() {
        showLoading(true);
    }

    @Override
    public void hideProgressBar() {
        showLoading(false);
    }

    @Override
    public void onFailure(String errorMsg) {
        DialogPresenter.showDialog(getContext(), getResources().getString(R.string.dialog_failure), errorMsg, getResources().getString(R.string.button_ok), null, null);
    }

    @Override
    public void onSuccess(List<CanadaInformation> canadaInformationListData) {
        setRefreshingState(false);
        if (canadaInformationListData.isEmpty()) {
            tvNoData.setVisibility(View.VISIBLE);
            recyclerViewHomeScreen.setVisibility(View.GONE);
        } else {
            canadaInformationViewModel.setCanadaInformationList(canadaInformationListData);
            setDataToAdapter(canadaInformationListData);
        }

    }

    private void setDataToAdapter(List<CanadaInformation> canadaInformationList) {
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(canadaInformationList);
        recyclerViewHomeScreen.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void onRefresh() {
        getCanadaInformationAPICall(true);
    }

    /**
     * This method will check whether is page refreshing
     * parameter is-
     * setRefreshing - true if page is refreshing
     * - false if page is stop refreshing
     */
    public void setRefreshingState(boolean setRefreshing) {
        if (null == swipeRefreshHomeScreen) {
            return;
        }
        swipeRefreshHomeScreen.setRefreshing(setRefreshing);

    }

}
