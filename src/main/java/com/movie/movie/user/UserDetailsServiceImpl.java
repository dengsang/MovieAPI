package com.movie.movie.user;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl {

    private final UserRepository userRepository;

    //@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return ( UserDetails ) userRepository.findByLogin(username)
                .map(user -> new AuthenticatedUser(user.getLogin(), user.getPassword()))
                .orElseThrow(() -> new UsernameNotFoundException("User is not found"));
    }
}
