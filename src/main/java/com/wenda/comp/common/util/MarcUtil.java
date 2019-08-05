package com.wenda.comp.common.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.wenda.comp.constant.Constant;
import com.wenda.comp.exception.BusinessException;
import com.wenda.comp.model.BiblioTemp;
import com.wenda.comp.vo.Marc;
import com.wenda.comp.vo.MarcField;


@Component
public class MarcUtil {
	/**
	 * marc读取并
	 * 
	 * @param fileName
	 * @param charset
	 * @return
	 * @throws BusinessException
	 */
	public static Map<String, Object> dealMarcDataToList(String fileName,
			String charset) throws BusinessException {
		int failSize = 0;
		BufferedReader br = null;
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> lines = new LinkedList<String>();
		List<Map<String, String>> marcDatas = new LinkedList<Map<String, String>>();
		String line = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					fileName), charset));
		} catch (UnsupportedEncodingException e) {
			throw new BusinessException("字符编码错误");
		} catch (FileNotFoundException e) {
			throw new BusinessException("找不到指定文件");
		}
		try {
			while ((line = br.readLine()) != null) {
				Map<String, String> marcContent = parseMarcData(line, '$');
				if (marcContent == null || marcContent.size() == 0)
					failSize++;
				else {
					lines.add(line);
					marcDatas.add(marcContent);
				}
			}
			br.close();
			result.put("lines", lines);
			result.put("marcDatas", marcDatas);
			result.put("failSize", failSize);
		} catch (IOException e) {
			throw new BusinessException("文件解析出错");
		}
		return result;
	}

	public static String[] getEyeAreaInfo(String line) {
		String[] res = new String[2];
		String sub = line.substring(24);
		StringBuilder sb = new StringBuilder();
		int dataStartIndex = 1;
		for (int i = 0; i < sub.length(); i++) {
			char c = sub.charAt(i);
			if (c == 31)
				continue;
			else if (c == 30)
				break;
			else {
				dataStartIndex += 1;
				sb.append(c);
			}
		}
		res[0] = String.valueOf(dataStartIndex + 24);
		res[1] = sb.toString();
		return res;
	}

	public static Map<String, String> parseOneMarcData(String line, char mark) {
		line = line.replace((char) 31, mark);
		StringBuilder sb = new StringBuilder();
		Map<String, String> recordMap = new LinkedHashMap<String, String>();
		String[] res = getEyeAreaInfo(line);
		int dataStartIndex = Integer.parseInt(res[0]);
		String eyeArea = res[1];
		int eyeStartIndex = 0;
		recordMap.put(Constant.MARC_000, line.substring(0, 24));
		while (eyeStartIndex < eyeArea.length()) {
			String key = eyeArea.substring(eyeStartIndex, eyeStartIndex + 3);
			while (dataStartIndex < line.length()) {
				char c = line.charAt(dataStartIndex);
				dataStartIndex++;
				if (c == 30)
					break;
				sb.append(c);
			}
			recordMap.put(key, sb.toString().trim());
			eyeStartIndex += 12;
			sb = new StringBuilder();
		}
		return recordMap;
	}

	/**
	 * 替换000字段键值
	 * 
	 * @param oldMap
	 * @return
	 */
	public static Map<String, String> replaceHeadKey(Map<String, String> oldMap) {
		Map<String, String> marcMap = new LinkedHashMap<String, String>();
		marcMap.put(Constant.MARC_000, oldMap.get(Constant.MARC_HEA));
		oldMap.remove(Constant.MARC_HEA);
		marcMap.putAll(oldMap);
		return marcMap;
	}

	/**
	 * 读取marc数据文件
	 * 
	 * @param fileName
	 * @param charSet
	 * @return
	 * @throws BusinessException
	 * @throws IOException
	 */
	public static List<String> readMarcData(String fileName, String charSet)
			throws BusinessException {
		BufferedReader br = null;
		List<String> list = new LinkedList<String>();
		String line = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					fileName), charSet));
		} catch (UnsupportedEncodingException e) {
			throw new BusinessException("字符编码错误");
		} catch (FileNotFoundException e) {
			throw new BusinessException("找不到指定文件");
		}
		try {
			while ((line = br.readLine()) != null) {
				list.add(line);
			}
			br.close();
		} catch (IOException e) {
			throw new BusinessException("文件解析出错");
		}
		return list;
	}

	/**
	 * 解析文件中的所有marc记录(返回List<Map<String,String>)
	 * 
	 * @param lines
	 * @return
	 */
	public static List<Map<String, String>> parseAllMarcData(List<String> lines) {
		List<Map<String, String>> list = new LinkedList<Map<String, String>>();
		for (String line : lines) {
			list.add(parseMarcData(line, '$'));
			// list.add(parseOneMarcData(line));
		}
		return list;
	}

	/**
	 * 将marc数据以List<List<MarcField>>类型返回
	 * 
	 * @param marcDatas
	 * @return
	 */
	public static List<List<MarcField>> changeMarcDataType(
			List<Map<String, String>> marcDatas) {
		List<List<MarcField>> list = new LinkedList<List<MarcField>>();
		for (Map<String, String> marcData : marcDatas) {
			List<MarcField> marcRecord = new LinkedList<MarcField>();
			for (Map.Entry<String, String> e : marcData.entrySet()) {
				MarcField marcField = new MarcField();
				marcField.setKey(e.getKey());
				marcField.setContent(e.getValue());
				marcRecord.add(marcField);
			}
			list.add(marcRecord);
		}
		return list;
	}

	/**
	 * 解析一条marc记录
	 * 
	 * @param line
	 * @return
	 */
	public static Map<String, String> parseMarcData(String line, char mark) {
		Map<String, String> recordMap = null;
		try {
			byte[] recordByte = line.getBytes();
			byte[] headByte = new byte[24];
			for (int i = 0; i < 24; i++)
				headByte[i] = recordByte[i];
			String head = new String(headByte).trim();
			int eyeNum = getEyeNum(line);
			if (eyeNum > 0) {
				recordMap = new LinkedHashMap<String, String>();
				byte[] marcByte = new byte[recordByte.length - 24 - 12 * eyeNum];
				for (int i = 24 + eyeNum * 12; i < recordByte.length; i++)
					marcByte[i - 24 - eyeNum * 12] = recordByte[i];
				recordMap.put(Constant.MARC_000, head);
				int markIndex = 24;
				int lenIndex = 27;
				int posIndex = 31;
				for (int i = 0; i < eyeNum; i++) {
					byte[] markByte = readPartByte(recordByte, markIndex, 3);
					byte[] lenByte = readPartByte(recordByte, lenIndex, 4);
					byte[] posByte = readPartByte(recordByte, posIndex, 5);
					String marcContent = readMarcData(marcByte, lenByte,
							posByte, mark);
					if (marcContent == null)
						return null;

					if (recordMap.get(new String(markByte)) == null)
						recordMap.put(new String(markByte), marcContent);

					markIndex += 12;
					lenIndex += 12;
					posIndex += 12;
				}
				return recordMap;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	/**
	 * 解析一条marc记录
	 * 
	 * @param line
	 * @return
	 */
	public static Map<String, String> parseZ3950MarcData(String line, char mark) {
		Map<String, String> recordMap = null;
		String marcKey = null;
		try {
			byte[] recordByte = line.getBytes();
			byte[] headByte = new byte[24];
			for (int i = 0; i < 24; i++)
				headByte[i] = recordByte[i];
			String head = new String(headByte).trim();
			int eyeNum = getEyeNum(line);
			if (eyeNum > 0) {
				recordMap = new LinkedHashMap<String, String>();
				byte[] marcByte = new byte[recordByte.length - 24 - 12 * eyeNum];
				for (int i = 24 + eyeNum * 12; i < recordByte.length; i++)
					marcByte[i - 24 - eyeNum * 12] = recordByte[i];
				recordMap.put(Constant.MARC_000, head);
				int markIndex = 24;
				int lenIndex = 27;
				int posIndex = 31;
				for (int i = 0; i < eyeNum; i++) {
					byte[] markByte = readPartByte(recordByte, markIndex, 3);
					marcKey = new String(markByte);
					if (!marcKey.equals(Constant.MARC_005)
							&& !marcKey.equals(Constant.MARC_049)
							&& !marcKey.equals(Constant.MARC_090)) {
						byte[] lenByte = readPartByte(recordByte, lenIndex, 4);
						byte[] posByte = readPartByte(recordByte, posIndex, 5);
						String marcContent = readMarcData(marcByte, lenByte,
								posByte, mark);
						if (marcContent == null)
							return null;

						if (recordMap.get(new String(markByte)) == null)
							recordMap.put(new String(markByte), marcContent);
					}
					markIndex += 12;
					lenIndex += 12;
					posIndex += 12;
				}
				return recordMap;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	/**
	 * 从目次区获取marc字段个数
	 * 
	 * @param line
	 * @return
	 */
	private static int getEyeNum(String line) {
		int eyeNum = 0;
		String sub = line.substring(24);
		for (int i = 0; i < sub.length(); i++) {
			char c = sub.charAt(i);
			if (c == 31)
				continue;
			else if (c == 30)
				break;
			else
				eyeNum += 1;
		}
		return eyeNum / 12;
	}

	/**
	 * 读取marc记录内容
	 * 
	 * @param marcByte
	 * @param lenByte
	 * @param posByte
	 * @return
	 */
	private static String readMarcData(byte[] marcByte, byte[] lenByte,
			byte[] posByte, char mark) {
		String len = new String(lenByte);
		String pos = new String(posByte);
		int lenInt = 0;
		int posInt = 0;
		try {
			lenInt = dealNumber(len);
			posInt = dealNumber(pos);
		} catch (Exception e) {
			return null;
		}
		byte[] marcData = new byte[lenInt];
		for (int i = posInt; i < posInt + lenInt; i++) {
			try {
				marcData[i - posInt] = marcByte[i];
			} catch (Exception e) {
				return null;
			}
		}
		String marContent = new String(marcData);
		for (int i = 0; i < marContent.length(); i++) {
			char c = marContent.charAt(i);
			if (c == 31)
				marContent = marContent.replace(c, mark).trim();
		}
		return marContent;
	}

	/**
	 * 处理成标准整数
	 * 
	 * @param str
	 * @return
	 */
	private static int dealNumber(String str) {
		StringBuilder sb = new StringBuilder();
		boolean firstNoZero = false;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c != '0')
				firstNoZero = true;

			if (firstNoZero)
				sb.append(c);
		}
		if (sb.toString().equals(""))
			return 0;
		return Integer.parseInt(sb.toString());
	}

	/**
	 * 读取目次区单个字段信息
	 * 
	 * @param recordByte
	 * @param startIndex
	 * @param n
	 * @return
	 */
	private static byte[] readPartByte(byte[] recordByte, int startIndex, int n) {
		byte[] dataByte = new byte[n];
		for (int i = 0; i < n; i++) {
			dataByte[i] = recordByte[startIndex + i];
		}
		return dataByte;
	}

	/**
	 * 分割MARC内容中的多个子字段内容
	 * 
	 * @param value
	 * @param mark
	 * @return
	 */
	public static String[] splitMarcValue(String value, String mark) {
		String[] values = null;
		if (StringUtils.isNotBlank(value) && value.indexOf(mark) >= 0) {
			values = value.split(mark);
		}
		return values;
	}

	/**
	 * 组合
	 * 
	 * @param line
	 * @return
	 */
	public static List<String> groupCase(String line) {
		int m = 1;
		List<String> list = new LinkedList<String>();
		while (m < line.length()) {
			list.addAll(groupCase(m, line));
			m++;
		}
		return list;
	}

	/**
	 * 组合
	 * 
	 * @param m
	 * @param line
	 * @return
	 */
	private static List<String> groupCase(int m, String line) {
		List<Integer> indexList = new LinkedList<Integer>();
		List<String> resultList = new LinkedList<String>();
		int start = 0, count = 0, end = 0;
		if (StringUtils.isNotBlank(line)) {
			while (start <= line.length() - m) {
				for (; end < line.length(); end++) {
					indexList.add(end);
					count++;
					if (count == m) {
						String str = "";
						for (int index : indexList) {
							str = replaceNumberToPercent(line, str, index);
						}
						resultList.add(str);
						break;
					}
				}
				if (count == 1) {
					end = indexList.get(0);
					indexList.clear();
					count = 0;
					start = ++end;
				} else {
					end = indexList.get(count - 1);
					indexList.remove(count - 1);
					count--;
					end++;
				}
			}
		}
		return resultList;
	}

	private static String replaceNumberToPercent(String line, String str,
			int index) {
		if (StringUtils.isNotBlank(str)) {
			String newString = "";
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c == '%')
					newString += c;
				else if (str.indexOf('%') > i)
					newString += c;
			}
			str = newString;
		}
		for (int i = str.length(); i < line.length(); i++) {
			if (i == index)
				str += "%";
			else
				str += line.charAt(i);
		}
		return str;
	}

	/**
	 * 自定义书目MARC解析
	 * 
	 * @param marcCopy
	 * @return
	 */
	public static Marc parseSelfMarcData(String marcCopy) {
		Marc marc = null;
		if (StringUtils.isNotBlank(marcCopy)) {
			marc = new Marc();
			List<MarcField> list = new LinkedList<MarcField>();
			String[] marcAry = marcCopy.split("#");
			for (String marcObj : marcAry) {
				MarcField marcField = new MarcField();
				String[] keyValue = marcObj.split("@");
				marcField.setKey(keyValue[0]);
				marcField.setSign(keyValue[1]);
				marcField.setContent(keyValue[2]);
				list.add(marcField);
			}
			marc.setMarcFields(list);
		}
		return marc;
	}

	/**
	 * 目次区长度固定长度
	 * 
	 * @param str
	 * @param length
	 * @return
	 */
	public static String fixedMarcEyeLength(String str, int length,
			int startIndex) {
		String lenStr = null;
		if (startIndex == -1) {
			lenStr = str.length() + "";
		} else {
			lenStr = startIndex + "";
		}
		while (lenStr.length() < length) {
			lenStr = "0" + lenStr;
		}
		return lenStr;
	}

	/**
	 * 生成标准MRAC数据
	 * 
	 * @param marcFields
	 * @return
	 */
	public static String contactMarcData(List<MarcField> marcFields) {
		int startIndex = 0;
		char partMark = 31;
		char colTail = 30;
		StringBuilder eye = new StringBuilder();
		StringBuilder data = new StringBuilder();
		StringBuilder marcColumn = new StringBuilder();
		for (MarcField mf : marcFields) {
			String marcMark = mf.getMarcMark();
			String key = mf.getKey();
			String sign = mf.getSign();
			String value = mf.getContent().trim();
			if (key.equals(Constant.MARC_000)) {
				value = value + " ";
				eye.append(value);
				continue;
			}
			if (StringUtils.isNotBlank(marcMark)) {
				continue;
			}
			if (StringUtils.isNotBlank(sign)) {
				data.append(sign);
				marcColumn.append(sign);
			}
			data.append(value);
			data.append(colTail);
			marcColumn.append(value);
			marcColumn.append(colTail);
			eye.append(key);
			eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
			eye.append(fixedMarcEyeLength(marcColumn.toString(), 5, startIndex));
			startIndex += marcColumn.length();
			marcColumn.delete(0, marcColumn.length());
		}
		return eye.append(colTail).append(data).toString()
				.replaceAll("▼", partMark + "");
	}

	/**
	 * 中文图书简单编目MARC生成(新增的时候)
	 * 
	 * @param biblioTemp
	 * @param schoolCode
	 * @return
	 */
	public static String easyCatalogueChineseBook(BiblioTemp biblioTemp,
			String schoolCode) {
		int startIndex = 0;
		char partMark = 31;
		char colTail = 30;
		StringBuilder eye = new StringBuilder();
		StringBuilder data = new StringBuilder();
		StringBuilder marcColumn = new StringBuilder();
		eye.append("00960nam0 22002651  450 ");

		data.append(InternetTime.parseDateStr(new Date(), "yyyyMMddhhmmssS"));
		data.append(colTail);

		marcColumn.append(InternetTime.parseDateStr(new Date(),
				"yyyyMMddhhmmssS"));
		marcColumn.append(colTail);

		eye.append(Constant.MARC_005);
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 5, startIndex));
		startIndex += marcColumn.length();
		marcColumn.delete(0, marcColumn.length());

		data.append("▼a");
		data.append(biblioTemp.getIsbn());

		marcColumn.append("▼a");
		marcColumn.append(biblioTemp.getIsbn());

		data.append("▼dCNY");
		data.append(biblioTemp.getPrice());

		marcColumn.append("▼dCNY");
		marcColumn.append(biblioTemp.getPrice());

		if (StringUtils.isNotBlank(biblioTemp.getTotalPrice())) {
			data.append(biblioTemp.getTotalPrice());
			marcColumn.append(biblioTemp.getTotalPrice());
		}
		data.append(colTail);
		marcColumn.append(colTail);

		eye.append(Constant.MARC_010);
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 5, startIndex));
		startIndex += marcColumn.length();
		marcColumn.delete(0, marcColumn.length());

		if (StringUtils.isNotBlank(biblioTemp.getUnionNo())) {
			data.append("▼a");
			data.append(biblioTemp.getUnionNo());
			data.append(colTail);

			marcColumn.append("▼a");
			marcColumn.append(biblioTemp.getUnionNo());
			marcColumn.append(colTail);

			eye.append(Constant.MARC_091);
			eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
			eye.append(fixedMarcEyeLength(marcColumn.toString(), 5, startIndex));
			startIndex += marcColumn.length();
			marcColumn.delete(0, marcColumn.length());
		}

		if (StringUtils.isNotBlank(biblioTemp.getLanguage())) {
			data.append(0);
			marcColumn.append(0);

			data.append("▼a");
			data.append(biblioTemp.getLanguage());
			data.append(colTail);

			marcColumn.append("▼a");
			marcColumn.append(biblioTemp.getLanguage());
			marcColumn.append(colTail);

			eye.append(Constant.MARC_101);
			eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
			eye.append(fixedMarcEyeLength(marcColumn.toString(), 5, startIndex));
			startIndex += marcColumn.length();
			marcColumn.delete(0, marcColumn.length());
		}

		data.append("▼aCN▼b");
		data.append(colTail);
		marcColumn.append("▼aCN▼b");
		marcColumn.append(colTail);

		eye.append(Constant.MARC_102);
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 5, startIndex));
		startIndex += marcColumn.length();
		marcColumn.delete(0, marcColumn.length());

		data.append("▼ay z 000yy");
		data.append(colTail);
		marcColumn.append("▼ay z 000yy");
		marcColumn.append(colTail);

		eye.append(Constant.MARC_105);
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 5, startIndex));
		startIndex += marcColumn.length();
		marcColumn.delete(0, marcColumn.length());

		data.append("▼ar");
		data.append(colTail);
		marcColumn.append("▼ar");
		marcColumn.append(colTail);

		eye.append(Constant.MARC_106);
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 5, startIndex));
		startIndex += marcColumn.length();
		marcColumn.delete(0, marcColumn.length());

		data.append(1);
		marcColumn.append(1);
		data.append("▼a");
		data.append(biblioTemp.getTitle());

		marcColumn.append("▼a");
		marcColumn.append(biblioTemp.getTitle());

		data.append("▼f");
		data.append(biblioTemp.getAuthor());
		data.append(colTail);

		marcColumn.append("▼f");
		marcColumn.append(biblioTemp.getAuthor());
		marcColumn.append(colTail);

		eye.append(Constant.MARC_200);
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 5, startIndex));
		startIndex += marcColumn.length();
		marcColumn.delete(0, marcColumn.length());

		data.append("▼a");
		data.append(biblioTemp.getAddress());
		data.append("▼c");
		data.append(biblioTemp.getPublisher());
		data.append("▼d");
		data.append(biblioTemp.getPublishDate());
		data.append(colTail);

		marcColumn.append("▼a");
		marcColumn.append(biblioTemp.getAddress());
		marcColumn.append("▼c");
		marcColumn.append(biblioTemp.getPublisher());
		marcColumn.append("▼d");
		marcColumn.append(biblioTemp.getPublishDate());
		marcColumn.append(colTail);

		eye.append(Constant.MARC_210);
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 5, startIndex));
		startIndex += marcColumn.length();
		marcColumn.delete(0, marcColumn.length());

		data.append("▼a");
		data.append(biblioTemp.getPage());
		data.append("▼d");
		data.append(biblioTemp.getBookSize());

		marcColumn.append("▼a");
		marcColumn.append(biblioTemp.getPage());
		marcColumn.append("▼d");
		marcColumn.append(biblioTemp.getBookSize());

		if (StringUtils.isNotBlank(biblioTemp.getAttachment())) {
			data.append("▼e");
			data.append(biblioTemp.getAttachment());
			marcColumn.append("▼e");
			marcColumn.append(biblioTemp.getAttachment());
		}
		data.append(colTail);
		marcColumn.append(colTail);

		eye.append(Constant.MARC_215);
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 5, startIndex));
		startIndex += marcColumn.length();
		marcColumn.delete(0, marcColumn.length());

		if (StringUtils.isNotBlank(biblioTemp.getSummary())) {
			data.append("▼a");
			data.append(biblioTemp.getSummary());
			data.append(colTail);

			marcColumn.append("▼a");
			marcColumn.append(biblioTemp.getSummary());
			marcColumn.append(colTail);

			eye.append(Constant.MARC_330);
			eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
			eye.append(fixedMarcEyeLength(marcColumn.toString(), 5, startIndex));
			startIndex += marcColumn.length();
			marcColumn.delete(0, marcColumn.length());
		}

		if (StringUtils.isNotBlank(biblioTemp.getSubject())) {
			String[] subs = null;
			if (biblioTemp.getSubject().indexOf("，") >= 0
					|| biblioTemp.getSubject().indexOf(",") >= 0) {
				if (biblioTemp.getSubject().indexOf("，") >= 0)
					subs = biblioTemp.getSubject().split("，");
				else
					subs = biblioTemp.getSubject().split(",");
				if (subs != null) {
					for (int i = 0; i < subs.length; i++) {
						if (i == 0)
							data.append("▼a");
						else if (i == 1)
							data.append("▼x");
						else if (i == 2)
							data.append("▼y");
						else if (i == 3)
							data.append("▼z");
						else if (i == 4)
							data.append("▼j");
						data.append(subs[i]);

						if (i == 0)
							marcColumn.append("▼a");
						else if (i == 1)
							marcColumn.append("▼x");
						else if (i == 2)
							marcColumn.append("▼y");
						else if (i == 3)
							marcColumn.append("▼z");
						else if (i == 4)
							marcColumn.append("▼j");
						marcColumn.append(subs[i]);
					}
				}
			} else {
				data.append("▼a");
				data.append(biblioTemp.getSubject());

				marcColumn.append("▼a");
				marcColumn.append(biblioTemp.getSubject());
			}
			data.append(colTail);
			marcColumn.append(colTail);
			eye.append(Constant.MARC_606);
			eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
			eye.append(fixedMarcEyeLength(marcColumn.toString(), 5, startIndex));
			startIndex += marcColumn.length();
			marcColumn.delete(0, marcColumn.length());
		}

		data.append("▼a");
		data.append(biblioTemp.getClassNo());
		data.append("▼v5");
		data.append(colTail);

		marcColumn.append("▼a");
		marcColumn.append(biblioTemp.getClassNo());
		marcColumn.append("▼v5");
		marcColumn.append(colTail);

		eye.append(Constant.MARC_690);
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 5, startIndex));
		startIndex += marcColumn.length();
		marcColumn.delete(0, marcColumn.length());

		data.append("▼aCN");
		data.append("▼b");
		data.append(schoolCode);
		data.append("▼c");
		data.append(InternetTime.parseDateStr(new Date(), "yyyyMMdd"));
		data.append(colTail);

		marcColumn.append("▼aCN");
		marcColumn.append("▼b");
		marcColumn.append(schoolCode);
		marcColumn.append("▼c");
		marcColumn.append(InternetTime.parseDateStr(new Date(), "yyyyMMdd"));
		marcColumn.append(colTail);

		eye.append(Constant.MARC_801);
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 5, startIndex));
		startIndex += marcColumn.length();
		marcColumn.delete(0, marcColumn.length());
		return eye.append(colTail).append(data).toString()
				.replaceAll("▼", partMark + "");
	}

	/**
	 * 中文期刊简单编目MARC生成(新增的时候)
	 * 
	 * @param biblioTemp
	 * @param schoolCode
	 * @return
	 */
	public static String easyCatalogueChineseSeries(BiblioTemp biblioTemp,
			String schoolCode) {
		int startIndex = 0;
		char partMark = 31;
		char colTail = 30;
		StringBuilder eye = new StringBuilder();
		StringBuilder data = new StringBuilder();
		StringBuilder marcColumn = new StringBuilder();

		eye.append("00960nam0 22002651  450 ");

		data.append(InternetTime.parseDateStr(new Date(), "yyyyMMddhhmmssS"));
		data.append(colTail);

		marcColumn.append(InternetTime.parseDateStr(new Date(),
				"yyyyMMddhhmmssS"));
		marcColumn.append(colTail);

		eye.append(Constant.MARC_005);
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 5, startIndex));
		startIndex += marcColumn.length();
		marcColumn.delete(0, marcColumn.length());

		data.append("▼a");
		data.append(biblioTemp.getIsbn());

		marcColumn.append("▼a");
		marcColumn.append(biblioTemp.getIsbn());

		data.append("▼dCNY");
		data.append(biblioTemp.getPrice());

		marcColumn.append("▼dCNY");
		marcColumn.append(biblioTemp.getPrice());

		if (StringUtils.isNotBlank(biblioTemp.getTotalPrice())) {
			data.append(biblioTemp.getTotalPrice());
			marcColumn.append(biblioTemp.getTotalPrice());
		}
		data.append(colTail);
		marcColumn.append(colTail);

		eye.append(Constant.MARC_011);
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 5, startIndex));
		startIndex += marcColumn.length();
		marcColumn.delete(0, marcColumn.length());

		if (StringUtils.isNotBlank(biblioTemp.getUnionNo())) {
			data.append("▼a");
			data.append(biblioTemp.getUnionNo());
			data.append(colTail);

			marcColumn.append("▼a");
			marcColumn.append(biblioTemp.getUnionNo());
			marcColumn.append(colTail);

			eye.append(Constant.MARC_091);
			eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
			eye.append(fixedMarcEyeLength(marcColumn.toString(), 5, startIndex));
			startIndex += marcColumn.length();
			marcColumn.delete(0, marcColumn.length());
		}

		data.append("▼a");
		data.append(biblioTemp.getOrderNo());
		data.append(colTail);

		marcColumn.append("▼a");
		marcColumn.append(biblioTemp.getOrderNo());
		marcColumn.append(colTail);

		eye.append(Constant.MARC_092);
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 5, startIndex));
		startIndex += marcColumn.length();
		marcColumn.delete(0, marcColumn.length());

		if (StringUtils.isNotBlank(biblioTemp.getLanguage())) {
			data.append(0);
			marcColumn.append(0);

			data.append("▼a");
			data.append(biblioTemp.getLanguage());
			data.append(colTail);

			marcColumn.append("▼a");
			marcColumn.append(biblioTemp.getLanguage());
			marcColumn.append(colTail);

			eye.append(Constant.MARC_101);
			eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
			eye.append(fixedMarcEyeLength(marcColumn.toString(), 5, startIndex));
			startIndex += marcColumn.length();
			marcColumn.delete(0, marcColumn.length());
		}

		data.append("▼aCN▼b");
		data.append(colTail);
		marcColumn.append("▼aCN▼b");
		marcColumn.append(colTail);

		eye.append(Constant.MARC_102);
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 5, startIndex));
		startIndex += marcColumn.length();
		marcColumn.delete(0, marcColumn.length());

		data.append("▼ar");
		data.append(colTail);
		marcColumn.append("▼ar");
		marcColumn.append(colTail);

		eye.append(Constant.MARC_106);
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 5, startIndex));
		startIndex += marcColumn.length();
		marcColumn.delete(0, marcColumn.length());

		data.append(1);
		marcColumn.append(1);
		data.append("▼a");
		data.append(biblioTemp.getTitle());

		marcColumn.append("▼a");
		marcColumn.append(biblioTemp.getTitle());

		data.append("▼f");
		data.append(biblioTemp.getAuthor());
		data.append(colTail);

		marcColumn.append("▼f");
		marcColumn.append(biblioTemp.getAuthor());
		marcColumn.append(colTail);

		eye.append(Constant.MARC_200);
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 5, startIndex));
		startIndex += marcColumn.length();
		marcColumn.delete(0, marcColumn.length());

		data.append("▼a");
		data.append(biblioTemp.getAddress());
		data.append("▼c");
		data.append(biblioTemp.getPublisher());
		data.append("▼d");
		data.append(biblioTemp.getPublishDate());
		data.append(colTail);

		marcColumn.append("▼a");
		marcColumn.append(biblioTemp.getAddress());
		marcColumn.append("▼c");
		marcColumn.append(biblioTemp.getPublisher());
		marcColumn.append("▼d");
		marcColumn.append(biblioTemp.getPublishDate());
		marcColumn.append(colTail);

		eye.append(Constant.MARC_210);
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 5, startIndex));
		startIndex += marcColumn.length();
		marcColumn.delete(0, marcColumn.length());

		data.append("▼a");
		data.append(biblioTemp.getPage());
		data.append("▼d");
		data.append(biblioTemp.getBookSize());

		marcColumn.append("▼a");
		marcColumn.append(biblioTemp.getPage());
		marcColumn.append("▼d");
		marcColumn.append(biblioTemp.getBookSize());

		if (StringUtils.isNotBlank(biblioTemp.getAttachment())) {
			data.append("▼e");
			data.append(biblioTemp.getAttachment());
			marcColumn.append("▼e");
			marcColumn.append(biblioTemp.getAttachment());
		}
		data.append(colTail);
		marcColumn.append(colTail);

		eye.append(Constant.MARC_215);
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 5, startIndex));
		startIndex += marcColumn.length();
		marcColumn.delete(0, marcColumn.length());

		data.append("▼a");
		data.append(biblioTemp.getFrequency());
		data.append(colTail);

		marcColumn.append("▼a");
		marcColumn.append(biblioTemp.getFrequency());
		marcColumn.append(colTail);

		eye.append(Constant.MARC_326);
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 5, startIndex));
		startIndex += marcColumn.length();
		marcColumn.delete(0, marcColumn.length());

		data.append("▼a");
		data.append(biblioTemp.getClassNo());
		data.append("▼v5");
		data.append(colTail);

		marcColumn.append("▼a");
		marcColumn.append(biblioTemp.getClassNo());
		marcColumn.append("▼v5");
		marcColumn.append(colTail);

		eye.append(Constant.MARC_690);
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 5, startIndex));
		startIndex += marcColumn.length();
		marcColumn.delete(0, marcColumn.length());

		data.append("▼aCN");
		data.append("▼b");
		data.append(schoolCode);
		data.append("▼c");
		data.append(InternetTime.parseDateStr(new Date(), "yyyyMMdd"));
		data.append(colTail);

		marcColumn.append("▼aCN");
		marcColumn.append("▼b");
		marcColumn.append(schoolCode);
		marcColumn.append("▼c");
		marcColumn.append(InternetTime.parseDateStr(new Date(), "yyyyMMdd"));
		marcColumn.append(colTail);

		eye.append(Constant.MARC_801);
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
		eye.append(fixedMarcEyeLength(marcColumn.toString(), 5, startIndex));
		startIndex += marcColumn.length();
		marcColumn.delete(0, marcColumn.length());
		return eye.append(colTail).append(data).toString()
				.replaceAll("▼", partMark + "");
	}

	/**
	 * 简单编目同步MARC(MARC存在情况下)
	 * 
	 * @param biblioTemp
	 * @param marcContent
	 * @param mark
	 */
	public static BiblioTemp reSetMarcColumn(BiblioTemp biblioTemp, char mark) {
		int startIndex = 0;
		char partMark = 31;
		char colTail = 30;
		StringBuilder eye = new StringBuilder();
		StringBuilder data = new StringBuilder();
		StringBuilder marcColumn = new StringBuilder();
		Map<String, String> marcMap = parseOneMarcData(
				biblioTemp.getMarcContent(), mark);
		for (Map.Entry<String, String> e : marcMap.entrySet()) {
			String marcKey = e.getKey();
			String marcValue = e.getValue();
			String[] values = marcValue.split(mark + "");
			if (marcKey.equals(Constant.MARC_000)) {
				eye.append(marcValue);
			} else if (marcKey.equals(Constant.MARC_005)) {
				data.append(InternetTime.parseDateStr(new Date(),
						"yyyyMMddhhmmssS"));
				data.append(colTail);
				marcColumn.append(colTail);
				eye.append(Constant.MARC_005);
				eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
				eye.append(fixedMarcEyeLength(marcColumn.toString(), 5,
						startIndex));
				startIndex += marcColumn.length();
				marcColumn.delete(0, marcColumn.length());
			} else if (marcKey.equals(Constant.MARC_010)
					|| marcKey.equals(Constant.MARC_011)) {
				for (String value : values) {
					value = value.trim();
					if (StringUtils.isNotBlank(value)
							&& value.indexOf("a") == 0) {
						data.append(mark + "a");
						data.append(biblioTemp.getIsbn());

						marcColumn.append(mark + "a");
						marcColumn.append(biblioTemp.getIsbn());
					} else if (StringUtils.isNotBlank(value)
							&& value.indexOf("b") == 0) {
						data.append(mark + value);
						marcColumn.append(mark + value);
					} else if (StringUtils.isNotBlank(value)
							&& value.indexOf("d") == 0) {
						data.append(mark + "d");
						data.append(biblioTemp.getPrice());

						marcColumn.append(mark + "d");
						marcColumn.append(biblioTemp.getIsbn());
					}
				}
				data.append(colTail);
				marcColumn.append(colTail);
				eye.append(Constant.MARC_010);
				eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
				eye.append(fixedMarcEyeLength(marcColumn.toString(), 5,
						startIndex));
				startIndex += marcColumn.length();
				marcColumn.delete(0, marcColumn.length());
			} else if (marcKey.equals(Constant.MARC_091)
					&& StringUtils.isNotBlank(biblioTemp.getUnionNo())) {
				for (String value : values) {
					value = value.trim();
					if (StringUtils.isNotBlank(value)
							&& value.indexOf("a") == 0) {
						data.append(mark + "a");
						data.append(biblioTemp.getUnionNo());

						marcColumn.append(mark + "a");
						marcColumn.append(biblioTemp.getUnionNo());
					}
				}
				data.append(colTail);
				marcColumn.append(colTail);
				eye.append(Constant.MARC_091);
				eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
				eye.append(fixedMarcEyeLength(marcColumn.toString(), 5,
						startIndex));
				startIndex += marcColumn.length();
				marcColumn.delete(0, marcColumn.length());
			} else if (marcKey.equals(Constant.MARC_092)) {
				for (String value : values) {
					value = value.trim();
					if (StringUtils.isNotBlank(value)
							&& value.indexOf("a") == 0) {
						data.append(mark + "a");
						data.append(biblioTemp.getOrderNo());

						marcColumn.append(mark + "a");
						marcColumn.append(biblioTemp.getOrderNo());
					}
				}
				data.append(colTail);
				marcColumn.append(colTail);
				eye.append(Constant.MARC_092);
				eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
				eye.append(fixedMarcEyeLength(marcColumn.toString(), 5,
						startIndex));
				startIndex += marcColumn.length();
				marcColumn.delete(0, marcColumn.length());
			} else if (marcKey.equals(Constant.MARC_101)
					&& StringUtils.isNotBlank(biblioTemp.getLanguage())) {
				if (biblioTemp.getLanguage().indexOf(",") >= 0
						|| biblioTemp.getLanguage().indexOf("，") >= 0) {
					String[] newValue = null;
					if (biblioTemp.getLanguage().indexOf(",") >= 0) {
						newValue = biblioTemp.getLanguage().split(",");
					} else {
						newValue = biblioTemp.getLanguage().split("，");
					}
					for (int i = 0; i < newValue.length; i++) {
						if (i == 0) {
							data.append(0);
							data.append(mark + "a");
							data.append(newValue[0]);

							marcColumn.append(0);
							marcColumn.append(mark + "a");
							marcColumn.append(newValue[0]);
						} else if (i == 1) {
							data.append(mark + "b");
							data.append(newValue[1]);

							marcColumn.append(mark + "b");
							marcColumn.append(newValue[1]);
						} else if (i == 2) {
							data.append(mark + "c");
							data.append(newValue[2]);

							marcColumn.append(mark + "c");
							marcColumn.append(newValue[2]);
						}
					}
				} else {
					data.append(0);
					data.append(mark + "a");
					data.append(biblioTemp.getLanguage());

					marcColumn.append(0);
					marcColumn.append(mark + "a");
					marcColumn.append(biblioTemp.getLanguage());
				}
				data.append(colTail);
				marcColumn.append(colTail);
				eye.append(Constant.MARC_101);
				eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
				eye.append(fixedMarcEyeLength(marcColumn.toString(), 5,
						startIndex));
				startIndex += marcColumn.length();
				marcColumn.delete(0, marcColumn.length());
			} else if (marcKey.equals(Constant.MARC_200)) {
				String[] newValue = null;
				for (String value : values) {
					value = value.trim();
					if (StringUtils.isNotBlank(value)
							&& value.indexOf("a") == 0) {
						data.append(1);
						data.append(mark + "a");
						data.append(biblioTemp.getTitle());

						marcColumn.append(1);
						marcColumn.append(mark + "a");
						marcColumn.append(biblioTemp.getTitle());
					} else if (StringUtils.isNotBlank(value)
							&& value.indexOf("9") == 0) {
						data.append(mark + value);
						marcColumn.append(mark + value);
					} else if (StringUtils.isNotBlank(value)
							&& value.indexOf("b") == 0) {
						data.append(mark + value);
						marcColumn.append(mark + value);
					} else if (StringUtils.isNotBlank(value)
							&& value.indexOf("e") == 0) {
						data.append(mark + value);
						marcColumn.append(mark + value);
					} else if (StringUtils.isNotBlank(value)
							&& value.indexOf("f") == 0) {
						if (biblioTemp.getAuthor().indexOf(",") >= 0
								|| biblioTemp.getAuthor().indexOf("，") >= 0) {
							if (biblioTemp.getAuthor().indexOf(",") >= 0) {
								newValue = biblioTemp.getAuthor().split(",");
							} else {
								newValue = biblioTemp.getAuthor().split("，");
							}
						}
						data.append(mark + "f");
						marcColumn.append(mark + "f");
						if (newValue == null) {
							data.append(biblioTemp.getAuthor());
							marcColumn.append(biblioTemp.getAuthor());
						} else {
							data.append(newValue[0]);
							marcColumn.append(newValue[0]);
						}
					} else if (StringUtils.isNotBlank(value)
							&& value.indexOf("g") == 0) {
						data.append(mark + value);
						marcColumn.append(mark + value);
					} else if (StringUtils.isNotBlank(value)
							&& value.indexOf("h") == 0) {
						data.append(mark + value);
						marcColumn.append(mark + value);
					}
				}
				data.append(colTail);
				marcColumn.append(colTail);
				eye.append(Constant.MARC_200);
				eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
				eye.append(fixedMarcEyeLength(marcColumn.toString(), 5,
						startIndex));
				startIndex += marcColumn.length();
				marcColumn.delete(0, marcColumn.length());
			}

			else if (marcKey.equals(Constant.MARC_205)) {
                    if(biblioTemp.getEdition().indexOf(",")>=0 || biblioTemp.getEdition().indexOf("，")>=0){	
                    	String[] newValue=null;
                    	if(biblioTemp.getEdition().indexOf(",")>=0){	
                    		newValue=biblioTemp.getEdition().split(",");
                    	}else{	
                    		newValue=biblioTemp.getEdition().split("，");
                    	}
                    	for (int i = 0; i < newValue.length; i++) {
    						if (i == 0) {
    							data.append(mark + "a");
    							data.append(newValue[0]);

    							marcColumn.append(mark + "a");
    							marcColumn.append(newValue[0]);
    						} else if (i == 1) {
    							data.append(mark + "b");
    							data.append(newValue[1]);

    							marcColumn.append(mark + "b");
    							marcColumn.append(newValue[1]);
    						}
    					}
                    }else{	
    					data.append(mark + "a");
    					data.append(biblioTemp.getEdition());

    					marcColumn.append(mark + "a");
    					marcColumn.append(biblioTemp.getEdition());
                    }
				data.append(colTail);
				marcColumn.append(colTail);
				eye.append(Constant.MARC_205);
				eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
				eye.append(fixedMarcEyeLength(marcColumn.toString(), 5,
						startIndex));
				startIndex += marcColumn.length();
				marcColumn.delete(0, marcColumn.length());
			}

			else if (marcKey.equals(Constant.MARC_210)) {
				for (String value : values) {
					value = value.trim();
					if (StringUtils.isNotBlank(value)
							&& value.indexOf("a") == 0) {
						data.append(mark + "a");
						data.append(biblioTemp.getAddress());

						marcColumn.append(mark + "a");
						marcColumn.append(biblioTemp.getAddress());
					} else if (StringUtils.isNotBlank(value)
							&& value.indexOf("c") == 0) {
						data.append(mark + "c");
						data.append(biblioTemp.getPublisher());

						marcColumn.append(mark + "c");
						marcColumn.append(biblioTemp.getPublisher());
					} else if (StringUtils.isNotBlank(value)
							&& value.indexOf("d") == 0) {
						data.append(mark + "d");
						data.append(biblioTemp.getPublishDate());

						marcColumn.append(mark + "d");
						marcColumn.append(biblioTemp.getPublishDate());
					} else if (StringUtils.isNotBlank(value)
							&& value.indexOf("9") == 0) {
						data.append(mark + value);
						marcColumn.append(mark + value);
					}
				}
				data.append(colTail);
				marcColumn.append(colTail);
				eye.append(Constant.MARC_210);
				eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
				eye.append(fixedMarcEyeLength(marcColumn.toString(), 5,
						startIndex));
				startIndex += marcColumn.length();
				marcColumn.delete(0, marcColumn.length());
			} else if (marcKey.equals(Constant.MARC_215)) {
				for (String value : values) {
					value = value.trim();
					if (StringUtils.isNotBlank(value)
							&& value.indexOf("a") == 0) {
						data.append(mark + "a");
						data.append(biblioTemp.getPage());

						marcColumn.append(mark + "a");
						marcColumn.append(biblioTemp.getPage());
					} else if (StringUtils.isNotBlank(value)
							&& value.indexOf("c") == 0) {
						data.append(mark + value);
						marcColumn.append(mark + value);
					} else if (StringUtils.isNotBlank(value)
							&& value.indexOf("d") == 0) {
						data.append(mark + "d");
						data.append(biblioTemp.getBookSize());

						marcColumn.append(mark + "d");
						marcColumn.append(biblioTemp.getBookSize());
					} else if (StringUtils.isNotBlank(value)
							&& value.indexOf("e") == 0) {
						data.append(mark + "e");
						data.append(biblioTemp.getAttachment());

						marcColumn.append(mark + "e");
						marcColumn.append(biblioTemp.getAttachment());
					}
				}
				data.append(colTail);
				marcColumn.append(colTail);
				eye.append(Constant.MARC_215);
				eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
				eye.append(fixedMarcEyeLength(marcColumn.toString(), 5,
						startIndex));
				startIndex += marcColumn.length();
				marcColumn.delete(0, marcColumn.length());
			} else if (marcKey.equals(Constant.MARC_330)
					&& StringUtils.isNotBlank(biblioTemp.getSummary())) {
				for (String value : values) {
					value = value.trim();
					if (StringUtils.isNotBlank(value)
							&& value.indexOf("a") == 0) {
						data.append(mark + "a");
						data.append(biblioTemp.getSummary());

						marcColumn.append(mark + "a");
						marcColumn.append(biblioTemp.getSummary());
					}
				}
				data.append(colTail);
				marcColumn.append(colTail);
				eye.append(Constant.MARC_330);
				eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
				eye.append(fixedMarcEyeLength(marcColumn.toString(), 5,
						startIndex));
				startIndex += marcColumn.length();
				marcColumn.delete(0, marcColumn.length());
			} else if (marcKey.equals(Constant.MARC_606)
					&& StringUtils.isNotBlank(biblioTemp.getSubject())) {
				if (biblioTemp.getSubject().indexOf("，") >= 0
						|| biblioTemp.getSubject().indexOf(",") >= 0) {
					String[] newValue = null;
					if (biblioTemp.getSubject().indexOf("，") >= 0)
						newValue = biblioTemp.getSubject().split("，");
					else
						newValue = biblioTemp.getSubject().split(",");
					for (int i = 0; i < newValue.length; i++) {
						if (i == 0) {
							data.append(mark + "a");
							data.append(newValue[0]);

							marcColumn.append(mark + "a");
							marcColumn.append(newValue[0]);
						} else if (i == 1) {
							data.append(mark + "x");
							data.append(newValue[1]);

							marcColumn.append(mark + "x");
							marcColumn.append(newValue[1]);
						} else if (i == 2) {
							data.append(mark + "y");
							data.append(newValue[2]);

							marcColumn.append(mark + "y");
							marcColumn.append(newValue[2]);
						} else if (i == 3) {
							data.append(mark + "z");
							data.append(newValue[3]);

							marcColumn.append(mark + "z");
							marcColumn.append(newValue[3]);
						} else if (i == 4) {
							data.append(mark + "j");
							data.append(newValue[4]);

							marcColumn.append(mark + "j");
							marcColumn.append(newValue[4]);
						}
					}
				} else {
					data.append(mark + "a");
					data.append(biblioTemp.getSubject());

					marcColumn.append(mark + "a");
					marcColumn.append(biblioTemp.getSubject());
				}
				data.append(colTail);
				marcColumn.append(colTail);
				eye.append(Constant.MARC_606);
				eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
				eye.append(fixedMarcEyeLength(marcColumn.toString(), 5,
						startIndex));
				startIndex += marcColumn.length();
				marcColumn.delete(0, marcColumn.length());
			} else if (marcKey.equals(Constant.MARC_690)) {
				for (String value : values) {
					value = value.trim();
					if (StringUtils.isNotBlank(value)
							&& value.indexOf("a") == 0) {
						data.append(mark + "a");
						data.append(biblioTemp.getClassNo());

						marcColumn.append(mark + "a");
						marcColumn.append(biblioTemp.getClassNo());
					} else if (StringUtils.isNotBlank(value)
							&& value.indexOf("v") == 0) {
						data.append(mark + value);
						marcColumn.append(mark + value);
					}
				}
				data.append(colTail);
				marcColumn.append(colTail);
				eye.append(Constant.MARC_690);
				eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
				eye.append(fixedMarcEyeLength(marcColumn.toString(), 5,
						startIndex));
				startIndex += marcColumn.length();
				marcColumn.delete(0, marcColumn.length());
			} else if (marcKey.equals(Constant.MARC_326)) {
				for (String value : values) {
					value = value.trim();
					if (StringUtils.isNotBlank(value)
							&& value.indexOf("a") == 0) {
						data.append(mark + "a");
						data.append(biblioTemp.getFrequency());

						marcColumn.append(mark + "a");
						marcColumn.append(biblioTemp.getFrequency());
					}
				}
				data.append(colTail);
				marcColumn.append(colTail);
				eye.append(Constant.MARC_326);
				eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
				eye.append(fixedMarcEyeLength(marcColumn.toString(), 5,
						startIndex));
				startIndex += marcColumn.length();
				marcColumn.delete(0, marcColumn.length());
			} else {
				data.append(marcValue);
				marcColumn.append(marcValue);
				data.append(colTail);
				marcColumn.append(colTail);

				eye.append(marcKey);
				eye.append(fixedMarcEyeLength(marcColumn.toString(), 4, -1));
				eye.append(fixedMarcEyeLength(marcColumn.toString(), 5,
						startIndex));
				startIndex += marcColumn.length();
				marcColumn.delete(0, marcColumn.length());
			}
		}
		String marcContent = eye.append(colTail).append(data).toString()
				.replaceAll("▼", partMark + "");
		biblioTemp.setMarcContent(marcContent);
		return biblioTemp;
	}

	/**
	 * 获取z3950MARC数据指示符
	 * 
	 * @param marcMap
	 * @param mark
	 * @return
	 */
	public static Map<String, String> getZ3950MarcDataIndicator(
			Map<String, String> marcMap, String mark) {
		Map<String, String> indicatorMap = new HashMap<String, String>();
		for (Map.Entry<String, String> e : marcMap.entrySet()) {
			String key = e.getKey();
			String value = e.getValue();
			if (value.indexOf(mark) < 0) {
				indicatorMap.put(key, "");
				continue;
			}
			String sign = value.substring(0, value.indexOf(mark)).trim();
			if (sign.length() == 1) {
				indicatorMap.put(key, sign);
				marcMap.put(key, value.substring(value.indexOf(mark)));
			} else if (sign.length() == 2) {
				indicatorMap.put(key, sign);
				marcMap.put(key, value.substring(value.indexOf(mark)));
			} else
				indicatorMap.put(key, "");
		}
		return indicatorMap;
	}

	public static void main(String[] args) throws Exception {
		// List<Character> dataList = new LinkedList<Character>();
		// dataList.add('2');
		// dataList.add('0');
		// dataList.add('0');
		// groupCase(3, 2, dataList);
		// List<String> list = readMarcData("D:\\桌面重要文件\\总.iso", "gbk");
		// for (int i = 0; i < list.size(); i++) {
		// Map<String, String> map = parseMarcData(list.get(i),'$');
		// if (map != null) {
		// for (Map.Entry<String, String> e : map.entrySet()) {
		// System.out.println(e.getKey() + "  " + e.getValue());
		// }
		// }
		// }
		// String line =
		// "00960nam0 22002651  450 0050017000000100027000171000040000441010007000841020013000911050012001041060004001162000014001202100021001342150010001555170006001656900009001718010030001802016041809542147a978-7-5097-2068-4dCNY30a20160418da纷纷投入f突然专著 em y0chiy0110 ea0achiaCNb110000ay z 000yyar1a纷纷投入f突然专著a北京c社会科学文献出版社d201a页d20cma他如何aG88v5aCNb3303010000784c20160418";
		// Map<String, String> map = parseMarcData(line, '$');
		// for (Map.Entry<String, String> e : map.entrySet()) {
		// System.out.println(e.getKey() + "  " + e.getValue());
		// }
		// char partMark=31;
		// System.out.println("aa".replaceAll("a", ""+partMark));
		// List<String> list = readMarcData("D:\\桌面重要文件\\总.iso", "gbk");
		// String
		// str="00960nam0 22002651  450 010002800000101000500028200002200033210002000055215001200075330002000087606000500107690000600112a978-7-5013-3646-3dCNY60.0achia书目数据编制方法及操作实例f刘小玲专著a北京c国家图书馆出版社d2010a305页d20cma介绍图书馆详细MARC编目方法及流程a图书馆aG254";
		// for(int i=0;i<str.length();i++){
		// char c=str.charAt(i);
		// if(c==30){
		// System.out.println(i);
		// }
		// }
		// System.out.print(Long.parseLong("00032578"));
		// char c=31;
		// String str=""+c;
		// System.out.println(str.length());
		// StringBuilder sql = new StringBuilder("dhsfkjshfksk");
		// sql.delete(0, sql.toString().length());
		// System.out.print(sql.length());
		// String str = "a";
		// System.out.println(str.substring(0, 0).trim());
		// System.out.println(" 00960nam0 22002651 450 ".length());
	}
}
