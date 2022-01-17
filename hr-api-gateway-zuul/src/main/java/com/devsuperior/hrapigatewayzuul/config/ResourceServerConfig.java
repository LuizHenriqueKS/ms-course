package com.devsuperior.hrapigatewayzuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Configuration
public class ResourceServerConfig {

    private final AuthenticationManager authenticationManager;
    private final BearerTokenConverter bearerTokenConverter;

    private static final String[] PUBLIC = { "/hr-oauth/oauth/token" };
    private static final String[] OPERATOR = { "/hr-worker/**" };
    private static final String[] ADMIN = { "/hr-payroll/**", "/hr-user/**", "/hr-oauth/**", "/actuactor/**",
            "/hr-worker/actuator/**", "/hr-oauth/actuator/**" };

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http.csrf().disable()
                .authorizeExchange()
                .pathMatchers(PUBLIC).permitAll()
                .pathMatchers(OPERATOR).hasAnyRole("OPERATOR", "ADMIN")
                .pathMatchers(ADMIN).hasRole("ADMIN")
                .anyExchange().authenticated(); // Todos os outros recursos precisam estar autenticados
        http.oauth2ResourceServer()
                .authenticationManagerResolver(exchange -> Mono.just(authenticationManager))
                .bearerTokenConverter(bearerTokenConverter);
        return http.build();
    }

}
