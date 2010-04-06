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
import java.io.*;

import javax.imageio.ImageIO;
 
 public class ComicDatabase {
	private final DATA_FILE;
	private List<ComicSite> allComics;
	
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
	 */
	public void loadDatabase() {
		allComics.clear();
	}
	
	/**
	 * Saves the current list of ComicSites to the data file specified by
	 * DATA_FILE.
	 *
	 * WARNING: Calling this method clears the list of comics in order to load
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
 