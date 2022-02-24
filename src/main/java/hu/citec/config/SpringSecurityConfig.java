package hu.citec.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource datasource;

	@Autowired
	private CustomAccessDeniedHandler accessDeniedHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/registration").permitAll().antMatchers("/reg").permitAll()
				.antMatchers("/*").fullyAuthenticated().antMatchers("/adminHome").hasAnyAuthority("ADMIN")
				.antMatchers("/userHome").hasAnyAuthority("ADMIN", "DIAK", "SZULO", "TANAR").antMatchers("/teacherHome")
				.hasAnyAuthority("TANAR", "ADMIN").anyRequest().authenticated().and().formLogin().loginPage("/login")
				.usernameParameter("username").passwordParameter("password").permitAll().loginProcessingUrl("/login")
				.defaultSuccessUrl("/connect", true).permitAll().and().logout().invalidateHttpSession(true)
				.clearAuthentication(true).permitAll().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login?loggedout").permitAll().and().exceptionHandling()
				.accessDeniedHandler(accessDeniedHandler);
	}

	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(datasource)
				.usersByUsernameQuery("SELECT username, user_password, 1 AS ENABLED FROM users WHERE username =?")
				.authoritiesByUsernameQuery(
						"Select u.username,r.role_type from role r LEFT JOIN user_roles ur on ur.role_id "
								+ "= r.role_id LEFT JOIN users u ON u.user_id = ur.user_id WHERE u.username =  ?");

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

}