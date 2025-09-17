package com.neighbourly.listing.mapper;

import com.neighbourly.listing.dto.ItemImageDto;
import com.neighbourly.listing.entity.ItemImage;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring" )
public interface ItemImageMapper {

    ItemImageDto toDto(ItemImage itemImage);
    ItemImage toEntity(ItemImageDto itemImageDto);

    default List<ItemImageDto> toDtoList(List<ItemImage> itemImages) {
        return itemImages.stream()
                .map(this::toDto)
                .toList();
    }
}
