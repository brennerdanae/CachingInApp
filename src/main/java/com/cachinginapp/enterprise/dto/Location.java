package com.cachinginapp.enterprise.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

public @Data class Location {
    @SerializedName("State")
    private String state;
    @SerializedName("County")
    private String county;
    @SerializedName("City")
    private String city;
    @SerializedName("Zip-Code")
    private Integer zip;
    @SerializedName("Longitude")
    private Integer longitude;
    @SerializedName("Latitude")
    private Integer latitude;

}
