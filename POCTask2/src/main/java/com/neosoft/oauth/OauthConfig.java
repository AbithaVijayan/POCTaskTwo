package com.neosoft.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
@EnableAuthorizationServer
public class OauthConfig  extends AuthorizationServerConfigurerAdapter{
	
	@Autowired
	private AuthenticationManager authenticationManager;  
	
	private PasswordEncoder passwordEncoder;
	
    
	@Autowired
	public OauthConfig(AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder) {
		super();
		this.authenticationManager = authenticationManager;
		this.passwordEncoder = passwordEncoder;
	}
	
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("abitha")
				.authorizedGrantTypes("client_credentials")
				.authorities("ADMIN","USER")
				.accessTokenValiditySeconds(5000)
				.resourceIds("oauth2-resource")
				.secret(passwordEncoder.encode("abitha-secretkey"))
				.scopes("resource-server-read", "resource-server-write");
	}

	
}
