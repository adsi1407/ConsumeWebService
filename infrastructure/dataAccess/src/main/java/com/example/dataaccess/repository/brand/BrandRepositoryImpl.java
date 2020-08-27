package com.example.dataaccess.repository.brand;

import com.example.dataaccess.dto.BrandDto;
import com.example.domain.entity.Brand;
import com.example.domain.exception.TechnicalException;
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

    public static final String BASE_URL = "https://parallelum.com.br/fipe/api/v1/";
    private Retrofit retrofit;

    @Inject
    public BrandRepositoryImpl() {

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Override
    public List<Brand> getAllBrands() {

        BrandsService brandsService = retrofit.create(BrandsService.class);
        Call<List<BrandDto>> call = brandsService.getAllBrands();
        List<BrandDto> brandsFromService;

        try {
            Response<List<BrandDto>> response = call.execute();
            brandsFromService = response.body();
        }
        catch (IOException ex) {
            throw new TechnicalException(ex);
        }

        List<Brand> brands = new ArrayList<>();

        for (int i = 0; i < brandsFromService.size(); i++) {
            BrandDto brandDto = brandsFromService.get(i);
            brands.add(new Brand(brandDto.getId(), brandDto.getName()));
        }

        return brands;
    }
}
