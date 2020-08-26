package com.example.consumewebservice.viewmodel;

import android.os.AsyncTask;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.domain.entity.Brand;
import com.example.domain.service.BrandService;

import java.util.List;

public class BrandViewModel extends ViewModel {

    private MutableLiveData<List<Brand>> brands;

    private final BrandService brandService;

    @ViewModelInject
    public BrandViewModel(BrandService brandService) {

        this.brandService = brandService;
    }

    public LiveData<List<Brand>> getAllBrands() {

        if (brands == null) {
            brands = new MutableLiveData<>();
            loadAllBrands();
        }
        return brands;
    }

    private void loadAllBrands() {

        BrandsAsyncTask brandsAsyncTask = new BrandsAsyncTask();
        brandsAsyncTask.execute();
    }

    class BrandsAsyncTask extends AsyncTask<String, String, List<Brand>> {


        @Override
        protected List<Brand> doInBackground(String... strings) {
            return brandService.getAllBrands();
        }

        @Override
        protected void onPostExecute(List<Brand> brandsFromTask) {
            super.onPostExecute(brandsFromTask);
            brands.setValue(brandsFromTask);
        }
    }
}
