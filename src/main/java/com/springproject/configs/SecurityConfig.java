package com.springproject.configs;


import com.springproject.security.jwt.JwtConfigurer;
import com.springproject.security.jwt.JwtTokenFilter;
import com.springproject.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    private JwtTokenProvider jwtTokenProvider;


    @Autowired
    public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }



    @Override
    public void configure(HttpSecurity http) throws Exception
    {
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

}
