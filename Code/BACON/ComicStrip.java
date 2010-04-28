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
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.Icon;

public class ComicStrip {
    private Icon comicStripImage;      // The actual Image of the comic strip.
    private String filePath;
    private boolean isUrl;             //true if filePath is actually a url

    /**
     * Constructs the ComicStirp object with null values.
     */
    public ComicStrip() {
        filePath = null;
        comicStripImage = null;
        isUrl = false;
    }

    /**
     * Sets the filepath, but does not load the image.
     *
     * @param fileName the full path to an image file.
     */
    public ComicStrip(String fileName) {
        filePath = fileName;
        comicStripImage = null;
        isUrl = false;
    }
    
    /**
     * Sets the filepath to an image URL, but does not load the image.
     *
     * @param url the URL to an image file.
     */
    public ComicStrip(URL url) {
        filePath = url.toString();
        comicStripImage = null;
        isUrl = true;
    }
    
    /**
    * Saves the image to the directory given to the method.
    *
    * @param dest The path to the directory where images for that particular comic are stored.
    * @return Returns true if successfully added, false if not.
    */
    public boolean saveImage(String dest) {
    	if(!(isUrl)) {
    		return false;
    	}
    	else {
    		try { 
    		filePath = ImageGrabber.getImage(new URL(filePath), dest);
    		} catch (java.net.MalformedURLException e) {
    			System.err.println("URL not properly formatted:" + filePath);
    		}
    		if(filePath != null) return true;
    		else return false;
    	}
    }

    /**
     * Loads the image specified by fileName into comicStripImage.
     *
     * @param fileName the full path to an image file.
     */
    public void loadImage(String fileName) {
        filePath = fileName;
        isUrl = false;
        this.loadImage();
    }
    
    /**
     * Loads the image specified by url into comicStripImage.
     *
     * @param url the URL to an image file.
     */
    public void loadImage(URL url) {
        filePath = url.toString();
        isUrl = true;
        this.loadImage();
    }

    /**
     * Loads the image file into comicStripImage.
     */
    public void loadImage() {
        //System.out.format("LOADING %s\n", filePath);
        if (!isUrl) {
            comicStripImage = new ImageIcon(filePath);
        } else {
            try {
                comicStripImage = new ImageIcon(new URL(filePath));
            } catch(java.net.MalformedURLException e) {
                //URL isn't valid...
                System.err.format("ComicStrip path %s is not a valid URL\n", filePath);
                comicStripImage = new ImageIcon(filePath);
            }
        }
     }

    /**
     * Returns the comic strip image as an Image object.
     *
     * @return  the Comic Strip Image.
     * @see     Image
     */
    public Icon getComicStripImage() {
        return comicStripImage;
    }

    /**
     * Accessor method for the Image file path.
     *
     * @return The path to the image file as a String.
     */
    public String getFilePath() {
        return filePath;
    }
    
    /**
     * Returns true if the image was specified by a URL rather than a path from the filesystem.
     *
     * @return true if the strip's image was specified by URL.
     */
    public boolean isOnline() {
        return isUrl;
    }
}
