/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package org.ycli.testside.modules.cms.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.ycli.testside.modules.cms.entity.Task;

public interface TaskDao extends PagingAndSortingRepository<Task, String>, JpaSpecificationExecutor<Task> {

	Page<Task> findByUserId(String id, Pageable pageRequest);

	@Modifying
	@Query("delete from Task task where id=?1")
	void deleteTest(String id);
}
