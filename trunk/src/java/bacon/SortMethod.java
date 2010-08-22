/**
 * BACON (sdd.bacon@gmail.com)
 *
 * SortMethod - An enumeration of sorting types.
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

public enum SortMethod {
    SORT_BY_ALPHABETICAL("A_TO_Z_ALPHABETICAL"),
    SORT_BY_AUTHOR("AUTHOR_NAME_A_TO_Z"),
    SORT_BY_DATE("DATE_LAST_UPDATED");
	
	private String sortName;
    
    public static SortMethod getSortMethod(String sortString) {
    	if (sortString.equalsIgnoreCase("A_TO_Z_ALPHABETICAL")) {
    		return SORT_BY_ALPHABETICAL;
    	} else if (sortString.equalsIgnoreCase("AUTHOR_NAME_A_TO_Z")) {
    		return SORT_BY_AUTHOR;
    	} else if (sortString.equalsIgnoreCase("DATE_LAST_UPDATED")) {
    		return SORT_BY_DATE;
    	} else {
    		return null;
    	}
    }
    
    private SortMethod(String sortName) {
    	this.sortName = sortName;
    }
    
    public String toString() {
    	return sortName;
    }
}
