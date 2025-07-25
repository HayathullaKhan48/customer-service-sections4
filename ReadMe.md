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
- Method: POST
- URL : ```http://localhost:8080/api/customer/v1/create```
- Request Body :
```
{
    "username": "sadakhat1",
    "mobileNumber": "89898989891",
    "emailAddress": "sada@gmai1l.com",
    "customerAge": 35
}
```
- Response Body: "successfully registered..."

## Database Schema (MySQL Workbench)
- Table Structure: `customer_details`
  - create database customer_db
  - use customer_db
### Input in Database
```
   select * from customer_details 
```
### Output in Database (input system-generated fields):
```aiignore
| id | created_date  | customer_age | email_address          | mobile_number  | password    | updated_date  | user_status  |
|----|---------------|--------------|------------------------|----------------|-------------|---------------|--------------|
| 1  | 37:40.5       | 35           | sada@gmail.com         | 89898989891    | Te1@tfKeMx  | 05:39.2       | active       |

```
### Get All Customers
- Method: GET
- URL : ```http://localhost:8080/api/customer/v1/getAllData```
- Request Body : null 
- Response Body:
```
[
    {
        "id": 1,
        "username": "sadakhat",
        "mobileNumber": "89898989891",
        "emailAddress": "sada@gmail.com",
        "customerAge": 35,
        "password": "Te1@tfKeMx",
        "userStatus": "active"
    },
    {
        "id": 3,
        "username": "Aakif",
        "mobileNumber": "80000232",
        "emailAddress": "Aakif@gmai1l.com",
        "customerAge": 3,
        "password": "Sn3*Usj*r2",
        "userStatus": "active"
    },
    {
         "id": 4,
         "username": "Hayathulla",
         "mobileNumber": "8985415771",
         "emailAddress": "hayathulla@gmai1l.com",
         "customerAge": 24,
         "password": "Dg6%Wjko_v",
         "userStatus": "active"
}
    {
        "id": 5,
        "username": "Hayathulla",
        "mobileNumber": "8985415771",
        "emailAddress": "hayathulla@gmai1l.com",
        "customerAge": 24,
        "password": "Dw3+5z1Zbk",
        "userStatus": "active"
    },
    {
        "id": 6,
        "username": "sufiyan",
        "mobileNumber": "6304474604",
        "emailAddress": "sufiyan@gmai1l.com",
        "customerAge": 17,
        "password": "Ux3$If#0k!",
        "userStatus": "active"
    },
    {
        "id": 7,
        "username": "Arzoo",
        "mobileNumber": "3456787654",
        "emailAddress": "sufiyan@gmai1l.com",
        "customerAge": 18,
        "password": "Sl9&C-UgG!",
        "userStatus": "active"
    }
]

```
## Database Schema (MySQL Workbench)
### Input in Database
```
  select * from customer_details
```
### Output in Database (input system-generated fields):
```aiignore
| id | created_date  | customer_age | email_address          | mobile_number  | password    | updated_date  | user_status  |
|----|---------------|--------------|------------------------|----------------|-------------|---------------|--------------|
| 1  | 37:40.5       | 35           | sada@gmail.com         | 6304474604     | Te1@tfKeMx  | 05:39.2       | active       |
| 3  | 25:31.8       | 3            | Aakif@gmai1l.com       | 80000232       | Sn3*Usj*r2  | 44:44.0       | active       |
| 5  | 36:49.0       | 24           | hayathulla@gmai1l.com  | 8985415771     | Dw3+5z1Zbk  | 36:49.0       | active       |
| 6  | 38:12.0       | 17           | sufiyan@gmai1l.com     | 6304474604     | Ux3$If#0k!  | 38:12.0       | active       |
| 7  | 04:30.5       | 18           | sufiyan@gmai1l.com     | 3456787654     | Sl9&C-UgG!  | 04:30.5       | active       |

```

### Get Customer By ID
- Method: GET
- URL : ```http://localhost:8080/api/customer/v1/getById/4```
- Request Body : null 
- Response Body:
```
{
    "id": 4,
    "username": "Hayathulla",
    "mobileNumber": "8985415771",
    "emailAddress": "hayathulla@gmai1l.com",
    "customerAge": 24,
    "password": "Dg6%Wjko_v",
    "userStatus": "active"
}

```
## Database Schema (MySQL Workbench)
### Input in Database
```
  select * from customer_details
```
### Output in Database (input system-generated fields):
```
| id | created_date  | customer_age | email_address          | mobile_number  | password    | updated_date  | user_status  |
|----|---------------|--------------|------------------------|----------------|-------------|---------------|--------------|
| 4  | 37:40.5       | 24           | hayathulla@gmail.com   | 8985415771     | Tewyebf324  | 05:39.2       | active       |
```
### Delete Customer By ID
- Method: DELETE
- URL : ```http://localhost:8080/api/customer/v1/deleteById/4```
- Request Body : null 
- Response Body: Customer deleted Successfully!
## Database Schema (MySQL Workbench)
### Input in Database
```
  select * from customer_details
```
### Output in Database (input system-generated fields):
```
| id | created_date  | customer_age | email_address          | mobile_number  | password    | updated_date  | user_status  |
|----|---------------|--------------|------------------------|----------------|-------------|---------------|--------------|
|    |               |              |                        |                |             |               |              |
```


### Update Customer Details
- Method: PUT
- URL : ```http://localhost:8080/api/customer/v1/update```
- Request Body : 
```
 {
        "id": 3,
        "username": "Aakif",
        "mobileNumber": "80000232",
        "emailAddress": "Aakif@gmai1l.com",
        "customerAge": 3,
        "password": "Sn3*Usj*r2",
        "userStatus": "active"
 }
    
```
- Response Body: Customer updated successfully!

## Database Schema (MySQL Workbench)
### Input in Database
```
  select * from customer_details
```
### Output in Database (input system-generated fields):
```
| id | created_date  | customer_age | email_address          | mobile_number  | password    | updated_date  | user_status  |
|----|---------------|--------------|------------------------|----------------|-------------|---------------|--------------|
| 3  | 37:40.5       | 3            | Aakif@gmail.com        | 80000232       | mnbkb7f324  | 06:39.2       | active       |
```

### Update Mobile Number
- Method: PATCH
- URL : ```http://localhost:8080/api/customer/v1/updateMobileNumber/1/6304474604```
- Request Body : null 
- Response Body: Mobile number updated successfully

## Database Schema (MySQL Workbench)
### Input in Database
```
  select * from customer_details
```
### Output in Database (input system-generated fields):
```
| id | created_date  | customer_age | email_address          | mobile_number  | password    | updated_date  | user_status  |
|----|---------------|--------------|------------------------|----------------|-------------|---------------|--------------|
| 1  | 37:40.5       | 35            | sada@gmail.com        | 6304474604       | 90jkb7f324  | 06:51.2       | active       |
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



