package com.cachinginapp.enterprise.dto;

import lombok.Data;

public @Data
class Cache {
    private int cacheID;
    private int latitude;
    private int longitude;
    private String description;

}

class YourLocation {
    private int userID;
    private int userLatitude;
    private int userLongitude;
}