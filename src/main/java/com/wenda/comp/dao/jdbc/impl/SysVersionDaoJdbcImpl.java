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
import com.wenda.comp.dao.jdbc.SysVersionDaoJdbc;
import com.wenda.comp.model.SysVersion;

@Repository
public class SysVersionDaoJdbcImpl implements SysVersionDaoJdbc {
	
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource oracleSource) {
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(oracleSource);
	}
	
	/**
	 * ≤È—Ø∞Ê±æ
	 * @param name
	 * @param userName
	 * @param schoolName
	 * @param pageable
	 * @return
	 */
	public Page<SysVersion> query(String edition,String directory,Pageable pageable){	
		StringBuilder sql=new StringBuilder();
		StringBuilder countSql=new StringBuilder();
		sql.append("select * from sys_version t where 1=1 ");
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if(StringUtils.isNotBlank(edition)){
			sql.append("and edition = :edition ");
			paramSource.addValue("edition", edition);
		}
		if(StringUtils.isNotBlank(directory)){
			sql.append("and directory = :directory ");
			paramSource.addValue("directory", directory);
		}
		countSql.append("select count(*) from ("+sql+")");
		
		Page<SysVersion> page=JdbcPaginationHelper.queryForPage(namedJdbcTemplate, pageable, sql.toString(), countSql.toString(), new RowMapper<SysVersion>() {
			public SysVersion mapRow(ResultSet rs, int rowNum) throws SQLException {
				SysVersion version = new SysVersion();
				version.setId(rs.getLong("id"));
				version.setEdition(rs.getString("edition"));
				version.setDirectory(rs.getString("directory"));
				version.setReleaseNotes(rs.getString("release_notes"));
				version.setCharacteristic(rs.getString("characteristic"));
				version.setCreateDate(rs.getTimestamp("create_date"));
				version.setModifyDate(rs.getTimestamp("modify_date"));
				version.setIsCurrentVersion(rs.getBoolean("is_current_version"));
				return version;
			}
		
		}, paramSource);
		return page;
	}

}
