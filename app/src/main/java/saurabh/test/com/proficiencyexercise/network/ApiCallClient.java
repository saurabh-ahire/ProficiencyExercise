package saurabh.test.com.proficiencyexercise.network;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import saurabh.test.com.proficiencyexercise.Constants.NetworkConstants;

/**
 * This calss is created to handle API call initializations.
 *
 * Created by saurabha on 18/10/18.
 */
public class ApiCallClient {
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {

        if (retrofit == null) {

             retrofit = new Retrofit.Builder()
                    .baseUrl(NetworkConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
