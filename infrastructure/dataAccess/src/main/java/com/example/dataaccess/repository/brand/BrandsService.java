package com.example.dataaccess.repository.brand;

import com.example.dataaccess.dto.BrandDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BrandsService {

    @GET("carros/marcas")
    Call<List<BrandDto>> getAllBrands();
}
