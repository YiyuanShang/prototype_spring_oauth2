package com.athensoft.prototype.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athensoft.prototype.dao.UaasUserRepository;
import com.athensoft.prototype.entity.UaasUser;
import com.athensoft.prototype.exception.ResourceNotFoundException;
import com.athensoft.prototype.security.CurrentUser;
import com.athensoft.prototype.security.UserPrincipal;

@RestController
public class UserController {
	@Autowired
    private UaasUserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public UaasUser getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "acctId", userPrincipal.getId()));
    }

}
