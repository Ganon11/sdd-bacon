/**
 * BACON (sdd.bacon@gmail.com)
 *
 * DateUtils - Provides an easy interface for getting/saving the current date.
 * 
 * Copyright (c) 2010
 * @author David Pizzuto, Seamus Reynolds, Matt Schoen, Michael Stark
 * All Rights Reserved
 *
 * @version 0.1, 04/02/10
 *
 * http://code.google.com/p/bacon/
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
 
package BACON;

import java.util.Date;
import java.util.GregorianCalendar;

public final class DateUtils {
    /**
    * NO ONE SHALL CREATE A DateUtils OBJECT
    */
    private DateUtils() {
    }
    /**
     * Creates a Date object representing the current time.
     *
     * @return A Date object representing the current time.
     */
	public static Date getCurrentDate() {
		GregorianCalendar currentDate = new GregorianCalendar();
		return currentDate.getTime();
	}
	
    /**
     * Creates a Date object at day/month/year
     *
     * @param year The year in YYYY form.
     * @param month The month in MM or M form (i.e. 11 or 4).  Must be 0 based.
     * @param day The day in DD or D form (i.e. 21 or 6)
     * @return A date representing the given parameters.
     */
	public static Date createDate(int year, int month, int day) {
        // GregorianCalendar expects month in 0 based form (January is 0).
		GregorianCalendar date = new GregorianCalendar(year, month, day);
		return date.getTime();
	}
	
    /**
     * Creates a Date object at day/month/year.  If a bad month is given, returns null.
     *
     * @param year The year in YYYY form.
     * @param month The month in String formate (either 'Jan' or 'April')
     * @param day The day in DD or D form (i.e. 21 or 6)
     * @return A date representing the given parameters, or null if a bad Month is given.
     */
    
    public static Date createDate(int year, String month, int day) {
        int monthVal = DateUtils.monthStringToInteger(month);
        if (monthVal == -1) {
            return null;
        }
        return DateUtils.createDate(year, monthVal, day);
    }
	
    /**
     * Fetches the numerical month value based on the given String representation.
     *
     * @param month The month in String format (either 'Jan' or 'April')
     * @return The month's integer value, or 0 if bad input is given.
     */
	
	public static int monthStringToInteger(String month) {
		if (month.equalsIgnoreCase("Jan") || month.equalsIgnoreCase("January")) {
			return 0;
		}
		if (month.equalsIgnoreCase("Feb") || month.equalsIgnoreCase("February")) {
			return 1;
		}
		if (month.equalsIgnoreCase("Mar") || month.equalsIgnoreCase("March")) {
			return 2;
		}
		if (month.equalsIgnoreCase("Apr") || month.equalsIgnoreCase("April")) {
			return 3;
		}
		if (month.equalsIgnoreCase("May")) {
			return 4;
		}
		if (month.equalsIgnoreCase("Jun") || month.equalsIgnoreCase("June")) {
			return 5;
		}
		if (month.equalsIgnoreCase("Jul") || month.equalsIgnoreCase("July")) {
			return 6;
		}
		if (month.equalsIgnoreCase("Aug") || month.equalsIgnoreCase("August")) {
			return 7;
		}
		if (month.equalsIgnoreCase("Sep") || month.equalsIgnoreCase("September")) {
			return 8;
		}
		if (month.equalsIgnoreCase("Oct") || month.equalsIgnoreCase("October")) {
			return 9;
		}
		if (month.equalsIgnoreCase("Nov") || month.equalsIgnoreCase("November")) {
			return 10;
		}
		if (month.equalsIgnoreCase("Dec") || month.equalsIgnoreCase("December")) {
			return 11;
		}
		return -1;
	}
}