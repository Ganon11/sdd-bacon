/**
 * BACON (sdd.bacon@gmail.com)
 *
 * ComicPanel - Displays a single WebComic.
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

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComicPanel extends JPanel {
	private ComicSite theComic;
	private String infoString;
	
	/**
	 * Sets the ComicSite object, and builds the info string.
	 *
	 * @param site The Comic Site object containing the image and information
	 *     to display.
	 */
	public ComicPanel(ComicSite site) {
		theComic = site;
		infoString = theComic.getTitle() + ", by " + theComic.getAuthor();
	}
	
	/**
	 * Overloads the JComponent's paint method.
	 *
	 * @param g The Graphics object used to display the image.
	 */
	public void paint(Graphics g) {
		g.drawImage(theComic.getStrip().getComicStripImage(), 0, 0, null);
	}
	
	/**
	 * Accessor method for the information string.
	 *
	 * @return The comic's title and author in an easily readable format
	 *     (as a String)
	 */
	public String getInfoString() {
		return infoString;
	}
}