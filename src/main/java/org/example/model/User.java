package org.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "grras_users_test")
@CompoundIndexes({
        @CompoundIndex(name = "email_age_idx", def = "{'email': 1, 'age': -1}")
})
@TypeAlias("Grras_Users_Test")
public class User {

    @Id
    private String id;
    @Indexed(direction = IndexDirection.DESCENDING)
    private String name;
    private String email;
    private int age;

    //@Transient
    private String password;
    @Indexed(direction = IndexDirection.DESCENDING)
    private Double salary;

    public User() {}

    public User(String name, String email, int age, String password, Double salary) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.password = password;
        this.salary = salary;
    }

    // Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }
}
