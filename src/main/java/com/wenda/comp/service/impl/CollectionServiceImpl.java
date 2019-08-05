package com.wenda.comp.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wenda.comp.common.util.JsonUtil;
import com.wenda.comp.dao.CollectionDao;
import com.wenda.comp.vo.backUps.CollectionBean;
import com.wenda.comp.model.BiblioAcceptanceBook;
import com.wenda.comp.model.BiblioTemp;
import com.wenda.comp.model.BookCirculateType;
import com.wenda.comp.model.Collection;
import com.wenda.comp.model.CollectionPlace;
import com.wenda.comp.model.School;
import com.wenda.comp.service.CollectionService;

/**
 * <p>
 * Description: 条码库serviceImpl
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Service
public class CollectionServiceImpl implements CollectionService {

	@Autowired
	private CollectionDao collectionDao;
	/**
	 * 
	 * @Title: deal
	 * @Description: 数据恢复
	 * @param list
	 * @return
	 */
	public String deal(List<String> list) {
		StringBuilder exist = new StringBuilder();
		int i = 0;
		for (String s : list) {
			CollectionBean cb = (CollectionBean) JsonUtil.json2obj(s,
					CollectionBean.class);
			Collection c = convert(cb);
			Collection entity_c = collectionDao.findOne(c.getId());
			if (entity_c == null) {
				collectionDao.save(c);
				i++;
			} else {
				exist.append(c.getBarcode() + ",");
			}
		}
		return "总共条数:" + list.size() + ";成功条数:" + i + ";已存在条码："
				+ exist.toString();
	}

	private Collection convert(CollectionBean cb) {
		Collection c = new Collection();
		c.setId(cb.getId());
		BiblioTemp bt = new BiblioTemp();
		bt.setId(cb.getBiblioTempId());
		c.setBiblioTemp(bt);
		BiblioAcceptanceBook bab = new BiblioAcceptanceBook();
		bab.setId(cb.getBiblioAcceptanceBookId());
		c.setBiblioAcceptanceBook(bab);
		CollectionPlace cp = new CollectionPlace();
		cp.setId(cb.getCollectionPlaceId());
		c.setCollectionPlace(cp);
		School school = new School();
		school.setId(cb.getSchoolId());
		c.setSchool(school);
		BookCirculateType bct = new BookCirculateType();
		bct.setId(cb.getBookCirculateTypeId());
		c.setBookCirculateType(bct);
		c.setBookSellerId(cb.getBookSellerId());
		c.setBudgetId(cb.getBudgetId());
		c.setBarcode(cb.getBarcode());
		c.setBarcodeNum(cb.getBarcodeNum());
		c.setCallNo(cb.getCallNo());
		c.setSinglePrice(cb.getSinglePrice());
		c.setTotalPrice(cb.getTotalPrice());
		c.setBookSource(cb.getBookSource());
		c.setMediaType(cb.getMediaType());
		c.setBindInfo(cb.getBindInfo());
		c.setVolNum(cb.getVolNum());
		c.setVolInfo(cb.getVolInfo());
		c.setTotalLendNum(cb.getTotalLendNum());
		c.setStatus(cb.getStatus());
		c.setSysUserId(cb.getSysUserId());
		c.setCreateDate(cb.getCreateDate());
		c.setDealDate(cb.getDealDate());
		c.setType(cb.getType());
		c.setState(cb.getState());
		c.setRemark(cb.getRemark());
		c.setIsHadRegist(cb.getIsHadRegist());
		return c;

	}

}
