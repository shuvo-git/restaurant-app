package com.jobayed.orderservice.controller.endpoint;

import com.jobayed.orderservice.controller.model.request.OrderRequest;
import com.jobayed.orderservice.controller.model.response.OrderResponse;
import com.jobayed.orderservice.controller.model.response.SalesResponse;
import com.jobayed.orderservice.service.OrderService;
import com.jobayed.orderservice.service.SalesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/13/24 5:52 PM
 */
@RequestMapping("api/sales")
@RestController
@RequiredArgsConstructor
@Slf4j
public class SalesController {
    private final SalesService salesService;

//    @GetMapping("/{customerId}")
//    public ResponseEntity<Page<OrderResponse.OrderSummary>> getOrderListByCustomerId(
//            @PathVariable("customerId") Long customerId,
//            @RequestParam Integer page,
//            @RequestParam Integer pageSize) {
//        return ResponseEntity.ok(orderService.getOrdersByCustomerId(customerId, page, pageSize));
//    }

    @GetMapping("/today")
    public ResponseEntity<SalesResponse.TotalSales> getOrderListByCurrentDate(
            @RequestParam Integer page,
            @RequestParam Integer pageSize) {
//        return ResponseEntity.ok(orderService.getOrdersByCurrentDate(page, pageSize));
        return null;
    }

}
