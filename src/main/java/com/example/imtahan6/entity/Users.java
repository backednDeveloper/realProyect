package com.example.imtahan6.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Table(name = "users")
public class Users implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "password")
    private String password;
    @Column(name = "birthdate")
    private LocalDate birthdate;
    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @NotBlank
    private String email;
    public Users() {
    }

    public Users(Long id) {
        this.id = id;
    }

    private String username;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;


//        @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<String> authorities = Arrays.asList("READ", "SEARCH", "CREATE", "UPDATE", "DELETE");
//      List<Collection> collections = Collections.singletonList(authorities.stream()
//              .map(role -> "ROLE_" + role)
//              .collect(Collectors.toList()));
//        return (Collection<? extends GrantedAuthority>) collections;
//    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<String> authorities = Arrays.asList("READ", "SEARCH", "CREATE", "UPDATE", "DELETE");
        return authorities.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toList());
    }


}
