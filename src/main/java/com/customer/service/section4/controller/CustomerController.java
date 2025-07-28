package com.customer.service.section4.controller;

import com.customer.service.section4.request.CustomerRequest;
import com.customer.service.section4.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

/**
 * REST Controller for handling customer related operations
 */
@RestController
@RequestMapping("/api/customer/v1")
@RequiredArgsConstructor // Lombok annotation to generate constructor injection
public class CustomerController {

    //Injected customer service that contains business logic for all final fields (Dependency Injection)
    private final CustomerService customerService; //Customer service Injected

    /**
     * Endpoint to create a new customer.
     *
     * @param request the customer details from the client (JSON)
     * @return success message after saving the customer
     */
    @PostMapping("/create")
    public String createCustomer(@RequestBody CustomerRequest request){
        return customerService.createCustomer(request);
    }

    /**
     * Endpoint to get all customers
     *
     *
     * @return a collection of all customer details
     */
    @GetMapping("/getAllData")
    public Collection<CustomerRequest> getAllCustomers() {
        return customerService.getCustomerData();
    }

    /**
     * Endpoint to get a specific customer by ID.
     *
     * @param customerId the ID of the customer
     * @return the customer details
     */
    @GetMapping("/getById/{customerId}")
    public CustomerRequest getCustomerById(@PathVariable Long customerId){
        return customerService.getCustomerById(customerId);
    }

    /**
     * Endpoint to delete a customer by ID.
     *
     * @param customerId the ID of the customer to delete
     * @return success message after deletion
     */
    @DeleteMapping("/deleteById/{customerId}")
    public String deleteCustomerById(@PathVariable Long customerId){
        return customerService.deleteCustomerById(customerId);
    }

    /**
     * Endpoint to update entire customer details.
     *
     * @param request the updated customer data
     * @return success message after update
     */
    @PutMapping("/update")
    public String updateCustomerDetails(@RequestBody CustomerRequest request){
        return customerService.updateCustomerDetails(request);
    }

    /**
     * Endpoint to update only the mobile number of a customer using ID and new mobile number.
     * @param id the customer ID
     * @param mobileNumber the new mobile number to update
     * @return success message after mobile number update
     */
    @PatchMapping("updateMobileNumber/{id}/{mobileNumber}")
    public String updateMobileNumber(@PathVariable Long id, @PathVariable String mobileNumber){
        return customerService.updateMobileNumber(id, mobileNumber);
    }

}
