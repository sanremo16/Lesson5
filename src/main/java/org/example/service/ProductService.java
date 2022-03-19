package org.example.service;

import okhttp3.ResponseBody;
import org.example.dto.Product;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.ArrayList;


public interface ProductService {

    @POST("products")
    Call<Product> createProduct(@Body Product createProductRequest);

    @DELETE("products/{id}")
    Call<ResponseBody> deleteProduct(@Path("id") int id);

    @GET("products/{id}")
    Call<Product> getProduct(@Path("id") int id);

    @GET("products")
    Call<ArrayList<Product>> getProducts();
}

