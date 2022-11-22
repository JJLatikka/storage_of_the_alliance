package storageOfTheAlliance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import storageOfTheAlliance.service.UDService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConf {

	@Autowired
	private UDService uDS;

	@Bean
	public SecurityFilterChain config(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/style/**", "/resources/**").permitAll().anyRequest()
				.authenticated().and().formLogin().loginPage("/sign_in").permitAll()
				.defaultSuccessUrl("/storage_of_the_alliance", true).and().logout().logoutSuccessUrl("/sign_out")
				.permitAll().and().csrf().disable();
		return http.build();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder aMB) throws Exception {
		aMB.userDetailsService(uDS).passwordEncoder(new BCryptPasswordEncoder());
	}

}
