package com.jobayed.customerservice.repository;

import com.jobayed.customerservice.entity.CustomerEntity;
import com.jobayed.customerservice.entity.dto.CustomerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/14/24 7:52 PM
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    @Query("SELECT " +
            " c.id AS id, " +
            " c.name AS name, " +
            " c.phoneNumber AS phoneNumber, " +
            " c.status AS status, " +
            " a.location AS location, " +
            " a.city AS city, " +
            " a.postCode AS postCode, " +
            " c.createdAt AS createdAt" +
            " FROM CustomerEntity c" +
            " JOIN AddressEntity a ON c.address = a ")
    Page<CustomerDto> getCustomerList(Pageable pageable);
}
