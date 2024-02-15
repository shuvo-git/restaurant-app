package com.jobayed.customerservice.service;

import com.jobayed.customerservice.controller.model.request.CustomerRequest;
import com.jobayed.customerservice.controller.model.response.CustomerResponse;
import com.jobayed.customerservice.entity.AddressEntity;
import com.jobayed.customerservice.entity.CustomerEntity;
import com.jobayed.customerservice.entity.dto.CustomerDto;
import com.jobayed.customerservice.repository.AddressRepository;
import com.jobayed.customerservice.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/14/24 8:10 PM
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public CustomerResponse.Create create(CustomerRequest.Customer request) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setLocation(request.getLocation());
        addressEntity.setCity(request.getCity());
        addressEntity.setPostCode(request.getPostCode());
        addressEntity = addressRepository.save(addressEntity);

        CustomerEntity entity = new CustomerEntity();
        entity.setName(request.getName());
        entity.setPhoneNumber(request.getPhoneNumber());
        entity.setStatus(request.getStatus());
        entity.setAddress(addressEntity);
        customerRepository.save(entity);

        return CustomerResponse.Create.builder().message("Customer successfully created!").build();
    }

    @Override
    public Page<CustomerDto> getCustomers(Integer page, Integer pageSize) {
        PageRequest pageable = PageRequest.of(page, pageSize);
        return customerRepository.getCustomerList(pageable);
    }
}
