package com.jobayed.orderservice.controller.endpoint;

import com.jobayed.orderservice.controller.model.request.OrderRequest;
import com.jobayed.orderservice.service.CustomerService;
import com.jobayed.orderservice.service.OrderService;
import jdk.jshell.JShell;
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
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody @Validated OrderRequest.Order request) {
        log.info("Creating Order with this request: {}", request);
        return ResponseEntity.ok(orderService.createOrder(request));
    }

//    @GetMapping
//    public ResponseEntity<Page<CustomerDto>> getCustomerList(
//            @RequestParam Integer page, @RequestParam Integer pageSize) {
//        return ResponseEntity.ok(customerService.getCustomers(page, pageSize));
//    }
}
