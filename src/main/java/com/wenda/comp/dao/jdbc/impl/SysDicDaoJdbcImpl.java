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
import com.wenda.comp.dao.jdbc.SysDicDaoJdbc;
import com.wenda.comp.model.SysDic;

/**
 * <p>
 * Description: 数据字典daojdbc实现
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
@Repository

public class SysDicDaoJdbcImpl implements SysDicDaoJdbc{
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource oracleSource) {
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(oracleSource);
	}

	/**
	 * 查询数据字典
	 * @param dicType
	 * @param dicKey
	 * @param dicValue
	 * @param pageable
	 * @return
	 */
	public Page<SysDic> query(Integer dicType, Integer dicKey, String dicValue,
			Pageable pageable) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from sys_dic t where 1=1 ");
		StringBuilder countSql = new StringBuilder();
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if (dicType != null) {
			sql.append("and t.dic_type=:dicType ");
			paramSource.addValue("dicType", dicType);
		}
		if (dicKey != null) {
			sql.append("and t.dic_key=:dicKey ");
			paramSource.addValue("dicKey", dicKey);
		}
		if (StringUtils.isNotBlank(dicValue)) {
			sql.append("and t.dic_value like:dicValue");
			paramSource.addValue("dicValue", "%" + dicValue + "%");
		}
		countSql.append("select count(*) from ("+sql+")");
		Page<SysDic> page = JdbcPaginationHelper.queryForPage(
				namedJdbcTemplate, pageable, sql.toString(),
				countSql.toString(), new RowMapper<SysDic>() {
					public SysDic mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						SysDic sysDic = new SysDic();
						sysDic.setId(rs.getLong("id"));
						sysDic.setDicType(rs.getInt("dic_type"));
						sysDic.setDicKey(rs.getInt("dic_key"));
						sysDic.setDicValue(rs.getString("dic_value"));
						sysDic.setDicTypeDesc(rs.getString("dic_type_desc"));
						return sysDic;
					}
				}, paramSource);
		return page;
	}
}
