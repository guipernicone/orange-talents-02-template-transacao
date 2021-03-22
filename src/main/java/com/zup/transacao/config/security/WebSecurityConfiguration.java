package com.zup.transacao.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * Route access configuration
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // Disable csrf (cross site request forgery)
                .csrf().disable()
                // Entry Points authorize
                .authorizeRequests().anyRequest().authenticated()

                .and()
                //Configure to use auth2ResourceServer
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
    }
}
