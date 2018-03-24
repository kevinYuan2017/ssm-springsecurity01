/**
 * 
 */
package com.lanou.controller;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lanou.entity.User;
import com.lanou.service.MyUserDetailsService;

/**
 * @author 袁中凯
 * @createTime 2018-03-24 10:52:49
 */
@Controller
public class UserController {
	@Resource
	private MyUserDetailsService myUserDetailsService;
	@RequestMapping("home")
    public String home(){
        return "home";
    }
    @RequestMapping(value = "helloadmin", method=RequestMethod.GET)
    public String helloAdmin(){
        return "helloAdmin";
    }

    @RequestMapping(value = "hellouser", method=RequestMethod.GET)
    public String helloUser(){
        return "helloUser";
    }

    @RequestMapping(value = "toLogin", method = RequestMethod.GET)
    public String toLogin() {
    	return "login";
    }
    
//    @RequestMapping(value = "login", method = RequestMethod.POST)
//    public String login(User user) {
//    	UserDetails userDetails = myUserDetailsService.loadUserByUsername(user.getUsername());
//    	if (userDetails != null && user.getPassword().equals(userDetails.getPassword())) {
//    		return "helloUser";
//		}else {
//			return "login";
//		}
//    	
//    }
    
    @RequestMapping("403")
    public String forbidden(){
        return "403";
    }
}
