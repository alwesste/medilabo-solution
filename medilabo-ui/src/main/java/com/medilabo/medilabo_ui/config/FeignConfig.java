//package com.medilabo.medilabo_ui.config;
//
//import feign.RequestInterceptor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AnonymousAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.GrantedAuthority;
//
//@Configuration
//public class FeignConfig {
//
//    @Bean
//    public RequestInterceptor authHeaderInterceptor() {
//        return requestTemplate -> {
//            Authentication auth =
//                    SecurityContextHolder.getContext().getAuthentication();
//
//            if (auth != null && auth.isAuthenticated()
//                    && !(auth instanceof AnonymousAuthenticationToken)) {
//
//                requestTemplate.header("X-Auth-User", auth.getName());
//
//                String role = auth.getAuthorities()
//                        .stream()
//                        .findFirst()
//                        .map(GrantedAuthority::getAuthority)
//                        .orElse("");
//
//                requestTemplate.header("X-Auth-Role", role);
//            }
//        };
//    }
//}
