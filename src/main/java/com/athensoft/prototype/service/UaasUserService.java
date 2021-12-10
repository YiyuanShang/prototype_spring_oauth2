package com.athensoft.prototype.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athensoft.prototype.dao.UaasUserRepository;
import com.athensoft.prototype.entity.Provider;
import com.athensoft.prototype.entity.UaasAuthority;
import com.athensoft.prototype.entity.UaasUser;

@Service
public class UaasUserService {
	@Autowired
	private UaasUserRepository userRepo;
	
	public void processOAuthPostLogin(String username) {
		System.out.println("UaasUserService :" + username);
        UaasUser existUser = userRepo.findByAcctName(username);
         
        if (existUser == null) {
        	UaasUser newUser = new UaasUser();
            newUser.setAcctName(username);
            newUser.setProvider(Provider.GOOGLE);
            newUser.setEnabled(true);          
             
            userRepo.save(newUser);        
        }
         
    }

	public UaasUser getUserByAcctName(String email) {
		return userRepo.findByAcctName(email);
	}

	public void createUser(String email, Provider provider) {
		UaasUser user = new UaasUser();
		user.setAcctName(email);
		user.setProvider(provider);
		user.setEnabled(true);
		List<UaasAuthority> authorities = new ArrayList<>();
		authorities.add(UaasAuthority.ROLE_USER);
		user.setAuthorities(authorities);
		
		userRepo.save(user);
		
		
	}

	public void updateUser(UaasUser user, Provider google) {
		user.setProvider(Provider.GOOGLE);
		
		userRepo.save(user);
	}
	

}
