/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package org.ycli.testside.modules.sys.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.ycli.testside.modules.sys.service.account.ShiroDbRealm.ShiroUser;

/**
 * 用户工具类
 * @author ThinkGem
 * @version 2013-5-29
 */
public class UserUtils{
	
	public static ShiroUser getCurrentUser(){
		ShiroUser user = null;
		try{
//			user = (ShiroUser)SecurityUtils.getSubject().getPrincipal();
			user = new ShiroUser("", "", "");
			return user;
		}catch (UnavailableSecurityManagerException e) {
		}catch (InvalidSessionException e){
		}
		if (user == null){
			try{
				SecurityUtils.getSubject().logout();
			}catch (UnavailableSecurityManagerException e) {
			}catch (InvalidSessionException e){
			}
		}
		return new ShiroUser("", "", "");
	}
}
