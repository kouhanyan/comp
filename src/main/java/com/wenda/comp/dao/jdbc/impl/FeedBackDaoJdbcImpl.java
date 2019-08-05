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
import com.wenda.comp.constant.Constant;
import com.wenda.comp.dao.jdbc.FeedBackDaoJdbc;
import com.wenda.comp.model.FeedBack;

/**
 * <p>
 * Description: 反馈daojdbc实现
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
@Repository

public class FeedBackDaoJdbcImpl implements FeedBackDaoJdbc{

private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource oracleSource) {
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(oracleSource);	
	}
	
	/**
	 * 反馈信息查询
	 * @param userName
	 * @param schoolName
	 * @param isDeal
	 * @param pageable
	 * @return
	 */
	public Page<FeedBack> query(Long schoolId,Integer schoolType,String userName,String schoolName,Integer isDeal,Pageable pageable){	
		StringBuilder sql=new StringBuilder();
		StringBuilder countSql=new StringBuilder();
		sql.append("select * from feed_back t where 1=1 ");
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if(schoolType==Constant.IS_SCHOOL){	
			sql.append("and t.school_id=:schoolId ");
			paramSource.addValue("schoolId", schoolId);
		}
		if(StringUtils.isNotBlank(userName)){	
			sql.append("and t.sys_user_name like:userName ");
			paramSource.addValue("userName", "%"+userName+"%");
		}
		if(StringUtils.isNotBlank(schoolName)){	
			sql.append("and t.school_name like:schoolName ");
			paramSource.addValue("schoolName", "%"+schoolName+"%");
		}
		if(isDeal!=null && isDeal!=0){	
			sql.append("and t.is_deal=:isDeal");
			paramSource.addValue("isDeal", isDeal);
		}
		countSql.append("select count(*) from ("+sql+")");
		Page<FeedBack> page=JdbcPaginationHelper.queryForPage(namedJdbcTemplate, pageable, sql.toString(), countSql.toString(), new RowMapper<FeedBack>() {

			public FeedBack mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				FeedBack feedBack=new FeedBack();
				feedBack.setId(rs.getLong("id"));
				feedBack.setSysUserName(rs.getString("sys_user_name"));
				feedBack.setSchoolName(rs.getString("school_name"));
				feedBack.setProblem(rs.getString("problem"));
				feedBack.setCreateDate(rs.getTimestamp("create_date"));
				feedBack.setIsDeal(rs.getInt("is_deal"));
				return feedBack;
			}
		}, paramSource);
		return page;
	}
}
