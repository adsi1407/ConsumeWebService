package com.example.dataaccess.repository.brand;

import com.example.domain.entity.Brand;
import com.example.domain.repository.BrandRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BrandRepositoryImpl implements BrandRepository {

    public static final String BASE_URL = "https://parallelum.com.br/fipe/api/v1";
    private Retrofit retrofit;

    @Inject
    public BrandRepositoryImpl() {

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Override
    public List<Brand> getAllBrands() throws IOException {

        BrandsService brandsService = retrofit.create(BrandsService.class);
        Call<List<com.example.dataaccess.dto.Brand>> call = brandsService.getAllBrands();
        Response<List<com.example.dataaccess.dto.Brand>> response = call.execute();
        List<com.example.dataaccess.dto.Brand> brandsFromService = response.body();

        List<Brand> brands = new ArrayList<>();

        for (int i = 0; i < brandsFromService.size(); i++) {
            com.example.dataaccess.dto.Brand item = brandsFromService.get(i);
            brands.add(new Brand(item.getId(), item.getName()));
        }

        return brands;
    }
}
