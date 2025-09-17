package com.neighbourly.listing.web;

import com.neighbourly.listing.dto.HeaderInfo;
import com.neighbourly.listing.dto.ItemDto;
import com.neighbourly.listing.dto.Response;
import com.neighbourly.listing.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/{id}")
    public ResponseEntity<Response<ItemDto>> getItemById(@PathVariable Long id, HeaderInfo headers) {
        ItemDto itemDto = itemService.getItemById(id);
        Response<ItemDto> response = Response.<ItemDto>builder().data(itemDto).uuid(headers.getUuid()).build();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Response<ItemDto>> createItem(ItemDto itemDto, HeaderInfo headers) {
        ItemDto createdItem = itemService.createItem(itemDto);
        Response<ItemDto> response = Response.<ItemDto>builder().data(createdItem).uuid(headers.getUuid()).build();
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id, HeaderInfo headers) {
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<ItemDto>> updateItem(@PathVariable Long id, ItemDto itemDto, HeaderInfo headers) {
        ItemDto updatedItem = itemService.updateItem(id, itemDto);
        Response<ItemDto> response = Response.<ItemDto>builder().data(updatedItem).uuid(headers.getUuid()).build();
        return ResponseEntity.ok(response);
    }



}
