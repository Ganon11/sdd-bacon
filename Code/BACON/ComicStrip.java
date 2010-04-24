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
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.Icon;

public class ComicStrip {
    private Icon comicStripImage;      // The actual Image of the comic strip.
    private String filePath;

    /**
     * Constructs the ComicStirp object with null values.
     */
    public ComicStrip() {
        filePath = null;
        comicStripImage = null;
    }

    /**
     * Sets the filepath, but does not load the image.
     *
     * @param fileName the full path to an image file.
     */
    public ComicStrip(String fileName) {
        filePath = fileName;
        comicStripImage = null;
    }

    /**
     * Loads the image specified by fileName into comicStripImage.
     *
     * @param fileName the full path to an image file.
     */
    public void loadImage(String fileName) {
        filePath = fileName;
        this.loadImage();
    }

    /**
     * Loads the image file into comicStripImage.
     */
     public void loadImage() {
         System.out.println("FISH");
         comicStripImage = new ImageIcon(filePath);
         System.out.println("SANDWICH");
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
}
