package com.wenda.comp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wenda.comp.model.CollectionPlace;

/**
 * 
 * @ClassName: CollectionPlaceDao
 * @Description: 馆藏地点
 * @author: zhaopo
 * @version: V1.0
 * @date: 2016年11月8日 上午8:59:25
 */
public interface CollectionPlaceDao extends JpaRepository<CollectionPlace, Long> {

	@Query("select t from CollectionPlace t where  t.school.id=?1 ")
	public List<CollectionPlace> getList(Long schoolId);

}
