package com.neighbourly.listing.dto;

public class ItemImageDto {
    private Long id;

    private String url;  // S3 / Cloudinary / CDN link

    private boolean isPrimary;  // true → used in list view

    private int displayOrder;   // 1,2,3 for ordering in details view

}
