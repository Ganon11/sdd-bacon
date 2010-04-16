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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

 public class ComicDatabase {
    private final String DATA_FILE;
    private List<ComicSite> allComics;
    private Date dateLoaded;

    /**
     * Creates the ComicDatabase with the data file stored in the specified
     * location.
     */
    public ComicDatabase(String dataFileName) {
        DATA_FILE = dataFileName;
        allComics = new ArrayList<ComicSite>();
    }

    /**
     * Creates the ComicDatabase with the data file stored in the default
     * location.
     */
    public ComicDatabase() {
        DATA_FILE = ".datafile.dat";
    }

    /**
     * Loads the file specified by DATA_FILE, and reads in the list of
     * ComicSites and ComicStrips.
     *
     * WARNING: Calling this method clears the list of comics in order to load
     * the new list!
     *
     * @throws FileNotFoundException If the database file does not exist.
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
                // The Data File consists of the Comic Title, Author, and Image
                // File Path on seperate lines.  Each set of information is, in
                // turn, seperated by a blank line.
                ComicSite comic;
                ComicStrip strip;
                String titleLine = dataFile.nextLine();
                String authorLine = dataFile.nextLine();
                String fileLine = dataFile.nextLine();
                // If this was the last entry, there may not be a blank line
                // following it.
                if (dataFile.hasNextLine()) {
                    dataFile.nextLine();
                }

                String title = titleLine.substring(12);
                String author = authorLine.substring(14);
                String filePath = fileLine.substring(12);
                strip = new ComicStrip(filePath);
                comic = new ComicSite(title, author);
                comic.setStrip(strip);
                allComics.add(comic);
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(); // Should be caught by GUI
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
    public void saveDatabase(List<ComicSite> newComics) {
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
     * @return A list of ComicSites, each of which has the proper image loaded.
     */
    public List<ComicSite> getAllComics() {
        return allComics;
    }
 }

