package com.wenda.comp.dao.jdbc.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.swing.text.html.HTMLDocument.HTMLReader.ParagraphAction;

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
import com.wenda.comp.dao.SysUserDao;
import com.wenda.comp.dao.jdbc.Z3950DaoJdbc;
import com.wenda.comp.model.Z3950;

@Repository

public class Z3950DaoJdbcImpl implements Z3950DaoJdbc {

	private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Autowired
	private SysUserDao sysUserDao;

	@Autowired
	public void setDataSource(DataSource oracleSource) {
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(oracleSource);
	}

	/**
	 * ≤È—Øz3950
	 * 
	 * @param name
	 * @param server
	 * @param database
	 * @param pageable
	 * @param schoolId
	 * @return
	 */
	public Page<Z3950> query(Integer type, String name, String server,
			String database, Long schoolId, Pageable pageable) {
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if (type == Constant.IS_COMPANY)
			sql.append("select * from z3950 t where t.school_id is null ");
		else {
			sql.append("select * from z3950 t where t.school_id=:schoolId ");
			paramSource.addValue("schoolId", schoolId);
		}
		StringBuilder countSql = new StringBuilder();
		paramSource.addValue("schoolId", schoolId);
		if (StringUtils.isNotBlank(name)) {
			sql.append("and t.name like:name ");
			paramSource.addValue("name", "%" + name + "%");
		}
		if (StringUtils.isNotBlank(server)) {
			sql.append("and t.server like:server ");
			paramSource.addValue("server", "%" + server + "%");
		}
		if (StringUtils.isNotBlank(database)) {
			sql.append("and t.database like:database ");
			paramSource.addValue("database", "%" + database + "%");
		}
		countSql.append("select count(*) from (" + sql + ")");
		Page<Z3950> page = JdbcPaginationHelper.queryForPage(namedJdbcTemplate,
				pageable, sql.toString(), countSql.toString(),
				new RowMapper<Z3950>() {
					public Z3950 mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Z3950 z3950 = new Z3950();
						z3950.setId(rs.getLong("id"));
						z3950.setName(rs.getString("name"));
						z3950.setCountry(rs.getString("country"));
						z3950.setServer(rs.getString("server"));
						z3950.setPort(rs.getString("port"));
						z3950.setDatabase(rs.getString("database"));
						z3950.setUserName(rs.getString("user_name"));
						z3950.setAuthType(rs.getInt("auth_type"));
						z3950.setSysUser(sysUserDao.findOne(rs
								.getLong("sys_user_id")));
						return z3950;
					}
				}, paramSource);
		return page;
	}
}
