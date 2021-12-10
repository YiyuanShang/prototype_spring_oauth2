package com.athensoft.prototype.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.athensoft.prototype.entity.Provider;
import com.athensoft.prototype.entity.UaasUser;
import com.athensoft.prototype.service.UaasUserService;

@Component
public class CustomOAuth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
	@Autowired
	UaasUserService userService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		CustomOAuth2User oauthUser = (CustomOAuth2User) authentication.getPrincipal();
		 
		String email = oauthUser.getEmail();
		System.out.println("CustomAuthSuccessHandler:" + email);
		
		UaasUser user = userService.getUserByAcctName(email);
		if(user == null) {
			// register as a new user
			userService.createUser(email, Provider.GOOGLE);
		}else {
			// update existing user
			userService.updateUser(user, Provider.GOOGLE);
			
		}
        
        super.onAuthenticationSuccess(request, response, authentication);

       
		
	}

}
