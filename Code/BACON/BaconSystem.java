/**
 * BACON (sdd.bacon@gmail.com)
 *
 * BaconSystem - The backend structure of the BACON Project. Also the main class for
 * the project.
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

import BACON.MainFrame;
import BACON.SwingInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
import java.io.Writer;
//import java.net.URI;
import java.net.URL;
import java.util.*;

import javax.swing.text.AttributeSet;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;

public class BaconSystem {
    public static final String ABOUT_TEXT =
        "This program is licensed under the GNU General Public License v3\n" +
        "and is \u00A9 2010 The Circuit Breakers. The terms of the license may be\n" +
        "found at <http://www.gnu.org/licenses>. You may also view the text\n" +
        "locally by using your favorite ZIP/RAR editor to explore this JAR file\n" +
        "and read license.txt.";

    /**
     * main - Entry point for the application
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        boolean notFirstRun = new File(".localpref.dat").exists();
        ComicDatabase db;
        LocalPrefReader lpr;
        if (!notFirstRun) {
            // prompt for location to save comic database and images
            boolean location = false;
            String locDb = "", locImages = "";
            while (!location) {
                locDb = SwingInput.chooseDirectory("Please input the directory" +
                                                          " you would like to save the comic" +
                                                          " database in.");
                if (locDb.length() != 0) {
                    location = true;
                }
            }
            location = false;
            while (!location) {
                locImages = SwingInput.chooseDirectory("Please input the directory" +
                                                              " you would like to save the comic" +
                                                              " images in.");
                if (locImages.length() != 0) {
                    location = true;
                }
            }
            lpr = new LocalPrefReader();
            lpr.setPreference("DataBaseFolder", locDb);
            lpr.setPreference("SortStyle", "A_TO_Z_ALPHABETICAL");
            db = new ComicDatabase(locDb + File.separator + ".datafile.dat");
        } else {
            lpr = new LocalPrefReader();
            String fileLoc = lpr.getPreference("DataBaseFolder");
            if (fileLoc == null) {
                // We has a problem. Better get that file again.
                String locDb = "";
                boolean location = false;
                while (!location) {
                    locDb = SwingInput.chooseDirectory("Please input the directory" +
                                                              " you would like to save the comic" +
                                                              " database in.");
                    if (locDb.length() != 0) {
                        location = true;
                    }
                }
                fileLoc = locDb;
                lpr.setPreference("DataBaseFolder", locDb);
            }
            db = new ComicDatabase(fileLoc + File.separator + ".datafile.dat");
            try {
                db.loadDatabase();
            } catch (FileNotFoundException e) {
                SwingInput.displayErrorMessage(fileLoc + File.separator +
                                               ".datafile.dat could not be found: "
                                               + e.getMessage());
            }
        }
        new MainFrame(db, lpr).setVisible(true);
    }

    /**
     * Reads a webpage and returns a map of all the HTML elements.
     *
     * @param  url  the URL of the webpage to read
     * @return      a HashMap of HTML tag types to lists of their use
     */
    public static HashMap<HTML.Tag, ArrayList<AttributeSet>> getTagMap(String url) {
        TagMapper tm = TagMapper.parse(url);
        return tm != null ? tm.getTagMap() : null;
    }

    /**
     * Reads a webpage and returns a list of all the image links found.
     *
     * @param  url  the URL of the webpage to read
     * @return      an array of all image URLs gathered from the page
     */
    public static URL[] getImageUrls(String url) {
        TagMapper tm = TagMapper.parse(url);
        if (tm == null) return null;

        ArrayList<AttributeSet> imgs = tm.getTagMap().get(HTML.Tag.IMG);
        if (imgs == null) return new URL[0];


        URL base;
        try {
            base = new URL(url);
        } catch(java.net.MalformedURLException e) { //java.net.URISyntaxException e) {
            //I'm pretty sure this is impossible at this point,
            //since the mapper made the URL successfully...
            return null;
        }

        URL[] urls = new URL[imgs.size()];
        for(int i = 0; i < urls.length; ++i) {
            try {
                urls[i] = new URL(base, imgs.get(i).getAttribute(HTML.Attribute.SRC).toString());
            } catch(java.net.MalformedURLException e) {
                //Bad image URL, keep a null placeholder
            }
        }

        return urls;
    }

    /**
     * Reads a webpage and returns the nth image link on the page.
     *
     * @param  url  the URL of the webpage to read
     * @param  n    the index of the image to retrieve
     * @return      the URL of the nth image on the page, or null if it cannot be retrieved
     */
    public static URL getImageN(String url, int n) {
        if (n < 0) return null; //BAD USER!
        TagMapper tm = TagMapper.parse(url);
        if (tm == null) return null;

        ArrayList<AttributeSet> imgs = tm.getTagMap().get(HTML.Tag.IMG);
        if (imgs == null || n >= imgs.size()) return null;

        try {
            return new URL(new URL(url), imgs.get(n).getAttribute(HTML.Attribute.SRC).toString());
        } catch(java.net.MalformedURLException e) { //java.net.URISyntaxException e) {
            //The URL on the page failed to resolve with the base URL...
        }
        return null;
    }

    /**
     * A wrapper class around the HTMLEditorKit used to make the getParser method public.
     */
    private static class ParserGetter extends HTMLEditorKit {
        /**
         *
         */
        public HTMLEditorKit.Parser getParser() {
            return super.getParser();
        }
    }

    private static class TagMapper extends HTMLEditorKit.ParserCallback {
        private HashMap<HTML.Tag, ArrayList<AttributeSet>> tagMap; //The HTML tag map being created

         /**
         * This constructor is private to being called by this class's methods.
         */
        private TagMapper(HashMap<HTML.Tag, ArrayList<AttributeSet>> tagMap) {
            this.tagMap = tagMap;
        }

         /**
         * @param urlPath The path to the URL to be parsed
         */
        public TagMapper(String urlPath) {
            HTMLEditorKit.Parser parser = new ParserGetter().getParser();
            URL url;
            try {
                url = new URL(urlPath);
            } catch(java.net.MalformedURLException e) {
                System.err.println("URL Exception Thrown: " + e);
                return;
            }

            try {
                InputStreamReader r = new InputStreamReader(url.openStream(), "ISO-8859-1");
                tagMap = new HashMap<HTML.Tag, ArrayList<AttributeSet>>();
                parser.parse(r, this, true);
            } catch(Exception e) {
                System.err.format("Could not read URL \"%s\":\n\t%s\n", url, e);
            }
        }

         /**
         *
         */
        private void mapTag(HTML.Tag t, AttributeSet a) {
            ArrayList<AttributeSet> list = tagMap.get(t);
            if (list == null) {
                list = new ArrayList<AttributeSet>();
                tagMap.put(t, list);
            }
            list.add(a.copyAttributes());
        }

         /**
         *
         */
        public void handleSimpleTag(HTML.Tag t, MutableAttributeSet a, int pos) {
            mapTag(t, a);
        }

         /**
         * @return The map of tags
         */
        public HashMap<HTML.Tag, ArrayList<AttributeSet>> getTagMap() {
            return tagMap;
        }

         /**
         *
         */
        public static TagMapper parse(String urlPath) {
            HTMLEditorKit.Parser parser = new ParserGetter().getParser();
            URL url;
            try {
                url = new URL(urlPath);
            } catch(java.net.MalformedURLException e) {
                System.err.println("URL Exception Thrown: " + e);
                return null;
            }

            try {
                InputStream s = url.openStream();
                InputStreamReader r = new InputStreamReader(s, "ISO-8859-1");
                TagMapper tm = new TagMapper(new HashMap<HTML.Tag, ArrayList<AttributeSet>>());
                parser.parse(r, tm, true);
                return tm;
            } catch(Exception e) {
                System.err.format("Could not read URL \"%s\":\n\t%s\n", url, e);
            }
            return null;
        }
    }

}
