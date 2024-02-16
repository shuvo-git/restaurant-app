package com.jobayed.foodservice.controller.model.request;

import com.jobayed.foodservice.enums.Status;
import lombok.Data;

public interface ItemRequest {
    @Data
    public class Add {
        String name;
        double price;
        Status status;
    }
}


