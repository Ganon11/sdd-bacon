/**
 * BACON (sdd.bacon@gmail.com)
 *
 * DateUtilsTest - Tests for the DateUtils library.
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

package bacon;

import java.util.Date;
import java.util.GregorianCalendar;

import junit.framework.TestCase;

public class DateUtilsTest extends TestCase {
	/**
	 * Tests whether getCurrentDate correctly fetches the current Date.
	 */
	public void test_getCurrentDate() {
		long expected = new GregorianCalendar().getTime().getTime();
		long actual = DateUtils.getCurrentDate().getTime();
		assertTrue(expected <= actual);
		long expected2 = new GregorianCalendar().getTime().getTime();
		assertTrue(actual <= expected2);
	}
	
    /**
     * Tests whether createDate creates a correct date.
     */
    public void test_createDate() {
        Date testDay = DateUtils.createDate(1989, 4, 11);
        Date myBDay = new GregorianCalendar(1989, 4, 11).getTime();
        assertEquals(testDay, myBDay);
    }
    
    /**
     * Tests whether createDate creates a correct date when given negative month values.
     */
    public void test_createDateWithNegativeValues() {
        Date testDay = DateUtils.createDate(1989, -4, 11);
        Date notMyBDay = new GregorianCalendar(1989, -4, 11).getTime();
        assertEquals(testDay, notMyBDay);
    }
    
    /**
     * Tests whether createDate creates a correct date, using the (int, String, int) function call.
     */
    public void test_createDateWithStringArg() {
        Date testDay = DateUtils.createDate(1989, "May", 11);
        Date myBDay = new GregorianCalendar(1989, 4, 11).getTime();
        assertEquals(testDay, myBDay);
    }
    
    /**
     * Tests whether createDate nulls its return value when given a bad month value.
     */
    public void test_createDateWithBadStringArg() {
        Date testDay = DateUtils.createDate(1989, "Funtober", 11);
        assertEquals(testDay, null);
    }
    
    /**
     * Tests the monthStringToInteger method with various months.
     */
     public void test_monthStringToInteger() {
        String month = "Jan";
        int expectedValue = 0;
        assertEquals(DateUtils.monthStringToInteger(month), expectedValue);
        month = "JAN";
        expectedValue = 0;
        assertEquals(DateUtils.monthStringToInteger(month), expectedValue);
        month = "March";
        expectedValue = 2;
        assertEquals(DateUtils.monthStringToInteger(month), expectedValue);
        month = "AUGusT";
        expectedValue = 7;
        assertEquals(DateUtils.monthStringToInteger(month), expectedValue);
     }
     
     /**
     * Tests the monthStringToInteger method with a nonexistent month.
     */
     public void test_monthStringToIntegerWithBadString() {
        String month = "Funtober";
        int expectedValue = -1;
        assertEquals(DateUtils.monthStringToInteger(month), expectedValue);
     }
}
