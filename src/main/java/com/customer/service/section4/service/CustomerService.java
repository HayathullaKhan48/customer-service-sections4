package com.customer.service.section4.service;

import com.customer.service.section4.request.CustomerRequest;

/**
 * Service interface defining customer operations
 * follows the Service Layer pattern to abstract business logic
 */
public interface CustomerService {

    /**
     * Creates a new customer in the system
     * @param request Customer details for creation
     * @return Status message after creations
     */
    String createCustomer(CustomerRequest request);
}
