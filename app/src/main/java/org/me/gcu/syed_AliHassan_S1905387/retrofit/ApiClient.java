package org.me.gcu.syed_AliHassan_S1905387.retrofit;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.internal.Util;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class ApiClient {

    public final static String URL = "http://trafficscotland.org";

    private ApiClient instance ;

    // Keep your services here, build them in buildRetrofit method later
    private WebService webService;

    public ApiClient getInstance(Context context) {
        if (instance == null) {
            instance = new ApiClient(context);
        }
        return instance;
    }

    // Build retrofit once when creating a single instance
    public ApiClient(Context context) {
        // Implement a method to build your retrofit
        Retrofit(context);
    }

    // Retrofit Class use Live Service
    public void Retrofit(Context context) {
        Retrofit retrofit ;

       OkHttpClient.Builder httpClientBuilder =
                new OkHttpClient.Builder()
                        .readTimeout(5000, TimeUnit.SECONDS)
                        .writeTimeout(60, TimeUnit.SECONDS)
                        .connectTimeout(5000, TimeUnit.SECONDS)
                        .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));

        org.me.gcu.syed_AliHassan_S1905387.Util.Util.initSSL(httpClientBuilder,context);
        retrofit =   new Retrofit.Builder()
                .baseUrl(URL + "/")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();

        webService = retrofit.create(WebService.class);

    }// close the Retrofit Static Methord

    public WebService getWebService() {
        return webService;
    }

}
