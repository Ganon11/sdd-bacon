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

import bacon.ComicDatabase;
import bacon.ComicSite;
import bacon.DateUtils;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class ComicDatabaseTest {
//	private String baseDir = "C:\\Users\\starkm3\\workspace\\BACON-Repo\\src\\test\\";

    /**
     * Tests whether an exception is thrown if the file cannot be found.
     */
    @Test
    public void test_LoadDatabaseThrowsFileNotFound() throws Exception {
        ComicDatabase db = new ComicDatabase("NOT A FILE");
        try {
        	db.loadDatabase();
        	fail("FileNotFoundException expected.");
        } catch (FileNotFoundException e) {
        	// Nothing to do here
        	assertEquals("NOT A FILE (The system cannot find the file specified)", e.getMessage());
        }
    }

    /**
     * Tests whether loadDatabase reads from a file properly.
     */
    @Test
    public void test_LoadDatabaseReadsProperly() throws FileNotFoundException {
//        String dbFileName = baseDir + "fakedatabase.dat";
    	String dbFileName = "fakedatabase.dat";
        ComicDatabase db = new ComicDatabase(dbFileName);
        db.loadDatabase();
        List<ComicSite> resultList = db.getAllComics();
        ComicSite testComic = resultList.get(0);
        
        // Note: This test is dependent on the fake database file given,  If the
        // contents of the fake file change, change this test accordingly, or you
        // will get false failures.
        
//        String testPath = "~/sdd-bacon/PanelExamples/4x2panels.gif";
        assertEquals("DOMINIC DEEGAN", testComic.getTitle());
        assertEquals("M IS FOR MOOKIE", testComic.getAuthor());
        // Next line commented out because new ComicDatabase functionality may
        // latest image on its own - in which case the filepath will change
        //assertEquals(testPath, testComic.getStrip().getFilePath());
        assertEquals("http://www.dominic-deegan.com/", testComic.getUrl());
        assertEquals(3, testComic.getIndex());
    }

    /**
     * Tests whether loadDatabase reads the date from the DBFile properly.
     */
    @Test
    public void test_LoadDatabaseReadsDateProperly() throws FileNotFoundException {
//        String dbFileName = baseDir + "fakedatabase.dat";
    	String dbFileName = "fakedatabase.dat";
        ComicDatabase db = new ComicDatabase(dbFileName);
        db.loadDatabase();
        java.util.Date testDate = DateUtils.createDate(2010, "APR", 14);
        assertEquals(db.getSaveDate(), testDate);
    }

    /**
     * Tests adding a comic to the list.
     */
    @Test
    public void test_AddComic() {
        String dbFileName = "test" + File.separator + "fakedatabase.dat";
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
        ComicSite sc = new ComicSite("CAD", "Tim Buckley", "http://www.cad-comic.com", 2);
        db.addComic(cs);
        db.addComic(sc);
        assertEquals(cs, db.getNextComic());
        assertEquals(sc, db.getNextComic());
        assertEquals(cs, db.getNextComic());
        assertEquals(sc, db.getPreviousComic());
        assertEquals(cs, db.getPreviousComic());
    }

}
