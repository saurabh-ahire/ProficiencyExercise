package saurabh.test.com.proficiencyexercise.presentor;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import saurabh.test.com.proficiencyexercise.model.data.CanadaInformation;

/**
 * This interface will have all contract method between presenter and UI.
 *
 * Created by saurabha on 18/10/18.
 */
public interface HomeScreenView {

    /**
     * This method will return current class context
     *
     */
    Context getContext();

    /**
     * This method will show progress bar
     *
     */
    void showProgressBar();

    /**
     * This method will hide progress bar
     *
     */
    void hideProgressBar();
    /**
     * This method will update UI if error occurs while fetching data
     *
     * @param errorMsg - Error message
     */
    void onFailure(String errorMsg);

    /**
     * This method will notify user that API request is successful.
     *
     * @param canadaInformationList - List of information
     */
    void onSuccess(List<CanadaInformation> canadaInformationList);

    /**
     * This method will initiate Api call and refresh list UI
     */
    void onRefresh();
}
