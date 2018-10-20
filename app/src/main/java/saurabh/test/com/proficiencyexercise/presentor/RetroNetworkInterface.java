package saurabh.test.com.proficiencyexercise.presentor;

import retrofit2.Call;
import retrofit2.http.GET;
import saurabh.test.com.proficiencyexercise.Constants.NetworkConstants;
import saurabh.test.com.proficiencyexercise.model.ResponseData;

/**
 * Created by saurabha on 18/10/18.
 */
public interface RetroNetworkInterface {

    @GET(NetworkConstants.URL_GET_CANADA_DATA)
    Call<ResponseData> getCanadaInformations();
}
