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
import com.wenda.comp.dao.jdbc.SysAnnouncementDaoJdbc;
import com.wenda.comp.model.SysAnnouncement;

@Repository
public class SysAnnouncementDaoJdbcImpl implements SysAnnouncementDaoJdbc {
	
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	@Autowired
	public void setDataSource(DataSource oracleSource) {
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(oracleSource);

	}

	public Page<SysAnnouncement> query(String title, String sender,
			Pageable pageable) {
		StringBuilder sql=new StringBuilder();
		StringBuilder countSql=new StringBuilder();
		sql.append("select * from sys_announcement t where 1=1 ");
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if(StringUtils.isNotBlank(title)){
			sql.append("and title like :title ");
			paramSource.addValue("title", "%"+title+"%");
		}
		if(StringUtils.isNotBlank(sender)){
			sql.append("and sender like: :sender ");
			paramSource.addValue("directory", "%"+sender+"%");
		}
		countSql.append("select count(*) from ("+sql+")");
		
		Page<SysAnnouncement> page=JdbcPaginationHelper.queryForPage(namedJdbcTemplate, pageable, sql.toString(), countSql.toString(), new RowMapper<SysAnnouncement>() {
			public SysAnnouncement mapRow(ResultSet rs, int rowNum) throws SQLException {
				SysAnnouncement sysAnnouncement = new SysAnnouncement();
				sysAnnouncement.setId(rs.getLong("id"));
				sysAnnouncement.setSysUserId(rs.getLong("sys_user_id"));
				sysAnnouncement.setSender(rs.getString("sender"));
				sysAnnouncement.setTitle(rs.getString("title"));
				sysAnnouncement.setContent(rs.getString("content"));
				sysAnnouncement.setSendDate(rs.getTimestamp("send_date"));
				sysAnnouncement.setIsDisplay(rs.getBoolean("is_display"));
				return sysAnnouncement;
			}
		
		}, paramSource);
		return page;
	}

}
