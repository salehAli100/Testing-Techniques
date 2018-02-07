
package testingTechniques;

import java.io.File;
import java.io.FileNotFoundException;

public class AnotherWayDemo {
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		File file = new File("TestCases_2.txt");

		AnotherWay another = new AnotherWay();
		another.read.readInput(file);

		another.select();
	}

}
