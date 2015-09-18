/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package org.ycli.testside.web.area;

import java.util.Map;

import javax.servlet.ServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springside.modules.web.Servlets;
import org.ycli.testside.entity.Area;
import org.ycli.testside.service.account.ShiroDbRealm.ShiroUser;
import org.ycli.testside.service.area.AreaService;
import org.ycli.testside.web.BaseController;

import com.google.common.collect.Maps;

/**
 * Task管理的Controller, 使用Restful风格的Urls:
 * 
 * List page : GET /area/
 * 
 * @author calvin
 */
@Controller
@RequestMapping(value = "/area")
public class AreaController extends BaseController{

	private static final String PAGE_SIZE = "3";

	private static Map<String, String> sortTypes = Maps.newLinkedHashMap();
	static {
		sortTypes.put("auto", "自动");
		sortTypes.put("title", "标题");
	}

	@Autowired
	private AreaService areaService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
			@RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize, Model model,
			ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
//		String userId = getCurrentUserId();

		Page<Area> tasks = areaService.getUserTask(searchParams, pageNumber, pageSize, "");

		model.addAttribute("tasks", tasks);
//		model.addAttribute("sortType", sortType);
//		model.addAttribute("sortTypes", sortTypes);
		// 将搜索条件编码成字符串，用于排序，分页的URL
		model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, "search_"));

		return "area/areaList";
	}

}
