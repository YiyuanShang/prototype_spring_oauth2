package com.athensoft.prototype.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.athensoft.prototype.config.CustomUserDetails;
import com.athensoft.prototype.dao.UaasUserRepository;
import com.athensoft.prototype.entity.UaasUser;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
    private UaasUserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UaasUser uaasUser = userRepo.findByAcctName(username);
        if(uaasUser ==null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        return new CustomUserDetails(uaasUser);
    }
}
