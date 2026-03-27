package crudhexagonal.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtService jwtService) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .headers(headers -> headers.frameOptions(frame -> frame.disable()))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll()
                        .requestMatchers("/auth/**").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(new JwtFilter(jwtService),
                        org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
