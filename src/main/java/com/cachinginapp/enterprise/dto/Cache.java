package com.cachinginapp.enterprise.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public @Data class Cache {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int cacheID;
    private String latitude;
    private String longitude;
    private String description;

}
