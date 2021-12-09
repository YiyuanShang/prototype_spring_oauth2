package com.athensoft.prototype.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

import com.athensoft.prototype.dao.UaasUserRepository;

public class CustomOidUserService extends OidcUserService {
	@Autowired
	private UaasUserRepository userRepo;

	@Override
	public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
		final OidcUser oidcUser = super.loadUser(userRequest);
		return oidcUser;
	}

}
