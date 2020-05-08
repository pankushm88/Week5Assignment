/**
 * 
 */
package src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Pankush
 *
 */
public class DisplayAllFiles {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		Files.walk(Paths.get("."), 5).forEach(System.out::println);
	}

}
