package com.customer.service.section4.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;

/**
 * JPA Entity representing customer data in the database
 * Maps to customer_details table
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity //marks as JPA entity
@Table(name = "customer_details")
public class CustomerModel {

    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Numbers Auto-increment
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "customer_age")
    private int customerAge;

    @Column(name = "password")
    private String password;

    @Column(name = "user_status")
    private String userStatus;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP) //Data precision
    @CreationTimestamp //Auto-set on creation
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP) //Data precision
    @UpdateTimestamp //Auto-updated on creation
    private LocalDateTime updatedDate;
}
