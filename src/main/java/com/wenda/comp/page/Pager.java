package com.wenda.comp.page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.wenda.comp.constant.Constant;

/**
 * <p>
 * Description: ∑÷“≥¿‡
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-17
 */
public class Pager implements Pageable {
	private int pageNumber;

	private int pageSize;

	private Direction direction;

	private String properties;

	public Pager() {
		this.pageSize = Constant.PAGE_SIZE;
		this.pageNumber = 1;
		this.properties = Constant.ID;
		this.direction = Direction.DESC;
	}

	public Pager(int pageNumber, int pageSize, Direction direction,
			String properties) {
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.direction = direction;
		this.properties = properties;
	}

	public void setPropertiesIfNotSet(String properties, Direction direction) {
		if (this.properties == null || ("").equals(this.properties)) {
			this.direction = direction;
			this.properties = properties;
		}
	}

	public void setPropertiesIfNotSet(String properties) {
		if (this.properties == null) {
			this.properties = properties;
		}
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public String getProperties() {
		return properties;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}

	public int getOffset() {
		return (pageNumber - 1) * pageSize;
	}

	public Sort getSort() {
		if (this.properties == null || this.properties.equals("")) {
			return null;
		} else {
			return new Sort(direction, properties);
		}
	}

}
