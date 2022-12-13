package com.syrongk.ddd.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.NullRequestCache;

import javax.sql.DataSource;

@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class WebSecurityConfig {
    public static final String AUTHCOOKIENAME = "AUTH";

    @Autowired
    private DataSource dataSource;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.securityContext().securityContextRepository(new CookieSecurityContextRepository(users(dataSource)));
        http.requestCache().requestCache(new NullRequestCache());

        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/", "/home", "/categories/**", "/products/**").permitAll()
                        .requestMatchers("/sample/hello").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin() // login
//                .loginPage("/login")
                .permitAll()
                .successHandler(new CustomAuthSuccessHandler())
                .and()
                .logout() // /login?logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/loggedOut")
                .deleteCookies(AUTHCOOKIENAME)
                .permitAll()
                .and()
                .csrf().disable()
        ;
        return http.build();
    }

    @Bean
    public UserDetailsManager users(DataSource dataSource) throws Exception {
//        User.withDefaultPasswordEncoder()//todo 자동인코딩해주는 애같은데 이거 다른 애로 대체해야할 듯
        /*UserDetails user = User.builder()
                .username("username")
                .password("password")
                .authorities(new GrantedAuthority["admin"])
                .passwordEncoder((password) -> new BCryptPasswordEncoder().encode(password)).build();*/

        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery("select member_id, password, 'true' from member where member_id = ?");
        userDetailsManager.setAuthoritiesByUsernameQuery("select member_id, authority from member_authorities where member_id = ?");
//        userDetailsManager.createUser(user);
        return userDetailsManager;
//        auth
//                .jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("select member_id, password, 'true' from member where member_id = ?")
//                .authoritiesByUsernameQuery("select member_id, authority from member_authorities where member_id = ?")
//                .passwordEncoder(NoOpPasswordEncoder.getInstance())
//        ;
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() throws Exception {
       return (web) -> web.ignoring().requestMatchers("/vendor/**", "/api/**", "/images/**", "/favicon.ico");
    }
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
