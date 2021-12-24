package com.athensoft.prototype.security.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import com.athensoft.prototype.config.AppProperties;
import com.athensoft.prototype.exception.BadRequestException;
import com.athensoft.prototype.security.TokenProvider;


import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Optional;



@Component
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private TokenProvider tokenProvider;

    private AppProperties appProperties;

   


    @Autowired
    OAuth2AuthenticationSuccessHandler(TokenProvider tokenProvider, AppProperties appProperties) {
        this.tokenProvider = tokenProvider;
        this.appProperties = appProperties;
      
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
    	super.onAuthenticationSuccess(request, response, authentication);
    	String targetUrl = determineTargetUrl(request, response, authentication);

        if (response.isCommitted()) {
            logger.debug("Response has already been committed. Unable to redirect to " + targetUrl);
            return;
        }

       
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
        System.out.println("OAuth2AuthenticationSuccessHandler targetUrl:" + targetUrl);
        
       
    }

   
}
