package saurabh.test.com.proficiencyexercise.presentor;

import java.util.List;

import saurabh.test.com.proficiencyexercise.model.CanadaInformation;

/**
 * Created by saurabha on 18/10/18.
 */
public interface HomeScreenResponseHandler {

    void onFailure(String errorMsg);

    void onSuccess(List<CanadaInformation> canadaInformationList);

}
