package com.athensoft.prototype.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import javax.persistence.JoinColumn;

@Entity
@Table(name="uaas_acct")
public class UaasUser {
	@Id
	@Column(name="acct_name")
	private String acctName;
	
	private String password;
	
	private Boolean enabled;

	@ElementCollection(targetClass = UaasAuthority.class, fetch=FetchType.EAGER)
	@JoinTable(name = "authorities", 
	joinColumns = @JoinColumn(name = "acct_name", referencedColumnName = "acct_name"))
	@Column(name = "authority", nullable = false)
	@Enumerated(EnumType.STRING)
	private List<UaasAuthority> authorities;
	
	@Enumerated(EnumType.STRING)
    private Provider provider;
	
	
	@Override
	public String toString() {
		return "UaasUser [acctName=" + acctName + ", password=" + password + ", enabled=" + enabled + ", authorities="
				+ authorities + "]";
	}

	public String getAcctName() {
		return acctName;
	}

	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<UaasAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<UaasAuthority> authorities) {
		this.authorities = authorities;
	}

	public Provider getProvider() {
        return provider;
    }
 
    public void setProvider(Provider provider) {
        this.provider = provider;
    }
	
	

}
