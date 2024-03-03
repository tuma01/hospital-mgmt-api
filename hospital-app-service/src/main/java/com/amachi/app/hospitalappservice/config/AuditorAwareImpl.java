package com.amachi.app.hospitalappservice.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl  implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Admin");
    }
}

// ------------------ Use below code for spring security --------------------------
/*class SpringSecurityAuditorAware implements AuditorAware<User> {

 public User getCurrentAuditor() {
  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
  if (authentication == null || !authentication.isAuthenticated()) {
   return null;
  }
  return ((MyUserDetails) authentication.getPrincipal()).getUser();
 }
}*/
