package pl.edytab.automationorder.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface AppUserDetailsService {

    UserDetails loadUserByUsername(String email);
}
