package com.wenda.comp.dao.jdbc.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wenda.comp.common.util.JdbcPaginationHelper;
import com.wenda.comp.dao.jdbc.SysResourceDaoJdbc;
import com.wenda.comp.model.SysResource;

/**
 * <p>
 * Description: 系统资源daojdbc实现
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
@Repository

public class SysResourceDaoJdbcImpl implements SysResourceDaoJdbc {

	private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource oracleSource) {
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(oracleSource);
	}

	/**
	 * 查询系统资源
	 * @param name
	 * @param url
	 * @param parentName
	 * @param level
	 * @param pageable
	 * @return
	 */
	public Page<SysResource> query(String name, String url, String parentName,
			Integer level, Pageable pageable) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from sys_resource t where 1=1 ");
		StringBuilder countSql = new StringBuilder();
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if (StringUtils.isNotBlank(name)) {
			sql.append("and t.name like:name ");
			paramSource.addValue("name", "%" + name + "%");
		}
		if (StringUtils.isNotBlank(url)) {
			sql.append("and t.url like:url ");
			paramSource.addValue("url", "%" + url + "%");
		}
		if (StringUtils.isNotBlank(parentName)) {
			sql.append("and t.parent_id in (select id from sys_resource where name like:parentName) ");
			paramSource.addValue("parentName", "%" + parentName + "%");
		}
		if (level != null) {
			sql.append("and t.resource_level=:level");
			paramSource.addValue("level", level);
		}
		countSql.append("select count(*) from (" + sql + ")");
		Page<SysResource> page = JdbcPaginationHelper.queryForPage(
				namedJdbcTemplate, pageable, sql.toString(),
				countSql.toString(), new RowMapper<SysResource>() {

					public SysResource mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						SysResource sysResource = new SysResource();
						sysResource.setId(rs.getLong("id"));
						sysResource.setName(rs.getString("name"));
						sysResource.setUrl(rs.getString("url"));
						sysResource.setParentId(rs.getLong("parent_id"));
						sysResource.setResourceLevel(rs
								.getInt("resource_level"));
						sysResource.setSort(rs.getInt("sort"));
						return sysResource;
					}
				}, paramSource);
		return page;
	}
	
	/**
	 * 获取桌面显示资源
	 * @param deskResourceNames
	 * @param roleId
	 * @return
	 */
	public List<SysResource> findDeskResources(List<String> deskResourceNames,Long roleId){	
		StringBuilder sql=new StringBuilder();
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		sql.append("select * from sys_resource sr where exists ");
		sql.append("(select 1 from sys_role_resource srr where srr.sys_role_id=:roleId and sr.id=srr.sys_resource_id and sr.resource_level=3 and sr.name in (:deskResourceNames)) ");
		paramSource.addValue("roleId", roleId);
		paramSource.addValue("deskResourceNames", deskResourceNames);
		List<SysResource> list=namedJdbcTemplate.query(sql.toString(), paramSource, new RowMapper<SysResource>() {

			public SysResource mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				SysResource sr=new SysResource();
				sr.setId(rs.getLong("id"));
				sr.setName(rs.getString("name"));
				sr.setParentId(rs.getLong("parent_id"));
				sr.setResourceLevel(rs.getInt("resource_level"));
				sr.setUrl(rs.getString("url"));
				sr.setSort(rs.getInt("sort"));
				return sr;
			}
		});
		return list;
	}
}
