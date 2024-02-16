package com.jobayed.foodservice.controller.endpoint;

import com.jobayed.foodservice.controller.model.request.ItemRequest;
import com.jobayed.foodservice.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/13/24 5:52 PM
 */
@RequestMapping("api/item")
@RestController
@RequiredArgsConstructor
@Slf4j
public class ItemController {
    private final ItemService itemService;
    @PostMapping
    public ResponseEntity<?> createItem(
            @RequestBody @Validated ItemRequest.Add request) {
        log.info("Creating Item with this request: {}", request);
        return ResponseEntity.ok(itemService.addItem(request));
    }

//    @GetMapping
//    public ResponseEntity<Page<CustomerDto>> getCustomerList(
//            @RequestParam Integer page, @RequestParam Integer pageSize) {
//        return ResponseEntity.ok(customerService.getCustomers(page, pageSize));
//    }
}
