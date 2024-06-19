package com.aluraLatam.foroHubChallenge.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.List;

@Entity(name= "User")
@Table(name="users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true)
    private String email;
    private String username;
    private String password;

    public String getEmail() {
        return email;
    }
    public User(DataRegister dataRegister) {
        this.name=dataRegister.name();
        this.email=dataRegister.email();
        this.username=dataRegister.username();
        this.password=dataRegister.password();
    }

    public User(Long id) {
        this.id=getId();
    }


    public User(DataRegister dataRegister, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.name=dataRegister.name();
        this.email=dataRegister.email();
        this.username=dataRegister.username();
        this.password= bCryptPasswordEncoder.encode(dataRegister.password());
    }

    public void updateData (UserDataUpdate userDataUpdate){
        if (userDataUpdate.name() != null){
            this.name=userDataUpdate.name();
        }
        if (userDataUpdate.email() != null){
            this.email=userDataUpdate.email();
        }

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }
    @Override
    public String getPassword(){
        return password;
    }
    @Override
    public String getUsername(){
        return username;
    }



    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Integer getId() {
        return id;
    }
}
