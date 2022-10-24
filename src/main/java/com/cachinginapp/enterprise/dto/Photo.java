package com.cachinginapp.enterprise.dto;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

public class Photo {
    @Id
    @GeneratedValue
    private int photoId;
    private String photographer;
    private String path;
    private String fileName;
    private String comments;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="cacID")
    private Cache cache;
}
