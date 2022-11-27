package com.cachinginapp.enterprise.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
public @Data
class Cache {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int locationID;
    private int cacheID;
    private String latitude;
    private String longitude;
    private String description;

    @OneToMany(mappedBy = "cache")
    private List<Photo> photos;

}
