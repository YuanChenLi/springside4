/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package org.ycli.testside.repository.cms;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ContextConfiguration;
import org.ycli.testside.dependency.spring.SpringTransactionalTestCase;
import org.ycli.testside.modules.cms.dao.TaskDao;
import org.ycli.testside.modules.cms.entity.Task;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TaskDaoTest extends SpringTransactionalTestCase {

	@Autowired
	private TaskDao taskDao;

	@Test
	public void findTasksByUserId() throws Exception {
//		Page<Task> tasks = taskDao.findByCreateById("2", new PageRequest(0, 100, Direction.ASC, "id"));
//		assertThat(tasks.getContent()).hasSize(5);
//		assertThat(tasks.getContent().get(0).getId()).isEqualTo("1");
//
//		tasks = taskDao.findByCreateById("99999", new PageRequest(0, 100, Direction.ASC, "id"));
//		assertThat(tasks.getContent()).isEmpty();
//		assertThat(tasks.getContent()).isEmpty();
	}
}
