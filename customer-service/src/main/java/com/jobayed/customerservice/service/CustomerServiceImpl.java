package com.jobayed.customerservice.service;

import com.jobayed.customerservice.controller.model.request.CustomerRequest;
import com.jobayed.customerservice.controller.model.response.CustomerResponse;
import com.jobayed.customerservice.entity.AddressEntity;
import com.jobayed.customerservice.entity.CustomerEntity;
import com.jobayed.customerservice.repository.AddressRepository;
import com.jobayed.customerservice.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    private final CustomerRepository repository;
    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public CustomerResponse.Create create(CustomerRequest.Customer request) {
        AddressEntity addressEntity = AddressEntity.builder()
                .location(request.getLocation())
                .city(request.getCity())
                .postCode(request.getPostCode())
                .build();
        addressEntity = addressRepository.save(addressEntity);

        CustomerEntity entity = CustomerEntity.builder()
                .name(request.getName())
                .phoneNumber(request.getPhoneNumber())
                .status(request.getStatus())
                .address(addressEntity)
                .build();
        repository.save(entity);

        return CustomerResponse.Create.builder().message("Customer successfully created!").build();
    }
}
