package com.wenda.comp.service;

import java.util.List;
import java.util.Map;

import com.wenda.comp.exception.BusinessException;
import com.wenda.comp.form.MarcForm;

public interface MarcService {

	/**
	 * 
	 * @Title: addMarc
	 * @Description: marc数据导入
	 * @param batchId
	 * @param marcFormat
	 * @param marcDatas
	 * @param lines
	 * @param bookType
	 * @return
	 * @throws BusinessException
	 * @return: Map<String,Object>
	 */
	public Map<String, Object> addMarc(Long batchId, Integer marcFormat, List<Map<String, String>> marcDatas, List<String> lines, Integer bookType,MarcForm marcForm) throws BusinessException;

}
