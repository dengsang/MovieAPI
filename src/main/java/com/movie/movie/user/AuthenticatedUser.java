package com.movie.movie.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

import static java.util.Collections.emptyList;

@RequiredArgsConstructor
public class AuthenticatedUser {

    private final String username;
    private final String password;

   // @Override
    public Collection<?extends GrantedAuthority> getAuthorities() {
        return emptyList();
    }

    //@Override
    @JsonIgnore
    public String getPassword()
    {
        return password;
    }

    //@Override
    public String getUsername() {
        return username;
    }

    //@Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //@Override
    public boolean isAccountNonLocked() {
        return true;
    }

   // @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

   // @Override
    public boolean isEnabled() {
        return true;
    }

}
