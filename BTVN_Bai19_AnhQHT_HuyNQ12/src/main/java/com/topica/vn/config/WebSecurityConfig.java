package com.topica.vn.config;

import com.topica.vn.security.CustomAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Qualifier("databaseUserDetailService")
  @Autowired
  UserDetailsService userDetailsService;

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }


  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

    // Setting Service to find User in the database.
    // And Setting PassswordEncoder
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
  }

  @Bean
  public AuthenticationSuccessHandler successHandler(){
    return new CustomAuthenticationSuccessHandler();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
            .antMatchers("/", "/home").permitAll()
        .and()
            .formLogin()
            .loginProcessingUrl("/j_spring_security_check") // Submit URL
            .loginPage("/login")
            .permitAll()
            .successHandler(successHandler())
            .failureUrl("/login?error=true")
            .usernameParameter("username")
            .passwordParameter("password")
            // Config for Logout Page
          .and()
            .logout()
            .permitAll()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login")
          .and()
            .authorizeRequests()
            .antMatchers("/admin/")
            .access("hasRole('ADMIN')")
            .anyRequest()
            .authenticated()
          .and()
            .exceptionHandling()
            .accessDeniedPage("/403");

  }
}
