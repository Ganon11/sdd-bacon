/**
 * BACON (sdd.bacon@gmail.com)
 *
 * ComicDatabaseTest - Tests for the ComicDatabase class
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

import BACON.ComicDatabase;
import org.junit.*;
import static org.junit.Assert.*;
import java.io.FileNotFoundException;

public class ComicDatabaseTest {

    /**
     * Tests whether an exception is thrown if the file cannot be found.
     */
    @Test(expected=FileNotFoundException.class)
    public void test_LoadDatabaseThrowsFileNotFound() throws FileNotFoundException {
        ComicDatabase db = new ComicDatabase("NOT A FILE");
        db.loadDatabase();
    }

    /**
     * Tests whether loadDatabase reads from a file properly.
     */
    @Test
    public void test_LoadDatabaseReadsProperly() {

    }
}
