package com.springproject.сonfigs;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.springproject.filters.CsrfTokenResponseHeaderBindingFilter;
import com.springproject.security.jwt.JwtConfigurer;
import com.springproject.security.jwt.JwtTokenFilter;
import com.springproject.security.jwt.JwtTokenProvider;
import com.springproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;

import javax.sql.DataSource;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    private UserService userService;
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Autowired
    public void setUserService(UserService userService)
    {
        this.userService = userService;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception
    {
        CsrfTokenResponseHeaderBindingFilter csrfTokenResponseHeaderBindingFilter = new CsrfTokenResponseHeaderBindingFilter();
         JwtTokenFilter jwtTokenFilter = new JwtTokenFilter(jwtTokenProvider);
        http
                .httpBasic().disable()
                .csrf().disable()

                .authorizeRequests()
                    .antMatchers("/student/**").authenticated()
                    .antMatchers("/profile/**").authenticated()
                    .antMatchers("/api/login/**").permitAll()
                    .antMatchers("/api/**").authenticated()
                    .antMatchers("/account/**").permitAll()
                    .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .and()
                    .formLogin()
                .and()
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(csrfTokenResponseHeaderBindingFilter,CsrfFilter.class)
                    .logout()
                        .logoutSuccessUrl("/")
                .and()
                    .apply(new JwtConfigurer(jwtTokenProvider));
    }

//    @Bean
//    public UserDetailsService users(){
//        UserDetails user = User.builder()
//                .username("user")
//                .password("{bcrypt}$2a$10$bsCUED.ZQbiWicjxtM.bFu/CsvZqp1h6i8gG/rB5JqwYwHPnwlGmm")
//                .roles("USER")
//                .build();
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("{bcrypt}$2a$10$bsCUED.ZQbiWicjxtM.bFu/CsvZqp1h6i8gG/rB5JqwYwHPnwlGmm")
//                .roles("ADMIN","USER")
//                .build();
//        return new InMemoryUserDetailsManager(user,admin);
//    }




    @Bean
    public CsrfTokenResponseHeaderBindingFilter csrfTokenResponseHeaderBindingFilter() {
        return new CsrfTokenResponseHeaderBindingFilter();
    }
}
