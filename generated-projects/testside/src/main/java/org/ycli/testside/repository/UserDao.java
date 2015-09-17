/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package org.ycli.testside.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.ycli.testside.entity.User;

public interface UserDao extends PagingAndSortingRepository<User, String> {
	User findByLoginName(String loginName);
}
