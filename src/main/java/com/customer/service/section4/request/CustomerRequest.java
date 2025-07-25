package com.customer.service.section4.request;

import lombok.*;

/**
 * Data Transfer object for customer creation requests
 * Contains only the fields needed for creating a customer
 * Separates API contract from a persistence model
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CustomerRequest {
    private Long id;
    private String username; // Customer's username
    private String mobileNumber; //Contact number
    private String emailAddress; //Email address
    private int customerAge;//Customer age in years
    private String password; // auto generate password
    private String userStatus; // customer userStatus
}
