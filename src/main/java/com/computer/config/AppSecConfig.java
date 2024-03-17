package com.computer.config;



import com.computer.service.appuser.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class AppSecConfig {
    @Autowired
    private AppUserService appUserService;
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) ->{
            authorize
                    .requestMatchers("/computers").permitAll()
                    .requestMatchers("/types").permitAll()
                    .requestMatchers("/computers/*").hasAnyRole("ADMIN","USER")
                    .requestMatchers("/types/*").hasAnyRole("ADMIN","USER")
                    .requestMatchers("/computers/update/*").hasRole("ADMIN")
                    .requestMatchers("/types/update/*").hasRole("ADMIN")
                    .requestMatchers("/computers/delete/*").hasRole("ADMIN")
                    .requestMatchers("/types/delete/*").hasRole("ADMIN")
                    .requestMatchers("/user/").hasRole("USER")
                    .requestMatchers("/types/create").hasAnyRole("ADMIN","USER")
                    .requestMatchers("/computers/create").hasAnyRole("ADMIN","USER");

        }).formLogin((authorizie)->authorizie.defaultSuccessUrl("/computers"));
        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider passwordEncoder(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(appUserService);
        authenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return  authenticationProvider;
    }

}