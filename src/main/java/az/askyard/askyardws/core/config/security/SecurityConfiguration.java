package az.askyard.askyardws.core.config.security;

import az.askyard.askyardws.core.config.patterns.RequestAuthPattern;
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

    private UserAuthService userAuthService;
    private PasswordEncoder passwordEncoder;


    @Autowired
    public SecurityConfiguration(UserAuthService userAuthService, PasswordEncoder passwordEncoder) {
        this.userAuthService = userAuthService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); // Gorulmeyen headerleri baglamaq ucun
        http.httpBasic().authenticationEntryPoint(new AuthEntryPoint()); // Browser terefde Pop up ekrani gorunmemesi ucun
        http
            .authorizeRequests()
                .antMatchers(HttpMethod.POST, RequestAuthPattern.AUTH.getPattern()).authenticated()
                .antMatchers(HttpMethod.PUT,RequestAuthPattern.ACCOUNT_DELETE.getPattern()).authenticated()
                .antMatchers(HttpMethod.DELETE,RequestAuthPattern.ACCOUNT_UPDATE.getPattern()).authenticated()
                .antMatchers(HttpMethod.GET,RequestAuthPattern.GET_ALL_FOLLOWERS.getPattern()).authenticated()
                .antMatchers(HttpMethod.GET,RequestAuthPattern.FOLLOW.getPattern()).authenticated()
                .antMatchers(HttpMethod.GET,RequestAuthPattern.UNFOLLOW.getPattern()).authenticated()
            .and()
            .authorizeRequests().anyRequest().permitAll();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userAuthService).passwordEncoder(passwordEncoder);
    }

}
