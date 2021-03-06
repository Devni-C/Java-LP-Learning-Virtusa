package conf;

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
public class AuthServerConfiguration extends
        WebSecurityConfigurerAdapter implements AuthorizationServerConfigurer {

    @Autowired
    AuthenticationManager authenticationManager;

<<<<<<< HEAD
    @Bean
    @Override
    public AuthenticationManager getAuthenticationManager() throws Exception {
=======
    PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
>>>>>>> 08617e428cb113546708441a2259930c9bbe5440
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer authorizationServerSecurityConfigurer) throws Exception {
        authorizationServerSecurityConfigurer.checkTokenAccess("permitAll()");
    }

<<<<<<< HEAD
    PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Override
    public void configure(ClientDetailsServiceConfigurer clientDetailsServiceConfigurer) throws Exception {
        clientDetailsServiceConfigurer.inMemory().withClient("cid")
                .secret(passwordEncoder.encode("123"))
                .scopes("READ", "WRITE")
                .authorizedGrantTypes("pw").accessTokenValiditySeconds(3600);
=======

    @Override
    public void configure(ClientDetailsServiceConfigurer clientDetailsServiceConfigurer) throws Exception {
        clientDetailsServiceConfigurer
                .inMemory()
                .withClient("cid")
                .secret(passwordEncoder.encode("123"))
                .scopes("READ", "WRITE")
                .authorizedGrantTypes("pw")
                .accessTokenValiditySeconds(3600);
>>>>>>> 08617e428cb113546708441a2259930c9bbe5440
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer authorizationServerEndpointsConfigurer) throws Exception {
<<<<<<< HEAD
        authorizationServerEndpointsConfigurer.authenticationManager(getAuthenticationManager());
=======
        authorizationServerEndpointsConfigurer
                .authenticationManager(authenticationManager);
>>>>>>> 08617e428cb113546708441a2259930c9bbe5440
    }
}
