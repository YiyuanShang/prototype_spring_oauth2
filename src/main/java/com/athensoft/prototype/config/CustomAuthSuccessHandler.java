package com.athensoft.prototype.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomAuthSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
//		CustomOAuth2User oauthUser = (CustomOAuth2User) authentication.getPrincipal();
//		 
//        userService.processOAuthPostLogin(oauthUser.getEmail());
//
//        response.sendRedirect("/list");
		
	}

}
