package bg.softuni.tabula.config;

import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService tabulaUserDetailsService;
    private final PasswordEncoder passwordEncoder;

    //Verification of http request
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .antMatchers("/login**", "/login-error**").permitAll()
                .antMatchers("/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login/authenticate")
                .failureForwardUrl("/login-error")
                .successForwardUrl("/home")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");
    }

    public void configureGlobal(AuthenticationManagerBuilder authManager) throws Exception {
        authManager
                .userDetailsService(tabulaUserDetailsService)
                .passwordEncoder(passwordEncoder);
    }
}
