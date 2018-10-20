package saurabh.test.com.proficiencyexercise.presentor;

import android.content.Context;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import saurabh.test.com.proficiencyexercise.R;
import saurabh.test.com.proficiencyexercise.model.ResponseData;
import saurabh.test.com.proficiencyexercise.network.ApiCallClient;

/**
 * Created by saurabha on 18/10/18.
 */
public class HomeScreenIntegrator {



    public void getCanadaInformation(final Context context, final HomeScreenResponseHandler homeScreenResponseHandler) {

        final RetroNetworkInterface apiService =
                ApiCallClient.getClient(context).create(RetroNetworkInterface.class);

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
