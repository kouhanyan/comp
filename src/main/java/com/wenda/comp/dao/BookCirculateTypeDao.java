package com.wenda.comp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wenda.comp.model.BookCirculateType;

/**
 * 
 * @ClassName: BookCirculateTypeDao
 * @Description: 文献流通类型
 * @author: zhaopo
 * @version: V1.0
 * @date: 2016年11月8日 上午9:03:35
 */
public interface BookCirculateTypeDao extends JpaRepository<BookCirculateType, Long> {
	
	@Query("select t from BookCirculateType t where t.school.id = ?1 ")
	public List<BookCirculateType> getList(Long schoolId);

}
