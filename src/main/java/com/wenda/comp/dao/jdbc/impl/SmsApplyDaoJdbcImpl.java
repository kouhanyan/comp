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
import com.wenda.comp.dao.jdbc.SmsApplyDaoJdbc;
import com.wenda.comp.enumModel.SmsApplyStateEnum;
import com.wenda.comp.model.SmsApply;

/**
 * <p>
 * Description: 短信充值daojdbc实现
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author jzp
 * @Version 1.0 2014-07-18
 */
@Repository
public class SmsApplyDaoJdbcImpl implements SmsApplyDaoJdbc {

	private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource oracleSource) {
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(oracleSource);
	}

	public Page<SmsApply> query(Long schoolId, Date appleStartDate,
			Date appleEndDate, Pageable pageable) {
		StringBuilder sql = new StringBuilder();
		StringBuilder countSql = new StringBuilder();
		MapSqlParameterSource paramSource = new MapSqlParameterSource();

		sql.append("select * from sms_apply sa where sa.school_id =:schoolId ");
		paramSource.addValue("schoolId", schoolId);
		if (appleStartDate != null) {
			sql.append("and sa.applyDate >= :appleStartDate ");
			paramSource.addValue("appleStartDate", appleStartDate);
		}
		if (appleEndDate != null) {
			sql.append("and sa.applyDate < :appleEndDate ");
			paramSource.addValue("appleEndDate",
					InternetTime.addDate(appleEndDate, 1));
		}
		countSql.append("select count(*) from (" + sql + ")");
		Page<SmsApply> page = JdbcPaginationHelper.queryForPage(
				namedJdbcTemplate, pageable, sql.toString(),
				countSql.toString(), new RowMapper<SmsApply>() {
					public SmsApply mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						SmsApply sa = new SmsApply();
						sa.setId(rs.getLong("id"));
						sa.setSchoolId(rs.getLong("school_id"));
						sa.setSchoolName(rs.getString("school_name"));
						sa.setUserId(rs.getLong("user_id"));
						sa.setUserName(rs.getString("user_name"));
						sa.setApplyNum(rs.getLong("apply_num"));
						sa.setApplyState(SmsApplyStateEnum.values()[rs
								.getInt("apply_state")]);
						sa.setApplyDate(rs.getTimestamp("apply_date"));
						sa.setDealDate(rs.getTimestamp("deal_date"));
						sa.setProject(rs.getString("project"));
						sa.setAmount(rs.getDouble("amount"));
						return sa;
					}
				}, paramSource);
		return page;
	}

	public Page<SmsApply> query(String name, Date appleStartDate,
			Date appleEndDate, SmsApplyStateEnum applyState, Pageable pageable) {
		StringBuilder sql = new StringBuilder();
		StringBuilder countSql = new StringBuilder();
		MapSqlParameterSource paramSource = new MapSqlParameterSource();

		sql.append("select * from sms_apply sa where 1=1 ");
		if (applyState != null) {
			sql.append("and sa.apply_state =:applyState ");
			paramSource.addValue("applyState", applyState);
		}
		if (StringUtils.isNotBlank(name)) {
			sql.append("and sa.school_name =:name ");
			paramSource.addValue("name", name);
		}
		if (appleStartDate != null) {
			sql.append("and sa.applyDate >= :appleStartDate ");
			paramSource.addValue("appleStartDate", appleStartDate);
		}
		if (appleEndDate != null) {
			sql.append("and sa.applyDate < :appleEndDate ");
			paramSource.addValue("appleEndDate",
					InternetTime.addDate(appleEndDate, 1));
		}
		System.out.println(sql.toString());
		countSql.append("select count(*) from (" + sql + ")");
		Page<SmsApply> page = JdbcPaginationHelper.queryForPage(
				namedJdbcTemplate, pageable, sql.toString(),
				countSql.toString(), new RowMapper<SmsApply>() {
					public SmsApply mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						SmsApply sa = new SmsApply();
						sa.setId(rs.getLong("id"));
						sa.setSchoolId(rs.getLong("school_id"));
						sa.setSchoolName(rs.getString("school_name"));
						sa.setUserId(rs.getLong("user_id"));
						sa.setUserName(rs.getString("user_name"));
						sa.setApplyNum(rs.getLong("apply_num"));
						sa.setApplyState(SmsApplyStateEnum.values()[rs
								.getInt("apply_state")]);
						sa.setApplyDate(rs.getTimestamp("apply_date"));
						sa.setDealDate(rs.getTimestamp("deal_date"));
						sa.setProject(rs.getString("project"));
						sa.setAmount(rs.getDouble("amount"));
						return sa;
					}
				}, paramSource);
		return page;
	}

}
