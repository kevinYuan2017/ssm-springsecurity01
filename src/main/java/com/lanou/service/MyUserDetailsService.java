/**
 * 
 */
package com.lanou.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author 袁中凯
 * @createTime 2018-03-23 17:56:04
 */
public interface MyUserDetailsService extends UserDetailsService {

	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

	
}
