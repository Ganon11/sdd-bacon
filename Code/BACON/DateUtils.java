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

public class DateUtils {
	public static Date getCurrentDate() {
		GregorianCalendar currentDate = new GregorianCalendar();
		return currentDate.getTime();
	}
	
	public static Date createDate(int year, int month, int day) {
		GregorianCalendar date = new GregorianCalendar(year, month, day);
		return date.getTime();
	}
    
    public static Date createDate(int year, String month, int day) {
        return DateUtils.createDate(year, DateUtils.monthStringToInteger(month), day);
    }
	
	public static int monthStringToInteger(String month) {
		if (month.equalsIgnoreCase("Jan") || month.equalsIgnoreCase("January")) {
			return 1;
		}
		if (month.equalsIgnoreCase("Feb") || month.equalsIgnoreCase("February")) {
			return 2;
		}
		if (month.equalsIgnoreCase("Mar") || month.equalsIgnoreCase("March")) {
			return 3;
		}
		if (month.equalsIgnoreCase("Apr") || month.equalsIgnoreCase("April")) {
			return 4;
		}
		if (month.equalsIgnoreCase("May")) {
			return 5;
		}
		if (month.equalsIgnoreCase("Jun") || month.equalsIgnoreCase("June")) {
			return 6;
		}
		if (month.equalsIgnoreCase("Jul") || month.equalsIgnoreCase("July")) {
			return 7;
		}
		if (month.equalsIgnoreCase("Aug") || month.equalsIgnoreCase("August")) {
			return 8;
		}
		if (month.equalsIgnoreCase("Sep") || month.equalsIgnoreCase("September")) {
			return 9;
		}
		if (month.equalsIgnoreCase("Oct") || month.equalsIgnoreCase("October")) {
			return 10;
		}
		if (month.equalsIgnoreCase("Nov") || month.equalsIgnoreCase("November")) {
			return 11;
		}
		if (month.equalsIgnoreCase("Dec") || month.equalsIgnoreCase("December")) {
			return 12;
		}
		return 0;
	}
}