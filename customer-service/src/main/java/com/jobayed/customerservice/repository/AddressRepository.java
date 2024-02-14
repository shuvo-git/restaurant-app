package com.jobayed.customerservice.repository;

import com.jobayed.customerservice.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/14/24 8:32 PM
 */

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
