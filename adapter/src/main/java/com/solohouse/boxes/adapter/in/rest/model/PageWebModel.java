package com.solohouse.boxes.adapter.in.rest.model;

import lombok.Builder;

import java.util.List;

@Builder
public record PageWebModel<T>(List<T> content, int page, int size, long totalElements, int totalPages) {
}
