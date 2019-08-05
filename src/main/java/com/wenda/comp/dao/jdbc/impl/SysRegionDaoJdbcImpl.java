package com.wenda.comp.dao.jdbc.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wenda.comp.common.util.JdbcPaginationHelper;
import com.wenda.comp.dao.jdbc.SysRegionDaoJdbc;
import com.wenda.comp.model.SysRegion;

/**
 * <p>
 * Description: 行政区划daojdbc实现
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
@Repository

public class SysRegionDaoJdbcImpl implements SysRegionDaoJdbc {

	private NamedParameterJdbcTemplate namedJdbcTemplate;

	
	@Autowired
	public void setDataSource(DataSource oracleSource) {
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(oracleSource);
	}

	/**
	 * 行政区划查询
	 * 
	 * @param code
	 * @param name
	 * @param parentId
	 * @param pageable
	 * @return
	 */
	public Page<SysRegion> query(String code, String name, String parentName,
			Pageable pageable) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from sys_region t where 1=1 ");
		StringBuilder countSql = new StringBuilder();
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if (StringUtils.isNotBlank(code)) {
			sql.append("and t.code like:code ");
			paramSource.addValue("code", "%" + code + "%");
		}
		if (StringUtils.isNotBlank(name)) {
			sql.append("and t.name like:name ");
			paramSource.addValue("name", "%" + name + "%");
		}
		if (StringUtils.isNotBlank(parentName)) {
			sql.append("and t.parent_id in (select id from sys_region where name like:parentName)");
			paramSource.addValue("parentName", "%" + parentName + "%");
		}
		countSql.append("select count(*) from ("+sql+")");
		Page<SysRegion> page = JdbcPaginationHelper.queryForPage(
				namedJdbcTemplate, pageable, sql.toString(),
				countSql.toString(), new RowMapper<SysRegion>() {
					public SysRegion mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						SysRegion sysRegion = new SysRegion();
						sysRegion.setId(rs.getLong("id"));
						sysRegion.setCode(rs.getString("code"));
						sysRegion.setName(rs.getString("name"));
						sysRegion.setParentId(rs.getLong("parent_id"));
						sysRegion.setRegionLevel(rs.getInt("region_level"));
						sysRegion.setRemark(rs.getString("remark"));
						return sysRegion;
					}
				}, paramSource);
		return page;
	}
}
