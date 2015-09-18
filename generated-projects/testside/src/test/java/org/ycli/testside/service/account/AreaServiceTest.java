/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package org.ycli.testside.service.account;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;
import org.ycli.testside.entity.Area;
import org.ycli.testside.service.area.AreaService;

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
