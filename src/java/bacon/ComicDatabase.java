/**
 * BACON (sdd.bacon@gmail.com)
 *
 * ComicDatabase - Saves and loads a list of Webcomics to display.
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

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 public class ComicDatabase {
    private String fileName;
    private List<ComicSite> allComics;
    private Date dateLoaded;
    private int current;

    /**
     * Creates the ComicDatabase with the data file stored in the specified
     * location.
     */
    public ComicDatabase(String dataFileName) {
        fileName = dataFileName;
        allComics = new ArrayList<ComicSite>();
        current = -1;
    }

    /**
     * Creates the ComicDatabase with the data file stored in the default
     * location.
     */
    public ComicDatabase() {
        fileName = ".datafile.dat";
        allComics = new ArrayList<ComicSite>();
        current = -1;
    }

    /**
     * Loads the file specified by DATA_FILE, and reads in the list of
     * ComicSites and ComicStrips.
     *
     * WARNING: Calling this method clears the list of comics in order to load
     * the new list!
     *
     * @see Date
     */
    public void loadDatabase() throws FileNotFoundException {
        allComics.clear();
        current = 0;
        try {
            //System.out.println(DATA_FILE);
            Scanner dataFile = new Scanner(new FileReader(fileName));
            String dateSaved = dataFile.nextLine();
            // The date is saved in format:
            // dow mon dd hh:mm:ss zzz yyyy
            // For more information, see the Date class.
            String[] dateItems = dateSaved.split(" ");
            int year = new Integer(dateItems[5]).intValue();
            int day = new Integer(dateItems[2]).intValue();
            dateLoaded = DateUtils.createDate(year, dateItems[1], day);

            while (dataFile.hasNextLine()) {
                // The Data File consists of the Comic Title, Author, Image
                // File Path, URL, and Comic Index on separate lines.
                ComicSite comic;
                ComicStrip strip;
                String titleLine = dataFile.nextLine();
                String authorLine = dataFile.nextLine();
                String fileLine = dataFile.nextLine();
                String urlLine = dataFile.nextLine();
                String indexLine = dataFile.nextLine();

                String title = titleLine.substring(12);
                String author = authorLine.substring(14);
                String filePath = fileLine.substring(12);
                String url = urlLine.substring(11);
                int index = Integer.parseInt(indexLine.substring(13));
                strip = createComicStrip(url, index);
                comic = createComicSite(title, author, url, index, strip);
                allComics.add(comic);
            }
        } catch (FileNotFoundException e) {
            throw e;
        }
        sortComicList();
    }
    
    /**
     * Saves the current list of ComicSites to the data file given.
     * 
     *  @param fileName Name of new file to write to.
     */
    public void saveDatabase(String fileName) {
    	this.fileName = fileName;
    	saveDatabase();
    }

    /**
     * Saves the current list of ComicSites to the data file specified by
     * DATA_FILE.
     */
    public void saveDatabase() {
        try {
            FileWriter dataFile = new FileWriter(fileName);
            Date currentDate = DateUtils.getCurrentDate();
            // The date is saved in format:
            // dow mon dd hh:mm:ss zzz yyyy
            // For more information, see the Date class.
            dataFile.write(currentDate.toString());
            for (ComicSite comic : allComics) {
                ComicStrip strip = comic.getStrip();
                dataFile.write("\nComic Name: " + comic.getTitle() + "\n");
                dataFile.write("Comic Author: " + comic.getAuthor() + "\n");
                String pathline = "Image Path: " + strip.getFilePath();
                dataFile.write(pathline + "\n");
                dataFile.write("Comic URL: " + comic.getUrl() + "\n");
                dataFile.write("Comic Index: " + comic.getIndex());
            }
            dataFile.close();
        } catch (IOException e) {
            // Handle the IOException here - display an error frame, print
            // a message the STDERR, whatev.
        }
    }

    /**
     * Fetches the loaded list of all comics.
     *
     * @return An ArrayList of ComicSites, each of which has the proper image loaded.
     */
    public List<ComicSite> getAllComics() {
        return allComics;
    }

    /**
     * Fetches the date when comics were last saved.
     *
     * @return The Date pbject representing when the comics were last saved.
     */
    public Date getSaveDate() {
        return dateLoaded;
    }

    /**
     * Re-sorts the list, presumably after ComicSite's sortMethod has changed.
     */
    public void sortComicList() {
        if (allComics.size() <= 1) {
        	return; // Lists of size 0 or 1 shouldn't be sorted
        }
        // We want to keep the user at the comic they're currently viewing.
        ComicSite cs = getCurrentComic();
        Collections.sort(allComics);
        current = Collections.binarySearch(allComics, cs);
    }

    /**
     * Moves to and returns the next ComicSite for display. Circles to the first if the current site
     * is the last in the list.
     *
     * @return The next ComicSite in the list, circling to the first if necessary, or null if the list is empty.
     */
    public ComicSite getNextComic() {
        if (allComics.isEmpty()) {
        	return null;
        }
        if (current < 0 || ++current >= allComics.size()) {
        	current = 0;
        }
        ComicSite cs = allComics.get(current);
        cs.getStrip().loadImage();
        return cs;
    }

    /**
     * Moves to and returns the previous ComicSite for display. Circles to the last if the current site
     * is the first in the list.
     *
     * @return The next Comic Site in the list, circling to the first if necessary, or null if the list is empty.
     */
    public ComicSite getPreviousComic() {
        if (allComics.isEmpty()) {
        	return null;
        }
        if (current >= allComics.size() || --current < 0) {
        	current = allComics.size() - 1;
        }
        ComicSite cs = allComics.get(current);
        cs.getStrip().loadImage();
        return cs;
    }

    /**
    * Returns the current comic as a ComicSite.
    *
    * @return The current ComicSite in the list, or null if the list is empty.
    */
    public ComicSite getCurrentComic() {
        if (allComics.isEmpty()) {
        	return null;
        }
        if (current < 0 || current >= allComics.size()) {
        	current = 0;
        }
        return allComics.get(current);
    }

    /**
    * Returns true if the database has any comics stored.
    *
    * @return true if the comic list is NOT empty.
    */
    public boolean hasComics() {
        return !allComics.isEmpty();
    }

    /**
     * Adds a ComicSite to the list.
     * @param cs The ComicSite to be added
     */
    public void addComic(ComicSite cs) {
        int pos = Collections.binarySearch(allComics, cs);
        if (pos < 0) {
            //pos == (-(insertion point) - 1)
            current = -(pos + 1);
            allComics.add(current, cs);
        } else {
            //The comic has already been found in the database...
            System.err.println("Comic already exists. Will not add.");
        }
    }

    /**
    * Removes a ComicSite from the list
    */
    public void removeComic() {
        if (allComics.isEmpty()) {
            //Nothing to remove...
            return;
        }
        if (current < 0 || current >= allComics.size()) current = 0;
        allComics.remove(current);
        if(current >= allComics.size()) current = 0;
    }
    
    public boolean equals(Object o) {
    	if (!(o instanceof ComicDatabase)) {
    		return false;
    	}
    	
    	ComicDatabase other = (ComicDatabase) o;
    	for (ComicSite site : allComics) {
    		if (!other.allComics.contains(site)) {
    			return false;
    		}
    	}
    	
    	return true;
    }
    
    // ========== helper methods ==========
    
    // Left at package visibility for testing
    ComicStrip createComicStrip(String url, int index) {
    	return new ComicStrip(BaconSystem.getImageN(url, index));
    }

    // Left at package visibility for testing
    ComicSite createComicSite(String title, String author, String url, int index, ComicStrip strip) {
    	ComicSite site = new ComicSite(title, author, url, index);
    	site.setStrip(strip);
    	return site;
    }
}
