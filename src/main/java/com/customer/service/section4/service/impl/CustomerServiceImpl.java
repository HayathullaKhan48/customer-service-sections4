package com.customer.service.section4.service.impl;

import com.customer.service.section4.entity.CustomerModel;
import com.customer.service.section4.repository.CustomerRepository;
import com.customer.service.section4.request.CustomerRequest;
import com.customer.service.section4.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Implementation of the CustomerService interface.
 * This class contains the core business logic for managing customer operations like
 * create, read, update, delete (CRUD), and utility features like password generation.
 */
@Service //Spring service component
@RequiredArgsConstructor // Lombok constructor injection
public class CustomerServiceImpl implements CustomerService {
    private static final String ACTIVE = "active"; //Default customer status
    private final CustomerRepository customerRepository; //Data access dependency

    /**
     * Creates a new customer by converting the request DTO to entity,
     * setting default values, and saving it to the database.
     *
     * @param request Customer details
     * @return Success message after creation
     */
    @Override
    public String createCustomer(CustomerRequest request) {
        CustomerModel customerModel = requestToModelConverter(request);
        customerRepository.saveAndFlush(customerModel);
        return " Customer created successfully...";
    }

    /**
     * Retrieves all customer records from the database and converts them to DTOs.
     *
     * @return Collection of customer data
     */
    @Override
    public Collection<CustomerRequest>getCustomerData(){
        return customerRepository.findAll().stream()
                .map(this::modelToRequestConverter)
                .collect(Collectors.toList());
    }

    /**
     * Converts a CustomerModel entity to a CustomerRequest DTO.
     *
     * @param model The entity object
     * @return Corresponding DTO object
     */
    private CustomerRequest modelToRequestConverter(CustomerModel model) {
        return CustomerRequest.builder()
                .id(model.getId())
                .username(model.getUsername())
                .mobileNumber(model.getMobileNumber())
                .emailAddress(model.getEmailAddress())
                .customerAge(model.getCustomerAge())
                .password(model.getPassword())
                .userStatus(model.getUserStatus())
                .build();
    }

    /**
     * Retrieves a single customer by ID.
     *
     * @param id ID of the customer
     * @return Customer details as DTO
     */
    @Override
    public CustomerRequest getCustomerById(Long id) {
        CustomerModel model = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + id));
        return modelToRequestConverter(model);
    }

    /**
     * Deletes a customer by ID.
     *
     * @param id ID of the customer to delete
     * @return Success message
     */
    @Override
    public String deleteCustomerById(Long id){
        customerRepository.deleteById(id);
        return "Customer deleted Successfully!";
    }

    /**
     * Updates all fields of an existing customer by ID.
     *
     * @param request Updated customer data
     * @return Success message
     */
    @Override
    public String updateCustomerDetails(CustomerRequest request) {
        CustomerModel model = customerRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        model.setUsername(request.getUsername());
        model.setMobileNumber(request.getMobileNumber());
        model.setEmailAddress(request.getEmailAddress());
        model.setCustomerAge(request.getCustomerAge());
        model.setUserStatus(request.getUserStatus());
        model.setPassword(request.getPassword());
        customerRepository.save(model);
        return "Customer updated successfully!";
    }

    /**
     * Update only the mobile number of a specific customer.
     *
     * @param id Customer ID
     * @param mobile_number New mobile number
     * @return Success message
     */
    @Override
    public String updateMobileNumber(Long id, String mobile_number){
        CustomerModel model = customerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Customer not Found"));
        model.setMobileNumber(mobile_number);
        customerRepository.save(model);
        return "Mobile number updated successfully";
    }

    /**
     * Converts CustomerRequest Data transfer object to customerModel entity
     * Sets default status and generates random password
     *
     * @param request Request Data transfer object
     * @return fully populated entity
     */
    private static CustomerModel requestToModelConverter(CustomerRequest request) {
        return CustomerModel.builder()
                .username(request.getUsername())
                .mobileNumber(request.getMobileNumber())
                .emailAddress(request.getEmailAddress())
                .customerAge(request.getCustomerAge())
                .userStatus(ACTIVE)
                .password(generatePassword())
                .build();
    }

    /**
     * Generates a random 10-character password
     * Contains at least one uppercase, one lowercase, one digit and one special character
     * @return Generated password
     */
    public static String generatePassword() {
        int length = 10;
        // Character sets
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String special = "!@#$%^&*()-_+=<>?";

        // Combine all characters
        String allChars = upper + lower + digits + special;

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        // Ensure at least one from each category
        password.append(upper.charAt(random.nextInt(upper.length())));
        password.append(lower.charAt(random.nextInt(lower.length())));
        password.append(digits.charAt(random.nextInt(digits.length())));
        password.append(special.charAt(random.nextInt(special.length())));

        // Fill the remaining length
        for (int i = 4; i < length; i++) {
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }

        return password.toString();
    }
}
