package com.jobayed.customerservice.service;

import com.jobayed.customerservice.controller.model.request.CustomerRequest;
import com.jobayed.customerservice.controller.model.response.CustomerResponse;
import com.jobayed.customerservice.entity.dto.CustomerDto;
import org.springframework.data.domain.Page;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/14/24 7:57 PM
 */

public interface CustomerService {
    CustomerResponse.Create create(CustomerRequest.Customer request);

    Page<CustomerDto> getCustomers(Integer page, Integer pageSize);
}
