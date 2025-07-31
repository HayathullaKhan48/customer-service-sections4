package com.customer.service.section4.repository;

import com.customer.service.section4.entity.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA Repository for CustomerModel entities
 * provides CURD operations out the box
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {

    //Spring Data JPA will implement all basic CURD operation automatically
    //Custom queries can be added here as needed

}