/**
 * BACON (sdd.bacon@gmail.com)
 *
 * BaconSystem - The backend structure of the BACON Project.
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

import java.io.IOException;
//import java.io.InputStream;
import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.util.*;

import javax.swing.text.AttributeSet;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;

public class BaconSystem {
    
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
     * @return      a HashMap of HTML tag types to lists of their use
     */
    public static ArrayList<String> getImageURLs(String url) {
        HashMap<HTML.Tag, ArrayList<AttributeSet>> tagMap = getTagMap(url);
        if(tagMap == null) return null;
        
        ArrayList<AttributeSet> imgs = tagMap.get(HTML.Tag.IMG);
        if(imgs == null) return new ArrayList<String>();
        
        ArrayList<String> urls = new ArrayList<String>(imgs.size());
        for(AttributeSet s: imgs) {
            urls.add(s.getAttribute(HTML.Attribute.SRC).toString());
        }
        
        return urls;
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
         * 
         */
        private TagMapper(HashMap<HTML.Tag, ArrayList<AttributeSet>> tagMap) {
            this.tagMap = tagMap;
        }
        
         /**
         * 
         */
        public TagMapper(String urlPath)
        {
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
            } catch(IOException e) {
                System.err.println("IO Exception Thrown: " + e);
            }
        }
        
         /**
         * 
         */
        private void mapTag(HTML.Tag t, AttributeSet a) {
            ArrayList<AttributeSet> list = tagMap.get(t);
            if(list == null) {
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
         * 
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
                InputStreamReader r = new InputStreamReader(url.openStream(), "ISO-8859-1");
                TagMapper tm = new TagMapper(new HashMap<HTML.Tag, ArrayList<AttributeSet>>());
                parser.parse(r, tm, true);
                return tm;
            } catch(IOException e) {
                System.err.println("IO Exception Thrown: " + e);
            }
            return null;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
