package golf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Autowired
    public CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**, /js/**, *.ico");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().and()
        .authorizeRequests().antMatchers("/*", "/home","/index","/css/**", "/js/**").permitAll().anyRequest()
                .authenticated()
                .and()
                // .formLogin().loginPage("/login") //post로 /login에 날릴것 frontend부분에 url 주소랑 관계 없음
                .formLogin().loginPage("/login").defaultSuccessUrl("/alert").failureUrl("/login?error=true")
                // .usernameParameter("id").passwordParameter("password")
                .successHandler(customAuthenticationSuccessHandler).failureHandler(customAuthenticationFailureHandler)
                .permitAll().and()
                .logout().logoutSuccessUrl("/").permitAll();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}