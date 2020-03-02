package conf;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserConfiguration extends GlobalAuthenticationConfigurerAdapter {
    PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Override
    public void init(AuthenticationManagerBuilder builder) throws Exception {
        builder.inMemoryAuthentication().withUser("devni")
                .password(passwordEncoder.encode("devni"))
                .roles("USER", "ADMIN", "MANAGER")
                .authorities("CAN_READ", "CAN_WRITE", "CAN_DELETE")
                .and()
                .withUser("usr")
                .password(passwordEncoder.encode("ps"))
                .roles("USER")
                .authorities("CAN_READ", "CAN_WRITE");
    }
}