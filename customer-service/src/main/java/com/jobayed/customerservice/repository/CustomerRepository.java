package com.jobayed.customerservice.repository;

import com.jobayed.customerservice.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/14/24 7:52 PM
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
