package com.lanou.filter;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.lanou.service.MyUserDetailsService;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	@Resource
	private MyUserDetailsService myUserDetailService;
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

		if(!request.getMethod().equals("POST")){
			throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
		}
		String username = this.obtainUsername(request);
		String password = this.obtainPassword(request);
		
		UserDetails userDetails = myUserDetailService.loadUserByUsername(username);
		if(userDetails == null || !password.equals(userDetails.getPassword())){
			throw new AuthenticationServiceException("用户名或密码错误！");
		}
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
		this.setDetails(request, authRequest);
		Authentication authentication = null;
		try{
			authentication = this.getAuthenticationManager().authenticate(authRequest);
		}catch(Exception e){
			e.printStackTrace();
		}
		return authentication;
	}
}
