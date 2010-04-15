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

package test;

import BACON.LocalPrefReader;
import org.junit.*;
import static org.junit.Assert.*;

public class LocalPrefReaderTest {

    /**
     * Tests whether getPreference returns null when the preference is not present.
     */
    @Test
    public void test_getPreferenceWithPreferenceNotPresent() {
        LocalPrefReader lpr = new LocalPrefReader();
        String pref = lpr.getPreference("not present");
        assertSame(pref, null);
    }

    /**
     * Tests whether getPreference returns the correct value when present.
     */
    @Test
    public void test_getPreferenceWithPreferencePresent() {
        LocalPrefReader.PREF_FILENAME = "test" +  java.io.File.separator + "fakelocalpref.txt";
        LocalPrefReader lpr = new LocalPrefReader();
        String pref = lpr.getPreference("SortStyle");
        assertEquals(pref, "A_TO_Z_ALPHABETICAL");
    }

    /**
     * Tests whether savePreferences saves the data to a file in a fashion loadable
     * by loadPreferences with the same data.
     */
    @Test
    public void test_loadSavePreferences() {
        LocalPrefReader.PREF_FILENAME = "test" +  java.io.File.separator + "fakelocalpref.txt";
        LocalPrefReader lpr = new LocalPrefReader();
        LocalPrefReader.PREF_FILENAME = "test" + java.io.File.separator + "fakelocalpref2.txt";
        lpr.savePreferences();
        LocalPrefReader lpr2 = new LocalPrefReader();
        assertEquals(lpr.getPreference("SortStyle"), lpr2.getPreference("SortStyle"));
    }
}
