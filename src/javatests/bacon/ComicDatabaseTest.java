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

package bacon;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import junit.framework.TestCase;

public class ComicDatabaseTest extends TestCase {
	private ComicDatabase database;
	private String FAKE_DATABASE = "fakedatabase.dat";
	
	public void setUp() throws IOException {
		FileWriter dummyFile = new FileWriter(FAKE_DATABASE);
		dummyFile.write("Wed Apr 14 00:00:00 EST 2010\n" +
						"Comic Name: DOMINIC DEEGAN\n" +
						"Comic Author: M IS FOR MOOKIE\n" +
						"Image Path: ~/sdd-bacon/PanelExamples/4x2panels.gif\n" +
						"Comic URL: http://www.dominic-deegan.com/\n" +
						"Comic Index: 3\n" +
						"Comic Name: SORE THUMBS\n" +
						"Comic Author: THUMBS ARE SORE\n" +
						"Image Path: ~/sdd-bacon/PanelExamples/1x4panels.jpg\n" +
						"Comic URL: http://www.ihavesorethumbs.com/\n" +
						"Comic Index: 8\n" +
						"Comic Name: Girly\n" +
						"Comic Author: Mr. Pizzuto-san\n" +
						"Image Path: ~/sdd-bacon/PanelExamples/infinitecanvaspanels.png\n" +
						"Comic URL: http://www.prettygirly.com/\n" +
						"Comic Index: 2");
		dummyFile.close();
	}
	
	public void tearDown() throws IOException {
		File dummyFile = new File(FAKE_DATABASE);
		dummyFile.delete();
	}
	
    /**
     * Tests whether an exception is thrown if the file cannot be found.
     */
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
    public void test_LoadDatabaseReadsProperly() throws FileNotFoundException {
    	// TODO(stark3): Refactor ComicDatabase to use dependency injection so that we can
    	// stub out files.
//    	File fakeDatabaseFile = File.createTempFile(arg0, arg1);
    	database = new StubComicDatabase(FAKE_DATABASE);
        database.loadDatabase();
        List<ComicSite> resultList = database.getAllComics();
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
    public void test_LoadDatabaseReadsDateProperly() throws FileNotFoundException {
    	// TODO(stark3): Refactor ComicDatabase to use dependency injection so that we can
    	// stub out files.
    	database = new StubComicDatabase(FAKE_DATABASE);
        database.loadDatabase();
        java.util.Date testDate = DateUtils.createDate(2010, "APR", 14);
        assertEquals(database.getSaveDate(), testDate);
    }

    /**
     * Tests adding a comic to the list.
     */
    public void test_AddComic() {
    	File dummyFile = new File("dummy_data_file.dat");
        ComicDatabase db = new ComicDatabase(dummyFile.getName());
        ComicSite cs = new ComicSite("New Comic", "New Author", "http://www.fake.com", 1);
        db.addComic(cs);
        List<ComicSite> comics = db.getAllComics();
        assertTrue(comics.contains(cs));
        dummyFile.delete();
    }

    /**
     * Tests that getting the next comic works with one comic.
     */
    public void test_GetNextOneComic() {
    	File dummyFile = new File("dummy_data_file.dat");
        ComicDatabase db = new ComicDatabase(dummyFile.getName());
        ComicSite cs = new StubComicSite("xkcd", "Randall Munroe", "http://www.xkcd.com", 1);
        db.addComic(cs);
        assertEquals(cs, db.getNextComic());
        dummyFile.delete();
    }

    /**
     * Tests that getting the previous comic works with one comic.
     */
    public void test_GetPreviousOneComic() {
    	File dummyFile = new File("dummy_data_file.dat");
        ComicDatabase db = new ComicDatabase(dummyFile.getName());
        ComicSite cs = new StubComicSite("xkcd", "Randall Munroe", "http://www.xkcd.com", 1);
        db.addComic(cs);
        assertEquals(cs, db.getPreviousComic());
        dummyFile.delete();
    }
    
    public void test_SaveDatabase() throws FileNotFoundException {
    	File dummyFile = new File("new_dummy_file.dat");
    	database = new StubComicDatabase();
    	ComicSite testSite = new StubComicSite("Name", "Author", "http://some.web.site", 3);
    	testSite.setStrip(new StubComicStrip());
    	database.addComic(testSite);
    	database.saveDatabase(dummyFile.getName());
    	ComicDatabase db = new StubComicDatabase(dummyFile.getName());
    	db.loadDatabase();
    	assertEquals(database, db);
    	dummyFile.delete();
    }

    /**
     * Tests getNextComic and getPreviousComic when the list has multiple elements.
     */
    public void test_GetNextPreviousComic() {
    	File dummyFile = new File("dummy_data_file.dat");
        ComicDatabase db = new ComicDatabase(dummyFile.getName());
        ComicSite cs = new StubComicSite("xkcd", "Randall Munroe", "http://www.xkcd.com", 1);
        ComicSite sc = new StubComicSite("CAD", "Tim Buckley", "http://www.cad-comic.com", 2);
        db.addComic(cs);
        db.addComic(sc);
        assertEquals(cs, db.getNextComic());
        assertEquals(sc, db.getNextComic());
        assertEquals(cs, db.getNextComic());
        assertEquals(sc, db.getPreviousComic());
        assertEquals(cs, db.getPreviousComic());
        dummyFile.delete();
    }

    public void test_hasComics() {
    	ComicDatabase db = new ComicDatabase();
    	assertFalse(db.hasComics());
    	ComicSite cs = new ComicSite("Comic Name", "URL", 3);
    	db.addComic(cs);
    	assertTrue(db.hasComics());
    	db.removeComic();
    	assertFalse(db.hasComics());
    }
    
    public void test_emptyDatabase() {
    	database = new ComicDatabase();
    	assertTrue(database.getNextComic() == null);
    	assertTrue(database.getPreviousComic() == null);
    	assertTrue(database.getCurrentComic() == null);
    }
    
    // ========== helper functions ==========
    
    private class StubComicDatabase extends ComicDatabase {
    	public StubComicDatabase() {
    		super();
    	}
    	
    	public StubComicDatabase(String fileName) {
    		super(fileName);
    	}
    	
    	@Override
    	ComicStrip createComicStrip(String url, int index) {
    		return null;
    	}
    }
    
    private class StubComicSite extends ComicSite {
		public StubComicSite(String name, String author, String url, int index) {
			super(name, author, url, index);
		}
		
		@Override
		public ComicStrip getStrip() {
			return new StubComicStrip();
		}
    }
    
    private class StubComicStrip extends ComicStrip {
    	@Override
    	public String getFilePath() {
    		return null;
    	}
    	
    	@Override
    	public void loadImage() {}
    }
}
