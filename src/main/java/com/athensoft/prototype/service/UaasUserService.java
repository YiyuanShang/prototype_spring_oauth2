package com.athensoft.prototype.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athensoft.prototype.dao.UaasUserRepository;
import com.athensoft.prototype.entity.Provider;
import com.athensoft.prototype.entity.UaasUser;

@Service
public class UaasUserService {
	@Autowired
	private UaasUserRepository useRepo;
	
	public void processOAuthPostLogin(String username) {
        UaasUser existUser = useRepo.findByAcctName(username);
         
        if (existUser == null) {
        	UaasUser newUser = new UaasUser();
            newUser.setAcctName(username);
            newUser.setProvider(Provider.GOOGLE);
            newUser.setEnabled(true);          
             
            useRepo.save(newUser);        
        }
         
    }
	

}
