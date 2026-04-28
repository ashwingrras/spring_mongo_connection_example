package org.example.model;

import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.index.*;
import org.springframework.data.mongodb.core.mapping.*;
import jakarta.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Document(collection = "users")
@CompoundIndexes({
        @CompoundIndex(name = "email_age_idx", def = "{'email': 1, 'age': -1}")
})
@TypeAlias("UserWithMongoAnnotations")
public class UserWithMongoAnnotations {

    // Primary Key
    @Id
    private String id;

    // Basic Fields
    @Field("full_name")
    @NotNull
    @Size(min = 2, max = 50)
    private String name;

    @Indexed(unique = true)
    @Email
    private String email;

    @Indexed
    private int age;

    // Not stored in DB
    @Transient
    private String tempSessionToken;

    // Embedded object (no DBRef used → better performance)
    private Address address;

    // Reference to another collection (optional usage)
    @DBRef
    private List<Order> orders;

    // Full-text search index
    @TextIndexed
    private String bio;

    // Geolocation support (if needed)
    @GeoSpatialIndexed
    private double[] location; // [longitude, latitude]

    // Auditing fields
    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    private String updatedBy;

    // Optimistic locking
    @Version
    private Long version;

    // Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    public List<Order> getOrders() { return orders; }
    public void setOrders(List<Order> orders) { this.orders = orders; }
}