/**
 * BACON (sdd.bacon@gmail.com)
 *
 * ComicSite - Provides an abstraction for a Webcomic.
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
 
public class ComicSite {
	private ComicStrip 	currentStrip;	// The current Comic Image.
	private String comicName;	// The name of the Web Comic.
	private String comicAuthor;	// The author of the Web Comic.
	
	/**
	 * Constructs a ComicSite object with the correct name/author.
	 *
	 * @param name	The Webcomic Name, such as "Ctrl-Alt-Del"
	 * @param author	The Webcomic Author's name.
	 */
	public ComicSite(String name, String author) {
		comicName = name;
		comicAuthor = author;
	}
}