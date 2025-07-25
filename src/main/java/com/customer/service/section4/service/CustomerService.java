package com.customer.service.section4.service;

import com.customer.service.section4.request.CustomerRequest;
import java.util.Collection;

/**
 * Service interface defining customer operations.
 * Follows the Service Layer pattern to abstract and encapsulate business logic.
 * <p>
 * Implementations of this interface handle core customer management
 * such as creation, retrieval, updating, and deletion of customer data.
 */
public interface CustomerService {

    /**
     * Creates a new customer in the system.
     *
     * @param request Customer details from the client
     * @return Status message indicating success or failure
     */
    String createCustomer(CustomerRequest request);


    /**
     * Retrieves all customers from the system.
     *
     * @return A collection of all customer records
     */
    Collection<CustomerRequest> getCustomerData();

    /**
     * Retrieves a specific customer by their unique ID.
     *
     * @param id The ID of the customer
     * @return The customer details as a DTO
     */
    CustomerRequest getCustomerById(Long id);

    /**
     * Deletes a customer from the system using their ID.
     *
     * @param id The ID of the customer to delete
     * @return Status message after deletion
     */
    String deleteCustomerById(Long id);

    /**
     * Updates all the details of an existing customer.
     *
     * @param request Updated customer data
     * @return Status message after update
     */
    String updateCustomerDetails(CustomerRequest request);

    /**
     * Updates only the mobile number of a specific customer.
     *
     * @param id Customer ID
     * @param mobile_number New mobile number to set
     * @return Status message after updating the mobile number
     */
    String updateMobileNumber(Long id, String mobile_number);
}
