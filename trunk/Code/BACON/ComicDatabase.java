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

package BACON;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

 public class ComicDatabase {
    private final String DATA_FILE;
    private LinkedList<ComicSite> allComics;
    private Date dateLoaded;
    private ListIterator<ComicSite> it;

    /**
     * Creates the ComicDatabase with the data file stored in the specified
     * location.
     */
    public ComicDatabase(String dataFileName) {
        DATA_FILE = dataFileName;
        allComics = new LinkedList<ComicSite>();
    }

    /**
     * Creates the ComicDatabase with the data file stored in the default
     * location.
     */
    public ComicDatabase() {
        DATA_FILE = ".datafile.dat";
        allComics = new LinkedList<ComicSite>();
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
        try {
            Scanner dataFile = new Scanner(new FileReader(DATA_FILE));
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
                // File Path, and URL on separate lines.
                ComicSite comic;
                ComicStrip strip;
                String titleLine = dataFile.nextLine();
                String authorLine = dataFile.nextLine();
                String fileLine = dataFile.nextLine();
                String urlLine = dataFile.nextLine();

                String title = titleLine.substring(12);
                String author = authorLine.substring(14);
                String filePath = fileLine.substring(12);
                String url = urlLine.substring(11);
                strip = new ComicStrip(filePath);
                comic = new ComicSite(title, author, url);
                comic.setStrip(strip);
                allComics.addFirst(comic);
                it = allComics.listIterator();
            }
        } catch (FileNotFoundException e) {
            throw e;
        }
    }

    /**
     * Saves the current list of ComicSites to the data file specified by
     * DATA_FILE.
     *
     * WARNING: Calling this method clears the list of comics in order to save
     * the new list!
     *
     * @param newComics List of currently loaded/displayed ComicSites and ComicStrips.
     */
    public void saveDatabase(LinkedList<ComicSite> newComics) {
        allComics = newComics;
        this.saveDatabase();
    }

    /**
     * Saves the current list of ComicSites to the data file specified by
     * DATA_FILE.
     */
    private void saveDatabase() {
        try {
            FileWriter dataFile = new FileWriter(DATA_FILE);
            Date currentDate = DateUtils.getCurrentDate();
            // The date is saved in format:
            // dow mon dd hh:mm:ss zzz yyyy
            // For more information, see the Date class.
            dataFile.write(currentDate.toString() + "\n");
            for (ComicSite comic : allComics) {
                ComicStrip strip = comic.getStrip();
                dataFile.write("Comic Name: " + comic.getTitle() + "\n");
                dataFile.write("Comic Author: " + comic.getAuthor() + "\n");
                String pathline = "Image Path: " + strip.getFilepath();
                dataFile.write(pathline + "\n");
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
     * @return A LinkedList of ComicSites, each of which has the proper image loaded.
     */
    public LinkedList<ComicSite> getAllComics() {
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
        ComicSite cs;
        if (it.hasNext()) { // We need to know what the current comic is
            it.next(); // so that we can still iterate from its position
            cs = it.previous();
        } else if (it.hasPrevious()) {
            it.previous();
            cs = it.next();
        } else { // List is empty, so don't bother re-sorting
            return;
        }
        Collections.sort(allComics); // Yes, this is an "unchecked or unsafe operation"
        int pos = Collections.binarySearch(allComics, cs);
        it = (pos < 0) ? allComics.listIterator() : allComics.listIterator(pos);
    }

    /**
     * Returns the next image for display. Circles to the first if the current image
     * is the last in the list.
     *
     * @return An Image of the next strip in the list, circling to the first if necessary.
     */
    public Image getNextImage() {
        if (it.hasNext()) {
            return it.next().getStrip().getComicStripImage();
        } else {
            it = allComics.listIterator();
            return it.next().getStrip().getComicStripImage();
        }
    }

    /**
     * Returns the previous image for display. Circles to the last if the current image
     * is the first in the list.
     *
     * @return An Image of the next strip in the list, circling to the first if necessary.
     */
    public Image getPreviousImage() {
        if (it.hasPrevious()) {
            return it.previous().getStrip().getComicStripImage();
        } else {
            it = allComics.listIterator(allComics.size());
            return it.previous().getStrip().getComicStripImage();
        }
    }
}
