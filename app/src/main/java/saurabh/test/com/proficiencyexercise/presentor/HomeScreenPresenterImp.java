package saurabh.test.com.proficiencyexercise.presentor;

import android.support.v4.widget.SwipeRefreshLayout;

import java.util.List;

import saurabh.test.com.proficiencyexercise.model.CanadaInformation;

/**
 * Created by saurabha on 18/10/18.
 */
public class HomeScreenPresenterImp implements HomeScreenResponseHandler,SwipeRefreshLayout.OnRefreshListener {

    HomeScreenView homeScreenView;

    public HomeScreenPresenterImp(HomeScreenView homeScreenView) {
        this.homeScreenView = homeScreenView;
    }

    public void getCanadaInformation(boolean isRefresh) {
        if (!isRefresh) {
            homeScreenView.showProgressBar();
        }
        new HomeScreenIntegrator().getCanadaInformation(homeScreenView.getContext(), this);
    }

    @Override
    public void onFailure(String errorMsg) {
        homeScreenView.hideProgressBar();
        homeScreenView.onFailure(errorMsg);
    }

    @Override
    public void onSuccess(List<CanadaInformation> canadaInformationList) {
        homeScreenView.hideProgressBar();
        homeScreenView.onSuccess(canadaInformationList);
    }

    @Override
    public void onRefresh() {
        homeScreenView.onRefresh();
    }
}
