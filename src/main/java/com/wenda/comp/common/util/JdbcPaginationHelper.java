package com.wenda.comp.common.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterUtils;
import org.springframework.jdbc.core.namedparam.ParsedSql;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;

public class JdbcPaginationHelper {
	/**
	 * ���ݸ����Ĳ����������ݿⷵ��һ��intֵ
	 * 
	 * @param jdbcTemplate
	 * @param sql
	 * @param setter
	 * @return
	 */
	public static int queryForInt(final JdbcTemplate jdbcTemplate, String sql,
			PreparedStatementSetter setter) {
		Connection conn = DataSourceUtils.getConnection(jdbcTemplate
				.getDataSource());

		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);

			if (setter != null) {
				setter.setValues(pstmt);
			}

			ResultSet rs = null;
			try {

				rs = pstmt.executeQuery();

				if (rs.next()) {
					return rs.getInt(1);
				}

			} finally {
				JdbcUtils.closeResultSet(rs);
			}
		} catch (SQLException e) {
			throw jdbcTemplate.getExceptionTranslator().translate(
					"queryForInt", sql, e);
		} finally {
			JdbcUtils.closeStatement(pstmt);
			DataSourceUtils.releaseConnection(conn,
					jdbcTemplate.getDataSource());
		}

		return 0;
	}

	/**
	 * ���ݸ����Ĳ����������ݿⷵ��һ��intֵ
	 * 
	 * @param namedJdbcTemplate
	 * @param sql
	 * @param paramSource
	 * @return
	 */
	public static int queryForInt(
			final NamedParameterJdbcTemplate namedJdbcTemplate, String sql,
			SqlParameterSource paramSource) {

		JdbcOperations jdbcTemplate = namedJdbcTemplate.getJdbcOperations();

		ParsedSql parsedSql = NamedParameterUtils.parseSqlStatement(sql);

		String sqlToUse = NamedParameterUtils.substituteNamedParameters(
				parsedSql, paramSource);

		Object[] params = NamedParameterUtils.buildValueArray(parsedSql,
				paramSource, null);

		List<SqlParameter> declaredParameters = NamedParameterUtils
				.buildSqlParameterList(parsedSql, paramSource);

		PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
				sqlToUse, declaredParameters);

		PreparedStatementCreator psc = pscf.newPreparedStatementCreator(params);

		List<Integer> results = jdbcTemplate.query(psc,
				new SingleColumnRowMapper<Integer>(Integer.class));

		Integer result = DataAccessUtils.requiredSingleResult(results);

		if (result != null) {
			return result.intValue();
		} else {
			return 0;
		}
	}

	/**
	 * �����ݿ��ҳ��ѯ����� NamedParameter ��ʽ�������װΪ Page<Map<String, Object>>
	 * 
	 * @param namedJdbcTemplate
	 * @param pageable
	 * @param sql
	 * @param countSql
	 * @param rowMapper
	 * @param paramSource
	 * @return
	 */
	public static Page<Map<String, Object>> queryForPage(
			NamedParameterJdbcTemplate namedJdbcTemplate,
			final Pageable pageable, String sql, String countSql,
			final SqlParameterSource paramSource) {
		return queryForPage(namedJdbcTemplate, pageable, sql, countSql,
				new ColumnMapRowMapper(), paramSource);
	}

	/**
	 * �����ݿ��ҳ��ѯ����� NamedParameter ��ʽ�������װΪ Page<Map<String, Object>>
	 * 
	 * @param namedJdbcTemplate
	 * @param pageable
	 * @param sql
	 * @param countSql
	 * @param rowMapper
	 * @param paramSource
	 * @return
	 */
	public static Page<Map<String, Object>> queryForPage(
			NamedParameterJdbcTemplate namedJdbcTemplate,
			final Pageable pageable, String sql, String countSql) {
		return queryForPage(namedJdbcTemplate, pageable, sql, countSql,
				new ColumnMapRowMapper(), null);
	}

	/**
	 * �����ݿ��ҳ��ѯ����� NamedParameter ��ʽ
	 * 
	 * @param namedJdbcTemplate
	 * @param pageable
	 * @param sql
	 * @param countSql
	 * @param rowMapper
	 * @return
	 */
	public static <E> Page<E> queryForPage(
			NamedParameterJdbcTemplate namedJdbcTemplate,
			final Pageable pageable, String sql, String countSql,
			final RowMapper<E> rowMapper) {
		return queryForPage(namedJdbcTemplate, pageable, sql, countSql,
				rowMapper, null);
	}

	/**
	 * �����ݿ��ҳ��ѯ����� NamedParameter ��ʽ
	 * 
	 * @param namedJdbcTemplate
	 * @param pageable
	 * @param sql
	 * @param countSql
	 * @param rowMapper
	 * @param paramSource
	 * @return
	 */
	public static <E> Page<E> queryForPage(
			NamedParameterJdbcTemplate namedJdbcTemplate,
			final Pageable pageable, String sql, String countSql,
			final RowMapper<E> rowMapper, final SqlParameterSource paramSource) {
		if (!(namedJdbcTemplate.getJdbcOperations() instanceof JdbcTemplate)) {
			throw new RuntimeException(
					"Cannot get JdbcTemplate from NamedParameterJdbcTemplate");
		}

//		sql = appendOrderByToSql(pageable, sql);

		JdbcTemplate jdbcTemplate = (JdbcTemplate) namedJdbcTemplate
				.getJdbcOperations();

		int count;
		if (paramSource != null) {
			count = queryForInt(namedJdbcTemplate, countSql, paramSource);
		} else {
			count = jdbcTemplate.queryForInt(countSql);
		}

		ParsedSql parsedSql = NamedParameterUtils.parseSqlStatement(sql);

		String sqlToUse = NamedParameterUtils.substituteNamedParameters(
				parsedSql, paramSource);

		Object[] params = NamedParameterUtils.buildValueArray(parsedSql,
				paramSource, null);

		List<SqlParameter> declaredParameters = NamedParameterUtils
				.buildSqlParameterList(parsedSql, paramSource);

		PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
				sqlToUse, declaredParameters);

		PreparedStatementSetter setter = pscf
				.newPreparedStatementSetter(params);

		int s = pageable.getOffset() >= 1 ? pageable.getOffset() + 1 : 1;

		int recordNum = /*pageable.getOffset() +*/ pageable.getPageSize();
		
		List<E> l = queryForList(jdbcTemplate, sqlToUse, rowMapper, setter, s,
				recordNum);

		return new PageImpl<E>(l, pageable, count);

	}

	/**
	 * �����ݿ��ҳ��ѯ����� ��ͳ jdbc ��ʽ�� �����װΪ Map<String, Object>
	 * 
	 * @param jdbcTemplate
	 * @param pageable
	 * @param sql
	 * @param countSql
	 * @param rowMapper
	 * @return
	 */
	public static Page<Map<String, Object>> queryForPage(
			final JdbcTemplate jdbcTemplate, final Pageable pageable,
			String sql, String countSql) {
		return queryForPage(jdbcTemplate, pageable, sql, countSql,
				new ColumnMapRowMapper(), null);
	}

	/**
	 * �����ݿ��ҳ��ѯ����� ��ͳ jdbc ��ʽ�� �����װΪ Map<String, Object>
	 * 
	 * @param jdbcTemplate
	 * @param pageable
	 * @param sql
	 * @param countSql
	 * @param rowMapper
	 * @return
	 */
	public static Page<Map<String, Object>> queryForPage(
			final JdbcTemplate jdbcTemplate, final Pageable pageable,
			String sql, String countSql, final PreparedStatementSetter setter) {
		return queryForPage(jdbcTemplate, pageable, sql, countSql,
				new ColumnMapRowMapper(), setter);
	}

	/**
	 * �����ݿ��ҳ��ѯ����� ��ͳ jdbc ��ʽ
	 * 
	 * @param jdbcTemplate
	 * @param pageable
	 * @param sql
	 * @param countSql
	 * @param rowMapper
	 * @return
	 */
	public static <E> Page<E> queryForPage(final JdbcTemplate jdbcTemplate,
			final Pageable pageable, String sql, String countSql,
			final RowMapper<E> rowMapper) {
		return queryForPage(jdbcTemplate, pageable, sql, countSql, rowMapper,
				null);
	}

	/**
	 * �����ݿ��ҳ��ѯ����� ��ͳ jdbc ��ʽ
	 * 
	 * @param jdbcTemplate
	 * @param pageable
	 * @param sql
	 * @param countSql
	 * @param rowMapper
	 * @param setter
	 * @return
	 */
	public static <E> Page<E> queryForPage(final JdbcTemplate jdbcTemplate,
			final Pageable pageable, String sql, String countSql,
			final RowMapper<E> rowMapper, final PreparedStatementSetter setter) {
		sql = appendOrderByToSql(pageable, sql);

		int count;
		if (setter != null) {
			count = queryForInt(jdbcTemplate, countSql, setter);
		} else {
			count = jdbcTemplate.queryForInt(countSql);
		}

		int s = pageable.getOffset() >= 1 ? pageable.getOffset() + 1 : 1;

		int recordNum = /*pageable.getOffset() +*/ pageable.getPageSize();

		List<E> l = queryForList(jdbcTemplate, sql, rowMapper, setter, s,
				recordNum);

		return new PageImpl<E>(l, pageable, count);
	}

	/**
	 * �����ݿ���ط�ҳ���ݣ������ֻ�����ҿɹ�������Ҫjdbc����֧��
	 * 
	 * @param jdbcTemplate
	 * @param sqlToUse
	 * @param rowMapper
	 * @param setter
	 * @param start
	 * @param recordNum
	 * @return
	 */
	protected static <E> List<E> queryForList(JdbcTemplate jdbcTemplate,
			String sqlToUse, final RowMapper<E> rowMapper,
			PreparedStatementSetter setter, int start, int recordNum) {
		List<E> l = new ArrayList<E>();
		Connection conn = DataSourceUtils.getConnection(jdbcTemplate
				.getDataSource());
		/*sqlToUse = "select * from (select row_.*, rownum rownum_ from (" + sqlToUse + ") row_ where rownum <= " + (start - 1 + recordNum) + ")" +
				" where rownum_ >= " + start;*/
		sqlToUse = sqlToUse + " limit " + (start -1) +","+recordNum ;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sqlToUse,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			if (setter != null) {
				setter.setValues(pstmt);
			}
			ResultSet rs = null;
			try {
				rs = pstmt.executeQuery();
				int i = 1;
				while(rs.next() && i <= recordNum){
					l.add(rowMapper.mapRow(rs, i));
					i++;
				}
			} finally {
				JdbcUtils.closeResultSet(rs);
			}
		} catch (SQLException e) {
			throw jdbcTemplate.getExceptionTranslator().translate("findAll",
					sqlToUse, e);
		} finally {
			JdbcUtils.closeStatement(pstmt);
			DataSourceUtils.releaseConnection(conn,
					jdbcTemplate.getDataSource());
		}
		return l;
	}

	/**
	 * ���� pageable ׷��order by ��sql���
	 * 
	 * @param pageable
	 * @param sql
	 * @return
	 */
	public static String appendOrderByToSql(Pageable pageable, String sql) {
		Sort sort = pageable.getSort();
		if (sort != null) {
			sql += " order by";
			int index = 0;
			for (Order p : sort) {
				if (index > 0) {
					sql += ",";
				}
				sql += " " + p.getProperty() + " " + p.getDirection();
				/*if (p.getDirection().equals(Direction.ASC)) {
					sql += " " + p.getProperty() + " " + p.getDirection() + " NULLS FIRST";
				} else {
					sql += " " + p.getProperty() + " " + p.getDirection() + " NULLS LAST";
				}*/
				
				index++;
			}
		}
		return sql;
	}
}
