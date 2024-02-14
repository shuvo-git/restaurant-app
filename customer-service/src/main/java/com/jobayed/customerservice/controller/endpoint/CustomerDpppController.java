package com.jobayed.customerservice.controller.endpoint;

import com.jobayed.customerservice.exception.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/13/24 5:52 PM
 */
@RequestMapping("api/customer2")
@RestController
@RequiredArgsConstructor
public class CustomerDpppController {
    @GetMapping("/{id}")
    public String getCustomer(@PathVariable("id") Long id) {
        return Optional.ofNullable(getCustomerById(id))
                .orElseThrow(CustomerNotFoundException::new);
    }

    String getCustomerById(Long id) {
        if (id == 100) {
            return "100";
        }
        return null;
    }
}
