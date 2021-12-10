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
	

	public UaasUser getUserByAcctName(String acctName) {
		return userRepo.findByAcctName(acctName);
	}

	public void createUser(String acctName, Provider provider) {
		UaasUser user = new UaasUser();
		user.setAcctName(acctName);
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
