package com.wenda.comp.common.util;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.converters.DateConverter;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.ClassPathResource;

import com.wenda.comp.common.util.mail.MyConvertUtils;
import com.wenda.comp.form.Setting;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

public class SettingUtils {
	private static final CacheManager cacheManager = CacheManager.getInstance();
	private static final BeanUtilsBean beanUtilsBean;
	static {
		MyConvertUtils myConvertUtils = new MyConvertUtils();
		DateConverter dateconverter = new DateConverter();
		dateconverter.setPatterns(DateEditor.DATE_PATTERNS);
		myConvertUtils.register(dateconverter, Date.class);
		beanUtilsBean = new BeanUtilsBean(myConvertUtils);
	}

	
	  /**
     * 获取系统配置信息
     * @return
     */
	@SuppressWarnings("unchecked")
	public static Setting get() {
		Ehcache ehcache = cacheManager.getEhcache(Setting.CACHE_NAME);
		Element element = ehcache.get(Setting.CACHE_KEY);
		Setting setting;
		if (element != null) {
			setting = (Setting)element.getObjectValue();
		} else {
			setting = new Setting();
			try {
				File file = new ClassPathResource("/setting.xml").getFile();
				Document document = (new SAXReader()).read(file);
				List<org.dom4j.Element> list = document.selectNodes("/wenda/setting");
				for (Iterator<org.dom4j.Element> iterator = list.iterator(); iterator.hasNext();){
					org.dom4j.Element element1 = iterator.next();
					String s = element1.attributeValue("name");
					String s1 = element1.attributeValue("value");
					try {
						beanUtilsBean.setProperty(setting, s, s1);
					} catch (IllegalAccessException illegalaccessexception) {
						illegalaccessexception.printStackTrace();
					}
					catch (InvocationTargetException invocationtargetexception) {
						invocationtargetexception.printStackTrace();
					}
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			}
			ehcache.put(new Element(Setting.CACHE_KEY, setting));
		}
		return setting;
    }
	
}
