/**
 * BACON (sdd.bacon@gmail.com)
 *
 * ImageGrabber - This class provides an easy way to take a url of an image,
 * download it, and then save it to the appropriate directory.
 *
 * Copyright (c) 2010
 * @author David Pizzuto, Seamus Reynolds, Matt Schoen, Michael Stark
 * All Rights Reserved
 *
 * http://code.google.com/p/bacon/
 *
 * @version 0.1, 04/02/10
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
 
import java.net.URL;
import java.net.URLConnection;
import java.io.File;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

public class ImageGrabber {
	
	public static String getImage(URL url, String directory) {
		BufferedInputStream is = null;
		BufferedOutputStream os = null;
		
		if(new File(directory).isDirectory()) {
			File uri = new File(url.toString());
			String filename = directory + uri.getName();
//			System.out.println(filename);
//			File file = new File(filename);
			try {
				URLConnection urlc = url.openConnection();
				is = new BufferedInputStream( urlc.getInputStream() );
				os = new BufferedOutputStream( new FileOutputStream(filename) );
			
				int i;
				while( (i = is.read()) != -1) {
					os.write( i );
				}
			}
			catch(IOException e) {
				System.out.println("Bad craziness!");
				e.printStackTrace();
				return null;
			}
			/** catch(java.io.FileNotFoundException fe) {
				System.out.println("Couldn't open directory.");
				System.out.println(fe);
			} */
			finally {
				if( is != null ) {
					try {
						is.close();
					}
					catch (IOException ioe) {
						System.out.println("Could not close!");
						ioe.printStackTrace();
						return null;
					}
				}
			}
			return filename;		
		}
		else {
			System.out.println("Not a proper directory name.");
			return null;
		}
	}
}		
		
		

