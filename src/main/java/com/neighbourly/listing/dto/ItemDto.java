package com.neighbourly.listing.dto;


import com.neighbourly.listing.constants.CATEGORY;
import com.neighbourly.listing.constants.ITEM_CONDITION;
import com.neighbourly.listing.constants.VISIBILITY;
import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class ItemDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private CATEGORY category;
    private ITEM_CONDITION condition;
    private Long communityId;
    private Long userId;
    private VISIBILITY visibility;

    private Set<ItemImageDto> itemImages = new HashSet<>();
}
