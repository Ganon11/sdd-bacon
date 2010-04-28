/**
 * BACON (sdd.bacon@gmail.com)
 *
 * BrowserLaunch - This class displays the URL for the currently displayed webcomic
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

 import java.awt.Desktop;
 import java.io.IOException;
 import java.net.URI;

 public class BrowserLaunch {
     public static void loadBrowser(String path) throws IOException {
        Desktop.getDesktop().browse(URI.create(path));
     }
 }