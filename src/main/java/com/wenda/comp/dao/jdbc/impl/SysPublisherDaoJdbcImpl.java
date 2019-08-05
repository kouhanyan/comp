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
import com.wenda.comp.controller.BaseController;
import com.wenda.comp.dao.jdbc.SysPublisherDaoJdbc;
import com.wenda.comp.model.SysPublisher;

/**
 * <p>
 * Description: daojdbc实现
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
@Repository

public class SysPublisherDaoJdbcImpl extends BaseController implements
		SysPublisherDaoJdbc {
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource oracleSource) {
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(oracleSource);
	}

	/**
	 * 查询出版社
	 * 
	 * @param code
	 * @param name
	 * @param pageable
	 * @return
	 */
	public Page<SysPublisher> query(Long schoolId, String code,
			String name, Pageable pageable) {
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		sql.append("select * from sys_publisher t where t.school_id=:schoolId ");
		paramSource.addValue("schoolId", schoolId);
		StringBuilder countSql = new StringBuilder();
		if (StringUtils.isNotBlank(code)) {
			sql.append("and t.code like:code ");
			paramSource.addValue("code", "%" + code + "%");
		}
		if (StringUtils.isNotBlank(name)) {
			sql.append("and t.name like:name ");
			paramSource.addValue("name", "%" + name + "%");
		}
		countSql.append("select count(*) from (" + sql + ")");
		Page<SysPublisher> page = JdbcPaginationHelper.queryForPage(
				namedJdbcTemplate, pageable, sql.toString(),
				countSql.toString(), new RowMapper<SysPublisher>() {

					public SysPublisher mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						SysPublisher sysPublisher = new SysPublisher();
						sysPublisher.setId(rs.getLong("id"));
						sysPublisher.setCode(rs.getString("code"));
						sysPublisher.setName(rs.getString("name"));
						sysPublisher.setCityCode(rs.getString("city_code"));
						sysPublisher.setCityName(rs.getString("city_name"));
						return sysPublisher;
					}
				}, paramSource);
		return page;
	}

	public Page<SysPublisher> queryPublicPulisher(String code, String name,
			Pageable pageable) {
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		sql.append("select * from sys_publisher t where t.school_id is null ");
		StringBuilder countSql = new StringBuilder();
		if (StringUtils.isNotBlank(code)) {
			sql.append("and t.code like:code ");
			paramSource.addValue("code", "%" + code + "%");
		}
		if (StringUtils.isNotBlank(name)) {
			sql.append("and t.name like:name ");
			paramSource.addValue("name", "%" + name + "%");
		}
		countSql.append("select count(*) from (" + sql + ")");
		Page<SysPublisher> page = JdbcPaginationHelper.queryForPage(
				namedJdbcTemplate, pageable, sql.toString(),
				countSql.toString(), new RowMapper<SysPublisher>() {

					public SysPublisher mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						SysPublisher sysPublisher = new SysPublisher();
						sysPublisher.setId(rs.getLong("id"));
						sysPublisher.setCode(rs.getString("code"));
						sysPublisher.setName(rs.getString("name"));
						sysPublisher.setCityCode(rs.getString("city_code"));
						sysPublisher.setCityName(rs.getString("city_name"));
						return sysPublisher;
					}
				}, paramSource);
		return page;
	}

	public Page<SysPublisher> queryPublicPulisherOrBySchoolId(Long schoolId,
			String code, String name, Pageable pageable) {
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		sql.append("select * from sys_publisher t where t.school_id=:schoolId or t.school_id is null ");
		paramSource.addValue("schoolId", schoolId);
		StringBuilder countSql = new StringBuilder();
		if (StringUtils.isNotBlank(code)) {
			sql.append("and t.code like:code ");
			paramSource.addValue("code", "%" + code + "%");
		}
		if (StringUtils.isNotBlank(name)) {
			sql.append("and t.name like:name ");
			paramSource.addValue("name", "%" + name + "%");
		}
		countSql.append("select count(*) from (" + sql + ")");
		Page<SysPublisher> page = JdbcPaginationHelper.queryForPage(
				namedJdbcTemplate, pageable, sql.toString(),
				countSql.toString(), new RowMapper<SysPublisher>() {

					public SysPublisher mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						SysPublisher sysPublisher = new SysPublisher();
						sysPublisher.setId(rs.getLong("id"));
						sysPublisher.setCode(rs.getString("code"));
						sysPublisher.setName(rs.getString("name"));
						sysPublisher.setCityCode(rs.getString("city_code"));
						sysPublisher.setCityName(rs.getString("city_name"));
						return sysPublisher;
					}
				}, paramSource);
		return page;
	}
}
