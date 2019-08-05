package com.wenda.comp.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * <p>
 * Description: ����ʱ�䣨�����ࣩ
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author jzp
 * @Version 1.0 2014-07-17
 */
public class InternetTime {
	private static final String INTEGER_URL = "http://www.bjtime.cn";// ����ʱ�����ַ

	/**
	 * ��ȡ����ʱ�䣨��ݣ�
	 * 
	 * @return
	 */
	public static Integer getInternetTime() {
		// URL url;
		// Date date = null;
		// try {
		// url = new URL(INTEGER_URL);//�������Ӷ���
		// URLConnection uc;//ȡ����Դ����
		// uc = url.openConnection();
		// uc.connect(); //��������
		// long ld=uc.getDate(); //ȡ����վ����ʱ��
		// date=new Date(ld); //ת��Ϊ��׼ʱ�����
		// } catch (MalformedURLException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		Date date = new Date();
		return Integer.valueOf(new SimpleDateFormat("yyyy").format(date));
	}

	/**
	 * ��ȡ������ʾ������»���
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static int[] parseYearOrMonthOrDay(Date date) {
		int[] ymd = new int[3];
		SimpleDateFormat yearSdf = new SimpleDateFormat("yyyy");
		SimpleDateFormat monthSdf = new SimpleDateFormat("MM");
		SimpleDateFormat daySdf = new SimpleDateFormat("dd");
		int year = Integer.parseInt(yearSdf.format(date));
		int month = Integer.parseInt(monthSdf.format(date));
		int day = Integer.parseInt(daySdf.format(date));
		ymd[0] = year;
		ymd[1] = month;
		ymd[2] = day;
		return ymd;
	}

	/**
	 * ���������ַ���
	 * 
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static Date parseDateStr(String dateStr, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = null;
		try {
			if(StringUtils.isNotBlank(dateStr))
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		return date;
	}
	/**
	 * ��date����ַ���
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDate(Date date,String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * ���������ַ���
	 * @param date
	 * @param format
	 * @return
	 */
	public static String parseDateStr(Date date,String format){	
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	/**
	 * ��������Ϊ����
	 * 
	 * @param calendar
	 * @return
	 */
	public static Date toDate(Calendar calendar) {
		return calendar.getTime();
	}

	/**
	 * �����ڱ�Ϊ����
	 * 
	 * @param date
	 * @return
	 */
	public static Calendar toCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	/**
	 * ��ȡָ����������
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static Date strToDate(String year, String month, String day) {
		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(year), Integer.parseInt(month),
				Integer.parseInt(day));
		cal.getTime();
		return cal.getTime();
	}

	/**
	 * ��ȡһ���ж�����
	 * 
	 * @param date
	 * @return
	 */
	public static Integer getDatesForYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.DATE, 31);
		return cal.get(Calendar.DAY_OF_YEAR);
	}

	/**
	 * �������
	 * 
	 * @param date
	 * @param dates
	 * @return
	 */
	public static Date addDate(Date date, Integer dates) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, dates);
		return cal.getTime();
	}

	/**
	 * �����
	 * 
	 * @param date
	 * @param years
	 * @return
	 */
	public static Date addYear(Date date, Integer years) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, years);
		return cal.getTime();
	}

	public static Date getYearAndMonthAndDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	/**
	 * ��ȡĬ�Ͽ�ѧ����
	 * 
	 * @return
	 */
	public static Date[] openSchoolDate() {
		Date[] startEnd = new Date[2];
		Date curDate = new Date();
		int[] ymd = parseYearOrMonthOrDay(curDate);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			if (ymd[1] >= 1 && ymd[1] < 9) {
				startEnd[0] = sdf.parse(ymd[0] - 1 + "-09-01 00:00:00");
				startEnd[1] = sdf.parse(ymd[0] + "-09-01 00:00:00");
			} else {
				startEnd[0] = sdf.parse(ymd[0] + "-09-01 00:00:00");
				startEnd[1] = sdf.parse(ymd[0] + 1 + "-01-01 00:00:00");
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		return startEnd;
	}

	/**
	 * ��ȡָ�������·ݵ�����
	 * 
	 * @param date
	 * @param month
	 * @param dates
	 * @return
	 */
	public static Date getDetail(Date date, Integer month, Integer dates) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DATE, dates);
		return cal.getTime();
	}

	/**
	 * ��ȡ��ǰ��������ʱ�� ����2014��12��12��
	 * 
	 * @return
	 */
	public static String getServerTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strTime = sdf.format(new Date());
		String[] strTimes = strTime.split("-");
		return strTimes[0] + "��" + strTimes[1] + "��" + strTimes[2] + "��";
	}

	/**
	 * �ж�ǩ���Ƿ�---�ж�ʱ��
	 * 
	 * @return
	 */
	public static Boolean signinJudge(Date modifyDate, int day) {
		if (modifyDate == null)
			return false;
		long between = new Date().getTime() - modifyDate.getTime();
		if (between > (24 * 3600000)) {
			return true;
		}
		return false;

	}

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(getYearAndMonthAndDay(new Date())));
	}

}
