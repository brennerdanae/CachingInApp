package com.cachinginapp.enterprise.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/*
Location of user
 */
public @Data class Location {
    @SerializedName("UserID")
    private String userID;
    @SerializedName("Longitude")
    private Integer longitude;
    @SerializedName("Latitude")
    private Integer latitude;

}
