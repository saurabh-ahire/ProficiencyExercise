package saurabh.test.com.proficiencyexercise.network;

import retrofit2.Call;
import retrofit2.http.GET;
import saurabh.test.com.proficiencyexercise.Constants.NetworkConstants;
import saurabh.test.com.proficiencyexercise.model.data.ResponseData;

/**
 * This is a API interface to fetch canada information using a retofit framework.
 *
 * Created by saurabha on 18/10/18.
 */
public interface RetroNetworkInterface {
    /**
     * This is a method which will initiate API call and capture results and pass results to
     * service callback.
     * <p>
     * return CountryFacts - a object of response data of canada information from webservice.
     */

    @GET(NetworkConstants.URL_GET_CANADA_DATA)
    Call<ResponseData> getCanadaInformations();
}
