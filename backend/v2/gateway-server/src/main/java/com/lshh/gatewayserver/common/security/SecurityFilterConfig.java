package com.lshh.gatewayserver.common.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityFilterConfig {
    
    @Bean
    public SecurityWebFilterChain filterChain(ServerHttpSecurity http) throws Exception{
        // http.authorizeExchange(
        //     exchanges -> exchanges
        //         // any URL that starts with /admin/ requires the role "ROLE_ADMIN"
        //         .pathMatchers("/admin/**").hasRole("ADMIN")
        //         // a POST to /users requires the role "USER_POST"
        //         .pathMatchers(HttpMethod.POST, "/users").hasAuthority("USER_POST")
        //         // a request to /users/{username} requires the current authentication's username
        //         // to be equal to the {username}
        //         .pathMatchers("/users/{username}").access((authentication, context) ->
        //             authentication
        //                 .map(Authentication::getName)
        //                 .map((username) -> username.equals(context.getVariables().get("username")))
        //                 .map(AuthorizationDecision::new)
        //         )
        //     );
        
        http
            .httpBasic(exchanges->
                exchanges.disable())
            .formLogin(exchanges->
                exchanges.disable())
            .cors(exchanges->
                exchanges.disable())
            .csrf(exchanges->
                exchanges.disable());

            

        return http.build();
    }
}
