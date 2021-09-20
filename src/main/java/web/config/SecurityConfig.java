package web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import web.config.handler.LoginSuccessHandler;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and()
                .formLogin()
                .defaultSuccessUrl("/userhome")
                .successHandler(new LoginSuccessHandler())
//                .successForwardUrl("/admin/users")
//                .loginProcessingUrl("/admin/users")
                .and()
                .logout().logoutSuccessUrl("/hello");
    }





    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(users()).passwordEncoder(passwordEncoder());
//        auth.jdbcAuthentication().passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public UserDetailsService users(){
        UserDetails admin = User.builder()
                .username("admin")
                .password("1")
                .roles("ADMIN")
                .build();
        UserDetails user = User.builder()
                .username("user")
                .password("1")
                .roles("USER")
                .build();
        return new  InMemoryUserDetailsManager(admin, user);
    }


//    @Bean
//    public JdbcUserDetailsManager users(DataSource dataSource){
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("1")
//                .roles("ADMIN")
//                .build();
//        UserDetails user = User.builder()
//                .username("user")
//                .password("1")
//                .roles("USER")
//                .build();
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//        jdbcUserDetailsManager.createUser(admin);
//        jdbcUserDetailsManager.createUser(user);
//        return jdbcUserDetailsManager;
//    }

}
