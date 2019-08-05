package com.wenda.comp.common.util;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.wenda.comp.common.util.UUIDGenerator;
import com.wenda.comp.constant.Constant;
import com.wenda.comp.exception.BusinessException;

/**
 * <p>
 * Description: 文件上传类
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-17
 */
public class FileUtil {

	private static final Logger logger = LoggerFactory
			.getLogger(FileUtil.class);

	/**
	 * 上传文件(绝对地址)，并用uuid重命名文件名
	 * 
	 * @param file
	 * @param path
	 * @return String
	 * @throws IOException
	 * @throws BusinessException
	 */
	public final static String uploadFile(MultipartFile file, String path)
			throws IOException, BusinessException {
		if (file == null) {
			logger.error("要另存为的文件不存在");
			throw new BusinessException(Constant.ERROR_FILE_NOTFOUND);
		}

		InputStream inputStream = null;
		OutputStream outputStream = null;
		String fileName;
		try {
			if (!isExist(path)) {
				logger.error("创建文件路径失败");
				throw new BusinessException(Constant.ERROR_FILE_CREATE);
			}
			;
			inputStream = file.getInputStream();
			fileName = UUIDGenerator.getUUID()
					+ file.getOriginalFilename().substring(
							file.getOriginalFilename().lastIndexOf("."));
			outputStream = new FileOutputStream(path + fileName);
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = inputStream.read(buffer, 0, 8192)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}

			return fileName;

		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}

	/**
	 * 判断文件夹路径，不存在则创建
	 * 
	 * @param path
	 */
	public static Boolean isExist(String path) {
		Boolean bResult = false;
		File file = new File(path);
		if (!file.exists()) {
			bResult = file.mkdirs();
		} else {
			bResult = true;
		}
		return bResult;
	}

	/**
	 * 把工作簿以流的形式写入文件
	 * 
	 * @param wb
	 * @param fileName
	 * @return
	 * @throws BusinessException
	 */
	public static File wirteWorkBookToStream(HSSFWorkbook wb, String fileName)
			throws BusinessException {
		String path = Config.parseFilePath("window.file.export",
				"linux.file.export");
		File file = new File(path + fileName);
		OutputStream out = null;
		try {
			out = new FileOutputStream(file);
			wb.write(out);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
		return file;
	}

	/**
	 * 文件导出
	 * 
	 * @param response
	 * @param file
	 * @throws BusinessException
	 */
	public static void exportFile(HttpServletResponse response,
			HSSFWorkbook wb, String fileName) throws BusinessException {
		try {
			File file = wirteWorkBookToStream(wb, fileName);
			InputStream input = FileUtils.openInputStream(file);
			byte[] data = IOUtils.toByteArray(input);
			response.reset();
			/*根据request的locale 得出可能的编码，中文操作系统通常是gb2312*/
			response.setHeader("Content-Disposition", "attachment; filename=\""
					+ new String( fileName.getBytes("gb2312"),"ISO8859-1") + "\"");
			response.addHeader("Content-Length", "" + data.length);
			response.setContentType("application/octet-stream; charset=utf-8");
			IOUtils.write(data, response.getOutputStream());
			IOUtils.closeQuietly(input);
			IOUtils.closeQuietly(response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将二进制数据还原成图标
	 * @param response
	 * @param binaryData
	 * @throws BusinessException
	 */
	public static void writeBinaryDataToImage(byte[] binaryData,HttpServletResponse response) throws BusinessException{	
		try {
			if(binaryData != null && binaryData.length > 0){
				OutputStream out=response.getOutputStream();
				out.write(binaryData, 0, binaryData.length);
				out.flush();
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	/**
	 * 桌面图标流加载
	 * @param url
	 * @param response
	 * @throws IOException
	 */
	public static void loadPngStream(String url,HttpServletResponse response) throws IOException{	
		OutputStream out=response.getOutputStream();
		byte[] buf=new byte[1024];
		InputStream in=new FileInputStream(url);
		int len;
		while((len=in.read(buf))!=-1){	
			out.write(buf, 0, len);
		}
		out.flush();
		in.close();
		out.close();
	}
}
