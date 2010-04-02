/**
 * BACON (sdd.bacon@gmail.com)
 *
 * ComicStrip - This class provides an abstraction for a displayable Comic
 * Strip Image.
 *
 * Copyright (c) 2010
 * @author David Pizzuto, Seamus Reynolds, Matt Schoen, Michael Stark
 * All Rights Reserved
 *
 * http://code.google.com/p/bacon/
 *
 * @version 0.1, 04/02/10
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

import javax.imageio.ImageIO;

import java.io.*;

public class ComicStrip {
	private Image comicStripImage;		// The actual Image of the comic strip.
	
	/**
	 * Sets the comicStripImage object to null.
	 */
	public ComicStrip() {
		comicStripImage = null;
	}
	
	/**
	 * Loads the image specified by fileName into comicStripImage.
	 *
	 * @param fileName the full path to an image file.
	 */
	public ComicStrip(String fileName) {
		comicStripImage = null;
		try {
			comicStripImage = ImageIO.read(new File(fileName));
		} catch (IOException e) {
			// Here, we should handle the exception - maybe display an error
			// message like "Could not load file fileName".
		}
	}
	
	/**
	 * Loads the image specified by fileName into comicStripImage.
	 *
	 * @param fileName the full path to an image file.
	 */
	public void loadImage(String fileName) {
		comicStripImage = null;
		try {
			comicStripImage = ImageIO.read(new File(fileName));
		} catch (IOException e) {
			// Here, we should handle the exception - maybe display an error
			// message like "Could not load file fileName".
		}
	}
	
	/**
	 * Returns the comic strip image as an Image object.
	 *
	 * @return 	the Comic Strip Image.
	 * @see 	Image
	 */
	public Image getComicStripImage() {
		return comicStripImage;
	}
}
