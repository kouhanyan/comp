package com.wenda.comp.dao.jdbc.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wenda.comp.common.util.InternetTime;
import com.wenda.comp.common.util.JdbcPaginationHelper;
import com.wenda.comp.dao.jdbc.CompLogDaoJdbc;
import com.wenda.comp.model.CompLog;

/**
 * <p>
 * Description: 系统日志daojdbcimpl
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
@Repository
public class CompLogJdbcImpl implements CompLogDaoJdbc{

	private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource oracleSource) {
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(oracleSource);
	}
	
	/**
	 * 查询系统后台日志
	 * @param userName
	 * @param startDate
	 * @param endDate
	 * @param pageable
	 * @return
	 */
	public Page<CompLog> query(String userName,Date startDate,Date endDate,Pageable pageable){
		StringBuilder sql = new StringBuilder();
		StringBuilder countSql = new StringBuilder();
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		sql.append("select * from comp_log t where 1=1 ");
		if(StringUtils.isNotBlank(userName)){	
			sql.append("and t.user_name like:userName ");
			paramSource.addValue("userName", userName);
		}
		if(startDate!=null){	
			sql.append("and t.create_date>=:startDate ");
			paramSource.addValue("startDate", startDate);
		}
		if(endDate!=null){	
			sql.append("and t.create_date<:endDate ");
			paramSource.addValue("endDate", InternetTime.addDate(endDate, 1));
		}
		countSql.append("select count(*) from ("+sql+")");
		Page<CompLog> page=JdbcPaginationHelper.queryForPage(namedJdbcTemplate, pageable, sql.toString(), countSql.toString(),new RowMapper<CompLog>() {

			public CompLog mapRow(ResultSet rs, int rowNum) throws SQLException {
				CompLog compLog=new CompLog();
				compLog.setIp(rs.getString("ip"));
				compLog.setUserName(rs.getString("user_name"));
				compLog.setCreateDate(rs.getTimestamp("create_date"));
				return compLog;
			}
		}, paramSource);
		return page;
	}
}
