package com.security.securirtywithjpa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class User {
    @Id
    private int Id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private int active;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User(User user) {
        this.active=user.getActive();
        this.email=user.getEmail();
        this.firstName=user.getFirstName();
        this.lastName=user.getLastName();
        this.password=user.getPassword();
        this.roles=user.getRoles();
        this.Id=user.getId();
    }
}
