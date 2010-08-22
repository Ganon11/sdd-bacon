/**
 * BACON (sdd.bacon@gmail.com)
 *
 * LocalPrefReaderTest - Tests for the LocalPrefReader class.
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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import junit.framework.TestCase;

public class LocalPrefReaderTest extends TestCase {
	private String FAKE_PREF_FILE = "fakelocalpref.txt";
	private LocalPrefReader lpr;
	
	public void setUp() throws IOException {
		LocalPrefReader.PREF_FILENAME = FAKE_PREF_FILE;
		FileWriter file = new FileWriter(FAKE_PREF_FILE);
		file.write("SortStyle = A_TO_Z_ALPHABETICAL\n" +
				   "DataBaseFolder = C:\\Users\\starkm3\\workspace\\bacon\n");
		file.close();
	}
	
	public void tearDown() {
		File file = new File(FAKE_PREF_FILE);
		file.delete();
	}

    /**
     * Tests whether getPreference returns null when the preference is not present.
     */
    public void test_getPreferenceWithPreferenceNotPresent() {
    	lpr = new LocalPrefReader();
        String pref = lpr.getPreference("not present");
        assertNull(pref);
    }

    /**
     * Tests whether getPreference returns the correct value when present.
     */
    public void test_getPreferenceWithPreferencePresent() {
    	lpr = new LocalPrefReader();
        lpr.loadPreferences();
        String pref = lpr.getPreference("SortStyle");
        assertEquals(pref, "A_TO_Z_ALPHABETICAL");
    }

    /**
     * Tests whether savePreferences saves the data to a file in a fashion loadable
     * by loadPreferences with the same data.
     */
    public void test_loadSavePreferences() {
        lpr = new LocalPrefReader();
        lpr.loadPreferences();
        LocalPrefReader.PREF_FILENAME = "fakelocalpref2.txt";
        lpr.savePreferences();
        LocalPrefReader lpr2 = new LocalPrefReader();
        lpr2.loadPreferences();
        assertEquals(lpr.getPreference("SortStyle"), lpr2.getPreference("SortStyle"));
        File fakeFile = new File("fakelocalpref2.txt");
        fakeFile.delete();
    }
}
