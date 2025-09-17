package com.neighbourly.listing.entity;


import com.neighbourly.listing.constants.CATEGORY;
import com.neighbourly.listing.constants.ITEM_CONDITION;
import com.neighbourly.listing.constants.VISIBILITY;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Table(name = "items")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Item extends Auditable{
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;
    private String description;
    private Double price;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CATEGORY category;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ITEM_CONDITION condition;
    private Long communityId;
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @Enumerated(EnumType.STRING)
    private VISIBILITY visibility;
    @ElementCollection
    @CollectionTable(
            name = "item_custom_visibility",
            joinColumns = @JoinColumn(name = "item_id")
    )
    @Column(name = "community_id")
    private Set<Long> customNeighbourhoods = new HashSet<>();

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ItemImage> images = new HashSet<>();



}
