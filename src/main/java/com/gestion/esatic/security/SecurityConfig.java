package com.gestion.esatic.security;

import com.gestion.esatic.data.UserRepository;
import com.gestion.esatic.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final JpaUserDetailsService myUserDetailsService;

    public SecurityConfig(JpaUserDetailsService myUserDetailsService) {
        this.myUserDetailsService = myUserDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }




    @Bean
    public SecurityFilterChain web(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                                .requestMatchers("/static/**", "/images/**","/api/**","localhost:8000/admin/login").permitAll()
                                .anyRequest().authenticated()


                        //.requestMatchers(mvc.pattern("/design/")).permitAll()
                        //.requestMatchers(RegexRequestMatcher.regexMatcher("/design")).permitAll()



                )
                .userDetailsService(myUserDetailsService)
                //.headers(headers -> headers.frameOptions().sameOrigin())
                //.httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());
                /*.formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/home")
                        .permitAll()
                );*/


        return http.build();
    }



}