package com.topica.vn.security;

import com.topica.vn.model.Role;
import com.topica.vn.model.User;
import com.topica.vn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DatabaseUserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username);

      if (user == null) {
          System.out.println("User not found! " + username);
          throw new UsernameNotFoundException("User " + username + " was not found in the database");
      }

      System.out.println("Found User: " + user.getUsername());

      List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
      if (user.getRoles() != null) {
          for (Role role : user.getRoles()) {
              GrantedAuthority authority = new SimpleGrantedAuthority(role.getCode());
              grantList.add(authority);
          }
      }

      return (UserDetails) new org.springframework.security.core.userdetails.User(user.getUsername(),
              user.getPassword(), grantList);
  }
}
