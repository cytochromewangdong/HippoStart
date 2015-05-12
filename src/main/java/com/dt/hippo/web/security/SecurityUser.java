/**
 * 
 */
package com.dt.hippo.web.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.dt.hippo.datajpa.model.jpa.Role;
import com.dt.hippo.datajpa.model.jpa.User;


public class SecurityUser implements UserDetails
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4649263810505759140L;
	
	private User delegateUser;
	Collection<? extends GrantedAuthority> authorities;
	public SecurityUser(User user) {
		this.delegateUser = user;
		authorities = extractAuthoritiesFromUser(user);
	}
	public  Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}
	
	public  static Collection<? extends GrantedAuthority> extractAuthoritiesFromUser(User delegateUser) {
		
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		Set<Role> userRoles = delegateUser.getRoles();
		
		if(userRoles != null)
		{
			for (Role role : userRoles) {
				SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
				authorities.add(authority);
			}
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return delegateUser.getPassword();
	}

	@Override
	public String getUsername() {
		return delegateUser.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
