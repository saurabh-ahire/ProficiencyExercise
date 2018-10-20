package saurabh.test.com.proficiencyexercise.presentor;

import android.content.Context;

import java.util.List;

import saurabh.test.com.proficiencyexercise.model.CanadaInformation;

/**
 * Created by saurabha on 18/10/18.
 */
public interface HomeScreenView {

    Context getContext();

    void showProgressBar();

    void hideProgressBar();

    void onFailure(String errorMsg);

    void onSuccess(List<CanadaInformation> canadaInformationList);

    void onRefresh();
}
