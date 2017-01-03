package com.dts.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author drdtl007
 */
public class DateWrapper
{
	/**
	 * for month names
	 */
	static String[] month = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };


	@SuppressWarnings("deprecation")
	/**
	 * 
	 * @param date
	 * @return
	 */
	public static String parseDate(final Date date)
	{
		final int monthid = date.getMonth();
		final String newdate = date.getDate() + "-" + month[monthid] + "-" + (date.getYear() + 1900);
		LoggerManager.writeLogInfo("new date==" + newdate);
		return newdate;
	}
	/**
	 * 
	 * @param date
	 * @return
	 */
	public static String parseDate(final String date)
	{
		final int monthid = Integer.parseInt(date.substring(date.indexOf('-') + 1, date.lastIndexOf('-')));
		final String newdate = date.substring(0, date.indexOf('-')) + "-" + month[monthid - 1] + "-" + (date.substring(date.lastIndexOf('-') + 1, date.length()));
		//System.out.println("parseDate(String) : "+newdate);
		return newdate;
	}
	/**
	 * 
	 * @param date
	 * @return
	 */
	public static String parseDate(final java.sql.Date date)
	{
		final String olddate = date.toString();
		return olddate.substring(0, olddate.indexOf('-')) + "-" + olddate.substring(olddate.indexOf('-') + 1, olddate.lastIndexOf('-')) + "-" + date.toString().substring(olddate.lastIndexOf('-') + 1, olddate.length());
	}
	
	public static java.sql.Date getSqlDate(final String dateString) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date parsed = null;
		try {
			parsed = format.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date sql = new java.sql.Date(parsed.getTime());
		return sql;
	}
}
