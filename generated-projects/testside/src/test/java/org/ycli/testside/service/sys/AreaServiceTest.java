/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package org.ycli.testside.service.sys;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.ycli.testside.dependency.spring.SpringTransactionalTestCase;
import org.ycli.testside.modules.sys.entity.Area;
import org.ycli.testside.modules.sys.service.AreaService;

import com.google.common.collect.Maps;

/**
 * AccountService的测试用例, 测试Service层的业务逻辑.
 * 
 * @author calvin
 */
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class AreaServiceTest extends SpringTransactionalTestCase {

	@Autowired
	private AreaService areaService;

	@Test
	public void testFindAreaPage(){
		Page<Area> areaPage = areaService.getUserTask(Maps.<String, Object>newHashMap(), 1, 10, "");
		assertThat(areaPage.getContent()).hasSize(2);
		System.out.println(areaPage.getTotalElements());
	}

}
