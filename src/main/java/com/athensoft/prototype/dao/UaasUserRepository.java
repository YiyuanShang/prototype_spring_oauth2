package com.athensoft.prototype.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.athensoft.prototype.entity.UaasUser;


@Repository
public interface UaasUserRepository extends JpaRepository<UaasUser, Long>{
	UaasUser findByAcctName(String acctName);

}
