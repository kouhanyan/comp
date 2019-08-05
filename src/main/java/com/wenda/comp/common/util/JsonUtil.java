package com.wenda.comp.common.util;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

import org.apache.commons.beanutils.BeanUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * json工具类
 * 
 * @author jinzhaopo
 * 
 */
public class JsonUtil {
	/**
	 * 将json字符串变成指定的对象
	 * 没有用到工具
	 * 
	 * @param json
	 * @param classType
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static <T> Object json2Obj(String json, Class<T> classType) {
		T t = null;
		try {
			JSONObject jb = new JSONObject(json);
			t = classType.newInstance();
			for (Iterator it = jb.keys(); it.hasNext();) {
				String key = (String) it.next();
				String value = jb.getString(key).toString();
				BeanUtils.setProperty(t, key.toLowerCase(), value);// 这边全变为小写反射的时候好些点
			}
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return t;

	}
	private static JsonUtil ju;
	private static JsonFactory jf;
	private static ObjectMapper mapper;
	private JsonUtil(){}
	
	public static JsonUtil getInstance() {
		if(ju==null) ju = new JsonUtil();
		return ju;
	}
	
	public static ObjectMapper getMapper() {
		if(mapper==null) {
			mapper = new ObjectMapper();
		}
		return mapper;
	}
	
	public static JsonFactory getFactory() {
		if(jf==null) jf = new JsonFactory();
		return jf;
	}
	
	public static String obj2json(Object obj) {
		JsonGenerator jg = null;
		try {
			jf = getFactory();
			mapper = getMapper();
			StringWriter out = new StringWriter();
			jg = jf.createJsonGenerator(out);
			mapper.writeValue(jg, obj);
			return out.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(jg!=null) jg.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static Object json2obj(String json, Class<?> clz) {
		try {
			mapper = getMapper();
			return mapper.readValue(json,clz);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	

}
