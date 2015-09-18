/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package org.ycli.testside.modules.sys.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.ycli.testside.common.persistence.DynamicSpecifications;
import org.ycli.testside.common.persistence.SearchFilter;
import org.ycli.testside.modules.sys.dao.AreaDao;
import org.ycli.testside.modules.sys.entity.Area;

// Spring Bean的标识.
@Component
// 类中所有public函数都纳入事务管理的标识.
@Transactional
public class AreaService {
	
	@Autowired
	private AreaDao areaDao;


	public Page<Area> getUserTask(Map<String, Object> searchParams, int pageNumber, int pageSize,
			String sortType) {
		Specification<Area> spec = buildSpecification(searchParams);
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
		
		return areaDao.findAll(spec, pageRequest);
	}
	
	public Area save(Area area) {
		return areaDao.save(area);
	}
	
	public Area findById(String areaId) {
		return areaDao.findOne(areaId);
	}

	/**
	 * 创建分页请求.
	 */
	private PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortType) {
		Sort sort = null;
		if ("auto".equals(sortType)) {
			sort = new Sort(Direction.DESC, "id");
		} else if ("title".equals(sortType)) {
			sort = new Sort(Direction.ASC, "title");
		}

		return new PageRequest(pageNumber - 1, pagzSize, sort);
	}

	/**
	 * 创建动态查询条件组合.
	 */
	private Specification<Area> buildSpecification(Map<String, Object> searchParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
//		filters.put("user.id", new SearchFilter("user.id", Operator.EQ, userId));
		Specification<Area> spec = DynamicSpecifications.bySearchFilter(filters.values(), Area.class);
		return spec;
	}

//	@Autowired
//	public void setAreaDao(AreaDao areaDao) {
//		this.areaDao = areaDao;
//	}
}