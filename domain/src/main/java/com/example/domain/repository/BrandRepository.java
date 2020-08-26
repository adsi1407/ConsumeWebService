package com.example.domain.repository;

import com.example.domain.entity.Brand;

import java.io.IOException;
import java.util.List;

public interface BrandRepository {

    List<Brand> getAllBrands() throws IOException;
}
