package com.jobayed.orderservice.service;

import com.jobayed.orderservice.entity.ItemEntity;

import java.util.List;
import java.util.Map;

public interface ItemService {
    void addItem(ItemEntity item);

    Map<Long, ItemEntity> findItemsByIds(List<Long> longStream);
}
