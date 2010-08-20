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

package test;

import bacon.ComicSite;
import bacon.SortMethod;
import org.junit.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class ComicSiteTest {

    /**
     * Tests the four-parameter constructor.
     */
    @Test
    public void Test_fourParameterConstructor() {
        ComicSite cs = new ComicSite("xkcd", "Randall Munroe", "http://www.xkcd.com", 1);
        assertEquals(cs.getTitle(), "xkcd");
        assertEquals(cs.getAuthor(), "Randall Munroe");
        assertEquals(cs.getUrl(), "http://www.xkcd.com");
        assertEquals(cs.getIndex(), 1);
    }

    /**
     * Tests the three-parameter constructor.
     */
    @Test
    public void Test_threeParameterConstructor() {
        ComicSite cs = new ComicSite("xkcd", "http://www.xkcd.com", 1);
        assertEquals(cs.getTitle(), "xkcd");
        assertEquals(cs.getUrl(), "http://www.xkcd.com");
        assertEquals(cs.getIndex(), 1);
    }

    /**
     * Tests equals() in the positive case
     */
    @Test
    public void Test_equalsEqual() {
        ComicSite cs = new ComicSite("xkcd", "http://www.xkcd.com", 1);
        ComicSite other = new ComicSite("xkcd", "http://www.xkcd.com", 1);
        assertEquals(cs, other);
    }

    /**
     * Tests equals() in the negative case
     */
    @Test
    public void Test_equalsNotEqual() {
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
    @Test
    public void Test_compareToAlpha() {
        ComicSite.sortMethod = SortMethod.SORT_BY_ALPHABETICAL;
        ComicSite cs = new ComicSite("xkcd", "Randall Munroe", "http://www.xkcd.com", 1);
        ComicSite o = new ComicSite("ykcd", "Randall Munroe", "http://www.xkcd.com", 1);
        assertThat(cs.compareTo(o), is(equalTo(-1)));
    }
}
