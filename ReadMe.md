# Customer service API
A Spring Boot microservice for managing customer data with secure password generation.

## Features
- REST full API endpoints
- Secure password generation
- Automatic timestamp management
- Cleanly layered architecture
- Lombok for boilerplate reduction
- JPA/Hibernate for persistence
- MySQL database integration
- Clean layered architecture

## API Endpoints
### Create Customer
**POST:** 
```
    http://localhost:8080/api/customer/v1/create
```
**Request Body:**
```
{
    "username": "sadakhat1",
    "mobileNumber": "89898989891",
    "emailAddress": "sada@gmai1l.com",
    "customerAge": 35
}
```
**Request Body:** "successfully registered..."

## Database Schema (MySQL Workbench)
### Table Structure: `customer_details`
### Input in Database
```
   select * from customer_details 
   create database customer_db 
   use customer_db
```
### Output in Database (input system-generated fields):
```
-- | id | username | mobile_number | email_address    | customer_age | password   | user_status | created_date                 | updated_date                 |
-- |----|----------|---------------|------------------|--------------|------------|-------------|------------------------------|------------------------------|
-- | 1  | sadakhat | 8989898989    | sada@gmail.com   | 35           | A1b$9XqL!z | active      | 2025-07-24 17:38:10.292773   | 2025-07-24 17:38:10.292773   |
-- | 2	|sadakhat1 |89898989891    |sada@gmai1l.com	  | 35	         |Ac3&KfWz%%  |	active	    | 2025-07-24 17:38:10.292773   |  2025-07-24 17:38:10.292773  |
```

## Technical Architecture
### Components
1. **Controller Layer:** 'CustomerController'
   - Handles HTTP requests
   - Perform input validation
   - Return appropriate responses
2. **Service Layer:**'CustomerService' and 'CustomerServiceImpl' 
   - Contains business logic
   - Generates secure passwords
   - Manages transaction boundaries
3. **Repository Layer:** 'CustomerRepository'
   - Database operations
   - Extends Spring Data JPA
   - Automatic CRUD implementation
4. **Entities/DTOs**
   - `CustomerModel`: JPA Entity
   - `CustomerRequest`: API Data Transfer Object

## Password Generation
The system automatically generates secure 10-character passwords containing:
- At least 1 uppercase letter
- At least 1 lowercase letter
- At least 1 digit
- At least 1 special character
- Randomly selected remaining characters


## Dependencies
- Spring Boot Starter Web
- Spring Data JPA
- Lombok
- MySQL Driver

## Future Enhancements
1. Add input validation annotations
2. Implement proper error handling
3. Add authentication/authorization
4. Implement password hashing
5. Add comprehensive unit tests



