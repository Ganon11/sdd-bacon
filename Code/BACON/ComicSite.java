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

public class ComicSite implements Comparable<ComicSite> {
    private ComicStrip currentStrip;    // The current Comic Image.
    private String comicName;   // The name of the Web Comic.
    private String comicAuthor; // The author of the Web Comic.
    private String comicUrl; //The URL of the comic site.
    private int comicIndex; //The index of the actual comic image on the site
    public static SortMethod sortMethod; // How the comics should be sorted

    /**
     * Constructs a ComicSite object with the correct name, author, and URL.
     *
     * @param name  The Webcomic Name, such as "Ctrl-Alt-Del"
     * @param author    The Webcomic Author's name.
     * @param url   The Webcomic's site URL, such as "http://www.cad-comic.com"
     */
    public ComicSite(String name, String author, String url, int index) {
        comicName = name;
        comicAuthor = author;
        comicUrl = url;
        comicIndex = index;
    }

    /**
     * Constructs a ComicSite object with the correct name and URL.
     *
     * @param name  The Webcomic Name, such as "Ctrl-Alt-Del"
     * @param url   The Webcomic's site URL, such as "http://www.cad-comic.com"
     */
    public ComicSite(String name, String url, int index) {
        comicName = name;
        comicUrl = url;
        comicAuthor = "";
    }

    /**
     * Updates the ComicSite's current strip.
     *
     * @param newStrip The new ComicStrip object.
     */
    public void setStrip(ComicStrip newStrip) {
        currentStrip = newStrip;
    }

    /**
     * Accessor method for the ComicStrip object.
     *
     * @return The current ComicStrip object.
     */
    public ComicStrip getStrip() {
        return currentStrip;
    }

    /**
     * Accessor method for the Author's name.
     *
     * @return The author's name as a String.
     */
    public String getAuthor() {
        return comicAuthor;
    }

    /**
     * Accessor method for the Webcomic's URL.
     *
     * @return The URL as a String.
     */
    public String getUrl() {
        return comicUrl;
    }

    /**
     * Accessor method for the comic's title.
     *
     * @return The Webcomic's title as a String.
     */
    public String getTitle() {
        return comicName;
    }

    /**
     * Comparator. Uses whatever type is held in sortType to sort.
     */
    public int compareTo(ComicSite cs) {
        if (sortMethod == SortMethod.SORT_BY_ALPHABETICAL) {
            return this.comicAuthor.compareTo(cs.comicAuthor);
        } else if (sortMethod == SortMethod.SORT_BY_DATE) {
            // We don't really have enough of a date infrastructure yet to write this
            return 0;
        } else {
            // Throw an exception?
            return 0;
        }
    }

    public boolean equals(Object o) {
        ComicSite cs = (ComicSite) o;
        return this.comicAuthor.equals(cs.getAuthor())
            && this.comicUrl.equals(cs.getUrl())
            && this.comicName.equals(cs.getTitle());
    }
}
