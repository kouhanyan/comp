package com.wenda.comp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wenda.comp.dao.Z3950Dao;
import com.wenda.comp.model.Z3950;
import com.wenda.comp.service.Z3950Service;

/**
 * <p>
 * Description: z3950serviceImpl
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Service

public class Z3950ServiceImpl implements Z3950Service{

	@Autowired
	private Z3950Dao z3950Dao;
	
	/**
	 * Õ®π˝id≤È’“z3950≈‰÷√
	 * @param id
	 * @return
	 */
	public Z3950 findOneZ3950(Long id){	
		Z3950 z3950=z3950Dao.findOne(id);
		return z3950;
	}
	
}
