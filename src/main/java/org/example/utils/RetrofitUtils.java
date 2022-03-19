package org.example.utils;

import lombok.experimental.UtilityClass;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.time.Duration;

@UtilityClass
public class RetrofitUtils {
    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

    public Retrofit getRetrofit(){
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(Duration.ofMinutes(1L))
                .addInterceptor(logging.setLevel(HttpLoggingInterceptor.Level.BASIC))
                .build();
        return new Retrofit.Builder()
                .baseUrl(ConfigUtils.getBaseUrl())
                .addConverterFactory(JacksonConverterFactory.create())
                .client(httpClient)
                .build();
    }
}
