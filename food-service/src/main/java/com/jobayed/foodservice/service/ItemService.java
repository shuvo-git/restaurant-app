package com.jobayed.foodservice.service;

import com.jobayed.foodservice.controller.model.request.ItemRequest;
import com.jobayed.foodservice.controller.model.response.ItemResponse;

public interface ItemService {
    ItemResponse.Add addItem(ItemRequest.Add request);
}
