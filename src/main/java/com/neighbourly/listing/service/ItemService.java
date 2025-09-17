package com.neighbourly.listing.service;

import com.neighbourly.listing.constants.CATEGORY;
import com.neighbourly.listing.dto.ItemDto;
import com.neighbourly.listing.entity.Item;
import com.neighbourly.listing.exception.ItemNotFoundException;
import com.neighbourly.listing.mapper.ItemMapper;
import com.neighbourly.listing.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    private final ItemMapper itemMapper;

    public ItemDto getItemById(Long id) {
       Item item = itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Item not found"));
        return itemMapper.toDto(item);



    }


    public ItemDto createItem(ItemDto itemDto) {
        Item item = itemMapper.toEntity(itemDto);
        Item savedItem = itemRepository.save(item);
        return itemMapper.toDto(savedItem);
    }


    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }


    @Transactional
    public ItemDto updateItem(Long id, ItemDto itemDto) {
        Item existingItem = itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Item not found"));
        Item updatedItem = itemMapper.toEntity(itemDto, existingItem);
        return itemMapper.toDto(updatedItem);
    }
}
