/**
 * BACON (sdd.bacon@gmail.com)
 *
 * ComicDatabaseTest - Tests for the ComicDatabase class
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

import BACON.ComicDatabase;
import BACON.ComicSite;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.List;

public class ComicDatabaseTest {

    /**
     * Tests whether an exception is thrown if the file cannot be found.
     */
    @Test(expected=FileNotFoundException.class)
    public void test_LoadDatabaseThrowsFileNotFound() throws FileNotFoundException {
        ComicDatabase db = new ComicDatabase("NOT A FILE");
        db.loadDatabase();
    }

    /**
     * Tests whether loadDatabase reads from a file properly.
     */
    @Test
    public void test_LoadDatabaseReadsProperly() throws FileNotFoundException {
        String dbFileName = "test" + java.io.File.separator + "fakedatabase.dat";
        ComicDatabase db = new ComicDatabase(dbFileName);
        db.loadDatabase();
        List<BACON.ComicSite> resultList = db.getAllComics();
        BACON.ComicSite testComic = resultList.get(0);
        String testPath = "~/sdd-bacon/PanelExamples/infinitecanvaspanels.png";
        assertEquals("Girly", testComic.getTitle());
        assertEquals("Mr. Pizzuto-san", testComic.getAuthor());
        assertEquals(testPath, testComic.getStrip().getFilePath());
        assertEquals("http://www.prettygirly.com/", testComic.getUrl());
        assertEquals(2, testComic.getIndex());
    }

    /**
     * Tests whether loadDatabase reads the date from the DBFile properly.
     */
    @Test
    public void test_LoadDatabaseReadsDateProperly() throws FileNotFoundException {
        String dbFileName = "test" + java.io.File.separator + "fakedatabase.dat";
        ComicDatabase db = new ComicDatabase(dbFileName);
        db.loadDatabase();
        java.util.Date testDate = BACON.DateUtils.createDate(2010, "APR", 14);
        assertEquals(db.getSaveDate(), testDate);
    }

    /**
     * Tests adding a comic to the list.
     */
    @Test
    public void test_AddComic() {
        String dbFileName = "test" + java.io.File.separator + "fakedatabase.dat";
        ComicDatabase db = new ComicDatabase(dbFileName);
        ComicSite cs = new ComicSite("xkcd", "Randall Munroe", "http://www.xkcd.com", 1);
        db.addComic(cs);
        ComicSite sc = db.getAllComics().get(0);
        assertEquals(cs, sc);
    }

    /**
     * Tests that getting the next comic works with one comic.
     */
    @Test
    public void test_GetNextOneComic() {
        ComicDatabase db = new ComicDatabase();
        ComicSite cs = new ComicSite("xkcd", "Randall Munroe", "http://www.xkcd.com", 1);
        db.addComic(cs);
        assertEquals(cs, db.getNextComic());
    }

    /**
     * Tests that getting the previous comic works with one comic.
     */
    @Test
    public void test_GetPreviousOneComic() {
        ComicDatabase db = new ComicDatabase();
        ComicSite cs = new ComicSite("xkcd", "Randall Munroe", "http://www.xkcd.com", 1);
        db.addComic(cs);
        assertEquals(cs, db.getPreviousComic());
    }

    /**
     * Tests getNextComic and getPreviousComic when the list has multiple elements.
     */
    @Test
    public void test_GetNextPreviousComic() {
        ComicDatabase db = new ComicDatabase();
        ComicSite cs = new ComicSite("xkcd", "Randall Munroe", "http://www.xkcd.com", 1);
        ComicSite sc = new ComicSite("CAD", "Tim Buckley", "http://www.cad-comic.com", 1);
        db.addComic(cs);
        db.addComic(sc);
        assertEquals(sc, db.getNextComic());
        assertEquals(sc, db.getPreviousComic());
        assertEquals(sc, db.getNextComic());
        assertEquals(cs, db.getNextComic());
        assertEquals(sc, db.getNextComic());
    }

}
