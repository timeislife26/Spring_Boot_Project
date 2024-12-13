package com.example.myproject.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "myusers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyUser {
    @Id
    private String username;
    private String password;
    private String role;
    private String firstName;
    private String lastName;
    private boolean enabled = true;
    private boolean accountNonExpired = true;
    private boolean credentialsNonExpired = true;
    private boolean accountNonLocked = true;
}
