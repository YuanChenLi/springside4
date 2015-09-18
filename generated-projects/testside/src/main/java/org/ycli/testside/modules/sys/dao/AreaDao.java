/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package org.ycli.testside.modules.sys.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.ycli.testside.modules.sys.entity.Area;

public interface AreaDao extends PagingAndSortingRepository<Area, String>, JpaSpecificationExecutor<Area> {

	Area findByType(String type);
}
