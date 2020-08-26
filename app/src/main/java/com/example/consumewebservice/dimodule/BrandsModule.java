package com.example.consumewebservice.dimodule;

import com.example.dataaccess.repository.brand.BrandRepositoryImpl;
import com.example.domain.repository.BrandRepository;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

@Module
@InstallIn(ActivityComponent.class)
public abstract class BrandsModule {

    @Binds
    public abstract BrandRepository bindBrandRepository(BrandRepositoryImpl brandRepository);
}
