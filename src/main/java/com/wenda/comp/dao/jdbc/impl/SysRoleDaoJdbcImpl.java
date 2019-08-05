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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wenda.comp.common.util.JdbcPaginationHelper;
import com.wenda.comp.dao.SchoolDao;
import com.wenda.comp.dao.jdbc.SysRoleDaoJdbc;
import com.wenda.comp.model.SysRole;

/**
 * <p>
 * Description: 系统角色daoJdbc实现
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
@Repository

public class SysRoleDaoJdbcImpl implements SysRoleDaoJdbc {

	private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Autowired
	private SchoolDao schoolDao;
	
	@Autowired
	public void setDataSource(DataSource oracleSource) {
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(oracleSource);
	}

	/**
	 * 查询系统角色
	 * 
	 * @param name
	 * @param schoolId
	 * @param pageable
	 * @return
	 */
	public Page<SysRole> query(String name, String schoolName, Pageable pageable) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from sys_role t where 1=1 ");
		StringBuilder countSql = new StringBuilder();
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if (StringUtils.isNotBlank(name)) {
			sql.append("and t.name like:name ");
			paramSource.addValue("name", "%" + name + "%");
		}
		if (StringUtils.isNotBlank(schoolName)) {
			sql.append("and t.school_id in (select id from school where school_name like:schoolName)");
			paramSource.addValue("schoolName", "%" + schoolName + "%");
		}
		countSql.append("select count(*) from ("+sql+")");
		Page<SysRole> page = JdbcPaginationHelper.queryForPage(
				namedJdbcTemplate, pageable, sql.toString(),
				countSql.toString(), new RowMapper<SysRole>() {
					public SysRole mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						SysRole sysRole = new SysRole();
						sysRole.setId(rs.getLong("id"));
						sysRole.setName(rs.getString("name"));
						sysRole.setSchool(schoolDao.findOne(rs.getLong("school_id")));
						sysRole.setRoleDesc(rs.getString("role_desc"));
						return sysRole;
					}
				}, paramSource);
		return page;
	}

	/**
	 * 查询系统角色
	 * 
	 * @param name
	 * @param schoolId
	 * @param pageable
	 * @return
	 */
	public Page<SysRole> queryBySchoolId(String name, Long schoolId,
			Pageable pageable) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from sys_role t where 1=1 ");
		StringBuilder countSql = new StringBuilder();
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if (StringUtils.isNotBlank(name)) {
			sql.append("and t.name like:name ");
			paramSource.addValue("name", "%" + name + "%");
		}
			sql.append("and t.school_id =:schoolId ");
			paramSource.addValue("schoolId", schoolId);
		countSql.append("select count(*) from ("+sql+")");
		Page<SysRole> page = JdbcPaginationHelper.queryForPage(
				namedJdbcTemplate, pageable, sql.toString(),
				countSql.toString(), new RowMapper<SysRole>() {
					public SysRole mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						SysRole sysRole = new SysRole();
						sysRole.setId(rs.getLong("id"));
						sysRole.setName(rs.getString("name"));
						sysRole.setSchool(schoolDao.findOne(rs.getLong("school_id")));
						sysRole.setRoleDesc(rs.getString("role_desc"));
						return sysRole;
					}
				}, paramSource);
		return page;
	}
}
