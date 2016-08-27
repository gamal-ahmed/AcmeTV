package utils;

import java.sql.Date;

public class DateUtils {

	public static String getMonth(int CalendarInteger) {
		switch (CalendarInteger) {
		case 1:
			return "JANUARY";
		case 2:
			return "FEBRUARY";
		case 3:
			return "MARCH";
		case 4:
			return "APRIL";
		case 5:
			return "MAY";
		case 6:
			return "JUNE";
		case 7:
			return "JULY";
		case 8:
			return "AUGUST";
		case 9:
			return "SEPTEMBER";
		case 10:
			return "OCTOBER";
		case 11:
			return "NOVEMBER";
		case 12:
			return "DECEMBER";
		default:
			break;
		}
		return "";

	}

	/**
	 * Converts the given java.util.Date to java.sql.Date.
	 * 
	 * @param date
	 *            The java.util.Date to be converted to java.sql.Date.
	 * @return The converted java.sql.Date.
	 */
	public static Date toSqlDate(java.util.Date date) {
		return (date != null) ? new Date(date.getTime()) : null;
	}
}
