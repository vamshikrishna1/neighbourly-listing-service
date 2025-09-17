package com.neighbourly.listing.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Response<T> {
    private String uuid;
    private T data;
}
