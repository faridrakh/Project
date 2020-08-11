package com.brs.project.auth.entity;

import com.brs.project.user.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {
    private String id;
    private String fullName;
    private String userName;
    @JsonIgnore
    private String email;
    @JsonIgnore
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    public UserPrincipal(String id, String fullName, String userName, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.fullName = fullName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
        this.enabled = true;
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
    }

    public static UserPrincipal create(User user,String role) {
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+role);

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(authority);

        return new UserPrincipal(
                user.getId(),
                user.getFullName(),
                user.getUserName(),
                user.getEmail(),
                user.getPassword(),
                authorities
        );
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
