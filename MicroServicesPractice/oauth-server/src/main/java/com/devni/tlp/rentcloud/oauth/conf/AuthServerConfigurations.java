package com.devni.tlp.rentcloud.oauth.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
public class AuthServerConfigurations extends
        WebSecurityConfigurerAdapter implements AuthorizationServerConfigurer {

    @Autowired
    AuthenticationManager authenticationManager;

    PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer securityConfigurer) throws Exception {
        securityConfigurer.checkTokenAccess("permitAll");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer client) throws Exception {
        client.inMemory()
                .withClient("web")
                .secret(passwordEncoder.encode("webpass"))
                .scopes("READ", "WRITE")
                .authorizedGrantTypes("password", "authorization");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoint) throws Exception {
        endpoint.authenticationManager(authenticationManager);
    }

}
