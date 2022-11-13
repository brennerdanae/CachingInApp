package com.cachinginapp.enterprise.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public @Data class Photo
{
    @Id
    @GeneratedValue
    private int photoId;
    private String photographer;
    private String path;
    private String fileName;
    private String comments;
}
