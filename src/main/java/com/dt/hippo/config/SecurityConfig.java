/**
 * 
 */
package com.dt.hippo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.dt.hippo.service.CustomUserDetailsService;

/**
 * @author Don
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
    
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder registry)
			throws Exception {
		// registry.jdbcAuthentication().dataSource(dataSource);
		// ReflectionSaltSource rss = new ReflectionSaltSource();
		// rss.setUserPropertyToUse("salt");

		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		// provider.setSaltSource(rss);
		provider.setUserDetailsService(customUserDetailsService);

		provider.setPasswordEncoder(passwordEncoder());
		// new BCryptPasswordEncoder(10, new SecureRandom())
		registry.authenticationProvider(provider);

		// registry.userDetailsService(customUserDetailsService).passwordEncoder(new
		// PasswordEncoder(){
		//
		// @Override
		// public String encode(CharSequence rawPassword) {
		// return null;
		// }
		//
		// @Override
		// public boolean matches(CharSequence rawPassword,
		// String encodedPassword) {
		// return false;
		// }
		//
		// });
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/contacts/**", "/**"); // #3
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf()
				.disable()
				.authorizeRequests()
				.antMatchers("/login", "/login/form**", "/register", "/logout")
				.permitAll()
				// #4
				.antMatchers("/admin", "/admin/**")
				.hasRole("ADMIN")
				// #6
				.anyRequest()
				.authenticated()
				// 7
				.and()
				.formLogin()
				.defaultSuccessUrl("/success")
				.successHandler(customUserDetailsService)
				// #8
				.loginPage("/login")
				// #9
				.loginProcessingUrl("/login").failureUrl("/login_error")
				.usernameParameter("username").passwordParameter("password")
				.permitAll(); // #5
	}
}
