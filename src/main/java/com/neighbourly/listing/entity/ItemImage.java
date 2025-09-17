package com.neighbourly.listing.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "item_images")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class ItemImage {

    @Id
    @GeneratedValue
    private Long id;

    private String url;  // S3 / Cloudinary / CDN link

    private boolean isPrimary;  // true → used in list view

    private int displayOrder;   // 1,2,3 for ordering in details view

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;
}
