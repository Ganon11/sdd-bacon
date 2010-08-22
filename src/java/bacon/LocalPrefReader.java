/**
 * BACON (sdd.bacon@gmail.com)
 *
 * LocalPrefReader - Reads a Local preference file into a Map structure.
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

package bacon;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

 public class LocalPrefReader {
    public static String PREF_FILENAME = ".localpref.dat";
    private Map<String, String> preferences;

    /**
     * Creates a new Local Preference Reader.  Starts with a blank set of
     * preferences, but loads the preference list immediately.
     */
    public LocalPrefReader() {
        preferences = new HashMap<String, String>();
    }

    /**
     * Loads the preference information from PREF_FILENAME into the preferences
     * Map.
     */
    public void loadPreferences() {
        Scanner prefFile;
        try {
            prefFile = new Scanner(new FileReader(PREF_FILENAME));
            while (prefFile.hasNextLine()) {
                String line = prefFile.nextLine();
                // Each line consists of KEY_NAME = VALUE, so splitting on " "
                // will make elements[0] the key, elements[1] the "=", and
                // elements[2] the value.
                String[] elements = line.split(" ");
                preferences.put(elements[0], elements[2]);
            }
            prefFile.close();
            ComicSite.sortMethod = SortMethod.getSortMethod(preferences.get("SortStyle"));
        } catch (java.io.FileNotFoundException e) {
            // Toss this up for GUI error display?
        } catch (NullPointerException e) {
            ComicSite.sortMethod = SortMethod.SORT_BY_ALPHABETICAL;
        }
    }

    /**
     * Saves the current map of preferences to PREF_FILENAME.
     */
    public void savePreferences() {
        FileWriter prefFile;
        try {
            prefFile = new FileWriter(PREF_FILENAME);
            Set<String> allKeys = preferences.keySet();
            for (String k : allKeys) {
                String v = preferences.get(k);
                prefFile.write(k + " = " + v + "\n");
            }
            prefFile.close();
        } catch (IOException e) {
            // Handle the exception here - probably throw it to a higher class
            // to display a popup message or something.
        }
    }

    /**
     * Returns the preference value corresponding to the given key.  If the
     * preference is not in the map, returns null.
     *
     * WARNING: CALLING CLASSES MUST HANDLE THE NULL CASE.
     *
     * @param key The preference name.
     * @return The corresponding preference value, or null.
     */
    public String getPreference(String key) {
        if (preferences.containsKey(key)) {
            return preferences.get(key);
        } else {
            return null;
        }
    }

    /**
     * Sets the given preference name to the given preference value.
     *
     * @param key The preference name.
     * @param value The desired value for key.
     */
    public void setPreference(String key, String value) {
        preferences.put(key, value);
    }
 }
