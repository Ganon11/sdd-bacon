/**
 * Modified from Dem Pilafian's Bare Bones Browser Launch v3.0, available in the public
 * domain at http://www.centerkey.com/java/browser/BareBonesBrowserLaunch.java.
 *
 * BACON (sdd.bacon@gmail.com)
 *
 * BrowserLaunch - Launches the user's preferred browser.
 *
 * Modifications copyright (c) 2010
 * @author David Pizzuto, Seamus Reynolds, Matt Schoen, Michael Stark
 * All Rights Reserved
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

import java.io.IOException;
import java.util.Arrays;

public class BrowserLaunch {

	/**
	 * Supported browsers.
	 */
    private static final String[] browsers = { "google-chrome", "firefox", "opera",
        "konqueror", "epiphany", "seamonkey", "galeon", "kazehakase", "mozilla" };

    /**
     * Opens a URL in the user's preferred browser if possible.
     * @param url The URL to be opened
     * @throws IOException If the browser has some sort of error. Other errors will be met with a JOptionPane.
     */
    public static void openUrl(String url) throws IOException {
        try {  // attempt to use Desktop library from JDK 1.6+ (even if on 1.5)
            Class<?> d = Class.forName("java.awt.Desktop");
            d.getDeclaredMethod("browse", new Class[] {java.net.URI.class}).invoke(
                d.getDeclaredMethod("getDesktop").invoke(null),
                    new Object[] {java.net.URI.create(url)});
            // above code mimics:
            //   java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
            // through the use of reflection
        } catch (ClassNotFoundException e) {  // library not available or failed
            launchPreferredBrowser(url);
        } catch (Exception e) {
            SwingInput.displayErrorMessage(e.getMessage());
        }
    }

    /**
     * Hunts down and launches the user's preferred browser by combing through the OS.
     * @param url The URL to be opened.
     */
    private static void launchPreferredBrowser(String url) {
        String osName = System.getProperty("os.name");
        try {
            if (osName.startsWith("Mac OS")) {
            Class.forName("com.apple.eio.FileManager").getDeclaredMethod(
                "openURL", new Class[] {String.class}).invoke(null,
                new Object[] {url});
            } else if (osName.startsWith("Windows")) {
               Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
            } else { // assume Unix or Linux
                boolean found = false;
                for (String browser : browsers) {
                    if (!found) {
                        found = Runtime.getRuntime().exec(
                            new String[] {"which", browser}).waitFor() == 0;
                        if (found) {
                            Runtime.getRuntime().exec(new String[] {browser, url});
                        }
                    }
                }
                if (!found) {
                    throw new Exception(Arrays.toString(browsers));
                }
            }
        } catch (Exception e) {
            SwingInput.displayErrorMessage(e.getMessage());
        }
    }
}
