/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package org.ycli.testside.modules.cms.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.NotBlank;
import org.ycli.testside.common.SysCode;
import org.ycli.testside.common.persistence.DataEntity;

//JPA标识
@Entity
@Table(name = "ycli_task")
@SQLDelete(sql="UPDATE YCLI_TASK SET DEL_FLAG = '" + SysCode.DEL_FLAG_DELETE + "' WHERE id = ?")
@Where(clause="DEL_FLAG <> '"+SysCode.DEL_FLAG_DELETE+"'")
public class Task extends DataEntity {

	private static final long serialVersionUID = 1076796553431226470L;
	
	private String title;
	private String description;

	// JSR303 BeanValidator的校验规则
	@NotBlank
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
