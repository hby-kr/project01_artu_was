package com.artu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

    // 현재 시큐리티 필터와 로그인 창 모두 꺼놓은 상태. 나중에 구현하려고.
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())     // CSRF 비활성화 (테스트용)
                .authorizeHttpRequests((auth) -> auth
                        .anyRequest().permitAll() // 모든 요청 허용
                )
                .formLogin(form -> form.disable());// 로그인 창도 제거

        return http.build();
    }

    @Bean
    // 비밀번호를 암호화해서 비교하기 위해 어떤 인코딩 방식을 쓸지 명시함.
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    // authenticationManager()는 스프링이 내부적으로 구성한 빌더를 사용하는 편리한 방식일 뿐임.
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class).build();
        //HttpSecurity 에서 AuthenticationManager "빌더"를 꺼내서 빌딩하고 반환하는 것일 뿐.
    }

}
