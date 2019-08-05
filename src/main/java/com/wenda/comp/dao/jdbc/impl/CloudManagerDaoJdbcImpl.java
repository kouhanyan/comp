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
import com.wenda.comp.dao.SchoolDao;
import com.wenda.comp.dao.jdbc.CloudManagerDaoJdbc;
import com.wenda.comp.model.CloudManager;

/**
 * <p>
 * Description: 云端维护daojdbcImpl
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
@Repository
public class CloudManagerDaoJdbcImpl implements CloudManagerDaoJdbc{

	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	@Autowired
	private SchoolDao schoolDao;
	
	@Autowired
	public void setDataSource(DataSource oracleSource) {
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(oracleSource);
	}

	/**
	 * 云端维护列表查询
	 * @param schoolId
	 * @param dealStatus
	 * @param startDate
	 * @param endDate
	 * @param pageable
	 * @return
	 */
	public Page<CloudManager> query(boolean isComp,Long schoolId,Integer dealStatus,Date startDate,Date endDate,Pageable pageable){	
		StringBuilder sql=new StringBuilder();
		StringBuilder countSql = new StringBuilder();
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		sql.append("select t.* from cloud_manager t where exists (select 1 from school s where t.school_id=s.id ");
		if(isComp){	
			sql.append("and s.agent_user_id is null ");
		}
		sql.append(") ");
		if(schoolId!=null){	
			sql.append("and t.school_id=:schoolId ");
			paramSource.addValue("schoolId", schoolId);
		}
		if(dealStatus!=null){	
			sql.append("and t.deal_status=:dealStatus ");
			paramSource.addValue("dealStatus", dealStatus);
		}
		if(startDate!=null){	
			sql.append("and t.create_date>=:startDate ");
			paramSource.addValue("startDate", startDate);
		}
		if(endDate!=null){	
			sql.append("and t.create_date<:endDate ");
			paramSource.addValue("endDate",InternetTime.addDate(endDate, 1));
		}
		countSql.append("select count(*) from ("+sql+")");
		Page<CloudManager> page=JdbcPaginationHelper.queryForPage(namedJdbcTemplate, pageable, sql.toString(), countSql.toString(),new RowMapper<CloudManager>() {

			public CloudManager mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				CloudManager cloudManager=new CloudManager();
				cloudManager.setId(rs.getLong("id"));
				cloudManager.setSchool(schoolDao.findOne(rs.getLong("school_id")));
				cloudManager.setSysUserId(rs.getLong("sys_user_id"));
				cloudManager.setCreateDate(rs.getTimestamp("create_date"));
				cloudManager.setDealStatus(rs.getInt("deal_status"));
				cloudManager.setDescribe(rs.getString("describe"));
				return cloudManager;
			}
		}, paramSource);
		return page;
	}
}
