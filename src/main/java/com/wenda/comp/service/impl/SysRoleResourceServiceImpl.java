package com.wenda.comp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wenda.comp.constant.Constant;
import com.wenda.comp.dao.SysResourceDao;
import com.wenda.comp.dao.SysRoleResourceDao;
import com.wenda.comp.model.SysResource;
import com.wenda.comp.model.SysRole;
import com.wenda.comp.model.SysRoleResource;
import com.wenda.comp.service.SysRoleResourceService;

/**
 * <p>
 * Description: 系统角色资源关系serviceImpl
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Service
public class SysRoleResourceServiceImpl implements SysRoleResourceService {

	@Autowired
	private SysRoleResourceDao sysRoleResourceDao;

	@Autowired
	private SysResourceDao sysResourceDao;
	
	/**
	 * 系统角色赋权限
	 * 
	 * @param sysRole
	 * @param sysResources
	 */
	@Transactional
	public void endueAuthority(SysRole sysRole, Long[] checks) {
		List<SysRoleResource> sysRoleResources = sysRoleResourceDao
				.findByRoleId(sysRole.getId());
		if (sysRoleResources != null && sysRoleResources.size() > 0) {
			sysRoleResourceDao.delete(sysRoleResources);
		}
		List<SysResource> sysResources = new LinkedList<SysResource>();
		if (checks != null && checks.length > 0) {
			for (Long id : checks) {
				SysResource sysResource = sysResourceDao.findOne(id);
				sysResources.add(sysResource);
			}
		}
		List<SysRoleResource> list = new LinkedList<SysRoleResource>();
		if (sysResources.size() > 0) {
			for (SysResource res : sysResources) {
				SysRoleResource srr = new SysRoleResource();
				srr.setSysRole(sysRole);
				srr.setSysResource(res);
				list.add(srr);
			}
			sysRoleResourceDao.save(list);
		}
	}

	/**
	 * 获取桌面资源
	 * 
	 * @param roleId
	 * @param level
	 * @param nameList
	 * @return
	 */
	public List<SysRoleResource> getDeskRoleResource(Long roleId,
			Integer level, List<String> nameList) {
		List<SysRoleResource> deskList = sysRoleResourceDao
				.findByRoleIdAndResourceNameAndLevel(roleId, level, nameList);
//		Collections.sort(deskList, new Comparator<SysRoleResource>() {
//
//			@Override
//			public int compare(SysRoleResource o1, SysRoleResource o2) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//		});
		List<SysRoleResource> sortList = new ArrayList<SysRoleResource>();
		for(String str : nameList){
			for(SysRoleResource sr : deskList){
				if(sr.getSysResource().getName().equals(str)){
					sortList.add(sr);
				}
			}
		}
		return sortList;
	}

	/**
	 * 获取对应角色的一级资源
	 * 
	 * @param roleId
	 * @return
	 */
	public List<SysRoleResource> getOneRoleResource(Long roleId) {
		List<SysRoleResource> oneList = sysRoleResourceDao.findByRoleId(roleId,
				Constant.MENU_ONE);
		return oneList;
	}

	/**
	 * 获取已经赋予权限的二级和三级资源
	 * 
	 * @param roleId
	 * @param parentId
	 * @return
	 */
	public Map<String, List<SysRoleResource>> getTwoAndThreeRoleResource(
			Long roleId, Long parentId) {
		Map<String, List<SysRoleResource>> resultMap = new HashMap<String, List<SysRoleResource>>();
		List<SysRoleResource> twoList = sysRoleResourceDao
				.findByRoleIdAndLevelAndParentId(roleId, Constant.MENU_TWO,
						parentId);
		resultMap.put("two", twoList);
		if (twoList.size() > 0) {
			List<SysRoleResource> threeList = new LinkedList<SysRoleResource>();
			for (SysRoleResource srr : twoList) {
				List<SysRoleResource> partThreeList = sysRoleResourceDao
						.findByRoleIdAndLevelAndParentId(roleId,
								Constant.MENU_THREE, srr.getSysResource()
										.getId());
				threeList.addAll(partThreeList);
			}
			resultMap.put("three", threeList);
		}
		return resultMap;
	}


}
