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
import com.wenda.comp.dao.SchoolDao;
import com.wenda.comp.dao.jdbc.SysUserDaoJdbc;
import com.wenda.comp.model.SysUser;

/**
 * <p>
 * Description: 系统用户daojdbc实现
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-22
 */
@Repository

public class SysUserDaoJdbcImpl implements SysUserDaoJdbc {

	private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Autowired
	private SchoolDao schoolDao;
	
	@Autowired
	public void setDataSource(DataSource oracleSource) {
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(oracleSource);
	}

	/**
	 * 查询系统用户
	 * @param name
	 * @param userName
	 * @param schoolName
	 * @param pageable
	 * @return
	 */
	public Page<SysUser> query(String name,String userName,String schoolName,Pageable pageable){	
		StringBuilder sql=new StringBuilder();
		StringBuilder countSql=new StringBuilder();
		sql.append("select * from sys_user t where 1=1 ");
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if(StringUtils.isNotBlank(name)){	
			sql.append("and t.name like:name ");
			paramSource.addValue("name", "%"+name+"%");
		}
		if(StringUtils.isNotBlank(userName)){	
			sql.append("and t.user_name like:userName ");
			paramSource.addValue("userName", "%"+userName+"%");
		}
		if(StringUtils.isNotBlank(schoolName)){	
			sql.append("and t.school_id in (select id from school where school_name like:schoolName) ");
			paramSource.addValue("schoolName", "%"+schoolName+"%");
		}
		countSql.append("select count(*) from ("+sql+")");
		Page<SysUser> page=JdbcPaginationHelper.queryForPage(namedJdbcTemplate, pageable, sql.toString(), countSql.toString(), new RowMapper<SysUser>() {
			public SysUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				SysUser sysUser=new SysUser();
				sysUser.setId(rs.getLong("id"));
				sysUser.setName(rs.getString("name"));
				sysUser.setUserName(rs.getString("user_name"));
				sysUser.setEmail(rs.getString("email"));
				sysUser.setPhone(rs.getString("phone"));
				sysUser.setSchool(schoolDao.findOne(rs.getLong("school_id")));
				return sysUser;
			}
		
		}, paramSource);
		return page;
	}
}
