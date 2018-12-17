package it.unical.asde2018.unitest.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public HttpSessionEventPublisher httpSessionEventPublisher() {
	    return new HttpSessionEventPublisher();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.sessionManagement().maximumSessions(1).expiredUrl("/login?expired");
		
		http.sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
        
		http
        .csrf().disable()
        .authorizeRequests()
        .antMatchers("/resources/**").permitAll()
        .antMatchers("/login**").permitAll()
        .antMatchers("/createExam", "/addQuestions", "/evalExam").hasRole("Professor")
        .anyRequest().authenticated()        
        .and()
        .formLogin()
        .loginPage("/login")
        .loginProcessingUrl("/loginAction")
        .defaultSuccessUrl("/", true)
        .and()
        .logout()
        .logoutUrl("/logout")
        .deleteCookies("JSESSIONID").and().exceptionHandling().accessDeniedPage("/accessDenied");
		
//		http.authorizeRequests().antMatchers("/createExam**").hasRole("Professor");
	}
}