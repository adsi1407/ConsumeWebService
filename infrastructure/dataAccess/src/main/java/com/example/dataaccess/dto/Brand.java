package com.example.dataaccess.dto;

import com.google.gson.annotations.SerializedName;

public class Brand {

    @SerializedName("codigo")
    private String id;

    @SerializedName("nome")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
