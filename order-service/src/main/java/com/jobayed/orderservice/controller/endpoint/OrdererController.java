package com.jobayed.orderservice.controller.endpoint;

import com.jobayed.orderservice.controller.model.request.OrderRequest;
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
@RequestMapping("api/order")
@RestController
@RequiredArgsConstructor
@Slf4j
public class OrdererController {

    @PostMapping
    public ResponseEntity<?> createCustomer(
            @RequestBody @Validated OrderRequest.Order request) {
        log.info("Creating customer with this request: {}", request);
        // return ResponseEntity.ok(customerService.create(request));
        return null;
    }

//    @GetMapping
//    public ResponseEntity<Page<CustomerDto>> getCustomerList(
//            @RequestParam Integer page, @RequestParam Integer pageSize) {
//        return ResponseEntity.ok(customerService.getCustomers(page, pageSize));
//    }
}
