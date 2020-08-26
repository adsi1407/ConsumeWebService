package com.example.dataaccess.repository.brand;

import com.example.dataaccess.dto.Brand;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BrandsService {

    @GET("carros/marcas")
    Call<List<Brand>> getAllBrands();
}
