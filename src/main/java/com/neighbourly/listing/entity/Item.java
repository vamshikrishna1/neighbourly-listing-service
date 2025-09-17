package com.neighbourly.listing.entity;


import com.neighbourly.constants.CATEGORY;
import com.neighbourly.constants.ITEM_CONDITION;
import com.neighbourly.constants.VISIBILITY;
import jakarta.persistence.*;

@Table(name = "items")
@Entity
public class Item {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private Double price;
    @Enumerated(EnumType.STRING)
    private CATEGORY category;
    @Enumerated(EnumType.STRING)
    private ITEM_CONDITION condition;
    private Long communityId;
    private Long userId;
    @Enumerated(EnumType.STRING)
    private VISIBILITY visibility;



}
