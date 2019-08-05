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
import com.wenda.comp.dao.SysRegionDao;
import com.wenda.comp.dao.jdbc.SchoolDaoJdbc;
import com.wenda.comp.model.School;

/**
 * <p>
 * Description: 学校daojdbc实现
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-22
 */
@Repository

public class SchoolDaoJdbcImpl implements SchoolDaoJdbc {

	private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Autowired
	private SysRegionDao sysRegionDao;
	
	@Autowired
	public void setDataSource(DataSource oracleSource) {
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(oracleSource);
	}

	/**
	 * 查询学校
	 * @param code
	 * @param simpleName
	 * @param name
	 * @param type
	 * @param pageable
	 * @return
	 */
	public Page<School> query(String code, String simpleName, String name,
			Integer type, Pageable pageable) {
		StringBuilder sql = new StringBuilder();
		StringBuilder countSql = new StringBuilder();
		sql.append("select * from school t where 1=1 ");
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if (StringUtils.isNotBlank(code)) {
			sql.append("and t.school_code like:code ");
			paramSource.addValue("code", "%" + code + "%");
		}
		if (StringUtils.isNotBlank(simpleName)) {
			sql.append("and t.simple_name like:simpleName ");
			paramSource.addValue("simpleName", "%" + simpleName + "%");
		}
		if (StringUtils.isNotBlank(name)) {
			sql.append("and t.school_name like:name ");
			paramSource.addValue("name", "%" + name + "%");
		}
		if (type != null && type!=0) {
			sql.append("and t.type=:type ");
			paramSource.addValue("type", type);
		}
		countSql.append("select count(*) from ("+sql+")");
		Page<School> page = JdbcPaginationHelper.queryForPage(
				namedJdbcTemplate, pageable, sql.toString(),
				countSql.toString(), new RowMapper<School>() {

					public School mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						School school = new School();
						school.setId(rs.getLong("id"));
						school.setSchoolCode(rs.getString("school_code"));
						school.setSimpleName(rs.getString("simple_name"));
						school.setSchoolName(rs.getString("school_name"));
						school.setSysRegion(sysRegionDao.findOne(rs.getLong("sys_region_id")));
						school.setType(rs.getInt("type"));
						return school;
					}
				}, paramSource);
		return page;
	}
}
