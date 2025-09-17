package com.neighbourly.listing.mapper;

import com.neighbourly.listing.dto.ItemDto;
import com.neighbourly.listing.entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = ItemImageMapper.class)
public interface ItemMapper {

    ItemDto toDto(Item item);
    Item toEntity(ItemDto itemDto);
    Item toEntity(ItemDto itemDto, @MappingTarget Item item);
    default List<ItemDto> toDtoList(List<Item> items) {
        return items.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

}
