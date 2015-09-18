/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package org.ycli.testside.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;
import org.ycli.testside.entity.Area;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class AreaDaoTest extends SpringTransactionalTestCase {

	@Autowired
	private AreaDao areaDao;

	@Test
	public void findAreaPage() throws Exception {
		Page<Area> tasks = areaDao.findAll(new PageRequest(0, 10, new Sort(Direction.ASC, "id")));
		assertThat(tasks.getContent()).hasSize(2);
		assertThat(tasks.getContent().get(0).getId()).isEqualTo("1");
	}
	
	@Test
	public void findByType(){
		Area area = areaDao.findByType("1");
//		Page<Area> tasks = areaDao.findAll(new PageRequest(0, 10));
		assertThat(area.getId()).isEqualTo("1");
	}
	
	@Test
	public void testA(){
	}
}
