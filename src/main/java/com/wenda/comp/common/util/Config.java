package com.wenda.comp.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.springframework.web.multipart.MultipartFile;

import com.wenda.comp.exception.BusinessException;

/**
 * <p>
 * Description: ���ý�����
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-17
 */
public class Config {

	/**
	 * ��ȡ�ļ������ϴ�·��
	 * 
	 * @param key
	 * @param windowsPath
	 * @param linuxPath
	 * @param file
	 * @return
	 * @throws BusinessException
	 */
	public static String parseFilePath(String windowsPath, String linuxPath,
			MultipartFile file) throws BusinessException {
		String path = null;
		String fileName = null;
		try {
			if(file.isEmpty())
				throw new BusinessException("�ļ�����Ϊ�գ��ϴ�ʧ��");
			if (isWindows())
				path = parseProperties(windowsPath);
			else
				path = parseProperties(linuxPath);
			fileName = FileUtil.uploadFile(file, path);
		} catch (BusinessException e) {
			throw new BusinessException("�ļ���������");
		} catch (IOException e) {
			throw new BusinessException("�ļ��ϴ�����");
		}
		return path + fileName;
	}

	/**
	 * ��ȡ�ļ�·��
	 * @param windowsPath
	 * @param linuxPath
	 * @return
	 * @throws BusinessException
	 */
	public static String parseFilePath(String windowsPath, String linuxPath)
			throws BusinessException {
		String path = null;
		try {
			if (isWindows())
				path = parseProperties(windowsPath);
			else
				path = parseProperties(linuxPath);
		} catch (BusinessException e) {
			throw new BusinessException("�ļ���������");
		}

		return path;
	}

	public static String parseProperties(String key) throws BusinessException {
		return paresProperties("/filepath.properties", key);
	}

	public static String paresProperties(String path, String key)
			throws BusinessException {
		Properties pro = new Properties();
		InputStream in = Config.class.getResourceAsStream(path);
		try {
			pro.load(in);
		} catch (IOException e) {
			throw new BusinessException("�ļ���������");

		}
		return pro.getProperty(key);
	}

	public static boolean isWindows() {
		Properties prop = System.getProperties();
		String os = prop.getProperty("os.name");
		return os.startsWith("win") || os.startsWith("Win");
	}

	public static void main(String[] args) throws IOException {
		System.out.println(isWindows());
		// System.out.println(paresProperties("/filepath.properties",
		// "wndows.reader.photo"));
	}
	
	public static String createFilePath(String windowsPath, String linuxPath){
		String path = null;
		String fileName = null;
		try {
			if (isWindows()){
				path = parseProperties(windowsPath);
			}else
				path = parseProperties(linuxPath);
				fileName = getSysDatetime() + ".png";
		} catch (BusinessException e) {
			}
		return path + fileName;
	}
	
	/**
	 * ��ȡʱ���
	 * @return
	 */
	public static String getSysDatetime(){
		Calendar rightNow = Calendar.getInstance();
	    SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddhhmmss");
	    String sysDatetime = fmt.format(rightNow.getTime());   
	    return sysDatetime;
	}
}
