package saurabh.test.com.proficiencyexercise.presentor;

import java.util.List;

import saurabh.test.com.proficiencyexercise.model.data.CanadaInformation;

/**
 * This is a callback mechanism for implementer.
 * Created by saurabha on 18/10/18.
 */
public interface HomeScreenResponseHandler {

    /**
     * This method will notify user that API request is successful.
     * With parameter
     * canadaInformationList - list of information returned by API
     */
    void onSuccess(List<CanadaInformation> canadaInformationList);

    /**
     * This method will notify user that API request is failed.
     * With parameter
     * errorMsg - error message
     */

    void onFailure(String errorMsg);

}
