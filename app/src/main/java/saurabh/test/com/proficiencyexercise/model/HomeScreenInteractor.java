package saurabh.test.com.proficiencyexercise.model;

import android.content.Context;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import saurabh.test.com.proficiencyexercise.R;
import saurabh.test.com.proficiencyexercise.model.data.ResponseData;
import saurabh.test.com.proficiencyexercise.network.ApiCallClient;
import saurabh.test.com.proficiencyexercise.presentor.HomeScreenResponseHandler;
import saurabh.test.com.proficiencyexercise.network.RetroNetworkInterface;

/**
 * This is a service implementer.
 * It will handle all data related functionality like initiating actual API call or database
 * operation.
 * <p>
 * Created by saurabha on 18/10/18.
 */
public class HomeScreenInteractor implements GetCanadaInformationServiceContract {

    HomeScreenResponseHandler homeScreenResponseHandler;

    public HomeScreenInteractor(HomeScreenResponseHandler homeScreenResponseHandler) {
        this.homeScreenResponseHandler = homeScreenResponseHandler;
    }

    @Override
    public void getCanadaInformation(final Context context) {

        final RetroNetworkInterface apiService =
                ApiCallClient.getClient().create(RetroNetworkInterface.class);

        Call<ResponseData> call = apiService.getCanadaInformations();

        call.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                ResponseData responseData = response.body();

                if (responseData != null) {
                    homeScreenResponseHandler.onSuccess(responseData.getCanadaInformations());
                } else
                    homeScreenResponseHandler.onFailure(context.getString(R.string.we_are_unable_to_process_your_request));
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {

                homeScreenResponseHandler.onFailure(t.toString());

            }
        });
    }
}
