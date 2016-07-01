package no.sag.treg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private RESTAuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private RESTAuthenticationFailureHandler authenticationFailureHandler;
    @Autowired
    private RESTAuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception
    {
        builder
            .jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery("select username, password, enabled from users where username=?")
            .authoritiesByUsernameQuery("select username, role from user_roles where username=?");


            /*.inMemoryAuthentication()
            .withUser("sglamseter@gmail.com")
            .password("steinar")
            .roles("USER")
            .and()
            .withUser("admin")
            .password("admin").roles("ADMIN");*/
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests().antMatchers("/innebandy/**").authenticated();
        http.csrf().disable();
        http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
        http.formLogin().successHandler(authenticationSuccessHandler);
        http.formLogin().failureHandler(authenticationFailureHandler);
        http.formLogin().usernameParameter("username");
        http.formLogin().passwordParameter("password");
        http.logout().logoutSuccessUrl("/");
    }
}