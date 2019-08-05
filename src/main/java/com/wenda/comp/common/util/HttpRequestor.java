package com.wenda.comp.common.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * 
 * @author Administrator
 * 
 */
public class HttpRequestor {
	/**
	 * get请求
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static String doGet(String url,String charset) throws Exception {
		URL localURL = new URL(url);
		URLConnection connection = localURL.openConnection();
		HttpURLConnection httpURLConnection = (HttpURLConnection) connection;

		httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
		httpURLConnection.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");

		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader reader = null;
		StringBuffer resultBuffer = new StringBuffer();
		String tempLine = null;

		if (httpURLConnection.getResponseCode() >= 300) {
			throw new Exception(
					"HTTP Request is not success, Response code is "
							+ httpURLConnection.getResponseCode());
		}

		try {
			inputStream = httpURLConnection.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream,charset);//获取指定的编码
			reader = new BufferedReader(inputStreamReader);

			while ((tempLine = reader.readLine()) != null) {
				resultBuffer.append(tempLine);
			}

		} finally {

			if (reader != null) {
				reader.close();
			}

			if (inputStreamReader != null) {
				inputStreamReader.close();
			}

			if (inputStream != null) {
				inputStream.close();
			}

		}
		return resultBuffer.toString();
	}
	/**
	 * post请求
	 * @param url
	 * @param parameterData
	 * @param charset
	 * @return
	 * @throws Exception
	 */
	 public static String doPost(String url,String parameterData,String charset) throws Exception {
	        //String parameterData = "username=nickhuang&blog=http://www.cnblogs.com/nick-huang/";
	        
	        URL localURL = new URL(url);
	        URLConnection connection = localURL.openConnection();
	        HttpURLConnection httpURLConnection = (HttpURLConnection)connection;
	        
	        httpURLConnection.setDoOutput(true);
	        httpURLConnection.setRequestMethod("POST");
	        httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
	        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(parameterData.length()));
	        
	        OutputStream outputStream = null;
	        OutputStreamWriter outputStreamWriter = null;
	        InputStream inputStream = null;
	        InputStreamReader inputStreamReader = null;
	        BufferedReader reader = null;
	        StringBuffer resultBuffer = new StringBuffer();
	        String tempLine = null;
	        
	        try {
	            outputStream = httpURLConnection.getOutputStream();
	            outputStreamWriter = new OutputStreamWriter(outputStream);
	            
	            outputStreamWriter.write(parameterData.toString());
	            outputStreamWriter.flush();
	            
	            if (httpURLConnection.getResponseCode() >= 300) {//在调用决策的时候会返回404
	            	if(httpURLConnection.getResponseCode() == 404){
	            		return "true";//在调用决策的时候inputStream会是null
	            	}
	                throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
	            }
	            
	            
	            inputStream = httpURLConnection.getInputStream();
	            inputStreamReader = new InputStreamReader(inputStream,charset);
	            reader = new BufferedReader(inputStreamReader);
	            
	            while ((tempLine = reader.readLine()) != null) {
	                resultBuffer.append(tempLine);
	            }
	            
	        } finally {
	            
	            if (outputStreamWriter != null) {
	                outputStreamWriter.close();
	            }
	            
	            if (outputStream != null) {
	                outputStream.close();
	            }
	            
	            if (reader != null) {
	                reader.close();
	            }
	            
	            if (inputStreamReader != null) {
	                inputStreamReader.close();
	            }
	            
	            if (inputStream != null) {
	                inputStream.close();
	            }
	            
	        }

	        return resultBuffer.toString();
	    }

	 public static byte[] sendGetForImg(String url) {
			InputStream in = null;
			byte[] b = null;
			try {
				URL realUrl = new URL(url);
				URLConnection conn = realUrl.openConnection();
				conn.setDoInput(true);
				conn.setConnectTimeout(3000);
				conn.setReadTimeout(4000);
				conn.setRequestProperty("accept", "*/*");
				conn.setRequestProperty("connection", "Keep-Alive");
				conn.setRequestProperty("user-agent",
						"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");

				conn.connect();
				in = conn.getInputStream();
				b = readBytes(in);
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			} finally {
				try {
					if (in != null) {
						in.close();
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
			return b;
		}
	 
	 /*** 
	     * 将InputStream变成字节数组
	     *  
	     * @param in 
	     * @return 
	     * @throws IOException 
	     */  
	    public static byte[] readBytes(InputStream in) {  
	    	ByteArrayOutputStream out = null;
	    	byte[] b = null;
			try {
				out = new ByteArrayOutputStream();
				 byte[] buffer=new byte[1024];
				 int n=0;
				 while ( (n=in.read(buffer)) !=-1) {
				     out.write(buffer,0,n);
				 }
				 b = out.toByteArray();
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}finally{
				try {
					if(out != null)out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	         return b;
	    }  
	
	public static void main(String[] args) {
		try {
			System.out.println(
					doGet("http://find.nlc.gov.cn/search/doSearch?query=${isbn}&secQuery=&actualQuery=${isbn}&searchType=2&docType=%E5%85%A8%E9%83%A8&isGroup=isGroup&targetFieldLog=%E5%85%A8%E9%83%A8%E5%AD%97%E6%AE%B5&orderBy=RELATIVE",
							"UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
