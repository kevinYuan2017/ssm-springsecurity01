/**
 * 
 */
package com.lanou.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lanou.entity.Authority;
import com.lanou.mapper.UserMapper;
import com.lanou.service.MyUserDetailsService;

/**
 * @author 袁中凯
 * @createTime 2018-03-23 17:56:53
 */
@Service("myUserDetailsService")
@Transactional
@SuppressWarnings("deprecation")
public class MyUserDetailsServiceImpl implements MyUserDetailsService {
	@Resource
	private UserMapper userMapper;
	/* (non-Javadoc)
	 * @see com.lanou.service.MyUserDetailService#loadUserByUsername(java.lang.String)
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Collection<GrantedAuthority> grantedAuthorities=new ArrayList<GrantedAuthority>(); 
		com.lanou.entity.User loginUser = userMapper.selectByPrimaryKey(username);
		System.out.println("登录用户信息: " + loginUser);
		Boolean enabled = false;
		if (loginUser == null) {
			grantedAuthorities = null;
			throw new UsernameNotFoundException("用户名不存在!");
		} else {
			enabled = loginUser.getEnabled() == 1;
			List<Authority> authorities = loginUser.getAuthorities();
			if (authorities.size() > 0) {
				for (Authority authority : authorities) {
					grantedAuthorities.add(new GrantedAuthorityImpl(authority.getAuthority()));
				}
			}
		}
        User user = new User(username, loginUser.getPassword(), enabled, true, true, true, grantedAuthorities);   
        return user;    
    }
}
