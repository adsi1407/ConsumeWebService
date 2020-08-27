package com.example.dataaccess.anticorruption;

import com.example.dataaccess.dto.BrandDto;
import com.example.domain.entity.Brand;

import java.util.ArrayList;
import java.util.List;

public class BrandTranslator {

    public List<Brand> dtoListToEntityList(List<BrandDto> brandDtoList){

        List<Brand> brands = new ArrayList<>();
        for (int i = 0; i < brandDtoList.size(); i++) {
            BrandDto brandDto = brandDtoList.get(i);
            brands.add(new Brand(brandDto.getId(), brandDto.getName()));
        }
        return brands;
    }
}
