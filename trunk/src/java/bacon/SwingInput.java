/**
 * BACON (sdd.bacon@gmail.com)
 *
 * SwingInput - Gets GUI input from the user.
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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class SwingInput {
    /**
     * Gets string data using a JOptionPane.
     * @param message The prompt to be displayed
     * @return The text inputted.
     */
    public static String getString(String message) {
        String input = JOptionPane.showInputDialog(message);
        while (input.length() == 0) {
            input = JOptionPane.showInputDialog(message);
        }
        return input;
    }

    /**
     * Displays the given error message to the user.
     * @param msg The message to be displayed
     */
    public static void displayErrorMessage(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Allows the user to choose a directory to save files.
     * @param msg A message to inform the user why they have to input this.
     * @return A String either with the chosen file or the empty string if no cirectory was chosen.
     */
    public static String chooseDirectory(String msg) {
        JOptionPane.showMessageDialog(null, msg);
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int retval = fc.showOpenDialog(null);
        if (retval == JFileChooser.APPROVE_OPTION) {
            return fc.getCurrentDirectory() + File.separator + fc.getSelectedFile().getName();
        } else {
            return "";
        }
    }
}
