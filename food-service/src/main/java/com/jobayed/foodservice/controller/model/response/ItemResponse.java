package com.jobayed.foodservice.controller.model.response;

import lombok.Builder;
import lombok.Data;

public class ItemResponse {
    @Data
    @Builder
    public static class Add {
        String message;
    }
}
