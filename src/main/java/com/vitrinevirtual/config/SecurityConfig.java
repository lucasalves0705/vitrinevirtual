package com.vitrinevirtual.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.vitrinevirtual.dao.UsuarioDao;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UsuarioDao service;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(new BCryptPasswordEncoder()); 
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception { 
		http.authorizeRequests()
			// acessos públicos liberados
			.antMatchers("/css/**", "/js/**", "/img/**", "/vendors/**", "/video/**").permitAll()
			.antMatchers("/", "/home").permitAll()
			
			.antMatchers("/usuario/**").hasAuthority("MANAGER")
			.antMatchers("/empresa/cadastro").hasAuthority("MANAGER")
			.antMatchers("/produto/form").hasAuthority("MANAGER")
			.antMatchers("/empresa/exibir").hasAuthority("MANAGER")
			.antMatchers("/produto/form").hasAuthority("MANAGER")
			.antMatchers("/ramo/cadastro").hasAuthority("MANAGER")
			.antMatchers("/ramo/alterar").hasAuthority("MANAGER")
            .antMatchers("/empresa/index").hasAnyAuthority("MANAGER", "USER")
            .antMatchers("/home/**").hasAnyAuthority("MANAGER", "USER")
            .antMatchers("/ramo/index").hasAnyAuthority("MANAGER", "USER")
			
			.anyRequest().authenticated()
			.and() 
			.formLogin().loginPage("/login") 
				.defaultSuccessUrl("/empresa/index", true) 
				.failureUrl("/login-error") 
				.permitAll() 
				.and() 
			.logout() 
	        .invalidateHttpSession(true)
	        .clearAuthentication(true)
	        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	        .logoutSuccessUrl("/")
	        .permitAll();	
	}
	
}
