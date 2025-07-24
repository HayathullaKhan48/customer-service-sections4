package com.customer.service.section4.controller;

import com.customer.service.section4.request.CustomerRequest;
import com.customer.service.section4.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for handling customer related operations
 */
@RestController
@RequestMapping("/api/customer/v1")
@RequiredArgsConstructor // Lombok annotation to generate constructor injection
public class CustomerController {

    private final CustomerService customerService; //Customer service injection

    @PostMapping("/create")
    public String createCustomer(@RequestBody CustomerRequest request){
        return customerService.createCustomer(request);
    }

    // GetMapping

}
