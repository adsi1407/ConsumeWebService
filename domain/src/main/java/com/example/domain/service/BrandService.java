package com.example.domain.service;

import com.example.domain.entity.Brand;
import com.example.domain.exception.NoDataException;
import com.example.domain.repository.BrandRepository;

import java.util.List;

public class BrandService {

    public static final String NO_BRANDS_FOUND = "No se encontraron marcas de vehículos";
    private BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> getAllBrands() throws Exception {

        List<Brand> brands = brandRepository.getAllBrands();

        if (!brands.isEmpty())
            return brands;
        else
            throw new NoDataException(NO_BRANDS_FOUND);
    }
}
