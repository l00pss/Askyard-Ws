package az.askyard.askyardws.core.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * @author Vugar Mammadli
 */

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    String authPostPath = "/api/1.0/auth";
    String updatePutPath = "/api/1.0/user/account/delete";
    String accountDeletePath = "/api/1.0/user/update";
    String findAllFirends = "/api/1.0/user/findAllFirends";
    String follow = "/follow/{id}";
    UserAuthService userAuthService;
    PasswordEncoder passwordEncoder;


    @Autowired
    public SecurityConfiguration(UserAuthService userAuthService, PasswordEncoder passwordEncoder) {
        this.userAuthService = userAuthService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.httpBasic().authenticationEntryPoint(new AuthEntryPoint()); // Pop up ekrani gorunmemesi ucun

        http
            .authorizeRequests()
                .antMatchers(HttpMethod.POST, authPostPath).authenticated()
                .antMatchers(HttpMethod.PUT,updatePutPath).authenticated()
                .antMatchers(HttpMethod.DELETE,accountDeletePath).authenticated()
                .antMatchers(HttpMethod.GET,findAllFirends).authenticated()
                .antMatchers(HttpMethod.GET,follow).authenticated()
            .and()
            .authorizeRequests().anyRequest().permitAll();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userAuthService).passwordEncoder(passwordEncoder);
    }



}
