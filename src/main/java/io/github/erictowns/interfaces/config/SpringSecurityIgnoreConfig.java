package io.github.erictowns.interfaces.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

/**
 * Description: disable security for some profiles
 *
 * @author EricTowns
 * @date 2023/10/17 15:14
 */
@Configuration
@Profile("dev")
public class SpringSecurityIgnoreConfig {

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/**");
    }

}
