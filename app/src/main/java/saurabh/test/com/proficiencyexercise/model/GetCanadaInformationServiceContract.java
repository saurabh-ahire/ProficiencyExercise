package saurabh.test.com.proficiencyexercise.model;

import android.content.Context;

/**
 * This is a service contract.
 * It provide a action for service implementor to initiate API call.
 * It captures callback from retrofit API interface.
 *
 * Created by saurabha on 23/10/18.
 */
public interface GetCanadaInformationServiceContract {
    /**
     * This method will initiate atual service call to get data.
     */
    void getCanadaInformation(Context context);
}
