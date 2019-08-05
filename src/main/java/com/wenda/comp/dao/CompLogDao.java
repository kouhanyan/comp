package com.wenda.comp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wenda.comp.model.CompLog;

@Repository
public interface CompLogDao extends JpaRepository<CompLog, Long>{

}
