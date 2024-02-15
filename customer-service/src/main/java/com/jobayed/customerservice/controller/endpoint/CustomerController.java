package com.jobayed.customerservice.controller.endpoint;

import com.jobayed.customerservice.controller.model.request.CustomerRequest;
import com.jobayed.customerservice.controller.model.response.CustomerResponse;
import com.jobayed.customerservice.entity.dto.CustomerDto;
import com.jobayed.customerservice.service.CustomerService;
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
@RequestMapping("api/customer")
@RestController
@RequiredArgsConstructor
@Slf4j
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponse.Create> createCustomer(
            @RequestBody @Validated CustomerRequest.Customer request) {
        log.info("Creating customer with this request: {}", request);
        return ResponseEntity.ok(customerService.create(request));
    }

    @GetMapping
    public ResponseEntity<Page<CustomerDto>> getCustomerList(
            @RequestParam Integer page, @RequestParam Integer pageSize) {
        return ResponseEntity.ok(customerService.getCustomers(page, pageSize));
    }
}
