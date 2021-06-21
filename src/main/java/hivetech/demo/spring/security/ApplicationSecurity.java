package hivetech.demo.spring.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                /* add antMatchers after demo basic auth */
//                .antMatchers("/", "index", "/css/*", "/js/*")
//                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
                /* default basicAuth. create this file after show form based auth*/
    }
}
