/**
 * BACON (sdd.bacon@gmail.com)
 *
 * ComicSiteTest - Provides Tests for ComicSite.
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

import junit.framework.TestCase;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class ComicSiteTest extends TestCase {

    /**
     * Tests the four-parameter constructor.
     */
    public void test_fourParameterConstructor() {
        ComicSite cs = new ComicSite("xkcd", "Randall Munroe", "http://www.xkcd.com", 1);
        assertEquals(cs.getTitle(), "xkcd");
        assertEquals(cs.getAuthor(), "Randall Munroe");
        assertEquals(cs.getUrl(), "http://www.xkcd.com");
        assertEquals(cs.getIndex(), 1);
    }

    /**
     * Tests the three-parameter constructor.
     */
    public void test_threeParameterConstructor() {
        ComicSite cs = new ComicSite("xkcd", "http://www.xkcd.com", 1);
        assertEquals(cs.getTitle(), "xkcd");
        assertEquals(cs.getUrl(), "http://www.xkcd.com");
        assertEquals(cs.getIndex(), 1);
    }

    /**
     * Tests equals() in the positive case
     */
    public void test_equalsEqual() {
        ComicSite cs = new ComicSite("xkcd", "http://www.xkcd.com", 1);
        ComicSite other = new ComicSite("xkcd", "http://www.xkcd.com", 1);
        assertEquals(cs, other);
    }

    /**
     * Tests equals() in the negative case
     */
    public void test_equalsNotEqual() {
        ComicSite cs = new ComicSite("xkcd", "http://www.xkcd.com", 1);
        ComicSite o = new ComicSite("CAD", "http://www.xkcd.com", 1);
        ComicSite p = new ComicSite("xkcd", "http://www.cad-comic.com", 1);
        ComicSite q = new ComicSite("xkcd", "http://www.xkcd.com", 2);
        assertThat(cs, is(not(o)));
        assertThat(cs, is(not(p)));
        assertThat(cs, is(not(q)));
    }

    /**
     * Tests compareTo(), assuming alphabetical sort
     */
    public void test_compareToAlpha() {
        ComicSite.sortMethod = SortMethod.SORT_BY_ALPHABETICAL;
        ComicSite cs = new ComicSite("xkcd", "Randall Munroe", "http://www.xkcd.com", 1);
        ComicSite o = new ComicSite("ykcd", "Randall Munroe", "http://www.xkcd.com", 1);
        assertThat(cs.compareTo(o), is(equalTo(-1)));
        assertThat(o.compareTo(cs), is(equalTo(1)));
    }
    
    /**
     * Tests compareTo(), assuming alphabetical sort, with equal comic names.
     */
    public void test_compareToAlpha_equalNames() {
    	ComicSite.sortMethod = SortMethod.SORT_BY_ALPHABETICAL;
        ComicSite cs = new ComicSite("xkcd", "Randall Munroe", "http://www.xkcd.com", 1);
        ComicSite o = new ComicSite("xkcd", "Sandall Nunroe", "http://www.xkcd.com", 1);
        assertThat(cs.compareTo(o), is(equalTo(-1)));
        assertThat(o.compareTo(cs), is(equalTo(1)));
    }
    
    /**
     * Tests compareTo(), assuming author sort.
     */
    public void test_compareToAuthor() {
    	ComicSite.sortMethod = SortMethod.SORT_BY_AUTHOR;
        ComicSite cs = new ComicSite("xkcd", "Randall Munroe", "http://www.xkcd.com", 1);
        ComicSite o = new ComicSite("xkcd", "Sandall Nunroe", "http://www.xkcd.com", 1);
        assertThat(cs.compareTo(o), is(equalTo(-1)));
        assertThat(o.compareTo(cs), is(equalTo(1)));
    }
    
    /**
     * Tests compareTo(), assuming author sort, with identical author names.
     */
    public void test_compareToAuthor_equalAuthors() {
    	ComicSite.sortMethod = SortMethod.SORT_BY_AUTHOR;
        ComicSite cs = new ComicSite("xkcd", "Randall Munroe", "http://www.xkcd.com", 1);
        ComicSite o = new ComicSite("ykcd", "Randall Munroe", "http://www.xkcd.com", 1);
        assertThat(cs.compareTo(o), is(equalTo(-1)));
        assertThat(o.compareTo(cs), is(equalTo(1)));
    }
    
    /**
     * Tests compareTo(), assuming date sort.
     */
    public void test_compareToDate() {
    	// TODO(stark3): Fill in this test when compareTo works with SORT_BY_DATE
    	ComicSite.sortMethod = SortMethod.SORT_BY_DATE;
        ComicSite cs = new ComicSite("xkcd", "Randall Munroe", "http://www.xkcd.com", 1);
        ComicSite o = new ComicSite("xkcd", "Randall Munroe", "http://www.xkcd.com", 1);
        assertThat(cs.compareTo(o), is(equalTo(0)));
        assertThat(o.compareTo(cs), is(equalTo(0)));
    }
    
    public void test_compareTo_nullSortMethod() {
    	ComicSite.sortMethod = null;
        ComicSite cs = new ComicSite("xkcd", "Randall Munroe", "http://www.xkcd.com", 1);
        ComicSite o = new ComicSite("xkcd", "Randall Munroe", "http://www.xkcd.com", 1);
        try {
        	cs.compareTo(o);
        	fail("NullPointerException expected");
        } catch (NullPointerException e) {
        	assertEquals("sortMethod cannot be null", e.getMessage());
        }
    }
    
    /**
     * Tests getInfoString with an author given.
     */
    public void test_getInfoString() {
    	ComicSite cs = new ComicSite("xkcd", "Randall Munroe", "http://www.xkcd.com", 1);
    	String expectedInfoString = "\"xkcd\" by Randall Munroe, at http://www.xkcd.com";
    	assertEquals(expectedInfoString, cs.getInfoString());
    }
    
    /**
     * Tests getInfoString with an author given.
     */
    public void test_getInfoString_noAuthor() {
    	ComicSite cs = new ComicSite("xkcd", "http://www.xkcd.com", 1);
    	String expectedInfoString = "\"xkcd\" at http://www.xkcd.com";
    	assertEquals(expectedInfoString, cs.getInfoString());
    }
    
    /**
     * Tests toString.
     */
    public void test_toString() {
    	ComicSite cs = new ComicSite("xkcd", "Randall Munroe", "http://www.xkcd.com", 1);
    	assertEquals(cs.getInfoString(), cs.toString());
    	
    	ComicSite cs2 = new ComicSite("Order ot the Stick", "Some Guy", "http://www.website.com", 2);
    	assertEquals(cs2.getInfoString(), cs2.toString());
    }
}
